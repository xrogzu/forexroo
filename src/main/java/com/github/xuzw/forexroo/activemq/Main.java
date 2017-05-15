package com.github.xuzw.forexroo.activemq;

import java.util.UUID;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月4日 下午3:33:18
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String url = "failover:tcp://119.23.62.18:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        Destination requestDest = session.createTopic("History_Rates_Info_Topic");
        // Queue requestDest = session.createQueue("xuzw_test");
        MessageProducer producer = session.createProducer(requestDest);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        JSONObject json = new JSONObject();
        String uuid = UUID.randomUUID().toString();
        json.put("reqid", uuid);
        json.put("symbol", "EURUSD");
        json.put("period", 1);
        json.put("fromtime", 1493888947);
        json.put("endtime", 1493891409);
        BytesMessage bytesMessage = session.createBytesMessage();
        bytesMessage.writeBytes(json.toJSONString().getBytes());
        producer.send(bytesMessage);
        session.commit();
        System.out.println("Sent message: ");

    }
}
