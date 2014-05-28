package com.ncr.ATMMonitoring.updatequeue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Component;


/**
 * Class that extracts an update information message from the queue 
 * @author Otto Abreu
 * 
 */
@Component
public class ATMUpdateQueueConsumer {

    @Autowired
    private JmsTemplate atmUpdateJmsTemplate;
    /**
     * Retrieves the first message in the queue
     * @return
     */
    public ATMUpdateInfo receiveUpdateInfo() {
	
	return (ATMUpdateInfo) this.atmUpdateJmsTemplate.receiveAndConvert();
    }
    
    
    /**
     * COnsumes all the messages in the queue
     * @throws JMSException
     */
    public void cleanQueue() throws JMSException{
	 MessageConsumer consumer = this.getQueueConsumer();
	  Message message = null;
	   
	    do {
	        message = consumer.receiveNoWait();
	       
	        if (message != null){
	           
	            message.acknowledge();
	        }
	        
	    } while (message != null);
    }
    
    private MessageConsumer getQueueConsumer() {
   	final MessageConsumer consumer = this.atmUpdateJmsTemplate.execute(
   		new SessionCallback<MessageConsumer>() {

   		    public MessageConsumer doInJms(Session session)
   			    throws JMSException {

   			return session.createConsumer((Queue) atmUpdateJmsTemplate
				.getDefaultDestination());
   		    }
   		}, true);

   	return consumer;
       }
   
}
