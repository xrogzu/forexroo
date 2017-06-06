package com.github.xuzw.forexroo;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 下午12:16:01
 */
public class ActiveMqTest {
    public static void main(String[] args) throws Exception {
        ActiveMq.init();
        JSONObject json = new JSONObject();
        json.put("symbol", "EURUSD");
        json.put("period", 1440);
        json.put("fromtime", 1496592000);
        json.put("endtime", 1496592000);
        System.out.println(ActiveMq.sendRequestAndAwait("History_Rates_Info_Topic", json).toJSONString());
    }
}
