.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence JoinTable

.. java:import:: javax.persistence ManyToMany

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.socket.ATMWrongDataException

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

.. java:import:: com.ncr.agent.baseData.vendor.utils FinancialTerminalPojo

Terminal
========

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Terminal

   The Terminal Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
Terminal
^^^^^^^^

.. java:constructor:: public Terminal()
   :outertype: Terminal

   Instantiates a new terminal.

Terminal
^^^^^^^^

.. java:constructor:: public Terminal(ATMDataStorePojo terminal) throws ATMWrongDataException
   :outertype: Terminal

   Instantiates a new terminal with the given terminal data from the agent.

   :param terminal: the terminal

Methods
-------
getBank
^^^^^^^

.. java:method:: public String getBank()
   :outertype: Terminal

   Gets the bank.

   :return: the bank

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public BankCompany getBankCompany()
   :outertype: Terminal

   Gets the bank company.

   :return: the bankCompany

getBaseBoards
^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getBaseBoards()
   :outertype: Terminal

   Gets the base boards.

   :return: the hardwareDevices

getBios
^^^^^^^

.. java:method:: public Set<HardwareDevice> getBios()
   :outertype: Terminal

   Gets the bios.

   :return: the hardwareDevices

getBranch
^^^^^^^^^

.. java:method:: public String getBranch()
   :outertype: Terminal

   Gets the branch.

   :return: the branch

getCdromDrives
^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getCdromDrives()
   :outertype: Terminal

   Gets the cdrom drives.

   :return: the hardwareDevices

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: Terminal

   Gets the comboboxes data for the query designer.

   :return: the comboboxes data

getComputerSystems
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getComputerSystems()
   :outertype: Terminal

   Gets the computer systems.

   :return: the hardwareDevices

getConfigs
^^^^^^^^^^

.. java:method:: public Set<TerminalConfig> getConfigs()
   :outertype: Terminal

   Gets the configs.

   :return: the configs

getControllers1394
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getControllers1394()
   :outertype: Terminal

   Gets the controllers1394.

   :return: the hardwareDevices

getCsvDescription
^^^^^^^^^^^^^^^^^

.. java:method:: public String getCsvDescription()
   :outertype: Terminal

   Gets a recap of the terminal data in csv format.

getCsvHeader
^^^^^^^^^^^^

.. java:method:: public static String getCsvHeader()
   :outertype: Terminal

   Gets the csv header for exporting terminals' data.

   :return: the csv header

getCurrentConfig
^^^^^^^^^^^^^^^^

.. java:method:: public TerminalConfig getCurrentConfig()
   :outertype: Terminal

   Gets the currently valid config.

   :return: the current config

getDesktopMonitors
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getDesktopMonitors()
   :outertype: Terminal

   Gets the desktop monitors.

   :return: the hardwareDevices

getDiskDrives
^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getDiskDrives()
   :outertype: Terminal

   Gets the disk drives.

   :return: the hardwareDevices

getFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<FinancialDevice> getFinancialDevices()
   :outertype: Terminal

   Gets the financial devices.

   :return: the financialDevices

getFloppyDrives
^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getFloppyDrives()
   :outertype: Terminal

   Gets the floppy drives.

   :return: the hardwareDevices

getFrontReplenish
^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getFrontReplenish()
   :outertype: Terminal

   Gets the front replenish.

   :return: the frontReplenish

getGeographicAddress
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getGeographicAddress()
   :outertype: Terminal

   Gets the geographic address.

   :return: the geographicAddress

getHardwareDevices
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getHardwareDevices()
   :outertype: Terminal

   Gets the hardware devices.

   :return: the hardwareDevices

getHotfixes
^^^^^^^^^^^

.. java:method:: public Set<Hotfix> getHotfixes()
   :outertype: Terminal

   Gets the hotfixes.

   :return: the hotfixes

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Terminal

   Gets the id.

   :return: the id

getInstallation
^^^^^^^^^^^^^^^

