package com.ncr.ATMMonitoring.serverchain.adapter;

import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;

/**
 * Adapter class that connects the socket communication and the chain communication
 * allowing the execution in single node mode
 * @author Otto Abreu
 * 
 */
public interface ATMUpdateRequestAdapter {

    /**
     * Setup that prepares the adapter
     * 
     * @param updateInfo
     * @param socketComunicationParams
     */
    void setupAdapter(ATMUpdateInfo updateInfo,
	    ATMSocketCommunicationParams socketComunicationParams);

    /**
     * Executes the request of the given ATM. This method will call directly the
     * ATM or initiate the serverchain process.
     * 
     * The setup method should be called before executing this method
     */
    void requestATMUpdate();

    
    /**
     * The ATM Requests to the Root node to execute an update 
     */
    void requestUpdateToRoot();
    

}
