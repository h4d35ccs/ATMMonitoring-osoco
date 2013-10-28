package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class LocationDAOImpl implements LocationDAO {

    static private Logger logger = Logger.getLogger(LocationDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addLocation(Location location) {
	sessionFactory.getCurrentSession().save(location);
	logger.debug("Created new Location with id " + location.getId());
    }

    @Override
    public Location getLocation(Integer id) {
	return (Location) sessionFactory.getCurrentSession().get(
		Location.class, id);
    }

    @Override
    public List<Location> listLocations() {
	return sessionFactory.getCurrentSession()
		.createCriteria(Location.class).list();
    }

    @Override
    public void updateLocation(Location location) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(location));
	logger.info("Updated Location with id " + location.getId());
    }

    @Override
    public void removeLocation(Integer id) {
	Location location = (Location) sessionFactory.getCurrentSession().load(
		Location.class, id);
	if (null != location) {
	    sessionFactory.getCurrentSession().delete(location);
	}

    }
}