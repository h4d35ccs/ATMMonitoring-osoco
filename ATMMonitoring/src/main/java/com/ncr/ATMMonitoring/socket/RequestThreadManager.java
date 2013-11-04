package com.ncr.ATMMonitoring.socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RequestThreadManager extends Thread {

    static private Logger logger = Logger.getLogger(RequestThreadManager.class
	    .getName());

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
}
