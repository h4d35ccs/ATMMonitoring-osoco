.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.utils.WidgetQueryAssociationType

QueryService
============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface QueryService

   The Interface QueryService. It contains the query related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addQuery
^^^^^^^^

.. java:method:: public void addQuery(Query query)
   :outertype: QueryService

   Adds the query.

   :param query: the query

deleteQuery
^^^^^^^^^^^

.. java:method:: public void deleteQuery(Query query)
   :outertype: QueryService

   Delete query.

   :param query: the query

executeQuery
^^^^^^^^^^^^

.. java:method:: public List<Terminal> executeQuery(Query query, Locale locale, String sort, String order, Date queryDate)
   :outertype: QueryService

   Execute query.

   :param query: the query
   :param locale: the locale
   :param sort: the fields for sorting terminals
   :param order: the order for sorting terminals
   :param queryDate: date for query to auditable elements
   :return: the terminal list

executeQuery
^^^^^^^^^^^^

.. java:method:: public List<Terminal> executeQuery(Query query, Locale locale, String sort, String order)
   :outertype: QueryService

   Execute query.

   :param query: the query
   :param locale: the locale
   :param sort: the fields for sorting terminals
   :param order: the order for sorting terminals
   :return: the terminal list

executeQuery
^^^^^^^^^^^^

.. java:method:: public List<Terminal> executeQuery(Query query, Locale locale)
   :outertype: QueryService

   Execute query.

   :param query: the query
   :param locale: the locale
   :return: the terminal list

executeQuery
^^^^^^^^^^^^

.. java:method:: public List<Terminal> executeQuery(Query query)
   :outertype: QueryService

   Execute query.

   :param query: the query
   :return: the terminal list

executeQueryGroupingBy
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<?> executeQueryGroupingBy(Query query, WidgetQueryAssociationType groupByEntity, String groupBy, Locale locale, Date queryDate)
   :outertype: QueryService

   Execute query grouping by.

   :param query: the query
   :param groupByEntity: the group by entity
   :param groupBy: the group by
   :param locale: the locale
   :return: the query list

findOrCreateQuery
^^^^^^^^^^^^^^^^^

.. java:method:: public Query findOrCreateQuery(Query query)
   :outertype: QueryService

   Find or create query.

   :param query: the query
   :return: the query

getQuery
^^^^^^^^

.. java:method:: public Query getQuery(Integer id)
   :outertype: QueryService

   Gets the query by its id.

   :param id: the query id
   :return: the query

listQueries
^^^^^^^^^^^

.. java:method:: public List<Query> listQueries()
   :outertype: QueryService

   List queries.

   :return: the query list

updateQuery
^^^^^^^^^^^

.. java:method:: public void updateQuery(Query query)
   :outertype: QueryService

   Update query.

   :param query: the query

