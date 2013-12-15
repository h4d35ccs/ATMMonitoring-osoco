.. java:import:: java.security Principal

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

HelpController
==============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class HelpController

   The Class HelpController.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
showDashboard
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showDashboard(Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: HelpController

   Show dashboard.

   :param map: the map
   :param principal: the principal
   :param request: the request
   :return: the string

