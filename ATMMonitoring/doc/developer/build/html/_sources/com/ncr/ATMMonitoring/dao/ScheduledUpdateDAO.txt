.. java:import:: java.util Calendar

.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

ScheduledUpdateDAO
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface ScheduledUpdateDAO

   The Interface ScheduledUpdateDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAO

   Adds the scheduled update.

   :param scheduledUpdate: the scheduled update

existsMonthlyScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAO

   Exists monthly scheduled update.

   :param scheduledUpdate: the scheduled update
   :return: true, if successful

existsWeeklyScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAO

   Exists weekly scheduled update.

   :param scheduledUpdate: the scheduled update
   :return: true, if successful

getScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: public ScheduledUpdate getScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateDAO

   Gets the scheduled update.

   :param id: the id
   :return: the scheduled update

listMonthlyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listMonthlyScheduledUpdates()
   :outertype: ScheduledUpdateDAO

   List monthly scheduled updates.

   :return: the list

listValidScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date)
   :outertype: ScheduledUpdateDAO

   List valid scheduled updates.

   :param date: the date
   :return: the list

listWeeklyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listWeeklyScheduledUpdates()
   :outertype: ScheduledUpdateDAO

   List weekly scheduled updates.

   :return: the list

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateDAO

   Removes the scheduled update.

   :param id: the id

