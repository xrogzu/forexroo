package com.github.xuzw.forexroo.crm.div.login.input;

import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.InputDiv;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:23:59
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "356px"), //
                @StyleDeclarationAnnotation(property = "height", value = "48px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-bottom", value = "0px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "auto"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "auto"), //
        }), @StyleBlockAnnotation(selector = ">input", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "324px"), //
                @StyleDeclarationAnnotation(property = "height", value = "100%"), //
                @StyleDeclarationAnnotation(property = "padding-left", value = "16px"), //
                @StyleDeclarationAnnotation(property = "padding-right", value = "16px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #eeeeee"), //
        }), @StyleBlockAnnotation(selector = ">input::-webkit-input-placeholder", value = { //
                @StyleDeclarationAnnotation(property = "color", value = "#bbbbbb"), //
        }) })
public class Input extends InputDiv {

    public Input(String inputId) {
        super(inputId);
    }
}
