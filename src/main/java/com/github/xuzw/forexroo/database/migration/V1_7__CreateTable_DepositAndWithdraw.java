package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月9日 下午3:26:14
 */
public class V1_7__CreateTable_DepositAndWithdraw implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("deposit_and_withdraw");
        table.addColumn("raw_request", "原始请求", C.TEXT);
        table.addColumn("mt4_raw_request", "MT4-原始请求", C.TEXT);
        table.addColumn("mt4_raw_response", "MT4-原始响应", C.TEXT);
        table.addColumn("mt4_request_time", "MT4-发送请求时间戳", C.BIGINT);
        table.addColumn("mt4_response_time", "MT4-收到响应时间戳", C.BIGINT);
        table.addColumn("type", "类型", C.INT);
        table.addColumn("order_id", "订单ID", C.STRING);
        table.addColumn("amount", "金额", C.STRING);
        table.addColumn("comment", "备注", C.STRING);
        table.addColumn("user_id", "用户ID", C.BIGINT);
        table.addColumn("time", "时间", C.BIGINT);
        table.addPKColumn("id", "主键", C.AUTOINC);
        migration.run(connection);
    }
}
