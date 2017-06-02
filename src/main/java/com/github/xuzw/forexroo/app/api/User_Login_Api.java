package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import org.jooq.impl.DSL;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.app.utils.Tokens;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "用户 - 登录即注册")
@GenerateByApiEngineSdk(time = "2017.06.02 12:53:09.938", version = "v0.0.8")
public class User_Login_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (!req.getVerificationCode().equals("1234")) {
            throw new ApiExecuteException(ErrorCodeEnum.verification_code_error);
        }
        Resp resp = new Resp();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.PHONE, req.getPhone());
        String newToken = Tokens.newToken();
        if (user == null) {
            // 注册新用户
            User newUser = new User();
            newUser.setPhone(req.getPhone());
            newUser.setRegisterTime(System.currentTimeMillis());
            newUser.setToken(newToken);
            userDao.insert(newUser);
        } else {
            // 旧用户
            String oldToken = user.getToken();
            DSL.using(Jooq.buildConfiguration()).update(USER).set(USER.TOKEN, newToken).where(USER.TOKEN.equal(oldToken)).execute();
        }
        resp.setToken(newToken);
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
