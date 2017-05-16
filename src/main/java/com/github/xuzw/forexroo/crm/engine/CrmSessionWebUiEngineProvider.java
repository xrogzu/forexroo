package com.github.xuzw.forexroo.crm.engine;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.xuzw.ui_engine_runtime.UiEngine;
import com.github.xuzw.ui_engine_runtime.script.ExternalScript;
import com.github.xuzw.ui_engine_runtime.style.ExternalStyleSheet;
import com.github.xuzw.ui_engine_runtime_http_wrapper.provider.AbstractSessionWebUiEngineProvider;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午4:52:26
 */
public class CrmSessionWebUiEngineProvider extends AbstractSessionWebUiEngineProvider {

    @Override
    public UiEngine newInstance(HttpSession session) {
        List<ExternalStyleSheet> externalStyleSheets = new ArrayList<>();
        externalStyleSheets.add(new ExternalStyleSheet(CrmUri.of("/style/default.css")));
        // ----
        List<ExternalScript> externalScripts = new ArrayList<>();
        externalScripts.add(new ExternalScript(CrmUri.of("/script/startswith.js")));
        externalScripts.add(new ExternalScript(CrmUri.of("/script/cookie.js")));
        externalScripts.add(new ExternalScript(CrmUri.of("/script/ui-engine.js")));
        // ----
        return new CrmWebUiEngine(externalStyleSheets, externalScripts);
    }
}
