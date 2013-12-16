package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.OperatingSystem;

// TODO: Auto-generated Javadoc
/**
 * The Interface OperatingSystemService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface OperatingSystemService {

    /**
     * Adds the operating system.
     *
     * @param operatingSystem the operating system
     */
    public void addOperatingSystem(OperatingSystem operatingSystem);

    /**
     * Gets the operating system.
     *
     * @param id the id
     * @return the operating system
     */
    public OperatingSystem getOperatingSystem(Integer id);

    /**
     * Gets the operating system by serial number.
     *
     * @param number the number
     * @return the operating system by serial number
     */
    public OperatingSystem getOperatingSystemBySerialNumber(String number);

    /**
     * List operating system.
     *
     * @return the list
     */
    public List<OperatingSystem> listOperatingSystem();
}