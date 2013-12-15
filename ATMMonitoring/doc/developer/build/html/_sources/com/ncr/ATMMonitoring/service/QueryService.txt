.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Locale

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

QueryService
============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface QueryService

   The Interface QueryService.

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

.. java:method:: public List<Terminal> executeQuery(Query query, Locale locale, String sort, String order)
   :outertype: QueryService

   Execute query.

   :param query: the query
   :param locale: the locale
   :param sort: the sort
   :param order: the order
   :return: the list

executeQuery
^^^^^^^^^^^^

.. java:method:: public List<Terminal> executeQuery(Query query, Locale locale)
   :outertype: QueryService

   Execute query.

   :param query: the query
   :param locale: the locale
   :return: the list

executeQuery
^^^^^^^^^^^^

.. java:method:: public List<Terminal> executeQuery(Query query)
   :outertype: QueryService

   Execute query.

   :param query: the query
   :return: the list

executeQueryGroupingBy
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List executeQueryGroupingBy(Query query, String groupByEntity, String groupBy, Locale locale)
   :outertype: QueryService

   Execute query grouping by.

   :param query: the query
   :param groupByEntity: the group by entity
   :param groupBy: the group by
   :param locale: the locale
   :return: the list

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

   Gets the query.

   :param id: the id
   :return: the query

listQueries
^^^^^^^^^^^

.. java:method:: public List<Query> listQueries()
   :outertype: QueryService

   List queries.

   :return: the list

updateQuery
^^^^^^^^^^^

.. java:method:: public void updateQuery(Query query)
   :outertype: QueryService

   Update query.

   :param query: the query

