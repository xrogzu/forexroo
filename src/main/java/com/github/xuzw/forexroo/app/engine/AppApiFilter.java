package com.github.xuzw.forexroo.app.engine;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.api_engine_runtime_http_wrapper.ApiEngineRuntimeHttpWrapper;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午6:45:41
 */
@WebFilter(urlPatterns = "/app/api/*", initParams = @WebInitParam(name = ApiEngineRuntimeHttpWrapper.init_param_name_auto_scan_package, value = "com.github.xuzw.forexroo.app.api"))
public class AppApiFilter extends ApiEngineRuntimeHttpWrapper {
    private Logger logger = LoggerFactory.getLogger(AppApiFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init");
        super.init(filterConfig);
        AppApiEngineHolder.set(getEngine());
    }
}
