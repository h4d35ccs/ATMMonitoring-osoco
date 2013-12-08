package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

// TODO: Auto-generated Javadoc
/**
 * The Interface LogicalCashUnitService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LogicalCashUnitService {

    /**
     * Adds the logical cash unit.
     *
     * @param logicalCashUnit the logical cash unit
     */
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit);

    /**
     * Gets the logical cash unit.
     *
     * @param id the id
     * @return the logical cash unit
     */
    public LogicalCashUnit getLogicalCashUnit(Integer id);

    /**
     * List logical cash units.
     *
     * @return the list
     */
    public List<LogicalCashUnit> listLogicalCashUnits();
}