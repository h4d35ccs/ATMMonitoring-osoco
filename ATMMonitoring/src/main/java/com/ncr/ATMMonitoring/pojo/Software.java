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

import ncr.inventory.data.Product;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.agent.baseData.os.module.ProductPojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "software")
public class Software {

    static private Logger logger = Logger.getLogger(Software.class.getName());

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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "software_id_seq")
    @SequenceGenerator(name = "software_id_seq", sequenceName = "software_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "caption", length = 150)
    private String caption;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "identifying_number", length = 50)
    private String identifyingNumber;

    @Column(name = "install_date")
    private Date installDate = new Date();

    @Column(name = "vendor", length = 150)
    private String vendor;

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

    @Column(name = "language", length = 10)
    private String language;

    @Column(name = "local_package", length = 50)
    private String localPackage;

    @Column(name = "package_name", length = 50)
    private String packageName;

    @Column(name = "product_id", length = 25)
    private String productId;

    @Column(name = "sw_type", length = 10)
    private String swType;

    // We don't need this for now
    // @ManyToMany
    // @Cascade(CascadeType.ALL)
    // @JoinTable(name = "terminal_config_software", joinColumns = {
    // @JoinColumn(name = "software_id") }, inverseJoinColumns = {
    // @JoinColumn(name = "terminal_config_id") })
    // private Set<TerminalConfig> configs;

    public Software() {
    }

    public Software(Product sw) {
	this.setVersion(sw.getVersion());
	this.caption = sw.getCaption();
	this.description = sw.getDescription();
	this.identifyingNumber = sw.getIdentifyingNumber();
	if (sw.getInstallDate().length() > 0) {
	    try {
		this.installDate = new SimpleDateFormat("yyyyMMdd").parse(sw
			.getInstallDate().substring(0, 8));
	    } catch (ParseException e) {
		logger.error("Couldn't parse Product date.", e);
		this.installDate = null;
	    }
	}
	this.language = sw.getLanguage();
	this.localPackage = sw.getLocalPackage();
	this.name = sw.getName();
	this.packageName = sw.getPackageName();
	this.productId = sw.getProductID();
	this.swType = sw.getSwtype();
	this.vendor = sw.getVendor();
    }

    public Software(ProductPojo sw) {
	this.setVersion(sw.getVersion());
	this.caption = sw.getCaption();
	this.description = sw.getDescription();
	this.identifyingNumber = sw.getIdentifyingNumber();
	if (sw.getInstallDate().length() > 0) {
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
     * @return the identifyingNumber
     */
    public String getIdentifyingNumber() {
	return identifyingNumber;
    }

    /**
     * @param identifyingNumber
     *            the identifyingNumber to set
     */
    public void setIdentifyingNumber(String identifyingNumber) {
	this.identifyingNumber = identifyingNumber;
    }

    /**
     * @return the installDate
     */
    public Date getInstallDate() {
	return installDate;
    }

    /**
     * @param installDate
     *            the installDate to set
     */
    public void setInstallDate(Date installDate) {
	this.installDate = installDate;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
	return vendor;
    }

    /**
     * @param vendor
     *            the vendor to set
     */
    public void setVendor(String vendor) {
	this.vendor = vendor;
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
     * @return the name and version concatenated
     */
    public String getNameVersion() {
	return name + " (V. " + getVersion() + ")";
    }

    /**
     * @return the language
     */
    public String getLanguage() {
	return language;
    }

    /**
     * @param language
     *            the language to set
     */
    public void setLanguage(String language) {
	this.language = language;
    }

    /**
     * @return the localPackage
     */
    public String getLocalPackage() {
	return localPackage;
    }

    /**
     * @param localPackage
     *            the localPackage to set
     */
    public void setLocalPackage(String localPackage) {
	this.localPackage = localPackage;
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
	return packageName;
    }

    /**
     * @param packageName
     *            the packageName to set
     */
    public void setPackageName(String packageName) {
	this.packageName = packageName;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
	return productId;
    }

    /**
     * @param productId
     *            the productId to set
     */
    public void setProductId(String productId) {
	this.productId = productId;
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
     * @return the swType
     */
    public String getSwType() {
	return swType;
    }

    /**
     * @param swType
     *            the swType to set
     */
    public void setSwType(String swType) {
	this.swType = swType;
    }
}