package com.github.xuzw.forexroo.crm.engine.script;

import com.github.xuzw.ui_engine_runtime.script.Script;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午2:31:39
 */
public class AjaxLoad extends Script {
    public AjaxLoad(String selector, String url) {
        super(String.format("$('%s').load('%s');", selector, url));
    }
}
