.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.SoftwareAggregate

SoftwareAggregateDAO
====================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface SoftwareAggregateDAO

   The Interface SoftwareAggregateDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addSoftwareAggregate(SoftwareAggregate softwareAggregate)
   :outertype: SoftwareAggregateDAO

   Adds the software aggregate.

   :param softwareAggregate: the software aggregate

getSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public SoftwareAggregate getSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateDAO

   Gets the software aggregate.

   :param id: the id
   :return: the software aggregate

getSoftwareAggregateByVersionName
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public SoftwareAggregate getSoftwareAggregateByVersionName(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion, String name)
   :outertype: SoftwareAggregateDAO

   Gets the software aggregate by version name.

   :param majorVersion: the major version
   :param minorVersion: the minor version
   :param buildVersion: the build version
   :param revisionVersion: the revision version
   :param remainingVersion: the remaining version
   :param name: the name
   :return: the software aggregate by version name

listSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<SoftwareAggregate> listSoftwareAggregate()
   :outertype: SoftwareAggregateDAO

   List software aggregate.

   :return: the list

removeSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateDAO

   Removes the software aggregate.

   :param id: the id

