package com.github.xuzw.forexroo.app.utils;

import com.github.xuzw.api_engine_runtime.impl.AutoScanEngine;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午7:44:16
 */
public class AppApiEngineHolder {
    private static AutoScanEngine engine;

    public static AutoScanEngine get() {
        return engine;
    }

    public static void set(AutoScanEngine engine) {
        AppApiEngineHolder.engine = engine;
    }
}
