/**
 * 
 */
package com.ncr.ATMMonitoring.parser.ups.dto;

import java.util.Date;

/**
 * DTO that holds the basic information retrieved from an UPS XML
 * @author ottoabreu
 *
 */
public class UPSInfo {
	
	private String ip;
	private String firmware;
	private String runningStatus;
	private float chargePercentage;
	private float expensePercentage;
	private String alarmMsg;
	private String upsType;
	private String upsModel;
	private String seriesNumber;
	private long runningTimeMilisec;
	private long autonomyMilisec;
	private String numPosition;
	private Date audFmo;
	private String generalStatusMsg;
	private Date lastExecutionDate;
	private String originalXML;
	private UPSExtraInfo extraInfo;
	
	
	
	
	/**
	 * Constructor with all the parameters
	 * @param ip
	 * @param firmware
	 * @param runningStatus
	 * @param chargePercentage
	 * @param expensePercentage
	 * @param alarmMsg
	 * @param upsType
	 * @param upsModel
	 * @param seriesNumber
	 * @param runningTimeMilisec
	 * @param autonomyMilisec
	 * @param numPosition
	 * @param audFmo
	 * @param generalStatusMsg
	 * @param lastExecutionDate
	 * @param originalXML
	 * @param extraInfo
	 */
	public UPSInfo(String ip, String firmware, String runningStatus,
			float chargePercentage, float expensePercentage, String alarmMsg,
			String upsType, String upsModel, String seriesNumber,
			long runningTimeMilisec, long autonomyMilisec, String numPosition,
			Date audFmo, String generalStatusMsg, Date lastExecutionDate,
			String originalXML, UPSExtraInfo extraInfo) {
		super();
		this.ip = ip;
		this.firmware = firmware;
		this.runningStatus = runningStatus;
		this.chargePercentage = chargePercentage;
		this.expensePercentage = expensePercentage;
		this.alarmMsg = alarmMsg;
		this.upsType = upsType;
		this.upsModel = upsModel;
		this.seriesNumber = seriesNumber;
		this.runningTimeMilisec = runningTimeMilisec;
		this.autonomyMilisec = autonomyMilisec;
		this.numPosition = numPosition;
		this.audFmo = audFmo;
		this.generalStatusMsg = generalStatusMsg;
		this.lastExecutionDate = lastExecutionDate;
		this.originalXML = originalXML;
		this.extraInfo = extraInfo;
	}
	
	/**
	 * COnstructor no param
	 */
	public UPSInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	/**
	 * Getter method for ip
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Setter method for the ip
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Getter method for firmware
	 * @return the firmware
	 */
	public String getFirmware() {
		return firmware;
	}

	/**
	 * Setter method for the firmware
	 * @param firmware the firmware to set
	 */
	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	/**
	 * Getter method for runningStatus
	 * @return the runningStatus
	 */
	public String getRunningStatus() {
		return runningStatus;
	}

	/**
	 * Setter method for the runningStatus
	 * @param runningStatus the runningStatus to set
	 */
	public void setRunningStatus(String runningStatus) {
		this.runningStatus = runningStatus;
	}

	/**
	 * Getter method for chargePercentage
	 * @return the chargePercentage
	 */
	public float getChargePercentage() {
		return chargePercentage;
	}

	/**
	 * Setter method for the chargePercentage
	 * @param chargePercentage the chargePercentage to set
	 */
	public void setChargePercentage(float chargePercentage) {
		this.chargePercentage = chargePercentage;
	}

	/**
	 * Getter method for expensePercentage
	 * @return the expensePercentage
	 */
	public float getExpensePercentage() {
		return expensePercentage;
	}

	/**
	 * Setter method for the expensePercentage
	 * @param expensePercentage the expensePercentage to set
	 */
	public void setExpensePercentage(float expensePercentage) {
		this.expensePercentage = expensePercentage;
	}

	/**
	 * Getter method for alarmMsg
	 * @return the alarmMsg
	 */
	public String getAlarmMsg() {
		return alarmMsg;
	}

	/**
	 * Setter method for the alarmMsg
	 * @param alarmMsg the alarmMsg to set
	 */
	public void setAlarmMsg(String alarmMsg) {
		this.alarmMsg = alarmMsg;
	}

	/**
	 * Getter method for upsType
	 * @return the upsType
	 */
	public String getUpsType() {
		return upsType;
	}

	/**
	 * Setter method for the upsType
	 * @param upsType the upsType to set
	 */
	public void setUpsType(String upsType) {
		this.upsType = upsType;
	}

	/**
	 * Getter method for upsModel
	 * @return the upsModel
	 */
	public String getUpsModel() {
		return upsModel;
	}

	/**
	 * Setter method for the upsModel
	 * @param upsModel the upsModel to set
	 */
	public void setUpsModel(String upsModel) {
		this.upsModel = upsModel;
	}

