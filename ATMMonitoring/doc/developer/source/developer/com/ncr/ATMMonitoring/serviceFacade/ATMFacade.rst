.. java:import:: java.io InputStream

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

.. java:import:: com.ncr ATMMonitoring.service.InstallationService

.. java:import:: com.ncr ATMMonitoring.service.ScheduledUpdateService

.. java:import:: com.ncr ATMMonitoring.service.TerminalConfigService

.. java:import:: com.ncr ATMMonitoring.service.TerminalModelService

.. java:import:: com.ncr ATMMonitoring.service.TerminalService

ATMFacade
=========

.. java:package:: com.ncr.ATMMonitoring.serviceFacade
   :noindex:

.. java:type:: public interface ATMFacade

   Service that is an implementation of the Facade pattern that provides a simplified interface for the interaction with the services :java:ref:`TerminalService`, :java:ref:`TerminalModelService`, :java:ref:`ScheduledUpdateService`, :java:ref:`TerminalConfigService` and :java:ref:`InstallationService`.<br> Holds all the operations related to the ATMs, such as scheduling updates and Cruds operations

   :author: Otto Abreu

Fields
------
ADD
^^^

.. java:field::  int ADD
   :outertype: ATMFacade

   constant that specify an add operation ADD = 1;

MONTHLY
^^^^^^^

.. java:field::  int MONTHLY
   :outertype: ATMFacade

   to define a search for monthly updates MONTHLY = 0;

ORDER_ASC
^^^^^^^^^

.. java:field::  String ORDER_ASC
   :outertype: ATMFacade

   indicate that the search will return the elements order in ascendent order

ORDER_DESC
^^^^^^^^^^

.. java:field::  String ORDER_DESC
   :outertype: ATMFacade

   indicate that the search will return the elements order in descendent order

UPDATE
^^^^^^

.. java:field::  int UPDATE
   :outertype: ATMFacade

   constant that specify an update operation UPDATE = 0;

WEEKLY
^^^^^^

.. java:field::  int WEEKLY
   :outertype: ATMFacade

   to define a search for weekly updates WEEKLY = 1;

Methods
-------
addATMByFile
^^^^^^^^^^^^

.. java:method::  void addATMByFile(InputStream file)
   :outertype: ATMFacade

   Adds the info of the ATM using the given :java:ref:`InputStream`<br> The file must be a valid JSON string used by the ATMs

   :param file: Inputstream

addATMMachine
^^^^^^^^^^^^^

