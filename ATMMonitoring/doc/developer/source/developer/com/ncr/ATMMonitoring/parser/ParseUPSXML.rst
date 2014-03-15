.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: org.apache.commons.io IOUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: com.ncr ATMMonitoring.parser.dto.UPSInfo

.. java:import:: com.ncr ATMMonitoring.parser.exception.NoParserFoundException

.. java:import:: com.ncr ATMMonitoring.parser.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.exception.XMLNotReadableException

ParseUPSXML
===========

.. java:package:: com.ncr.ATMMonitoring.parser
   :noindex:

.. java:type:: public abstract class ParseUPSXML

   Interface that define a XML UPS Parser ( a Link in the responsibility chain) <br> To start the chain and the parsing process call the :java:ref:`ParseUPSChainBuilder.parse(InputStream)`

   :author: ottoabreu

Fields
------
logger
^^^^^^

.. java:field:: protected static final Logger logger
   :outertype: ParseUPSXML

Methods
-------
applyParser
^^^^^^^^^^^

.. java:method:: protected abstract UPSInfo applyParser() throws ParserException, XMLNotReadableException, NoParserFoundException
   :outertype: ParseUPSXML

   Method that holds the specific logic to parse each XML and must be implemented by all the concrete classes

   :return: UPSInfo

canParseXML
^^^^^^^^^^^

.. java:method:: protected abstract boolean canParseXML() throws ParserException, XMLNotReadableException
   :outertype: ParseUPSXML

   Indicate if the parser is in charge of read the XML<br> Return true if the parser will process the file, false if will delegate the process to other parser

   :return: boolean

getOriginalXmlString
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected String getOriginalXmlString()
   :outertype: ParseUPSXML

   Returns the original xml in string format

   :return: String

getXmlFile
^^^^^^^^^^

.. java:method:: protected InputStream getXmlFile()
   :outertype: ParseUPSXML

   Returns the XML Inputstream

   :return: InputStream

parseXML
^^^^^^^^

.. java:method:: public UPSInfo parseXML(InputStream xmlFile) throws ParserException, XMLNotReadableException, NoParserFoundException
   :outertype: ParseUPSXML

   Method that parse an XML from an specific UPS<br> If the XML can not be parsed by this method, the next parser will be called ( Chain of responsibility pattern)

   :param xmlFile: :java:ref:`InputStream`
   :return: :java:ref:`UPSInfo`

setNextParser
^^^^^^^^^^^^^

.. java:method:: public void setNextParser(ParseUPSXML nextParser)
   :outertype: ParseUPSXML

   Sets the next parser in the chain

   :param nextParser: :java:ref:`ParseUPSXML`

