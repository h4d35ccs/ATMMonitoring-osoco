.. java:import:: java.security Principal

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.UserService

HelpController
==============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class HelpController

   The Class HelpController. Controller for handling help related HTTP petitions.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
showDashboardHelp
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showDashboardHelp(Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: HelpController

   Show dashboard help URL.

   :param map: the map
   :param principal: the principal
   :param request: the request
   :return: the petition response

showHelp
^^^^^^^^

.. java:method:: @RequestMapping public String showHelp(Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: HelpController

   Show default help URL.

   :param map: the map
   :param principal: the principal
   :param request: the request
   :return: the petition response

showTerminalsHelp
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showTerminalsHelp(Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: HelpController

   Show terminals help URL.

   :param map: the map
   :param principal: the principal
   :param request: the request
   :return: the petition response

