package com.github.xuzw.forexroo.crm.engine.script;

import com.github.xuzw.ui_engine_runtime.script.Script;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月29日 下午5:28:01
 */
public class GotoPage extends Script {
    public GotoPage(String href) {
        super(String.format("window.location.href = '%s';", href));
    }
}
