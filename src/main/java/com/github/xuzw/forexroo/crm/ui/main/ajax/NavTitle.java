package com.github.xuzw.forexroo.crm.ui.main.ajax;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午6:00:48
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-top", value = "12px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "16px"), //
        }), @StyleBlockAnnotation(selector = "span", value = { //
                @StyleDeclarationAnnotation(property = "font-size", value = "14px"), //
                @StyleDeclarationAnnotation(property = "font-weight", value = "500"), //
                @StyleDeclarationAnnotation(property = "color", value = "#98a6ad"), //
        }), })
public class NavTitle extends Div {
    private String title;

    public NavTitle(String title) {
        this.title = title;
    }

    @Override
    protected void build(HtmlBuilder div) {
        div.child("span").text(title);
    }
}
