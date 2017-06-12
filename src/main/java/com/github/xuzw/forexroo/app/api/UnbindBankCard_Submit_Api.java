package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.MY_BANK_CARD;
import static com.github.xuzw.forexroo.entity.Tables.USER;
import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.app.service.ApistoreService;
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

@Comment(value = "解绑银行卡 - 提交预留手机号和验证码")
@GenerateByApiEngineSdk(time = "2017.06.12 01:21:10.998", version = "v0.0.37")
public class UnbindBankCard_Submit_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String reservedPhone = req.getReservedPhone();
        if (!req.getVerificationCode().equals(SmsVerificationCodeCache.getIfPresent(reservedPhone, SmsTemplateEnum.unbind_bank_card.name()))) {
            throw new ApiExecuteException(ErrorCodeEnum.verification_code_error);
        }
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        Long userId = user.getId();
        MyBankCardDao myBankCardDao = new MyBankCardDao(Jooq.buildConfiguration());
        MyBankCard myBankCard = myBankCardDao.fetchOne(MY_BANK_CARD.USER_ID, userId);
        if (myBankCard.getStatus() != MyBankCardStatusEnum.binding_success.getValue()) {
            throw new ApiExecuteException(ErrorCodeEnum.status_error);
        }
        String bankCardNumber = myBankCard.getBankCardNumber();
        JSONObject jsonObject = ApistoreService.verifyBankCard(bankCardNumber, user.getOpenAccountRealname(), user.getOpenAccountIdentityCardNumber(), reservedPhone);
        if (jsonObject.getIntValue("error_code") != 0) {
            throw new ApiExecuteException(ErrorCodeEnum.bankCard_authentication_failed, jsonObject.getString("reason"));
        }
        myBankCardDao.deleteById(myBankCard.getId());
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

        @Comment(value = "预留手机号")
        @Required(value = true)
        private String reservedPhone;

        public String getReservedPhone() {
            return reservedPhone;
        }

        public void setReservedPhone(String reservedPhone) {
            this.reservedPhone = reservedPhone;
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
