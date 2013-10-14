package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.FinancialDeviceDAO;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("financialDeviceService")
@Transactional
public class FinancialDeviceServiceImpl implements FinancialDeviceService {

    @Autowired
    private FinancialDeviceDAO financialDeviceDAO;

    @Override
    public void addFinancialDevice(FinancialDevice financialDevice) {
    	financialDeviceDAO.addFinancialDevice(financialDevice);
    }

    @Override
    public List<FinancialDevice> listFinancialDevices() {
    	return financialDeviceDAO.listFinancialDevices();
    }

    @Override
    public FinancialDevice getFinancialDevice(Integer id) {
    	return financialDeviceDAO.getFinancialDevice(id);
    }

    @Override
    public void removeFinancialDevice(Integer id) {
    	financialDeviceDAO.removeFinancialDevice(id);
    }
}