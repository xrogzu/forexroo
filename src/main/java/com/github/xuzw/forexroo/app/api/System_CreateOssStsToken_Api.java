package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "系统 - 创建阿里云OSS STS授权TOKEN")
@GenerateByApiEngineSdk(time = "2017.06.02 05:48:31.053", version = "v0.0.14")
public class System_CreateOssStsToken_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "ID")
        @Required(value = true)
        private String accessKeyId;

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        @Comment(value = "密匙")
        @Required(value = true)
        private String accessKeySecret;

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        @Comment(value = "截止期限")
        @Required(value = true)
        private String expiration;

        public String getExpiration() {
            return expiration;
        }

        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        @Comment(value = "授权TOKEN")
        @Required(value = true)
        private String securityToken;

        public String getSecurityToken() {
            return securityToken;
        }

        public void setSecurityToken(String securityToken) {
            this.securityToken = securityToken;
        }
    }
}
