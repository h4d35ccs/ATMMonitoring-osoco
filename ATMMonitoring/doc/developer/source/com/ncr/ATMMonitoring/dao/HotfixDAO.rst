.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Hotfix

HotfixDAO
=========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface HotfixDAO

   The Interface HotfixDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHotfix
^^^^^^^^^

.. java:method:: public void addHotfix(Hotfix hotfix)
   :outertype: HotfixDAO

   Adds the hotfix.

   :param hotfix: the hotfix

getHotfix
^^^^^^^^^

.. java:method:: public Hotfix getHotfix(Integer id)
   :outertype: HotfixDAO

   Gets the hotfix.

   :param id: the id
   :return: the hotfix

listHotfix
^^^^^^^^^^

.. java:method:: public List<Hotfix> listHotfix()
   :outertype: HotfixDAO

   List hotfix.

   :return: the list

removeHotfix
^^^^^^^^^^^^

.. java:method:: public void removeHotfix(Integer id)
   :outertype: HotfixDAO

   Removes the hotfix.

   :param id: the id

