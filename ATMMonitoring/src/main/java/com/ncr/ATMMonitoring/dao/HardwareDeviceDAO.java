package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

// TODO: Auto-generated Javadoc
/**
 * The Interface HardwareDeviceDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HardwareDeviceDAO {

    /**
     * Adds the hardware device.
     *
     * @param hardwareDevice the hardware device
     */
    public void addHardwareDevice(HardwareDevice hardwareDevice);

    /**
     * List hardware devices.
     *
     * @return the list
     */
    public List<HardwareDevice> listHardwareDevices();

    /**
     * Gets the hardware device.
     *
     * @param id the id
     * @return the hardware device
     */
    public HardwareDevice getHardwareDevice(Integer id);

    /**
     * Removes the hardware device.
     *
     * @param id the id
     */
    public void removeHardwareDevice(Integer id);
}
