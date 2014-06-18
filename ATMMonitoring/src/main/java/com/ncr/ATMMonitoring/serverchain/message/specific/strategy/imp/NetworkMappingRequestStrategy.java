package com.ncr.ATMMonitoring.serverchain.message.specific.strategy.imp;

import java.util.Date;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.routertable.RouterTableHandler;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.NetworkMappingResponse;
import com.ncr.serverchain.message.specific.SpecificMessage;
import com.ncr.serverchain.message.specific.strategy.BroadcastType;
import com.ncr.serverchain.message.specific.strategy.imp.BaseStrategy;
import com.ncr.serverchain.message.wrapper.IncomingMessage;
import com.ncr.serverchain.message.wrapper.MessageWrapper;

/**
 * <pre>
 * Strategy that process NetworkMappingRequest messages.
 * 
 * This strategy travels all the nodes and generate 
 * a response message ( NetworkMappingResponse)  and puts the information of the leaf node inside.
 * After that the message is returned to the parent
 * 
 * In the middle nodes the Request message will be broadcasted to all the children and also will generate a  response
 * to send to the parent node (BroadcastType.TWO_WAY) 
 * will be generated in the node.
 * 
 * In the leaf will generate the response using (BroadcastType.TURN_BACK)
 * 
 * @author Otto Abreu
 * <pre>
 */
public class NetworkMappingRequestStrategy extends BaseStrategy {

    private NetworkMappingResponse response;
    private static final Logger logger = Logger
	    .getLogger(NetworkMappingRequestStrategy.class);
    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.message.specific.strategy.
     * SpecifcMessageProcessStrategy#canProcessSpecificMessage()
     */
    @Override
    public boolean canProcessSpecificMessage() {

	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.message.specific.strategy.
     * SpecifcMessageProcessStrategy#processSpecificMessage()
     */
    @Override
    public void processSpecificMessage() {

	if (this.isLeaf() || this.isMiddle()) {
	    this.generateResponse();
	    logger.debug("NetworkMap Response generated");
	}

    }


    private void generateResponse() {
	 
	this.response = new NetworkMappingResponse();
	 String nodeUrlAndPort =  this.nodeInformation.getLocalUrl();
	 String parentUrl = this.nodeInformation.getParentUrl();
	 String routerTable = null;
	 routerTable = RouterTableHandler.tableTotring();
	 this.response.addNodeInformationLeaforMiddle(nodeUrlAndPort, routerTable, parentUrl);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.message.specific.strategy.
     * SpecifcMessageProcessStrategy#broadcastDirection()
     */
    @Override
    public BroadcastType broadcastDirection() {
	BroadcastType broadcast = BroadcastType.ONE_WAY;
	
	if(this.isLeaf()){
	    
	    broadcast = BroadcastType.TURN_BACK;
	    
	}else if(this.isMiddle()){
	   
	    broadcast = BroadcastType.TWO_WAY;
	}
	
	return broadcast;
    }
    /*
     * (non-Javadoc)
     * @see com.ncr.serverchain.message.specific.strategy.imp.BaseStrategy#getTurnBackMessage()
     */
    @Override
    public MessageWrapper getTurnBackMessage() {

	return this.getResponseMessageWrapper();
    }
    
    private MessageWrapper getResponseMessageWrapper(){
	MessageWrapper turnbackMessage =  new IncomingMessage("Network mapping response",new Date().getTime());
	turnbackMessage.setSpecificMessage(this.response);
	return turnbackMessage;
    }

    /*
     * (non-Javadoc)
     * @see com.ncr.serverchain.message.specific.strategy.imp.BaseStrategy#getChangeDirectionMessageInTwoWay()
     */
    @Override
   public SpecificMessage getChangeDirectionMessageInTwoWay(){
    
       return this.response;
       
   }
}
