package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class SoftwareAggregateDAOImpl implements SoftwareAggregateDAO {

    static private Logger logger = Logger
	    .getLogger(SoftwareAggregateDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate) {
    	sessionFactory.getCurrentSession().save(softwareAggregate);
    	logger.debug("Created new Software Aggregate with id " + softwareAggregate.getId());
    }

    @Override
    public List<SoftwareAggregate> listSoftwareAggregate() {
	return sessionFactory.getCurrentSession()
		.createCriteria(SoftwareAggregate.class)
		.addOrder(Order.asc("name"))
		.addOrder(Order.desc("major_version"))
		.addOrder(Order.desc("minor_version"))
		.addOrder(Order.desc("build_version"))
		.addOrder(Order.desc("revision_version"))
		.addOrder(Order.asc("remaining_version")).list();
    }

    @Override
    public SoftwareAggregate getSoftwareAggregate(Integer id) {
    	return (SoftwareAggregate) sessionFactory.getCurrentSession().get(SoftwareAggregate.class, id);
    }

    @Override
    public SoftwareAggregate getSoftwareAggregateByVersionName(
	    Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name) {
	
    	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SoftwareAggregate.class);
		if (majorVersion == null) {
		    criteria.add(Restrictions.isNull("majorVersion"));
		} else {
		    criteria.add(Restrictions.eq("majorVersion", majorVersion));
		}
		if (minorVersion == null) {
		    criteria.add(Restrictions.isNull("minorVersion"));
		} else {
		    criteria.add(Restrictions.eq("minorVersion", minorVersion));
		}
		if (buildVersion == null) {
		    criteria.add(Restrictions.isNull("buildVersion"));
		} else {
		    criteria.add(Restrictions.eq("buildVersion", buildVersion));
		}
		if (revisionVersion == null) {
		    criteria.add(Restrictions.isNull("revisionVersion"));
		} else {
		    criteria.add(Restrictions.eq("revisionVersion", revisionVersion));
		}
		if (remainingVersion == null) {
		    criteria.add(Restrictions.isNull("remainingVersion"));
		} else {
		    criteria.add(Restrictions.eq("remainingVersion", remainingVersion));
		}
		if (name == null) {
		    return (SoftwareAggregate) criteria.add(Restrictions.isNull("name")).uniqueResult();
		} else {
		    return (SoftwareAggregate) criteria.add(Restrictions.eq("name", name)).uniqueResult();
		}
    }

    @Override
    public void removeSoftwareAggregate(Integer id) {
    	SoftwareAggregate softwareAggregate = (SoftwareAggregate) sessionFactory.getCurrentSession().load(SoftwareAggregate.class, id);
		if (softwareAggregate != null) {
		    sessionFactory.getCurrentSession().delete(softwareAggregate);
		}
    }
}