package com.ncr.ATMMonitoring.pojo;

import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.agent.baseData.os.module.OperatingSystemPojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "operating_systems")
public class OperatingSystem {

    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	comboboxes.put("osType", stringOperations);
	comboboxes.put("name", stringOperations);
	comboboxes.put("majorVersion",
		Operation.getOperationsByType(Operation.DataType.VERSION));
	comboboxes.put("serialNumber", stringOperations);
	comboboxes.put("servicePackMajorVersion",
		Operation.getOperationsByType(Operation.DataType.VERSION));
	comboboxes.put("osLanguage", stringOperations);
	comboboxes.put("manufacturer", stringOperations);
	comboboxes.put("organization", stringOperations);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operating_systems_id_seq")
    @SequenceGenerator(name = "operating_systems_id_seq", sequenceName = "operating_systems_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "os_type", length = 150)
    private String osType;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "serial_number", length = 50, unique = true)
    private String serialNumber;

    @Column(name = "manufacturer", length = 50)
    private String manufacturer;

    @Column(name = "major_version")
    private Integer majorVersion;

    @Column(name = "minor_version")
    private Integer minorVersion;

    @Column(name = "build_version")
    private Integer buildVersion;

    @Column(name = "revision_version")
    private Integer revisionVersion;

    @Column(name = "remaining_version", length = 20)
    private String remainingVersion;

    @Column(name = "service_pack_major_version")
    private Integer servicePackMajorVersion;

    @Column(name = "service_pack_minor_version")
    private Integer servicePackMinorVersion;

    @Column(name = "service_pack_build_version")
    private Integer servicePackBuildVersion;

    @Column(name = "service_pack_revision_version")
    private Integer servicePackRevisionVersion;

    @Column(name = "service_pack_remaining_version", length = 20)
    private String servicePackRemainingVersion;

    @Column(name = "organization", length = 50)
    private String organization;

    @Column(name = "os_language", length = 10)
    private String osLanguage;

    // We don't need this for now
    // @ManyToMany
    // @Cascade(CascadeType.ALL)
    // @JoinTable(name = "t_config_op_system", joinColumns = {
    // @JoinColumn(name = "operating_system_id") }, inverseJoinColumns = {
    // @JoinColumn(name = "terminal_config_id") })
    // private Set<TerminalConfig> configs;

    public OperatingSystem() {
    }

    public OperatingSystem(ncr.inventory.data.OperatingSystem os) {
	this.setVersion(os.getVersion());
	this.setServicePackVersion(os.getSpversion());
	this.manufacturer = os.getManufacturer();
	this.name = os.getName();
	this.organization = os.getOrganization();
	this.osLanguage = os.getOslanguage();
	this.osType = os.getOstype();
	this.serialNumber = os.getSerialnumber();
    }

