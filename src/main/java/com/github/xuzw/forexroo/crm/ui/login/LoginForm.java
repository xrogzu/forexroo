package com.github.xuzw.forexroo.crm.ui.login;

import com.github.xuzw.forexroo.crm.ui.login.ajax.LoginButton;
import com.github.xuzw.forexroo.crm.ui.login.input.PasswordInput;
import com.github.xuzw.forexroo.crm.ui.login.input.PhoneInput;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.YList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午5:38:26
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "850px"), //
                @StyleDeclarationAnnotation(property = "height", value = "628px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "92px"), //
                @StyleDeclarationAnnotation(property = "margin-bottom", value = "92px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "auto"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "auto"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
                @StyleDeclarationAnnotation(property = "overflow", value = "hidden"), //
        }) })
public class LoginForm extends YList {
    public LoginForm() {
        add(new Logo());
        add(new Text());
        add(new PhoneInput());
        add(new PasswordInput());
        add(new VerificationCodeContainer());
        add(new LoginButton());
    }
}
