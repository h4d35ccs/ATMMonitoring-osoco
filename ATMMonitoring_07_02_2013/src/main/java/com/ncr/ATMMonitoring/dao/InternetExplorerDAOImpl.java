package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class InternetExplorerDAOImpl implements InternetExplorerDAO {

    static private Logger logger = Logger
	    .getLogger(InternetExplorerDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addInternetExplorer(InternetExplorer internetExplorer) {
	sessionFactory.getCurrentSession().save(internetExplorer);
	logger.debug("Created new Internet Explorer with id "
		+ internetExplorer.getId());
    }

    @Override
    public List<InternetExplorer> listInternetExplorer() {
	return sessionFactory.getCurrentSession()
		.createCriteria(InternetExplorer.class)
		.addOrder(Order.desc("major_version"))
		.addOrder(Order.desc("minor_version"))
		.addOrder(Order.desc("build_version"))
		.addOrder(Order.desc("revision_version"))
		.addOrder(Order.asc("remaining_version")).list();
    }

    @Override
    public InternetExplorer getInternetExplorer(Integer id) {
	return (InternetExplorer) sessionFactory.getCurrentSession().get(
		InternetExplorer.class, id);
    }

    @Override
    public void removeInternetExplorer(Integer id) {
	InternetExplorer internetExplorer = (InternetExplorer) sessionFactory
		.getCurrentSession().load(InternetExplorer.class, id);
	if (internetExplorer != null) {
	    sessionFactory.getCurrentSession().delete(internetExplorer);
	}
    }

    @Override
    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
			InternetExplorer.class);
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
		    return (InternetExplorer) criteria.add(
			    Restrictions.isNull("remainingVersion")).uniqueResult();
		} else {
		    return (InternetExplorer) criteria.add(
			    Restrictions.eq("remainingVersion", remainingVersion))
			    .uniqueResult();
		}
    }
}