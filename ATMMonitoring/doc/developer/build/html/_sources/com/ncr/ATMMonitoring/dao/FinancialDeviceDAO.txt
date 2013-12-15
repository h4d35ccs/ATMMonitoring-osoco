.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.FinancialDevice

FinancialDeviceDAO
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface FinancialDeviceDAO

   The Interface FinancialDeviceDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addFinancialDevice(FinancialDevice financialDevice)
   :outertype: FinancialDeviceDAO

   Adds the financial device.

   :param financialDevice: the financial device

getFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: public FinancialDevice getFinancialDevice(Integer id)
   :outertype: FinancialDeviceDAO

   Gets the financial device.

   :param id: the id
   :return: the financial device

listFinancialDevices
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<FinancialDevice> listFinancialDevices()
   :outertype: FinancialDeviceDAO

   List financial devices.

   :return: the list

removeFinancialDevice
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeFinancialDevice(Integer id)
   :outertype: FinancialDeviceDAO

   Removes the financial device.

   :param id: the id

