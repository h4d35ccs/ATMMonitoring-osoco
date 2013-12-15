.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.springframework.web.multipart.commons CommonsMultipartFile

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

TerminalService
===============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface TerminalService

   The Interface TerminalService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminal
^^^^^^^^^^^

.. java:method:: public void addTerminal(Terminal terminal)
   :outertype: TerminalService

   Adds the terminal.

   :param terminal: the terminal

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal(Integer id)
   :outertype: TerminalService

   Gets the terminal.

   :param id: the id
   :return: the terminal

importJsonTerminal
^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean importJsonTerminal(CommonsMultipartFile jsonFile)
   :outertype: TerminalService

   Import json terminal.

   :param jsonFile: the json file
   :return: true, if successful

listTerminals
^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminals()
   :outertype: TerminalService

   List terminals.

   :return: the list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks)
   :outertype: TerminalService

   List terminals by bank companies.

   :param banks: the banks
   :return: the list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String sort, String order)
   :outertype: TerminalService

   List terminals by bank companies.

   :param banks: the banks
   :param sort: the sort
   :param order: the order
   :return: the list

listTerminalsByBankCompany
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompany(BankCompany bank)
   :outertype: TerminalService

   List terminals by bank company.

   :param bank: the bank
   :return: the list

loadTerminalByIp
^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalByIp(String ip)
   :outertype: TerminalService

   Load terminal by ip.

   :param ip: the ip
   :return: the terminal

loadTerminalByMac
^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalByMac(String mac)
   :outertype: TerminalService

   Load terminal by mac.

   :param mac: the mac
   :return: the terminal

loadTerminalByMatricula
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalByMatricula(Long matricula)
   :outertype: TerminalService

   Load terminal by matricula.

   :param matricula: the matricula
   :return: the terminal

loadTerminalBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalBySerialNumber(String serialNumber)
   :outertype: TerminalService

   Load terminal by serial number.

   :param serialNumber: the serial number
   :return: the terminal

persistDataStoreTerminal
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal)
   :outertype: TerminalService

   Persist data store terminal.

   :param dataStoreTerminal: the data store terminal
   :return: the terminal

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: public void updateTerminal(Terminal terminal)
   :outertype: TerminalService

   Update terminal.

   :param terminal: the terminal

