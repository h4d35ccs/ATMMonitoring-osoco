package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class OperatingSystemDAOImpl implements OperatingSystemDAO {

    static private Logger logger = Logger
	    .getLogger(OperatingSystemDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOperatingSystem(OperatingSystem operatingSystem) {
	sessionFactory.getCurrentSession().save(operatingSystem);
	logger.debug("Created new Operating System with id "
		+ operatingSystem.getId());
    }

    @Override
    public List<OperatingSystem> listOperatingSystem() {
	return sessionFactory.getCurrentSession()
		.createCriteria(OperatingSystem.class)
		.addOrder(Order.asc("name"))
		.addOrder(Order.desc("major_version"))
		.addOrder(Order.desc("minor_version"))
		.addOrder(Order.desc("build_version"))
		.addOrder(Order.desc("revision_version"))
		.addOrder(Order.desc("remaining_version")).list();
    }

    @Override
    public OperatingSystem getOperatingSystem(Integer id) {
	return (OperatingSystem) sessionFactory.getCurrentSession().get(
		OperatingSystem.class, id);
    }

    @Override
    public OperatingSystem getOperatingSystemBySerialNumber(String number) {
	return (OperatingSystem) sessionFactory.getCurrentSession()
		.createCriteria(OperatingSystem.class)
		.add(Restrictions.eq("serialNumber", number)).uniqueResult();
    }
}