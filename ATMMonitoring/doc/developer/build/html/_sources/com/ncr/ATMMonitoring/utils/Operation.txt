.. java:import:: java.text DateFormat

.. java:import:: java.text ParseException

.. java:import:: java.util Calendar

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: org.hibernate.type CalendarType

.. java:import:: org.hibernate.type FloatType

.. java:import:: org.hibernate.type IntegerType

.. java:import:: org.hibernate.type StringType

.. java:import:: org.hibernate.type Type

Operation
=========

.. java:package:: com.ncr.ATMMonitoring.utils
   :noindex:

.. java:type:: public abstract class Operation

   The Class Operation.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getConstraintHQL
^^^^^^^^^^^^^^^^

.. java:method:: public static String getConstraintHQL(String column, String operation, String value, List<Object> values, List<Type> types, Locale locale)
   :outertype: Operation

   Gets the constraint hql.

   :param column: the column
   :param operation: the operation
   :param value: the value
   :param values: the values
   :param types: the types
   :param locale: the locale
   :return: the constraint hql

getOperationsByType
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getOperationsByType(DataType type)
   :outertype: Operation

   Gets the operations by type.

   :param type: the type
   :return: the operations by type

needsNotVoidValue
^^^^^^^^^^^^^^^^^

.. java:method:: public static boolean needsNotVoidValue(String operation)
   :outertype: Operation

   Needs not void value.

   :param operation: the operation
   :return: true, if successful

