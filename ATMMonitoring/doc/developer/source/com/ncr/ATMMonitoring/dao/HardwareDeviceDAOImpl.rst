.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.HardwareDevice

HardwareDeviceDAOImpl
=====================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class HardwareDeviceDAOImpl implements HardwareDeviceDAO

   The Class HardwareDeviceDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addHardwareDevice(HardwareDevice hardwareDevice)
   :outertype: HardwareDeviceDAOImpl

getHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public HardwareDevice getHardwareDevice(Integer id)
   :outertype: HardwareDeviceDAOImpl

listHardwareDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<HardwareDevice> listHardwareDevices()
   :outertype: HardwareDeviceDAOImpl

removeHardwareDevice
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeHardwareDevice(Integer id)
   :outertype: HardwareDeviceDAOImpl

