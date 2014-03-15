.. java:import:: java.io InputStream

.. java:import:: java.text ParseException

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Date

.. java:import:: java.util.concurrent TimeUnit

.. java:import:: java.util.regex Matcher

.. java:import:: java.util.regex Pattern

.. java:import:: org.w3c.dom DOMException

.. java:import:: org.w3c.dom Element

.. java:import:: org.w3c.dom Node

.. java:import:: org.w3c.dom NodeList

.. java:import:: com.ncr ATMMonitoring.parser.ParseUPSChainBuilder

.. java:import:: com.ncr ATMMonitoring.parser.annotation.UPSParser

.. java:import:: com.ncr ATMMonitoring.parser.dto.UPSInfo

.. java:import:: com.ncr ATMMonitoring.parser.exception.NoParserFoundException

.. java:import:: com.ncr ATMMonitoring.parser.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.exception.XMLNotReadableException

ParseEmersonUPS
===============

.. java:package:: com.ncr.ATMMonitoring.parser.imp
   :noindex:

.. java:type:: @UPSParser public class ParseEmersonUPS extends ParseUPSDom

   Class that parse an Emerson UPS XML with the following structure:<br> &lt;PK-C1-UPS&gt;<br> &nbsp;&nbsp;&lt;NUMPUESTO&gt;&lt;/NUMPUESTO&gt;<br> &nbsp;&nbsp;&lt;IP_UPS&gt;&lt;/IP_UPS&gt;<br> &nbsp;&nbsp;&lt;FIRMWARE_UPS&gt;&lt;/FIRMWARE_UPS&gt;<br> &nbsp;&nbsp;&lt;ESTADO_UPS&gt;&lt;/ESTADO_UPS&gt;<br> &nbsp;&nbsp;&lt;PORCENTAJE_CARGA_UPS&gt;&lt;/PORCENTAJE_CARGA_UPS&gt;<br> &nbsp;&nbsp;&lt;PORCENTAJE_GASTO_UPS&gt;&lt;/PORCENTAJE_GASTO_UPS&gt;<br> &nbsp;&nbsp;&lt;ALARMAS_UPS&gt;&lt;/ALARMAS_UPS&gt;<br> &nbsp;&nbsp;&lt;NOMBRE_UPS&gt;&lt;/NOMBRE_UPS&gt;<br> &nbsp;&nbsp;&lt;MODELO_UPS&gt;&lt;/MODELO_UPS&gt;<br> &nbsp;&nbsp;&lt;NUM_SERIE_UPS&gt;&lt;/NUM_SERIE_UPS&gt;<br> &nbsp;&nbsp;&lt;TIEMPO_ENCENDIDO_UPS&gt;&lt;/TIEMPO_ENCENDIDO_UPS&gt;<br> &nbsp;&nbsp;&lt;AUTONOMIA_UPS&gt;&lt;/AUTONOMIA_UPS&gt;<br> &nbsp;&nbsp;&lt;AUD_FMO_UPS&gt;&lt;/AUD_FMO_UPS&gt;<br> &nbsp;&nbsp;&lt;STATUS&gt;&lt;/STATUS&gt;<br> &nbsp;&nbsp;&lt;FECHA_ULTIMA_EJECUCION&gt;&lt;/FECHA_ULTIMA_EJECUCION&gt;<br> &lt;PK-C1-UPSS&gt;<br> ***Do not call the parser directly, call :java:ref:`ParseUPSChainBuilder.parse(InputStream)`***

   :author: ottoabreu

Methods
-------
applyParser
^^^^^^^^^^^

.. java:method:: @Override protected UPSInfo applyParser() throws ParserException, XMLNotReadableException, NoParserFoundException
   :outertype: ParseEmersonUPS

canParseXML
^^^^^^^^^^^

.. java:method:: @Override protected boolean canParseXML() throws ParserException, XMLNotReadableException
   :outertype: ParseEmersonUPS

