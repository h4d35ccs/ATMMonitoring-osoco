.. java:import:: java.security Principal

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util ArrayList

.. java:import:: java.util Date

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind WebDataBinder

.. java:import:: org.springframework.web.bind.annotation InitBinder

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.bind.annotation ResponseBody

.. java:import:: org.springframework.web.servlet.mvc.support RedirectAttributes

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.controller.propertyEditor.DatePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.ScheduledUpdateService

.. java:import:: com.ncr ATMMonitoring.service.UserService

ScheduledUpdateController
=========================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class ScheduledUpdateController

   The Class ScheduledUpdateController. Controller for handling scheduled update related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addScheduledUpdate(ScheduledUpdate scheduledUpdate, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal, RedirectAttributes redirectAttributes)
   :outertype: ScheduledUpdateController

   Adds the scheduled update.

   :param scheduledUpdate: the scheduled update
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :param redirectAttributes: the redirect attributes
   :return: the petition response

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: ScheduledUpdateController

   Binds custom property editors.

   :param binder: the binder

deleteScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteScheduledUpdate(Integer scheduledUpdateId, RedirectAttributes redirectAttributes)
   :outertype: ScheduledUpdateController

   Delete scheduled update.

   :param scheduledUpdateId: the scheduled update id
   :param redirectAttributes: the redirect attributes
   :return: the petition response

listSchedules
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listSchedules(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: ScheduledUpdateController

   List schedules URL.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

listUpdateEvents
^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseBody public List listUpdateEvents(long start, long end, HttpServletRequest request, Principal principal)
   :outertype: ScheduledUpdateController

   List update events between two dates.

   :param start: the start date
   :param end: the end date
   :param request: the request
   :param principal: the principal
   :return: the list of update events

newScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String newScheduledUpdate(Map<String, Object> map, String queryId, HttpServletRequest request, Principal principal)
   :outertype: ScheduledUpdateController

   New scheduled update.

   :param map: the map
   :param queryId: the query id
   :param request: the request
   :param principal: the principal
   :return: the petition response

redirectToSchedules
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToSchedules()
   :outertype: ScheduledUpdateController

   Redirect to schedules.

   :return: the petition response

