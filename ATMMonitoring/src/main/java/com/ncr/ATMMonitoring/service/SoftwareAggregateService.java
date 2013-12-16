package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

// TODO: Auto-generated Javadoc
/**
 * The Interface SoftwareAggregateService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareAggregateService {

    /**
     * Adds the software aggregate.
     *
     * @param softwareAggregate the software aggregate
     */
    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate);

    /**
     * Removes the software aggregate.
     *
     * @param id the id
     */
    public void removeSoftwareAggregate(Integer id);

    /**
     * Gets the software aggregate by version name.
     *
     * @param majorVersion the major version
     * @param minorVersion the minor version
     * @param buildVersion the build version
     * @param revisionVersion the revision version
     * @param remainingVersion the remaining version
     * @param name the name
     * @return the software aggregate by version name
     */
    public SoftwareAggregate getSoftwareAggregateByVersionName(
	    Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name);

    /**
     * Gets the software aggregate.
     *
     * @param id the id
     * @return the software aggregate
     */
    public SoftwareAggregate getSoftwareAggregate(Integer id);

    /**
     * List software aggregate.
     *
     * @return the list
     */
    public List<SoftwareAggregate> listSoftwareAggregate();
}