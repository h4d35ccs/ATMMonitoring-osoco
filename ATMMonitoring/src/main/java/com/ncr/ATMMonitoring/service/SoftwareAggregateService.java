package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareAggregateService {

    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate);

    public void removeSoftwareAggregate(Integer id);

    public SoftwareAggregate getSoftwareAggregateByVersionName(
	    Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name);

    public SoftwareAggregate getSoftwareAggregate(Integer id);

    public List<SoftwareAggregate> listSoftwareAggregate();
}