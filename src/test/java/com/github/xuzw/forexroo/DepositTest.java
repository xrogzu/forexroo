package com.github.xuzw.forexroo;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月9日 上午11:06:32
 */
public class DepositTest {
    public static void main(String[] args) throws Exception {
        ActiveMq.init();
        JSONObject json = new JSONObject();
        // json.put("login", 996000489);
        // json.put("login", 996000490);
        // json.put("login", 996000492);
        json.put("login", 996000492);
        json.put("operationtype", 1);
        json.put("amount", 10000);
        json.put("comment", "2017年6月9日入金10000美元");
        System.out.println(ActiveMq.sendRequestAndAwait("Deposit_User_Info_Topic", json).toJSONString());
    }
}
