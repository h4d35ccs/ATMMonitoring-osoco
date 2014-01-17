package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ncr.ATMMonitoring.dao.TerminalDAO;
import com.ncr.ATMMonitoring.pojo.AuditableInternetExplorer;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.Hotfix;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;
import com.ncr.ATMMonitoring.pojo.TerminalModel;
import com.ncr.ATMMonitoring.pojo.XfsComponent;
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
import com.ncr.agent.baseData.standard.jxfs.alm.CapabilitiesJxfsALMCollector;
import com.ncr.agent.baseData.standard.jxfs.cam.CapabilitiesJxfsCAMCollector;
import com.ncr.agent.baseData.standard.jxfs.cdr.CapabilitiesJxfsCDRCollector;
import com.ncr.agent.baseData.standard.jxfs.chk.CapabilitiesJxfsCHKCollector;
import com.ncr.agent.baseData.standard.jxfs.dep.CapabilitiesJxfsDEPCollector;
import com.ncr.agent.baseData.standard.jxfs.msd.CapabilitiesJxfsMSDCollector;
import com.ncr.agent.baseData.standard.jxfs.pin.CapabilitiesJxfsPINCollector;
import com.ncr.agent.baseData.standard.jxfs.ptr.CapabilitiesJxfsPTRCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.CapabilitiesJxfsSCNCollector;
import com.ncr.agent.baseData.standard.jxfs.siu.CapabilitiesJxfsSIUCollector;
import com.ncr.agent.baseData.standard.jxfs.tio.CapabilitiesJxfsTIOCollector;
import com.ncr.agent.baseData.standard.jxfs.vdm.CapabilitiesJxfsVDMCollector;
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
 * The Class TerminalServiceImpl.
 * 
 * Default implementation of the TerminalService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("terminalService")
