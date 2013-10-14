package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface FinancialDeviceService {

    public void addFinancialDevice(FinancialDevice financialDevice);

    public void removeFinancialDevice(Integer id);

    public FinancialDevice getFinancialDevice(Integer id);

    public List<FinancialDevice> listFinancialDevices();
}