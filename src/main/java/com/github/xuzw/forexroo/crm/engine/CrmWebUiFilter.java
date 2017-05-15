package com.github.xuzw.forexroo.crm.engine;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.ui_engine_runtime_http_wrapper.AbstractWebUiEngineRuntimeHttpFilter;
import com.github.xuzw.ui_engine_runtime_http_wrapper.provider.AbstractSessionWebUiEngineProvider;
import com.github.xuzw.ui_engine_runtime_http_wrapper.provider.WebUiEngineProvider;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午4:54:15
 */
@WebFilter("/ui/*")
public class CrmWebUiFilter extends AbstractWebUiEngineRuntimeHttpFilter {
    private Logger logger = LoggerFactory.getLogger(CrmWebUiFilter.class);
    private AbstractSessionWebUiEngineProvider sessionWebUiEngineProvider = new CrmSessionWebUiEngineProvider();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init");
    }

    @Override
    public void destroy() {
        logger.info("destroy");
    }

    @Override
    protected WebUiEngineProvider getWebUiEngineProvider() {
        return sessionWebUiEngineProvider;
    }
}
