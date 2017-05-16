package com.github.xuzw.forexroo.crm.div.login.input;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:28:43
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation(selector = ">input", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "324px"), //
                @StyleDeclarationAnnotation(property = "height", value = "48px"), //
                @StyleDeclarationAnnotation(property = "padding-left", value = "16px"), //
                @StyleDeclarationAnnotation(property = "padding-right", value = "16px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #eeeeee"), //
        }), @StyleBlockAnnotation(selector = ">input::-webkit-input-placeholder", value = { //
                @StyleDeclarationAnnotation(property = "color", value = "#bbbbbb"), //
        }) })
public class VerificationCode extends Input {

    public VerificationCode() {
        super(VerificationCode.class.getName());
    }

    @Override
    protected void buildInput(HtmlBuilder input) {
        input.attr("placeholder", "请输入验证码").attr("maxlength", "5");
    }

}
