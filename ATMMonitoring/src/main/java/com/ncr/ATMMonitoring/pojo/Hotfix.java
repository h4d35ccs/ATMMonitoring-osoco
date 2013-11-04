package com.ncr.ATMMonitoring.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

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

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.agent.baseData.os.module.HotfixPojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "hotfixes")
public class Hotfix {

    static private Logger logger = Logger.getLogger(Hotfix.class.getName());

    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	comboboxes.put("number",
		Operation.getOperationsByType(Operation.DataType.NUMBER));
	comboboxes.put("fixComments", stringOperations);
	comboboxes.put("hotfixId", stringOperations);
	comboboxes.put("description", stringOperations);
	comboboxes.put("installedOn",
		Operation.getOperationsByType(Operation.DataType.DATE));
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotfixes_id_seq")
    @SequenceGenerator(name = "hotfixes_id_seq", sequenceName = "hotfixes_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @Column(name = "numbr")
    private Integer number;

    @Column(name = "fix_comments", length = 150)
    private String fixComments;

    @Column(name = "hotfix_id", length = 150)
    private String hotfixId;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "installed_on")
    private Date installedOn;

    public Hotfix() {
    }

    public Hotfix(ncr.inventory.data.Hotfix hotfix) {
	this.description = hotfix.getDescription();
	this.fixComments = hotfix.getFixComments();
	this.hotfixId = hotfix.getHotfixID();
	if (hotfix.getInstalledOn().length() > 0) {
	    try {
		String[] date = hotfix.getInstalledOn().split("/");
		String pattern = "dd/MM/";
		if (date.length >= 3) {
		    String day = date[0];
		    if (day.length() > 2) {
			day = day.substring(0, 2);
		    } else if (day.length() == 1) {
			day = "0" + day;
		    } else if (day.length() != 2) {
			day = null;
		    }
		    String month = date[1];
		    if (month.length() > 2) {
			month = month.substring(0, 2);
		    } else if (month.length() == 1) {
			month = "0" + month;
		    } else if (month.length() != 2) {
			month = null;
		    }
		    String year = date[2];
		    if (year.length() >= 4) {
			year = year.substring(0, 4);
			pattern += "yyyy";
		    } else if (year.length() == 2) {
			pattern += "yy";
		    } else {
			year = null;
		    }
		    if ((year != null) && (month != null) && (day != null)) {
			this.installedOn = new SimpleDateFormat(pattern)
				.parse(day + "/" + month + "/" + year);
		    } else {
			logger.error("Couldn't parse Hotfix date '"
				+ hotfix.getInstalledOn() + "'");
			this.installedOn = null;
		    }
		}
	    } catch (ParseException e) {
		logger.error("Couldn't parse Hotfix date.", e);
		this.installedOn = null;
	    }
	}
	// TODO
	// No number?
    }

    public Hotfix(HotfixPojo hotfix) {
	this.description = hotfix.getDescription();
	this.fixComments = hotfix.getFixComments();
	this.hotfixId = hotfix.getHotfixID();
	if (hotfix.getInstalledOn().length() > 0) {
	    try {
		String[] date = hotfix.getInstalledOn().split("/");
		String pattern = "dd/MM/";
		if (date.length >= 3) {
		    String day = date[0];
		    if (day.length() > 2) {
			day = day.substring(0, 2);
		    } else if (day.length() == 1) {
			day = "0" + day;
		    } else if (day.length() != 2) {
			day = null;
		    }
		    String month = date[1];
		    if (month.length() > 2) {
			month = month.substring(0, 2);
		    } else if (month.length() == 1) {
			month = "0" + month;
		    } else if (month.length() != 2) {
			month = null;
		    }
		    String year = date[2];
		    if (year.length() >= 4) {
			year = year.substring(0, 4);
			pattern += "yyyy";
		    } else if (year.length() == 2) {
			pattern += "yy";
		    } else {
			year = null;
		    }
		    if ((year != null) && (month != null) && (day != null)) {
			this.installedOn = new SimpleDateFormat(pattern)
				.parse(day + "/" + month + "/" + year);
		    } else {
			logger.error("Couldn't parse Hotfix date '"
				+ hotfix.getInstalledOn() + "'");
			this.installedOn = null;
		    }
		}
	    } catch (ParseException e) {
		logger.error("Couldn't parse Hotfix date.", e);
		this.installedOn = null;
	    }
	}
    }

    /**
     * @return the comboboxes
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
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
     * @return the fixComments
     */
    public String getFixComments() {
	return fixComments;
    }

    /**
     * @param fixComments
     *            the fixComments to set
     */
    public void setFixComments(String fixComments) {
	this.fixComments = fixComments;
    }

    /**
     * @return the hotfixId
     */
    public String getHotfixId() {
	return hotfixId;
    }

    /**
     * @param hotfixId
     *            the hotfixId to set
     */
    public void setHotfixId(String hotfixId) {
	this.hotfixId = hotfixId;
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
     * @return the installedOn
     */
    public Date getInstalledOn() {
	return installedOn;
    }

    /**
     * @param installedOn
     *            the installedOn to set
     */
    public void setInstalledOn(Date installedOn) {
	this.installedOn = installedOn;
    }

    /**
     * @return the terminal
     */
    public Terminal getTerminal() {
	return terminal;
    }

    /**
     * @param terminal
     *            the terminal to set
     */
    public void setTerminal(Terminal terminal) {
	this.terminal = terminal;
    }

}