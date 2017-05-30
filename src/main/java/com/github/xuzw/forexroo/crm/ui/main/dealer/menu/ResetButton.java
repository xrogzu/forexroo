package com.github.xuzw.forexroo.crm.ui.main.dealer.menu;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午3:17:42
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-top", value = "14px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "8px"), //
        }), @StyleBlockAnnotation(selector = ">input", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "44px"), //
                @StyleDeclarationAnnotation(property = "height", value = "28px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #cccccc"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
        }), })
public class ResetButton extends Div {

    @Override
    protected void build(HtmlBuilder div) {
        div.button().value("重置");
    }
}
