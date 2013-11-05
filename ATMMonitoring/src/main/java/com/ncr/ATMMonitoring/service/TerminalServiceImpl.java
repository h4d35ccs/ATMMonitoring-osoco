package com.ncr.ATMMonitoring.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
import com.ncr.ATMMonitoring.pojo.TerminalModel;
import com.ncr.ATMMonitoring.pojo.XfsComponent;
import com.ncr.ATMMonitoring.snmp.SnmpWrongDataException;
import com.ncr.ATMMonitoring.socket.ATMWrongDataException;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.agent.baseData.os.module.BaseBoardPojo;
import com.ncr.agent.baseData.os.module.BiosPojo;
import com.ncr.agent.baseData.os.module.CDROMDrivePojo;
import com.ncr.agent.baseData.os.module.ComputerSystemPojo;
import com.ncr.agent.baseData.os.module.DesktopMonitorPojo;
import com.ncr.agent.baseData.os.module.DiskDrivePojo;
import com.ncr.agent.baseData.os.module.FloppyDrivePojo;
import com.ncr.agent.baseData.os.module.HotfixPojo;
import com.ncr.agent.baseData.os.module.IExplorerPojo;
import com.ncr.agent.baseData.os.module.KeyboardPojo;
import com.ncr.agent.baseData.os.module.LogicalDiskPojo;
import com.ncr.agent.baseData.os.module.NetworkAdapterSettingPojo;
import com.ncr.agent.baseData.os.module.OperatingSystemPojo;
import com.ncr.agent.baseData.os.module.ParallelPortPojo;
import com.ncr.agent.baseData.os.module.PhysicalMemoryPojo;
import com.ncr.agent.baseData.os.module.PointingDevicePojo;
import com.ncr.agent.baseData.os.module.ProcessorPojo;
import com.ncr.agent.baseData.os.module.ProductPojo;
import com.ncr.agent.baseData.os.module.SCSIControllerPojo;
import com.ncr.agent.baseData.os.module.SerialPortPojo;
import com.ncr.agent.baseData.os.module.SoundDevicePojo;
import com.ncr.agent.baseData.os.module.SystemSlotPojo;
import com.ncr.agent.baseData.os.module.USBControllerPojo;
import com.ncr.agent.baseData.os.module.UsbHubPojo;
import com.ncr.agent.baseData.os.module.VideoControllerPojo;
import com.ncr.agent.baseData.os.module._1394ControllerPojo;
import com.ncr.agent.baseData.standard.xfs.module.ALM;
import com.ncr.agent.baseData.standard.xfs.module.BCR;
import com.ncr.agent.baseData.standard.xfs.module.CAM;
import com.ncr.agent.baseData.standard.xfs.module.CDM;
import com.ncr.agent.baseData.standard.xfs.module.CEU;
import com.ncr.agent.baseData.standard.xfs.module.CHK;
import com.ncr.agent.baseData.standard.xfs.module.CIM;
import com.ncr.agent.baseData.standard.xfs.module.CRD;
import com.ncr.agent.baseData.standard.xfs.module.DEP;
import com.ncr.agent.baseData.standard.xfs.module.IDC;
import com.ncr.agent.baseData.standard.xfs.module.IPM;
import com.ncr.agent.baseData.standard.xfs.module.PIN;
import com.ncr.agent.baseData.standard.xfs.module.PTR;
import com.ncr.agent.baseData.standard.xfs.module.SIU;
import com.ncr.agent.baseData.standard.xfs.module.TTU;
import com.ncr.agent.baseData.standard.xfs.module.VDM;
import com.ncr.agent.baseData.vendor.utils.FinancialDevicePojo;
import com.ncr.agent.baseData.vendor.utils.FinancialPackagePojo;
import com.ncr.agent.baseData.vendor.utils.FinancialTerminalPojo;

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
    @Autowired
    private TerminalModelService terminalModelService;

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
	return terminalDAO.listTerminalsByBankCompanies(banks);
    }

    @Override
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank) {
	return terminalDAO.listTerminalsByBankCompany(bank);
    }

    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks,
	    String sort, String order) {
	return terminalDAO.listTerminalsByBankCompanies(banks, sort, order);
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

    @Override
    public boolean importJsonTerminal(CommonsMultipartFile jsonFile) {
	try {
	    InputStream is = jsonFile.getInputStream();
	    String json = IOUtils.toString(is, "ISO-8859-1");
	    // logger.debug("Json read: " + json);
	    ATMDataStorePojo data = ATMDataStorePojo.fromJson(json);
	    if (data == null) {
		logger.error("Invalid json file for importing terminal...");
		return false;
	    }
	    logger.debug("ATMDataStore read: " + data.toString());
	    // logger.debug("Resulting Json: " + data.toJson());
	    persistDataStoreTerminal(data);
	} catch (Exception e) {
	    logger.error(
		    "Error while importing terminal from uploaded json file...",
		    e);
	    return false;
	}
	return true;
    }

    private void removeRelatedEntities(Terminal terminal) {
	Set<HardwareDevice> hwDevs = terminal.getHardwareDevices();
	Iterator iter = hwDevs.iterator();
	while (iter.hasNext()) {
	    HardwareDevice hw = (HardwareDevice) iter.next();
	    iter.remove();
	    hardwareDeviceService.removeHardwareDevice(hw.getId());
	}
	logger.debug("Deleted Hardware Devices for Terminal with IP "
		+ terminal.getIp());
	Set<FinancialDevice> financialDevs = terminal.getFinancialDevices();
	iter = financialDevs.iterator();
	while (iter.hasNext()) {
	    FinancialDevice fd = (FinancialDevice) iter.next();
	    iter.remove();
	    financialDeviceService.removeFinancialDevice(fd.getId());
	}
	logger.debug("Deleted Financial Devices for Terminal with IP "
		+ terminal.getIp());
	Set<Hotfix> hotfixes = terminal.getHotfixes();
	iter = hotfixes.iterator();
	while (iter.hasNext()) {
	    Hotfix hotfix = (Hotfix) iter.next();
	    iter.remove();
	    hotfixService.removeHotfix(hotfix.getId());
	}
	logger.debug("Deleted Hotfixes for Terminal with IP "
		+ terminal.getIp());
    }

    private void addNewEntities(Terminal terminal, ATM snmpTerminal) {

	terminal.setHardwareDevices(getHwDevs(terminal, snmpTerminal));
	terminal.setFinancialDevices(getFinancialDevs(terminal, snmpTerminal));
	terminal.setHotfixes(getHotfixes(terminal, snmpTerminal));

	Set<SoftwareAggregate> swAggregates = getSwAggregates(snmpTerminal);
	Set<SoftwareAggregate> swAggregatesAux = new HashSet<SoftwareAggregate>();
	for (SoftwareAggregate swAggregate : swAggregates) {
	    SoftwareAggregate swAggregateAux = softwareAggregateService
		    .getSoftwareAggregateByVersionName(
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
	terminal.setSoftwareAggregates(swAggregates);

	Set<InternetExplorer> ies = getInternetExplorers(snmpTerminal);
	Set<InternetExplorer> iesAux = new HashSet<InternetExplorer>();
	for (InternetExplorer ie : ies) {
	    InternetExplorer ieAux = internetExplorerService
		    .getInternetExplorerByVersion(ie.getMajorVersion(),
			    ie.getMinorVersion(), ie.getBuildVersion(),
			    ie.getRevisionVersion(), ie.getRemainingVersion());
	    if (ieAux != null) {
		iesAux.add(ieAux);
	    } else {
		iesAux.add(ie);
	    }
	}
	terminal.setInternetExplorers(iesAux);

	TerminalConfig newConfig = new TerminalConfig();

	Set<Software> sws = getSoftware(snmpTerminal);
	Set<Software> swsAux = new HashSet<Software>();
	for (Software sw : sws) {
	    Software swAux = softwareService.getSoftwareByIdentifyingNumber(sw
		    .getIdentifyingNumber());
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
	    OperatingSystem osAux = operatingSystemService
		    .getOperatingSystemBySerialNumber(os.getSerialNumber());
	    if (osAux != null) {
		ossAux.add(osAux);
	    } else {
		ossAux.add(os);
	    }
	}
	newConfig.setOperatingSystems(ossAux);

	if ((terminal.getCurrentConfig() == null)
		|| (!terminal.getCurrentConfig().equals(newConfig))) {
	    terminal.getConfigs().add(newConfig);
	    newConfig.setTerminal(terminal);
	    logger.debug("Adding new Software Config to Terminal with IP "
		    + terminal.getIp());
	}
    }

    private void addNewEntities(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal) {

	TerminalModel model = getTerminalModel(dataStoreTerminal);
	if (model != null) {
	    terminal.setTerminalModel(model);
	}
	terminal.setHardwareDevices(getHwDevs(terminal, dataStoreTerminal));
	terminal.setFinancialDevices(getFinancialDevs(terminal,
		dataStoreTerminal));
	terminal.setHotfixes(getHotfixes(terminal, dataStoreTerminal));

	Set<SoftwareAggregate> swAggregates = getSwAggregates(dataStoreTerminal);
	Set<SoftwareAggregate> swAggregatesAux = new HashSet<SoftwareAggregate>();
	for (SoftwareAggregate swAggregate : swAggregates) {
	    SoftwareAggregate swAggregateAux = softwareAggregateService
		    .getSoftwareAggregateByVersionName(
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
	terminal.setSoftwareAggregates(swAggregatesAux);

	Set<InternetExplorer> ies = getInternetExplorers(dataStoreTerminal);
	Set<InternetExplorer> iesAux = new HashSet<InternetExplorer>();
	for (InternetExplorer ie : ies) {
	    InternetExplorer ieAux = internetExplorerService
		    .getInternetExplorerByVersion(ie.getMajorVersion(),
			    ie.getMinorVersion(), ie.getBuildVersion(),
			    ie.getRevisionVersion(), ie.getRemainingVersion());
	    if (ieAux != null) {
		iesAux.add(ieAux);
	    } else {
		iesAux.add(ie);
	    }
	}
	terminal.setInternetExplorers(iesAux);

	TerminalConfig newConfig = new TerminalConfig();

	Set<Software> sws = getSoftware(dataStoreTerminal);
	Set<Software> swsAux = new HashSet<Software>();
	for (Software sw : sws) {
	    Software swAux = softwareService.getSoftwareByIdentifyingNumber(sw
		    .getIdentifyingNumber());
	    if (swAux != null) {
		swsAux.add(swAux);
	    } else {
		swsAux.add(sw);
	    }
	}
	newConfig.setSoftware(swsAux);

	Set<OperatingSystem> oss = getOperatingSystems(dataStoreTerminal);
	Set<OperatingSystem> ossAux = new HashSet<OperatingSystem>();
	for (OperatingSystem os : oss) {
	    OperatingSystem osAux = operatingSystemService
		    .getOperatingSystemBySerialNumber(os.getSerialNumber());
	    if (osAux != null) {
		logger.debug("Found os with serial number "
			+ os.getSerialNumber());
		ossAux.add(osAux);
	    } else {
		logger.debug("Couldn't find os with serial number "
			+ os.getSerialNumber());
		ossAux.add(os);
	    }
	}
	newConfig.setOperatingSystems(ossAux);

	if ((terminal.getCurrentConfig() == null)
		|| (!terminal.getCurrentConfig().equals(newConfig))) {
	    terminal.getConfigs().add(newConfig);
	    newConfig.setTerminal(terminal);
	    logger.debug("Adding new Software Config to Terminal with IP "
		    + terminal.getIp());
	}
    }

    @Override
    public void persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal) {
	try {
	    Terminal terminal = new Terminal(dataStoreTerminal);
	    System.out.println(terminal.getCsvDescription());
	    Terminal dbTerminal = terminalDAO.getTerminalByMac(terminal
		    .getMac());
	    if (dbTerminal != null) {
		overwriteFields(dbTerminal, terminal);
		terminal = dbTerminal;
		terminalDAO.updateTerminal(terminal);
		logger.debug("Updated Terminal from ATMDataStore with IP "
			+ dbTerminal.getIp());
		removeRelatedEntities(terminal);
	    } else {
		terminalDAO.addTerminal(terminal);
		logger.debug("Created Terminal form ATMDataStore with IP "
			+ terminal.getIp());
	    }
	    addNewEntities(terminal, dataStoreTerminal);
	    terminalDAO.updateTerminal(terminal);
	    logger.debug("Created all new devices and software for Terminal with IP "
		    + terminal.getIp());
	} catch (ATMWrongDataException e) {
	    String ip = "";
	    if (!dataStoreTerminal.getvNetworkAdapterSetting().isEmpty()) {
		ip = dataStoreTerminal.getvNetworkAdapterSetting().get(0)
			.getIpAddress();
	    }
	    logger.error("Couldn't persist ATM with IP " + ip
		    + "due to error: ", e);
	}
    }

    @Override
    public void persistSnmpTerminal(ATM snmpTerminal) {
	try {
	    Terminal terminal = new Terminal(snmpTerminal);
	    Terminal dbTerminal = terminalDAO.getTerminalByMac(terminal
		    .getMac());
	    if (dbTerminal != null) {
		overwriteFields(dbTerminal, terminal);
		terminal = dbTerminal;
		terminalDAO.updateTerminal(terminal);
		logger.debug("Updated Terminal by SNMP with IP "
			+ dbTerminal.getIp());
		removeRelatedEntities(terminal);
	    } else {
		terminalDAO.addTerminal(terminal);
		logger.debug("Created Terminal by SNMP with IP "
			+ terminal.getIp());
	    }
	    addNewEntities(terminal, snmpTerminal);
	    terminalDAO.updateTerminal(terminal);
	    logger.debug("Created all new devices and software for Terminal with IP "
		    + terminal.getIp());
	} catch (SnmpWrongDataException e) {
	    logger.error("Couldn't persist ATM with IP " + snmpTerminal.getIp()
		    + "due to error: ", e);
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
	terminal.setProductClassDescription(newTerminal
		.getProductClassDescription());
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

    private TerminalModel getTerminalModel(ATMDataStorePojo dataStoreTerminal) {

	FinancialTerminalPojo ft = dataStoreTerminal.getFinancialTerminal();
	TerminalModel model = null;
	if ((ft.getModel() != null) && (ft.getModel().length() > 0)
		&& (!ft.getModel().equals("null"))) {
	    model = terminalModelService.getTerminalModelByModel(ft.getModel());
	    if (model == null) {
		logger.error("Couldn't find a TerminalModel with model '"
			+ ft.getModel() + "'");
	    }
	}
	return model;
    }

    private Set<SoftwareAggregate> getSwAggregates(
	    ATMDataStorePojo dataStoreTerminal) {
	Set<SoftwareAggregate> swAggregates = new HashSet<SoftwareAggregate>();
	Vector<FinancialPackagePojo> vector = dataStoreTerminal
		.getvFinancialPackage();
	if (vector != null) {
	    for (FinancialPackagePojo item : vector) {
		SoftwareAggregate swAggregate = new SoftwareAggregate(item);
		swAggregates.add(swAggregate);
	    }
	}
	return swAggregates;
    }

    private Set<InternetExplorer> getInternetExplorers(
	    ATMDataStorePojo dataStoreTerminal) {
	Set<InternetExplorer> internetExplorers = new HashSet<InternetExplorer>();
	Vector<IExplorerPojo> vector = dataStoreTerminal.getvIExplorer();
	if (vector != null) {
	    for (IExplorerPojo item : vector) {
		InternetExplorer ie = new InternetExplorer(item);
		internetExplorers.add(ie);
	    }
	}
	return internetExplorers;
    }

    private Set<Software> getSoftware(ATMDataStorePojo dataStoreTerminal) {
	Set<Software> software = new HashSet<Software>();
	Vector<ProductPojo> vector = dataStoreTerminal.getvProduct();
	if (vector != null) {
	    for (ProductPojo item : vector) {
		Software sw = new Software(item);
		software.add(sw);
	    }
	}
	return software;
    }

    private Set<OperatingSystem> getOperatingSystems(
	    ATMDataStorePojo dataStoreTerminal) {
	Set<OperatingSystem> oss = new HashSet<OperatingSystem>();
	Vector<OperatingSystemPojo> vector = dataStoreTerminal
		.getvOperatingSystem();
	if (vector != null) {
	    for (OperatingSystemPojo item : vector) {
		OperatingSystem os = new OperatingSystem(item);
		oss.add(os);
	    }
	}
	return oss;
    }

    private void assignXfsComponent(XfsComponent xfs,
	    Collection<FinancialDevice> finDevs, String name) {
	for (FinancialDevice dev : finDevs) {
	    if (name.equals(dev.getName())) {
		dev.getXfsComponents().add(xfs);
		xfs.setFinancialDevice(dev);
	    }
	}
    }

    private Set<FinancialDevice> getFinancialDevs(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal) {
	Set<FinancialDevice> finDevs = new HashSet<FinancialDevice>();
	Vector<FinancialDevicePojo> vector = dataStoreTerminal
		.getvFinancialDevice();
	if (vector != null) {
	    for (FinancialDevicePojo item : vector) {
		FinancialDevice finDev = new FinancialDevice(item);
		finDev.setTerminal(terminal);
		finDevs.add(finDev);
	    }
	}
	if (dataStoreTerminal.getvAlm() != null) {
	    for (ALM xfsPojo : dataStoreTerminal.getvAlm()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvBcr() != null) {
	    for (BCR xfsPojo : dataStoreTerminal.getvBcr()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvCam() != null) {
	    for (CAM xfsPojo : dataStoreTerminal.getvCam()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvCdm() != null) {
	    for (CDM xfsPojo : dataStoreTerminal.getvCdm()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvCeu() != null) {
	    for (CEU xfsPojo : dataStoreTerminal.getvCeu()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvChk() != null) {
	    for (CHK xfsPojo : dataStoreTerminal.getvChk()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvCim() != null) {
	    for (CIM xfsPojo : dataStoreTerminal.getvCim()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvCrd() != null) {
	    for (CRD xfsPojo : dataStoreTerminal.getvCrd()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvDep() != null) {
	    for (DEP xfsPojo : dataStoreTerminal.getvDep()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvIdc() != null) {
	    for (IDC xfsPojo : dataStoreTerminal.getvIdc()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvIpm() != null) {
	    for (IPM xfsPojo : dataStoreTerminal.getvIpm()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvPin() != null) {
	    for (PIN xfsPojo : dataStoreTerminal.getvPin()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvPtr() != null) {
	    for (PTR xfsPojo : dataStoreTerminal.getvPtr()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvSiu() != null) {
	    for (SIU xfsPojo : dataStoreTerminal.getvSiu()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvTtu() != null) {
	    for (TTU xfsPojo : dataStoreTerminal.getvTtu()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	if (dataStoreTerminal.getvVdm() != null) {
	    for (VDM xfsPojo : dataStoreTerminal.getvVdm()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename());
	    }
	}
	return finDevs;
    }

    private Set<Hotfix> getHotfixes(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal) {
	Set<Hotfix> hotfixes = new HashSet<Hotfix>();
	Vector<HotfixPojo> vector = dataStoreTerminal.getvHotfix();
	if (vector != null) {
	    for (HotfixPojo item : vector) {
		Hotfix hotfix = new Hotfix(item);
		hotfix.setTerminal(terminal);
		hotfixes.add(hotfix);
	    }
	}
	return hotfixes;
    }

    private Set<HardwareDevice> getHwDevs(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal) {

	Set<HardwareDevice> hwDevs = new HashSet<HardwareDevice>();
	Vector vector = dataStoreTerminal.getV1394Controller();
	if (vector != null) {
	    for (_1394ControllerPojo item : (Vector<_1394ControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvBaseBoard();
	if (vector != null) {
	    for (BaseBoardPojo item : (Vector<BaseBoardPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvBios();
	if (vector != null) {
	    for (BiosPojo item : (Vector<BiosPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvCDROMDrive();
	if (vector != null) {
	    for (CDROMDrivePojo item : (Vector<CDROMDrivePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvComputerSystem();
	if (vector != null) {
	    for (ComputerSystemPojo item : (Vector<ComputerSystemPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvDesktopMonitor();
	if (vector != null) {
	    for (DesktopMonitorPojo item : (Vector<DesktopMonitorPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvDiskDrive();
	if (vector != null) {
	    for (DiskDrivePojo item : (Vector<DiskDrivePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvFloppyDrive();
	if (vector != null) {
	    for (FloppyDrivePojo item : (Vector<FloppyDrivePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvKeyboard();
	if (vector != null) {
	    for (KeyboardPojo item : (Vector<KeyboardPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvLogicalDisk();
	if (vector != null) {
	    for (LogicalDiskPojo item : (Vector<LogicalDiskPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvNetworkAdapterSetting();
	if (vector != null) {
	    for (NetworkAdapterSettingPojo item : (Vector<NetworkAdapterSettingPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvParallelPort();
	if (vector != null) {
	    for (ParallelPortPojo item : (Vector<ParallelPortPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvPhysicalMemory();
	if (vector != null) {
	    for (PhysicalMemoryPojo item : (Vector<PhysicalMemoryPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvPointingDevice();
	if (vector != null) {
	    for (PointingDevicePojo item : (Vector<PointingDevicePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvProcessor();
	if (vector != null) {
	    for (ProcessorPojo item : (Vector<ProcessorPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSCSIController();
	if (vector != null) {
	    for (SCSIControllerPojo item : (Vector<SCSIControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSerialPort();
	if (vector != null) {
	    for (SerialPortPojo item : (Vector<SerialPortPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSoundDevice();
	if (vector != null) {
	    for (SoundDevicePojo item : (Vector<SoundDevicePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSystemSlot();
	if (vector != null) {
	    for (SystemSlotPojo item : (Vector<SystemSlotPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvUSBController();
	if (vector != null) {
	    for (USBControllerPojo item : (Vector<USBControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvUSBHub();
	if (vector != null) {
	    for (UsbHubPojo item : (Vector<UsbHubPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvVideoController();
	if (vector != null) {
	    for (VideoControllerPojo item : (Vector<VideoControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDevs.add(hwDev);
	    }
	}
	return hwDevs;
    }
}