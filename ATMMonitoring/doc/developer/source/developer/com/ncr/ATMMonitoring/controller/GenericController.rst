.. java:import:: java.security Principal

.. java:import:: java.util Locale

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.UserService

GenericController
=================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public abstract class GenericController

   Holds the common method between the controllers

   :author: Otto Abreu

Methods
-------
clearSession
^^^^^^^^^^^^

.. java:method:: protected void clearSession(HttpServletRequest request, String sessionKey)
   :outertype: GenericController

   clear a value from the session

   :param request:
   :param sessionKey:

getUserGreeting
^^^^^^^^^^^^^^^

.. java:method:: protected String getUserGreeting(Principal principal, HttpServletRequest request)
   :outertype: GenericController

   Obtains the greeting for the user

   :param principal:
   :param request:

