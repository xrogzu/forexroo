package com.github.xuzw.forexroo.app.api;

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

@GenerateByApiEngineSdk(time = "2017.04.25 05:20:15.297", version = "v0.0.1")
public class System_SendSms_Api implements Api {

    public static final String key = "23ea02288ae1b784c17de701d77cda4c";

    public static final String template = "【ForexRoo】验证码%s";

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Integer mobile = req.getMobile();
        JdkRequest jdkRequest = new JdkRequest("http://v.apistore.cn/api/v14/send/");
        jdkRequest.uri().queryParam("key", key).queryParam("mobile", mobile).queryParam("content", String.format(template, mobile));
        String json = jdkRequest.method(com.jcabi.http.Request.GET).fetch().body();
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
    }
}
