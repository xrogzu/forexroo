package com.github.xuzw.forexroo.app.api;

import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.activemq_utils.ActiveMq;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.DepositAndWithdrawTypeEnum;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.DepositAndWithdrawDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.DepositAndWithdraw;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "入金 - 提交入金金额")
@GenerateByApiEngineSdk(time = "2017.06.15 03:28:54.235", version = "v1.0.4")
public class Deposit_SubmitAmount_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        DepositAndWithdrawTypeEnum type = DepositAndWithdrawTypeEnum.deposit;
        double amount = Double.valueOf(req.getAmount());
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.TOKEN, req.getToken());
        JSONObject mt4Request = new JSONObject();
        mt4Request.put("login", Integer.valueOf(user.getMt4RealAccount()));
        mt4Request.put("operationtype", type.getValue());
        mt4Request.put("amount", amount);
        DepositAndWithdraw entity = new DepositAndWithdraw();
        entity.setRawRequest(JSON.toJSONString(request));
        entity.setUserId(user.getId());
        entity.setType(type.getValue());
        entity.setAmount(String.valueOf(amount));
        entity.setMt4RawRequest(mt4Request.toJSONString());
        entity.setMt4RequestTime(System.currentTimeMillis());
        JSONObject mt4Response = ActiveMq.sendRequestAndAwait("Deposit_User_Info_Topic", mt4Request);
        entity.setMt4RawResponse(mt4Response.toJSONString());
        entity.setMt4ResponseTime(System.currentTimeMillis());
        String orderId = mt4Response.getString("orderid");
        entity.setOrderId(orderId);
        boolean success = StringUtils.isNotBlank(orderId);
        if (!success) {
            throw new ApiExecuteException(ErrorCodeEnum.mt4_middleware_error, mt4Response.getString("error"));
        }
        entity.setTime(System.currentTimeMillis());
        DepositAndWithdrawDao depositAndWithdrawDao = new DepositAndWithdrawDao(Jooq.buildConfiguration());
        depositAndWithdrawDao.insert(entity);
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

        @Comment(value = "入金金额")
        @Required(value = true)
        private String amount;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
