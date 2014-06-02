/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.routertable.RouterTableHandler;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateRouterTable;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;

/**
 * <pre>
 * Class in charge of register a new ATM in the router table of the node.
 * 
 * This class creates and publish a UpdateRouterTable in order to notify the network
 * about the change.
 * 
 * The usage  are:
 * 	* A new ATM with no matricula arrives to the node
 * 	* An existing ATM with matricula was moved from one node to another
 * In both cases the same will happen: the matricula will be added/updated to this node,
 * and to the rest of the network.
 * 
 * when a ATM present itself to the node, call this class
 * 
 * </pre>
 * @author Otto Abreu
 *
 */
@Component
public class ATMMatriculaHandler {
    
    @Autowired
    private MessagePublisher messagePublisher;
    
    @Autowired
    private NodeInformation nodeInformation;
    
    private static Logger logger = Logger
	    .getLogger(ATMMatriculaHandler.class);

    public boolean matriculaPresentInRouterTable(long matricula){
	
	return RouterTableHandler.matriculaIsInRouterTable(matricula);
    }
    
    public void addATMtoRouterTable(long matricula){
	
	String currentNodeUrl = this.getCurrentNodeUrl();
	RouterTableHandler.addMatriculaAndIpToTable(matricula, currentNodeUrl);
	logger.info("Local router Table updated, added new: "+matricula);
	this.publishRouterTableChange(matricula,currentNodeUrl);
    }
    
    
    private String getCurrentNodeUrl(){
	
	return this.nodeInformation.getLocalUrl();
    }
    
    private void publishRouterTableChange(long matricula, String currentNodeUrl){
	 
	UpdateRouterTable updateInfo = new UpdateRouterTable(matricula, currentNodeUrl);
	   
	 this.messagePublisher.publishIncomingMessage(matricula,
		    "Incoming message to update table send from: " + currentNodeUrl,
		    updateInfo );
    }
}
