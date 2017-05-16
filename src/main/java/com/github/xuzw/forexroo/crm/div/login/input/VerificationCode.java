package com.github.xuzw.forexroo.crm.div.login.input;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:28:43
 */
@StyleAnnotation
public class VerificationCode extends Input {

    public VerificationCode() {
        super(VerificationCode.class.getName());
    }

    @Override
    protected void buildInput(HtmlBuilder input) {
        input.attr("placeholder", "请输入验证码").attr("maxlength", "5");
    }

}
