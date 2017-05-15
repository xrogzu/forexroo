package com.github.xuzw.forexroo.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月28日 下午2:31:54
 */
public class MarketQuotationConsumer {
    private static final Logger log = LoggerFactory.getLogger(MarketQuotationConsumer.class);

    public MarketQuotationConsumer() throws JMSException {
        String url = "failover:tcp://119.23.62.18:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Topic destination = session.createTopic("Market_Data_Info_Topic");
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    log.info(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                try {
                    session.commit();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
