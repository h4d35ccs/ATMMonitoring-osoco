package com.ncr.ATMMonitoring.snmp;

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import ncr.inventory.Inventory;
import ncr.inventory.data.ATM;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.service.TerminalService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Component
public class SnmpListener extends Inventory {

    static private Logger logger = Logger.getLogger(SnmpListener.class.getName());
    static private ConcurrentLinkedQueue<String> waitingIps = new ConcurrentLinkedQueue<String>();
    @Value("${config.snmpTimeOut}")
    private int timeOut;
    // @Value("${config.backgroundListener}")
    private String listenerState = "off";
    @Autowired
    private TerminalService terminalService;

    public SnmpListener() {
    	//super(Thread.currentThread().getContextClassLoader().getResource("inventory.properties").getPath());
    	//Eva - 14/03/2013 - Base name for the properties file
    	super("inventory.properties");
    }

    @Override
    protected void processReceivedATM(ATM atm) {
		waitingIps.remove(atm.getIp());
		terminalService.persistSnmpTerminal(atm);
    }

    public void requestTerminalUpdate(String ip) throws SnmpTimeOutException {
		logger.debug("Requesting update for terminal with IP " + ip);
		if (!waitingIps.contains(ip)) {
		    waitingIps.add(ip);
		}
		setSchedulerUpdate(ip);
		for (int t = 0; t < (timeOut * 4); t++) {
		    try {
		    	Thread.sleep(250);
		    } catch (InterruptedException e) {
				logger.error(
					"There was a problem while waiting for the response" + " from the terminal with the IP" + ip, e);
				e.printStackTrace();
		    }
		    if (!waitingIps.contains(ip)) {
				logger.debug("Received response from terminal with IP " + ip);
				return;
		    }
		}
		logger.error("No response received in " + timeOut + " seconds from the terminal with the IP" + ip);
		throw new SnmpTimeOutException(ip);
    }

    @PostConstruct
    public void checkInit() {
		if ((listenerState != null) && (listenerState.equalsIgnoreCase("on"))) {
		    logger.info("Initializing trap listener...");
		    this.init();
		    logger.info("Trap listener initialized!!");
		} else {
		    logger.warn("Trap listener is not being initialized, SNMP updates won't be available.");
		}
    }

    @PreDestroy
    public void checkDestroy() {
		if ((listenerState != null) && (listenerState.equalsIgnoreCase("on"))) {
		    logger.info("Releasing resources from trap listener...");
		    this.destroy();
		    logger.info("Trap listener resources released!!");
		}
    }
}
