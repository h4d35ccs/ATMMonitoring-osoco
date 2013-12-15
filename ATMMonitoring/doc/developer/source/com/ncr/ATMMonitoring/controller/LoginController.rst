.. java:import:: java.util Map

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

LoginController
===============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class LoginController

   The Class LoginController.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
login
^^^^^

.. java:method:: @RequestMapping public String login()
   :outertype: LoginController

   Login.

   :return: the string

loginFailed
^^^^^^^^^^^

.. java:method:: @RequestMapping public String loginFailed(Map<String, Object> map)
   :outertype: LoginController

   Login failed.

   :param map: the map
   :return: the string

printWelcome
^^^^^^^^^^^^

.. java:method:: @RequestMapping public String printWelcome()
   :outertype: LoginController

   Prints the welcome.

   :return: the string

redirectToIndex
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToIndex()
   :outertype: LoginController

   Redirect to index.

   :return: the string

