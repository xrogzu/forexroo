package com.github.xuzw.forexroo.crm.ui.login.ajax;

import java.util.Optional;

import com.github.xuzw.captcha.CaptchaServlet;
import com.github.xuzw.forexroo.crm.engine.script.GotoPage;
import com.github.xuzw.forexroo.crm.engine.script.Tooltip;
import com.github.xuzw.forexroo.crm.engine.web.CrmSessionHolder;
import com.github.xuzw.forexroo.crm.ui.login.input.VerificationCodeInput;
import com.github.xuzw.forexroo.crm.ui.main.MainPage;
import com.github.xuzw.ui_engine_runtime.div.location.Id;
import com.github.xuzw.ui_engine_runtime.input.Input;
import com.github.xuzw.ui_engine_runtime.input.Inputs;
import com.github.xuzw.ui_engine_runtime.page.PageName;
import com.github.xuzw.ui_engine_runtime.page.ScriptPage;
import com.github.xuzw.ui_engine_runtime.script.JQueryDocumentReadyCallback;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 上午10:56:09
 */
public class LoginScriptPage extends ScriptPage {
    public LoginScriptPage() {
        super(PageName.of(LoginScriptPage.class));
    }

    @Override
    protected void onFilter(Inputs inputs) {
        String captcha = (String) CrmSessionHolder.get().getAttribute(CaptchaServlet.CAPTCHA_KEY);
        Optional<Input> verificationCode = inputs.get(Id.of(VerificationCodeInput.class));
        if (!verificationCode.isPresent()) {
            addScript(new JQueryDocumentReadyCallback(new Tooltip(Id.of(VerificationCodeInput.class), "请输入验证码")));
            return;
        }
        if (!captcha.equals(verificationCode.get().getValue())) {
            addScript(new JQueryDocumentReadyCallback(new Tooltip(Id.of(VerificationCodeInput.class), "验证码不正确")));
            return;
        }
        addScript(new GotoPage(PageName.of(MainPage.class)));
    }
}
