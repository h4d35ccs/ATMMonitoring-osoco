package com.ncr.ATMMonitoring.socket;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.agent.baseData.ATMDataStorePojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
public class SocketServiceImpl implements SocketService {

    static private Logger logger = Logger.getLogger(SocketServiceImpl.class
	    .getName());

    private Set<String> awaitingIps = Collections
	    .synchronizedSet(new HashSet<String>());

    @Value("${config.maxNumberUpdateThreads}")
    private double maxThreads;
    @Value("${config.maxNumberTerminalsPerThread}")
    private double maxTerminals;
    @Value("${config.socketTimeOut}")
    private int timeOut;
    @Value("${config.agentSocketPort}")
    private int agentPort;
    @Value("${config.sleepTimeRequestManager}")
    private int sleepTime;
    @Value("${config.maxTimeRequestThread}")
    private int maxTime;

    @Autowired
    private SocketListener socketListener;
    @Autowired
    private TerminalService terminalService;
    @Autowired
    private QueryService queryService;
    private RequestThreadManager requestThreadManager;

    @PostConstruct
    public void init() {
	socketListener.setSocketService(this);
    }

    @Override
    @Async
    public void updateAllTerminalsSocketAsync() {
	Date now = new Date();
	try {
	    updateAllTerminalsSocket();
	} catch (Exception e) {
	    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,
		    DateFormat.SHORT);
	    logger.error("Async Update that started at [" + df.format(now)
		    + "] raised Exception", e);
	}
    }

    @Override
    public void updateAllTerminalsSocket() {
	List<Terminal> terminals = terminalService.listTerminals();
	for (Terminal terminal : terminals) {
	    updateTerminalSocket(terminal);
	}
    }

    @Override
    public void updateTerminalSocket(Terminal terminal) {
	awaitingIps.add(terminal.getIp());
    }

    @Override
    public void updateTerminalSocket(String ip) {
	awaitingIps.add(ip);
    }

    @Override
    public void updateTerminalsSocket(Collection<String> ips) {
	awaitingIps.addAll(ips);
    }

    @Override
    public void updateTerminalsSocket(Query query) {
	if (query != null) {
	    Set<String> ips = new HashSet<String>();
	    List<Terminal> terminals = queryService.executeQuery(query);
	    for (Terminal terminal : terminals) {
		ips.add(terminal.getIp());
	    }
	    updateTerminalsSocket(ips);
	}
    }

    @Override
    @Scheduled(cron = "30 * * * * *")
    public void processAwaitingIps() {
	logger.info("Checking the IPs waiting for update...");
	if (awaitingIps.isEmpty()) {
	    return;
	}
	if ((requestThreadManager != null) && requestThreadManager.isAlive()) {
	    logger.info("Request threads manager still busy with previous requests...");
	    return;
	}
	logger.info("Processing the IPs waiting for update...");
	Set<String> aux;
	synchronized (awaitingIps) {
	    aux = new HashSet<String>(awaitingIps);
	    awaitingIps.clear();
	}
	requestThreadManager = new RequestThreadManager(maxThreads,
		maxTerminals, timeOut, agentPort, sleepTime, maxTime, this, aux);
	requestThreadManager.start();
    }

    public void processTerminalJson(String json) {
	// logger.debug("Json received: " + json);
	ATMDataStorePojo data = ATMDataStorePojo.fromJson(json);
	logger.debug("ATMDataStore received: " + data.toString());
	// logger.debug("Resulting Json: " + data.toJson());
	terminalService.persistDataStoreTerminal(data);
    }
}