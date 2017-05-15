package com.github.xuzw.forexroo.database;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午11:04:45
 */
public class DruidDataSourceHolder {
    private static DruidDataSource druidDataSource;

    public static DruidDataSource get() {
        return druidDataSource;
    }

    public static void set(DruidDataSource druidDataSource) {
        DruidDataSourceHolder.druidDataSource = druidDataSource;
    }
}
