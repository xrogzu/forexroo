package com.github.xuzw.forexroo.crm.div.login;

import com.github.xuzw.forexroo.crm.engine.CrmUri;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:08:41
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "96px"), //
                @StyleDeclarationAnnotation(property = "height", value = "96px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "60px"), //
                @StyleDeclarationAnnotation(property = "margin-bottom", value = "0px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "auto"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "auto"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "20px"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#fc412b"), //
        }) })
public class Logo extends Div {

    @Override
    protected void build(HtmlBuilder div) {
        div.child("img").src(CrmUri.of("/icon/logo.svg"));
    }
}
