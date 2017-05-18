package com.github.xuzw.forexroo.crm.engine.web;

import javax.servlet.annotation.WebServlet;

import com.github.xuzw.captcha.CaptchaServlet;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午12:21:52
 */
@WebServlet("/ui/captcha")
public class CrmCaptchaServlet extends CaptchaServlet {
    private static final long serialVersionUID = 1L;
    private static final String CAPTCHA_CHARS = "1234567890";

    @Override
    public String getCaptchaChars() {
        return CAPTCHA_CHARS;
    }
}