.. java:method::  void addATMMachine(TerminalConfig terminalConfig)
   :outertype: ATMFacade

   Adds a physical ATM machine to the Database<br> *Note:* An ATM machine refers to the physical configuration of the ATM, such as memory, Hard drive, etc. see (:java:ref:`TerminalConfig`

   :param terminalConfig:

addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method::  void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ATMFacade

   Adds the given :java:ref:`ScheduledUpdate`

   :param scheduledUpdate: ScheduledUpdate to be added

addUpdateATM
^^^^^^^^^^^^

.. java:method::  void addUpdateATM(Terminal terminal, int operType)
   :outertype: ATMFacade

   Execute an add or update operation on the given :java:ref:`Terminal`<br> To execute an add operation please use :java:ref:`ATMFacade.ADD`, To update please use :java:ref:`ATMFacade.UPDATE` in the operType param

   :param terminal: Terminal to be updated or added
   :param operType: int that indicate if the given Terminal will be added or updated

addUpdateATMInstallation
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void addUpdateATMInstallation(Installation installation, int operType)
   :outertype: ATMFacade

   Execute an add or update operation on the given :java:ref:`Installation`<br> <br> To execute an add operation please use :java:ref:`ATMFacade.ADD`, To update please use :java:ref:`ATMFacade.UPDATE` in the operType param

   :param installation: Installation to be updated or added
   :param operType: int that indicate if the given Terminal will be added or updated

addUpdateATMModel
^^^^^^^^^^^^^^^^^

.. java:method::  void addUpdateATMModel(TerminalModel terminalModel, int operType)
   :outertype: ATMFacade

   Execute an add or update operation on the given :java:ref:`TerminalModel`<br> <br> To execute an add operation please use :java:ref:`ATMFacade.ADD`, To update please use :java:ref:`ATMFacade.UPDATE` in the operType param

   :param terminalModel: TerminalModel to be updated or added
   :param operType: int that indicate if the given Terminal will be added or updated

existScheduledUpdate
^^^^^^^^^^^^^^^^^^^^

.. java:method::  boolean existScheduledUpdate(int updateId)
   :outertype: ATMFacade

   Tells if exist in the Database a :java:ref:`ScheduledUpdate` with the given Id<br> if a :java:ref:`ScheduledUpdate` is found returns true, false otherwise

   :param updateId: int
   :return: boolean

getATM
^^^^^^

.. java:method::  Terminal getATM(int atmId, String serialNumber, String matricula, String ip, String macAddress)
   :outertype: ATMFacade

   Method that returns an ATM (:java:ref:`Terminal`) using the criteria given<br> ***Important*: ONLY ONE PARAMETER CAN BE USED OF atmId,serialNumber, matricula, ip AND macAdress , THIS MEANS ONLY ONE CAN NOT BE NULL, OTHERWISE WILL EXECUTE THE FIRST NOT NULL PARAM RECEIVED**<br> Examples of use:<br>

   * Search by terminals ID: getATM(atmId,null, null, null,null);
   * Search by serial number: getATM(null,serialNumber, null, null,null);
   * Search by matricula: getATM(null,null, matricula, null,null);
   * * Search by IP: getATM(null,null, null, ip,null);
   * Search by MAC Address: getATM(null,null, null, null,macAddress);

   :param atmId: int if not null will search based on the given list of ids
   :param serialNumber: String if not null will search based on the given serial number
   :param matricula: String if not null will search based on the given matricula
   :param ip: String if not null will search based on the given ip
   :param macAddress: String if not null will search based on the given Mac Address
   :return: Terminal

getATMInstallation
^^^^^^^^^^^^^^^^^^

.. java:method::  Installation getATMInstallation(int installationId)
   :outertype: ATMFacade

   Return the :java:ref:`Installation` that matches with the given id

   :param installationId: int
   :return: Installation

getATMMachine
^^^^^^^^^^^^^

.. java:method::  TerminalConfig getATMMachine(int atmId)
   :outertype: ATMFacade

   Return the :java:ref:`TerminalConfig` that matches with the given id

   :param atmId: int
   :return: TerminalConfig

listATM
^^^^^^^

.. java:method::  List<Terminal> listATM(List<BankCompany> banksCompanies, BankCompany bank, List<Integer> atmId, String sort, String order)
   :outertype: ATMFacade

   Method that returns a list of ATM (:java:ref:`Terminal`) using the criteria given<br> ***Important*: ONLY ONE PARAMETER CAN BE USED OF banksCompanies,bank AND atmId , THIS MEANS ONLY ONE CAN NOT BE NULL, OTHERWISE WILL EXECUTE THE FIRST NOT NULL PARAM RECEIVED**<br> Examples of use:<br>

   * Search by several Bank companies: listATM(banksCompanies,null, null,sort, order);
   * Search by ONE Bank company: listATM(null,bankCompany, null,sort, order);
   * Search by Terminal ID: listATM(null,null, ids,null, null);
   * Return all the Terminals: listATM(null,null, null,null, null);

    *Note:* the params sort and order only will affect the search by Bank Companies or by a single bank<br> To specify the param order please use: :java:ref:`ATMFacade.ORDER_ASC` for an ascendant order and :java:ref:`ATMFacade.ORDER_DESC` for descendant

   :param banksCompanies: List<BankCompany> if not null will search based on the given Bank companies
   :param bank: BankCompany if not null will search based on the given Bank
   :param atmId: if not null will search based on the given list of ids
   :param sort: String optional param used when listing by Banks, will be the value to sort the result
   :param order: String optional param used when listing by Banks. give the order, can be ascendant or descendant
   :return: List<Terminal>

listATMInstallations
^^^^^^^^^^^^^^^^^^^^

.. java:method::  List<Installation> listATMInstallations()
   :outertype: ATMFacade

   Returns all the installations of ATMs registered in the Database

   :return: List<Installation>

listATMMachines
^^^^^^^^^^^^^^^

.. java:method::  List<TerminalConfig> listATMMachines()
   :outertype: ATMFacade

   Returns a list with all the ATM machines in the Database<br> *Note:* An ATM machine refers to the physical configuration of the ATM, such as memory, Hard drive, etc. see (:java:ref:`TerminalConfig`

   :return: List<TerminalConfig>

listATMModels
^^^^^^^^^^^^^

.. java:method::  List<TerminalModel> listATMModels()
   :outertype: ATMFacade

   Returns all the models of ATMs registered in the Database

   :return: List<TerminalModel>

listATMModelsByManufacturer
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Map<String, List<TerminalModel>> listATMModelsByManufacturer()
   :outertype: ATMFacade

   Returns all the models of ATMs registered in the Database but organized by the manufacturer<br> The key of the returning map is the name of the manufacturer

   :return: Map<String,List<TerminalModel>

listScheduledUpdates
^^^^^^^^^^^^^^^^^^^^

.. java:method::  List<ScheduledUpdate> listScheduledUpdates(int updateType)
   :outertype: ATMFacade

   Returns a list with all the ScheduledUpdate that matches the given update type <br> To return a list with weekly updates please use :java:ref:`ATMFacade.WEEKLY`, To return a list with monthly updates please use :java:ref:`ATMFacade.MONTHLY`

   :param updateType: int indicate the type of update to fetch ( weekly or monthly)
   :return: List<ScheduledUpdate>

removeATMInstallation
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void removeATMInstallation(int installationId)
   :outertype: ATMFacade

   Removes the :java:ref:`Installation` that matches the given id

   :param installationId:

removeATMModel
^^^^^^^^^^^^^^

.. java:method::  void removeATMModel(int atmModelId)
   :outertype: ATMFacade

   Removes the :java:ref:`TerminalModel` that matches the given id

   :param atmModelId:

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void removeScheduledUpdate(int updateId)
   :outertype: ATMFacade

   Removes the :java:ref:`ScheduledUpdate` that matches the given id

   :param updateId:

