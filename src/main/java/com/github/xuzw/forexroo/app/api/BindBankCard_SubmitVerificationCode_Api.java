package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.MY_BANK_CARD;
import static com.github.xuzw.forexroo.entity.Tables.USER;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.jooq.Field;
import org.jooq.impl.DSL;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
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
@GenerateByApiEngineSdk(time = "2017.06.07 11:16:34.790", version = "v0.0.31")
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
        if (!req.getVerificationCode().equals(SmsVerificationCodeCache.getIfPresent(myBankCard.getReservedPhone(), SmsTemplateEnum.binded_bank_card.name()))) {
            updateStatus(userId, MyBankCardStatusEnum.binding_fail);
            throw new ApiExecuteException(ErrorCodeEnum.verification_code_error);
        }
        updateStatus(userId, MyBankCardStatusEnum.binding_success);
        return new Response();
    }

    private static void updateStatus(Long userId, MyBankCardStatusEnum myBankCardStatusEnum) throws SQLException {
        Map<Field<?>, Object> map = new HashMap<>();
        map.put(MY_BANK_CARD.STATUS, myBankCardStatusEnum.getValue());
        DSL.using(Jooq.buildConfiguration()).update(MY_BANK_CARD).set(map).where(MY_BANK_CARD.USER_ID.equal(userId)).execute();
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
