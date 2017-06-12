package com.github.xuzw.forexroo.app.api;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.activemq.ActiveMq;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "入金 - 提交入金金额")
@GenerateByApiEngineSdk(time = "2017.06.09 02:55:53.314", version = "v0.0.35")
public class Deposit_SubmitAmount_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.TOKEN, req.getToken());
        JSONObject json = new JSONObject();
        json.put("login", Long.valueOf(user.getMt4RealAccount()));
        json.put("operationtype", 1);
        json.put("amount", Integer.valueOf(req.getAmount()));
        json.put("comment", System.currentTimeMillis());
        JSONObject depositResult = ActiveMq.sendRequestAndAwait("Deposit_User_Info_Topic", json);
        String orderId = depositResult.getString("orderid");
        boolean success = StringUtils.isNotBlank(orderId);
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "用户唯一标识码") @Required(value = true) private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "入金金额") @Required(value = true) private String amount;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
