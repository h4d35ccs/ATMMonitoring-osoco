package com.ncr.ATMMonitoring.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.agent.baseData.os.module.ProductPojo;

/**
 * The Software Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "software")
public class Software {

    /** The logger. */
    static private Logger logger = Logger.getLogger(Software.class.getName());

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	comboboxes.put("caption", stringOperations);
	comboboxes.put("name", stringOperations);
	comboboxes.put("majorVersion",
		Operation.getOperationsByType(Operation.DataType.VERSION));
	comboboxes.put("description", stringOperations);
	comboboxes.put("identifyingNumber", stringOperations);
	comboboxes.put("productId", stringOperations);
	comboboxes.put("packageName", stringOperations);
	comboboxes.put("localPackage", stringOperations);
	comboboxes.put("vendor", stringOperations);
	comboboxes.put("language", stringOperations);
	comboboxes.put("installDate",
		Operation.getOperationsByType(Operation.DataType.DATE));
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "software_id_seq")
    @SequenceGenerator(name = "software_id_seq", sequenceName = "software_id_seq", allocationSize = 1)
    private Integer id;

    /** The caption. */
    @Column(name = "caption")
    @Type(type = "text")
    private String caption;

    /** The name. */
    @Column(name = "name")
    @Type(type = "text")
    private String name;

    /** The description. */
    @Column(name = "description")
    @Type(type = "text")
    private String description;

    /** The identifying number. */
    @Column(name = "identifying_number")
    @Type(type = "text")
    private String identifyingNumber;

    /** The install date. */
    @Column(name = "install_date")
    private Date installDate = new Date();

    /** The vendor. */
    @Column(name = "vendor")
    @Type(type = "text")
    private String vendor;

    /** The major version. */
    @Column(name = "major_version")
    private Integer majorVersion;

    /** The minor version. */
    @Column(name = "minor_version")
    private Integer minorVersion;

    /** The build version. */
    @Column(name = "build_version")
    private Integer buildVersion;

    /** The revision version. */
    @Column(name = "revision_version")
    private Integer revisionVersion;

    /** The remaining version. */
    @Column(name = "remaining_version")
    @Type(type = "text")
    private String remainingVersion;

    /** The language. */
    @Column(name = "language")
    @Type(type = "text")
    private String language;

    /** The local package. */
    @Column(name = "local_package")
    @Type(type = "text")
    private String localPackage;

    /** The package name. */
    @Column(name = "package_name")
    @Type(type = "text")
    private String packageName;

    /** The product id. */
    @Column(name = "product_id")
    @Type(type = "text")
    private String productId;

    /** The sw type. */
    @Column(name = "sw_type")
    @Type(type = "text")
    private String swType;

    // We don't need this for now
    // @ManyToMany
    // @Cascade(CascadeType.ALL)
    // @JoinTable(name = "terminal_config_software", joinColumns = {
    // @JoinColumn(name = "software_id") }, inverseJoinColumns = {
    // @JoinColumn(name = "terminal_config_id") })
    // private Set<TerminalConfig> configs;

    /**
     * Instantiates a new software.
     */
    public Software() {
    }

    /**
     * Instantiates a new software with the given software data from the agent.
     * 
     * @param sw
     *            the sw
     */
    public Software(ProductPojo sw) {
	this.setVersion(sw.getVersion());
	this.caption = sw.getCaption();
	this.description = sw.getDescription();
	this.identifyingNumber = sw.getIdentifyingNumber();
	if ((sw.getInstallDate() != null)
		&& (sw.getInstallDate().length() >= 8)) {
	    try {
		this.installDate = new SimpleDateFormat("yyyyMMdd").parse(sw
			.getInstallDate().substring(0, 8));
	    } catch (ParseException e) {
		logger.error("Couldn't parse Product date.", e);
		this.installDate = null;
	    }
	}
	// this.language = sw.getLanguage();
	// this.localPackage = sw.getLocalPackage();
	this.name = sw.getName();
	// this.packageName = sw.getPackageName();
	// this.productId = sw.getProductID();
	this.swType = sw.getSwtype();
	this.vendor = sw.getVendor();
    }

    /**
     * Gets the comboboxes data for the query GUI.
     *
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the caption.
     *
     * @return the caption
     */
    public String getCaption() {
	return caption;
    }

    /**
     * Sets the caption.
     *
     * @param caption the caption to set
     */
    public void setCaption(String caption) {
	this.caption = caption;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the identifying number.
     *
     * @return the identifyingNumber
     */
    public String getIdentifyingNumber() {
	return identifyingNumber;
    }

    /**
     * Sets the identifying number.
     *
     * @param identifyingNumber the identifyingNumber to set
     */
    public void setIdentifyingNumber(String identifyingNumber) {
	this.identifyingNumber = identifyingNumber;
    }

    /**
     * Gets the install date.
     *
     * @return the installDate
     */
    public Date getInstallDate() {
	return installDate;
    }

    /**
     * Sets the install date.
     *
     * @param installDate the installDate to set
     */
    public void setInstallDate(Date installDate) {
	this.installDate = installDate;
    }

    /**
     * Gets the vendor.
     *
     * @return the vendor
     */
    public String getVendor() {
	return vendor;
    }

    /**
     * Sets the vendor.
     *
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor) {
	this.vendor = vendor;
    }

    /**
     * Gets the version.
     *
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
     * Sets the version.
     *
     * @param version the complete version to set
     */
    public void setVersion(String version) {
	String[] versions = version.split("\\.", 5);
	switch (versions.length) {
	case 5:
	    setRemainingVersion(versions[4]);
	case 4:
	    try {
		setRevisionVersion(new Integer(versions[3]));
	    } catch (NumberFormatException e) {
		setRemainingVersion(versions[3]);
	    }
	case 3:
	    try {
		setBuildVersion(new Integer(versions[2]));
	    } catch (NumberFormatException e) {
		setRemainingVersion(versions[2]);
	    }
	case 2:
	    try {
		setMinorVersion(new Integer(versions[1]));
	    } catch (NumberFormatException e) {
		setRemainingVersion(versions[1]);
	    }
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
     * Gets the name version.
     *
     * @return the name and version concatenated
     */
    public String getNameVersion() {
	return name + " (V. " + getVersion() + ")";
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public String getLanguage() {
	return language;
    }

    /**
     * Sets the language.
     *
     * @param language the language to set
     */
    public void setLanguage(String language) {
	this.language = language;
    }

    /**
     * Gets the local package.
     *
     * @return the localPackage
     */
    public String getLocalPackage() {
	return localPackage;
    }

    /**
     * Sets the local package.
     *
     * @param localPackage the localPackage to set
     */
    public void setLocalPackage(String localPackage) {
	this.localPackage = localPackage;
    }

    /**
     * Gets the package name.
     *
     * @return the packageName
     */
    public String getPackageName() {
	return packageName;
    }

    /**
     * Sets the package name.
     *
     * @param packageName the packageName to set
     */
    public void setPackageName(String packageName) {
	this.packageName = packageName;
    }

    /**
     * Gets the product id.
     *
     * @return the productId
     */
    public String getProductId() {
	return productId;
    }

    /**
     * Sets the product id.
     *
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
	this.productId = productId;
    }

    /**
     * Gets the major version.
     *
     * @return the majorVersion
     */
    public Integer getMajorVersion() {
	return majorVersion;
    }

    /**
     * Gets the minor version.
     *
     * @return the minorVersion
     */
    public Integer getMinorVersion() {
	return minorVersion;
    }

    /**
     * Gets the builds the version.
     *
     * @return the buildVersion
     */
    public Integer getBuildVersion() {
	return buildVersion;
    }

    /**
     * Gets the revision version.
     *
     * @return the revisionVersion
     */
    public Integer getRevisionVersion() {
	return revisionVersion;
    }

    /**
     * Sets the major version.
     *
     * @param majorVersion the majorVersion to set
     */
    public void setMajorVersion(Integer majorVersion) {
	this.majorVersion = majorVersion;
    }

    /**
     * Sets the minor version.
     *
     * @param minorVersion the minorVersion to set
     */
    public void setMinorVersion(Integer minorVersion) {
	this.minorVersion = minorVersion;
    }

    /**
     * Sets the builds the version.
     *
     * @param buildVersion the buildVersion to set
     */
    public void setBuildVersion(Integer buildVersion) {
	this.buildVersion = buildVersion;
    }

    /**
     * Sets the revision version.
     *
     * @param revisionVersion the revisionVersion to set
     */
    public void setRevisionVersion(Integer revisionVersion) {
	this.revisionVersion = revisionVersion;
    }

    /**
     * Gets the remaining version.
     *
     * @return the remainingVersion
     */
    public String getRemainingVersion() {
	return remainingVersion;
    }

    /**
     * Sets the remaining version.
     *
     * @param remainingVersion the remainingVersion to set
     */
    public void setRemainingVersion(String remainingVersion) {
	this.remainingVersion = remainingVersion;
    }

    /**
     * Gets the sw type.
     *
     * @return the swType
     */
    public String getSwType() {
	return swType;
    }

    /**
     * Sets the sw type.
     *
     * @param swType the swType to set
     */
    public void setSwType(String swType) {
	this.swType = swType;
    }
}