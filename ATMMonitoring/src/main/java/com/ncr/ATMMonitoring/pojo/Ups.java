package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The UPS Pojo.
 * 
 * @author Otto Abreu
 */
@Entity
@Table(name = "ups")
public class Ups implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3914511485325636325L;

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ups_id_seq")
    @SequenceGenerator(name = "ups_id_seq", sequenceName = "ups_id_seq", allocationSize = 1)
    private Integer id;

    /** The ip. */
    @Column(name = "ip")
    private String ip;

    /** The firmware version. */
    @Column(name = "firmware_revision")
    private String firmware;

    /** The running status. */
    @Column(name = "running_status")
    private String runningStatus;

    /** The charge percentage. */
    @Column(name = "charge_percentage")
    private Float chargePercentage;

    /** The expense percentage. */
    @Column(name = "expense_percentage")
    private Float expensePercentage;

    /** The alarm message. */
    @Column(name = "alarm_msg")
    private String alarmMsg;

    /** The type. */
    @Column(name = "type")
    private String type;

    /** The model. */
    @Column(name = "model")
    private String model;

    /** The serial number. */
    @Column(name = "series_number")
    private String seriesNumber;

    /** The running time in millisecs. */
    @Column(name = "running_time_millisec")
    private Long runningTimeMillisec;

    /** The autonomy in millisecs. */
    @Column(name = "autonomy_millisec")
    private Long autonomyMillisec;

    /** The position number. */
    @Column(name = "num_position")
    private String numPosition;

    /** The aud fmo. */
    @Column(name = "aud_fmo")
    private Date audFmo;

    /** The general status message. */
    @Column(name = "general_status_msg")
    private String generalStatusMsg;

    /** The last execution date. */
    @Column(name = "last_execution")
    private Date lastExecutionDate;

    /** The original xml. */
    @Column(name = "xml")
    private String originalXML;

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
     * @param id
     *            the new id
     */
    public void setId(Integer id) {
	this.id = id;
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
     * @param ip
     *            the new ip
     */
    public void setIp(String ip) {
	this.ip = ip;
    }

    /**
     * Gets the firmware.
     * 
     * @return the firmware
     */
    public String getFirmware() {
	return firmware;
    }

    /**
     * Sets the firmware.
     * 
     * @param firmware
     *            the new firmware
     */
    public void setFirmware(String firmware) {
	this.firmware = firmware;
    }

    /**
     * Gets the running status.
     * 
     * @return the running status
     */
    public String getRunningStatus() {
	return runningStatus;
    }

    /**
     * Sets the running status.
     * 
     * @param runningStatus
     *            the new running status
     */
    public void setRunningStatus(String runningStatus) {
	this.runningStatus = runningStatus;
    }

    /**
     * Gets the charge percentage.
     * 
     * @return the charge percentage
     */
    public float getChargePercentage() {
	return chargePercentage;
    }

    /**
     * Sets the charge percentage.
     * 
     * @param chargePercentage
     *            the new charge percentage
     */
    public void setChargePercentage(Float chargePercentage) {
	this.chargePercentage = chargePercentage;
    }

    /**
     * Gets the expense percentage.
     * 
     * @return the expense percentage
     */
    public float getExpensePercentage() {
	return expensePercentage;
    }

    /**
     * Sets the expense percentage.
     * 
     * @param expensePercentage
     *            the new expense percentage
     */
    public void setExpensePercentage(Float expensePercentage) {
	this.expensePercentage = expensePercentage;
    }

    /**
     * Gets the alarm msg.
     * 
     * @return the alarm msg
     */
    public String getAlarmMsg() {
	return alarmMsg;
    }

    /**
     * Sets the alarm msg.
     * 
     * @param alarmMsg
     *            the new alarm msg
     */
    public void setAlarmMsg(String alarmMsg) {
	this.alarmMsg = alarmMsg;
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
     * @param type
     *            the new type
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Gets the model.
     * 
     * @return the model
     */
    public String getModel() {
	return model;
    }

    /**
     * Sets the model.
     * 
     * @param model
     *            the new model
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * Gets the series number.
     * 
     * @return the series number
     */
    public String getSeriesNumber() {
	return seriesNumber;
    }

    /**
     * Sets the series number.
     * 
     * @param seriesNumber
     *            the new series number
     */
    public void setSeriesNumber(String seriesNumber) {
	this.seriesNumber = seriesNumber;
    }

    /**
     * Gets the running time milisec.
     * 
     * @return the running time milisec
     */
    public long getRunningTimeMilisec() {
	return runningTimeMillisec;
    }

    /**
     * Sets the running time milisec.
     * 
     * @param runningTimeMilisec
     *            the new running time milisec
     */
    public void setRunningTimeMilisec(Long runningTimeMilisec) {
	this.runningTimeMillisec = runningTimeMilisec;
    }

    /**
     * Gets the autonomy milisec.
     * 
     * @return the autonomy milisec
     */
    public long getAutonomyMilisec() {
	return autonomyMillisec;
    }

    /**
     * Sets the autonomy milisec.
     * 
     * @param autonomyMilisec
     *            the new autonomy milisec
     */
    public void setAutonomyMilisec(Long autonomyMilisec) {
	this.autonomyMillisec = autonomyMilisec;
    }

    /**
     * Gets the num position.
     * 
     * @return the num position
     */
    public String getNumPosition() {
	return numPosition;
    }

    /**
     * Sets the num position.
     * 
     * @param numPosition
     *            the new num position
     */
    public void setNumPosition(String numPosition) {
	this.numPosition = numPosition;
    }

    /**
     * Gets the aud fmo.
     * 
     * @return the aud fmo
     */
    public Date getAudFmo() {
	return audFmo;
    }

    /**
     * Sets the aud fmo.
     * 
     * @param audFmo
     *            the new aud fmo
     */
    public void setAudFmo(Date audFmo) {
	this.audFmo = audFmo;
    }

    /**
     * Gets the general status msg.
     * 
     * @return the general status msg
     */
    public String getGeneralStatusMsg() {
	return generalStatusMsg;
    }

    /**
     * Sets the general status msg.
     * 
     * @param generalStatusMsg
     *            the new general status msg
     */
    public void setGeneralStatusMsg(String generalStatusMsg) {
	this.generalStatusMsg = generalStatusMsg;
    }

    /**
     * Gets the last execution date.
     * 
     * @return the last execution date
     */
    public Date getLastExecutionDate() {
	return lastExecutionDate;
    }

    /**
     * Sets the last execution date.
     * 
     * @param lastExecutionDate
     *            the new last execution date
     */
    public void setLastExecutionDate(Date lastExecutionDate) {
	this.lastExecutionDate = lastExecutionDate;
    }

    /**
     * Gets the original xml.
     * 
     * @return the original xml
     */
    public String getOriginalXML() {
	return originalXML;
    }

    /**
     * Sets the original xml.
     * 
     * @param originalXML
     *            the new original xml
     */
    public void setOriginalXML(String originalXML) {
	this.originalXML = originalXML;
    }
}
