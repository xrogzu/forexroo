package com.github.xuzw.forexroo;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 下午3:11:52
 */
public class OpenAccountTest {
    public static void main(String[] args) throws Exception {
        ActiveMq.init();
        JSONObject json = new JSONObject();
        json.put("username", "13426290598");
        json.put("leverage", 100);
        json.put("groupname", "Testab");
        json.put("password", "abc123456");
        json.put("investor", "abc123456");
        json.put("phonepwd", "abc123456");
        JSONObject resp = ActiveMq.sendRequestAndAwait("Register_User_Info_Topic", json);
        System.out.println(resp.toJSONString());
        String mt4Account = resp.getString("login");
        System.out.println(mt4Account);
    }
}
