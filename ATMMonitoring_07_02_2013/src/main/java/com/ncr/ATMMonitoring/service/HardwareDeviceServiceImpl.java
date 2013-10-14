package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.HardwareDeviceDAO;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("hardwareDeviceService")
@Transactional
public class HardwareDeviceServiceImpl implements HardwareDeviceService {

    @Autowired
    private HardwareDeviceDAO hardwareDeviceDAO;

    @Override
    public void addHardwareDevice(HardwareDevice hardwareDevice) {
    	hardwareDeviceDAO.addHardwareDevice(hardwareDevice);
    }

    @Override
    public List<HardwareDevice> listHardwareDevices() {
    	return hardwareDeviceDAO.listHardwareDevices();
    }

    @Override
    public HardwareDevice getHardwareDevice(Integer id) {
    	return hardwareDeviceDAO.getHardwareDevice(id);
    }

    @Override
    public void removeHardwareDevice(Integer id) {
    	hardwareDeviceDAO.removeHardwareDevice(id);
    }
}