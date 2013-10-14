package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LogicalCashUnitDAO {

    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit);

    public List<LogicalCashUnit> listLogicalCashUnits();

    public LogicalCashUnit getLogicalCashUnit(Integer id);
}
