package com.ncr.ATMMonitoring.pojo;

import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ncr.inventory.data.Device;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Operation;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "financial_devices")
public class FinancialDevice {

    private static final Map<String, Map> comboboxes;

    static {
		comboboxes = new TreeMap<String, Map>();
		Map<String, Map> stringOperations = Operation.getOperationsByType(Operation.DataType.STRING);
		Map<String, Map> boolOperations = Operation.getOperationsByType(Operation.DataType.BOOLEAN);
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
		comboboxes.put("firmwareMajorVersion",Operation.getOperationsByType(Operation.DataType.VERSION));
		comboboxes.put("majorVersion",Operation.getOperationsByType(Operation.DataType.VERSION));
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_devices_id_seq")
    @SequenceGenerator(name = "financial_devices_id_seq", sequenceName = "financial_devices_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    //@Cascade(CascadeType.ALL) - Eva 13/03/2013 - Generates an "No row with the given identifier exists..."
    @Cascade(CascadeType.REFRESH)
    //<--
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @OneToMany(mappedBy = "financialDevice", fetch = FetchType.LAZY)
    @OrderBy("xfs_class asc")
    @Cascade(CascadeType.ALL)
    private Set<XfsComponent> xfsComponents = new HashSet<XfsComponent>();

    @Column(name = "device_instance", length = 100)
    private String deviceInstance;

    @Column(name = "device_status", length = 50)
    private String deviceStatus;

    @Column(name = "hot_swappable")
    private Boolean hotSwappable;

    @Column(name = "removable")
    private Boolean removable;

    @Column(name = "replaceable")
    private Boolean replaceable;

    @Column(name = "pm_status", length = 100)
    private String pmStatus;

    @Column(name = "universal_id", length = 100)
    private String universalId;

    @Column(name = "model", length = 100)
    private String model;

    @Column(name = "variant", length = 100)
    private String variant;

    /*@Column(name = "serial_number", unique = true, length = 100)
    private String serialNumber;*/
    
    @Column(name = "serial_number", length = 100)
    private String serialNumber;

    @Column(name = "name", length = 300)
    private String name;

    @Column(name = "caption", length = 300)
    private String caption;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "manufacturer", length = 300)
    private String manufacturer;

    @Column(name = "firmware_major_version")
    private Integer firmwareMajorVersion;

    @Column(name = "firmware_minor_version")
    private Integer firmwareMinorVersion;

    @Column(name = "firmware_build_version")
    private Integer firmwareBuildVersion;

    @Column(name = "firmware_revision_version")
    private Integer firmwareRevisionVersion;

    @Column(name = "firmware_remaining_version", length = 100)
    private String firmwareRemainingVersion;

    @Column(name = "major_version")
    private Integer majorVersion;

    @Column(name = "minor_version")
    private Integer minorVersion;

    @Column(name = "build_version")
    private Integer buildVersion;

    @Column(name = "revision_version")
    private Integer revisionVersion;

    @Column(name = "remaining_version", length = 100)
    private String remainingVersion;

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
     * @return the firmwareMajorVersion
     */
    public Integer getFirmwareMajorVersion() {
    	return firmwareMajorVersion;
    }

    /**
     * @return the firmwareMinorVersion
     */
    public Integer getFirmwareMinorVersion() {
    	return firmwareMinorVersion;
    }

    /**
     * @return the firmwareBuildVersion
     */
    public Integer getFirmwareBuildVersion() {
    	return firmwareBuildVersion;
    }

    /**
     * @return the firmwareRevisionVersion
     */
    public Integer getFirmwareRevisionVersion() {
    	return firmwareRevisionVersion;
    }

    /**
     * @return the firmwareRemainingVersion
     */
    public String getFirmwareRemainingVersion() {
    	return firmwareRemainingVersion;
    }

    /**
     * @return the majorVersion
     */
    public Integer getMajorVersion() {
    	return majorVersion;
    }

    /**
     * @return the minorVersion
     */
    public Integer getMinorVersion() {
    	return minorVersion;
    }

    /**
     * @return the buildVersion
     */
    public Integer getBuildVersion() {
    	return buildVersion;
    }

    /**
     * @return the revisionVersion
     */
    public Integer getRevisionVersion() {
    	return revisionVersion;
    }

    /**
     * @return the remainingVersion
     */
    public String getRemainingVersion() {
    	return remainingVersion;
    }

    /**
     * @param firmwareMajorVersion
     *            the firmwareMajorVersion to set
     */
    public void setFirmwareMajorVersion(Integer firmwareMajorVersion) {
    	this.firmwareMajorVersion = firmwareMajorVersion;
    }

    /**
     * @param firmwareMinorVersion
     *            the firmwareMinorVersion to set
     */
    public void setFirmwareMinorVersion(Integer firmwareMinorVersion) {
    	this.firmwareMinorVersion = firmwareMinorVersion;
    }

    /**
     * @param firmwareBuildVersion
     *            the firmwareBuildVersion to set
     */
    public void setFirmwareBuildVersion(Integer firmwareBuildVersion) {
    	this.firmwareBuildVersion = firmwareBuildVersion;
    }

    /**
     * @param firmwareRevisionVersion
     *            the firmwareRevisionVersion to set
     */
    public void setFirmwareRevisionVersion(Integer firmwareRevisionVersion) {
    	this.firmwareRevisionVersion = firmwareRevisionVersion;
    }

    /**
     * @param firmwareRemainingVersion
     *            the firmwareRemainingVersion to set
     */
    public void setFirmwareRemainingVersion(String firmwareRemainingVersion) {
    	this.firmwareRemainingVersion = firmwareRemainingVersion;
    }

    /**
     * @return the firmware version complete
     */
    public String getFirmwareVersion() {
    	/*String version = null;
		if (firmwareMajorVersion != null) {
		    version = firmwareMajorVersion.toString();
		    if (firmwareMinorVersion != null) {
			version += "." + firmwareMinorVersion.toString();
			if (firmwareBuildVersion != null) {
			    version += "." + firmwareBuildVersion.toString();
			    if (firmwareRevisionVersion != null) {
				version += "." + firmwareRevisionVersion.toString();
				if (firmwareRemainingVersion != null) {
				    version += "." + firmwareRemainingVersion;
				}
			    }
			}
		    }
		} else {
		    if ((firmwareRemainingVersion != null)
			    && (firmwareRemainingVersion != "")) {
			version = firmwareRemainingVersion;
		    }
		}
		return version;*/
    	
    	return getFirmwareRemainingVersion();
    }

    /**
     * @param version
     *            the complete firmware version to set
     */
    public void setFirmwareVersion(String version) {
		/*String[] versions = version.split("\\.", 5);
		switch (versions.length) {
			case 5:
			    setFirmwareRemainingVersion(versions[4]);
			case 4:
			    setFirmwareRevisionVersion(new Integer(versions[3]));
			case 3:
			    setFirmwareBuildVersion(new Integer(versions[2]));
			case 2:
			    setFirmwareMinorVersion(new Integer(versions[1]));
			    setFirmwareMajorVersion(new Integer(versions[0]));
			    break;
			case 1:
			    try {
			    	setFirmwareMajorVersion(new Integer(versions[0]));
			    } catch (NumberFormatException e) {
			    	setFirmwareRemainingVersion(versions[0]);
			    }
			case 0:
			    break;
		}*/
    	
    	setFirmwareRemainingVersion(version);
    }

    /**
     * @return the firmware name and version concatenated
     */
    public String getFirmwareNameVersion() {
    	return name + " (V. " + getFirmwareVersion() + ")";
    }

    /**
     * @param majorVersion
     *            the majorVersion to set
     */
    public void setMajorVersion(Integer majorVersion) {
	this.majorVersion = majorVersion;
    }

    /**
     * @param minorVersion
     *            the minorVersion to set
     */
    public void setMinorVersion(Integer minorVersion) {
	this.minorVersion = minorVersion;
    }

    /**
     * @param buildVersion
     *            the buildVersion to set
     */
    public void setBuildVersion(Integer buildVersion) {
	this.buildVersion = buildVersion;
    }

    /**
     * @param revisionVersion
     *            the revisionVersion to set
     */
    public void setRevisionVersion(Integer revisionVersion) {
	this.revisionVersion = revisionVersion;
    }

    /**
     * @param remainingVersion
     *            the remainingVersion to set
     */
    public void setRemainingVersion(String remainingVersion) {
	this.remainingVersion = remainingVersion;
    }

    /**
     * @return the version complete
     */
    public String getVersion() {
	String version = null;
	if (majorVersion != null) {
	    version = majorVersion.toString();
	    if (minorVersion != null) {
		version += "." + minorVersion.toString();
		if (buildVersion != null) {
		    version += "." + buildVersion.toString();
		    if (revisionVersion != null) {
			version += "." + revisionVersion.toString();
			if (remainingVersion != null) {
			    version += "." + remainingVersion;
			}
		    }
		}
	    }
	} else {
	    if ((remainingVersion != null) && (remainingVersion != "")) {
		version = remainingVersion;
	    }
	}
	return version;
    }

    /**
     * @param version
     *            the complete version to set
     */
    public void setVersion(String version) {
		String[] versions = version.split("\\.", 5);
		switch (versions.length) {
		case 5:
		    setRemainingVersion(versions[4]);
		case 4:
		    setRevisionVersion(new Integer(versions[3]));
		case 3:
		    setBuildVersion(new Integer(versions[2]));
		case 2:
		    setMinorVersion(new Integer(versions[1]));
		    setMajorVersion(new Integer(versions[0]));
		    break;
		case 1:
		    try {
			setMajorVersion(new Integer(versions[0]));
		    } catch (NumberFormatException e) {
			setRemainingVersion(versions[0]);
		    }
		case 0:
		    break;
		}
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
}