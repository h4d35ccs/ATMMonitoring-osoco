package com.ncr.ATMMonitoring.updatequeue;

import java.util.Enumeration;
import java.util.LinkedList;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.updatequeue.exception.QueueBrowsingException;

/**
 * 
 * Class that allow browsing operation over the ATM Update JMS Queue
 * @author Otto Abreu
 * 
 */
@Component
public class ATMUpdateQueueBrowser {

    @Autowired
    private JmsTemplate atmUpdateJmsTemplate;

    /**
     * 
     * Returns the size of the queue
     * 
     * @return int

     */
    public int queueSize()  {


	int size = 0;
	
	try {
	  
	    size = getSize();
	
	} catch (JMSException e) {
	   
	    throw new QueueBrowsingException(QueueBrowsingException.GET_QUEUE_SIZE_ERROR+e.getMessage(),e);
	}
	
	return size;

    }
    
    
    private int getSize() throws JMSException{
	Enumeration<ActiveMQObjectMessage> queueElements = this.extractEnumerationFromBrowser();
	int size = this.countElementsInEnumeration(queueElements);
	return size;
    }

    private int countElementsInEnumeration(Enumeration<ActiveMQObjectMessage> queueElements) {
	int count = 0;

	while (queueElements.hasMoreElements()) {
	    count++;
	    queueElements.nextElement();
	}
	return count;
    }

        
    
    private QueueBrowser getQueueBrowser() {
	final QueueBrowser browser = this.atmUpdateJmsTemplate.execute(
		new SessionCallback<QueueBrowser>() {

		    public QueueBrowser doInJms(Session session)
			    throws JMSException {

			return session.createBrowser((Queue) atmUpdateJmsTemplate
				.getDefaultDestination());
		    }
		}, true);

	return browser;
    }
        

    /**
     * Returns an Snapshot of the elements in the JMS Queue as a  java.util.Queue<ATMUpdateInfo>
     * 
     * @return java.util.Queue<ATMUpdateInfo> 
     */
    public  java.util.Queue<ATMUpdateInfo> getQueueCopy(){
	
	java.util.Queue<ATMUpdateInfo> queueElements = null;
	
	try{
	    
	    queueElements = this.getQueueFromEnumeration();
	    
	
	
	} catch (IllegalStateException e){
	   //the session could be closed, so we try again to get the elements
		queueElements = this.getQueueFromEnumeration();
	   
	}
	
	return  queueElements;
    }
    
    private java.util.Queue<ATMUpdateInfo> getQueueFromEnumeration(){
	
	java.util.Queue<ATMUpdateInfo> queueElements = null;
	
	try {
		
		queueElements = this.switchElementsFromEnumerationToList();
	   
	    } catch (JMSException e) {
		
		 throw new QueueBrowsingException(QueueBrowsingException.GET_QUEUE_ERROR+e.getMessage(),e);
	    }
	
	return queueElements;
    }
    
    
    private java.util.Queue<ATMUpdateInfo> switchElementsFromEnumerationToList() throws JMSException{
	
	Enumeration<ActiveMQObjectMessage> elements = this.extractEnumerationFromBrowser();
	
	java.util.Queue<ATMUpdateInfo> queueElements = new LinkedList<ATMUpdateInfo>();
	
	while(elements.hasMoreElements()){
	   
	    ActiveMQObjectMessage objMessage = elements.nextElement();
	    ATMUpdateInfo info = (ATMUpdateInfo) objMessage.getObject();
	    queueElements.add(info);
	}
	
	return queueElements;
    }
    
    @SuppressWarnings("unchecked")
    private Enumeration<ActiveMQObjectMessage> extractEnumerationFromBrowser() throws JMSException{
	
	QueueBrowser browser = this.getQueueBrowser();
	return (Enumeration<ActiveMQObjectMessage>)browser.getEnumeration();
    }

    

}
