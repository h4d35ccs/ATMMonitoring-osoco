/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain.adapter.imp;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.serverchain.ATMMatriculaHandler;
import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter;
import com.ncr.agent.baseData.ATMDataStorePojo;

/**
 * @author Otto Abreu
 * 
 */
public class ATMSocketUpdateResponseAdapterImp extends ATMUpdateResponseAdapter {

    
    private static Logger logger = Logger
	    .getLogger(ATMSocketUpdateResponseAdapterImp.class);
    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter#
     * sendUpdateDataMessage(java.lang.String)
     */
    @Override
    public void sendUpdateDataMessage(String jsonResponse) {

	Long matricula = this.getMatricula(jsonResponse);
	this.addATMMatriculaIfNotInRouterTable(matricula);
	this.sendUpdate(jsonResponse);
    }

    public Long getMatricula(String jsonResponse) {
	
	ATMDataStorePojo data = this.generateDataStore(jsonResponse);
	Long matricula = null;
	
	if (!StringUtils.isEmpty(data.getMatricula())) {
	    matricula = Long.parseLong(data.getMatricula());
	}

	return matricula;
    }

    private ATMDataStorePojo generateDataStore(String jsonResponse) {
	return ATMDataStorePojo.fromJson(jsonResponse);
    }

    private void addATMMatriculaIfNotInRouterTable(long matricula) {

	boolean matriculaPresent = this.getMatriculaHandler()
		.matriculaPresentInRouterTable(matricula);

	if (!matriculaPresent) {
	    logger.info("Update from a new ATM in this node, adding matricula to router table: "+matricula);
	    this.getMatriculaHandler().addATMtoRouterTable(matricula);
	}
    }

    private void sendUpdate(String jsonResponse) {

	String wrapperInfoMessage = this
		.getWrapperInfoMessage("ATM Communication response from: ");

	this.sendMessageUsingServerChain(jsonResponse, wrapperInfoMessage);
    }

    private ATMMatriculaHandler getMatriculaHandler() {
	return this.springContext.getBean(ATMMatriculaHandler.class);
    }

}
