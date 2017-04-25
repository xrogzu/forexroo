package com.github.xuzw.forexroo.utils.database;

import java.sql.Connection;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午11:58:42
 */
public class JooqConfigurationBuilder {
    public static Configuration build(Connection conn) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(conn);
        configuration.setSQLDialect(SQLDialect.MYSQL);
        return configuration;
    }
}
