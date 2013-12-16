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
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Utils;

/**
 * The LogicalCashUnit Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "logical_cash_units")
public class LogicalCashUnit {

    /** The Constant separator. */
    private static final char separator = ';';

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logical_cash_units_id_seq")
    @SequenceGenerator(name = "logical_cash_units_id_seq", sequenceName = "logical_cash_units_id_seq", allocationSize = 1)
    private Integer id;

    /** The xfs component. */
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "xfs_component_id")
    private XfsComponent xfsComponent;

    /** The physical cash units. */
    @OneToMany(mappedBy = "logicalCashUnit", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("name")
    private Set<PhysicalCashUnit> physicalCashUnits = new HashSet<PhysicalCashUnit>();

    /** The name. */
    @Column(name = "name")
    @Type(type = "text")
    private String name;

    /** The type. */
    @Column(name = "type")
    @Type(type = "text")
    private String type;

    /** The unit id. */
    @Column(name = "unit_id")
    private Integer unitId;

    /** The currency id. */
    @Column(name = "currency_id")
    @Type(type = "text")
    private String currencyId;

    /** The values. */
    @Column(name = "vals")
    @Type(type = "text")
    private String values;

    /** The minimum. */
    @Column(name = "minimum")
    private Integer minimum;

    /** The maximum. */
    @Column(name = "maximum")
    private Integer maximum;

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
     * Gets the xfs component.
     *
     * @return the xfsComponent
     */
    public XfsComponent getXfsComponent() {
	return xfsComponent;
    }

    /**
     * Sets the xfs component.
     *
     * @param xfsComponent the xfsComponent to set
     */
    public void setXfsComponent(XfsComponent xfsComponent) {
	this.xfsComponent = xfsComponent;
    }

    /**
     * Gets the physical cash units.
     *
     * @return the physicalCashUnits
     */
    public Set<PhysicalCashUnit> getPhysicalCashUnits() {
	return physicalCashUnits;
    }

    /**
     * Sets the physical cash units.
     *
     * @param physicalCashUnits the physicalCashUnits to set
     */
    public void setPhysicalCashUnits(Set<PhysicalCashUnit> physicalCashUnits) {
	this.physicalCashUnits = physicalCashUnits;
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
     * @param type the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Gets the unit id.
     *
     * @return the unitId
     */
    public Integer getUnitId() {
	return unitId;
    }

    /**
     * Sets the unit id.
     *
     * @param unitId the unitId to set
     */
    public void setUnitId(Integer unitId) {
	this.unitId = unitId;
    }

    /**
     * Gets the currency id.
     *
     * @return the currencyId
     */
    public String getCurrencyId() {
	return currencyId;
    }

    /**
     * Sets the currency id.
     *
     * @param currencyId the currencyId to set
     */
    public void setCurrencyId(String currencyId) {
	this.currencyId = currencyId;
    }

    /**
     * Gets the values.
     *
     * @return the values
     */
    public String getValues() {
	return values;
    }

    /**
     * Sets the values.
     *
     * @param values the values to set
     */
    public void setValues(String values) {
	this.values = values;
    }

    /**
     * Gets the values split by the separator.
     * 
     * @return the values
     */
    public List<Integer> getValuesSplit() {
	return Utils.splitIntegers(values, LogicalCashUnit.separator);
    }

    /**
     * Sets the values.
     *
     * @param values the values to set
     */
    public void setValues(List<Integer> values) {
	this.values = Utils.concatIntegers(values, LogicalCashUnit.separator);
    }

    /**
     * Gets the minimum.
     *
     * @return the minimum
     */
    public Integer getMinimum() {
	return minimum;
    }

    /**
     * Sets the minimum.
     *
     * @param minimum the minimum to set
     */
    public void setMinimum(Integer minimum) {
	this.minimum = minimum;
    }

    /**
     * Gets the maximum.
     *
     * @return the maximum
     */
    public Integer getMaximum() {
	return maximum;
    }

    /**
     * Sets the maximum.
     *
     * @param maximum the maximum to set
     */
    public void setMaximum(Integer maximum) {
	this.maximum = maximum;
    }

}