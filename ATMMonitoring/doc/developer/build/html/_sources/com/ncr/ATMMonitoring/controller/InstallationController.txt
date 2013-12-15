.. java:import:: java.security Principal

.. java:import:: java.util Date

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.beans.support PagedListHolder

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind WebDataBinder

.. java:import:: org.springframework.web.bind.annotation InitBinder

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.controller.propertyEditor.DatePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.Location

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.InstallationService

.. java:import:: com.ncr ATMMonitoring.service.LocationService

.. java:import:: com.ncr ATMMonitoring.service.UserService

InstallationController
======================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class InstallationController

   The Class InstallationController.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallation
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addInstallation(Installation installation, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: InstallationController

   Adds the installation.

   :param installation: the installation
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the p
   :param principal: the principal
   :return: the string

addLocation
^^^^^^^^^^^

.. java:method:: @RequestMapping public String addLocation(Location location, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: InstallationController

   Adds the location.

   :param location: the location
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the p
   :param principal: the principal
   :return: the string

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: InstallationController

   Binder.

   :param binder: the binder

deleteInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteInstallation(Integer installationId, Principal principal)
   :outertype: InstallationController

   Delete installation.

   :param installationId: the installation id
   :param principal: the principal
   :return: the string

deleteLocation
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteLocation(Integer locationId, Principal principal)
   :outertype: InstallationController

   Delete location.

   :param locationId: the location id
   :param principal: the principal
   :return: the string

installationDetails
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String installationDetails(Integer installationId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Installation details.

   :param installationId: the installation id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

listInstallations
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listInstallations(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: InstallationController

   List installations.

   :param map: the map
   :param principal: the principal
   :param p: the p
   :param request: the request
   :return: the string

listLocations
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listLocations(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: InstallationController

   List locations.

   :param map: the map
   :param principal: the principal
   :param p: the p
   :param request: the request
   :return: the string

locationDetails
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String locationDetails(Integer locationId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Location details.

   :param locationId: the location id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

redirectToInstallations
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToInstallations()
   :outertype: InstallationController

   Redirect to installations.

   :return: the string

redirectToLocations
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToLocations()
   :outertype: InstallationController

   Redirect to locations.

   :return: the string

updateInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateInstallation(Installation installation, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Update installation.

   :param installation: the installation
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

updateLocation
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateLocation(Location location, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Update location.

   :param location: the location
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

