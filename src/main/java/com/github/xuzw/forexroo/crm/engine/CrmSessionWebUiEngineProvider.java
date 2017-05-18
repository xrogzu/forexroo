package com.github.xuzw.forexroo.crm.engine;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.xuzw.forexroo.crm.engine.web.CrmUri;
import com.github.xuzw.forexroo.crm.ui.login.LoginPage;
import com.github.xuzw.forexroo.crm.ui.login.ajax.LoginFormPage;
import com.github.xuzw.ui_engine_runtime.UiEngine;
import com.github.xuzw.ui_engine_runtime.impl.CommonUiEngine;
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
        List<ExternalStyleSheet> commonExternalStyleSheets = new ArrayList<>();
        commonExternalStyleSheets.add(new ExternalStyleSheet(CrmUri.of("/tooltipster/css/tooltipster.bundle.min.css")));
        commonExternalStyleSheets.add(new ExternalStyleSheet(CrmUri.of("/tooltipster/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-light.min.css")));
        commonExternalStyleSheets.add(new ExternalStyleSheet(CrmUri.of("/style/default.css")));
        // ----
        List<ExternalScript> commonExternalScripts = new ArrayList<>();
        commonExternalScripts.add(new ExternalScript(CrmUri.of("/script/cookie.js")));
        commonExternalScripts.add(new ExternalScript(CrmUri.of("/script/jquery-3.2.1.js")));
        commonExternalScripts.add(new ExternalScript(CrmUri.of("/script/startswith.js")));
        commonExternalScripts.add(new ExternalScript(CrmUri.of("/tooltipster/js/tooltipster.bundle.js")));
        commonExternalScripts.add(new ExternalScript(CrmUri.of("/script/tooltip.js")));
        commonExternalScripts.add(new ExternalScript(CrmUri.of("/script/ui-engine.js")));
        // ----
        CommonUiEngine commonUiEngine = new CommonUiEngine(commonExternalStyleSheets, commonExternalScripts);
        addPages(commonUiEngine);
        addAjaxPages(commonUiEngine);
        return commonUiEngine;
    }

    private void addPages(CommonUiEngine engine) {
        engine.addPage(new LoginPage());
    }

    private void addAjaxPages(CommonUiEngine engine) {
        engine.addPage(new LoginFormPage());
    }
}
