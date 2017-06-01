package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月1日 下午6:00:49
 */
public class V1_1__CreateTableMasterTraderRankings implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("master_trader_rankings");
        table.addColumn("user_id", "用户ID", C.BIGINT);
        table.addColumn("avatar", "头像", C.STRING);
        table.addColumn("nickname", "昵称", C.STRING);
        table.addColumn("follower_count", "关注人数", C.BIGINT);
        table.addColumn("total_profit", "总盈利", C.STRING);
        table.addColumn("single_profit", "均单盈利", C.STRING);
        table.addColumn("success_rate", "成功率", C.STRING);
        table.addPKColumn("id", "主键", C.AUTOINC);
        table.addUniqueIndex("user_id");
        migration.run(connection);
    }
}
