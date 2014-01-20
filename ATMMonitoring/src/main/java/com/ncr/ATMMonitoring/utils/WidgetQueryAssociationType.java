package com.ncr.ATMMonitoring.utils;

import java.util.Map;

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

public enum WidgetQueryAssociationType {
	
	TERMINAL(null, "terminal", Terminal.getComboboxes()),
	INSTALLATION("installations", "installations", Installation.getComboboxes()),
	FINANCIAL_DEVICES("financialDevices","financialDevice", FinancialDevice.getComboboxes()),
	XFS_COMPONENT("financialDevices.xfsComponent", "xfsComponent", XfsComponent.getComboboxes()),
	JXFS_COMPONENT("financialDevices.jxfsComponent", "jxfsComponent", JxfsComponent.getComboboxes()),
	HOTFIX("hotfixes", "hotfix", Hotfix.getComboboxes()),
	INTERNET_EXPLORER("auditableInternetExplorers","internetExplorer", InternetExplorer.getComboboxes()),
	OPERATING_SYSTEM("configs.operatingSystems" , "operatingSystem", OperatingSystem.getComboboxes()),
	SOFTWARE("configs.software" , "software", Software.getComboboxes()),
	HARDWARE_DEVICE("hardwareDevices" , "hardwareDevice", HardwareDevice.getComboboxes());		
	
	
	private String associationName;
	private String comboboxName;
	private Map<String,?> comboboxes;
	private String[] associationNames;
	private String lastAssociationName;
	
	private WidgetQueryAssociationType(String associationName, String comboboxName, Map<String,?> comboboxes) {
		this.comboboxes = comboboxes;
		this.associationName = associationName;
		this.comboboxName = comboboxName;
		if( associationName != null) {
			associationNames = associationName.split("\\.");
			lastAssociationName = associationNames[associationNames.length -1];  
		}
	}
	
	
	public static WidgetQueryAssociationType findByComboboxName(String comboboxName) {
		for( WidgetQueryAssociationType associationType : values() ) {
			if( associationType.comboboxName == comboboxName) {
				return associationType;
			}
		}
		return null;
	}
	
	public static WidgetQueryAssociationType findByAssociationName(String associationName) {
		for( WidgetQueryAssociationType associationType : values() ) {
			if( associationType.associationName == associationName) {
				return associationType;
			}
		}
		return null;
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

	public Map<String,?> getComboboxes() {
		return comboboxes;
	}
}
