package com.ncr.ATMMonitoring.snmp;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.TerminalDAO;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.TerminalService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */


//Eva 10/06/2013 - Exception "org.hibernate.HibernateException: No Session found for current thread"
//Added @Transactional
@Service
@Transactional
public class SnmpServiceImpl implements SnmpService {

    static private Logger logger = Logger.getLogger(SnmpServiceImpl.class
	    .getName());

    @Autowired
    private TerminalService terminalService;
    @Autowired
    private SnmpListener snmpListener;
    @Autowired
    private QueryService queryService;

    @Override
    @Async
    public void updateAllTerminalsSnmpAsync() {
		Date now = new Date();
		try {
		    updateAllTerminalsSnmp();
		} catch (Exception e) {
		    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,
			    DateFormat.SHORT);
		    logger.error("Async Update that started at [" + df.format(now)
			    + "] raised Exception", e);
		}
    }

    @Override
    public void updateAllTerminalsSnmp() throws SnmpTimeOutException {
		Set<String> errorIps = new HashSet<String>();
		List<Terminal> terminals = terminalService.listTerminals();
		for (Terminal terminal : terminals) {
		    try {
		    	updateTerminalSnmp(terminal);
		    } catch (SnmpTimeOutException e) {
		    	errorIps.add(e.getIpsHtmlList());
		    } catch (Exception e) {
		    	logger.error(
		    			"Exception raised while updating all Terminals by SNMP",
		    			e);
		    }
		}
		if (!errorIps.isEmpty()) {
		    throw new SnmpTimeOutException(errorIps);
		}
    }

    @Override
    public void updateTerminalSnmp(Terminal terminal) throws SnmpTimeOutException 
	{
		String ip = terminal.getIp();
		if ((ip != null) && (ip.split("\\.").length >= 4)) {
		    snmpListener.requestTerminalUpdate(ip);
		}
    }

    @Override
    public void updateTerminalSnmp(String ip) {
    	logger.info("MOCK updateTerminalsSnmp" + ip);
    }

    @Override
    public void updateTerminalsSnmp(Collection<String> ips) {
    	logger.info("MOCK updateTerminalsSnmp" + ips.toString());
    }

    @Override
    public void updateTerminalsSnmp(Query query) {
	if (query != null) {
	    Set<String> ips = new HashSet<String>();
	    List<Terminal> terminals = queryService.executeQuery(query);
	    for (Terminal terminal : terminals) {
		ips.add(terminal.getIp());
	    }
	    updateTerminalsSnmp(ips);
	}
    }
}