package com.ncr.ATMMonitoring.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

// TODO: Auto-generated Javadoc
/**
 * The Class Installation.
 *
 * @author Jorge L�pez Fern�ndez (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "installations")
public class Installation {

    /** The Constant locationClasses. */
    private static final String[] locationClasses = { "internal_lobby",
	    "internal_vestibule", "external_ttw", "external_driveup" };

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "installations_id_seq")
    @SequenceGenerator(name = "installations_id_seq", sequenceName = "installations_id_seq", allocationSize = 1)
    private Integer id;

    /** The location. */
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "location_id")
    private Location location = new Location();

    /** The lu code. */
    @Column(name = "lu_code", length = 20)
    private String luCode;

    /** The type. */
    @Column(name = "type", length = 50)
    private String type;

    /** The post. */
    @Column(name = "post", length = 30)
    private String post;

    /** The processed. */
    @Column(name = "processed")
    private Boolean processed;

    /** The start date. */
    @Column(name = "start_date")
    private Date startDate;

    /** The end date. */
    @Column(name = "end_date")
    private Date endDate;

    /** The location class. */
    @Column(name = "location_class", length = 50)
    private String locationClass;

    /** The ip. */
    @Column(name = "ip", length = 50)
    private String ip;

    // We don't need this for now
    // @OneToMany(mappedBy = "installation")
    // @Cascade(CascadeType.ALL)
    // private Set<Terminal> terminals;
    //
    // public Set<Terminal> getTerminals() {
    // return terminals;
    // }
    //
    // public void setTerminals(Set<Terminal> terminals) {
    // this.terminals = terminals;
    // }

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
     * Gets the location.
     *
     * @return the location
     */
    public Location getLocation() {
	return location;
    }

    /**
     * Sets the location.
     *
     * @param location the new location
     */
    public void setLocation(Location location) {
	this.location = location;
    }

    /**
     * Gets the lu code.
     *
     * @return the lu code
     */
    public String getLuCode() {
	return luCode;
    }

    /**
     * Sets the lu code.
     *
     * @param luCode the new lu code
     */
    public void setLuCode(String luCode) {
	this.luCode = luCode;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Gets the post.
     *
     * @return the post
     */
    public String getPost() {
	return post;
    }

    /**
     * Sets the post.
     *
     * @param post the new post
     */
    public void setPost(String post) {
	this.post = post;
    }

    /**
     * Gets the processed.
     *
     * @return the processed
     */
    public Boolean getProcessed() {
	return processed;
    }

    /**
     * Sets the processed.
     *
     * @param processed the new processed
     */
    public void setProcessed(Boolean processed) {
	this.processed = processed;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
	return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
	return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    /**
     * Gets the location class.
     *
     * @return the location class
     */
    public String getLocationClass() {
	return locationClass;
    }

    /**
     * Sets the location class.
     *
     * @param locationClass the new location class
     */
    public void setLocationClass(String locationClass) {
	this.locationClass = locationClass;
    }

    /**
     * Gets the ip.
     *
     * @return the ip
     */
    public String getIp() {
	return ip;
    }

    /**
     * Sets the ip.
     *
     * @param ip the new ip
     */
    public void setIp(String ip) {
	this.ip = ip;
    }

    /**
     * Gets the locationclasses.
     *
     * @return the locationclasses
     */
    public static String[] getLocationclasses() {
	return locationClasses;
    }

}