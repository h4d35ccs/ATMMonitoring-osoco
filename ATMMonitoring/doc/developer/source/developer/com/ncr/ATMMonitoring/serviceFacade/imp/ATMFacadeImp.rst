.. java:import:: java.io InputStream

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.springframework.stereotype Service

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

.. java:import:: com.ncr ATMMonitoring.serviceFacade.ATMFacade

ATMFacadeImp
============

.. java:package:: com.ncr.ATMMonitoring.serviceFacade.imp
   :noindex:

.. java:type:: @Service public class ATMFacadeImp implements ATMFacade

   :author: Otto Abreu

Constructors
------------
ATMFacadeImp
^^^^^^^^^^^^

.. java:constructor:: public ATMFacadeImp()
   :outertype: ATMFacadeImp

Methods
-------
addATMByFile
^^^^^^^^^^^^

.. java:method:: @Override public void addATMByFile(InputStream file)
   :outertype: ATMFacadeImp

addATMMachine
^^^^^^^^^^^^^

.. java:method:: @Override public void addATMMachine(TerminalConfig terminalConfig)
   :outertype: ATMFacadeImp

addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ATMFacadeImp

addUpdateATM
^^^^^^^^^^^^

.. java:method:: @Override public void addUpdateATM(Terminal terminal, int operType)
   :outertype: ATMFacadeImp

addUpdateATMInstallation
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addUpdateATMInstallation(Installation installation, int operType)
   :outertype: ATMFacadeImp

addUpdateATMModel
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addUpdateATMModel(TerminalModel terminalModel, int operType)
   :outertype: ATMFacadeImp

existScheduledUpdate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean existScheduledUpdate(int updateId)
   :outertype: ATMFacadeImp

getATM
^^^^^^

.. java:method:: @Override public Terminal getATM(int atmId, String serialNumber, String matricula, String ip, String macAddress)
   :outertype: ATMFacadeImp

getATMInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Installation getATMInstallation(int installationId)
   :outertype: ATMFacadeImp

getATMMachine
^^^^^^^^^^^^^

.. java:method:: @Override public TerminalConfig getATMMachine(int atmId)
   :outertype: ATMFacadeImp

listATM
^^^^^^^

.. java:method:: @Override public List<Terminal> listATM(List<BankCompany> banksCompanies, BankCompany bank, List<Integer> atmId, String sort, String order)
   :outertype: ATMFacadeImp

listATMInstallations
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Installation> listATMInstallations()
   :outertype: ATMFacadeImp

listATMMachines
^^^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalConfig> listATMMachines()
   :outertype: ATMFacadeImp

listATMModels
^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalModel> listATMModels()
   :outertype: ATMFacadeImp

listATMModelsByManufacturer
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<String, List<TerminalModel>> listATMModelsByManufacturer()
   :outertype: ATMFacadeImp

listScheduledUpdates
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listScheduledUpdates(int updateType)
   :outertype: ATMFacadeImp

removeATMInstallation
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeATMInstallation(int installationId)
   :outertype: ATMFacadeImp

removeATMModel
^^^^^^^^^^^^^^

.. java:method:: @Override public void removeATMModel(int atmModelId)
   :outertype: ATMFacadeImp

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeScheduledUpdate(int updateId)
   :outertype: ATMFacadeImp

