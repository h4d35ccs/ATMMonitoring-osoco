package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

// TODO: Auto-generated Javadoc
/**
 * The Interface FinancialDeviceDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface FinancialDeviceDAO {

    /**
     * Adds the financial device.
     *
     * @param financialDevice the financial device
     */
    public void addFinancialDevice(FinancialDevice financialDevice);

    /**
     * List financial devices.
     *
     * @return the list
     */
    public List<FinancialDevice> listFinancialDevices();

    /**
     * Gets the financial device.
     *
     * @param id the id
     * @return the financial device
     */
    public FinancialDevice getFinancialDevice(Integer id);

    /**
     * Removes the financial device.
     *
     * @param id the id
     */
    public void removeFinancialDevice(Integer id);
}
