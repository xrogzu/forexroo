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
        table.addColumn("avatar", "头像", C.STRING);
        table.addColumn("nickname", "昵称", C.STRING);
        table.addColumn("sex", "性别", C.STRING);
        table.addColumn("country", "国家", C.STRING);
        table.addColumn("open_account_realname", "开户-姓名", C.STRING);
        table.addColumn("open_account_identity_card_number", "开户-身份证号", C.STRING);
        table.addColumn("open_account_picture_url", "开户-手持身份证正面照URL", C.STRING);
        table.addColumn("open_account_agreements", "开户-签订协议", C.STRING);
        table.addColumn("open_account_sign_url", "开户-签名图片URL", C.STRING);
        table.addColumn("open_account_status", "开户-状态", C.INT);
        table.addColumn("broker_request_agreements", "经纪人申请-签订协议", C.STRING);
        table.addColumn("broker_request_sign_url", "经纪人申请-签名图片URL", C.STRING);
        table.addColumn("broker_request_status", "经纪人申请-状态", C.INT);
        table.addPKColumn("id", "主键", C.AUTOINC);
        table.addUniqueIndex("phone");
        table.addUniqueIndex("token");
        migration.run(connection);
    }
}