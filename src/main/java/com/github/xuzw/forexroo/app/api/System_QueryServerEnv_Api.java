package com.github.xuzw.forexroo.app.api;

import java.util.HashMap;
import java.util.Map;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Required;

@GenerateByApiEngineSdk(time = "2017.04.26 01:04:52.621", version = "v0.0.1")
public class System_QueryServerEnv_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        resp.setEnv(System.getenv());
        Map<String, String> properties = new HashMap<>();
        for (Object key : System.getProperties().keySet()) {
            String keyString = (String) key;
            properties.put(keyString, System.getProperty(keyString));
        }
        resp.setProperties(properties);
        return resp;
    }

    public static class Resp extends Response {

        @Required(value = true)
        private Map<String, String> env;

        public Map<String, String> getEnv() {
            return env;
        }

        public void setEnv(Map<String, String> env) {
            this.env = env;
        }

        @Required(value = true)
        private Map<String, String> properties;

        public Map<String, String> getProperties() {
            return properties;
        }

        public void setProperties(Map<String, String> properties) {
            this.properties = properties;
        }
    }
}
