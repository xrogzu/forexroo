package com.github.xuzw.forexroo.crm.engine.script;

import com.github.xuzw.ui_engine_runtime.script.Script;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午4:31:52
 */
public class Tooltip extends Script {
    public Tooltip(String id, String title) {
        super(String.format("tooltip('%s', '%s');", id, title));
    }
}
