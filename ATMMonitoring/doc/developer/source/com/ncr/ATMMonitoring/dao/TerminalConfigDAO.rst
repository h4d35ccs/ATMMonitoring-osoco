.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

TerminalConfigDAO
=================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface TerminalConfigDAO

   The Interface TerminalConfigDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: public void addTerminalConfig(TerminalConfig terminalConfig)
   :outertype: TerminalConfigDAO

   Adds the terminal config.

   :param terminalConfig: the terminal config

getTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalConfig getTerminalConfig(Integer id)
   :outertype: TerminalConfigDAO

   Gets the terminal config.

   :param id: the id
   :return: the terminal config

listTerminalConfig
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<TerminalConfig> listTerminalConfig()
   :outertype: TerminalConfigDAO

   List terminal config.

   :return: the list

