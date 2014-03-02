package com.ncr.ATMMonitoring.utils;

public class TrialEndedException extends Exception {

    public TrialEndedException(String msg) {
	super(msg);
    }

    public TrialEndedException(String msg, Exception e) {
	super(msg, e);
    }

    private static final long serialVersionUID = 8973608074217634386L;

}
