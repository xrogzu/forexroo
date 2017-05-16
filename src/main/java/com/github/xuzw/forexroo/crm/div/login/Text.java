package com.github.xuzw.forexroo.crm.div.login;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:17:12
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "184px"), //
                @StyleDeclarationAnnotation(property = "height", value = "40px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-bottom", value = "0px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "auto"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "auto"), //
                @StyleDeclarationAnnotation(property = "font-size", value = "20px"), //
                @StyleDeclarationAnnotation(property = "text-align", value = "center"), //
                @StyleDeclarationAnnotation(property = "color", value = "#666666"), //
        }) })
public class Text extends Div {

    @Override
    protected void build(HtmlBuilder div) {
        div.text("微宗宝后台管理系统");
    }
}
