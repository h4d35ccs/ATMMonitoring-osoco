.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.LogicalCashUnit

LogicalCashUnitDAOImpl
======================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class LogicalCashUnitDAOImpl implements LogicalCashUnitDAO

   The Class LogicalCashUnitDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit)
   :outertype: LogicalCashUnitDAOImpl

getLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public LogicalCashUnit getLogicalCashUnit(Integer id)
   :outertype: LogicalCashUnitDAOImpl

listLogicalCashUnits
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<LogicalCashUnit> listLogicalCashUnits()
   :outertype: LogicalCashUnitDAOImpl