@Transactional
public class TerminalServiceImpl implements TerminalService {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalServiceImpl.class
	    .getName());

    /** The terminal dao. */
    @Autowired
    private TerminalDAO terminalDAO;
    
    /** The hardware device service. */
    @Autowired
    private HardwareDeviceService hardwareDeviceService;
    
    /** The financial device service. */
    @Autowired
    private FinancialDeviceService financialDeviceService;
    
    /** The internet explorer service. */
    @Autowired
    private InternetExplorerService internetExplorerService;
    
    /** The hotfix service. */
    @Autowired
    private HotfixService hotfixService;
    
    /** The software aggregate service. */
    @Autowired
    private SoftwareAggregateService softwareAggregateService;
    
    /** The software service. */
    @Autowired
    private SoftwareService softwareService;
    
    /** The operating system service. */
    @Autowired
    private OperatingSystemService operatingSystemService;
    
    /** The terminal model service. */
    @Autowired
    private TerminalModelService terminalModelService;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#addTerminal(com.ncr.ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void addTerminal(Terminal terminal) {
	terminalDAO.addTerminal(terminal);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#updateTerminal(com.ncr.ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void updateTerminal(Terminal terminal) {
	terminalDAO.updateTerminal(terminal);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminalsByBankCompanies(java.util.Set)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks) {
	return terminalDAO.listTerminalsByBankCompanies(banks);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminalsByBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank) {
	return terminalDAO.listTerminalsByBankCompany(bank);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminalsByBankCompanies(java.util.Set, java.lang.String, java.lang.String)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks,
	    String sort, String order) {
	return terminalDAO.listTerminalsByBankCompanies(banks, sort, order, null);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminals()
     */
    @Override
    public List<Terminal> listTerminals() {
	return terminalDAO.listTerminals();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#getTerminal(java.lang.Integer)
     */
    @Override
    public Terminal getTerminal(Integer id) {
	return terminalDAO.getTerminal(id);
    }
    
    @Override
    public List<Terminal> listTerminalsByIdsAndBankCompanies(List<Integer> terminalIds, Set<BankCompany> bankCompanies) {
    	return terminalDAO.listTerminalsByIdsAndBankCompanies(terminalIds, bankCompanies);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalBySerialNumber(java.lang.String)
     */
    @Override
    public Terminal loadTerminalBySerialNumber(String serialNumber) {
	return terminalDAO.getTerminalBySerialNumber(serialNumber);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalByMatricula(java.lang.Long)
     */
    @Override
    public Terminal loadTerminalByMatricula(Long matricula) {
	return terminalDAO.getTerminalByMatricula(matricula);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalByIp(java.lang.String)
     */
    @Override
    public Terminal loadTerminalByIp(String ip) {
	return terminalDAO.getTerminalByIp(ip);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalByMac(java.lang.String)
     */
    @Override
    public Terminal loadTerminalByMac(String mac) {
	return terminalDAO.getTerminalByMac(mac);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#importJsonTerminal(org.springframework.web.multipart.commons.CommonsMultipartFile)
     */
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

    /**
     * Removes all entities that depend onto a terminal.
     * 
     * @param terminal
     *            the terminal
     */
    @SuppressWarnings("rawtypes")
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

    /**
     * Adds the entities related to a terminal from an agent's pojo data.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     */
    private void addNewEntities(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal) {

	TerminalModel model = getTerminalModel(dataStoreTerminal);
	if (model != null) {
	    terminal.setTerminalModel(model);
	    terminal.setTerminalVendor(model.getManufacturer());
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

	//TODO Do correct AuditableInternetExplorer use
	Set<InternetExplorer> ies = getInternetExplorers(dataStoreTerminal);
	Set<AuditableInternetExplorer> iesAux = new HashSet<AuditableInternetExplorer>();
	for (InternetExplorer ie : ies) {
	    InternetExplorer storedIE = internetExplorerService
		    .getInternetExplorerByVersion(ie.getMajorVersion(),
			    ie.getMinorVersion(), ie.getBuildVersion(),
			    ie.getRevisionVersion(), ie.getRemainingVersion());
	    
	    AuditableInternetExplorer auditableIE = new AuditableInternetExplorer(storedIE != null ? storedIE : ie);
	    iesAux.add(auditableIE);
	}
	terminal.setAuditableInternetExplorers(iesAux);

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

	if ((terminal.getCurrentTerminalConfig() == null)
		|| (!terminal.getCurrentTerminalConfig().equals(newConfig))) {
	    terminal.getConfigs().add(newConfig);
	    newConfig.setTerminal(terminal);
	    logger.debug("Adding new Software Config to Terminal with IP "
		    + terminal.getIp());
	}
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.TerminalService#persistDataStoreTerminal(com.ncr.agent.baseData.ATMDataStorePojo)
     */
    @Override
    public Terminal persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal) {
	Terminal terminal = null;
	try {
	    try {
		terminal = new Terminal(dataStoreTerminal);
	    } catch (NumberFormatException e) {
		logger.error("Couldn't parse matricula number...", e);
		throw e;
	    }
	    Terminal dbTerminal = terminalDAO.getTerminalByMatricula(terminal
		    .getMatricula());
	    if ((dbTerminal == null) && (terminal.getSerialNumber() != null)
			&& (terminal.getSerialNumber().trim().length() > 0)) {
		dbTerminal = terminalDAO.getTerminalBySerialNumber(terminal
			.getSerialNumber());
	    }
	    if (dbTerminal == null) {
		dbTerminal = terminalDAO
			.getTerminalBySimilarity(dataStoreTerminal);
	    }
	    if (dbTerminal != null) {
		dbTerminal.replaceTerminalDataWoVoidValues(terminal);
		terminal = dbTerminal;
		terminalDAO.updateTerminal(terminal);
		logger.debug("Updated Terminal from ATMDataStore with IP "
			+ terminal.getIp() + " and matricula "
			+ terminal.getMatricula());
		removeRelatedEntities(terminal);
	    } else {
		terminalDAO.addTerminal(terminal);
		logger.debug("Created Terminal from ATMDataStore with IP "
			+ terminal.getIp() + " and matricula "
			+ terminal.getMatricula());
	    }
	    addNewEntities(terminal, dataStoreTerminal);
	    terminalDAO.updateTerminal(terminal);
	    logger.debug("Created all new devices and software for Terminal with IP "
		    + terminal.getIp()
		    + " and matricula "
		    + terminal.getMatricula());
	} catch (ATMWrongDataException e) {
	    logger.error(
		    "Couldn't persist ATM with IP "
			    + dataStoreTerminal.getCurrentip()
		    + "due to error: ", e);
	}
	return terminal;
    }

    /**
     * Gets the terminal model from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the terminal model
     */
    private TerminalModel getTerminalModel(ATMDataStorePojo dataStoreTerminal) {

	FinancialTerminalPojo ft = dataStoreTerminal.getFinancialTerminal();
	TerminalModel model = null;
	String productClass = ft.getProductclass();
	if ((productClass != null) && (productClass.length() > 0)
		&& (!productClass.equals("null"))) {
	    model = terminalModelService
		    .getTerminalModelByProductClass(productClass);
	    if (model == null) {
		logger.error("Couldn't find a TerminalModel with product class '"
			+ productClass + "'");
	    }
	}
	return model;
    }

    /**
     * Gets the sw aggregates from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the sw aggregates
     */
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

    /**
     * Gets the internet explorers from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the internet explorers
     */
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

    /**
     * Gets the software from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the software
     */
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

    /**
     * Gets the operating systems from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the operating systems
     */
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

    /**
     * Assign an xfs component to its financial devices by their names.
     * 
     * @param xfs
     *            the xfs component
     * @param finDevs
     *            the financial devices we have
     * @param names
     *            the xfs' financial device names
     */
    private void assignXfsComponent(XfsComponent xfs,
	    Collection<FinancialDevice> finDevs, String[] names) {
	boolean found;
	for (String name : names) {
	    found = false;
	    for (FinancialDevice dev : finDevs) {
		if (name.equals(dev.getName()) || name.equals(dev.getCaption())) {
		    dev.getXfsComponents().add(xfs);
		    found = true;
		    break;
		}
	    }
	    if (!found) {
		logger.warn("Couldn't find financial device '" + name
			+ "' for xfs component '" + xfs.getXfsClass() + "'");
	    }
	}
    }

    /**
     * Assign an jxfs component to its financial devices by their names.
     * 
     * @param jxfs
     *            the jxfs component
     * @param finDevs
     *            the financial devices we have
     * @param names
     *            the jxfs' financial device names
     */
    private void assignJxfsComponent(JxfsComponent jxfs,
	    Collection<FinancialDevice> finDevs, String[] names) {
	boolean found;
	for (String name : names) {
	    found = false;
	    for (FinancialDevice dev : finDevs) {
		if (name.equals(dev.getName()) || name.equals(dev.getCaption())) {
		    dev.getJxfsComponents().add(jxfs);
		    found = true;
		    break;
		}
	    }
	    if (!found) {
		logger.warn("Couldn't find financial device '" + name
			+ "' for jxfs component '" + jxfs.getJxfsClass() + "'");
	    }
	}
    }

    /**
     * Gets the financial devs from an agent's pojo data. It also assigns the
     * passed terminal to them.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the financial devs
     */
    private Set<FinancialDevice> getFinancialDevs(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal) {
	Set<FinancialDevice> finDevs = new HashSet<FinancialDevice>();
	Vector<FinancialDevicePojo> vector = dataStoreTerminal
		.getvFinancialDevice();
	// Create and assign xfs components
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
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvBcr() != null) {
	    for (BCR xfsPojo : dataStoreTerminal.getvBcr()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvCam() != null) {
	    for (CAM xfsPojo : dataStoreTerminal.getvCam()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvCdm() != null) {
	    for (CDM xfsPojo : dataStoreTerminal.getvCdm()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvCeu() != null) {
	    for (CEU xfsPojo : dataStoreTerminal.getvCeu()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvChk() != null) {
	    for (CHK xfsPojo : dataStoreTerminal.getvChk()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvCim() != null) {
	    for (CIM xfsPojo : dataStoreTerminal.getvCim()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvCrd() != null) {
	    for (CRD xfsPojo : dataStoreTerminal.getvCrd()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvDep() != null) {
	    for (DEP xfsPojo : dataStoreTerminal.getvDep()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvIdc() != null) {
	    for (IDC xfsPojo : dataStoreTerminal.getvIdc()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvIpm() != null) {
	    for (IPM xfsPojo : dataStoreTerminal.getvIpm()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvPin() != null) {
	    for (PIN xfsPojo : dataStoreTerminal.getvPin()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvPtr() != null) {
	    for (PTR xfsPojo : dataStoreTerminal.getvPtr()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvSiu() != null) {
	    for (SIU xfsPojo : dataStoreTerminal.getvSiu()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvTtu() != null) {
	    for (TTU xfsPojo : dataStoreTerminal.getvTtu()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getvVdm() != null) {
	    for (VDM xfsPojo : dataStoreTerminal.getvVdm()) {
		XfsComponent xfs = new XfsComponent(xfsPojo);
		if (xfsPojo.getDevicename() != null) {
		    assignXfsComponent(xfs, finDevs, xfsPojo.getDevicename()
			    .split(","));
		} else {
		    logger.warn("Xfs component of type '"
			    + xfs.getXfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}

	// Create and assign jxfs components
	if (dataStoreTerminal.getVjAlm() != null) {
	    for (CapabilitiesJxfsALMCollector jxfsPojo : dataStoreTerminal
		    .getVjAlm()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjCam() != null) {
	    for (CapabilitiesJxfsCAMCollector jxfsPojo : dataStoreTerminal
		    .getVjCam()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjCdr() != null) {
	    for (CapabilitiesJxfsCDRCollector jxfsPojo : dataStoreTerminal
		    .getVjCdr()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjChk() != null) {
	    for (CapabilitiesJxfsCHKCollector jxfsPojo : dataStoreTerminal
		    .getVjChk()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjDep() != null) {
	    for (CapabilitiesJxfsDEPCollector jxfsPojo : dataStoreTerminal
		    .getVjDep()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjMsd() != null) {
	    for (CapabilitiesJxfsMSDCollector jxfsPojo : dataStoreTerminal
		    .getVjMsd()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjPin() != null) {
	    for (CapabilitiesJxfsPINCollector jxfsPojo : dataStoreTerminal
		    .getVjPin()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjPtr() != null) {
	    for (CapabilitiesJxfsPTRCollector jxfsPojo : dataStoreTerminal
		    .getVjPtr()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjScn() != null) {
	    for (CapabilitiesJxfsSCNCollector jxfsPojo : dataStoreTerminal
		    .getVjScn()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjSiu() != null) {
	    for (CapabilitiesJxfsSIUCollector jxfsPojo : dataStoreTerminal
		    .getVjSiu()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjTio() != null) {
	    for (CapabilitiesJxfsTIOCollector jxfsPojo : dataStoreTerminal
		    .getVjTio()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	if (dataStoreTerminal.getVjVdm() != null) {
	    for (CapabilitiesJxfsVDMCollector jxfsPojo : dataStoreTerminal
		    .getVjVdm()) {
		JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		String[] devs = jxfsPojo.getVendorinfo();
		if ((devs != null) && (devs.length > 0)) {
		    assignJxfsComponent(jxfs, finDevs, devs);
		} else {
		    logger.warn("Jxfs component of type '"
			    + jxfs.getJxfsClass()
			    + "' won't be saved because it has no financial device info!!");
		}
	    }
	}
	return finDevs;
    }

    /**
     * Gets the hotfixes from an agent's pojo data. It also assigns the passed
     * terminal to them.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the hotfixes
     */
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

    /**
     * Gets the hardware devices from an agent's pojo data. It also assigns the
     * passed terminal to them.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the hardware devices
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
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

	
	public void addInstallationAndUpdateHistoricalData(Terminal terminal, Installation installation) {
		terminal.setCurrentInstallation(installation);
		updateTerminal(terminal);
	}
}