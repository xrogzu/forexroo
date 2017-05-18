package com.github.xuzw.forexroo.crm.ui.main.ajax;

import com.github.xuzw.forexroo.crm.engine.web.CrmUri;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午6:11:40
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "16px"), //
                @StyleDeclarationAnnotation(property = "height", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "12px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "16px"), //
        }), @StyleBlockAnnotation(selector = "img", value = { //
        }), })
public class SubNavSwitch extends Div {

    @Override
    protected void build(HtmlBuilder div) {
        div.child("img").src(CrmUri.of("/icon/arrow.svg"));
    }
}
