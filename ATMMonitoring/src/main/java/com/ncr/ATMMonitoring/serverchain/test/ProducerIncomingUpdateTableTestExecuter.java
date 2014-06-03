package com.ncr.ATMMonitoring.serverchain.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.routertable.RouterTableHandler;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateRouterTable;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;

@Component
public class ProducerIncomingUpdateTableTestExecuter {

    @Autowired
    private NodeInformation nodeInformation;

    @Autowired
    private MessagePublisher messagePublisher;
    
    private static final String URL_PORT_TO_TEST="61622";
    private static final String SECOND_URL_PORT_TO_TEST="61623";
    private static final String THIRD_URL_PORT_TO_TEST="61625";
    private static final String FOURTH_URL_PORT_TO_TEST="61619";
    private static final long MATRICULA_TO_ADD = 50;	
    
    

    private static final Logger logger = Logger
	    .getLogger(ProducerIncomingUpdateTableTestExecuter.class);

    private int count = 0;

    @Scheduled(cron="*/20 * * * * ?")
    public void runProducer() {
	String localUrl = nodeInformation.getLocalBrokerUrl();
	logger.debug(" cont change from local leaf (2<x<5):"+this.count);
	
	if (localUrl.contains(URL_PORT_TO_TEST) && ( this.count == 6)) {
	    
	    this.sendUpdate(URL_PORT_TO_TEST,MATRICULA_TO_ADD);
	    
	}else if (localUrl.contains(SECOND_URL_PORT_TO_TEST) && (this.count == 15)) {
		
		this.sendUpdate(SECOND_URL_PORT_TO_TEST,MATRICULA_TO_ADD);
	
	}else if(localUrl.contains(THIRD_URL_PORT_TO_TEST) && (this.count == 30 )){
	    
	    this.sendUpdate(THIRD_URL_PORT_TO_TEST,MATRICULA_TO_ADD);
	    
	}else if(localUrl.contains(FOURTH_URL_PORT_TO_TEST) && (this.count == 55)){
	  
	    this.sendUpdate(FOURTH_URL_PORT_TO_TEST,MATRICULA_TO_ADD);
	    
	} else if(this.count > 55){
	    
	    this.count = 0;
	}
	    
	this.count++;
    }
    
    private void sendUpdate(String portToTest,long matriculaToTest){
	
	 logger.debug("Is going to update table "+portToTest);
	    UpdateRouterTable updateInfo = new UpdateRouterTable(matriculaToTest, this.nodeInformation.getLocalUrl());
	    this.messagePublisher.publishIncomingMessage(this.count,
		    "Incoming message to update table send from: " + nodeInformation.getLocalBrokerUrl(),
		    updateInfo );
	    RouterTableHandler.addMatriculaAndIpToTable(matriculaToTest, this.nodeInformation.getLocalUrl());
    }
    
}
