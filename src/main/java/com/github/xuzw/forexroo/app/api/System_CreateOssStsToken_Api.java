package com.github.xuzw.forexroo.app.api;

import java.util.Arrays;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "系统 - 创建阿里云OSS STS授权TOKEN")
@GenerateByApiEngineSdk(time = "2017.06.05 05:52:48.489", version = "v0.0.27")
public class System_CreateOssStsToken_Api implements Api {

    public static final String REGION_ID = "cn-hangzhou";

    public static final String STS_API_VERSION = "2015-04-01";

    public static final Long DURATION_SECONDS = 3600L;

    private static AssumeRoleResponse assumeRole(String accessKeyId, String accessKeySecret, String roleArn, String roleSessionName, String policy, ProtocolType protocolType) throws ServerException, ClientException {
        IClientProfile profile = DefaultProfile.getProfile(REGION_ID, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        AssumeRoleRequest request = new AssumeRoleRequest();
        request.setVersion(STS_API_VERSION);
        request.setMethod(MethodType.POST);
        request.setProtocol(protocolType);
        request.setRoleArn(roleArn);
        request.setRoleSessionName(roleSessionName);
        request.setPolicy(policy);
        request.setDurationSeconds(DURATION_SECONDS);
        return client.getAcsResponse(request);
    }

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        String accessKeyId = "LTAI6MtXOFxuCzJ0";
        String accessKeySecret = "45JSdVwS4Ujg9onxnjVc67ErbbAuJ5";
        String roleArn = "acs:ram::1726592596677524:role/aliyunosstokengeneratorrole";
        String roleSessionName = "external-username";
        JSONObject policy = new JSONObject();
        policy.put("Version", "1");
        JSONObject statement = new JSONObject();
        statement.put("Action", new JSONArray(Arrays.asList("oss:GetObject", "oss:PutObject")));
        statement.put("Resource", new JSONArray(Arrays.asList("acs:oss:*:*:*")));
        statement.put("Effect", "Allow");
        policy.put("Statement", new JSONArray(Arrays.asList(statement)));
        ProtocolType protocolType = ProtocolType.HTTPS;
        try {
            AssumeRoleResponse response = assumeRole(accessKeyId, accessKeySecret, roleArn, roleSessionName, policy.toJSONString(), protocolType);
            resp.setExpiration(response.getCredentials().getExpiration());
            resp.setAccessKeyId(response.getCredentials().getAccessKeyId());
            resp.setAccessKeySecret(response.getCredentials().getAccessKeySecret());
            resp.setSecurityToken(response.getCredentials().getSecurityToken());
        } catch (ClientException e) {
            throw new ApiExecuteException(ErrorCodeEnum.create_oss_stsToken_exception, e);
        }
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