.. java:method:: public Installation getInstallation()
   :outertype: Terminal

   Gets the installation.

   :return: the installation

getInternetExplorers
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<InternetExplorer> getInternetExplorers()
   :outertype: Terminal

   Gets the internet explorers.

   :return: the internetExplorers

getIp
^^^^^

.. java:method:: public String getIp()
   :outertype: Terminal

   Gets the ip.

   :return: the ip

getKeyboards
^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getKeyboards()
   :outertype: Terminal

   Gets the keyboards.

   :return: the hardwareDevices

getLogicalDisks
^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getLogicalDisks()
   :outertype: Terminal

   Gets the logical disks.

   :return: the hardwareDevices

getMac
^^^^^^

.. java:method:: public String getMac()
   :outertype: Terminal

   Gets the mac.

   :return: the mac

getManufacturingSite
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getManufacturingSite()
   :outertype: Terminal

   Gets the manufacturing site.

   :return: the manufacturingSite

getMatricula
^^^^^^^^^^^^

.. java:method:: public Long getMatricula()
   :outertype: Terminal

   Gets the matricula.

   :return: the matricula

getNetworkAdapters
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getNetworkAdapters()
   :outertype: Terminal

   Gets the network adapters.

   :return: the hardwareDevices

getParallelPorts
^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getParallelPorts()
   :outertype: Terminal

   Gets the parallel ports.

   :return: the hardwareDevices

getPhysicalMemories
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getPhysicalMemories()
   :outertype: Terminal

   Gets the physical memories.

   :return: the hardwareDevices

getPointingDevices
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getPointingDevices()
   :outertype: Terminal

   Gets the pointing devices.

   :return: the hardwareDevices

getProcessors
^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getProcessors()
   :outertype: Terminal

   Gets the processors.

   :return: the hardwareDevices

getProductClassDescription
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getProductClassDescription()
   :outertype: Terminal

   Gets the product class description.

   :return: the productClassDescription

getScsiControllers
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getScsiControllers()
   :outertype: Terminal

   Gets the scsi controllers.

   :return: the hardwareDevices

getSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getSerialNumber()
   :outertype: Terminal

   Gets the serial number.

   :return: the serialNumber

getSerialPorts
^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getSerialPorts()
   :outertype: Terminal

   Gets the serial ports.

   :return: the hardwareDevices

getSoftwareAggregates
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<SoftwareAggregate> getSoftwareAggregates()
   :outertype: Terminal

   Gets the software aggregates.

   :return: the softwareAggregates

getSoundDevices
^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getSoundDevices()
   :outertype: Terminal

   Gets the sound devices.

   :return: the hardwareDevices

getSystemSlots
^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getSystemSlots()
   :outertype: Terminal

   Gets the system slots.

   :return: the hardwareDevices

getTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModel()
   :outertype: Terminal

   Gets the terminal model.

   :return: the terminal model

getTerminalType
^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalType()
   :outertype: Terminal

   Gets the terminal type.

   :return: the terminalType

getTerminalVendor
^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalVendor()
   :outertype: Terminal

   Gets the terminal vendor.

   :return: the terminalVendor

getTracerNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getTracerNumber()
   :outertype: Terminal

   Gets the tracer number.

   :return: the tracerNumber

getUsbControllers
^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getUsbControllers()
   :outertype: Terminal

   Gets the usb controllers.

   :return: the hardwareDevices

getVideoControllers
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getVideoControllers()
   :outertype: Terminal

   Gets the video controllers.

   :return: the hardwareDevices

replaceTerminalData
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void replaceTerminalData(Terminal terminal)
   :outertype: Terminal

   Replaces most terminal fields with the data from another Terminal entity.

   :param terminal: the terminal with its data rewritten

replaceTerminalDataWoVoidValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void replaceTerminalDataWoVoidValues(Terminal terminal)
   :outertype: Terminal

   Replaces most terminal fields with the data from another Terminal entity ignoring null or void values so they don't overwrite the original values.

   :param terminal: the terminal with its data rewritten

