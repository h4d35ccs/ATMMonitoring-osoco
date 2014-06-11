package com.ncr.ATMMonitoring.serverchain.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.serverchain.test.message.DummyMessage;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;
import com.ncr.serverchain.NodePosition;

@Component
public class MessagePerformanceTestExecuter {

    @Autowired
    private NodeInformation nodeInformation;

    @Autowired
    private MessagePublisher messagePublisher;
    
    public static final int MAX_AMOUNT_OF_MESSAGES_TO_SEND=10;

    private int count = 0;

//    @Scheduled(fixedDelay = 60000)
    public void runProducer() {

	DummyMessage dm = new DummyMessage();

	if(nodeInformation.getNodePosition().equals(NodePosition.FIRST_NODE) && count < 10){
	    messagePublisher.publishOutgoingMessage(this.count++,
		   
		    "Performance test" + nodeInformation.getLocalUrl(), dm);
	    
	   

	}
    }
}
