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
import com.github.xuzw.forexroo.app.utils.SmsVerificationCodeCache;
import com.github.xuzw.forexroo.app.utils.VerificationCodeBuilder;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;
import com.jcabi.http.request.JdkRequest;

@Comment(value = "系统 - 发送短信验证码")
@GenerateByApiEngineSdk(time = "2017.06.07 11:16:34.409", version = "v0.0.31")
public class System_SendSmsVerificationCode_Api implements Api {

    public static final String url = "http://v.apistore.cn/api/v14/xsend";

    public static final String key = "23ea02288ae1b784c17de701d77cda4c";

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String phone = req.getPhone();
        Map<String, String> params = new HashMap<>();
        Map<String, String> tplArgs = new HashMap<>();
        params.put("key", key);
        params.put("mobile", phone);
        SmsTemplateEnum smsTemplateEnum = SmsTemplateEnum.parse(req.getType());
        params.put("tpl_id", String.valueOf(smsTemplateEnum.getTemplateId()));
        String verificationCode = VerificationCodeBuilder.build();
        SmsVerificationCodeCache.put(phone, smsTemplateEnum.name(), verificationCode);
        tplArgs.put("code", verificationCode);
        params.put("tpl_val", JSON.toJSONString(tplArgs));
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

        @Comment(value = "类型（1:登录即注册 2:更换手机号 3:绑定银行卡 4:解绑银行卡）")
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
