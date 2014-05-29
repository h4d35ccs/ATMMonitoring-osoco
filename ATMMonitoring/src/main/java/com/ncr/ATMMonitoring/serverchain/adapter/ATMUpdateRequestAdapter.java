package com.ncr.ATMMonitoring.serverchain.adapter;

import org.springframework.context.ApplicationContext;

import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;
import com.ncr.serverchain.ServerchainMainBeanFactory;

/**
 * Adapter class that connects the socket communication and the chain communication
 * allowing the execution in single node mode
 * @author Otto Abreu
 * 
 */
public abstract class ATMUpdateRequestAdapter {

    
    protected ATMUpdateInfo updateInfo;

    protected ATMSocketCommunicationParams socketComunicationParams;

    protected NodeInformation nodeInformation;

    protected MessagePublisher messagePublisher;

    /**
     * Setup that prepares the adapter
     * 
     * @param updateInfo
     * @param socketComunicationParams
     */
    public void setupAdapter(ATMUpdateInfo updateInfo,
	    ATMSocketCommunicationParams socketComunicationParams) {

	this.socketComunicationParams = socketComunicationParams;
	this.updateInfo = updateInfo;

	ApplicationContext springContext = socketComunicationParams
		.getSpringContext();

	this.nodeInformation = this.getNodeInformation(springContext);

	this.messagePublisher = this.getMessagePublisher(springContext);

    }
    
    private NodeInformation getNodeInformation(ApplicationContext springContext) {

  	NodeInformation nodeInformation = ServerchainMainBeanFactory
  		.getNodeInformationInstance(springContext);

  	return nodeInformation;
      }

      private MessagePublisher getMessagePublisher(
  	    ApplicationContext springContext) {
  	MessagePublisher messagePublisher = ServerchainMainBeanFactory
  		.getMessagePublisherInstance(springContext);
  	return messagePublisher;
      }


    /**
     * Executes the request of the given ATM. This method will call directly the
     * ATM or initiate the serverchain process.
     * 
     * The setup method should be called before executing this method
     */
    public abstract void requestATMUpdate();

    
    /**
     * The ATM Requests to the Root node to execute an update 
     */
    public abstract void requestUpdateToRoot();
    

}