setBank
^^^^^^^

.. java:method:: public void setBank(String bank)
   :outertype: Terminal

   Sets the bank.

   :param bank: the bank to set

setBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void setBankCompany(BankCompany bankCompany)
   :outertype: Terminal

   Sets the bank company.

   :param bankCompany: the bankCompany to set

setBranch
^^^^^^^^^

.. java:method:: public void setBranch(String branch)
   :outertype: Terminal

   Sets the branch.

   :param branch: the branch to set

setConfigs
^^^^^^^^^^

.. java:method:: public void setConfigs(Set<TerminalConfig> configs)
   :outertype: Terminal

   Sets the configs.

   :param configs: the configs to set

setFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDevices(Set<FinancialDevice> financialDevices)
   :outertype: Terminal

   Sets the financial devices.

   :param financialDevices: the financialDevices to set

setFrontReplenish
^^^^^^^^^^^^^^^^^

.. java:method:: public void setFrontReplenish(Boolean frontReplenish)
   :outertype: Terminal

   Sets the front replenish.

   :param frontReplenish: the frontReplenish to set

setGeographicAddress
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setGeographicAddress(String geographicAddress)
   :outertype: Terminal

   Sets the geographic address.

   :param geographicAddress: the geographicAddress to set

setHardwareDevices
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDevices(Set<HardwareDevice> hardwareDevices)
   :outertype: Terminal

   Sets the hardware devices.

   :param hardwareDevices: the hardwareDevices to set

setHotfixes
^^^^^^^^^^^

.. java:method:: public void setHotfixes(Set<Hotfix> hotfixes)
   :outertype: Terminal

   Sets the hotfixes.

   :param hotfixes: the hotfixes to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Terminal

   Sets the id.

   :param id: the id to set

setInstallation
^^^^^^^^^^^^^^^

.. java:method:: public void setInstallation(Installation installation)
   :outertype: Terminal

   Sets the installation.

   :param installation: the new installation

setInternetExplorers
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorers(Set<InternetExplorer> internetExplorers)
   :outertype: Terminal

   Sets the internet explorers.

   :param internetExplorers: the internetExplorers to set

setIp
^^^^^

.. java:method:: public void setIp(String ip)
   :outertype: Terminal

   Sets the ip.

   :param ip: the ip to set

setMac
^^^^^^

.. java:method:: public void setMac(String mac)
   :outertype: Terminal

   Sets the mac.

   :param mac: the mac to set

setManufacturingSite
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setManufacturingSite(String manufacturingSite)
   :outertype: Terminal

   Sets the manufacturing site.

   :param manufacturingSite: the manufacturingSite to set

setMatricula
^^^^^^^^^^^^

.. java:method:: public void setMatricula(Long matricula)
   :outertype: Terminal

   Sets the matricula.

   :param matricula: the new matricula

setProductClassDescription
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setProductClassDescription(String productClassDescription)
   :outertype: Terminal

   Sets the product class description.

   :param productClassDescription: the productClassDescription to set

setSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setSerialNumber(String serialNumber)
   :outertype: Terminal

   Sets the serial number.

   :param serialNumber: the serialNumber to set

setSoftwareAggregates
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareAggregates(Set<SoftwareAggregate> softwareAggregates)
   :outertype: Terminal

   Sets the software aggregates.

   :param softwareAggregates: the softwareAggregates to set

setTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalModel(TerminalModel terminalModel)
   :outertype: Terminal

   Sets the terminal model.

   :param terminalModel: the new terminal model

setTerminalType
^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalType(String terminalType)
   :outertype: Terminal

   Sets the terminal type.

   :param terminalType: the terminalType to set

setTerminalVendor
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalVendor(String terminalVendor)
   :outertype: Terminal

   Sets the terminal vendor.

   :param terminalVendor: the terminalVendor to set

setTracerNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setTracerNumber(String tracerNumber)
   :outertype: Terminal

   Sets the tracer number.

   :param tracerNumber: the tracerNumber to set

