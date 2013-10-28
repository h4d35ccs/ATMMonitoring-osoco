package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Installation;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class InstallationDAOImpl implements InstallationDAO {

    static private Logger logger = Logger.getLogger(InstallationDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addInstallation(Installation installation) {
	sessionFactory.getCurrentSession().save(installation);
	logger.debug("Created new Installation with id " + installation.getId());
    }

    @Override
    public Installation getInstallation(Integer id) {
	return (Installation) sessionFactory.getCurrentSession().get(
		Installation.class, id);
    }

    @Override
    public List<Installation> listInstallations() {
	return sessionFactory.getCurrentSession()
		.createCriteria(Installation.class).list();
    }

    @Override
    public void updateInstallation(Installation installation) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(installation));
	logger.info("Updated Installation with id " + installation.getId());
    }

    @Override
    public void removeInstallation(Integer id) {
	Installation installation = (Installation) sessionFactory
		.getCurrentSession().load(Installation.class, id);
	if (null != installation) {
	    sessionFactory.getCurrentSession().delete(installation);
	}

    }
}