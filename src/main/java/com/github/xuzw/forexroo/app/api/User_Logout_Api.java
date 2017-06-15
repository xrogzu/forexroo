package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import org.jooq.impl.DSL;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.app.utils.Tokens;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "用户 - 退出")
@GenerateByApiEngineSdk(time = "2017.06.15 11:39:47.659", version = "v1.0.1")
public class User_Logout_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String oldToken = req.getToken();
        String newToken = Tokens.newToken();
        DSL.using(Jooq.buildConfiguration()).update(USER).set(USER.TOKEN, newToken).where(USER.TOKEN.equal(oldToken)).execute();
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
    }
}
