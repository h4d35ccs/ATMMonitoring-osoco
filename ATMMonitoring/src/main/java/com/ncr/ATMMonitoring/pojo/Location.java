package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "locations_id_seq")
    @SequenceGenerator(name = "locations_id_seq", sequenceName = "locations_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Column(name = "coord_x")
    private Double coordX;

    @Column(name = "coord_y")
    private Double coordY;

    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "location", length = 50)
    private String location;

    @Column(name = "office", length = 50)
    private String office;

    @Column(name = "bank", length = 50)
    private String bank;

    @Column(name = "bank_company", length = 50)
    private String bankCompany;

    @Column(name = "ip", length = 50)
    private String ip;

    @Column(name = "public_access")
    private Boolean publicAccess;

    // We don't need this for now
    // @OneToMany(mappedBy = "installation")
    // @Cascade(CascadeType.ALL)
    // private Set<Installation> installations
    // public Set<Installation> getInstallation() {
    // return installations;
    // }
    //
    // public void setInstallations(Set<Installation> installations) {
    // this.installations = installations;
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

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public Double getCoordX() {
	return coordX;
    }

    public void setCoordX(Double coordX) {
	this.coordX = coordX;
    }

    public Double getCoordY() {
	return coordY;
    }

    public void setCoordY(Double coordY) {
	this.coordY = coordY;
    }

    public String getPosition() {
	return position;
    }

    public void setPosition(String position) {
	this.position = position;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getOffice() {
	return office;
    }

    public void setOffice(String office) {
	this.office = office;
    }

    public String getBank() {
	return bank;
    }

    public void setBank(String bank) {
	this.bank = bank;
    }

    public String getBankCompany() {
	return bankCompany;
    }

    public void setBankCompany(String bankCompany) {
	this.bankCompany = bankCompany;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public Boolean getPublicAccess() {
	return publicAccess;
    }

    public void setPublicAccess(Boolean publicAccess) {
	this.publicAccess = publicAccess;
    }

}