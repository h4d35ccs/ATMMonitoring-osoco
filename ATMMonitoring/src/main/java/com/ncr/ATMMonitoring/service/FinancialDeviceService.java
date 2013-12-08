package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

// TODO: Auto-generated Javadoc
/**
 * The Interface FinancialDeviceService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface FinancialDeviceService {

    /**
     * Adds the financial device.
     *
     * @param financialDevice the financial device
     */
    public void addFinancialDevice(FinancialDevice financialDevice);

    /**
     * Removes the financial device.
     *
     * @param id the id
     */
    public void removeFinancialDevice(Integer id);

    /**
     * Gets the financial device.
     *
     * @param id the id
     * @return the financial device
     */
    public FinancialDevice getFinancialDevice(Integer id);

    /**
     * List financial devices.
     *
     * @return the list
     */
    public List<FinancialDevice> listFinancialDevices();
}