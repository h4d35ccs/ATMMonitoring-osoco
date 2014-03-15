.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Criterion

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Ups

UpsDAOImp
=========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class UpsDAOImp extends AbstractGenericDAO<Ups> implements UpsDAO

   Dao concrete class that interact with the UPS table

   :author: Otto Abreu

Methods
-------
addUps
^^^^^^

.. java:method:: @Override public void addUps(Ups ups)
   :outertype: UpsDAOImp

getUps
^^^^^^

.. java:method:: @Override public Ups getUps(int id)
   :outertype: UpsDAOImp

getUpsBySerialNumber
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Ups getUpsBySerialNumber(String seriesNumber)
   :outertype: UpsDAOImp

getUpsBySerialNumberAndModel
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model)
   :outertype: UpsDAOImp

listAllUps
^^^^^^^^^^

.. java:method:: @Override public List<Ups> listAllUps()
   :outertype: UpsDAOImp

listUps
^^^^^^^

.. java:method:: @Override @SuppressWarnings public List<Ups> listUps(Criterion... criterions)
   :outertype: UpsDAOImp

removeUps
^^^^^^^^^

.. java:method:: @Override public void removeUps(int id)
   :outertype: UpsDAOImp

updateUps
^^^^^^^^^

.. java:method:: @Override public void updateUps(Ups ups)
   :outertype: UpsDAOImp

