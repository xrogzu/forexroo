package com.github.xuzw.forexroo.crm.engine;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午6:38:35
 */
public class CrmUri {
    private static String contextPath;

    public static String of(String path) {
        return contextPath + path;
    }

    public static String getContextPath() {
        return contextPath;
    }

    public static void setContextPath(String contextPath) {
        CrmUri.contextPath = contextPath;
    }
}
