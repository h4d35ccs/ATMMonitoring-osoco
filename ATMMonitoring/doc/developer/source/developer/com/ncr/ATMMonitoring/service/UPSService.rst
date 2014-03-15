.. java:import:: java.io InputStream

.. java:import:: java.util Collection

.. java:import:: java.util List

UPSService
==========

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface UPSService

   Interface that define the operations related to the UPS

   :author: Otto Abreu

Methods
-------
deleteUPS
^^^^^^^^^

.. java:method::  void deleteUPS(int id)
   :outertype: UPSService

   Deletes the information related to an UPS

   :param id:

storeUPSinfo
^^^^^^^^^^^^

.. java:method::  List<String> storeUPSinfo(List<String> xmlFiles)
   :outertype: UPSService

   Generates the XML files, extract the information and store it in the database<br> will return the list of not processed (parsed) files, empty if all was processed

   :param xmlFiles: List<String> with valid file paths
   :return: List<String> with the not processed files

storeUPSinfo
^^^^^^^^^^^^

.. java:method::  boolean storeUPSinfo(InputStream xmlFile)
   :outertype: UPSService

   Generates the XML file, extract the information and store it in the database<br> Return true if the file was processed by the parser

   :param xmlFile: InputStream with a valid XML file
   :return: boolean true if the file was parsed, false otherwise

storeUPSinfo
^^^^^^^^^^^^

.. java:method::  List<InputStream> storeUPSinfo(Collection<InputStream> xmlFiles)
   :outertype: UPSService

   Generates the XML files, extract the information and store it in the database will return the List of not processed (parsed) files, empty if all was processed

   :param xmlFiles: Collection<InputStream> with valid inputstreams
   :return: List<InputStream> with the not processed files

storeUPSinfo
^^^^^^^^^^^^

.. java:method::  boolean storeUPSinfo(String xmlFile)
   :outertype: UPSService

   Generates the XML files, extract the information and store it in the database<br> Return true if the file was processed by the parser

   :param xmlFiles: String with a valid file path
   :return: boolean true if the file was parsed, false otherwise

