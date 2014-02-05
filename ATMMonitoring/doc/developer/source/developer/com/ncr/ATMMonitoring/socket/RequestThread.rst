.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

.. java:import:: java.io PrintWriter

.. java:import:: java.net Socket

.. java:import:: java.net SocketTimeoutException

.. java:import:: java.net UnknownHostException

.. java:import:: java.util Set

.. java:import:: org.apache.commons.lang RandomStringUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: com.ncr ATMMonitoring.utils.Utils

RequestThread
=============

.. java:package:: com.ncr.ATMMonitoring.socket
   :noindex:

.. java:type:: public class RequestThread extends Thread

   The Class RequestThread. This class retrieves the data from a series of ATM's by their ip's.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
RequestThread
^^^^^^^^^^^^^

.. java:constructor:: public RequestThread(Set<String> ips, int agentPort, int timeOut, RequestThreadManager parent)
   :outertype: RequestThread

   Instantiates a new request thread.

   :param ips: the ips
   :param agentPort: the agent port
   :param timeOut: the response time out
   :param parent: the parent manager

Methods
-------
getIps
^^^^^^

.. java:method:: public Set<String> getIps()
   :outertype: RequestThread

   Gets the ips.

   :return: the ips

run
^^^

.. java:method:: public void run()
   :outertype: RequestThread

