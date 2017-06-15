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
public class V1_1__CreateTable_User implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        Migration migration = new Migration();
        Table table = migration.createTable("user");
        // 基本资料
        table.addColumn("phone", "手机号", C.STRING);
        table.addColumn("password", "登录密码", C.STRING);
        table.addColumn("token", "用户唯一标识码", C.STRING);
        // 个人资料
        table.addColumn("register_time", "注册时间", C.BIGINT);
        table.addColumn("avatar", "头像", C.STRING);
        table.addColumn("nickname", "昵称", C.STRING);
        table.addColumn("sex", "性别", C.STRING);
        table.addColumn("country", "国家", C.STRING);
        // MT4
        table.addColumn("mt4_real_account", "MT4-真实账号", C.STRING);
        // 从属关系
        table.addColumn("my_broker_id", "所属经纪人-ID", C.BIGINT);
        table.addColumn("my_broker_name", "所属经纪人-姓名", C.STRING);
        table.addColumn("my_agent_id", "所属代理商-ID", C.BIGINT);
        table.addColumn("my_agent_name", "所属代理商-姓名", C.STRING);
        // 开户
        table.addColumn("open_account_realname", "开户-姓名", C.STRING);
        table.addColumn("open_account_identity_card_number", "开户-身份证号", C.STRING);
        table.addColumn("open_account_picture_url", "开户-手持身份证正面照URL", C.STRING);
        table.addColumn("open_account_agreements", "开户-签订协议", C.STRING);
        table.addColumn("open_account_sign_url", "开户-签名图片URL", C.STRING);
        table.addColumn("open_account_status", "开户-状态", C.INT);
        table.addColumn("open_account_audit_user_id", "开户-审核人-ID", C.BIGINT);
        table.addColumn("open_account_audit_user_name", "开户-审核人-姓名", C.STRING);
        table.addColumn("open_account_audit_timestamp", "开户-审核时间戳", C.BIGINT);
        table.addColumn("open_account_audit_fail_reason", "开户-审核失败-原因", C.INT);
        // 经纪人申请
        table.addColumn("broker_request_agreements", "经纪人申请-签订协议", C.STRING);
        table.addColumn("broker_request_sign_url", "经纪人申请-签名图片URL", C.STRING);
        table.addColumn("broker_request_status", "经纪人申请-状态", C.INT);
        table.addColumn("broker_request_audit_user_id", "经纪人申请-审核人-ID", C.BIGINT);
        table.addColumn("broker_request_audit_user_name", "经纪人申请-审核人-姓名", C.STRING);
        table.addColumn("broker_request_audit_timestamp", "经纪人申请-审核时间戳", C.BIGINT);
        table.addColumn("broker_request_audit_fail_reason", "经纪人申请-审核失败-原因", C.INT);
        // 交易大师
        table.addColumn("master_trader_total_profit", "交易大师-总盈利", C.STRING);
        table.addColumn("master_trader_single_profit", "交易大师-均单盈利", C.STRING);
        table.addColumn("master_trader_success_rate", "交易大师-成功率", C.STRING);
        // 主键
        table.addPKColumn("id", "主键", C.AUTOINC);
        // 唯一索引
        table.addUniqueIndex("phone");
        table.addUniqueIndex("token");
        migration.run(connection);
    }
}