.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.OperatingSystem

OperatingSystemDAOImpl
======================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class OperatingSystemDAOImpl implements OperatingSystemDAO

   The Class OperatingSystemDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addOperatingSystem(OperatingSystem operatingSystem)
   :outertype: OperatingSystemDAOImpl

getOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public OperatingSystem getOperatingSystem(Integer id)
   :outertype: OperatingSystemDAOImpl

getOperatingSystemBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public OperatingSystem getOperatingSystemBySerialNumber(String number)
   :outertype: OperatingSystemDAOImpl

listOperatingSystem
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<OperatingSystem> listOperatingSystem()
   :outertype: OperatingSystemDAOImpl

