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
import com.github.xuzw.forexroo.app.utils.SmsTemplateEnum;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;
import com.jcabi.http.request.JdkRequest;

@GenerateByApiEngineSdk(time = "2017.06.01 03:37:38.378", version = "v0.0.5")
public class System_SendSms_Api implements Api {

    public static final String url = "http://v.apistore.cn/api/v14/xsend";

    public static final String key = "23ea02288ae1b784c17de701d77cda4c";

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Map<String, String> params = new HashMap<>();
        Map<String, String> tplArgs = new HashMap<>();
        params.put("key", key);
        params.put("mobile", req.getPhone());
        if (1 == req.getType()) {
            params.put("tpl_id", SmsTemplateEnum.register.getIdString());
            tplArgs.put("code", "1234");
            params.put("tpl_val", JSON.toJSONString(tplArgs));
        }
        String json = new JdkRequest(url).uri().queryParams(params).back().method(com.jcabi.http.Request.GET).fetch().body();
        JSONObject jsonObject = JSON.parseObject(json);
        if (jsonObject.getIntValue("error_code") != 0) {
            throw new ApiExecuteException(ErrorCodeEnum.sms_send_error, jsonObject.getString("reason"));
        }
        return new Response();
    }

    public static class Req extends Request {

        @Comment(value = "手机号码")
        @Required(value = true)
        private String phone;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Comment(value = "类型（1:注册）")
        @Required(value = true)
        private Integer type;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
}
