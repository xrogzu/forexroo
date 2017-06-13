package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.app.service.ApistoreService;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.MyBankCardStatusEnum;
import com.github.xuzw.forexroo.entity.tables.daos.MyBankCardDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.MyBankCard;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "绑定银行卡 - 第一步：提交银行卡信息（银行卡号和预留手机号）")
@GenerateByApiEngineSdk(time = "2017.06.13 11:51:27.981", version = "v0.0.38")
public class BindBankCard_SubmitBankCard_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        String bankCardNumber = req.getBankCardNumber();
        String reservedPhone = req.getReservedPhone();
        JSONObject jsonObject = ApistoreService.verifyBankCard(bankCardNumber, user.getOpenAccountRealname(), user.getOpenAccountIdentityCardNumber(), reservedPhone);
        if (jsonObject.getIntValue("error_code") != 0) {
            throw new ApiExecuteException(ErrorCodeEnum.bankCard_authentication_failed, jsonObject.getString("reason"));
        }
        JSONObject information = jsonObject.getJSONObject("result").getJSONObject("information");
        MyBankCardDao myBankCardDao = new MyBankCardDao(Jooq.buildConfiguration());
        MyBankCard myBankCard = new MyBankCard();
        myBankCard.setBankCardNumber(bankCardNumber);
        myBankCard.setReservedPhone(reservedPhone);
        myBankCard.setBankImage(information.getString("bankimage"));
        myBankCard.setBankName(information.getString("bankname"));
        myBankCard.setCardName(information.getString("cardname"));
        myBankCard.setCardType(information.getString("cardtype"));
        myBankCard.setServicePhone(information.getString("servicephone"));
        myBankCard.setApistoreRawResponse(jsonObject.toJSONString());
        myBankCard.setStatus(MyBankCardStatusEnum.binding.getValue());
        myBankCardDao.insert(myBankCard);
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

        @Comment(value = "银行卡号")
        @Required(value = true)
        private String bankCardNumber;

        public String getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(String bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
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
