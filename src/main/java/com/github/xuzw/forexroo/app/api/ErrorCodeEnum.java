package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.api.ResponseCode;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;

@GenerateByApiEngineSdk(time = "2017.04.25 05:20:15.433", version = "v0.0.1")
public enum ErrorCodeEnum implements ResponseCode {

    /**数据库异常*/
    database_error(1000, "数据库异常"), /**资源不存在或已被删除*/
    not_exists(1001, "资源不存在或已被删除"), /**验证码发送失败*/
    sms_send_error(1002, "验证码发送失败");

    private ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    public int getCode() {
        return code;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
