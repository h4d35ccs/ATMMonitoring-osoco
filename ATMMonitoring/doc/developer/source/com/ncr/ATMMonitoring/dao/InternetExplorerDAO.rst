.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.InternetExplorer

InternetExplorerDAO
===================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface InternetExplorerDAO

   The Interface InternetExplorerDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addInternetExplorer(InternetExplorer internetExplorer)
   :outertype: InternetExplorerDAO

   Adds the internet explorer.

   :param internetExplorer: the internet explorer

getInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: public InternetExplorer getInternetExplorer(Integer id)
   :outertype: InternetExplorerDAO

   Gets the internet explorer.

   :param id: the id
   :return: the internet explorer

getInternetExplorerByVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public InternetExplorer getInternetExplorerByVersion(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion)
   :outertype: InternetExplorerDAO

   Gets the internet explorer by version.

   :param majorVersion: the major version
   :param minorVersion: the minor version
   :param buildVersion: the build version
   :param revisionVersion: the revision version
   :param remainingVersion: the remaining version
   :return: the internet explorer by version

listInternetExplorer
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<InternetExplorer> listInternetExplorer()
   :outertype: InternetExplorerDAO

   List internet explorer.

   :return: the list

removeInternetExplorer
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeInternetExplorer(Integer id)
   :outertype: InternetExplorerDAO

   Removes the internet explorer.

   :param id: the id

