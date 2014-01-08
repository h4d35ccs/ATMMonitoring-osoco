package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import com.ncr.agent.baseData.vendor.utils.FinancialPackagePojo;

/**
 * The SoftwareAggregate Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "software_aggregates", uniqueConstraints = { @UniqueConstraint(columnNames = {
	"name", "major_version", "minor_version", "build_version",
	"revision_version", "remaining_version" }) })
public class SoftwareAggregate extends Auditable {

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "software_aggregates_id_seq")
    @SequenceGenerator(name = "software_aggregates_id_seq", sequenceName = "software_aggregates_id_seq", allocationSize = 1)
    private Integer id;

    /** The number. */
    @Column(name = "numbr")
    private Integer number;

    /** The profile. */
    @Column(name = "profile")
    @Type(type = "text")
    private String profile;

    /** The name. */
    @Column(name = "name")
    @Type(type = "text")
    private String name;

    /** The description. */
    @Column(name = "description")
    @Type(type = "text")
    private String description;

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

    // We don't need this for now
    // @ManyToMany(cascade = CascadeType.REFRESH)
    // @Cascade(CascadeType.ALL)
    // @JoinTable(name = "terminal_software_aggregate", joinColumns = {
    // @JoinColumn(name = "software_aggregate_id") }, inverseJoinColumns = {
    // @JoinColumn(name = "terminal_id") })
    // private Set<Terminal> terminals;

    /**
     * Instantiates a new software aggregate.
     */
    public SoftwareAggregate() {
    }

    /**
     * Instantiates a new software aggregate with the given software aggregate
     * data from the agent.
     * 
     * @param pkg
     *            the pkg
     */
    public SoftwareAggregate(FinancialPackagePojo pkg) {
	this.setVersion(pkg.getVersion());
	this.description = pkg.getDescription();
	this.name = pkg.getName();
	this.profile = pkg.getProfile();
	// TODO
	// No number?
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
     * Gets the profile.
     *
     * @return the profile
     */
    public String getProfile() {
	return profile;
    }

    /**
     * Sets the profile.
     *
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
	this.profile = profile;
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
     * Gets the number.
     *
     * @return the number
     */
    public Integer getNumber() {
	return number;
    }

    /**
     * Sets the number.
     *
     * @param number the number to set
     */
    public void setNumber(Integer number) {
	this.number = number;
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
     * Gets the name version.
     *
     * @return the name and version concatenated
     */
    public String getNameVersion() {
	return name + " (V. " + getVersion() + ")";
    }
}