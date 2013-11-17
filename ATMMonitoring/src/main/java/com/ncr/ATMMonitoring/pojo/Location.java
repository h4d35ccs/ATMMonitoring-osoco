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

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "locations", uniqueConstraints = { @UniqueConstraint(columnNames = {
	"address_street", "address_number", "address_city", "address_postcode",
	"address_country" }) })
public class Location {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "locations_id_seq")
    @SequenceGenerator(name = "locations_id_seq", sequenceName = "locations_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "address_street")
    @Type(type = "text")
    private String addressStreet;

    @Column(name = "address_number")
    @Type(type = "text")
    private String addressNumber;

    @Column(name = "address_postcode")
    @Type(type = "text")
    private String addressPostcode;

    @Column(name = "address_city")
    @Type(type = "text")
    private String addressCity;

    @Column(name = "address_country")
    @Type(type = "text")
    private String addressCountry;

    @Column(name = "coord_x")
    private Double coordX;

    @Column(name = "coord_y")
    private Double coordY;

    @Column(name = "displaced")
    private Boolean displaced;

    @Column(name = "office", length = 50)
    private String office;

    @Column(name = "bank", length = 50)
    private String bank;

    @Column(name = "bank_company", length = 50)
    private String bankCompany;

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

    public Boolean getPublicAccess() {
	return publicAccess;
    }

    public void setPublicAccess(Boolean publicAccess) {
	this.publicAccess = publicAccess;
    }

    public String getAddressStreet() {
	return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
	this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
	return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
	this.addressNumber = addressNumber;
    }

    public String getAddressPostcode() {
	return addressPostcode;
    }

    public void setAddressPostcode(String addressPostcode) {
	this.addressPostcode = addressPostcode;
    }

    public String getAddressCity() {
	return addressCity;
    }

    public void setAddressCity(String addressCity) {
	this.addressCity = addressCity;
    }

    public String getAddressCountry() {
	return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
	this.addressCountry = addressCountry;
    }

    public String getCompleteAddress() {
	String address = (addressStreet != null) ? addressStreet : "";
	address += ((addressNumber != null) ? ((address.length() > 0) ? " "
		: "") + addressNumber : "");
	address += ((addressCity != null) ? ((address.length() > 0) ? ", " : "")
		+ addressCity
		: "");
	address += ((addressPostcode != null) ? ((address.length() > 0) ? ", "
		: "") + addressPostcode : "");
	address += ((addressCountry != null) ? ((address.length() > 0) ? ", "
		: "") + addressCountry : "");
	return address;
    }

    public Boolean getDisplaced() {
	return displaced;
    }

    public void setDisplaced(Boolean displaced) {
	this.displaced = displaced;
    }

}