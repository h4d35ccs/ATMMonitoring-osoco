package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class PhysicalCashUnitDAOImpl implements PhysicalCashUnitDAO {

    static private Logger logger = Logger
	    .getLogger(PhysicalCashUnitDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit) {
	sessionFactory.getCurrentSession().save(physicalCashUnit);
	logger.debug("Created new Physical Cash Unit with id "
		+ physicalCashUnit.getId());
    }

    @Override
    public List<PhysicalCashUnit> listPhysicalCashUnits() {
	return sessionFactory.getCurrentSession()
		.createCriteria(PhysicalCashUnit.class).list();
    }

    @Override
    public PhysicalCashUnit getPhysicalCashUnit(Integer id) {
	return (PhysicalCashUnit) sessionFactory.getCurrentSession().get(
		PhysicalCashUnit.class, id);
    }
}