.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.OperatingSystem

OperatingSystemService
======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface OperatingSystemService

   The Interface OperatingSystemService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addOperatingSystem(OperatingSystem operatingSystem)
   :outertype: OperatingSystemService

   Adds the operating system.

   :param operatingSystem: the operating system

getOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: public OperatingSystem getOperatingSystem(Integer id)
   :outertype: OperatingSystemService

   Gets the operating system.

   :param id: the id
   :return: the operating system

getOperatingSystemBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public OperatingSystem getOperatingSystemBySerialNumber(String number)
   :outertype: OperatingSystemService

   Gets the operating system by serial number.

   :param number: the number
   :return: the operating system by serial number

listOperatingSystem
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<OperatingSystem> listOperatingSystem()
   :outertype: OperatingSystemService

   List operating system.

   :return: the list

