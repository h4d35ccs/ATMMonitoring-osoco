package com.ncr.ATMMonitoring.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import ncr.inventory.data.ATM;
import ncr.inventory.data.BaseBoard;
import ncr.inventory.data.Bios;
import ncr.inventory.data.CDROMDrive;
import ncr.inventory.data.ComputerSystem;
import ncr.inventory.data.DesktopMonitor;
import ncr.inventory.data.Device;
import ncr.inventory.data.DiskDrive;
import ncr.inventory.data.FloppyDrive;
import ncr.inventory.data.IExplorer;
import ncr.inventory.data.Keyboard;
import ncr.inventory.data.LogicalDisk;
import ncr.inventory.data.NetworkAdapterSetting;
import ncr.inventory.data.ParallelPort;
import ncr.inventory.data.PhysicalMemory;
import ncr.inventory.data.PointingDevice;
import ncr.inventory.data.Processor;
import ncr.inventory.data.Product;
import ncr.inventory.data.SCSIController;
import ncr.inventory.data.SerialPort;
import ncr.inventory.data.SoundDevice;
import ncr.inventory.data.SystemSlot;
import ncr.inventory.data.USBController;
import ncr.inventory.data.UsbHub;
import ncr.inventory.data.VideoController;
import ncr.inventory.data._1394Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.TerminalDAO;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.Hotfix;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;
import com.ncr.ATMMonitoring.snmp.SnmpWrongDataException;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("terminalService")
@Transactional
public class TerminalServiceImpl implements TerminalService {

    static private Logger logger = Logger.getLogger(TerminalServiceImpl.class
	    .getName());

    @Autowired
    private TerminalDAO terminalDAO;
    @Autowired
    private HardwareDeviceService hardwareDeviceService;
    @Autowired
    private FinancialDeviceService financialDeviceService;
    @Autowired
    private InternetExplorerService internetExplorerService;
    @Autowired
    private HotfixService hotfixService;
    @Autowired
    private SoftwareAggregateService softwareAggregateService;
    @Autowired
    private SoftwareService softwareService;
    @Autowired
    private OperatingSystemService operatingSystemService;

    @Override
    public void addTerminal(Terminal terminal) {
    	terminalDAO.addTerminal(terminal);
    }

