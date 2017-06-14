package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月14日 上午10:23:34
 */
public class V2_0__ModifyTableUser implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        migration.addColumn("user", "my_broker", "所属经纪人", C.INT);
        migration.run(connection);
    }
}
