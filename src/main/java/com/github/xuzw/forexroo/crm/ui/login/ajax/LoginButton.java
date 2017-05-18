package com.github.xuzw.forexroo.crm.ui.login.ajax;

import com.github.xuzw.forexroo.crm.ui.login.LoginForm;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;
import com.github.xuzw.ui_engine_runtime.div.ajax.DynamicDiv;
import com.github.xuzw.ui_engine_runtime.page.PageName;
import com.github.xuzw.ui_engine_runtime.script.AjaxScript;

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
public class LoginButton extends Div {
    @Override
    protected void build(HtmlBuilder div) {
        div.button().value("登录").onClick(new AjaxScript(PageName.of(LoginFormPage.class), DynamicDiv.id(LoginForm.class)).toString());
    }
}
