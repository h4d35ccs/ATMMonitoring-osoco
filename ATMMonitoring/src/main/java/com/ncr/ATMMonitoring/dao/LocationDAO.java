package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Interface LocationDAO.
 * 
 * Dao with the operations for managing Location Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LocationDAO {

    /**
     * Adds the location.
     *
     * @param location the location
     */
    public void addLocation(Location location);

    /**
     * Gets the location with the given id.
     * 
     * @param id
     *            the id
     * @return the location, or null if it doesn't exist
     */
    public Location getLocation(Integer id);

    /**
     * Lists all locations.
     * 
     * @return the list
     */
    public List<Location> listLocations();

    /**
     * Updates location.
     * 
     * @param location
     *            the location
     */
    public void updateLocation(Location location);

    /**
     * Removes the location with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeLocation(Integer id);
}
