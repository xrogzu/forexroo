package com.github.xuzw.forexroo.crm.ui.main.dealer.menu;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午2:59:01
 */
@StyleAnnotation()
public class CategorySelect extends Select {
    @Override
    protected void build(HtmlBuilder div) {
        div.label().child("span").text("选择归属：");
        HtmlBuilder selectAgent = div.child("select");
        selectAgent.child("option").text("选择代理商");
        selectAgent.child("option").text("禁用");
        div.child("span").attr("style", "color:#666666;").text("-");
        HtmlBuilder selectBroker = div.child("select");
        selectBroker.child("option").text("选择经纪人");
        selectBroker.child("option").text("禁用");
    }
}
