package com.github.xuzw.forexroo.crm.div.login;

import com.github.xuzw.forexroo.crm.div.login.clickable.Captcha;
import com.github.xuzw.forexroo.crm.div.login.input.VerificationCode;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午1:22:59
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "356px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-bottom", value = "0px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "auto"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "auto"), //
        }) })
public class VerificationCodeContainer extends XList {
    public VerificationCodeContainer() {
        add(new VerificationCode());
        add(new Captcha());
    }
}
