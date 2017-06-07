package com.github.xuzw.forexroo;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 下午3:20:38
 */
public class TickLastTest {
    public static void main(String[] args) throws Exception {
        ActiveMq.init();
        JSONObject json = new JSONObject();
        json.put("symbol", "EURUSD");
        JSONObject resp = ActiveMq.sendRequestAndAwait("Get_Tick_Last_Topic", json);
        System.out.println(resp.toJSONString());
    }
}
