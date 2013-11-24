package com.ncr.ATMMonitoring.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SocketListenerThread extends Thread {

    static private Logger logger = Logger.getLogger(SocketListenerThread.class
	    .getName());
    private String okMessage;
    private Socket socket;
    private SocketListener parent;

    public SocketListenerThread(Socket socket, String okMessage,
	    SocketListener parent) {
	this.socket = socket;
	this.okMessage = okMessage;
	this.parent = parent;
    }

    public void run() {
	String ip = socket.getInetAddress().getHostAddress();
	logger.info("Update requested from IP: " + ip);

	try {
	    try {
		PrintWriter out = new PrintWriter(socket.getOutputStream(),
			true);
		// Confirmamos al agente que hemos recibido la petición
		out.println(okMessage);
		logger.info("Update request confirmed ('" + okMessage
			+ "') to IP: " + ip);

		// Pedimos los datos al agente
		parent.requestData(ip);
	    } catch (IOException e) {
		logger.error("An exception was thrown while processing "
			+ "an update request from IP: " + ip, e);
	    } finally {
		socket.close();
	    }
	} catch (IOException e) {
	    logger.error("An exception was thrown while processing "
		    + "an update request from IP: " + ip, e);
	}
    }
}
