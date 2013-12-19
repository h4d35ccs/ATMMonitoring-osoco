.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util.regex Matcher

.. java:import:: org.apache.commons.codec.digest DigestUtils

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson GsonBuilder

Utils
=====

.. java:package:: com.ncr.ATMMonitoring.utils
   :noindex:

.. java:type:: public abstract class Utils

   The Class Utils. Commodity methods for several purposes.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
concatIntegers
^^^^^^^^^^^^^^

.. java:method:: public static String concatIntegers(List<Integer> integers, char separator)
   :outertype: Utils

   Concat integers into an string with the given separator.

   :param integers: the integers
   :param separator: the separator
   :return: the concatted string

concatStrings
^^^^^^^^^^^^^

.. java:method:: public static String concatStrings(List<String> strings, char separator)
   :outertype: Utils

   Concats strings with the given separator.

   :param strings: the strings
   :param separator: the separator
   :return: the concatted strings

getMD5Hex
^^^^^^^^^

.. java:method:: public static String getMD5Hex(String content)
   :outertype: Utils

   Gets the MD5 hex from the given string.

   :param content: the string
   :return: the MD5 hex

splitIntegers
^^^^^^^^^^^^^

.. java:method:: public static List<Integer> splitIntegers(String integers, char separator)
   :outertype: Utils

   Split integers concatted into an string with the given separator.

   :param integers: the integers
   :param separator: the separator
   :return: the list with all the split integers

splitStrings
^^^^^^^^^^^^

.. java:method:: public static List<String> splitStrings(String strings, char separator)
   :outertype: Utils

   Splits strings concatted with the given separator.

   :param strings: the concatted strings
   :param separator: the separator
   :return: the list with all the split strings

toJson
^^^^^^

.. java:method:: public static String toJson(Object object)
   :outertype: Utils

   Tranforms an object to its Gson json representation.

   :param object: the object
   :return: the json string

unescapeJsonChain
^^^^^^^^^^^^^^^^^

.. java:method:: public static String unescapeJsonChain(String chain)
   :outertype: Utils

   Unescape special characters in a json chain.

   :param chain: the json chain
   :return: the unescaped chain

