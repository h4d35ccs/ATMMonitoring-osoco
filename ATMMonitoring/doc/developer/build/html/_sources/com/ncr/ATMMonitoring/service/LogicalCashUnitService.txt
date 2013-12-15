.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.LogicalCashUnit

LogicalCashUnitService
======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface LogicalCashUnitService

   The Interface LogicalCashUnitService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit)
   :outertype: LogicalCashUnitService

   Adds the logical cash unit.

   :param logicalCashUnit: the logical cash unit

getLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public LogicalCashUnit getLogicalCashUnit(Integer id)
   :outertype: LogicalCashUnitService

   Gets the logical cash unit.

   :param id: the id
   :return: the logical cash unit

listLogicalCashUnits
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<LogicalCashUnit> listLogicalCashUnits()
   :outertype: LogicalCashUnitService

   List logical cash units.

   :return: the list

