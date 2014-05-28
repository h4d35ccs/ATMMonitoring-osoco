package com.ncr.ATMMonitoring.serverchain.message.specific.strategy.imp;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateDataResponse;
import com.ncr.ATMMonitoring.socket.SocketService;
import com.ncr.serverchain.message.specific.strategy.imp.DirectRootCommunicationStrategy;

/**
 * Strategy to process a response from an ATM
 * 
 * This strategy let pass the message until reaches the Root node
 * where is processed.
 * 
 * In order to process the message, the SocketService is called
 * 
 * @author Otto Abreu
 * 
 */
public class UpdateDataResponseStrategy extends DirectRootCommunicationStrategy {

    private static final Logger logger = Logger
	    .getLogger(UpdateDataResponseStrategy.class);


    protected void customLogicToProcessMessageInRoot() {

	    SocketService socketService = this.getSocketService();
	    UpdateDataResponse dataResponse = this
		    .castMessageToUpdateDataResponse();

	    String json = dataResponse.getJsonMessage();
	    socketService.processTerminalJson(json);

	    logger.debug("message sent to socket service to be Processed");

    }

    private SocketService getSocketService() {
	return (SocketService) this.getSpringBean(SocketService.class);
    }

    private UpdateDataResponse castMessageToUpdateDataResponse() {
	return (UpdateDataResponse) this.messageToProcess;
    }


}
