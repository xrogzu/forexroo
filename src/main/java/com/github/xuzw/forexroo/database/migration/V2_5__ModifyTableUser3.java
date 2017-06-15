package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月14日 上午10:23:34
 */
public class V2_5__ModifyTableUser3 implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        migration.addColumn("user", "open_account_audit_fail_reason", "开户-审核失败-原因", C.INT);
        migration.run(connection);
    }
}
