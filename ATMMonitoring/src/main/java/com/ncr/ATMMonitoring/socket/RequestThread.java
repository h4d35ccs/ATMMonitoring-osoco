package com.ncr.ATMMonitoring.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.utils.Utils;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RequestThread extends Thread {

    private static final String hashSeed = "V3zVFyxn9DnToZJ8067i";
    private static final String authOkMsg = "OK";
    private static final String authErrorMsg = "ERROR";
    private static final String authUpdateMsg = "UPDATE";
    private static Logger logger = Logger.getLogger(SocketListenerThread.class
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

    private boolean confirmIdentity(Socket socket) {

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
		// Confirmamos al agente que la autenticación fue correcta
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
			// Confirmamos al agente que la autenticación fue
			// correcta y le pedimos que actualice su hash
			out.println(authUpdateMsg + ":" + oldParentSeed + ":"
				+ parentSeed);
			return true;
		    }
		}
	    }

	    // La autenticación ha fallado, avisamos al agente y terminamos
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

    private void requestDataJson(String ip) throws Exception {

	Socket socket = null;
	BufferedReader in = null;

	try {
	    // Abrimos el socket y un buffer de lectura
	    socket = RequestThreadManager.getClientSocketFactory()
		    .createSocket(ip, agentPort);

	    // Ponemos un timeout para la recepción de datos
	    socket.setSoTimeout(timeOut * 1000);

	    // Confirmamos la identidad del agente
	    if (confirmIdentity(socket)) {
		logger.info("Id confirmed for IP: " + ip);
	    } else {
		logger.error("Id couldn't be confirmed for IP: " + ip);
		socket.close();
		return;
	    }

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
