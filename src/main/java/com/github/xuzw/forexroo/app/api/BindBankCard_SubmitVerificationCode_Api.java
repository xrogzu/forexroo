package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.MY_BANK_CARD;
import static com.github.xuzw.forexroo.entity.Tables.USER;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.app.service.MyBankCardService;
import com.github.xuzw.forexroo.app.utils.SmsTemplateEnum;
import com.github.xuzw.forexroo.app.utils.SmsVerificationCodeCache;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.MyBankCardStatusEnum;
import com.github.xuzw.forexroo.entity.tables.daos.MyBankCardDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.MyBankCard;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "绑定银行卡 - 第二步：提交验证码（发送给预留手机号）")
@GenerateByApiEngineSdk(time = "2017.06.12 12:45:53.969", version = "v0.0.36")
public class BindBankCard_SubmitVerificationCode_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String token = req.getToken();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, token);
        Long userId = user.getId();
        MyBankCardDao myBankCardDao = new MyBankCardDao(Jooq.buildConfiguration());
        MyBankCard myBankCard = myBankCardDao.fetchOne(MY_BANK_CARD.USER_ID, userId);
        if (myBankCard.getStatus() != MyBankCardStatusEnum.binding.getValue()) {
            throw new ApiExecuteException(ErrorCodeEnum.status_error);
        }
        if (!req.getVerificationCode().equals(SmsVerificationCodeCache.getIfPresent(myBankCard.getReservedPhone(), SmsTemplateEnum.binded_bank_card.name()))) {
            MyBankCardService.updateStatus(userId, MyBankCardStatusEnum.binding_fail);
            throw new ApiExecuteException(ErrorCodeEnum.verification_code_error);
        }
        MyBankCardService.updateStatus(userId, MyBankCardStatusEnum.binding_success);
        return new Response();
    }

    public static class Req extends Request {

        @Comment(value = "用户唯一标识码")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "验证码")
        @Required(value = true)
        private String verificationCode;

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }
    }
}
