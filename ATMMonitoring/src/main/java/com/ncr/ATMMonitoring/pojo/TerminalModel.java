package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "terminal_models")
public class TerminalModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "terminal_models_id_seq")
    @SequenceGenerator(name = "terminal_models_id_seq", sequenceName = "terminal_models_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "model", length = 50, unique = true)
    private String model;

    @Column(name = "manufacturer", length = 50)
    private String manufacturer;

    @Column(name = "photo")
    private byte[] photo;

    // We don't need this for now
    // @OneToMany(mappedBy = "terminalModel")
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

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public String getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public byte[] getPhoto() {
	return photo;
    }

    public void setPhoto(byte[] photo) {
	this.photo = photo;
    }
}