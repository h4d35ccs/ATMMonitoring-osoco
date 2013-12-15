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

   The Class Utils.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
concatIntegers
^^^^^^^^^^^^^^

.. java:method:: public static String concatIntegers(List<Integer> integers, char separator)
   :outertype: Utils

   Concat integers.

   :param integers: the integers
   :param separator: the separator
   :return: the string

concatStrings
^^^^^^^^^^^^^

.. java:method:: public static String concatStrings(List<String> strings, char separator)
   :outertype: Utils

   Concat strings.

   :param strings: the strings
   :param separator: the separator
   :return: the string

getMD5Hex
^^^^^^^^^

.. java:method:: public static String getMD5Hex(String content)
   :outertype: Utils

   Gets the m d5 hex.

   :param content: the content
   :return: the m d5 hex

splitIntegers
^^^^^^^^^^^^^

.. java:method:: public static List<Integer> splitIntegers(String integers, char separator)
   :outertype: Utils

   Split integers.

   :param integers: the integers
   :param separator: the separator
   :return: the list

splitStrings
^^^^^^^^^^^^

.. java:method:: public static List<String> splitStrings(String strings, char separator)
   :outertype: Utils

   Split strings.

   :param strings: the strings
   :param separator: the separator
   :return: the list

toJson
^^^^^^

.. java:method:: public static String toJson(Object object)
   :outertype: Utils

   To json.

   :param object: the object
   :return: the string

unescapeJsonChain
^^^^^^^^^^^^^^^^^

.. java:method:: public static String unescapeJsonChain(String chain)
   :outertype: Utils

   Unescape json chain.

   :param chain: the chain
   :return: the string

