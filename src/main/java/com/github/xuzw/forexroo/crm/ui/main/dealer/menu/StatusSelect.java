package com.github.xuzw.forexroo.crm.ui.main.dealer.menu;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午1:37:03
 */
@StyleAnnotation()
public class StatusSelect extends Select {
    @Override
    protected void build(HtmlBuilder div) {
        div.label().child("span").text("状态：");
        HtmlBuilder select = div.child("select");
        select.child("option").text("正常");
        select.child("option").text("禁用");
    }
}
