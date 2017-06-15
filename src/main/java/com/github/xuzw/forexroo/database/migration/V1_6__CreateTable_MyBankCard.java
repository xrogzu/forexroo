package com.github.xuzw.forexroo.database.migration;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import com.github.xuzw.migration_builder.C;
import com.github.xuzw.migration_builder.Migration;
import com.github.xuzw.migration_builder.Table;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 上午10:00:48
 */
public class V1_6__CreateTable_MyBankCard implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("my_bank_card");
        table.addColumn("bank_card_number", "银行卡号", C.STRING);
        table.addColumn("reserved_phone", "预留手机号", C.STRING);
        table.addColumn("bank_image", "银行LOGO", C.STRING);
        table.addColumn("bank_name", "银行名称", C.STRING);
        table.addColumn("card_name", "卡名称", C.STRING);
        table.addColumn("card_type", "卡类型", C.STRING);
        table.addColumn("service_phone", "服务热线", C.STRING);
        table.addColumn("apistore_raw_response", "寻程-银行卡四要素认证v3-原始响应", C.TEXT);
        table.addColumn("status", "状态", C.INT);
        table.addColumn("user_id", "用户ID", C.BIGINT);
        table.addColumn("time", "时间", C.BIGINT);
        table.addPKColumn("id", "主键", C.AUTOINC);
        migration.run(connection);
    }
}
