package com.github.xuzw.forexroo.app.api;

import java.util.UUID;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.JooqConfigurationBuilder;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@GenerateByApiEngineSdk(time = "2017.05.29 02:46:22.496", version = "v0.0.1")
public class User_Login_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (!req.getVerificationCode().equals("1234")) {
            throw new ApiExecuteException(ErrorCodeEnum.verification_code_error);
        }
        UserDao userDao = new UserDao(JooqConfigurationBuilder.build());
        User user = userDao.fetchOne(Tables.USER.PHONE, req.getPhone());
        if (user == null) {
            User newUser = new User();
            newUser.setPhone(req.getPhone());
            newUser.setRegisterTime(System.currentTimeMillis());
            newUser.setToken(UUID.randomUUID().toString());
            userDao.insert(newUser);
            user = newUser;
        }
        Resp resp = new Resp();
        resp.setToken(user.getToken());
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "手机号码")
        @Required(value = true)
        private String phone;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

    public static class Resp extends Response {

        @Comment(value = "用户唯一标识码")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
