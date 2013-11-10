package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "physical_cash_units")
public class PhysicalCashUnit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "physical_cash_units_id_seq")
    @SequenceGenerator(name = "physical_cash_units_id_seq", sequenceName = "physical_cash_units_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "logical_cash_unit_id")
    private LogicalCashUnit logicalCashUnit;

    @Column(name = "name")
    @Type(type = "text")
    private String name;

    @Column(name = "unit_id")
    private Integer unitId;

    @Column(name = "maximum")
    private Integer maximum;

    @Column(name = "hardware_sensor")
    private Boolean hardwareSensor;

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
     * @return the logicalCashUnit
     */
    public LogicalCashUnit getLogicalCashUnit() {
	return logicalCashUnit;
    }

    /**
     * @param logicalCashUnit
     *            the logicalCashUnit to set
     */
    public void setLogicalCashUnit(LogicalCashUnit logicalCashUnit) {
	this.logicalCashUnit = logicalCashUnit;
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
     * @return the unitId
     */
    public Integer getUnitId() {
	return unitId;
    }

    /**
     * @param unitId
     *            the unitId to set
     */
    public void setUnitId(Integer unitId) {
	this.unitId = unitId;
    }

    /**
     * @return the maximum
     */
    public Integer getMaximum() {
	return maximum;
    }

    /**
     * @param maximum
     *            the maximum to set
     */
    public void setMaximum(Integer maximum) {
	this.maximum = maximum;
    }

    /**
     * @return the hardwareSensor
     */
    public Boolean getHardwareSensor() {
	return hardwareSensor;
    }

    /**
     * @param hardwareSensor
     *            the hardwareSensor to set
     */
    public void setHardwareSensor(Boolean hardwareSensor) {
	this.hardwareSensor = hardwareSensor;
    }

}