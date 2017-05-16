package com.github.xuzw.forexroo.crm.engine;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.xuzw.forexroo.crm.web.CrmUri;
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
        externalStyleSheets.add(new ExternalStyleSheet(CrmUri.of("/tooltipster/css/tooltipster.bundle.min.css")));
        externalStyleSheets.add(new ExternalStyleSheet(CrmUri.of("/tooltipster/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-light.min.css")));
        externalStyleSheets.add(new ExternalStyleSheet(CrmUri.of("/style/default.css")));
        // ----
        List<ExternalScript> externalScripts = new ArrayList<>();
        externalScripts.add(new ExternalScript(CrmUri.of("/script/cookie.js")));
        externalScripts.add(new ExternalScript(CrmUri.of("/script/jquery-3.2.1.js")));
        externalScripts.add(new ExternalScript(CrmUri.of("/script/startswith.js")));
        externalScripts.add(new ExternalScript(CrmUri.of("/tooltipster/js/tooltipster.bundle.js")));
        externalScripts.add(new ExternalScript(CrmUri.of("/script/tooltip.js")));
        externalScripts.add(new ExternalScript(CrmUri.of("/script/ui-engine.js")));
        // ----
        return new CrmWebUiEngine(externalStyleSheets, externalScripts);
    }
}