	/**
	 * Getter method for seriesNumber
	 * @return the seriesNumber
	 */
	public String getSeriesNumber() {
		return seriesNumber;
	}

	/**
	 * Setter method for the seriesNumber
	 * @param seriesNumber the seriesNumber to set
	 */
	public void setSeriesNumber(String seriesNumber) {
		this.seriesNumber = seriesNumber;
	}

	/**
	 * Getter method for runningTimeMilisec
	 * @return the runningTimeMilisec
	 */
	public long getRunningTimeMilisec() {
		return runningTimeMilisec;
	}

	/**
	 * Setter method for the runningTimeMilisec
	 * @param runningTimeMilisec the runningTimeMilisec to set
	 */
	public void setRunningTimeMilisec(long runningTimeMilisec) {
		this.runningTimeMilisec = runningTimeMilisec;
	}

	/**
	 * Getter method for autonomyMilisec
	 * @return the autonomyMilisec
	 */
	public long getAutonomyMilisec() {
		return autonomyMilisec;
	}

	/**
	 * Setter method for the autonomyMilisec
	 * @param autonomyMilisec the autonomyMilisec to set
	 */
	public void setAutonomyMilisec(long autonomyMilisec) {
		this.autonomyMilisec = autonomyMilisec;
	}

	/**
	 * Getter method for numPosition
	 * @return the numPosition
	 */
	public String getNumPosition() {
		return numPosition;
	}

	/**
	 * Setter method for the numPosition
	 * @param numPosition the numPosition to set
	 */
	public void setNumPosition(String numPosition) {
		this.numPosition = numPosition;
	}

	/**
	 * Getter method for audFmo
	 * @return the audFmo
	 */
	public Date getAudFmo() {
		return audFmo;
	}

	/**
	 * Setter method for the audFmo
	 * @param audFmo the audFmo to set
	 */
	public void setAudFmo(Date audFmo) {
		this.audFmo = audFmo;
	}

	/**
	 * Getter method for generalStatusMsg
	 * @return the generalStatusMsg
	 */
	public String getGeneralStatusMsg() {
		return generalStatusMsg;
	}

	/**
	 * Setter method for the generalStatusMsg
	 * @param generalStatusMsg the generalStatusMsg to set
	 */
	public void setGeneralStatusMsg(String generalStatusMsg) {
		this.generalStatusMsg = generalStatusMsg;
	}

	/**
	 * Getter method for lastExecutionDate
	 * @return the lastExecutionDate
	 */
	public Date getLastExecutionDate() {
		return lastExecutionDate;
	}

	/**
	 * Setter method for the lastExecutionDate
	 * @param lastExecutionDate the lastExecutionDate to set
	 */
	public void setLastExecutionDate(Date lastExecutionDate) {
		this.lastExecutionDate = lastExecutionDate;
	}

	/**
	 * Getter method for originalXML
	 * @return the originalXML
	 */
	public String getOriginalXML() {
		return originalXML;
	}

	/**
	 * Setter method for the originalXML
	 * @param originalXML the originalXML to set
	 */
	public void setOriginalXML(String originalXML) {
		this.originalXML = originalXML;
	}

	/**
	 * Getter method for extraInfo
	 * @return the extraInfo
	 */
	public UPSExtraInfo getExtraInfo() {
		return extraInfo;
	}

	/**
	 * Setter method for the extraInfo
	 * @param extraInfo the extraInfo to set
	 */
	public void setExtraInfo(UPSExtraInfo extraInfo) {
		this.extraInfo = extraInfo;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer("[");
		sb.append("| ip= "+ this.ip);
		sb.append("| firmware= "+ this.firmware);
		sb.append("| runningStatus= "+ this.runningStatus);
		sb.append("| chargePercentage= "+ this.chargePercentage);
		sb.append("| expensePercentage= "+ this.expensePercentage);
		sb.append("| alarmMsg= "+ this.alarmMsg);
		sb.append("| upsType= "+ this.upsType);
		sb.append("| upsModel= "+ this.upsModel);
		sb.append("| seriesNumber= "+ this.seriesNumber);
		sb.append("| runningTimeMilisec= "+ this.runningTimeMilisec);
		sb.append("| autonomyMilisec= "+ this.autonomyMilisec);
		sb.append("| numPosition= "+ this.numPosition);
		sb.append("| audFmo= "+ this.audFmo);
		sb.append("| generalStatusMsg= "+ this.generalStatusMsg);
		sb.append("| lastExecutionDate= "+ this.lastExecutionDate);
		sb.append("| originalXML= "+ this.originalXML);
		sb.append("| extraInfo= "+ this.extraInfo);
		sb.append(" ]");
		return sb.toString();
	}
	
	
	
}
