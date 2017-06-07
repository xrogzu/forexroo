package com.github.xuzw.forexroo;

import static com.github.xuzw.forexroo.entity.Tables.USER;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;
import com.github.xuzw.forexroo.database.Druid;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 下午5:31:30
 */
public class AccountQueryDetailTest {
    public static void main(String[] args) throws Exception {
        Druid.init();
        ActiveMq.init();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, "f42fcc4b-18cc-4741-9154-6760aa40a74b");
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("login", Long.valueOf(user.getMt4RealAccount()));
        System.out.println(jsonRequest.toJSONString());
        JSONObject jsonResponse = ActiveMq.sendRequestAndAwait("Get_User_Info_Topic", jsonRequest);
        System.out.println(jsonResponse.toJSONString());
        System.exit(0);
    }
}
