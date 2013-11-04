package com.ncr.ATMMonitoring.socket;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class ATMWrongDataException extends Exception {

    private static final long serialVersionUID = 8600512565515109648L;

    public ATMWrongDataException(String message) {
	super(message);
    }
}
