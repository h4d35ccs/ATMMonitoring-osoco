package com.ncr.ATMMonitoring.serverchain.adapter.imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.ncr.ATMMonitoring.serverchain.adapter.ATMSocketCommunicationParams;
import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateAdapterFactory;
import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateRequestAdapter;
import com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateResponseAdapter;
import com.ncr.ATMMonitoring.serverchain.adapter.exception.ATMUpdateRequestException;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateRequestCommunicationError;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateSelfRequest;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest;
import com.ncr.ATMMonitoring.socket.RequestThreadManager;
import com.ncr.ATMMonitoring.socket.SocketListener;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;
import com.ncr.serverchain.NodePosition;
import com.ncr.serverchain.ServerchainMainBeanFactory;
import com.ncr.serverchain.message.specific.SpecificMessage;
import com.ncr.serverchain.message.wrapper.MessageWrapper;

/**
 * @author Otto Abreu
 * 
 */
public class ATMSocketUpdateRequestAdapterImpl implements
	ATMUpdateRequestAdapter {

    private static Logger logger = Logger
	    .getLogger(ATMSocketUpdateRequestAdapterImpl.class);

    private ATMUpdateInfo updateInfo;

    private ATMSocketCommunicationParams socketComunicationParams;

    private NodeInformation nodeInformation;

    private MessagePublisher messagePublisher;

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateRequestAdapter#
     * setupAdapter(com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo,
     * com.ncr.ATMMonitoring.serverchain.adapter.ATMSocketComunicationParams)
     */
    @Override
    public void setupAdapter(ATMUpdateInfo updateInfo,
	    ATMSocketCommunicationParams socketComunicationParams) {

	this.socketComunicationParams = socketComunicationParams;
	this.updateInfo = updateInfo;

	ApplicationContext springContext = socketComunicationParams
		.getSpringContext();

	this.nodeInformation = this.getNodeInformation(springContext);

	this.messagePublisher = this.getMessagePublisher(springContext);

    }

    private NodeInformation getNodeInformation(ApplicationContext springContext) {

	NodeInformation nodeInformation = ServerchainMainBeanFactory
		.getNodeInformationInstance(springContext);

	return nodeInformation;
    }

    private MessagePublisher getMessagePublisher(
	    ApplicationContext springContext) {
	MessagePublisher messagePublisher = ServerchainMainBeanFactory
		.getMessagePublisherInstance(springContext);
	return messagePublisher;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateRequestAdapter#
     * requestATMUpdate()
     */
    @Override
    public void requestATMUpdate() {

	validateSetup();

	if (initateServerChain()) {

	    logger.debug("using serverchain");

	    this.publishUpdate();

	} else if (initiateSocketConnection()) {

	    logger.debug("using socketConnection");

	    try {

		this.openSocketComunication();

	    } catch (Exception e) {
		logger.debug("handling error",e);
		this.handleATMCommunicationError();
	    }
	}
    }

    private void validateSetup() {
	if (this.socketComunicationParams == null && this.updateInfo == null) {
	    throw new ATMUpdateRequestException(
		    ATMUpdateRequestException.SETUP_NOT_EXECUTED);
	}
    }

    private boolean initateServerChain() {

	boolean initiateServerChain = false;
	logger.debug("isRootAndIsNotOnlyNode" + isRootAndIsNotOnlyNode());
	if (isRootAndIsNotOnlyNode()) {

	    initiateServerChain = true;

	}
	logger.debug("initiateServerChain?" + initiateServerChain);
	return initiateServerChain;
    }

    private boolean isRootAndIsNotOnlyNode() {

	NodePosition position = this.getNodePosition();

	if (position.equals(NodePosition.FIRST_NODE)
		&& !position.equals(NodePosition.ONLY_NODE)) {

	    return true;

	} else {

	    return false;
	}
    }

    private void publishUpdate() {

	UpdateDataRequest updateRequest = getUpdateMessage();
	logger.debug("publshing message");
	this.messagePublisher.publishOutgoingMessage(updateRequest
		.getMatricula().intValue(),
		MessageWrapper.DEFAULT_OUTGOINGMESSAGE_INNER_MESSAGE
			+ this.nodeInformation.getLocalUrl(), updateRequest);
	logger.debug("published message");

    }

    private UpdateDataRequest getUpdateMessage() {
	String requestIp = updateInfo.getAtmIp();
	long matricula = updateInfo.getAtmMatricula();

	UpdateDataRequest updateRequest = new UpdateDataRequest(requestIp,
		matricula);

	return updateRequest;
    }

    private boolean initiateSocketConnection() {

	boolean initiateSocketConnection = false;

	if (isLeafNode() || isOnlyNode()) {

	    initiateSocketConnection = true;
	}

	return initiateSocketConnection;
    }

    private void openSocketComunication() throws Exception {

	String atmIp = this.updateInfo.getAtmIp();
	this.requestDataJson(atmIp);
    }

    private boolean isLeafNode() {

	NodePosition position = this.getNodePosition();

	if (position.equals(NodePosition.LEAF_NODE)) {

	    return true;

	} else {

	    return false;
	}

    }

    private boolean isOnlyNode() {

	NodePosition position = this.getNodePosition();

	if (position.equals(NodePosition.ONLY_NODE)) {

	    return true;

	} else {

	    return false;
	}

    }

    
    private void handleATMCommunicationError() {

	if (isOnlyNode()) {

	    RequestThreadManager requestThreadManager = this.socketComunicationParams
		    .getParentRequestThreadManager();
	    requestThreadManager.handleIpError(updateInfo);
	    logger.info("ATM Info back to the queue");

	} else if (isLeafNode()) {

	    this.publishCommunicationError();
	    logger.info("ATM Info sent to the root node");

	}

    }

    private void publishCommunicationError() {

	UpdateRequestCommunicationError commErrorInfo = this
		.createUpdateRequestError();

	String wrapperInfoMessage = "ATM Communication Error Message from: "
		+ commErrorInfo.getProcessingNode();

	int messageId = commErrorInfo.getMatricula().intValue();

	this.publishMessageToRoot(messageId, wrapperInfoMessage, commErrorInfo);
    }

    private void publishMessageToRoot(long messageId,
	    String wrapperInfoMessage, SpecificMessage message) {

	this.messagePublisher.publishIncomingMessage(messageId,
		wrapperInfoMessage, message);
    }

    private UpdateRequestCommunicationError createUpdateRequestError() {

	String atmNotRespondingIp = this.updateInfo.getAtmIp();
	Long atmNotRespondingMatricula = this.updateInfo.getAtmMatricula();
	String processingNode = this.nodeInformation.getLocalUrl();

	UpdateRequestCommunicationError commErrorInfo = new UpdateRequestCommunicationError(
		atmNotRespondingIp, atmNotRespondingMatricula, processingNode);
	return commErrorInfo;
    }

    private NodePosition getNodePosition() {

	NodePosition position = this.nodeInformation.getNodePosition();
	logger.debug("the position is: " + position);
	return position;
    }

    private String handleATMResponse(String json, String ip) {

	String endMessage = socketComunicationParams.getEndCommMsg();

	if (isOnlyNode()) {

	    endMessage = this.handleATMResponseInOnlyNodeMode(json, ip);

	} else {

	    this.generateUpdateDataResponseMessageToRoot(json);
	}

	return endMessage;
    }

    private String handleATMResponseInOnlyNodeMode(String json, String ip) {
	RequestThreadManager parent = socketComunicationParams
		.getParentRequestThreadManager();

	String endCommMsg = socketComunicationParams.getEndCommMsg();

	try {
	    Long matricula = parent.handleIpSuccess(json);
	    if (matricula != null) {
		// Tenemos una matrícula nueva, así que la enviamos al
		// agente
		logger.info("New generated id " + matricula
			+ " will be sent to IP: " + ip);
		endCommMsg += ":" + matricula;
	    }
	} catch (Exception e) {
	    logger.error(
		    "An error happened while saving data received from ip: "
			    + ip + "\nJson: " + json, e);
	}

	return endCommMsg;
    }

    private void generateUpdateDataResponseMessageToRoot(String jsonResponse) {

	ATMUpdateResponseAdapter responseAdapter = ATMUpdateAdapterFactory
		.getUpdateResponseAdapter(ATMUpdateAdapterFactory.SOCKET_COMMUNICATION_ADAPTER);
	responseAdapter.setupResponseAdapter(this.socketComunicationParams
		.getSpringContext());
	UpdateDataRequest originalRequestData = generatetOriginalRequestData();

	responseAdapter.generateUpdateDataMessageToRoot(jsonResponse,
		originalRequestData);
    }

    private UpdateDataRequest generatetOriginalRequestData() {

	String atmIp = this.updateInfo.getAtmIp();
	long atmMatricula = this.updateInfo.getAtmMatricula();
	UpdateDataRequest originalRequestData = new UpdateDataRequest(atmIp,
		atmMatricula);
	return originalRequestData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serverchain.adapter.ATMUpdateRequestAdapter#
     * requestUpdateToRoot()
     */
    @Override
    public void requestUpdateToRoot() {

	String ip = this.updateInfo.getAtmIp();
	long matricula = this.updateInfo.getAtmMatricula();

	if (this.isOnlyNode()) {

	    this.requestUpdateToRootOnlyNode(ip, matricula);

	} else {

	    this.requestUpdateToRootServerChain(ip, matricula);
	}

    }

    private void requestUpdateToRootOnlyNode(String ip, long matricula) {

	SocketListener socketListener = socketComunicationParams
		.getSocketListenerParent();

	socketListener.requestData(ip, matricula);

	logger.info("Update request from " + ip + " sent to SocketListener");
    }

    private void requestUpdateToRootServerChain(String ip, long matricula) {

	UpdateSelfRequest selfRequest = new UpdateSelfRequest(ip, matricula);

	String wrapperInfoMessage = "ATM Update request  Message from: "
		+ this.nodeInformation.getLocalUrl();

	this.publishMessageToRoot(matricula, wrapperInfoMessage, selfRequest);

	logger.info("Update request from " + ip + " sent to root");
    }

    /*-************************************************************************
     * code copied from RequestThread
     */
    /**
     * Code executed before requesting data from an ATM for confirming it is
     * reliable.
     * 
     * For confirming an ATM's reliability we send it a random string which it
     * must hash, along with a hardcoded one and a configurable one, and then
     * send us the result so we can check whether it matches the expected one.
     * If we detect the agent is using an old version of the configurable
     * string, then we send it the new version so it can replace it.
     * 
     * @param socket
     *            the socket
     * @return true, if successful
     */
    private boolean confirmIdentity(Socket socket) {

	
	RequestThreadManager parent = socketComunicationParams
		.getParentRequestThreadManager();
	String hashSeed = socketComunicationParams.getHashSeed();
	String authOkMsg = socketComunicationParams.getAuthOkMsg();
	String authUpdateMsg = socketComunicationParams.getAuthUpdateMsg();
	String authErrorMsg = socketComunicationParams.getAuthErrorMsg();

	try {
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    // Enviamos al agente la cadena base para el hash
	    String randomSeed = RandomStringUtils.randomAlphanumeric(20);
	    logger.info("Sending the authentication data [" + hashSeed
		    + "] to " + socket.getInetAddress().getHostAddress() + ":"
		    + socket.getPort());
	    out.println(randomSeed);

	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    socket.getInputStream()));
	    // Recuperamos el hash
	    String response = in.readLine();
	    logger.info("Authentication data received [" + response
		    + "] from IP: " + socket.getInetAddress().getHostAddress());
	    String parentSeed = parent.getHashSeed();
	    String hash = Utils.getMD5Hex(Utils.getMD5Hex(parentSeed)
		    + Utils.getMD5Hex(hashSeed) + Utils.getMD5Hex(randomSeed));
	    if (response.equals(hash)) {
		// Confirmamos al agente que la autenticacion fue correcta
		out.println(authOkMsg);
		return true;
	    } else {
		String oldParentSeed = parent.getOldHashSeed();
		if ((oldParentSeed != null)
			&& (!oldParentSeed.equals(parentSeed))) {
		    hash = Utils.getMD5Hex(Utils.getMD5Hex(oldParentSeed)
			    + Utils.getMD5Hex(hashSeed)
			    + Utils.getMD5Hex(randomSeed));
		    if (response.equals(hash)) {
			logger.warn("Old hash seed has been detected in IP "
				+ socket.getInetAddress().getHostAddress()
				+ ". New one will be sent.");
			// Confirmamos al agente que la autenticaci�n fue
			// correcta y le pedimos que actualice su hash
			out.println(authUpdateMsg + ":" + oldParentSeed + ":"
				+ parentSeed);
			return true;
		    }
		}
	    }

	    // La autenticacion ha fallado, avisamos al agente y terminamos
	    out.println(authErrorMsg);
	} catch (SocketTimeoutException e) {
	    logger.error("We received no response during"
		    + " authentication from IP: "
		    + socket.getInetAddress().getHostAddress(), e);
	} catch (IOException e) {
	    logger.error("An exception was thrown while"
		    + " confirming identity of IP: "
		    + socket.getInetAddress().getHostAddress(), e);
	}
	return false;
    }

    /**
     * Request data json from an ATM.
     * 
     * @param ip
     *            the ATM ip
     * @throws Exception
     *             any kind of exception thrown with an error
     */
    private void requestDataJson(String ip) throws Exception {

	int agentPort = socketComunicationParams.getAgentPort();
	String endCommMsg = socketComunicationParams.getEndCommMsg();
	int timeOut = socketComunicationParams.getTimeOut();

	try {
	    // Abrimos el socket y un buffer de lectura
	    Socket socket = RequestThreadManager.getClientSocketFactory()
		    .createSocket(ip, agentPort);

	    // Ponemos un timeout para la recepcion de datos
	    socket.setSoTimeout(timeOut * 1000);

	    // Confirmamos la identidad del agente
	    if (confirmIdentity(socket)) {
		logger.info("Id confirmed for IP: " + ip);
	    } else {
		logger.error("Id couldn't be confirmed for IP: " + ip);
		socket.close();
		return;
	    }

	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    socket.getInputStream()));
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    String json;
	    String endMsg = endCommMsg;

	    try {
		// // Recuperamos el Json con los datos del DataStore
		json = in.readLine();
		logger.info("Data received from IP: " + ip);

		endMsg = this.handleATMResponse(json, ip);

		// Enviamos el mensaje que confirma el final de la comunicacion
		logger.info("Sending final comm message to IP: " + ip);
		out.println(endMsg);
	    } catch (SocketTimeoutException e) {
		logger.error(ATMUpdateRequestException.NO_RESPONSE_ERROR + ip,
			e);
		throw new ATMUpdateRequestException(
			ATMUpdateRequestException.NO_RESPONSE_ERROR + ip, e);
	    } finally {
		// Cerramos los recursos abiertos
		socket.close();
	    }
	    // Todo ha ido bien, terminamos.
	    return;

	} catch (UnknownHostException e) {
	    logger.error(ATMUpdateRequestException.UNKNOWN_HOST_ERROR + ip, e);
	    throw new ATMUpdateRequestException(
		    ATMUpdateRequestException.UNKNOWN_HOST_ERROR + ip, e);
	} catch (IOException e) {
	    logger.error(
		    ATMUpdateRequestException.GENERAL_ERROR_WHILE_REQUESTING_DATA
			    + ip, e);
	    throw new ATMUpdateRequestException(
		    ATMUpdateRequestException.GENERAL_ERROR_WHILE_REQUESTING_DATA
			    + ip, e);
	}
    }

}
