package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

// TODO: Auto-generated Javadoc
/**
 * The Interface HardwareDeviceService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HardwareDeviceService {

    /**
     * Adds the hardware device.
     *
     * @param hardwareDevice the hardware device
     */
    public void addHardwareDevice(HardwareDevice hardwareDevice);

    /**
     * Removes the hardware device.
     *
     * @param id the id
     */
    public void removeHardwareDevice(Integer id);

    /**
     * Gets the hardware device.
     *
     * @param id the id
     * @return the hardware device
     */
    public HardwareDevice getHardwareDevice(Integer id);

    /**
     * List hardware devices.
     *
     * @return the list
     */
    public List<HardwareDevice> listHardwareDevices();
}