package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.LocationDAO;
import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Class LocationServiceImpl.
 * 
 * Default implementation of the LocationService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    /** The location dao. */
    @Autowired
    private LocationDAO locationDAO;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.LocationService#addLocation(com.ncr.ATMMonitoring.pojo.Location)
     */
    @Override
    public void addLocation(Location role) {
	locationDAO.addLocation(role);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.LocationService#getLocation(java.lang.Integer)
     */
    @Override
    public Location getLocation(Integer id) {
	return locationDAO.getLocation(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.LocationService#listLocations()
     */
    @Override
    public List<Location> listLocations() {
	return locationDAO.listLocations();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.LocationService#updateLocation(com.ncr.ATMMonitoring.pojo.Location)
     */
    @Override
    public void updateLocation(Location location) {
	locationDAO.updateLocation(location);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.LocationService#removeLocation(java.lang.Integer)
     */
    @Override
    public void removeLocation(Integer id) {
	locationDAO.removeLocation(id);
    }
}