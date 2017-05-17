package com.github.xuzw.forexroo.crm.div.login.event;

import java.util.Optional;

import com.github.xuzw.captcha.CaptchaServlet;
import com.github.xuzw.forexroo.crm.div.login.input.VerificationCode;
import com.github.xuzw.forexroo.crm.script.DocumentReadyCallback;
import com.github.xuzw.forexroo.crm.script.Tooltip;
import com.github.xuzw.forexroo.crm.web.CrmSessionHolder;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.ClickEventDiv;
import com.github.xuzw.ui_engine_runtime.div.location.Id;
import com.github.xuzw.ui_engine_runtime.event.ClickEvent;
import com.github.xuzw.ui_engine_runtime.input.Input;
import com.github.xuzw.ui_engine_runtime.page.Header;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午11:30:52
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "356px"), //
                @StyleDeclarationAnnotation(property = "margin-top", value = "20px"), //
                @StyleDeclarationAnnotation(property = "margin-bottom", value = "0px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "auto"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "auto"), //
        }), @StyleBlockAnnotation(selector = "input", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "100%"), //
                @StyleDeclarationAnnotation(property = "height", value = "48px"), //
                @StyleDeclarationAnnotation(property = "padding", value = "0px"), //
                @StyleDeclarationAnnotation(property = "border-radius", value = "3px"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #eeeeee"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#f5f5f5"), //
                @StyleDeclarationAnnotation(property = "color", value = "#666666"), //
                @StyleDeclarationAnnotation(property = "box-sizing", value = "content-box"), //
        }), @StyleBlockAnnotation(selector = "input:hover", value = { //
                @StyleDeclarationAnnotation(property = "background-color", value = "#eeeeee"), //
        }) })
public class Login extends ClickEventDiv {

    public Login() {
        super(Event.class);
    }

    @Override
    protected void buildClickEventDiv(HtmlBuilder clickEventDiv) {
        clickEventDiv.button().value("登录");
    }

    public static class Event extends ClickEvent {
        @Override
        public void onClick() {
            Header header = getSource().getHeader();
            String captcha = (String) CrmSessionHolder.get().getAttribute(CaptchaServlet.CAPTCHA_KEY);
            Optional<Input> verificationCode = getInputs().get(Id.of(VerificationCode.class));
            if (!verificationCode.isPresent()) {
                header.addScript(new DocumentReadyCallback(new Tooltip(Id.of(VerificationCode.class), "请输入验证码")));
                return;
            }
            if (!captcha.equals(verificationCode.get().getValue())) {
                header.addScript(new DocumentReadyCallback(new Tooltip(Id.of(VerificationCode.class), "验证码不正确")));
                return;
            }
        }
    }
}
