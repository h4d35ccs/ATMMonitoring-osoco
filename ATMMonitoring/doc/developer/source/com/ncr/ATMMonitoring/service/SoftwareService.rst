.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Software

SoftwareService
===============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface SoftwareService

   The Interface SoftwareService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftware
^^^^^^^^^^^

.. java:method:: public void addSoftware(Software software)
   :outertype: SoftwareService

   Adds the software.

   :param software: the software

getSoftware
^^^^^^^^^^^

.. java:method:: public Software getSoftware(Integer id)
   :outertype: SoftwareService

   Gets the software.

   :param id: the id
   :return: the software

getSoftwareByIdentifyingNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Software getSoftwareByIdentifyingNumber(String id)
   :outertype: SoftwareService

   Gets the software by identifying number.

   :param id: the id
   :return: the software by identifying number

listSoftware
^^^^^^^^^^^^

.. java:method:: public List<Software> listSoftware()
   :outertype: SoftwareService

   List software.

   :return: the list

