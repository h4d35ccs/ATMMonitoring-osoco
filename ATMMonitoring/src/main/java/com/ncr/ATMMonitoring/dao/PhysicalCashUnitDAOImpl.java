package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class PhysicalCashUnitDAOImpl.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class PhysicalCashUnitDAOImpl extends
	AbstractGenericDAO<PhysicalCashUnit> implements PhysicalCashUnitDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(PhysicalCashUnitDAOImpl.class.getName());

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.PhysicalCashUnitDAO#addPhysicalCashUnit(com.ncr.ATMMonitoring.pojo.PhysicalCashUnit)
     */
    @Override
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit) {
	add(physicalCashUnit);
	logger.debug("Created new Physical Cash Unit with id "
		+ physicalCashUnit.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.PhysicalCashUnitDAO#listPhysicalCashUnits()
     */
    @Override
    public List<PhysicalCashUnit> listPhysicalCashUnits() {
	return list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.PhysicalCashUnitDAO#getPhysicalCashUnit(java.lang.Integer)
     */
    @Override
    public PhysicalCashUnit getPhysicalCashUnit(Integer id) {
	return get(id);
    }
}