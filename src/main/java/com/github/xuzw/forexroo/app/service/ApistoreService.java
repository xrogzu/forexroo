package com.github.xuzw.forexroo.app.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcabi.http.request.JdkRequest;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 上午11:44:53
 */
public class ApistoreService {
    public static final String key = "23ea02288ae1b784c17de701d77cda4c";

    public static JSONObject verifyBankCard(String bankcard, String realName, String cardNo, String mobile) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("key", ApistoreService.key);
        params.put("bankcard", bankcard);
        params.put("realName", realName);
        params.put("cardNo", cardNo);
        params.put("Mobile", mobile);
        params.put("information", "1");
        String json = new JdkRequest("http://v.apistore.cn/api/bank/v4").uri().queryParams(params).back().method(com.jcabi.http.Request.GET).fetch().body();
        return JSON.parseObject(json);
    }
}
