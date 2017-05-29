package com.github.xuzw.forexroo.crm.ui.login;

import com.github.xuzw.ui_engine_runtime.page.Page;
import com.github.xuzw.ui_engine_runtime.page.PageName;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 上午11:06:29
 */
public class LoginPage extends Page {
    public LoginPage() {
        super(PageName.of(LoginPage.class));
        title("登录").body(new Background(new LoginForm()));
    }
}
