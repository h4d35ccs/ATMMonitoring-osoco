package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ncr.agent.baseData.vendor.utils.FinancialPackagePojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "software_aggregates", uniqueConstraints = { @UniqueConstraint(columnNames = {
	"name", "major_version", "minor_version", "build_version",
	"revision_version", "remaining_version" }) })
public class SoftwareAggregate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "software_aggregates_id_seq")
    @SequenceGenerator(name = "software_aggregates_id_seq", sequenceName = "software_aggregates_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "numbr")
    private Integer number;

    @Column(name = "profile", length = 500)
    private String profile;

    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

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

    // We don't need this for now
    // @ManyToMany(cascade = CascadeType.REFRESH)
    // @Cascade(CascadeType.ALL)
    // @JoinTable(name = "terminal_software_aggregate", joinColumns = {
    // @JoinColumn(name = "software_aggregate_id") }, inverseJoinColumns = {
    // @JoinColumn(name = "terminal_id") })
    // private Set<Terminal> terminals;

    public SoftwareAggregate() {
    }

    public SoftwareAggregate(ncr.inventory.data.Package pkg) {
	this.setVersion(pkg.getVersion());
	this.description = pkg.getDescription();
	this.name = pkg.getName();
	this.profile = pkg.getProfile();
	// TODO
	// No number?
    }

    public SoftwareAggregate(FinancialPackagePojo pkg) {
	this.setVersion(pkg.getVersion());
	this.description = pkg.getDescription();
	this.name = pkg.getName();
	this.profile = pkg.getProfile();
	// TODO
	// No number?
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
     * @return the profile
     */
    public String getProfile() {
	return profile;
    }

    /**
     * @param profile
     *            the profile to set
     */
    public void setProfile(String profile) {
	this.profile = profile;
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
     * @return the number
     */
    public Integer getNumber() {
	return number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(Integer number) {
	this.number = number;
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
}