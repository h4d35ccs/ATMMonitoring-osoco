package com.ncr.ATMMonitoring.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RequestThread extends Thread {

    static private Logger logger = Logger.getLogger(SocketListenerThread.class
	    .getName());
    private Set<String> ips;
    private int agentPort;
    private int timeOut;
    private RequestThreadManager parent;

    public RequestThread(Set<String> ips, int agentPort, int timeOut,
	    RequestThreadManager parent) {
	this.ips = ips;
	this.agentPort = agentPort;
	this.timeOut = timeOut;
	this.parent = parent;
    }

    public Set<String> getIps() {
	return ips;
    }

    private void requestDataJson(String ip) throws Exception {

	Socket socket = null;
	BufferedReader in = null;

	try {
	    // Abrimos el socket y un buffer de lectura
	    socket = new Socket(ip, agentPort);
	    // Ponemos un timeout para la recepción de datos
	    socket.setSoTimeout(timeOut * 1000);

	    in = new BufferedReader(new InputStreamReader(
		    socket.getInputStream()));
	    String json;
	    try {
		// Recuperamos el Json con los datos del DataStore
		json = in.readLine();
		logger.info("Data received from IP: " + ip);
	    } catch (SocketTimeoutException e) {
		logger.error("We received no response from IP: " + ip, e);
		throw e;
	    } finally {
		// Cerramos los recursos abiertos
		in.close();
		socket.close();
	    }
	    try {
		parent.handleIpSuccess(json);
	    } catch (Exception e) {
		logger.error(
			"An error happened while saving data received from ip: "
				+ ip + "\nJson: " + json, e);
	    }
	    // Todo ha ido bien, terminamos.
	    return;

	} catch (UnknownHostException e) {
	    logger.error("Don't know about host: " + ip, e);
	    throw e;
	} catch (IOException e) {
	    logger.error("An exception was thrown while"
		    + " requesting data from IP: " + ip, e);
	    throw e;
	}
    }

    public void run() {
	for (String ip : ips) {
	    try {
		requestDataJson(ip);
	    } catch (Exception e) {
		logger.warn(
			"Couldn't update terminal with IP"
				+ ip
				+ ". Ip will be requested again in next request phase...",
			e);
		parent.handleIpError(ip);
	    }
	}
    }
}
