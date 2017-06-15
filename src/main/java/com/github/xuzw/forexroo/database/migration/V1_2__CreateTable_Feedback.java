package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月5日 下午4:52:38
 */
public class V1_2__CreateTable_Feedback implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("feedback");
        table.addColumn("content", "意见反馈详细描述", C.TEXT);
        table.addColumn("user_id", "用户ID", C.BIGINT);
        table.addColumn("time", "时间", C.BIGINT);
        table.addColumn("picture_urls", "截图照片URL", C.STRING);
        table.addPKColumn("id", "主键", C.AUTOINC);
        migration.run(connection);
    }
}
