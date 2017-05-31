package com.github.xuzw.forexroo.crm.ui.main.dealer.table.paging;

import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月31日 下午2:01:01
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-left", value = "4px"), //
        }), @StyleBlockAnnotation(selector = ">input[type=button]", value = { //
                @StyleDeclarationAnnotation(property = "height", value = "32px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #bbbbbb"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
                @StyleDeclarationAnnotation(property = "color", value = "#666666"), //
                @StyleDeclarationAnnotation(property = "font-size", value = "14px"), //
                @StyleDeclarationAnnotation(property = "outline", value = "none"), //
        }), @StyleBlockAnnotation(selector = ">input[type=button]:hover", value = { //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #ff6350"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ff6350"), //
                @StyleDeclarationAnnotation(property = "color", value = "#ffffff"), //
        }), })
public abstract class ControlButton extends Div {
}
