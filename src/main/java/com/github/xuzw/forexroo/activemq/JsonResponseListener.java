package com.github.xuzw.forexroo.activemq;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 上午11:15:56
 */
public class JsonResponseListener {
    private static final Logger log = LoggerFactory.getLogger(JsonResponseListener.class);

    private Session session;
    private RequestCache requestCache;
    private List<String> topics = new ArrayList<>();

    public JsonResponseListener(Session session, RequestCache requestCache, List<String> topics) throws JMSException {
        this.session = session;
        this.topics = topics;
        for (String topic : topics) {
            Destination destination = session.createTopic(topic);
            MessageConsumer messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        TextMessage textMessage = (TextMessage) message;
                        String text = textMessage.getText();
                        JSONObject jsonResponse = JSON.parseObject(text);
                        String requestId = jsonResponse.getString("reqid");
                        JsonResponseCallback callback = requestCache.getIfPresent(requestId);
                        if (callback == null) {
                            log.warn("Expired response, topic={}, requestId={}", topic, requestId);
                        } else {
                            callback.onMessage(jsonResponse);
                        }
                    } catch (Exception e) {
                        log.error("", e);
                    }
                }
            });
        }
    }

    public Session getSession() {
        return session;
    }

    public RequestCache getRequestCache() {
        return requestCache;
    }

    public List<String> getTopics() {
        return topics;
    }
}
