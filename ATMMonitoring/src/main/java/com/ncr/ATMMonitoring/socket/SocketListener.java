package com.ncr.ATMMonitoring.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.net.ServerSocketFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Component
public class SocketListener extends Thread {

    static private Logger logger = Logger.getLogger(SocketListener.class
	    .getName());
    static private volatile ServerSocket serverSocket;
    static private volatile Thread listener = null;
    @Value("${config.serverSocketPort}")
    private int serverPort;
    @Value("${config.backgroundListener}")
    private String listenerState;
    @Value("${config.agentOkMessage}")
    private String okMessage;

    // Can't autowire because problems will arise related to the circular
    // reference
    // @Autowired
    private SocketService socketService;

    public SocketListener() {
	logger.info("Initializing SocketListener");
    }

    public void setSocketService(SocketService socketService) {
	this.socketService = socketService;
    }

    public SocketListener(String okMessage) {
	this.okMessage = okMessage;
    }

    public void requestData(String ip) {
	socketService.updateTerminalSocket(ip);
    }

    public void run() {
	// Cada vez que nos llegue una petición de conexión, la desviamos a un
	// hilo nuevo
	while (true) {
	    try {
		new SocketListenerThread(serverSocket.accept(), okMessage, this)
			.start();
	    } catch (SocketException e) {
		// Si el listener está a nulo, eso quiere decir que se están
		// liberando los recursos y no es un error
		if (listener == null) {
		    return;
		}
		logger.error("An exception was thrown while processing "
			+ "a socket connection.", e);
	    } catch (Exception e) {
		logger.error("An exception was thrown while processing "
			+ "a socket connection.", e);
	    }
	}
    }

    public void doInit() throws IOException {
	// Abrimos un socket en el puerto designado
	serverSocket = RequestThreadManager.getServerSocketFactory()
		.createServerSocket(serverPort);
	listener = this;
	start();
	logger.info("Server socket listening to port " + serverPort);
    }

    public void doDestroy() throws IOException {
	listener = null;
	serverSocket.close();
    }

    @PostConstruct
    public void checkInit() {
	if ((listenerState != null) && (listenerState.equalsIgnoreCase("on"))) {
	    logger.info("Initializing socket listener...");
	    try {
		doInit();
		logger.info("Socket listener initialized!!");
	    } catch (IOException e) {
		logger.error("Could not listen to port: " + serverPort, e);
	    }
	} else {
	    logger.warn("Socket listener is not being initialized, agent updates won't be available.");
	}
    }

    @PreDestroy
    public void checkDestroy() {
	if (listener != null) {
	    logger.info("Releasing resources from socket listener...");
	    try {
		doDestroy();
		logger.info("Socket listener resources released!!");
	    } catch (IOException e) {
		logger.error("An exception was thrown while closing "
			+ "the listener socket.", e);
	    }
	}
    }
}
