package com.github.xuzw.forexroo.crm.div.login.input;

import com.github.xuzw.forexroo.crm.engine.InputId;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:18:45
 */
@StyleAnnotation
public class Phone extends Input {

    public Phone() {
        super(InputId.of(Phone.class));
    }

    @Override
    protected void buildInput(HtmlBuilder input) {
        input.attr("placeholder", "请输入登录手机号");
    }

}
