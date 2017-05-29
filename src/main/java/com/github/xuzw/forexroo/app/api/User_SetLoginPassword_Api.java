package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;

import org.jooq.impl.DSL;

import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.JooqConfigurationBuilder;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@GenerateByApiEngineSdk(time = "2017.05.29 02:46:22.520", version = "v0.0.1")
public class User_SetLoginPassword_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String token = req.getToken();
        UserDao userDao = new UserDao(JooqConfigurationBuilder.build());
        User user = userDao.fetchOne(USER.TOKEN, token);
        if (user == null) {
            throw new ApiExecuteException(ErrorCodeEnum.token_error);
        }
        int count = DSL.using(JooqConfigurationBuilder.build()).update(USER).set(USER.PASSWORD, req.getPassword()).where(USER.TOKEN.equal(token)).execute();
        if (count == 0) {
            throw new ApiExecuteException(ErrorCodeEnum.database_error);
        }
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

        @Comment(value = "登录密码") @Required(value = true) private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
