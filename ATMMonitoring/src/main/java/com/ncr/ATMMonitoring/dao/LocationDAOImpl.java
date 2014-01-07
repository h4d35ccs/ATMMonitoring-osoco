package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Class LocationDAOImpl.
 * 
 * Default implementation of LocationDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class LocationDAOImpl extends AbstractGenericDAO<Location> implements
	LocationDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(LocationDAOImpl.class
	    .getName());

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
	return get(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#listLocations()
     */
    @Override
    public List<Location> listLocations() {
	return list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#updateLocation(com.ncr.ATMMonitoring.pojo.Location)
     */
    @Override
    public void updateLocation(Location location) {
	update(location);
	logger.info("Updated Location with id " + location.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#removeLocation(java.lang.Integer)
     */
    @Override
    public void removeLocation(Integer id) {
	delete(id);
    }
}