.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.scheduling.annotation Scheduled

.. java:import:: org.springframework.stereotype Component

.. java:import:: com.ncr ATMMonitoring.socket.SocketService

ProcessIpsTask
==============

.. java:package:: com.ncr.ATMMonitoring.scheduledTasks
   :noindex:

.. java:type:: @Component public class ProcessIpsTask

   Class that execute a scheduled task related to the ATM Update Process

   :author: Otto Abreu

Methods
-------
processIps
^^^^^^^^^^

.. java:method:: @Scheduled public void processIps()
   :outertype: ProcessIpsTask

   Method that calls the service in order to start the ATM update process

