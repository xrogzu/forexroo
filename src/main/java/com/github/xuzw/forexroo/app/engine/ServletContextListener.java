package com.github.xuzw.forexroo.app.engine;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.forexroo.database.Druid;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月5日 下午6:24:03
 */
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(ServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized");
        Druid.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed");
    }
}
