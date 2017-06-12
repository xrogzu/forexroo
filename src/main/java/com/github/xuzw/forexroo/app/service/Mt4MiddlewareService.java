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

    public static JSONObject deposit(double amount, int mt4RealAccount, int type) throws InterruptedException {
        JSONObject mt4Request = new JSONObject();
        mt4Request.put("login", mt4RealAccount);
        mt4Request.put("operationtype", type);
        mt4Request.put("amount", amount);
        return ActiveMq.sendRequestAndAwait("Deposit_User_Info_Topic", mt4Request);
    }
}
