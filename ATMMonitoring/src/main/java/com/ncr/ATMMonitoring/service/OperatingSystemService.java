package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface OperatingSystemService {

    public void addOperatingSystem(OperatingSystem operatingSystem);

    public OperatingSystem getOperatingSystem(Integer id);

    public OperatingSystem getOperatingSystemBySerialNumber(String number);

    public List<OperatingSystem> listOperatingSystem();
}