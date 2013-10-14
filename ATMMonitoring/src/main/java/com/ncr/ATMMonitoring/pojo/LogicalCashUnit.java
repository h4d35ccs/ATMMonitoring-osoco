package com.ncr.ATMMonitoring.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Utils;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "logical_cash_units")
public class LogicalCashUnit {

    private static final char separator = ';';

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logical_cash_units_id_seq")
    @SequenceGenerator(name = "logical_cash_units_id_seq", sequenceName = "logical_cash_units_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "xfs_component_id")
    private XfsComponent xfsComponent;

    @OneToMany(mappedBy = "logicalCashUnit", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("name")
    private Set<PhysicalCashUnit> physicalCashUnits = new HashSet<PhysicalCashUnit>();

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "unit_id")
    private Integer unitId;

    @Column(name = "currency_id", length = 50)
    private String currencyId;

    @Column(name = "vals", length = 150)
    private String values;

    @Column(name = "minimum")
    private Integer minimum;

    @Column(name = "maximum")
    private Integer maximum;

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
     * @return the xfsComponent
     */
    public XfsComponent getXfsComponent() {
	return xfsComponent;
    }

    /**
     * @param xfsComponent
     *            the xfsComponent to set
     */
    public void setXfsComponent(XfsComponent xfsComponent) {
	this.xfsComponent = xfsComponent;
    }

    /**
     * @return the physicalCashUnits
     */
    public Set<PhysicalCashUnit> getPhysicalCashUnits() {
	return physicalCashUnits;
    }

    /**
     * @param physicalCashUnits
     *            the physicalCashUnits to set
     */
    public void setPhysicalCashUnits(Set<PhysicalCashUnit> physicalCashUnits) {
	this.physicalCashUnits = physicalCashUnits;
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
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
	this.type = type;
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
     * @return the currencyId
     */
    public String getCurrencyId() {
	return currencyId;
    }

    /**
     * @param currencyId
     *            the currencyId to set
     */
    public void setCurrencyId(String currencyId) {
	this.currencyId = currencyId;
    }

    /**
     * @return the values
     */
    public String getValues() {
	return values;
    }

    /**
     * @param values
     *            the values to set
     */
    public void setValues(String values) {
	this.values = values;
    }

    /**
     * @return the values
     */
    public List<Integer> getValuesSplit() {
	return Utils.splitIntegers(values, LogicalCashUnit.separator);
    }

    /**
     * @param values
     *            the values to set
     */
    public void setValues(List<Integer> values) {
	this.values = Utils.concatIntegers(values, LogicalCashUnit.separator);
    }

    /**
     * @return the minimum
     */
    public Integer getMinimum() {
	return minimum;
    }

    /**
     * @param minimum
     *            the minimum to set
     */
    public void setMinimum(Integer minimum) {
	this.minimum = minimum;
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

}