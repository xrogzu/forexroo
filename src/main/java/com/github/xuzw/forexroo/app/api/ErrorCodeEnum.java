package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.api.ResponseCode;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;

@GenerateByApiEngineSdk(time = "2017.06.07 04:22:25.437", version = "v0.0.33")
public enum ErrorCodeEnum implements ResponseCode {

    /**数据库异常*/
    database_error(1000, "数据库异常"), /**资源不存在或已被删除*/
    not_exists(1001, "资源不存在或已被删除"), /**验证码发送失败*/
    sms_send_error(1002, "验证码发送失败"), /**验证码错误*/
    verification_code_error(1003, "验证码错误"), /**用户唯一标识码错误*/
    token_error(1004, "用户唯一标识码错误"), /**全国身份证实名认证失败*/
    realName_authentication_failed(1005, "全国身份证实名认证失败"), /**创建OSS STS授权TOKEN异常*/
    create_oss_stsToken_exception(1006, "创建OSS STS授权TOKEN异常"), /**已达到关注数量上限*/
    maximum_myMasterTrader_size_exceeded(1007, "已达到关注数量上限"), /**仅允许绑定一张银行卡*/
    maximum_bindBankCard_size_exceeded(1008, "仅允许绑定一张银行卡"), /**银行卡四要素认证失败*/
    bankCard_authentication_failed(1009, "银行卡四要素认证失败"), /**密码错误*/
    password_error(1010, "密码错误"), /**状态异常*/
    status_error(1011, "状态异常");

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
