package com.github.xuzw.forexroo;

import static com.github.xuzw.forexroo.entity.Tables.USER;

import java.util.HashMap;
import java.util.Map;

import org.jooq.Field;
import org.jooq.impl.DSL;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.forexroo.activemq.ActiveMq;
import com.github.xuzw.forexroo.database.Druid;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.OpenAccountStatusEnum;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 下午3:11:52
 */
public class OpenAccountAuditingTest {
    public static void main(String[] args) throws Exception {
        Druid.init();
        ActiveMq.init();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOneByPhone("13550311857");
        JSONObject json = new JSONObject();
        json.put("username", user.getPhone());
        json.put("leverage", 100);
        json.put("groupname", "xiaozhang");
        json.put("password", "abc123456");
        json.put("investor", "abc123456");
        json.put("phonepwd", "abc123456");
        System.out.println(json.toJSONString());
        JSONObject resp = ActiveMq.sendRequestAndAwait("Register_User_Info_Topic", json);
        System.out.println(resp.toJSONString());
        String mt4Account = resp.getString("login");
        Map<Field<?>, Object> map = new HashMap<>();
        map.put(USER.MT4_REAL_ACCOUNT, mt4Account);
        map.put(USER.OPEN_ACCOUNT_STATUS, OpenAccountStatusEnum.auditing_success.getValue());
        DSL.using(Jooq.buildConfiguration()).update(USER).set(map).where(USER.ID.equal(user.getId())).execute();
        System.exit(0);
    }
}
