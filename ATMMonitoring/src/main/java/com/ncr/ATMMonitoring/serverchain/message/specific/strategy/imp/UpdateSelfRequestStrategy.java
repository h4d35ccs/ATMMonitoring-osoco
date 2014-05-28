package com.ncr.ATMMonitoring.serverchain.message.specific.strategy.imp;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateSelfRequest;
import com.ncr.ATMMonitoring.socket.SocketService;
import com.ncr.serverchain.message.specific.strategy.imp.DirectRootCommunicationStrategy;

/**
 * 
 * Strategy that process a message asking to update an ATM
 * 
 * The message will travels until reaches root, then the Socket service will be
 * called
 * 
 * @author Otto Abreu
 * 
 */
public class UpdateSelfRequestStrategy extends DirectRootCommunicationStrategy {

    static private Logger logger = Logger
	    .getLogger(UpdateSelfRequestStrategy.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.serverchain.message.specific.strategy.imp.
     * DirectRootCommunicationStrategy#customLogicToProcessMessageInRoot()
     */
    @Override
    protected void customLogicToProcessMessageInRoot() {

	SocketService socketService = getSocketService();
	UpdateSelfRequest updateSelfRequest = this
		.castMessageToUpdateSelfRequest();

	String ip = updateSelfRequest.getAtmIp();
	long matricula = updateSelfRequest.getMatricula();

	socketService.updateTerminalSocket(ip, matricula);

	logger.debug("Request from " + ip + " sent to SocketService");

    }

    private SocketService getSocketService() {

	return this.springContext.getBean(SocketService.class);
    }

    private UpdateSelfRequest castMessageToUpdateSelfRequest() {
	return (UpdateSelfRequest) this.messageToProcess;
    }
}
