package com.github.xuzw.forexroo.app.service;

import static com.github.xuzw.forexroo.entity.Tables.MY_BANK_CARD;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.jooq.Field;
import org.jooq.impl.DSL;

import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.MyBankCardStatusEnum;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 上午11:47:11
 */
public class MyBankCardService {
    public static void updateStatus(Long userId, MyBankCardStatusEnum myBankCardStatusEnum) throws SQLException {
        Map<Field<?>, Object> map = new HashMap<>();
        map.put(MY_BANK_CARD.STATUS, myBankCardStatusEnum.getValue());
        DSL.using(Jooq.buildConfiguration()).update(MY_BANK_CARD).set(map).where(MY_BANK_CARD.USER_ID.equal(userId)).execute();
    }
}
