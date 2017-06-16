package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月16日 上午10:34:25
 */
public class V1_10__CreateTable_Mt4HistoryOrderSyncLog implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("mt4_history_order_sync_log");
        table.addColumn("request_arg_login", "请求参数-MT4帐号", C.STRING);
        table.addColumn("request_arg_symbol", "请求参数-品种", C.STRING);
        table.addColumn("request_arg_trade_type", "请求参数-类型", C.INT);
        table.addColumn("request_arg_from_time", "请求参数-开始时间戳", C.BIGINT);
        table.addColumn("request_arg_end_time", "请求参数-结束时间戳", C.BIGINT);
        table.addColumn("request_time", "请求时间戳", C.BIGINT);
        table.addColumn("response_time", "响应时间戳", C.BIGINT);
        table.addPKColumn("id", "主键", C.AUTOINC);
        migration.run(connection);
    }
}
