package com.github.xuzw.forexroo.crm.ui.main.dealer.table.paging;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午5:22:08
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-left", value = "4px"), //
        }), @StyleBlockAnnotation(selector = ">label", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "30px"), //
                @StyleDeclarationAnnotation(property = "height", value = "30px"), //
                @StyleDeclarationAnnotation(property = "line-height", value = "30px"), //
                @StyleDeclarationAnnotation(property = "text-align", value = "center"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #bbbbbb"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
                @StyleDeclarationAnnotation(property = "color", value = "#666666"), //
                @StyleDeclarationAnnotation(property = "display", value = "inline-block"), //
                @StyleDeclarationAnnotation(property = "font-size", value = "14px"), //
        }), @StyleBlockAnnotation(selector = ">label:hover", value = { //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #ff6350"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ff6350"), //
                @StyleDeclarationAnnotation(property = "color", value = "#ffffff"), //
        }), @StyleBlockAnnotation(selector = ">input[type=radio]", value = { //
                @StyleDeclarationAnnotation(property = "display", value = "none"), //
        }), @StyleBlockAnnotation(selector = ">input[type=radio]:checked ~ label", value = { //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #ff6350"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ff6350"), //
                @StyleDeclarationAnnotation(property = "color", value = "#ffffff"), //
        }), })
public class PagingButton extends Div {
    private int pageIndex;

    public PagingButton(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    protected void build(HtmlBuilder div) {
        String radioId = "paging-radio-" + getId();
        div.input().attr("type", "radio").id(radioId).attr("name", "pagingRadio");
        div.label().attr("for", radioId).text(String.valueOf(pageIndex + 1));
    }
}
