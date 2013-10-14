package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LogicalCashUnitService {

    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit);

    public LogicalCashUnit getLogicalCashUnit(Integer id);

    public List<LogicalCashUnit> listLogicalCashUnits();
}