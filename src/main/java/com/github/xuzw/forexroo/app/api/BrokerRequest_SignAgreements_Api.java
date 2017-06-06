package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jooq.Field;
import org.jooq.impl.DSL;

import com.alibaba.fastjson.JSON;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.BrokerRequestStatusEnum;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "经纪人申请 - 签订协议")
@GenerateByApiEngineSdk(time = "2017.06.06 10:17:24.051", version = "v0.0.28")
public class BrokerRequest_SignAgreements_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String token = req.getToken();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, token);
        if (user == null) {
            throw new ApiExecuteException(ErrorCodeEnum.token_error);
        }
        Map<Field<?>, Object> map = new HashMap<>();
        map.put(USER.BROKER_REQUEST_AGREEMENTS, JSON.toJSONString(req.getAgreements()));
        map.put(USER.BROKER_REQUEST_SIGN_URL, req.getSignUrl());
        map.put(USER.BROKER_REQUEST_STATUS, BrokerRequestStatusEnum.auditing.getValue());
        DSL.using(Jooq.buildConfiguration()).update(USER).set(map).where(USER.TOKEN.equal(token)).execute();
        return new Response();
    }

    public static class Req extends Request {

        @Comment(value = "用户唯一标识码") @Required(value = true) private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "签订协议（1:经纪人协议 2:经纪人承诺书 3:经纪人劳务服务协议）") @Required(value = true) private List<String> agreements;

        public List<String> getAgreements() {
            return agreements;
        }

        public void setAgreements(List<String> agreements) {
            this.agreements = agreements;
        }

        @Comment(value = "签名图片URL") @Required(value = true) private String signUrl;

        public String getSignUrl() {
            return signUrl;
        }

        public void setSignUrl(String signUrl) {
            this.signUrl = signUrl;
        }
    }
}
