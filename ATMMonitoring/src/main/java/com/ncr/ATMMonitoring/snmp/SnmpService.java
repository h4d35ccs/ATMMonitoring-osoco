package com.ncr.ATMMonitoring.snmp;

import java.util.Collection;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SnmpService {

    public void updateAllTerminalsSnmpAsync();

    public void updateAllTerminalsSnmp() throws SnmpTimeOutException;

    public void updateTerminalSnmp(Terminal terminal)
	    throws SnmpTimeOutException;

    public void updateTerminalSnmp(String ip);

    public void updateTerminalsSnmp(Collection<String> ips);

    public void updateTerminalsSnmp(Query query);
}