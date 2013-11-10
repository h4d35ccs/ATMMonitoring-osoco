package com.ncr.ATMMonitoring.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

import ncr.inventory.data.Device;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.vendor.utils.FinancialDevicePojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "financial_devices")
public class FinancialDevice {

    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> boolOperations = Operation
		.getOperationsByType(Operation.DataType.BOOLEAN);
	comboboxes.put("model", stringOperations);
	comboboxes.put("variant", stringOperations);
	comboboxes.put("manufacturer", stringOperations);
	comboboxes.put("serialNumber", stringOperations);
	comboboxes.put("caption", stringOperations);
	comboboxes.put("description", stringOperations);
	comboboxes.put("universalId", stringOperations);
	comboboxes.put("deviceInstance", stringOperations);
	comboboxes.put("deviceStatus", stringOperations);
	comboboxes.put("pmStatus", stringOperations);
	comboboxes.put("hotSwappable", boolOperations);
	comboboxes.put("replaceable", boolOperations);
	comboboxes.put("removable", boolOperations);
	comboboxes.put("name", stringOperations);
	comboboxes.put("firmwareMajorVersion",
		Operation.getOperationsByType(Operation.DataType.VERSION));
	comboboxes.put("majorVersion",
		Operation.getOperationsByType(Operation.DataType.VERSION));
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_devices_id_seq")
    @SequenceGenerator(name = "financial_devices_id_seq", sequenceName = "financial_devices_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("xfs_class asc")
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "financial_device_xfs_component", joinColumns = { @JoinColumn(name = "financial_device_id") }, inverseJoinColumns = { @JoinColumn(name = "xfs_component_id") })
    private Set<XfsComponent> xfsComponents = new HashSet<XfsComponent>();

    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("jxfs_class asc")
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "financial_device_jxfs_component", joinColumns = { @JoinColumn(name = "financial_device_id") }, inverseJoinColumns = { @JoinColumn(name = "jxfs_component_id") })
    private Set<JxfsComponent> jxfsComponents = new HashSet<JxfsComponent>();

    @Column(name = "device_instance", length = 150)
    private String deviceInstance;

    @Column(name = "device_status", length = 150)
    private String deviceStatus;

    @Column(name = "hot_swappable")
    private Boolean hotSwappable;

    @Column(name = "removable")
    private Boolean removable;

    @Column(name = "replaceable")
    private Boolean replaceable;

    @Column(name = "pm_status", length = 150)
    private String pmStatus;

    @Column(name = "universal_id", length = 150)
    private String universalId;

    @Column(name = "model", length = 150)
    private String model;

    @Column(name = "variant", length = 150)
    private String variant;

    @Column(name = "serial_number", length = 150)
    private String serialNumber;

    @Column(name = "name", length = 300)
    private String name;

    @Column(name = "caption", length = 300)
    private String caption;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "manufacturer", length = 300)
    private String manufacturer;

    @Column(name = "firmware_version", length = 300)
    private String firmwareVersion;

    @Column(name = "version", length = 300)
    private String version;

    public FinancialDevice() {
    }

    public FinancialDevice(Device device) {
	this.setFirmwareVersion(device.getFirmwareVersion());
	this.setVersion(device.getVersion());
	this.caption = device.getCaption();
	this.description = device.getDescription();
	this.deviceInstance = device.getDeviceInstance();
	this.deviceStatus = device.getDeviceStatus();
	this.hotSwappable = Boolean.parseBoolean(device.getHotSwappable());
	this.model = device.getModel();
	this.name = device.getName();
	this.pmStatus = device.getPmStatus();
	this.removable = Boolean.parseBoolean(device.getRemovable());
	this.replaceable = Boolean.parseBoolean(device.getReplaceable());
	this.serialNumber = device.getSerialNumber();
	this.universalId = device.getUniversalID();
	this.variant = device.getVariant();
	// TODO
	// No xfs components?
    }

    public FinancialDevice(FinancialDevicePojo device) {
	this.setFirmwareVersion(Utils.unescapeJsonChain(device
		.getFirmwareversion()));
	this.setVersion(Utils.unescapeJsonChain(device.getVersion()));
	this.caption = device.getCaption();
	this.description = device.getDescription();
	this.deviceInstance = device.getDeviceinstance();
	this.deviceStatus = device.getDevicestatus();
	this.hotSwappable = Boolean.parseBoolean(device.getHotswappable());
	this.model = device.getModel();
	this.name = device.getName();
	this.pmStatus = device.getPmstatus();
	this.removable = Boolean.parseBoolean(device.getRemovable());
	this.replaceable = Boolean.parseBoolean(device.getReplaceable());
	// if ((device.getSerialnumber() != null)
	// && (device.getSerialnumber().length() > 0)
	// && (!device.getSerialnumber().equals("null"))) {
	this.serialNumber = Utils.unescapeJsonChain(device.getSerialnumber());
	// }
	this.universalId = Utils.unescapeJsonChain(device.getUniversalid());
	this.variant = device.getVariant();
    }

    /**
     * @return the comboboxes
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
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
     * @return the model
     */
    public String getModel() {
	return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * @return the variant
     */
    public String getVariant() {
	return variant;
    }

    /**
     * @param variant
     *            the variant to set
     */
    public void setVariant(String variant) {
	this.variant = variant;
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
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the terminal
     */
    public Terminal getTerminal() {
	return terminal;
    }

    /**
     * @param terminal
     *            the terminal to set
     */
    public void setTerminal(Terminal terminal) {
	this.terminal = terminal;
    }

    /**
     * @return the xfsComponents
     */
    public Set<XfsComponent> getXfsComponents() {
	return xfsComponents;
    }

    /**
     * @param xfsComponents
     *            the xfsComponents to set
     */
    public void setXfsComponents(Set<XfsComponent> xfsComponents) {
	this.xfsComponents = xfsComponents;
    }

    /**
     * @return the firmwareVersion
     */
    public String getFirmwareVersion() {
	return firmwareVersion;
    }

    /**
     * @return the version
     */
    public String getVersion() {
	return version;
    }

    /**
     * @param firmwareVersion
     *            the firmwareVersion to set
     */
    public void setFirmwareVersion(String firmwareVersion) {
	this.firmwareVersion = firmwareVersion;
    }

    /**
     * @return the firmware name and version concatenated
     */
    public String getFirmwareNameVersion() {
	return name + " (V. " + getFirmwareVersion() + ")";
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(String version) {
	this.version = version;
    }

    /**
     * @return the name and version concatenated
     */
    public String getNameVersion() {
	return name + " (V. " + getVersion() + ")";
    }

    /**
     * @return the deviceInstance
     */
    public String getDeviceInstance() {
	return deviceInstance;
    }

    /**
     * @param deviceInstance
     *            the deviceInstance to set
     */
    public void setDeviceInstance(String deviceInstance) {
	this.deviceInstance = deviceInstance;
    }

    /**
     * @return the deviceStatus
     */
    public String getDeviceStatus() {
	return deviceStatus;
    }

    /**
     * @param deviceStatus
     *            the deviceStatus to set
     */
    public void setDeviceStatus(String deviceStatus) {
	this.deviceStatus = deviceStatus;
    }

    /**
     * @return the hotSwappable
     */
    public Boolean getHotSwappable() {
	return hotSwappable;
    }

    /**
     * @param hotSwappable
     *            the hotSwappable to set
     */
    public void setHotSwappable(Boolean hotSwappable) {
	this.hotSwappable = hotSwappable;
    }

    /**
     * @return the removable
     */
    public Boolean getRemovable() {
	return removable;
    }

    /**
     * @param removable
     *            the removable to set
     */
    public void setRemovable(Boolean removable) {
	this.removable = removable;
    }

    /**
     * @return the replaceable
     */
    public Boolean getReplaceable() {
	return replaceable;
    }

    /**
     * @param replaceable
     *            the replaceable to set
     */
    public void setReplaceable(Boolean replaceable) {
	this.replaceable = replaceable;
    }

    /**
     * @return the pmStatus
     */
    public String getPmStatus() {
	return pmStatus;
    }

    /**
     * @param pmStatus
     *            the pmStatus to set
     */
    public void setPmStatus(String pmStatus) {
	this.pmStatus = pmStatus;
    }

    /**
     * @return the universalId
     */
    public String getUniversalId() {
	return universalId;
    }

    /**
     * @param universalId
     *            the universalId to set
     */
    public void setUniversalId(String universalId) {
	this.universalId = universalId;
    }

    /**
     * @return the caption
     */
    public String getCaption() {
	return caption;
    }

    /**
     * @param caption
     *            the caption to set
     */
    public void setCaption(String caption) {
	this.caption = caption;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
	return manufacturer;
    }

    /**
     * @param manufacturer
     *            the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public Set<JxfsComponent> getJxfsComponents() {
	return jxfsComponents;
    }

    public void setJxfsComponents(Set<JxfsComponent> jxfsComponents) {
	this.jxfsComponents = jxfsComponents;
    }
}