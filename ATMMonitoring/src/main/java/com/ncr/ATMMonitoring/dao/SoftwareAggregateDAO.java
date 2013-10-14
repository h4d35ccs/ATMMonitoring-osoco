package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareAggregateDAO {

    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate);

    public List<SoftwareAggregate> listSoftwareAggregate();

    public SoftwareAggregate getSoftwareAggregate(Integer id);

    public SoftwareAggregate getSoftwareAggregateByVersionName(
	    Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name);

    public void removeSoftwareAggregate(Integer id);
}
