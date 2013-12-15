.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

InstallationService
===================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface InstallationService

   The Interface InstallationService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallation
^^^^^^^^^^^^^^^

.. java:method:: public void addInstallation(Installation installation)
   :outertype: InstallationService

   Adds the installation.

   :param installation: the installation

getInstallation
^^^^^^^^^^^^^^^

.. java:method:: public Installation getInstallation(Integer id)
   :outertype: InstallationService

   Gets the installation.

   :param id: the id
   :return: the installation

listInstallations
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Installation> listInstallations()
   :outertype: InstallationService

   List installations.

   :return: the list

removeInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeInstallation(Integer id)
   :outertype: InstallationService

   Removes the installation.

   :param id: the id

updateInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateInstallation(Installation installation)
   :outertype: InstallationService

   Update installation.

   :param installation: the installation

