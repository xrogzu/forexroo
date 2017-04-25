package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.app.utils.AppApiEngineHolder;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@GenerateByApiEngineSdk(time = "2017.04.25 05:20:15.209", version = "v0.0.1")
public class ApiEngine_Query_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        resp.setApiList(AppApiEngineHolder.get().getApiNames());
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "Api接口名字列表")
        @Required(value = true)
        private List<String> apiList;

        public List<String> getApiList() {
            return apiList;
        }

        public void setApiList(List<String> apiList) {
            this.apiList = apiList;
        }
    }
}
