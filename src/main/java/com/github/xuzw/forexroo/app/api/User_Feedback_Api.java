package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "用户 - 意见反馈")
@GenerateByApiEngineSdk(time = "2017.06.02 05:48:31.182", version = "v0.0.14")
public class User_Feedback_Api implements Api {

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

        @Comment(value = "意见反馈详细描述")
        @Required(value = true)
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Comment(value = "截图照片URL")
        @Required(value = true)
        private List<String> pictureUrls;

        public List<String> getPictureUrls() {
            return pictureUrls;
        }

        public void setPictureUrls(List<String> pictureUrls) {
            this.pictureUrls = pictureUrls;
        }
    }
}
