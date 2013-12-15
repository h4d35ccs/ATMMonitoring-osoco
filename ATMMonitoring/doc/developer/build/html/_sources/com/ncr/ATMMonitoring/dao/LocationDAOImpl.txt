.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Location

LocationDAOImpl
===============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class LocationDAOImpl implements LocationDAO

   The Class LocationDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLocation
^^^^^^^^^^^

.. java:method:: @Override public void addLocation(Location location)
   :outertype: LocationDAOImpl

getLocation
^^^^^^^^^^^

.. java:method:: @Override public Location getLocation(Integer id)
   :outertype: LocationDAOImpl

listLocations
^^^^^^^^^^^^^

.. java:method:: @Override public List<Location> listLocations()
   :outertype: LocationDAOImpl

removeLocation
^^^^^^^^^^^^^^

.. java:method:: @Override public void removeLocation(Integer id)
   :outertype: LocationDAOImpl

updateLocation
^^^^^^^^^^^^^^

.. java:method:: @Override public void updateLocation(Location location)
   :outertype: LocationDAOImpl

