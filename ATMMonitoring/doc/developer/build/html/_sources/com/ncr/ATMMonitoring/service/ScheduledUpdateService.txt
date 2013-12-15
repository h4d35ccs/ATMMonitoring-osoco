.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

ScheduledUpdateService
======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface ScheduledUpdateService

   The Interface ScheduledUpdateService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateService

   Adds the scheduled update.

   :param scheduledUpdate: the scheduled update

checkCurrentUpdates
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void checkCurrentUpdates()
   :outertype: ScheduledUpdateService

   Check current updates.

existsScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean existsScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateService

   Exists scheduled update.

   :param scheduledUpdate: the scheduled update
   :return: true, if successful

listMonthlyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listMonthlyScheduledUpdates()
   :outertype: ScheduledUpdateService

   List monthly scheduled updates.

   :return: the list

listWeeklyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listWeeklyScheduledUpdates()
   :outertype: ScheduledUpdateService

   List weekly scheduled updates.

   :return: the list

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateService

   Removes the scheduled update.

   :param id: the id

