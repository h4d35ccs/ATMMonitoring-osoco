package com.ncr.ATMMonitoring.updatequeue;

import java.io.Serializable;

/**
 * Holds the update information of an ATM.
 * 
 * This class is used as a message in the update queue
 * 
 * @author Otto Abreu
 * 
 */
public class ATMUpdateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String atmIp;

    private Long atmMatricula;

    public ATMUpdateInfo(String atmIp, Long atmMatricula) {
	super();
	this.atmIp = atmIp;
	this.atmMatricula = atmMatricula;
	// Added because the test database
	// have ip's with whitespace in the end
	if (this.atmIp != null) {
	    this.atmIp = this.atmIp.trim();
	}
    }

    public String getAtmIp() {
	return atmIp;
    }

    public void setAtmIp(String atmIp) {
	this.atmIp = atmIp;
    }

    public Long getAtmMatricula() {
	return atmMatricula;
    }

    public void setAtmMatricula(Long atmMatricula) {
	this.atmMatricula = atmMatricula;
    }

    @Override
    public boolean equals(Object obj) {

	boolean isEqual = false;

	if (obj instanceof ATMUpdateInfo) {

	    ATMUpdateInfo otherObject = (ATMUpdateInfo) obj;

	    if (this.equalNonNullValues(otherObject)) {

		isEqual = true;

	    }
	}
	return isEqual;

    }

    private boolean equalNonNullValues(ATMUpdateInfo otherObject) {

	if ((otherObject.getAtmIp() != null 
		&& otherObject.getAtmIp().equals(this.getAtmIp()))

		&& (otherObject.getAtmMatricula() != null && otherObject
			.getAtmMatricula().equals(this.atmMatricula))) {

	    return true;

	} else {
	    return false;
	}
    }

    @Override
    public String toString() {

	StringBuilder builder = new StringBuilder();
	builder.append("ATMUpdateInfo [");
	if (atmIp != null) {
	    builder.append("atmIp=");
	    builder.append(atmIp);
	    builder.append(", ");
	}
	if (atmMatricula != null) {
	    builder.append("atmMatricula=");
	    builder.append(atmMatricula);
	}
	builder.append("]");
	return builder.toString();
    }

}
