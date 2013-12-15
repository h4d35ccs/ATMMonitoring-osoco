.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.PhysicalCashUnit

PhysicalCashUnitDAOImpl
=======================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class PhysicalCashUnitDAOImpl implements PhysicalCashUnitDAO

   The Class PhysicalCashUnitDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit)
   :outertype: PhysicalCashUnitDAOImpl

getPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public PhysicalCashUnit getPhysicalCashUnit(Integer id)
   :outertype: PhysicalCashUnitDAOImpl

listPhysicalCashUnits
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<PhysicalCashUnit> listPhysicalCashUnits()
   :outertype: PhysicalCashUnitDAOImpl

