package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

// TODO: Auto-generated Javadoc
/**
 * The Interface PhysicalCashUnitService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface PhysicalCashUnitService {

    /**
     * Adds the physical cash unit.
     *
     * @param physicalCashUnit the physical cash unit
     */
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit);

    /**
     * Gets the physical cash unit.
     *
     * @param id the id
     * @return the physical cash unit
     */
    public PhysicalCashUnit getPhysicalCashUnit(Integer id);

    /**
     * List physical cash units.
     *
     * @return the list
     */
    public List<PhysicalCashUnit> listPhysicalCashUnits();
}