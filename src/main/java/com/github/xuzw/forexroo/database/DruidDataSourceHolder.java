package com.github.xuzw.forexroo.database;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午11:04:45
 */
public class DruidDataSourceHolder {
    private static final Logger log = LoggerFactory.getLogger(DruidDataSourceHolder.class);
    private static DruidDataSource druidDataSource;

    public static DruidDataSource get() {
        return druidDataSource;
    }

    public static void init() {
        DruidDataSourceHolder.druidDataSource = buildDruidDataSource();
    }

    private static DruidDataSource buildDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://rm-wz9g37e75ha54f140o.mysql.rds.aliyuncs.com:3306/forexroo");
        druidDataSource.setUsername("forexroo");
        druidDataSource.setPassword("qwer@0000");
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        try {
            druidDataSource.setFilters("stat");
        } catch (SQLException e) {
            log.error("", e);
        }
        return druidDataSource;
    }
}
