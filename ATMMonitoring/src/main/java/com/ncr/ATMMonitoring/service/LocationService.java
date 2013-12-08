package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Location;

// TODO: Auto-generated Javadoc
/**
 * The Interface LocationService.
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
     * Gets the location.
     *
     * @param id the id
     * @return the location
     */
    public Location getLocation(Integer id);

    /**
     * List locations.
     *
     * @return the list
     */
    public List<Location> listLocations();

    /**
     * Update location.
     *
     * @param location the location
     */
    public void updateLocation(Location location);

    /**
     * Removes the location.
     *
     * @param id the id
     */
    public void removeLocation(Integer id);
}