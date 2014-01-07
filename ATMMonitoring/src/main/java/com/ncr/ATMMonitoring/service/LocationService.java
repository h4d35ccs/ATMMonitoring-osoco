package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Interface LocationService.
 * 
 * It contains the location related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LocationService {

    /**
     * Adds the location.
     *
     * @param location the location
     */
    public void addLocation(Location location);

    /**
     * Gets the location by its id.
     * 
     * @param id
     *            the location id
     * @return the location
     */
    public Location getLocation(Integer id);

    /**
     * List locations.
     * 
     * @return the location list
     */
    public List<Location> listLocations();

    /**
     * Update location.
     *
     * @param location the location
     */
    public void updateLocation(Location location);

    /**
     * Removes the location by its id.
     * 
     * @param id
     *            the location id
     */
    public void removeLocation(Integer id);
}