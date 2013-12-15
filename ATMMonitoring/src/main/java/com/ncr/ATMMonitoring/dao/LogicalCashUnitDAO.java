package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

// TODO: Auto-generated Javadoc
/**
 * The Interface LogicalCashUnitDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LogicalCashUnitDAO {

    /**
     * Adds the logical cash unit.
     *
     * @param logicalCashUnit the logical cash unit
     */
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit);

    /**
     * List logical cash units.
     *
     * @return the list
     */
    public List<LogicalCashUnit> listLogicalCashUnits();

    /**
     * Gets the logical cash unit.
     *
     * @param id the id
     * @return the logical cash unit
     */
    public LogicalCashUnit getLogicalCashUnit(Integer id);
}
