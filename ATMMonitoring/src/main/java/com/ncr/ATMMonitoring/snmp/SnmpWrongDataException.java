package com.ncr.ATMMonitoring.snmp;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SnmpWrongDataException extends Exception {

    private static final long serialVersionUID = 7222317410564854558L;

    public SnmpWrongDataException(String message) {
	super(message);
    }
}
