package com.ncr.ATMMonitoring.serverchain.executer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;
import com.ncr.serverchain.NodePosition;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.NetworkMappingRequest;

/**
 * Sends the Network Map Request in a given time period
 * 
 * @author Otto Abreu
 * 
 */
@Component
public class NetworkMapExecuter {

    @Autowired
    private NodeInformation nodePosition;

    @Autowired
    private MessagePublisher messagePublisher;

    @Scheduled(fixedDelay = 40000)
    public void runNetworkMap() {

	if (nodePosition.getNodePosition().equals(NodePosition.FIRST_NODE)) {

	    NetworkMappingRequest networkMappingRequest = new NetworkMappingRequest();

	    messagePublisher.publishOutgoingMessage("Network Mapping Request",
		    networkMappingRequest);

	}
    }
}
