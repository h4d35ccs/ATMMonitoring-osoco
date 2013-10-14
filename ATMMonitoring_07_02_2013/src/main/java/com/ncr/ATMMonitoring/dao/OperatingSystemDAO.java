package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface OperatingSystemDAO {

    public void addOperatingSystem(OperatingSystem operatingSystem);

    public List<OperatingSystem> listOperatingSystem();

    public OperatingSystem getOperatingSystemBySerialNumber(String number);

    public OperatingSystem getOperatingSystem(Integer id);
}
