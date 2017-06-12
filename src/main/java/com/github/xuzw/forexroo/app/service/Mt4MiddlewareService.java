package com.github.xuzw.forexroo.app.service;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 下午3:36:48
 */
public class Mt4MiddlewareService {
    public static JSONObject getTickLast(String symbol) throws InterruptedException {
        JSONObject json = new JSONObject();
        json.put("symbol", symbol);
        return ActiveMq.sendRequestAndAwait("Get_Tick_Last_Topic", json);
    }
}
