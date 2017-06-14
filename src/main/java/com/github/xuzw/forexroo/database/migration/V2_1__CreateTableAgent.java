package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月14日 上午10:31:18
 */
public class V2_1__CreateTableAgent implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("agent");
        table.addColumn("name", "代理商名称", C.STRING);
        table.addColumn("code", "代理商代码", C.STRING);
        table.addColumn("password", "密码", C.STRING);
        table.addColumn("bank_detail_account_name", "银行资料-开户名称", C.STRING);
        table.addColumn("bank_detail_account_number", "银行资料-银行账号", C.BIGINT);
        table.addColumn("bank_detail_opening_bank", "银行资料-开户银行", C.STRING);
        table.addColumn("bank_detail_opening_bank_address", "银行资料-开户地", C.STRING);
        table.addColumn("status", "状态", C.STRING);
        table.addPKColumn("id", "主键", C.AUTOINC);
        table.addUniqueIndex("name");
        table.addUniqueIndex("code");
        migration.run(connection);
    }
}