.. java:import:: java.io BufferedOutputStream

.. java:import:: java.io IOException

.. java:import:: java.io OutputStream

.. java:import:: java.io OutputStreamWriter

.. java:import:: java.security Principal

.. java:import:: java.text DateFormat

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util ArrayList

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.servlet.http HttpServletResponse

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.beans.support PagedListHolder

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: org.springframework.web.servlet.mvc.support RedirectAttributes

.. java:import:: org.springframework.web.util WebUtils

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.QueryService

.. java:import:: com.ncr ATMMonitoring.service.UserService

.. java:import:: org.apache.log4j Logger

QueryController
===============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class QueryController

   The Class QueryController.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
DEFAULT_ORDER
^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_ORDER
   :outertype: QueryController

   The Constant DEFAULT_ORDER.

DEFAULT_SORT
^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_SORT
   :outertype: QueryController

   The Constant DEFAULT_SORT.

Methods
-------
createQuery
^^^^^^^^^^^

.. java:method:: @RequestMapping public String createQuery(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Creates the query.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

deleteUserQuery
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteUserQuery(Integer queryId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Delete user query.

   :param queryId: the query id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

downloadResultsCsv
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void downloadResultsCsv(Query query, HttpServletResponse response, HttpServletRequest request, String sort, String order)
   :outertype: QueryController

   Download results csv.

   :param query: the query
   :param response: the response
   :param request: the request
   :param sort: the sort
   :param order: the order

listQueries
^^^^^^^^^^^

.. java:method:: @RequestMapping public String listQueries(Map<String, Object> map, HttpServletRequest request, Principal principal, String p)
   :outertype: QueryController

   List queries.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :param p: the p
   :return: the string

redirectFromWrongResults
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectFromWrongResults()
   :outertype: QueryController

   Redirect from wrong results.

   :return: the string

redirectFromWrongResultsExport
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectFromWrongResultsExport()
   :outertype: QueryController

   Redirect from wrong results export.

   :return: the string

redirectToQueries
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToQueries()
   :outertype: QueryController

   Redirect to queries.

   :return: the string

saveOrUpdateQuery
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String saveOrUpdateQuery(Query query, Map<String, Object> map, HttpServletRequest request, Principal principal, RedirectAttributes redirectAttributes, String p, String sort, String order) throws Exception
   :outertype: QueryController

   Save or update query.

   :param query: the query
   :param map: the map
   :param request: the request
   :param principal: the principal
   :param redirectAttributes: the redirect attributes
   :param p: the p
   :param sort: the sort
   :param order: the order
   :return: the string

selectUserQuery
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String selectUserQuery(Query query, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Select user query.

   :param query: the query
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

showUserQuery
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showUserQuery(Integer queryId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Show user query.

   :param queryId: the query id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

