package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月26日 下午3:34:40
 */
public class V1_0__CreateTableUser implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("user");
        table.addColumn("phone", "手机号", C.STRING);
        table.addColumn("password", "登录密码", C.STRING);
        table.addColumn("token", "用户唯一标识码", C.STRING);
        table.addColumn("register_time", "注册时间", C.BIGINT);
        table.addPKColumn("id", "主键", C.AUTOINC);
        table.addUniqueIndex("phone");
        table.addUniqueIndex("token");
        migration.run(connection);
    }
}