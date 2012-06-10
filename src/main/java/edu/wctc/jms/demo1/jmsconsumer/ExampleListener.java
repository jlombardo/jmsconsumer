package edu.wctc.jms.demo1.jmsconsumer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class ExampleListener implements MessageListener {
	
    public void onMessage(Message message) {
//        if (message instanceof TextMessage) {
        if (message instanceof MapMessage) {
            try {
//                System.out.println(((TextMessage) message).getText());
            	MapMessage mapMsg = ((MapMessage) message);
            	String msgID = mapMsg.getJMSCorrelationID();
            	String name = mapMsg.getString("Name");
            	String note = mapMsg.getString("Note");
            	System.out.println("Message ID: " + msgID);
            	System.out.println("Name: " + name);
            	System.out.println("Note: " + note);
            	System.out.println("-----------------");
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }

    
    
}