package com.ncr.ATMMonitoring.pojo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.socket.ATMWrongDataException;
import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.agent.baseData.os.module.NetworkAdapterSettingPojo;
import com.ncr.agent.baseData.vendor.utils.FinancialTerminalPojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "terminals")
public class Terminal {

    static private Logger logger = Logger.getLogger(Terminal.class.getName());

    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> operations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	comboboxes.put("terminalType", operations);
	comboboxes.put("terminalVendor", operations);
	comboboxes.put("frontReplenish",
		Operation.getOperationsByType(Operation.DataType.BOOLEAN));
	comboboxes.put("geographicAddress", operations);
	comboboxes.put("address", operations);
	comboboxes.put("city", operations);
	comboboxes.put("area", operations);
	comboboxes.put("country", operations);
	comboboxes.put("zipCode", operations);
	comboboxes.put("branch", operations);
	comboboxes.put("bank", operations);
	comboboxes.put("manufacturingSite", operations);
	comboboxes.put("model", operations);
	comboboxes.put("productClass", operations);
	comboboxes.put("productClassDescription", operations);
	comboboxes.put("serialNumber", operations);
	comboboxes.put("tracerNumber", operations);
	comboboxes.put("ip", operations);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminals_id_seq")
    @SequenceGenerator(name = "terminals_id_seq", sequenceName = "terminals_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "installation_id")
    private Installation installation;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankCompany bankCompany;

    @ManyToOne
    @JoinColumn(name = "terminal_model_id")
    private TerminalModel terminalModel;

    @Column(name = "terminal_type")
    @Type(type = "text")
    private String terminalType;

    @Column(name = "terminal_vendor")
    @Type(type = "text")
    private String terminalVendor;

    @Column(name = "front_replenish")
    private Boolean frontReplenish;

    @Column(name = "geographic_address")
    @Type(type = "text")
    private String geographicAddress;

    @Column(name = "branch")
    @Type(type = "text")
    private String branch;

    @Column(name = "bank")
    @Type(type = "text")
    private String bank;

    @Column(name = "manufacturing_site")
    @Type(type = "text")
    private String manufacturingSite;

    @Column(name = "product_class_description")
    @Type(type = "text")
    private String productClassDescription;

    @Column(name = "serial_number")
    @Type(type = "text")
    private String serialNumber;

    @Column(name = "tracer_number")
    @Type(type = "text")
    private String tracerNumber;

    @Column(name = "matricula", nullable = false)
    private Long matricula;

    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("start_date desc")
    private Set<TerminalConfig> configs = new HashSet<TerminalConfig>();

    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("serial_number")
    private Set<FinancialDevice> financialDevices = new HashSet<FinancialDevice>();

    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("hardware_class")
    private Set<HardwareDevice> hardwareDevices = new HashSet<HardwareDevice>();

    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("hotfix_id")
    private Set<Hotfix> hotfixes = new HashSet<Hotfix>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "terminal_software_aggregate", joinColumns = { @JoinColumn(name = "terminal_id") }, inverseJoinColumns = { @JoinColumn(name = "software_aggregate_id") })
    @OrderBy("name asc, major_version desc, minor_version desc, build_version desc, revision_version desc, remaining_version asc")
    private Set<SoftwareAggregate> softwareAggregates = new HashSet<SoftwareAggregate>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "terminal_internet_explorer", joinColumns = { @JoinColumn(name = "terminal_id") }, inverseJoinColumns = { @JoinColumn(name = "internet_explorer_id") })
    @OrderBy("major_version desc, minor_version desc, build_version desc, revision_version desc, remaining_version asc")
    private Set<InternetExplorer> internetExplorers = new HashSet<InternetExplorer>();

    @Column(name = "ip", length = 23)
    private String ip;

    @Column(name = "mac", length = 17)
    private String mac;

    /**
     * @return the comboboxes
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    public static String getCsvHeader() {
	return "Serial Number;IP;MAC;Terminal Type;Vendor;Product Class;"
		+ "Product Class Description;Front Replenish;Bank;"
		+ "Branch;Geographic Address;Address;Manufacturing Site;"
		+ "Tracer Number";
    }

    public Terminal() {
    }

    public Terminal(ATMDataStorePojo terminal) throws ATMWrongDataException {
	this.ip = terminal.getCurrentip();
	this.mac = terminal.getCurrentmac();
	FinancialTerminalPojo financialTerminal = terminal
		.getFinancialTerminal();
	if (financialTerminal == null) {
	    throw new ATMWrongDataException(
		    "No subobject FinancialTerminal in Terminal related to IP "
			    + ip);
	}
	this.geographicAddress = financialTerminal.getGeographicaddress();
	this.frontReplenish = Boolean.parseBoolean(financialTerminal
		.getFrontreplenish());
	this.manufacturingSite = financialTerminal.getManufacturingsite();
	this.productClassDescription = financialTerminal
		.getProductclassdescription();
	// if ((financialTerminal.getSerialnumber() != null)
	// && (financialTerminal.getSerialnumber().length() > 0)
	// && !financialTerminal.getSerialnumber().equals("null")) {
	this.serialNumber = financialTerminal.getSerialnumber();
	// }
	this.terminalType = financialTerminal.getTerminaltype();
	this.terminalVendor = financialTerminal.getVendor();
	this.tracerNumber = financialTerminal.getTracernumber();
	String matricula = terminal.getMatricula();
	if ((matricula != null) && (matricula.length() > 0)) {
	    this.matricula = Long.parseLong(terminal.getMatricula());
	}
    }

    public void replaceTerminalData(Terminal terminal) {
	this.bank = terminal.bank;
	this.branch = terminal.branch;
	this.frontReplenish = terminal.frontReplenish;
	this.geographicAddress = terminal.geographicAddress;
	this.ip = terminal.ip;
	this.mac = terminal.mac;
	this.manufacturingSite = terminal.manufacturingSite;
	this.productClassDescription = terminal.productClassDescription;
	this.serialNumber = terminal.serialNumber;
	this.terminalType = terminal.terminalType;
	this.terminalVendor = terminal.terminalVendor;
	this.tracerNumber = terminal.tracerNumber;
	this.bankCompany = terminal.bankCompany;
	this.installation = terminal.installation;
	this.terminalModel = terminal.terminalModel;
    }

    public void replaceTerminalDataWoVoidValues(Terminal terminal) {
	this.bank = ((terminal.bank != null) && (terminal.bank.trim().length() > 0)) ? terminal.bank
		: this.bank;
	this.branch = ((terminal.branch != null) && (terminal.branch.trim()
		.length() > 0)) ? terminal.branch : this.branch;
	this.frontReplenish = (terminal.frontReplenish != null) ? terminal.frontReplenish
		: this.frontReplenish;
	this.geographicAddress = ((terminal.geographicAddress != null) && (terminal.geographicAddress
		.trim().length() > 0)) ? terminal.geographicAddress
		: this.geographicAddress;
	this.ip = ((terminal.ip != null) && (terminal.ip.trim().length() > 0)) ? terminal.ip
		: this.ip;
	this.mac = ((terminal.mac != null) && (terminal.mac.trim().length() > 0)) ? terminal.mac
		: this.mac;
	this.manufacturingSite = ((terminal.manufacturingSite != null) && (terminal.manufacturingSite
		.trim().length() > 0)) ? terminal.manufacturingSite
		: this.manufacturingSite;
	this.productClassDescription = ((terminal.productClassDescription != null) && (terminal.productClassDescription
		.trim().length() > 0)) ? terminal.productClassDescription
		: this.productClassDescription;
	this.serialNumber = ((terminal.serialNumber != null) && (terminal.serialNumber
		.trim().length() > 0)) ? terminal.serialNumber
		: this.serialNumber;
	this.terminalType = ((terminal.terminalType != null) && (terminal.terminalType
		.trim().length() > 0)) ? terminal.terminalType
		: this.terminalType;
	this.terminalVendor = ((terminal.terminalVendor != null) && (terminal.terminalVendor
		.trim().length() > 0)) ? terminal.terminalVendor
		: this.terminalVendor;
	this.tracerNumber = ((terminal.tracerNumber != null) && (terminal.tracerNumber
		.trim().length() > 0)) ? terminal.tracerNumber
		: this.tracerNumber;
	// We don't know if we can retrieve this information yet
	// this.bankCompany = (terminal.bankCompany != null) ?
	// terminal.bankCompany
	// : this.bankCompany;
	this.terminalModel = (terminal.terminalModel != null) ? terminal.terminalModel
		: this.terminalModel;
    }

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the bankCompany
     */
    public BankCompany getBankCompany() {
	return bankCompany;
    }

    /**
     * @param bankCompany
     *            the bankCompany to set
     */
    public void setBankCompany(BankCompany bankCompany) {
	this.bankCompany = bankCompany;
    }

    /**
     * @return the terminalType
     */
    public String getTerminalType() {
	return terminalType;
    }

    /**
     * @param terminalType
     *            the terminalType to set
     */
    public void setTerminalType(String terminalType) {
	this.terminalType = terminalType;
    }

    /**
     * @return the terminalVendor
     */
    public String getTerminalVendor() {
	return terminalVendor;
    }

    /**
     * @param terminalVendor
     *            the terminalVendor to set
     */
    public void setTerminalVendor(String terminalVendor) {
	this.terminalVendor = terminalVendor;
    }

    /**
     * @return the frontReplenish
     */
    public Boolean getFrontReplenish() {
	return frontReplenish;
    }

    /**
     * @param frontReplenish
     *            the frontReplenish to set
     */
    public void setFrontReplenish(Boolean frontReplenish) {
	this.frontReplenish = frontReplenish;
    }

    /**
     * @return the geographicAddress
     */
    public String getGeographicAddress() {
	return geographicAddress;
    }

    /**
     * @param geographicAddress
     *            the geographicAddress to set
     */
    public void setGeographicAddress(String geographicAddress) {
	this.geographicAddress = geographicAddress;
    }

    /**
     * @return the manufacturingSite
     */
    public String getManufacturingSite() {
	return manufacturingSite;
    }

    /**
     * @param manufacturingSite
     *            the manufacturingSite to set
     */
    public void setManufacturingSite(String manufacturingSite) {
	this.manufacturingSite = manufacturingSite;
    }

    /**
     * @return the productClassDescription
     */
    public String getProductClassDescription() {
	return productClassDescription;
    }

    /**
     * @param productClassDescription
     *            the productClassDescription to set
     */
    public void setProductClassDescription(String productClassDescription) {
	this.productClassDescription = productClassDescription;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
	return serialNumber;
    }

    /**
     * @param serialNumber
     *            the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * @return the tracerNumber
     */
    public String getTracerNumber() {
	return tracerNumber;
    }

    /**
     * @param tracerNumber
     *            the tracerNumber to set
     */
    public void setTracerNumber(String tracerNumber) {
	this.tracerNumber = tracerNumber;
    }

    /**
     * @return the configs
     */
    public Set<TerminalConfig> getConfigs() {
	return configs;
    }

    /**
     * @param configs
     *            the configs to set
     */
    public void setConfigs(Set<TerminalConfig> configs) {
	this.configs = configs;
    }

    /**
     * @return the financialDevices
     */
    public Set<FinancialDevice> getFinancialDevices() {
	return financialDevices;
    }

    /**
     * @param financialDevices
     *            the financialDevices to set
     */
    public void setFinancialDevices(Set<FinancialDevice> financialDevices) {
	this.financialDevices = financialDevices;
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getHardwareDevices() {
	return hardwareDevices;
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getComputerSystems() {
	return HardwareDevice.filterComputerSystem(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getProcessors() {
	return HardwareDevice.filterProcessor(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getPhysicalMemories() {
	return HardwareDevice.filterPhysicalMemory(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getDiskDrives() {
	return HardwareDevice.filterDiskDrive(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getLogicalDisks() {
	return HardwareDevice.filterLogicalDisk(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getBaseBoards() {
	return HardwareDevice.filterBaseBoard(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getNetworkAdapters() {
	return HardwareDevice.filterNetworkAdapter(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getFloppyDrives() {
	return HardwareDevice.filterFloppyDrive(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getCdromDrives() {
	return HardwareDevice.filterCdromDrive(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getSoundDevices() {
	return HardwareDevice.filterSoundDevice(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getUsbControllers() {
	return HardwareDevice.filterUsbController(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getSerialPorts() {
	return HardwareDevice.filterSerialPort(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getParallelPorts() {
	return HardwareDevice.filterParallelPort(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getControllers1394() {
	return HardwareDevice.filter1394Controller(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getScsiControllers() {
	return HardwareDevice.filterScsiController(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getDesktopMonitors() {
	return HardwareDevice.filterDesktopMonitor(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getKeyboards() {
	return HardwareDevice.filterKeyboard(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getPointingDevices() {
	return HardwareDevice.filterPointingDevice(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getSystemSlots() {
	return HardwareDevice.filterSystemSlot(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getBios() {
	return HardwareDevice.filterBios(hardwareDevices);
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getVideoControllers() {
	return HardwareDevice.filterVideoController(hardwareDevices);
    }

    /**
     * @param hardwareDevices
     *            the hardwareDevices to set
     */
    public void setHardwareDevices(Set<HardwareDevice> hardwareDevices) {
	this.hardwareDevices = hardwareDevices;
    }

    /**
     * @return the current config
     */
    public TerminalConfig getCurrentConfig() {
	if ((configs != null) && (!configs.isEmpty())) {
	    return configs.iterator().next();
	}
	return null;
    }

    /**
     * @return the bank
     */
    public String getBank() {
	return bank;
    }

    /**
     * @param bank
     *            the bank to set
     */
    public void setBank(String bank) {
	this.bank = bank;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
	return branch;
    }

    /**
     * @param branch
     *            the branch to set
     */
    public void setBranch(String branch) {
	this.branch = branch;
    }

    /**
     * @return the ip
     */
    public String getIp() {
	return ip;
    }

    /**
     * @param ip
     *            the ip to set
     */
    public void setIp(String ip) {
	this.ip = ip;
    }

    /**
     * @return the softwareAggregates
     */
    public Set<SoftwareAggregate> getSoftwareAggregates() {
	return softwareAggregates;
    }

    /**
     * @param softwareAggregates
     *            the softwareAggregates to set
     */
    public void setSoftwareAggregates(Set<SoftwareAggregate> softwareAggregates) {
	this.softwareAggregates = softwareAggregates;
    }

    /**
     * @return the hotfixes
     */
    public Set<Hotfix> getHotfixes() {
	return hotfixes;
    }

    /**
     * @param hotfixes
     *            the hotfixes to set
     */
    public void setHotfixes(Set<Hotfix> hotfixes) {
	this.hotfixes = hotfixes;
    }

    /**
     * @return the internetExplorers
     */
    public Set<InternetExplorer> getInternetExplorers() {
	return internetExplorers;
    }

    /**
     * @param internetExplorers
     *            the internetExplorers to set
     */
    public void setInternetExplorers(Set<InternetExplorer> internetExplorers) {
	this.internetExplorers = internetExplorers;
    }

    public String getCsvDescription() {
	return (serialNumber != null ? serialNumber.toString() : "")
		+ ";"
		+ (ip != null ? ip.toString() : "")
		+ ";"
		+ (mac != null ? mac.toString() : "")
		+ ";"
		+ (terminalType != null ? terminalType.toString() : "")
		+ ";"
		+ (((terminalModel != null) && (terminalModel.getManufacturer() != null)) ? terminalModel
			.getManufacturer() : "")
		+ ";"
		+ (((terminalModel != null) && (terminalModel.getProductClass() != null)) ? terminalModel
			.getProductClass() : "")
		+ ";"
		+ (productClassDescription != null ? productClassDescription
			.toString() : "")
		+ ";"
		+ (frontReplenish != null ? frontReplenish.toString() : "")
		+ ";"
		+ (bank != null ? bank.toString() : "")
		+ ";"
		+ (branch != null ? branch.toString() : "")
		+ ";"
		+ (geographicAddress != null ? geographicAddress.toString()
			: "")
		+ ";"
		+ (((installation != null) && (installation.getLocation() != null)) ? installation
			.getLocation().getCompleteAddress() : "")
		+ ";"
		+ (manufacturingSite != null ? manufacturingSite.toString()
			: "") + ";"
		+ (tracerNumber != null ? tracerNumber.toString() : "");
    }

    /**
     * @return the mac
     */
    public String getMac() {
	return mac;
    }

    /**
     * @param mac
     *            the mac to set
     */
    public void setMac(String mac) {
	this.mac = mac;
    }

    public TerminalModel getTerminalModel() {
	return terminalModel;
    }

    public void setTerminalModel(TerminalModel terminalModel) {
	this.terminalModel = terminalModel;
    }

    public Installation getInstallation() {
	return installation;
    }

    public void setInstallation(Installation installation) {
	this.installation = installation;
    }

    public Long getMatricula() {
	return matricula;
    }

    public void setMatricula(Long matricula) {
	this.matricula = matricula;
    }
}
