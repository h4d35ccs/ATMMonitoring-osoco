/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain.adapter.imp;

import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter;
import com.ncr.ATMMonitoring.socket.SocketService;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.serverchain.NodePosition;

/**
 * @author Otto Abreu
 * 
 */
public class ATMPushUpdateAdapterImp extends ATMUpdateResponseAdapter {

    private ATMDataStorePojo dataFromATM;

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter#
     * sendUpdateDataMessage(java.lang.String)
     */
    @Override
    public void sendUpdateDataMessage(String jsonResponse) {

	this.setATMDataStorePojo(jsonResponse);
	this.verifyIfMatriculaIsSet();

	if (useServerChain()) {

	    this.sendDataToParentNode(jsonResponse);

	} else {

	    this.sendDataToPushServer(jsonResponse);

	}

    }

    private void setATMDataStorePojo(String jsonResponse) {
	this.dataFromATM = ATMDataStorePojo.fromJson(jsonResponse);
    }

    /**
     * sets the matricula number if not set
     * 
     * * The rationale behind this is, because the matricula number in the tread
     * is only returned if the ATM does not have a matricula (new Installation).
     * When the ATM have a Matricula number, is returned in the JSON and put it
     * into the object ATMDataStorePojo.
     * 
     * So if the number inside the originalRequestData is null, means that is an
     * installed ATM and the matricula is inside the ATMDataStorePojo and it was
     * not set when this object was called.
     * 
     * The matricula inside this.originalRequestData is set if the ATM was new,
     * otherwise the matricula will be inside the JSON and then in the
     * ATMDataStorePojo
     * 
     */
    private void verifyIfMatriculaIsSet() {

	if (this.originalRequestData.getMatricula() == null) {

	    this.setOldMatriculaifNotSet();

	} else {

	    this.setMatriculaIfNewATM();
	}
    }

    private void setOldMatriculaifNotSet() {

	Long oldMatricula = Long.parseLong(this.dataFromATM.getMatricula());
	this.originalRequestData.setMatricula(oldMatricula);
    }

    private void setMatriculaIfNewATM() {

	String matricula = Long.toString(this.originalRequestData
		.getMatricula());
	this.dataFromATM.setMatricula(matricula);
    }

    private void sendDataToPushServer(String jsonResponse) {

	SocketService socketService = this.getSocketService();

	socketService.sendDataToPushServer(dataFromATM);
    }

    private SocketService getSocketService() {
	return this.springContext.getBean(SocketService.class);
    }

    private void sendDataToParentNode(String jsonResponse) {

	String wrapperInfoMessage = this
		.getWrapperInfoMessage("ATM Push Update from : ");

	this.sendMessageUsingServerChain(jsonResponse, wrapperInfoMessage);
    }

    /**
     * Indicate if the serverchain method must be used. return true only if the
     * node is a leaf the server chain will be executed because, a leaf node
     * have a parent configured, otherwise is a node in push mode.
     * 
     * In push mode, the last node does not have a relationship with other
     * server
     * 
     * @return boolean
     */
    private boolean useServerChain() {
	NodePosition nodePosition = this.nodeInformation.getNodePosition();

	if (nodePosition.equals(NodePosition.LEAF_NODE)) {
	    return true;
	} else {
	    return false;
	}
    }

}
