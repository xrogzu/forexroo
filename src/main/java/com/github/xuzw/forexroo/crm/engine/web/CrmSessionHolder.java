package com.github.xuzw.forexroo.crm.engine.web;

import javax.servlet.http.HttpSession;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午3:20:33
 */
public class CrmSessionHolder {
    private static ThreadLocal<HttpSession> threadLocal = new ThreadLocal<>();

    public static HttpSession get() {
        return threadLocal.get();
    }

    public static void set(HttpSession httpSession) {
        threadLocal.set(httpSession);
    }
}
