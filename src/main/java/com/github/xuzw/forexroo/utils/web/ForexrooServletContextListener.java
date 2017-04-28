package com.github.xuzw.forexroo.utils.web;

import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.forexroo.service.MarketQuotationConsumer;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月28日 下午2:27:35
 */
@WebListener
public class ForexrooServletContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(ForexrooServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized");
        try {
            new MarketQuotationConsumer();
        } catch (JMSException e) {
            log.error("", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed");
    }
}
