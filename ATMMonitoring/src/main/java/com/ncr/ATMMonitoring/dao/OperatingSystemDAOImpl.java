package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;

// TODO: Auto-generated Javadoc
/**
 * The Class OperatingSystemDAOImpl.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class OperatingSystemDAOImpl extends AbstractGenericDAO<OperatingSystem>
	implements OperatingSystemDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(OperatingSystemDAOImpl.class.getName());

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.OperatingSystemDAO#addOperatingSystem(com.ncr.ATMMonitoring.pojo.OperatingSystem)
     */
    @Override
    public void addOperatingSystem(OperatingSystem operatingSystem) {
	add(operatingSystem);
	logger.debug("Created new Operating System with id "
		+ operatingSystem.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.OperatingSystemDAO#listOperatingSystem()
     */
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

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.OperatingSystemDAO#getOperatingSystem(java.lang.Integer)
     */
    @Override
    public OperatingSystem getOperatingSystem(Integer id) {
	return get(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.OperatingSystemDAO#getOperatingSystemBySerialNumber(java.lang.String)
     */
    @Override
    public OperatingSystem getOperatingSystemBySerialNumber(String number) {
	return (OperatingSystem) sessionFactory.getCurrentSession()
		.createCriteria(OperatingSystem.class)
		.add(Restrictions.eq("serialNumber", number)).uniqueResult();
    }
}