    public OperatingSystem(OperatingSystemPojo os) {
	if (os.getVersion() != null) {
	    this.setVersion(os.getVersion());
	}
	if (os.getSpversion() != null) {
	    this.setServicePackVersion(os.getSpversion());
	}
	this.manufacturer = os.getManufacturer();
	this.name = os.getName();
	this.organization = os.getOrganization();
	this.osLanguage = os.getOslanguage();
	this.osType = os.getOstype();
	if ((os.getSerialnumber() != null)
		&& (os.getSerialnumber().length() > 0)
		&& !os.getSerialnumber().equals("null")) {
	    this.serialNumber = os.getSerialnumber();
	}
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
     * @return the remainingVersion
     */
    public String getRemainingVersion() {
	return remainingVersion;
    }

    /**
     * @param remainingVersion
     *            the remainingVersion to set
     */
    public void setRemainingVersion(String remainingVersion) {
	this.remainingVersion = remainingVersion;
    }

    /**
     * @return the oSType
     */
    public String getOsType() {
	return osType;
    }

    /**
     * @param oSType
     *            the oSType to set
     */
    public void setOsType(String oSType) {
	osType = oSType;
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

    /**
     * @return the servicePackMajorVersion
     */
    public Integer getServicePackMajorVersion() {
	return servicePackMajorVersion;
    }

    /**
     * @param servicePackMajorVersion
     *            the servicePackMajorVersion to set
     */
    public void setServicePackMajorVersion(Integer servicePackMajorVersion) {
	this.servicePackMajorVersion = servicePackMajorVersion;
    }

    /**
     * @return the servicePackMinorVersion
     */
    public Integer getServicePackMinorVersion() {
	return servicePackMinorVersion;
    }

    /**
     * @param servicePackMinorVersion
     *            the servicePackMinorVersion to set
     */
    public void setServicePackMinorVersion(Integer servicePackMinorVersion) {
	this.servicePackMinorVersion = servicePackMinorVersion;
    }

    /**
     * @return the servicePackBuildVersion
     */
    public Integer getServicePackBuildVersion() {
	return servicePackBuildVersion;
    }

    /**
     * @param servicePackBuildVersion
     *            the servicePackBuildVersion to set
     */
    public void setServicePackBuildVersion(Integer servicePackBuildVersion) {
	this.servicePackBuildVersion = servicePackBuildVersion;
    }

    /**
     * @return the servicePackRevisionVersion
     */
    public Integer getServicePackRevisionVersion() {
	return servicePackRevisionVersion;
    }

    /**
     * @param servicePackRevisionVersion
     *            the servicePackRevisionVersion to set
     */
    public void setServicePackRevisionVersion(Integer servicePackRevisionVersion) {
	this.servicePackRevisionVersion = servicePackRevisionVersion;
    }

    /**
     * @return the servicePackRemainingVersion
     */
    public String getServicePackRemainingVersion() {
	return servicePackRemainingVersion;
    }

    /**
     * @param servicePackRemainingVersion
     *            the servicePackRemainingVersion to set
     */
    public void setServicePackRemainingVersion(
	    String servicePackRemainingVersion) {
	this.servicePackRemainingVersion = servicePackRemainingVersion;
    }

    /**
     * @return the Service Pack version complete
     */
    public String getServicePackVersion() {
	String version = null;
	if (servicePackMajorVersion != null) {
	    version = servicePackMajorVersion.toString();
	    if (servicePackMinorVersion != null) {
		version += "." + servicePackMinorVersion.toString();
		if (servicePackBuildVersion != null) {
		    version += "." + servicePackBuildVersion.toString();
		    if (servicePackRevisionVersion != null) {
			version += "." + servicePackRevisionVersion.toString();
			if (servicePackRemainingVersion != null) {
			    version += "." + servicePackRemainingVersion;
			}
		    }
		}
	    }
	} else {
	    if ((servicePackRemainingVersion != null)
		    && (servicePackRemainingVersion != "")) {
		version = servicePackRemainingVersion;
	    }
	}
	return version;
    }

    /**
     * @param version
     *            the complete Service Pack version to set
     */
    public void setServicePackVersion(String version) {
	String[] versions = version.split("\\.", 5);
	switch (versions.length) {
	case 5:
	    setServicePackRemainingVersion(versions[4]);
	case 4:
	    setServicePackRevisionVersion(new Integer(versions[3]));
	case 3:
	    setServicePackBuildVersion(new Integer(versions[2]));
	case 2:
	    setServicePackMinorVersion(new Integer(versions[1]));
	    setServicePackMajorVersion(new Integer(versions[0]));
	    break;
	case 1:
	    try {
		setServicePackMajorVersion(new Integer(versions[0]));
	    } catch (NumberFormatException e) {
		setServicePackRemainingVersion(versions[0]);
	    }
	case 0:
	    break;
	}
    }

    /**
     * @return the organization
     */
    public String getOrganization() {
	return organization;
    }

    /**
     * @param organization
     *            the organization to set
     */
    public void setOrganization(String organization) {
	this.organization = organization;
    }

    /**
     * @return the oSLanguage
     */
    public String getOsLanguage() {
	return osLanguage;
    }

    /**
     * @param oSLanguage
     *            the oSLanguage to set
     */
    public void setOsLanguage(String oSLanguage) {
	osLanguage = oSLanguage;
    }
}