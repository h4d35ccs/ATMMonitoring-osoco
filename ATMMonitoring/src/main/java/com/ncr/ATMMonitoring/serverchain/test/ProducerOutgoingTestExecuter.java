package com.ncr.ATMMonitoring.serverchain.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;
import com.ncr.serverchain.message.wrapper.MessageWrapper;

@Component
public class ProducerOutgoingTestExecuter {

    @Autowired
    private NodeInformation nodeInformation;

    @Autowired
    private MessagePublisher messagePublisher;
    
    public static final int MAX_AMOUNT_OF_MESSAGES_TO_SEND=5000;

    private int count = 0;

//    @Scheduled(fixedDelay = 120000)
    public void runProducer() {

	if (!nodeInformation.hasParentNode()) {
	    
	    for(int i = 0; i < MAX_AMOUNT_OF_MESSAGES_TO_SEND; i++ ){

	    UpdateDataRequest udr = new UpdateDataRequest("192.168.1.1", 3);

	    messagePublisher.publishOutgoingMessage(this.count++,
		    MessageWrapper.DEFAULT_OUTGOINGMESSAGE_INNER_MESSAGE + nodeInformation.getLocalUrl(), udr);
	    
	    }

	}
    }
}