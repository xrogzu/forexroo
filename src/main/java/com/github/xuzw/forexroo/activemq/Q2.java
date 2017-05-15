package com.github.xuzw.forexroo.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月4日 下午3:50:06
 */
public class Q2 {
    public static void main(String[] args) throws Exception {
        String url = "failover:tcp://119.23.62.18:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        Destination responseDest = session.createTopic("History_Rates_Info_Result_Topic");
        // Destination responseDest = session.createQueue("xuzw_test");
        MessageConsumer consumer = session.createConsumer(responseDest);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                try {
                    TextMessage m = (TextMessage) message;
                    System.out.println("Received message: " + m.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // ActiveMQBytesMessage m = (ActiveMQBytesMessage) message;
                // byte[] data = m.getContent().getData();
                // System.out.println("Received message: " + data.length);
                // System.out.println("Received message: " + new String(data));
            }
        });

    }
}
