package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月3日 下午5:51:11
 */
public class V1_0__CreateMarketQuotation implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration m = new Migration();
        m.createTable("market_quotation")// 市场行情
                .addColumn("ask", C.STRING)// 卖出价
                .addColumn("bid", C.STRING)// 买入价
                .addColumn("symbol", C.STRING)// 品种
                .addColumn("time", C.BIGINT)// 品种
                .addPKColumn("id", C.AUTOINC);
        m.run(connection);
    }
}
