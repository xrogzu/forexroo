package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 下午3:30:55
 */
public class V1_5__CreateTable_MyMasterTrader implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("my_master_trader");
        table.addColumn("master_trader_user_id", "大师ID", C.BIGINT);
        table.addColumn("user_id", "用户ID", C.BIGINT);
        table.addColumn("time", "时间", C.BIGINT);
        table.addPKColumn("id", "主键", C.AUTOINC);
        migration.run(connection);
    }
}