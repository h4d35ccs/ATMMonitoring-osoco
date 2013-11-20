package com.ncr.ATMMonitoring.socket;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RequestThreadManager extends Thread {

    static private Logger logger = Logger.getLogger(RequestThreadManager.class
	    .getName());
    static private ServerSocketFactory SERVER_SOCKET_FACTORY;
    static private SocketFactory CLIENT_SOCKET_FACTORY;

    static {
	TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	    }

	    public void checkClientTrusted(X509Certificate[] certs,
		    String authType) {
	    }

	    public void checkServerTrusted(X509Certificate[] certs,
		    String authType) {
	    }
	} };

	try {
	    Properties props = PropertiesLoaderUtils
		    .loadProperties(new ClassPathResource("config.properties"));
	    KeyManagerFactory kmf = KeyManagerFactory
		    .getInstance(KeyManagerFactory.getDefaultAlgorithm());
	    InputStream in = new ClassPathResource("keystore").getInputStream();
	    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
	    ks.load(in, props.getProperty("security.keystorePass")
		    .toCharArray());
	    kmf.init(ks, props.getProperty("security.privatekeyPass")
		    .toCharArray());
	    // Install the all-trusting trust manager
	    SSLContext sc = SSLContext.getInstance("SSL");
	    sc.init(kmf.getKeyManagers(),
		    trustAllCerts, new java.security.SecureRandom());
	    SERVER_SOCKET_FACTORY = sc.getServerSocketFactory();
	    CLIENT_SOCKET_FACTORY = sc.getSocketFactory();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private double maxThreads;
    private double maxTerminals;
    private int timeOut;
    private int agentPort;
    private int sleepTime;
    private int maxTime;
    private SocketService socketService;

    private Set<String> ips;
    private List<RequestThread> threads = Collections
	    .synchronizedList(new ArrayList<RequestThread>());

    public RequestThreadManager(double maxThreads, double maxTerminals,
	    int timeOut, int agentPort, int sleepTime, int maxTime,
	    SocketService socketService, Set<String> ips) {
	this.maxThreads = maxThreads;
	this.maxTerminals = maxTerminals;
	this.timeOut = timeOut;
	this.agentPort = agentPort;
	this.sleepTime = sleepTime;
	this.maxTime = maxTime;
	this.socketService = socketService;
	this.ips = ips;
    }

    public void handleIpSuccess(String json) {
	socketService.processTerminalJson(json);
    }

    public void handleIpError(String ip) {
	socketService.updateTerminalSocket(ip);
    }

    public void run() {
	try {
	    Iterator<String> iterator = ips.iterator();
	    Set<String> subSet;
	    String ip;
	    RequestThread thread;
	    if (ips.size() > (maxThreads * maxTerminals)) {
		// El número de ips no nos permite mantener el número máximo de
		// threads y de ips por cada una. Dividimos de la manera más
		// equitativa entre el número máximo de threads.
		double size = ips.size() / maxThreads;
		double roundedSize = Math.floor(size);
		int remainingTerminals = 0;
		if (size != roundedSize) {
		    remainingTerminals = ips.size()
			    - new Double(roundedSize * maxThreads).intValue();
		}
		int j;
		for (int i = 1; i <= maxThreads; i++) {
		    subSet = new HashSet<String>();
		    j = 0;
		    while (iterator.hasNext() && (j++ < roundedSize)) {
			ip = iterator.next();
			logger.info("IP " + ip + " is gonna be updated...");
			subSet.add(ip);
		    }
		    if ((remainingTerminals > 0) && (iterator.hasNext())) {
			remainingTerminals--;
			ip = iterator.next();
			logger.info("IP " + ip + " is gonna be updated...");
			subSet.add(ip);
			j++;
		    }
		    if (j > 0) {
			logger.info("We create thread number " + i
				+ " for updating a collection of IPs...");
			thread = new RequestThread(subSet, agentPort, timeOut,
				this);
			thread.start();
			threads.add(thread);
		    }
		}
	    } else {
		// Podemos dividirlo entre n threads que no sobrepasan el número
		// máximo de ips
		int j = 0, i = 1;
		subSet = new HashSet<String>();
		while (iterator.hasNext()) {
		    ip = iterator.next();
		    logger.info("IP " + ip + " is gonna be updated...");
		    subSet.add(ip);
		    if ((++j == maxTerminals) || !iterator.hasNext()) {
			logger.info("We create thread number " + i++
				+ " for updating a collection of IPs...");
			thread = new RequestThread(subSet, agentPort, timeOut,
				this);
			thread.start();
			threads.add(thread);
			subSet = new HashSet<String>();
			j = 0;
		    }
		}
	    }
	    // Calculamos el nº máximo de ciclos de comprobación
	    double cycles = Math.ceil(maxTime / sleepTime);
	    while (!threads.isEmpty() && (cycles-- > 0)) {
		try {
		    Thread.sleep(sleepTime * 1000);
		    Iterator<RequestThread> iter = threads.iterator();
		    while (iter.hasNext()) {
			if (!iter.next().isAlive()) {
			    iter.remove();
			}
		    }
		} catch (InterruptedException e) {
		    logger.error("Error while sleeping"
			    + " between request threads checks...", e);
		}
	    }
	    // Si la colección no está vacía, es que no han terminado a tiempo.
	    if (!threads.isEmpty()) {
		logger.warn("Some request threads somehow couldn't finish in the configured max time."
			+ " Their ips will be requested again at next request phase...");
		for (RequestThread auxThread : threads) {
		    socketService.updateTerminalsSocket(auxThread.getIps());
		}
	    }
	} catch (Exception e) {
	    logger.error("Unexpected error when"
		    + " requesting updates to ips...", e);
	    for (Thread thread : threads) {
		thread.interrupt();
	    }
	    threads.clear();
	    socketService.updateTerminalsSocket(ips);
	}
    }

    /**
     * @return the serverSocketFactory
     */
    public static ServerSocketFactory getServerSocketFactory() {
	return SERVER_SOCKET_FACTORY;
    }

    /**
     * @return the clientSocketFactory
     */
    public static SocketFactory getClientSocketFactory() {
	return CLIENT_SOCKET_FACTORY;
    }
}
