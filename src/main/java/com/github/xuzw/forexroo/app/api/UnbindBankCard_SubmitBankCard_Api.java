package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.MY_BANK_CARD;
import static com.github.xuzw.forexroo.entity.Tables.USER;
import java.util.HashMap;
import java.util.Map;
import org.jooq.Field;
import org.jooq.impl.DSL;
import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.app.service.MyBankCardService;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.MyBankCardStatusEnum;
import com.github.xuzw.forexroo.entity.tables.daos.MyBankCardDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.MyBankCard;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "解绑银行卡 - 第一步：提交预留手机号")
@GenerateByApiEngineSdk(time = "2017.06.07 12:01:47.585", version = "v0.0.32")
public class UnbindBankCard_SubmitBankCard_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        Long userId = user.getId();
        MyBankCardDao myBankCardDao = new MyBankCardDao(Jooq.buildConfiguration());
        MyBankCard myBankCard = myBankCardDao.fetchOne(MY_BANK_CARD.USER_ID, userId);
        if (myBankCard.getStatus() != MyBankCardStatusEnum.binding_success.getValue()) {
            throw new ApiExecuteException(ErrorCodeEnum.status_error);
        }
        String bankCardNumber = myBankCard.getBankCardNumber();
        String reservedPhone = req.getReservedPhone();
        JSONObject jsonObject = MyBankCardService.verifyBankCard(bankCardNumber, user.getOpenAccountRealname(), user.getOpenAccountIdentityCardNumber(), reservedPhone);
        if (jsonObject.getIntValue("error_code") != 0) {
            throw new ApiExecuteException(ErrorCodeEnum.bankCard_authentication_failed, jsonObject.getString("reason"));
        }
        Map<Field<?>, Object> map = new HashMap<>();
        map.put(MY_BANK_CARD.RESERVED_PHONE, reservedPhone);
        map.put(MY_BANK_CARD.STATUS, MyBankCardStatusEnum.unbinding.getValue());
        DSL.using(Jooq.buildConfiguration()).update(MY_BANK_CARD).set(map).where(MY_BANK_CARD.USER_ID.equal(userId)).execute();
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
    }
}
