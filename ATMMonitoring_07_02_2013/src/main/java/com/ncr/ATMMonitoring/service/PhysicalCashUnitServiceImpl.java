package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.PhysicalCashUnitDAO;
import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("physicalCashUnitService")
@Transactional
public class PhysicalCashUnitServiceImpl implements PhysicalCashUnitService {

    @Autowired
    private PhysicalCashUnitDAO physicalCashUnitDAO;

    @Override
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit) {
	physicalCashUnitDAO.addPhysicalCashUnit(physicalCashUnit);
    }

    @Override
    public List<PhysicalCashUnit> listPhysicalCashUnits() {
	return physicalCashUnitDAO.listPhysicalCashUnits();
    }

    @Override
    public PhysicalCashUnit getPhysicalCashUnit(Integer id) {
	return physicalCashUnitDAO.getPhysicalCashUnit(id);
    }
}