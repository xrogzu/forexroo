package com.github.xuzw.forexroo.crm.engine;

import com.github.xuzw.ui_engine_runtime.div.location.ClassName;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午5:04:27
 */
public class InputId {
    public static String of(Class<?> clz) {
        return ClassName.of(clz);
    }
}
