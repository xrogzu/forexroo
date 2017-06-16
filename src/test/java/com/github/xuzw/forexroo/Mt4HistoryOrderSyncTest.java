package com.github.xuzw.forexroo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.activemq.ActiveMQConnection;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.activemq_utils.ActiveMq;
import com.github.xuzw.forexroo.database.Druid;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月16日 下午12:21:54
 */
public class Mt4HistoryOrderSyncTest {
    public static void main(String[] args) throws Exception {
        Druid.init();
        String brokerUrl = "failover:tcp://119.23.62.18:61616";
        List<String> responseTopics = new ArrayList<>();
        responseTopics.add("History_Orders_Info_Result_Topic");
        ActiveMq.init(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, brokerUrl, responseTopics);
        JSONObject json = new JSONObject();
        json.put("login", 996000521);
        json.put("symbol", "");
        json.put("tradeType", 0);
        Calendar time = Calendar.getInstance();
        time.add(Calendar.HOUR_OF_DAY, -8);
        json.put("endtime", time.getTimeInMillis() / 1000);
        time.add(Calendar.DAY_OF_MONTH, -1);
        json.put("fromtime", time.getTimeInMillis() / 1000);
        System.out.println(json.toJSONString());
        JSONObject resp = ActiveMq.sendRequestAndAwait("History_Orders_Info_Topic", json);
        System.out.println(resp.toJSONString());
        System.exit(0);
    }
}
