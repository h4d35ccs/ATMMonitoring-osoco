.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util List

.. java:import:: javax.annotation PostConstruct

.. java:import:: org.apache.commons.collections CollectionUtils

.. java:import:: org.apache.commons.io.filefilter IOFileFilter

.. java:import:: org.apache.commons.lang StringUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.scheduling.annotation Scheduled

.. java:import:: org.springframework.stereotype Component

.. java:import:: com.ncr ATMMonitoring.handler.FileInDiskHandler

.. java:import:: com.ncr ATMMonitoring.handler.exception.FileHandlerException

.. java:import:: com.ncr ATMMonitoring.service.UPSService

UPSGetXMLTask
=============

.. java:package:: com.ncr.ATMMonitoring.scheduledTasks
   :noindex:

.. java:type:: @Component public class UPSGetXMLTask

   Scheduled task that reads a system directory and determine which file is going to be processed. To know which file is going to be eligible, this class<br> This class uses the following properties:

   * **config.upsfolder**: <U>Required</u>, holds the system path where the xml are
   * *config.upstask.behavior</I>
   Optional, define what to do with successfully processed files. values are: delete,copy,move. if is not present delete will be used * <i>config.upstask.copyto*
   Optional only if the config.upstask.behaviuor is null or delete, otherwise is required to determine where to put the processed files
    <br> The default behavior of this class is to delete the processed xml files<br> this class uses :java:ref:`IOFileFilter` and FileUtils

   :author: Otto Abreu

Methods
-------
checkForUPSUpdates
^^^^^^^^^^^^^^^^^^

.. java:method:: @Scheduled public void checkForUPSUpdates()
   :outertype: UPSGetXMLTask

   Scheduled task that checks the folder for xml, and call the service to begin the XML processing

initTask
^^^^^^^^

.. java:method:: @PostConstruct public void initTask()
   :outertype: UPSGetXMLTask

   Method that create the folder in the object instance

