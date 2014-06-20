package com.ncr.ATMMonitoring.serverchain.message.specific.strategy.imp;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.routertable.RouterTableHandler;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest;
import com.ncr.ATMMonitoring.socket.SocketService;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;
import com.ncr.serverchain.NodePosition;
import com.ncr.serverchain.message.specific.strategy.BroadcastType;
import com.ncr.serverchain.message.specific.strategy.imp.BaseStrategy;

/**
 * <pre>
 * Strategy to execute to UpdateRequest Messages.
 * 
 * This strategy will continue passing the message if the node can process ( the matricula is on the route table) 
 * and is not a leaf, if is a leaf will call the class in charge of calling the ATM
 * @author Otto Abreu
 * 
 * </pre>
 * 
 */
@Component
public class UpdateDataRequestStrategy extends BaseStrategy {

    private static final Logger logger = Logger
	    .getLogger(UpdateDataRequestStrategy.class);

    private boolean finalProcessing = false;

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.message.specific.strategy.
     * SpecifcMessageProcessStrategy
     * #setupStrategy(com.ncr.ATMMonitoring.serverchain.NodePosition,
     * com.ncr.ATMMonitoring.serverchain.message.SpecificMessage)
     */

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.message.specific.strategy.
     * SpecifcMessageProcessStrategy#canProcessSpecificMessage()
     */
    @Override
    public boolean canProcessSpecificMessage() {

	boolean canProcess = false;
	UpdateDataRequest updateDataMessage = this
		.castMessageToUpdateDataRequest();

	if (nodeIsLeafOrMiddleAndMatriculaIsPresent(updateDataMessage)) {

	    canProcess = true;
	}

	logger.info("can process the message? " + canProcess+" updateDataMessage:"+updateDataMessage);
	return canProcess;
    }

    private UpdateDataRequest castMessageToUpdateDataRequest() {
	return (UpdateDataRequest) this.messageToProcess;
    }

    private boolean nodeIsLeafOrMiddleAndMatriculaIsPresent(
	    UpdateDataRequest updateDataMessage) {

	boolean matriculaPresentInTable = this
		.matriculaPresentInTable(updateDataMessage);

	if ((this.getCurrentNodePosition().equals(NodePosition.LEAF_NODE) || this
		.getCurrentNodePosition().equals(NodePosition.MIDDLE_NODE))
		&& matriculaPresentInTable) {

	    return true;

	} else {

	    return false;
	}
    }

    private NodePosition getCurrentNodePosition() {
	return this.nodeInformation.getNodePosition();
    }

    private boolean matriculaPresentInTable(UpdateDataRequest updateDataMessage) {
	logger.debug(RouterTableHandler.tableTotring());
	boolean matriculaPresentInTable = RouterTableHandler
		.matriculaIsInRouterTable(updateDataMessage.getMatricula());
	return matriculaPresentInTable;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.message.specific.strategy.
     * SpecifcMessageProcessStrategy#processSpecificMessage()
     */
    @Override
    public void processSpecificMessage() {

	this.processMessageByPosition();

    }

    private void processMessageByPosition() {

	if (isLeaf()) {
	    logger.info(" Update data Request reached leaf, processing....");
	    this.processWhenLeaf();

	}
    }

    private void processWhenLeaf() {

	this.finalProcessing = true;
	this.callServiceToProcessUpdate();
	logger.info(" Update data Request processed in leaf");
    }

    private void callServiceToProcessUpdate() {

	SocketService socketService = this.getSocketService();
	ATMUpdateInfo updateInfo = createATMUpdateInfo();
	socketService.updateTerminalSocket(updateInfo);

    }

    private SocketService getSocketService() {
	return this.springContext.getBean(SocketService.class);
    }

    private ATMUpdateInfo createATMUpdateInfo() {

	UpdateDataRequest dataRequest = castMessageToUpdateDataRequest();
	String atmIp = dataRequest.getAtmIp();
	long atmMatricula = dataRequest.getMatricula();

	ATMUpdateInfo updateInfo = new ATMUpdateInfo(atmIp, atmMatricula);
	return updateInfo;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.message.specific.strategy.
     * SpecifcMessageProcessStrategy#broadcastDirection()
     */
    @Override
    public BroadcastType broadcastDirection() {

	BroadcastType passMessage = BroadcastType.NONE;

	if (isMiddleNodeAndCanPassMessage()) {

	    passMessage = BroadcastType.ONE_WAY;

	} 
	return passMessage;
    }

    private boolean isMiddleNodeAndCanPassMessage() {

	if (!this.finalProcessing && canProcessSpecificMessage()) {
	    
	    return true;

	} else {

	    return false;
	}
    }

}
