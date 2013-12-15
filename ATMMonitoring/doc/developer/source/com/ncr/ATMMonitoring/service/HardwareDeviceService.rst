.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.HardwareDevice

HardwareDeviceService
=====================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface HardwareDeviceService

   The Interface HardwareDeviceService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: public void addHardwareDevice(HardwareDevice hardwareDevice)
   :outertype: HardwareDeviceService

   Adds the hardware device.

   :param hardwareDevice: the hardware device

getHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: public HardwareDevice getHardwareDevice(Integer id)
   :outertype: HardwareDeviceService

   Gets the hardware device.

   :param id: the id
   :return: the hardware device

listHardwareDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<HardwareDevice> listHardwareDevices()
   :outertype: HardwareDeviceService

   List hardware devices.

   :return: the list

removeHardwareDevice
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeHardwareDevice(Integer id)
   :outertype: HardwareDeviceService

   Removes the hardware device.

   :param id: the id

