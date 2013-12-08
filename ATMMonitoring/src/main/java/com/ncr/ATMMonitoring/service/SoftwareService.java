package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Software;

// TODO: Auto-generated Javadoc
/**
 * The Interface SoftwareService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareService {

    /**
     * Adds the software.
     *
     * @param software the software
     */
    public void addSoftware(Software software);

    /**
     * Gets the software.
     *
     * @param id the id
     * @return the software
     */
    public Software getSoftware(Integer id);

    /**
     * Gets the software by identifying number.
     *
     * @param id the id
     * @return the software by identifying number
     */
    public Software getSoftwareByIdentifyingNumber(String id);

    /**
     * List software.
     *
     * @return the list
     */
    public List<Software> listSoftware();
}