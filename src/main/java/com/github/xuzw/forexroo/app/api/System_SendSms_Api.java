package com.github.xuzw.forexroo.app.api;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;
import com.jcabi.http.request.JdkRequest;

@GenerateByApiEngineSdk(time = "2017.04.26 01:04:52.653", version = "v0.0.1")
public class System_SendSms_Api implements Api {

    public static final String url = "http://v.apistore.cn/api/v14/xsend";

    public static final String key = "23ea02288ae1b784c17de701d77cda4c";

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Map<String, String> params = new HashMap<>();
        params.put("key", key);
        params.put("mobile", req.getMobile());
        params.put("tpl_id", String.valueOf(req.getTemplateId()));
        params.put("tpl_val", JSON.toJSONString(req.getArgs()));
        String json = new JdkRequest(url).uri().queryParams(params).back().method(com.jcabi.http.Request.GET).fetch().body();
        JSONObject jsonObject = JSON.parseObject(json);
        if (jsonObject.getIntValue("error_code") != 0) {
            throw new ApiExecuteException(ErrorCodeEnum.sms_send_error, jsonObject.getString("reason"));
        }
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "手机号码") @Required(value = true) private String mobile;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        @Comment(value = "模板ID") @Required(value = true) private Integer templateId;

        public Integer getTemplateId() {
            return templateId;
        }

        public void setTemplateId(Integer templateId) {
            this.templateId = templateId;
        }

        @Comment(value = "模板变量") @Required(value = true) private Map<String, String> args;

        public Map<String, String> getArgs() {
            return args;
        }

        public void setArgs(Map<String, String> args) {
            this.args = args;
        }
    }
}
