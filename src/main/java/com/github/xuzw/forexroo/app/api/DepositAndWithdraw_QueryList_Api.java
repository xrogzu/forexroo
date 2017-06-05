package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "出入金 - 查询列表")
@GenerateByApiEngineSdk(time = "2017.06.05 01:04:54.663", version = "v0.0.24")
public class DepositAndWithdraw_QueryList_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
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
    }

    public static class Resp extends Response {

        @Comment(value = "列表")
        @Required(value = true)
        private List<DepositOrWithdraw> list;

        public List<DepositOrWithdraw> getList() {
            return list;
        }

        public void setList(List<DepositOrWithdraw> list) {
            this.list = list;
        }
    }
}
