.. java:import:: java.io InputStream

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate HibernateException

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.UpsDAO

.. java:import:: com.ncr ATMMonitoring.handler.FileInDiskHandler

.. java:import:: com.ncr ATMMonitoring.parser.ParseUPSChainBuilder

.. java:import:: com.ncr ATMMonitoring.parser.dto.UPSInfo

.. java:import:: com.ncr ATMMonitoring.parser.exception.NoParserFoundException

.. java:import:: com.ncr ATMMonitoring.parser.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.exception.XMLNotReadableException

.. java:import:: com.ncr ATMMonitoring.pojo.Ups

UPSServiceImp
=============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class UPSServiceImp implements UPSService

   Concrete class that implements :java:ref:`UPSService`

   :author: Otto Abreu

Methods
-------
deleteUPS
^^^^^^^^^

.. java:method:: @Override public void deleteUPS(int id)
   :outertype: UPSServiceImp

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public List<String> storeUPSinfo(List<String> xmlFiles)
   :outertype: UPSServiceImp

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public List<InputStream> storeUPSinfo(Collection<InputStream> xmlFiles)
   :outertype: UPSServiceImp

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public boolean storeUPSinfo(InputStream xmlFile)
   :outertype: UPSServiceImp

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public boolean storeUPSinfo(String xmlFile)
   :outertype: UPSServiceImp

