package com.github.xuzw.forexroo;

import java.util.Calendar;

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
        Calendar fromTime = Calendar.getInstance();
        fromTime.add(Calendar.HOUR_OF_DAY, -8);
        json.put("fromtime", fromTime.getTimeInMillis() / 1000);
        json.put("endtime", fromTime.getTimeInMillis() / 1000);
        System.out.println(ActiveMq.sendRequestAndAwait("History_Rates_Info_Topic", json).toJSONString());
    }
}
