package com.ncr.ATMMonitoring.socket;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SocketTimeOutException extends Exception {

    private static final long serialVersionUID = -2908900346083264402L;
    protected Set<String> ips = new HashSet<String>();

    public SocketTimeOutException(String string) {
	super();
	ips.add(string);
    }

    public SocketTimeOutException(Set<String> strings) {
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
