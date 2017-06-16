package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月16日 上午9:46:00
 */
public class V1_9__CreateTable_Mt4HistoryOrder implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("mt4_history_order");
        table.addColumn("activation", "", C.STRING);
        table.addColumn("close_price", "", C.STRING);
        table.addColumn("close_time", "", C.BIGINT);
        table.addColumn("cmd", "", C.INT);
        table.addColumn("comment", "", C.STRING);
        table.addColumn("commission", "", C.STRING);
        table.addColumn("commission_agent", "", C.STRING);
        table.addColumn("conv_rates1", "", C.STRING);
        table.addColumn("conv_rates2", "", C.STRING);
        table.addColumn("conv_reserv", "", C.STRING);
        table.addColumn("digits", "", C.STRING);
        table.addColumn("expiration", "", C.STRING);
        table.addColumn("gw_close_price", "", C.STRING);
        table.addColumn("gw_open_price", "", C.STRING);
        table.addColumn("gw_order", "", C.STRING);
        table.addColumn("gw_volume", "", C.STRING);
        table.addColumn("login", "", C.STRING);
        table.addColumn("magic", "", C.STRING);
        table.addColumn("margin_rate", "", C.STRING);
        table.addColumn("open_price", "", C.STRING);
        table.addColumn("open_time", "", C.BIGINT);
        table.addColumn("order_id", "", C.INT);
        table.addColumn("profit", "", C.STRING);
        table.addColumn("reason", "", C.STRING);
        table.addColumn("sl", "", C.STRING);
        table.addColumn("state", "", C.STRING);
        table.addColumn("storage", "", C.STRING);
        table.addColumn("symbol", "", C.STRING);
        table.addColumn("taxes", "", C.STRING);
        table.addColumn("timestamp", "", C.BIGINT);
        table.addColumn("tp", "", C.STRING);
        table.addColumn("volume", "", C.STRING);
        table.addPKColumn("id", "主键", C.AUTOINC);
        table.addUniqueIndex("order_id");
        migration.run(connection);
    }
}
