package com.github.xuzw.forexroo.crm.ui.main.dealer.table.paging;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午5:03:40
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-top", value = "4px"), //
        }), @StyleBlockAnnotation(selector = ">span", value = { //
                @StyleDeclarationAnnotation(property = "font-size", value = "14px"), //
                @StyleDeclarationAnnotation(property = "color", value = "#4a4a4a"), //
                @StyleDeclarationAnnotation(property = "height", value = "19px"), //
        }), })
public class PagingTip extends Div {

    @Override
    protected void build(HtmlBuilder div) {
        div.child("span").text("共1234条记录，共50页，当前第一页");
    }
}
