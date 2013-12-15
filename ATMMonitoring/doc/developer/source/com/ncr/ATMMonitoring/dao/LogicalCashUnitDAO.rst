.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.LogicalCashUnit

LogicalCashUnitDAO
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface LogicalCashUnitDAO

   The Interface LogicalCashUnitDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit)
   :outertype: LogicalCashUnitDAO

   Adds the logical cash unit.

   :param logicalCashUnit: the logical cash unit

getLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public LogicalCashUnit getLogicalCashUnit(Integer id)
   :outertype: LogicalCashUnitDAO

   Gets the logical cash unit.

   :param id: the id
   :return: the logical cash unit

listLogicalCashUnits
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<LogicalCashUnit> listLogicalCashUnits()
   :outertype: LogicalCashUnitDAO

   List logical cash units.

   :return: the list

