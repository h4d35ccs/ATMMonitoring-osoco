.. java:import:: java.security Principal

.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.security.core.userdetails UsernameNotFoundException

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind WebDataBinder

.. java:import:: org.springframework.web.bind.annotation InitBinder

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.controller.propertyEditor.RolePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Role

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.RoleService

.. java:import:: com.ncr ATMMonitoring.service.UserService

UserController
==============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class UserController

   The Class UserController. Controller for handling user related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addUser
^^^^^^^

.. java:method:: @RequestMapping public String addUser(User user, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Add user URL.

   :param user: the user
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: UserController

   Binds custom property editors.

   :param binder: the binder

deleteUser
^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteUser(Integer userId, Principal principal)
   :outertype: UserController

   Delete user URL.

   :param userId: the user id
   :param principal: the principal
   :return: the petition response

listUsers
^^^^^^^^^

.. java:method:: @RequestMapping public String listUsers(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   List users URL.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

newGroup
^^^^^^^^

.. java:method:: @RequestMapping public String newGroup()
   :outertype: UserController

   New group URL.

   :return: the petition response

redirectToUsers
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToUsers(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Redirect to users URL.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

updatePassword
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updatePassword(User user, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Update password URL.

   :param user: the user
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

updateUser
^^^^^^^^^^

.. java:method:: @RequestMapping public String updateUser(User user, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Update user URL.

   :param user: the user
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

userDetails
^^^^^^^^^^^

.. java:method:: @RequestMapping public String userDetails(Integer userId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   User details URL.

   :param userId: the user id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

