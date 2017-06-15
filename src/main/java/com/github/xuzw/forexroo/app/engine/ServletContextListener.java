package com.github.xuzw.forexroo.app.engine;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.apache.activemq.ActiveMQConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.activemq_utils.ActiveMq;
import com.github.xuzw.forexroo.app.service.QuotedPriceService;
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
        try {
            String brokerUrl = "failover:tcp://119.23.62.18:61616";
            List<String> responseTopics = new ArrayList<>();
            responseTopics.add("History_Rates_Info_Result_Topic");
            responseTopics.add("Register_User_Info_Result_Topic");
            responseTopics.add("Get_Tick_Last_Result_Topic");
            responseTopics.add("Get_User_Info_Result_Topic");
            responseTopics.add("Deposit_User_Info_Result_Topic");
            ActiveMq.init(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, brokerUrl, responseTopics);
            ActiveMq.onMessage("Market_Data_Info_Topic", x -> {
                QuotedPriceService.putBid(x.getString("symbol"), x.getString("bid"));
            });
        } catch (JMSException e) {
            log.error("", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed");
    }
}
