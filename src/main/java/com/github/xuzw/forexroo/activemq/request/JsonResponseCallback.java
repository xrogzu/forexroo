package com.github.xuzw.forexroo.activemq;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 上午11:10:22
 */
public interface JsonResponseCallback {
    void onMessage(JSONObject jsonResponse);
}
