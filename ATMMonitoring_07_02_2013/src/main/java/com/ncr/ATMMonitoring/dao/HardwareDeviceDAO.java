package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HardwareDeviceDAO {

    public void addHardwareDevice(HardwareDevice hardwareDevice);

    public List<HardwareDevice> listHardwareDevices();

    public HardwareDevice getHardwareDevice(Integer id);

    public void removeHardwareDevice(Integer id);
}
