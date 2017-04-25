package com.github.xuzw.forexroo.app.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

@GenerateByApiEngineSdk(time = "2017.04.25 06:23:18.747", version = "v0.0.1")
public class System_SendSms_Api implements Api {

    private static final Logger log = LoggerFactory.getLogger(System_SendSms_Api.class);

    public static final String key = "9059a93860c863a9395e8f715ee4c28a";

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        JdkRequest jdkRequest = new JdkRequest("http://v.apistore.cn/api/v14/xsend");
        jdkRequest.uri().queryParam("key", key).queryParam("mobile", req.getMobile()).queryParam("tpl_id", req.getTemplateId()).queryParam("tpl_val", req.getArgs());
        String json = jdkRequest.method(com.jcabi.http.Request.GET).fetch().body();
        log.debug(json);
        JSONObject jsonObject = JSON.parseObject(json);
        if (jsonObject.getIntValue("error_code") != 0) {
            throw new ApiExecuteException(ErrorCodeEnum.sms_send_error);
        }
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "手机号码") @Required(value = true) private Integer mobile;

        public Integer getMobile() {
            return mobile;
        }

        public void setMobile(Integer mobile) {
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
