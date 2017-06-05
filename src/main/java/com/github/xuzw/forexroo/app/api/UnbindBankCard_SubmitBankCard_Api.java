package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "解绑银行卡 - 第一步：提交预留手机号")
@GenerateByApiEngineSdk(time = "2017.06.05 05:03:00.798", version = "v0.0.25")
public class UnbindBankCard_SubmitBankCard_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
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
