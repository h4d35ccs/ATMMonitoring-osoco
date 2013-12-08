package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class LogicalCashUnitDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class LogicalCashUnitDAOImpl implements LogicalCashUnitDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(LogicalCashUnitDAOImpl.class.getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO#addLogicalCashUnit(com.ncr.ATMMonitoring.pojo.LogicalCashUnit)
     */
    @Override
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit) {
	sessionFactory.getCurrentSession().save(logicalCashUnit);
	logger.debug("Created new Logical Cash Unit with id "
		+ logicalCashUnit.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO#listLogicalCashUnits()
     */
    @Override
    public List<LogicalCashUnit> listLogicalCashUnits() {
	return sessionFactory.getCurrentSession()
		.createCriteria(LogicalCashUnit.class).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO#getLogicalCashUnit(java.lang.Integer)
     */
    @Override
    public LogicalCashUnit getLogicalCashUnit(Integer id) {
	return (LogicalCashUnit) sessionFactory.getCurrentSession().get(
		LogicalCashUnit.class, id);
    }
}