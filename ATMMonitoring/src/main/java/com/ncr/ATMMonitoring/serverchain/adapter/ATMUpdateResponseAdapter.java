package com.ncr.ATMMonitoring.serverchain.adapter;

import org.springframework.context.ApplicationContext;

import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest;

/**
 * 
 * @author Otto Abreu
 * 
 */
public interface ATMUpdateResponseAdapter {

    /**
     * 
     * @param springContext
     */
    void setupResponseAdapter(ApplicationContext springContext);

    /**
     * wraps the json response and send it back to root make sure to run first
     * the setup method
     * 
     * @param jsonResponse
     */
    void generateUpdateDataMessageToRoot(String jsonResponse,
	    UpdateDataRequest originalRequestData);

}
