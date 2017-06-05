package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "绑定银行卡 - 第一步：提交银行卡信息（银行卡号和预留手机号）")
@GenerateByApiEngineSdk(time = "2017.06.05 11:14:45.809", version = "v0.0.19")
public class BindBankCard_SubmitBankCard_Api implements Api {

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
