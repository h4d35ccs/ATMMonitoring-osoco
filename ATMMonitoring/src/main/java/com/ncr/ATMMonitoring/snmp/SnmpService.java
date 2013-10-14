package com.ncr.ATMMonitoring.snmp;

import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SnmpService {

    public void updateAllTerminalsSnmpAsync();

    public void updateAllTerminalsSnmp() throws SnmpTimeOutException;

    public void updateTerminalSnmp(Terminal terminal)
	    throws SnmpTimeOutException;
}