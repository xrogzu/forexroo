package com.github.xuzw.forexroo.activemq;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月12日 下午3:10:49
 */
public interface JsonMessageCallback {
    void onMessage(JSONObject jsonMessage);
}
