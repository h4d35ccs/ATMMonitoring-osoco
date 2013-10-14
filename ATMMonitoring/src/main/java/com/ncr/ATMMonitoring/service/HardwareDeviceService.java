package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HardwareDeviceService {

    public void addHardwareDevice(HardwareDevice hardwareDevice);

    public void removeHardwareDevice(Integer id);

    public HardwareDevice getHardwareDevice(Integer id);

    public List<HardwareDevice> listHardwareDevices();
}