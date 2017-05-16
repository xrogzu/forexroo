package com.github.xuzw.forexroo.crm.div.login;

import com.github.xuzw.forexroo.crm.div.login.button.Login;
import com.github.xuzw.forexroo.crm.div.login.input.Password;
import com.github.xuzw.forexroo.crm.div.login.input.Phone;
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
        add(new Phone());
        add(new Password());
        add(new VerificationCodeContainer());
        add(new Login());
    }
}
