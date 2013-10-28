package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LocationDAO {

    public void addLocation(Location location);

    public Location getLocation(Integer id);

    public List<Location> listLocations();

    public void updateLocation(Location location);

    public void removeLocation(Integer id);
}
