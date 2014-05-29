package com.ncr.ATMMonitoring.serverchain.adapter;

import org.springframework.context.ApplicationContext;

import com.ncr.ATMMonitoring.socket.RequestThreadManager;
import com.ncr.ATMMonitoring.socket.SocketListener;

/**
 * @author Otto Abreu
 *
 */
public class ATMSocketCommunicationParams {
    
    /** The Constant hashSeed. */
    private  String hashSeed;

    /** The Constant authOkMsg. */
    private  String authOkMsg;

    /** The Constant authErrorMsg. */
    private  String authErrorMsg ;

    /** The Constant authUpdateMsg. */
    private  String authUpdateMsg;

    /** The Constant endCommMsg. */
    private  String endCommMsg;
    
    /** The agent port. */
    private int agentPort;

    /** The response time out. */
    private int timeOut;

    /** The parent manager. */
    private RequestThreadManager parentRequestThreadManager;

    /** The number of ips to notify. */
    private int requestNumber;
        
    private ApplicationContext springContext;
    
    private SocketListener socketListenerParent;
    
    
    public String getHashSeed() {
        return hashSeed;
    }

    public void setHashSeed(String hashSeed) {
        this.hashSeed = hashSeed;
    }

    public String getAuthOkMsg() {
        return authOkMsg;
    }

    public void setAuthOkMsg(String authOkMsg) {
        this.authOkMsg = authOkMsg;
    }

    public String getAuthErrorMsg() {
        return authErrorMsg;
    }

    public void setAuthErrorMsg(String authErrorMsg) {
        this.authErrorMsg = authErrorMsg;
    }

    public String getAuthUpdateMsg() {
        return authUpdateMsg;
    }

    public void setAuthUpdateMsg(String authUpdateMsg) {
        this.authUpdateMsg = authUpdateMsg;
    }

    public String getEndCommMsg() {
        return endCommMsg;
    }

    public void setEndCommMsg(String endCommMsg) {
        this.endCommMsg = endCommMsg;
    }

    public int getAgentPort() {
        return agentPort;
    }

    public void setAgentPort(int agentPort) {
        this.agentPort = agentPort;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public RequestThreadManager getParentRequestThreadManager() {
        return parentRequestThreadManager;
    }

    public void setParentRequestThreadManager(
    	RequestThreadManager parentRequestThreadManager) {
        this.parentRequestThreadManager = parentRequestThreadManager;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public ApplicationContext getSpringContext() {
        return springContext;
    }

    public void setSpringContext(ApplicationContext springContext) {
        this.springContext = springContext;
    }

    public SocketListener getSocketListenerParent() {
        return socketListenerParent;
    }

    public void setSocketListenerParent(SocketListener socketListenerParent) {
        this.socketListenerParent = socketListenerParent;
    }



}