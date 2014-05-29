/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain.adapter.imp;

import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter;

/**
 * @author Otto Abreu
 * 
 */
public class ATMSocketUpdateResponseAdapterImp extends
	ATMUpdateResponseAdapter {

   
   /*
    * (non-Javadoc)
    * @see com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter#sendUpdateDataMessage(java.lang.String)
    */
    @Override
    public void sendUpdateDataMessage(String jsonResponse) {

	String wrapperInfoMessage = this.getWrapperInfoMessage("ATM Communication response from: ");

	this.sendMessageUsingServerChain(jsonResponse, wrapperInfoMessage);
    }

   

}
