package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface PhysicalCashUnitDAO {

    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit);

    public List<PhysicalCashUnit> listPhysicalCashUnits();

    public PhysicalCashUnit getPhysicalCashUnit(Integer id);
}
