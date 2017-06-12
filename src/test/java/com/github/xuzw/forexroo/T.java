package com.github.xuzw.forexroo;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;
import com.github.xuzw.forexroo.activemq.JsonMessageCallback;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月12日 下午3:21:28
 */
public class T {
    public static void main(String[] args) throws Exception {
        ActiveMq.init();
        ActiveMq.onMessage("Market_Data_Info_Topic", new JsonMessageCallback() {
            @Override
            public void onMessage(JSONObject jsonMessage) {
                System.out.println(jsonMessage.toJSONString());
            }
        });
    }
}
