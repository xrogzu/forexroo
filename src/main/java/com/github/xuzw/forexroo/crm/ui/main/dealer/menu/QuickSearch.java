package com.github.xuzw.forexroo.crm.ui.main.dealer.menu;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午3:23:44
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "height", value = "28px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "14px"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "16px"), //
        }), @StyleBlockAnnotation(selector = ">input[type=text]", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "186px"), //
                @StyleDeclarationAnnotation(property = "height", value = "26px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #cccccc"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
        }), @StyleBlockAnnotation(selector = ">input[type=button]", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "34px"), //
                @StyleDeclarationAnnotation(property = "height", value = "28px"), //
                @StyleDeclarationAnnotation(property = "padding", value = "0px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #ff6350"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ff6350"), //
                @StyleDeclarationAnnotation(property = "box-sizing", value = "content-box"), //
                @StyleDeclarationAnnotation(property = "background-image", value = "url(/forexroo/icon/search.svg)"), //
                @StyleDeclarationAnnotation(property = "background-position", value = "center"), //
                @StyleDeclarationAnnotation(property = "background-repeat", value = "no-repeat"), //
                @StyleDeclarationAnnotation(property = "outline", value = "none"), //
        }), @StyleBlockAnnotation(selector = ">input::-webkit-input-placeholder", value = { //
                @StyleDeclarationAnnotation(property = "color", value = "#bbbbbb"), //
        }), @StyleBlockAnnotation(selector = ">input", value = { //
                @StyleDeclarationAnnotation(property = "vertical-align", value = "middle"), //
        }), })
public class QuickSearch extends Div {

    @Override
    protected void build(HtmlBuilder div) {
        div.input().attr("placeholder", "快速查找（代理商/经纪人）");
        div.button();
    }
}
