package com.ncr.ATMMonitoring.snmp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SnmpTimeOutException extends Exception {

    private static final long serialVersionUID = 6146384668025313851L;
    protected Set<String> ips = new HashSet<String>();

    public SnmpTimeOutException(String string) {
	super();
	ips.add(string);
    }

    public SnmpTimeOutException(Set<String> strings) {
	super();
	ips = strings;
    }

    public String getIpsHtmlList() {
	String ipList = "";
	for (String ip : ips) {
	    ipList += "<br>" + ip;
	}
	return ipList.replaceFirst("<br>", "");
    }

    public Set<String> getIps() {
	return ips;
    }

    public String getMessage() {
	return "Timeout expired for answer from Terminals with IPs "
		+ ips.toString();
    }

}