    @Override
    public void updateTerminal(Terminal terminal) {
    	terminalDAO.updateTerminal(terminal);
    }

    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks) {
		return listTerminalsByBankCompanies(banks, null, null);
    }

    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String sort, String order) {
		return terminalDAO.listTerminalsByBankCompanies(banks, sort, order);
    }

    @Override
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank) {
	return terminalDAO.listTerminalsByBankCompany(bank);
    }

    @Override
    public List<Terminal> listTerminals() {
    	return terminalDAO.listTerminals();
    }

    @Override
    public Terminal getTerminal(Integer id) {
    	return terminalDAO.getTerminal(id);
    }

    @Override
    public Terminal loadTerminalBySerialNumber(String serialNumber) {
    	return terminalDAO.getTerminalBySerialNumber(serialNumber);
    }

    @Override
    public Terminal loadTerminalByIp(String ip) {
    	return terminalDAO.getTerminalByIp(ip);
    }

    @Override
    public Terminal loadTerminalByMac(String mac) {
    	return terminalDAO.getTerminalByMac(mac);
    }

    private void removeRelatedEntities(Terminal terminal) {
		Set<HardwareDevice> hwDevs = terminal.getHardwareDevices();
		for (HardwareDevice hw : hwDevs) {
		    hardwareDeviceService.removeHardwareDevice(hw.getId());
		}
		logger.debug("Deleted Hardware Devices for Terminal with IP "+ terminal.getIp());

		Set<FinancialDevice> financialDevs = terminal.getFinancialDevices();
		for (FinancialDevice fd : financialDevs) {
		    financialDeviceService.removeFinancialDevice(fd.getId());
		}
		logger.debug("Deleted Financial Devices for Terminal with IP "+ terminal.getIp());

		Set<Hotfix> hotfixes = terminal.getHotfixes();
		for (Hotfix hotfix : hotfixes) {
		    hotfixService.removeHotfix(hotfix.getId());
		}
		logger.debug("Deleted Hotfixes for Terminal with IP "+ terminal.getIp());
    }

    private void addNewEntities(Terminal terminal, ATM snmpTerminal) {

    	 logger.debug("Adding new Entities");

    	//********************************
    	//Hardware, Financial and Hotfixes
		terminal.setHardwareDevices(getHwDevs(terminal, snmpTerminal));
		terminal.setFinancialDevices(getFinancialDevs(terminal, snmpTerminal));
		terminal.setHotfixes(getHotfixes(terminal, snmpTerminal));

		//**********
		//Aggregates
		Set<SoftwareAggregate> swAggregates = getSwAggregates(snmpTerminal);
		Set<SoftwareAggregate> swAggregatesAux = new HashSet<SoftwareAggregate>();
		for (SoftwareAggregate swAggregate : swAggregates) {
		    SoftwareAggregate swAggregateAux = softwareAggregateService.getSoftwareAggregateByVersionName(
				    swAggregate.getMajorVersion(),
				    swAggregate.getMinorVersion(),
				    swAggregate.getBuildVersion(),
				    swAggregate.getRevisionVersion(),
				    swAggregate.getRemainingVersion(),
				    swAggregate.getName());
		    if (swAggregateAux != null) {
		    	swAggregatesAux.add(swAggregateAux);
		    } else {
		    	swAggregatesAux.add(swAggregate);
		    }
		}
		//terminal.setSoftwareAggregates(swAggregates);
		//Eva - 13/03/2013 - Updates should be made by using swAggregatesAux that contains the current data
		terminal.setSoftwareAggregates(swAggregatesAux);

		//*****************
		//Internet Explorer
		Set<InternetExplorer> ies = getInternetExplorers(snmpTerminal);
		Set<InternetExplorer> iesAux = new HashSet<InternetExplorer>();
		for (InternetExplorer ie : ies) {
		    InternetExplorer ieAux = internetExplorerService.getInternetExplorerByVersion(ie.getMajorVersion(),
				    ie.getMinorVersion(), ie.getBuildVersion(),
				    ie.getRevisionVersion(), ie.getRemainingVersion());
		    if (ieAux != null) {
		    	iesAux.add(ieAux);
		    } else {
		    	iesAux.add(ie);
		    }
		}
		terminal.setInternetExplorers(iesAux);

		//********************************************
		//Terminal Config: Software + Operating System
		TerminalConfig newConfig = new TerminalConfig();

		Set<Software> sws = getSoftware(snmpTerminal);
		Set<Software> swsAux = new HashSet<Software>();
		for (Software sw : sws) {
		    Software swAux = softwareService.getSoftwareByIdentifyingNumber(sw.getIdentifyingNumber());
		    if (swAux != null) {
		    	swsAux.add(swAux);
		    } else {
		    	swsAux.add(sw);
		    }
		}
		newConfig.setSoftware(swsAux);

		Set<OperatingSystem> oss = getOperatingSystems(snmpTerminal);
		Set<OperatingSystem> ossAux = new HashSet<OperatingSystem>();
		for (OperatingSystem os : oss) {
		    OperatingSystem osAux = operatingSystemService.getOperatingSystemBySerialNumber(os.getSerialNumber());
		    if (osAux != null) {
		    	ossAux.add(osAux);
		    } else {
		    	ossAux.add(os);
		    }
		}
		newConfig.setOperatingSystems(ossAux);

		if ((terminal.getCurrentConfig() == null) || (!terminal.getCurrentConfig().equals(newConfig))) {
		    terminal.getConfigs().add(newConfig);
		    newConfig.setTerminal(terminal);
		    logger.debug("Adding new Software Config to Terminal with IP " + terminal.getIp());
		}
    }

    @Override
    public void persistSnmpTerminal(ATM snmpTerminal) {
		try {
		    Terminal terminal = new Terminal(snmpTerminal);
		    Terminal dbTerminal = terminalDAO.getTerminalByMac(terminal.getMac());
		    if (dbTerminal != null) {
				overwriteFields(dbTerminal, terminal);
				terminal = dbTerminal;
				terminalDAO.updateTerminal(terminal);
				logger.debug("Updated Terminal by SNMP with IP "+ dbTerminal.getIp());
				removeRelatedEntities(terminal);
		    } else {
				terminalDAO.addTerminal(terminal);
				logger.debug("Created Terminal by SNMP with IP "
					+ terminal.getIp());
		    }
		    addNewEntities(terminal, snmpTerminal);
		    terminalDAO.updateTerminal(terminal);
		    logger.debug("Created all new devices and software for Terminal with IP" + terminal.getIp());
		}
		catch (SnmpWrongDataException e) {
		    logger.error("Couldn't persist ATM with IP " + snmpTerminal.getIp() + "due to error: ", e);
		}
    }

    private void overwriteFields(Terminal terminal, Terminal newTerminal) {
		terminal.setGeographicAddress(newTerminal.getGeographicAddress());
		terminal.setTerminalType(newTerminal.getTerminalType());
		terminal.setTerminalVendor(newTerminal.getTerminalVendor());
		terminal.setFrontReplenish(newTerminal.getFrontReplenish());
		terminal.setManufacturingSite(newTerminal.getManufacturingSite());
		terminal.setModel(newTerminal.getModel());
		terminal.setProductClass(newTerminal.getProductClass());
		terminal.setProductClassDescription(newTerminal.getProductClassDescription());
		terminal.setSerialNumber(newTerminal.getSerialNumber());
		terminal.setTracerNumber(newTerminal.getTracerNumber());
    }

    private Set<SoftwareAggregate> getSwAggregates(ATM snmpTerminal) {
		Set<SoftwareAggregate> swAggregates = new HashSet<SoftwareAggregate>();
		Vector vector = snmpTerminal.getmPackage();
		if (vector != null) {
		    for (ncr.inventory.data.Package item : (Vector<ncr.inventory.data.Package>) vector) {
		    	SoftwareAggregate swAggregate = new SoftwareAggregate(item);
		    	swAggregates.add(swAggregate);
		    	logger.debug("Added SW Aggregate to the list");
		    }
		}
		return swAggregates;
    }

    private Set<InternetExplorer> getInternetExplorers(ATM snmpTerminal) {
		Set<InternetExplorer> internetExplorers = new HashSet<InternetExplorer>();
		Vector vector = snmpTerminal.getmIExplorer();
		if (vector != null) {
		    for (IExplorer item : (Vector<IExplorer>) vector) {
		    	InternetExplorer ie = new InternetExplorer(item);
		    	internetExplorers.add(ie);
		    }
		}
		return internetExplorers;
    }

    private Set<Software> getSoftware(ATM snmpTerminal) {
		Set<Software> software = new HashSet<Software>();
		Vector vector = snmpTerminal.getmProduct();
		if (vector != null) {
		    for (Product item : (Vector<Product>) vector) {
		    	Software sw = new Software(item);
		    	software.add(sw);
		    }
		}
		return software;
    }

    private Set<OperatingSystem> getOperatingSystems(ATM snmpTerminal) {
		Set<OperatingSystem> oss = new HashSet<OperatingSystem>();
		Vector vector = snmpTerminal.getmOperatingSystem();
		if (vector != null) {
		    for (ncr.inventory.data.OperatingSystem item : (Vector<ncr.inventory.data.OperatingSystem>) vector) {
		    	OperatingSystem os = new OperatingSystem(item);
		    	oss.add(os);
		    }
		}
		return oss;
    }

    private Set<FinancialDevice> getFinancialDevs(Terminal terminal,
	    ATM snmpTerminal) {
		Set<FinancialDevice> finDevs = new HashSet<FinancialDevice>();
		Vector vector = snmpTerminal.getmDevice();
		if (vector != null) {
		    for (Device item : (Vector<Device>) vector) {
				FinancialDevice finDev = new FinancialDevice(item);
				finDev.setTerminal(terminal);
				finDevs.add(finDev);
		    }
		}
		return finDevs;
    }

    private Set<Hotfix> getHotfixes(Terminal terminal, ATM snmpTerminal) {
		Set<Hotfix> hotfixes = new HashSet<Hotfix>();
		Vector vector = snmpTerminal.getmHotfix();
		if (vector != null) {
		    for (ncr.inventory.data.Hotfix item : (Vector<ncr.inventory.data.Hotfix>) vector) {
				Hotfix hotfix = new Hotfix(item);
				hotfix.setTerminal(terminal);
				hotfixes.add(hotfix);
		    }
		}
		return hotfixes;
    }

    private Set<HardwareDevice> getHwDevs(Terminal terminal, ATM snmpTerminal) {

		Set<HardwareDevice> hwDevs = new HashSet<HardwareDevice>();
		Vector vector = snmpTerminal.getM1394Controller();
		if (vector != null) {
		    for (_1394Controller item : (Vector<_1394Controller>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmBaseBoard();
		if (vector != null) {
		    for (BaseBoard item : (Vector<BaseBoard>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmBios();
		if (vector != null) {
		    for (Bios item : (Vector<Bios>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmCDROMDrive();
		if (vector != null) {
		    for (CDROMDrive item : (Vector<CDROMDrive>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmComputerSystem();
		if (vector != null) {
		    for (ComputerSystem item : (Vector<ComputerSystem>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmDesktopMonitor();
		if (vector != null) {
		    for (DesktopMonitor item : (Vector<DesktopMonitor>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmDiskDrive();
		if (vector != null) {
		    for (DiskDrive item : (Vector<DiskDrive>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmFloppyDrive();
		if (vector != null) {
		    for (FloppyDrive item : (Vector<FloppyDrive>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmKeyboard();
		if (vector != null) {
		    for (Keyboard item : (Vector<Keyboard>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmLogicalDisk();
		if (vector != null) {
		    for (LogicalDisk item : (Vector<LogicalDisk>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmNetworkAdapterSetting();
		if (vector != null) {
		    for (NetworkAdapterSetting item : (Vector<NetworkAdapterSetting>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmParallelPort();
		if (vector != null) {
		    for (ParallelPort item : (Vector<ParallelPort>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmPhysicalMemory();
		if (vector != null) {
		    for (PhysicalMemory item : (Vector<PhysicalMemory>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmPointingDevice();
		if (vector != null) {
		    for (PointingDevice item : (Vector<PointingDevice>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmProcessor();
		if (vector != null) {
		    for (Processor item : (Vector<Processor>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmSCSIController();
		if (vector != null) {
		    for (SCSIController item : (Vector<SCSIController>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmSerialPort();
		if (vector != null) {
		    for (SerialPort item : (Vector<SerialPort>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmSoundDevice();
		if (vector != null) {
		    for (SoundDevice item : (Vector<SoundDevice>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmSystemSlot();
		if (vector != null) {
		    for (SystemSlot item : (Vector<SystemSlot>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmUSBController();
		if (vector != null) {
		    for (USBController item : (Vector<USBController>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmUsbHub();
		if (vector != null) {
		    for (UsbHub item : (Vector<UsbHub>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		vector = snmpTerminal.getmVideoController();
		if (vector != null) {
		    for (VideoController item : (Vector<VideoController>) vector) {
				HardwareDevice hwDev = new HardwareDevice(item);
				hwDev.setTerminal(terminal);
				hwDevs.add(hwDev);
		    }
		}
		return hwDevs;
    }
}
