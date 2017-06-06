package com.github.xuzw.forexroo;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;
import com.github.xuzw.forexroo.activemq.JsonResponseCallback;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 下午12:16:01
 */
public class ActiveMqTest {
    public static void main(String[] args) throws Exception {
        ActiveMq.init();
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("symbol", "EURUSD");
        jsonRequest.put("period", 1);
        jsonRequest.put("fromtime", 1493888947);
        jsonRequest.put("endtime", 1493891409);
        ActiveMq.sendRequest("History_Rates_Info_Topic", jsonRequest, new JsonResponseCallback() {
            @Override
            public void onMessage(JSONObject jsonResponse) {
                System.out.println(jsonResponse.toJSONString());
            }
        });
    }
}
