NoParserFoundException
======================

.. java:package:: com.ncr.ATMMonitoring.parser.exception
   :noindex:

.. java:type:: public class NoParserFoundException extends Exception

   Indicate that the given XML can be processed by any parser found in the classpath

   :author: ottoabreu

Fields
------
NO_PARSERS_FOUND
^^^^^^^^^^^^^^^^

.. java:field:: public static final String NO_PARSERS_FOUND
   :outertype: NoParserFoundException

   NO_PARSERS_FOUND = "The builder can not find parsers in the classpath, imposible to begin the process";

NO_PARSER_FOUND
^^^^^^^^^^^^^^^

.. java:field:: public static final String NO_PARSER_FOUND
   :outertype: NoParserFoundException

   NO_PARSER_FOUND = "The given XML can not be processed by any parser present in the classpath, check the configured parsers or add a new one to the classpath" ;

Constructors
------------
NoParserFoundException
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NoParserFoundException(String message)
   :outertype: NoParserFoundException

   :param message:

