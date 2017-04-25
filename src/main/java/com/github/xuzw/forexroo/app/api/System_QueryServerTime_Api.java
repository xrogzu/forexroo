package com.github.xuzw.forexroo.app.api;

import java.text.SimpleDateFormat;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@GenerateByApiEngineSdk(time = "2017.04.25 06:23:18.712", version = "v0.0.1")
public class System_QueryServerTime_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timestamp = System.currentTimeMillis();
        resp.setTimestamp(timestamp);
        resp.setTime(dateFormat.format(timestamp));
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "服务器时间戳")
        @Required(value = true)
        private Long timestamp;

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        @Comment(value = "服务器时间(格式yyyy-MM-dd HH:mm:ss)")
        @Required(value = true)
        private String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
