/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain.adapter.imp;

import org.springframework.context.ApplicationContext;

import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateDataResponse;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;

/**
 * @author Otto Abreu
 * 
 */
public class ATMSocketUpdateResponseAdapterImp implements
	ATMUpdateResponseAdapter {

    private NodeInformation nodeInformation;
    private MessagePublisher messagePublisher;


    @Override
    public void setupResponseAdapter(ApplicationContext springContext) {
	
	this.nodeInformation = springContext.getBean(NodeInformation.class);
	this.messagePublisher = springContext.getBean(MessagePublisher.class);
    }
    
    /*
     * (non-Javadoc)
     * @see com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter#generateUpdateDataMessageToRoot(java.lang.String, com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest)
     */
    @Override
    public void generateUpdateDataMessageToRoot(String jsonResponse,
	    UpdateDataRequest originalRequestData) {

	UpdateDataResponse responseData = new UpdateDataResponse(
		originalRequestData, jsonResponse);
	
	long messageId = originalRequestData.getMatricula();

	String wrapperInfoMessage = this.getWrapperInfoMessage("ATM Communication response from: ");

	this.publishMessage(messageId,wrapperInfoMessage, responseData);
    }

   
    private String getWrapperInfoMessage(String specificMessage){
	
	String processingNode = this.nodeInformation.getLocalUrl();

	String wrapperInfoMessage = specificMessage + processingNode;
	
	return wrapperInfoMessage;
	
    }
    
    
    private void publishMessage(long messageId,String wrapperInfoMessage, UpdateDataResponse responseData){

	this.messagePublisher.publishIncomingMessage(messageId,
		wrapperInfoMessage, responseData);
    }

}
