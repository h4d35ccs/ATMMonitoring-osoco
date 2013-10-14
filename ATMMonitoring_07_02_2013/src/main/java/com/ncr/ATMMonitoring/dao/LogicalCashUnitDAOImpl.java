package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class LogicalCashUnitDAOImpl implements LogicalCashUnitDAO {

    static private Logger logger = Logger
	    .getLogger(LogicalCashUnitDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit) {
	sessionFactory.getCurrentSession().save(logicalCashUnit);
	logger.debug("Created new Logical Cash Unit with id "
		+ logicalCashUnit.getId());
    }

    @Override
    public List<LogicalCashUnit> listLogicalCashUnits() {
	return sessionFactory.getCurrentSession()
		.createCriteria(LogicalCashUnit.class).list();
    }

    @Override
    public LogicalCashUnit getLogicalCashUnit(Integer id) {
	return (LogicalCashUnit) sessionFactory.getCurrentSession().get(
		LogicalCashUnit.class, id);
    }
}