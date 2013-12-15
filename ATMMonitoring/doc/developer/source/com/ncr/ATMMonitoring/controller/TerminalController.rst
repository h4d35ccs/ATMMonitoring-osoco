.. java:import:: java.awt.image BufferedImage

.. java:import:: java.io BufferedOutputStream

.. java:import:: java.io IOException

.. java:import:: java.io OutputStream

.. java:import:: java.io OutputStreamWriter

.. java:import:: java.security Principal

.. java:import:: java.util ArrayList

.. java:import:: java.util Date

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.imageio ImageIO

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.servlet.http HttpServletResponse

.. java:import:: javax.validation Valid

.. java:import:: org.apache.log4j Logger

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

.. java:import:: org.springframework.web.bind.annotation RequestParam

.. java:import:: org.springframework.web.multipart.commons CommonsMultipartFile

.. java:import:: org.springframework.web.servlet.mvc.support RedirectAttributes

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.controller.propertyEditor.DatePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.InstallationService

.. java:import:: com.ncr ATMMonitoring.service.LocationService

.. java:import:: com.ncr ATMMonitoring.service.QueryService

.. java:import:: com.ncr ATMMonitoring.service.TerminalModelService

.. java:import:: com.ncr ATMMonitoring.service.TerminalService

.. java:import:: com.ncr ATMMonitoring.service.UserService

.. java:import:: com.ncr ATMMonitoring.socket.SocketService

TerminalController
==================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class TerminalController

   The Class TerminalController.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
DEFAULT_ORDER
^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_ORDER
   :outertype: TerminalController

   The Constant DEFAULT_ORDER.

DEFAULT_SORT
^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_SORT
   :outertype: TerminalController

   The Constant DEFAULT_SORT.

Methods
-------
addTerminal
^^^^^^^^^^^

.. java:method:: @RequestMapping public String addTerminal(Terminal terminal, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal, String p)
   :outertype: TerminalController

   Adds the terminal.

   :param terminal: the terminal
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :param p: the p
   :return: the string

addTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addTerminalModel(TerminalModel terminalModel, CommonsMultipartFile photo, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: TerminalController

   Adds the terminal model.

   :param terminalModel: the terminal model
   :param photo: the photo
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the p
   :param principal: the principal
   :return: the string

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: TerminalController

   Binder.

   :param binder: the binder

deleteTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteTerminalModel(Integer terminalModelId, Principal principal)
   :outertype: TerminalController

   Delete terminal model.

   :param terminalModelId: the terminal model id
   :param principal: the principal
   :return: the string

downloadResultsCsv
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void downloadResultsCsv(HttpServletResponse response, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Download results csv.

   :param response: the response
   :param request: the request
   :param principal: the principal

downloadResultsCsvForQuery
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void downloadResultsCsvForQuery(Integer queryId, HttpServletResponse response, HttpServletRequest request)
   :outertype: TerminalController

   Download results csv for query.

   :param queryId: the query id
   :param response: the response
   :param request: the request

getTerminalModelImage
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void getTerminalModelImage(Integer terminalModelId, HttpServletRequest request, HttpServletResponse response, String width, String height)
   :outertype: TerminalController

   Gets the terminal model image.

   :param terminalModelId: the terminal model id
   :param request: the request
   :param response: the response
   :param width: the width
   :param height: the height
   :return: the terminal model image

importTerminal
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String importTerminal(CommonsMultipartFile file, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Import terminal.

   :param file: the file
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

listTerminalModels
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listTerminalModels(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: TerminalController

   List terminal models.

   :param map: the map
   :param principal: the principal
   :param p: the p
   :param request: the request
   :return: the string

listTerminals
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listTerminals(Map<String, Object> map, Principal principal, String p, String sort, String order, HttpServletRequest request)
   :outertype: TerminalController

   List terminals.

   :param map: the map
   :param principal: the principal
   :param p: the p
   :param sort: the sort
   :param order: the order
   :param request: the request
   :return: the string

listTerminalsByQuery
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listTerminalsByQuery(Map<String, Object> map, Integer queryId, Principal principal, String p, String sort, String order, HttpServletRequest request)
   :outertype: TerminalController

   List terminals by query.

   :param map: the map
   :param queryId: the query id
   :param principal: the principal
   :param p: the p
   :param sort: the sort
   :param order: the order
   :param request: the request
   :return: the string

newInstallation
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String newInstallation(Installation installation, BindingResult result, Map<String, Object> map, String matricula, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   New installation.

   :param installation: the installation
   :param result: the result
   :param map: the map
   :param matricula: the matricula
   :param request: the request
   :param principal: the principal
   :return: the string

newInstallationForm
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String newInstallationForm(Map<String, Object> map, String matricula)
   :outertype: TerminalController

   New installation form.

   :param map: the map
   :param matricula: the matricula
   :return: the string

redirectToTerminalModels
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToTerminalModels()
   :outertype: TerminalController

   Redirect to terminal models.

   :return: the string

redirectToTerminals
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToTerminals()
   :outertype: TerminalController

   Redirect to terminals.

   :return: the string

requestTerminalUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String requestTerminalUpdate(Integer terminalId, Map<String, Object> map, HttpServletRequest request, RedirectAttributes redirectAttributes, Principal principal)
   :outertype: TerminalController

   Request terminal update.

   :param terminalId: the terminal id
   :param map: the map
   :param request: the request
   :param redirectAttributes: the redirect attributes
   :param principal: the principal
   :return: the string

requestTerminalsUpdate
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String requestTerminalsUpdate(Map<String, Object> map, String queryId, HttpServletRequest request, Principal principal, RedirectAttributes redirectAttributes)
   :outertype: TerminalController

   Request terminals update.

   :param map: the map
   :param queryId: the query id
   :param request: the request
   :param principal: the principal
   :param redirectAttributes: the redirect attributes
   :return: the string

terminalDetails
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String terminalDetails(Integer terminalId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Terminal details.

   :param terminalId: the terminal id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

terminalModelDetails
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String terminalModelDetails(Integer terminalModelId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Terminal model details.

   :param terminalModelId: the terminal model id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateTerminal(Terminal terminal, BindingResult result, Map<String, Object> map, RedirectAttributes redirectAttributes, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Update terminal.

   :param terminal: the terminal
   :param result: the result
   :param map: the map
   :param redirectAttributes: the redirect attributes
   :param request: the request
   :param principal: the principal
   :return: the string

updateTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateTerminalModel(TerminalModel terminalModel, CommonsMultipartFile photo, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Update terminal model.

   :param terminalModel: the terminal model
   :param photo: the photo
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

viewNewTerminal
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String viewNewTerminal(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   View new terminal.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

