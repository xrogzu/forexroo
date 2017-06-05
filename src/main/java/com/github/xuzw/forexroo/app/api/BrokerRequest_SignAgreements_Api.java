package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "经纪人申请 - 签订协议")
@GenerateByApiEngineSdk(time = "2017.06.05 05:03:00.719", version = "v0.0.25")
public class BrokerRequest_SignAgreements_Api implements Api {

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

        @Comment(value = "签订协议（1:经纪人协议 2:经纪人承诺书 3:经纪人劳务服务协议）")
        @Required(value = true)
        private List<String> agreements;

        public List<String> getAgreements() {
            return agreements;
        }

        public void setAgreements(List<String> agreements) {
            this.agreements = agreements;
        }

        @Comment(value = "签名图片URL")
        @Required(value = true)
        private String signUrl;

        public String getSignUrl() {
            return signUrl;
        }

        public void setSignUrl(String signUrl) {
            this.signUrl = signUrl;
        }
    }
}
