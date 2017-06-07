package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.MyBankCardStatusEnum;
import com.github.xuzw.forexroo.entity.tables.daos.MyBankCardDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.MyBankCard;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;
import com.jcabi.http.request.JdkRequest;

@Comment(value = "绑定银行卡 - 第一步：提交银行卡信息（银行卡号和预留手机号）")
@GenerateByApiEngineSdk(time = "2017.06.07 11:16:34.780", version = "v0.0.31")
public class BindBankCard_SubmitBankCard_Api implements Api {

    public static final String url = "http://v.apistore.cn/api/bank/v4";

    public static final String key = "23ea02288ae1b784c17de701d77cda4c";

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        String bankCardNumber = req.getBankCardNumber();
        String reservedPhone = req.getReservedPhone();
        Map<String, String> params = new HashMap<>();
        params.put("key", key);
        params.put("bankcard", bankCardNumber);
        params.put("realName", user.getOpenAccountRealname());
        params.put("cardNo", user.getOpenAccountIdentityCardNumber());
        params.put("Mobile", reservedPhone);
        params.put("information", "1");
        String json = new JdkRequest(url).uri().queryParams(params).back().method(com.jcabi.http.Request.GET).fetch().body();
        JSONObject jsonObject = JSON.parseObject(json);
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
