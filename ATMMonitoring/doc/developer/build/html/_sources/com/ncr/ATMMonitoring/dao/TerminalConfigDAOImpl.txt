.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

TerminalConfigDAOImpl
=====================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class TerminalConfigDAOImpl implements TerminalConfigDAO

   The Class TerminalConfigDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addTerminalConfig(TerminalConfig terminalConfig)
   :outertype: TerminalConfigDAOImpl

getTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalConfig getTerminalConfig(Integer id)
   :outertype: TerminalConfigDAOImpl

listTerminalConfig
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalConfig> listTerminalConfig()
   :outertype: TerminalConfigDAOImpl

