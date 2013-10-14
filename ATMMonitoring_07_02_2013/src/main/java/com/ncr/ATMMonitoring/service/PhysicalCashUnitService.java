package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface PhysicalCashUnitService {

    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit);

    public PhysicalCashUnit getPhysicalCashUnit(Integer id);

    public List<PhysicalCashUnit> listPhysicalCashUnits();
}