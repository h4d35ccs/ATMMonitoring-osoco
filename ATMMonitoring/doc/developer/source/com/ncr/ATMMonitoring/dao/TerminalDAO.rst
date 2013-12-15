.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.hibernate.type Type

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

TerminalDAO
===========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface TerminalDAO

   The Interface TerminalDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminal
^^^^^^^^^^^

.. java:method:: public void addTerminal(Terminal terminal)
   :outertype: TerminalDAO

   Adds the terminal.

   :param terminal: the terminal

executeQuery
^^^^^^^^^^^^

.. java:method:: public List executeQuery(List<Object> values, List<Type> types, String hql)
   :outertype: TerminalDAO

   Execute query.

   :param values: the values
   :param types: the types
   :param hql: the hql
   :return: the list

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal(Integer id)
   :outertype: TerminalDAO

   Gets the terminal.

   :param id: the id
   :return: the terminal

getTerminalByIp
^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalByIp(String ip)
   :outertype: TerminalDAO

   Gets the terminal by ip.

   :param ip: the ip
   :return: the terminal by ip

getTerminalByMac
^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalByMac(String mac)
   :outertype: TerminalDAO

   Gets the terminal by mac.

   :param mac: the mac
   :return: the terminal by mac

getTerminalByMatricula
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalByMatricula(Long matricula)
   :outertype: TerminalDAO

   Gets the terminal by matricula.

   :param matricula: the matricula
   :return: the terminal by matricula

getTerminalBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalBySerialNumber(String serialNumber)
   :outertype: TerminalDAO

   Gets the terminal by serial number.

   :param serialNumber: the serial number
   :return: the terminal by serial number

getTerminalBySimilarity
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalBySimilarity(ATMDataStorePojo terminal)
   :outertype: TerminalDAO

   Gets the terminal by similarity.

   :param terminal: the terminal
   :return: the terminal by similarity

getTerminalsByHQL
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> getTerminalsByHQL(List<Object> values, List<Type> types, String hql)
   :outertype: TerminalDAO

   Gets the terminals by hql.

   :param values: the values
   :param types: the types
   :param hql: the hql
   :return: the terminals by hql

getTerminalsByHQL
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> getTerminalsByHQL(List<Object> values, List<Type> types, String hql, String sort, String order)
   :outertype: TerminalDAO

   Gets the terminals by hql.

   :param values: the values
   :param types: the types
   :param hql: the hql
   :param sort: the sort
   :param order: the order
   :return: the terminals by hql

listTerminals
^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminals()
   :outertype: TerminalDAO

   List terminals.

   :return: the list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank)
   :outertype: TerminalDAO

   List terminals by bank companies.

   :param bank: the bank
   :return: the list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank, String sort, String order)
   :outertype: TerminalDAO

   List terminals by bank companies.

   :param bank: the bank
   :param sort: the sort
   :param order: the order
   :return: the list

listTerminalsByBankCompany
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompany(BankCompany bank)
   :outertype: TerminalDAO

   List terminals by bank company.

   :param bank: the bank
   :return: the list

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: public void updateTerminal(Terminal terminal)
   :outertype: TerminalDAO

   Update terminal.

   :param terminal: the terminal

