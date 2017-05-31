package com.github.xuzw.forexroo.crm.ui.main.dealer.menu;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午3:08:48
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-top", value = "14px"), //
        }), @StyleBlockAnnotation(selector = ">label>span", value = { //
                @StyleDeclarationAnnotation(property = "margin-left", value = "16px"), //
                @StyleDeclarationAnnotation(property = "width", value = "43px"), //
                @StyleDeclarationAnnotation(property = "height", value = "17px"), //
                @StyleDeclarationAnnotation(property = "font-size", value = "14px"), //
                @StyleDeclarationAnnotation(property = "font-weight", value = "500"), //
                @StyleDeclarationAnnotation(property = "color", value = "#666666"), //
        }), @StyleBlockAnnotation(selector = ">select", value = { //
                @StyleDeclarationAnnotation(property = "height", value = "28px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #cccccc"), //
                @StyleDeclarationAnnotation(property = "outline", value = "none"), //
        }), })
public abstract class Select extends Div {
    @Override
    protected void build(HtmlBuilder div) {
    }
}
