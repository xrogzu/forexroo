package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月14日 上午10:23:34
 */
public class V2_4__ModifyTableUser2 implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        migration.addColumn("user", "open_account_audit_user_id", "开户-审核人", C.INT);
        migration.addColumn("user", "broker_request_audit_user_id", "经纪人申请-审核人", C.INT);
        migration.run(connection);
    }
}
