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

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "installations")
public class Installation {

    private static final String[] locationClasses = { "internal_lobby",
	    "internal_vestibule", "external_ttw", "external_driveup" };

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "installations_id_seq")
    @SequenceGenerator(name = "installations_id_seq", sequenceName = "installations_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "location_id")
    private Location location = new Location();

    @Column(name = "lu_code", length = 20)
    private String luCode;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "post", length = 30)
    private String post;

    @Column(name = "processed")
    private Boolean processed;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "location_class", length = 50)
    private String locationClass;

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

    public Location getLocation() {
	return location;
    }

    public void setLocation(Location location) {
	this.location = location;
    }

    public String getLuCode() {
	return luCode;
    }

    public void setLuCode(String luCode) {
	this.luCode = luCode;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getPost() {
	return post;
    }

    public void setPost(String post) {
	this.post = post;
    }

    public Boolean getProcessed() {
	return processed;
    }

    public void setProcessed(Boolean processed) {
	this.processed = processed;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public String getLocationClass() {
	return locationClass;
    }

    public void setLocationClass(String locationClass) {
	this.locationClass = locationClass;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public static String[] getLocationclasses() {
	return locationClasses;
    }

}