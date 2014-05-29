/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain.adapter;

import com.ncr.ATMMonitoring.serverchain.adapter.imp.ATMPushUpdateAdapterImp;
import com.ncr.ATMMonitoring.serverchain.adapter.imp.ATMSocketUpdateRequestAdapterImpl;
import com.ncr.ATMMonitoring.serverchain.adapter.imp.ATMSocketUpdateResponseAdapterImp;

/**
 * Factory class in charge of returning the correct type of adapter
 * (ATMUpdateRequestAdapter or getUpdateResponseAdapter)
 * 
 * @author Otto Abreu
 * 
 */
public class ATMUpdateAdapterFactory {

    /**
     * SOCKET_COMMUNICATION_ADAPTER ="Adapter";
     */
    public static final String SOCKET_COMMUNICATION_ADAPTER = "socket";

    public static final String PUSH_COMMUNICATION_ADAPTER = "push";

    /**
     * Factory method that returns the instance of ATMUpdateRequestAdapter.
     * 
     * If the adapterType param does not matches with anything, an
     * IllegalArgumentException is thrown
     * 
     * @param adapterType
     *            String (use the constants of the class to set this param)
     * @return
     */
    public static ATMUpdateRequestAdapter getRequestAdapterInstance(
	    String adapterType) {
	ATMUpdateRequestAdapter adapterInstance = null;
	switch (adapterType) {

	case SOCKET_COMMUNICATION_ADAPTER:

	    adapterInstance = new ATMSocketUpdateRequestAdapterImpl();

	    break;

	default:

	    throw new IllegalArgumentException(
		    "Wrong type of  Request adapter, use the constant of the class to avoid errors, received:"
			    + adapterType);
	}

	return adapterInstance;

    }

    /**
     * Factory method that returns the instance of ATMUpdateResponseAdapter.
     * 
     * If the adapterType param does not matches with anything, an
     * IllegalArgumentException is thrown
     * 
     * @param adapterType
     *            String (use the constants of the class to set this param)
     * @return ATMUpdateResponseAdapter
     */
    public static ATMUpdateResponseAdapter getUpdateResponseAdapter(
	    String adapterType) {
	ATMUpdateResponseAdapter adapterInstance = null;

	switch (adapterType) {

	case SOCKET_COMMUNICATION_ADAPTER:

	    adapterInstance = new ATMSocketUpdateResponseAdapterImp();

	    break;

	case PUSH_COMMUNICATION_ADAPTER:

	    adapterInstance = new ATMPushUpdateAdapterImp();

	    break;

	default:

	    throw new IllegalArgumentException(
		    "Wrong type of Response adapter, use the constant of the class to avoid errors, received:"
			    + adapterType);
	}

	return adapterInstance;
    }

}
