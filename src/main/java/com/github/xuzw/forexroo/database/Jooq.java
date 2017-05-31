package com.github.xuzw.forexroo.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午11:58:42
 */
public class Jooq {
    public static Configuration buildConfiguration(Connection conn) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(conn);
        configuration.setSQLDialect(SQLDialect.MYSQL);
        return configuration;
    }

    public static Configuration buildConfiguration() throws SQLException {
        return buildConfiguration(Druid.get().getConnection());
    }
}
