package com.github.xuzw.forexroo.crm.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.ui_engine_sdk.ScriptGeneratorUtils;
import com.github.xuzw.ui_engine_sdk.StyleGeneratorUtils;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月15日 下午4:55:13
 */
@WebListener
public class CrmServletContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(CrmServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        log.info("contextInitialized");
        try {
            ServletContext context = event.getServletContext();
            CrmUri.setContextPath(context.getContextPath());
            StyleGeneratorUtils.updateCssFiles(context.getRealPath("style"));
            ScriptGeneratorUtils.updateScriptFile(context.getRealPath("script/ui-engine.js"));
        } catch (IOException e) {
            log.error("", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed");
    }
}
