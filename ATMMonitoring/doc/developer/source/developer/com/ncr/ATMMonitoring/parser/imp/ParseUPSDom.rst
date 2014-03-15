.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: javax.xml.parsers DocumentBuilder

.. java:import:: javax.xml.parsers DocumentBuilderFactory

.. java:import:: javax.xml.parsers ParserConfigurationException

.. java:import:: org.w3c.dom Document

.. java:import:: org.w3c.dom Element

.. java:import:: org.w3c.dom.ls DOMImplementationLS

.. java:import:: org.w3c.dom.ls LSSerializer

.. java:import:: org.xml.sax SAXException

.. java:import:: com.ncr ATMMonitoring.parser.ParseUPSChainBuilder

.. java:import:: com.ncr ATMMonitoring.parser.ParseUPSXML

.. java:import:: com.ncr ATMMonitoring.parser.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.exception.XMLNotReadableException

ParseUPSDom
===========

.. java:package:: com.ncr.ATMMonitoring.parser.imp
   :noindex:

.. java:type:: public abstract class ParseUPSDom extends ParseUPSXML

   Class that define a parse based on w3c DOM<br> Holds the common logic to parse a XML based on DOM parser<br> ***Do not call the parser directly, call :java:ref:`ParseUPSChainBuilder.parse(InputStream)`***

   :author: ottoabreu

Methods
-------
getDoc
^^^^^^

.. java:method:: protected Document getDoc() throws ParserException, XMLNotReadableException
   :outertype: ParseUPSDom

   Returns the :java:ref:`Document`

   :return: Document

getRootElement
^^^^^^^^^^^^^^

.. java:method:: protected Element getRootElement() throws ParserException, XMLNotReadableException
   :outertype: ParseUPSDom

   Returns the root element, can return null if the Inputstream has not bean set

   :return: Element

getStringFromDoc
^^^^^^^^^^^^^^^^

.. java:method:: protected String getStringFromDoc()
   :outertype: ParseUPSDom

   Returns the XML in String format

   :param doc: Document
   :return: String

