package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

// TODO: Auto-generated Javadoc
/**
 * The Interface PhysicalCashUnitDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface PhysicalCashUnitDAO {

    /**
     * Adds the physical cash unit.
     *
     * @param physicalCashUnit the physical cash unit
     */
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit);

    /**
     * List physical cash units.
     *
     * @return the list
     */
    public List<PhysicalCashUnit> listPhysicalCashUnits();

    /**
     * Gets the physical cash unit.
     *
     * @param id the id
     * @return the physical cash unit
     */
    public PhysicalCashUnit getPhysicalCashUnit(Integer id);
}
