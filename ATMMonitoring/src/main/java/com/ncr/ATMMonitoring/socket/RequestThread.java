package com.ncr.ATMMonitoring.socket;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.serverchain.adapter.ATMSocketCommunicationParams;
import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateAdapterFactory;
import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateRequestAdapter;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;

/**
 * The Class RequestThread.
 * 
 * This class retrieves the data from a series of ATM's by their ips.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RequestThread extends Thread {

    /** The Constant hashSeed. */
    public static final String hashSeed = "V3zVFyxn9DnToZJ8067i";

    /** The Constant authOkMsg. */
    public static final String authOkMsg = "OK";

    /** The Constant authErrorMsg. */
    public static final String authErrorMsg = "ERROR";

    /** The Constant authUpdateMsg. */
    public static final String authUpdateMsg = "UPDATE";

    /** The Constant endCommMsg. */
    public static final String endCommMsg = "END";

    /** The logger. */
    private static Logger logger = Logger.getLogger(SocketListenerThread.class
	    .getName());

    /** The agent port. */
    private int agentPort;

    /** The response time out. */
    private int timeOut;

    /** The parent manager. */
    private RequestThreadManager parent;

    /** The number of ips to notify. */
    private int requestNumber;

    /**
     * Instantiates a new request thread.
     * 
     * @param requestNumber
     *            the number of ips to notify
     * @param agentPort
     *            the agent port
     * @param timeOut
     *            the response time out
     * @param parent
     *            the parent manager
     */
    public RequestThread(int requestNumber, int agentPort, int timeOut,
	    RequestThreadManager parent) {
	this.agentPort = agentPort;
	this.timeOut = timeOut;
	this.parent = parent;
	this.requestNumber = requestNumber;

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {

	ATMUpdateInfo updateInfo = null;

	for (int i = 0; i < this.requestNumber; i++) {

	    updateInfo = this.parent.getIpToProcess();
	    logger.debug("calling the adapter");
	    this.callServerChainAdapter(updateInfo);
	}
    }

    private void callServerChainAdapter(ATMUpdateInfo updateInfo) {

	ATMUpdateRequestAdapter adapter = ATMUpdateAdapterFactory
		.getRequestAdapterInstance(ATMUpdateAdapterFactory.SOCKET_COMMUNICATION_ADAPTER);
	ATMSocketCommunicationParams params = this.setUpAdapterParams();
	adapter.setupAdapter(updateInfo, params);
	adapter.requestATMUpdate();
    }

    private ATMSocketCommunicationParams setUpAdapterParams() {

	ATMSocketCommunicationParams params = new ATMSocketCommunicationParams();
	params.setAgentPort(agentPort);
	params.setAuthErrorMsg(authErrorMsg);
	params.setAuthOkMsg(authOkMsg);
	params.setAuthUpdateMsg(authUpdateMsg);
	params.setHashSeed(hashSeed);
	params.setEndCommMsg(endCommMsg);
	params.setParentRequestThreadManager(parent);
	params.setRequestNumber(requestNumber);
	params.setTimeOut(timeOut);
	params.setSpringContext(parent.getSpringContext());

	return params;

    }

}
