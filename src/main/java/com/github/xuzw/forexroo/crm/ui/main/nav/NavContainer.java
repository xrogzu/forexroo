package com.github.xuzw.forexroo.crm.ui.main.nav;

import com.github.xuzw.forexroo.crm.ui.main.nav.nav_group.NavFolder;
import com.github.xuzw.forexroo.crm.ui.main.nav.nav_group.NavGroup;
import com.github.xuzw.forexroo.crm.ui.main.nav.nav_group.SubNav;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.YList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午6:55:28
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "200px"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#252834"), //
        }), })
public class NavContainer extends YList {
    public NavContainer() {
        add(new Nav("/icon/home.svg", "首页"));
        add(new NavGroup(new NavFolder("/icon/user.svg", "用户管理")).add(new SubNav("交易商")).add(new SubNav("经纪人")).add(new SubNav("代理商")));
        add(new Nav("/icon/order.svg", "订单管理"));
        add(new NavGroup(new NavFolder("/icon/trade.svg", "交易管理")).add(new SubNav("交易大师")).add(new SubNav("复制交易")).add(new SubNav("机构交易")));
        add(new NavGroup(new NavFolder("/icon/audit.svg", "审核管理")).add(new SubNav("交易商开户申请审核")).add(new SubNav("经纪人申请审核")).add(new SubNav("交易商出金审核")).add(new SubNav("代理商出金审核")));
        add(new NavGroup(new NavFolder("/icon/risk.svg", "风险监控")).add(new SubNav("交易商监控")).add(new SubNav("持仓监控")));
        add(new NavGroup(new NavFolder("/icon/money.svg", "资金管理")).add(new SubNav("交易商出入金")).add(new SubNav("代理商出金")));
        add(new NavGroup(new NavFolder("/icon/commission.svg", "返佣管理")).add(new SubNav("经纪人记录")).add(new SubNav("返佣设置")));
        add(new NavGroup(new NavFolder("/icon/control.svg", "控制管理")).add(new SubNav("管理员列表")).add(new SubNav("权限组管理")));
        add(new NavGroup(new NavFolder("/icon/message.svg", "消息管理")).add(new SubNav("提示设置")));
        add(new Nav("/icon/system.svg", "系统管理"));
        add(new Nav("/icon/log.svg", "日志管理"));
    }
}
