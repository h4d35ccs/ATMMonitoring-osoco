package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Software;

// TODO: Auto-generated Javadoc
/**
 * The Class SoftwareDAOImpl.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class SoftwareDAOImpl extends AbstractGenericDAO<Software> implements
	SoftwareDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(SoftwareDAOImpl.class.getName());

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.SoftwareDAO#addSoftware(com.ncr.ATMMonitoring.pojo.Software)
     */
    @Override
    public void addSoftware(Software software) {
	add(software);
		logger.debug("Created new Software with id " + software.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.SoftwareDAO#listSoftware()
     */
    @Override
    public List<Software> listSoftware() {
		return sessionFactory.getCurrentSession()
			.createCriteria(Software.class).addOrder(Order.asc("name"))
			.addOrder(Order.desc("major_version"))
			.addOrder(Order.desc("minor_version"))
			.addOrder(Order.desc("build_version"))
			.addOrder(Order.desc("revision_version"))
			.addOrder(Order.desc("remaining_version")).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.SoftwareDAO#getSoftware(java.lang.Integer)
     */
    @Override
    public Software getSoftware(Integer id) {
	return get(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.SoftwareDAO#getSoftwareByIdentifyingNumber(java.lang.String)
     */
    @Override
    public Software getSoftwareByIdentifyingNumber(String id) {
		return (Software) sessionFactory.getCurrentSession().createCriteria(Software.class).add(Restrictions.eq("identifyingNumber", id)).uniqueResult();
    }
}