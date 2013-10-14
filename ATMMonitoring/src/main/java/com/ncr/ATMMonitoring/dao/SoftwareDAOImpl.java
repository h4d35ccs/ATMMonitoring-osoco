package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Software;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class SoftwareDAOImpl implements SoftwareDAO {

    static private Logger logger = Logger.getLogger(SoftwareDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSoftware(Software software) {
		sessionFactory.getCurrentSession().save(software);
		logger.debug("Created new Software with id " + software.getId());
    }

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

    @Override
    public Software getSoftware(Integer id) {
		return (Software) sessionFactory.getCurrentSession().get(
			Software.class, id);
    }

    @Override
    public Software getSoftwareByIdentifyingNumber(String id) {
		return (Software) sessionFactory.getCurrentSession().createCriteria(Software.class).add(Restrictions.eq("identifyingNumber", id)).uniqueResult();
    }
}