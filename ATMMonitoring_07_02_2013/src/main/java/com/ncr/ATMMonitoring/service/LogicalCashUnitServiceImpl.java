package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO;
import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("logicalCashUnitService")
@Transactional
public class LogicalCashUnitServiceImpl implements LogicalCashUnitService {

    @Autowired
    private LogicalCashUnitDAO logicalCashUnitDAO;

    @Override
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit) {
	logicalCashUnitDAO.addLogicalCashUnit(logicalCashUnit);
    }

    @Override
    public List<LogicalCashUnit> listLogicalCashUnits() {
	return logicalCashUnitDAO.listLogicalCashUnits();
    }

    @Override
    public LogicalCashUnit getLogicalCashUnit(Integer id) {
	return logicalCashUnitDAO.getLogicalCashUnit(id);
    }
}