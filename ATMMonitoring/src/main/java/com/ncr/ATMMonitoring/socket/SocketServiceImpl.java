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
 * The Class SocketServiceImpl.
 * 
 * Default implementation of SocketService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
public class SocketServiceImpl implements SocketService {

    /** The logger. */
    static private Logger logger = Logger.getLogger(SocketServiceImpl.class
	    .getName());

    /** The ips waiting to be requested their data. */
    private Set<String> awaitingIps = Collections
	    .synchronizedSet(new HashSet<String>());

    /** The max number of threads. */
    @Value("${config.maxNumberUpdateThreads}")
    private double maxThreads;
    
    /** The max number of terminals per thread. */
    @Value("${config.maxNumberTerminalsPerThread}")
    private double maxTerminals;
    
    /** The response time out. */
    @Value("${config.socketTimeOut}")
    private int timeOut;
    
    /** The agent port. */
    @Value("${config.agentSocketPort}")
    private int agentPort;
    
    /** The sleep time between checks onto the sub-threads. */
    @Value("${config.sleepTimeRequestManager}")
    private int sleepTime;
    
    /** The max time we wait for the whole process to end. */
    @Value("${config.maxTimeRequestThread}")
    private int maxTime;
    
    /** The current hash seed for confirming ATM's identity. */
    @Value("${security.hashSeed}")
    private String hashSeed;
    
    /** The old hash seed for confirming ATM's identity. */
    @Value("${security.oldHashSeed}")
    private String oldHashSeed;

    /** The socket listener. */
    @Autowired
    private SocketListener socketListener;
    
    /** The terminal service. */
    @Autowired
    private TerminalService terminalService;
    
    /** The query service. */
    @Autowired
    private QueryService queryService;
    
    /** The request thread manager. */
    private RequestThreadManager requestThreadManager;

    /**
     * Inits the socketListener by setting this object as its service.
     */
    @PostConstruct
    public void init() {
	socketListener.setSocketService(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#updateAllTerminalsSocket()
     */
    @Override
    public void updateAllTerminalsSocket() {
	List<Terminal> terminals = terminalService.listTerminals();
	for (Terminal terminal : terminals) {
	    updateTerminalSocket(terminal);
	}
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#updateTerminalSocket(com.ncr.ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void updateTerminalSocket(Terminal terminal) {
	awaitingIps.add(terminal.getIp());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#updateTerminalSocket(java.lang.String)
     */
    @Override
    public void updateTerminalSocket(String ip) {
	awaitingIps.add(ip);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#updateTerminalsSocket(java.util.Collection)
     */
    @Override
    public void updateTerminalsSocket(Collection<String> ips) {
	awaitingIps.addAll(ips);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#updateTerminalsSocket(com.ncr.ATMMonitoring.pojo.Query)
     */
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

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#processAwaitingIps()
     */
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

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#processTerminalJson(java.lang.String)
     */
    public Long processTerminalJson(String json) {
	// logger.debug("Json received: " + json);
	ATMDataStorePojo data = ATMDataStorePojo.fromJson(json);
	logger.debug("ATMDataStore received: " + data.toString());
	// logger.debug("Resulting Json: " + data.toJson());
	Terminal terminal = terminalService.persistDataStoreTerminal(data);
	if ((data.getMatricula() == null)
		|| (data.getMatricula().length() == 0)) {
	    // La matrícula es nueva, la devolvemos
	    return terminal.getMatricula();
	}
	return null;
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#getHashSeed()
     */
    public String getHashSeed() {
	return hashSeed;
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.socket.SocketService#getOldHashSeed()
     */
    public String getOldHashSeed() {
	return oldHashSeed;
    }
}