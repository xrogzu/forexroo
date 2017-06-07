package com.github.xuzw.forexroo.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午11:58:42
 */
public class Jooq {
    public static Configuration buildConfiguration(DataSource dataSource) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(dataSource);
        configuration.setSQLDialect(SQLDialect.MYSQL);
        return configuration;
    }

    public static Configuration buildConfiguration() throws SQLException {
        return buildConfiguration(Druid.get());
    }
}
