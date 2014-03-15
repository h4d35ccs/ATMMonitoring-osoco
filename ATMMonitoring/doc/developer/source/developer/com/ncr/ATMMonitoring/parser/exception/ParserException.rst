ParserException
===============

.. java:package:: com.ncr.ATMMonitoring.parser.exception
   :noindex:

.. java:type:: public class ParserException extends Exception

   Indicate an error while executing the parsing operation that are not related to the read

   :author: ottoabreu

Fields
------
GENERAL_ERROR
^^^^^^^^^^^^^

.. java:field:: public static final String GENERAL_ERROR
   :outertype: ParserException

   GENERAL_ERROR = "Can not continue with the parse operation due a general error: ";

PARSER_CONFIGURATION_ERROR
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String PARSER_CONFIGURATION_ERROR
   :outertype: ParserException

   DOCUMENT_BUILDER_ERROR = "Can not get the document builder, the file will not be parsed";

Constructors
------------
ParserException
^^^^^^^^^^^^^^^

.. java:constructor:: public ParserException(String arg0)
   :outertype: ParserException

   :param arg0:

ParserException
^^^^^^^^^^^^^^^

.. java:constructor:: public ParserException(Throwable arg0)
   :outertype: ParserException

   :param arg0:

ParserException
^^^^^^^^^^^^^^^

.. java:constructor:: public ParserException(String arg0, Throwable arg1)
   :outertype: ParserException

   :param arg0:
   :param arg1:

