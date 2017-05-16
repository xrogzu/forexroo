package com.github.xuzw.forexroo.crm.engine;

import javax.servlet.annotation.WebServlet;

import com.github.xuzw.ui_engine_runtime_http_wrapper.AbstractWebUiEngineRuntimeHttpServlet;
import com.github.xuzw.ui_engine_runtime_http_wrapper.provider.AbstractSessionWebUiEngineProvider;
import com.github.xuzw.ui_engine_runtime_http_wrapper.provider.WebUiEngineProvider;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午4:54:15
 */
@WebServlet("/ui/*")
public class CrmWebUiHttpServlet extends AbstractWebUiEngineRuntimeHttpServlet {
    private static final long serialVersionUID = 1L;
    private AbstractSessionWebUiEngineProvider sessionWebUiEngineProvider = new CrmSessionWebUiEngineProvider();

    @Override
    protected WebUiEngineProvider getWebUiEngineProvider() {
        return sessionWebUiEngineProvider;
    }
}
