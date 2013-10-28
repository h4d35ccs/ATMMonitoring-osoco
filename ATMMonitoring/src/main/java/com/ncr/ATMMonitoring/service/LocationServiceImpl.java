package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.LocationDAO;
import com.ncr.ATMMonitoring.pojo.Location;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public void addLocation(Location role) {
	locationDAO.addLocation(role);
    }

    @Override
    public Location getLocation(Integer id) {
	return locationDAO.getLocation(id);
    }

    @Override
    public List<Location> listLocations() {
	return locationDAO.listLocations();
    }

    @Override
    public void updateLocation(Location location) {
	locationDAO.updateLocation(location);
    }

    @Override
    public void removeLocation(Integer id) {
	locationDAO.removeLocation(id);
    }
}