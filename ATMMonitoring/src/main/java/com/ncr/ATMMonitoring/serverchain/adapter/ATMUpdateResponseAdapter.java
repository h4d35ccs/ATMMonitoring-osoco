package com.ncr.ATMMonitoring.serverchain.adapter;

import org.springframework.context.ApplicationContext;

import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateDataResponse;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;

/**
 * 
 * @author Otto Abreu
 * 
 */
public abstract class ATMUpdateResponseAdapter {

    protected NodeInformation nodeInformation;
    protected MessagePublisher messagePublisher;
    protected UpdateDataRequest originalRequestData;
    protected ApplicationContext springContext;

    /**
     * Sets the objects NodeInformation and MessagePublisher
     * 
     * @param springContext
     */
    public void setupResponseAdapter(ApplicationContext springContext,
	    String ip, Long matricula) {

	this.nodeInformation = springContext.getBean(NodeInformation.class);
	this.messagePublisher = springContext.getBean(MessagePublisher.class);
	this.originalRequestData = new UpdateDataRequest(ip, matricula);
	this.springContext = springContext;

    }

    /**
     * wraps the json response and send it back to root make sure to run first
     * the setup method
     * 
     * @param jsonResponse
     */

    public abstract void sendUpdateDataMessage(String jsonResponse);

    protected void sendMessageUsingServerChain(String jsonResponse,
	    String wrapperInfoMessage) {

	UpdateDataResponse responseData = this
		.getUpdateDataResponse(jsonResponse);

	long messageId = this.originalRequestData.getMatricula();

	this.publishMessage(messageId, wrapperInfoMessage, responseData);
    }

    /**
     * Returns the Message to send using Serverchain
     * 
     * @param jsonResponse
     * @return UpdateDataResponse
     */
    protected UpdateDataResponse getUpdateDataResponse(String jsonResponse) {

	UpdateDataResponse responseData = new UpdateDataResponse(
		this.originalRequestData, jsonResponse);

	return responseData;
    }

    /**
     * Generates a standar message to put in message wrapper
     * 
     * @param specificMessage
     * @return String
     */
    protected String getWrapperInfoMessage(String specificMessage) {

	String processingNode = this.nodeInformation.getLocalUrl();

	String wrapperInfoMessage = specificMessage + processingNode;

	return wrapperInfoMessage;

    }

    /**
     * Publishes the message in the topic
     * 
     * @param messageId
     * @param wrapperInfoMessage
     * @param responseData
     */
    protected void publishMessage(long messageId, String wrapperInfoMessage,
	    UpdateDataResponse responseData) {

	this.messagePublisher.publishIncomingMessage(messageId,
		wrapperInfoMessage, responseData);
    }

}
