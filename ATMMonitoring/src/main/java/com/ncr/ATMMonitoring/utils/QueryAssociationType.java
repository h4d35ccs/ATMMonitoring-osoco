package com.ncr.ATMMonitoring.utils;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.Hotfix;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

public enum QueryAssociationType {
	
	TERMINAL(null, "terminal", Terminal.class),
	INSTALLATION("installations", "installations", Installation.class),
	FINANCIAL_DEVICES("financialDevices","financialDevice", FinancialDevice.class),
	XFS_COMPONENT("financialDevices.xfsComponent", "xfsComponent", XfsComponent.class),
	JXFS_COMPONENT("financialDevices.jxfsComponent", "jxfsComponent", JxfsComponent.class),
	HOTFIX("hotfixes", "hotfix", Hotfix.class),
	INTERNET_EXPLORER("auditableInternetExplorers","internetExplorer", InternetExplorer.class),
	OPERATING_SYSTEM("configs.operatingSystems" , "operatingSystem", OperatingSystem.class),
	SOFTWARE("configs.software" , "software", Software.class),
	HARDWARE_DEVICE("hardwareDevices" , "hardwareDevice", HardwareDevice.class);		
	
	
	private String associationName;
	private String comboboxName;
	private Class<?> associationClass;
	private String[] associationNames;
	private String lastAssociationName;
	
	private QueryAssociationType(String associationName, String comboboxName, Class<?> associationClass) {
		this.associationClass = associationClass;
		this.associationName = associationName;
		this.comboboxName = comboboxName;
		if( associationName != null) {
			associationNames = associationName.split("\\.");
			lastAssociationName = associationNames[associationNames.length -1];  
		}
	}
	
	
	public static QueryAssociationType findByComboboxName(String comboboxName) {
		for( QueryAssociationType associationType : values() ) {
			if( associationType.comboboxName == comboboxName) {
				return associationType;
			}
		}
		return null;
	}
	
	public static QueryAssociationType findByAssociationName(String associationName) {
		for( QueryAssociationType associationType : values() ) {
			if( associationType.associationName == associationName) {
				return associationType;
			}
		}
		return null;
	}


	public Class<?> getAssociationClass() {
		return associationClass;
	}


	public String buildGroupName(String defaultAssociationName, String groupByField) {
		String association = (associationName != null) ? lastAssociationName : defaultAssociationName;
		return association + "." + groupByField;
	}


	public String buildJoin(String rootTableAlias) {
		String join = "";
		if (associationName != null) {
			String sourceAssociation = rootTableAlias;
			
			for(String associationName : associationNames) {
				join += " join "+ sourceAssociation + "." + associationName + " " + associationName;
				sourceAssociation = associationName;
			}
		}
		return join;
	}
	
	public String buildWhere() {
		String where = "";
		if (associationName != null) {
			String associationNameForApplyWhere = associationNames[0];
			where = " and " + associationNameForApplyWhere + ".endDate = null ";
		}
		
		return where;
	}
}
