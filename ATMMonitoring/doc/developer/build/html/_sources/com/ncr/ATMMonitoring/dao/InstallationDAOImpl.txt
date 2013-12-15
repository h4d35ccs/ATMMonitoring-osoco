.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

InstallationDAOImpl
===================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class InstallationDAOImpl implements InstallationDAO

   The Class InstallationDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallation
^^^^^^^^^^^^^^^

.. java:method:: @Override public void addInstallation(Installation installation)
   :outertype: InstallationDAOImpl

getInstallation
^^^^^^^^^^^^^^^

.. java:method:: @Override public Installation getInstallation(Integer id)
   :outertype: InstallationDAOImpl

listInstallations
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Installation> listInstallations()
   :outertype: InstallationDAOImpl

removeInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeInstallation(Integer id)
   :outertype: InstallationDAOImpl

updateInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateInstallation(Installation installation)
   :outertype: InstallationDAOImpl

