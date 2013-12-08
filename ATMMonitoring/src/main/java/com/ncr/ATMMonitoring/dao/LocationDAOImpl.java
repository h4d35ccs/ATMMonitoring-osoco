package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Location;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class LocationDAOImpl implements LocationDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(LocationDAOImpl.class
	    .getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#addLocation(com.ncr.ATMMonitoring.pojo.Location)
     */
    @Override
    public void addLocation(Location location) {
	sessionFactory.getCurrentSession().save(location);
	logger.debug("Created new Location with id " + location.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#getLocation(java.lang.Integer)
     */
    @Override
    public Location getLocation(Integer id) {
	return (Location) sessionFactory.getCurrentSession().get(
		Location.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#listLocations()
     */
    @Override
    public List<Location> listLocations() {
	return sessionFactory.getCurrentSession()
		.createCriteria(Location.class).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#updateLocation(com.ncr.ATMMonitoring.pojo.Location)
     */
    @Override
    public void updateLocation(Location location) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(location));
	logger.info("Updated Location with id " + location.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#removeLocation(java.lang.Integer)
     */
    @Override
    public void removeLocation(Integer id) {
	Location location = (Location) sessionFactory.getCurrentSession().load(
		Location.class, id);
	if (null != location) {
	    sessionFactory.getCurrentSession().delete(location);
	}

    }
}