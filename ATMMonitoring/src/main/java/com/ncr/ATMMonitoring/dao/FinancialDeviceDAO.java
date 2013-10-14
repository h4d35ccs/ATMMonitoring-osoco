package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface FinancialDeviceDAO {

    public void addFinancialDevice(FinancialDevice financialDevice);

    public List<FinancialDevice> listFinancialDevices();

    public FinancialDevice getFinancialDevice(Integer id);

    public void removeFinancialDevice(Integer id);
}
