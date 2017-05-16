package com.github.xuzw.forexroo.crm.script;

import com.github.xuzw.ui_engine_runtime.script.Script;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午4:50:36
 */
public class DocumentReadyCallback extends Script {

    public DocumentReadyCallback(Script script) {
        super(build(script));
    }

    private static String build(Script script) {
        StringBuffer sb = new StringBuffer();
        sb.append("$(document).ready(function(){").append(script.toString()).append("});");
        return sb.toString();
    }
}
