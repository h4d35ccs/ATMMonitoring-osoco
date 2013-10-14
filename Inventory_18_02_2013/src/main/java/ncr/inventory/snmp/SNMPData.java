package ncr.inventory.snmp;

import ncr.inventory.data.ATM;
import ncr.inventory.data.BaseBoard;
import ncr.inventory.data.Bios;
import ncr.inventory.data.CDROMDrive;
import ncr.inventory.data.ComputerSystem;
import ncr.inventory.data.DesktopMonitor;
import ncr.inventory.data.Device;
import ncr.inventory.data.DiskDrive;
import ncr.inventory.data.FloppyDrive;
import ncr.inventory.data.Hotfix;
import ncr.inventory.data.IExplorer;
import ncr.inventory.data.Keyboard;
import ncr.inventory.data.LogicalDisk;
import ncr.inventory.data.NetworkAdapterSetting;
import ncr.inventory.data.OperatingSystem;
import ncr.inventory.data.Package;
import ncr.inventory.data.ParallelPort;
import ncr.inventory.data.PhysicalMemory;
import ncr.inventory.data.PointingDevice;
import ncr.inventory.data.Processor;
import ncr.inventory.data.Product;
import ncr.inventory.data.SCSIController;
import ncr.inventory.data.SerialPort;
import ncr.inventory.data.SoundDevice;
import ncr.inventory.data.SystemSlot;
import ncr.inventory.data.Terminal;
import ncr.inventory.data.USBController;
import ncr.inventory.data.UsbHub;
import ncr.inventory.data.VideoController;
import ncr.inventory.data._1394Controller;

import org.apache.log4j.Logger;

import uk.co.westhawk.snmp.stack.AsnObject;
import uk.co.westhawk.snmp.stack.varbind;

public class SNMPData {
    static Logger logger = Logger.getLogger(SNMPData.class.getName());
    SNMPUtils snmputil = null;

    public SNMPData(String ip, String community, int port) {
    	snmputil = new SNMPUtils(ip, community, port);
    }

    public boolean getData(ATM unit) {
		boolean estadoOk = true;
		try {
		    if (estadoOk) {
				estadoOk = getProduct(unit);
				logger.debug("Product: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getHotfix(unit);
				logger.debug("Hotfix: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getIExplorer(unit);
				logger.debug("IExplorer: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getOperatingSystem(unit);
				logger.debug("OperatingSystem: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getComputerSystem(unit);
				logger.debug("ComputerSystem: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getBaseBoard(unit);
				logger.debug("BaseBoard: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getBios(unit);
				logger.debug("Bios" + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getPhysicalMemory(unit);
				logger.debug("PhysicalMemory: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getProcessor(unit);
				logger.debug("Processor: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getDiskDrive(unit);
				logger.debug("DiskDrive: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getCDROMDrive(unit);
				logger.debug("CDROMDrive: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getFloppyDrive(unit);
				logger.debug("FloppyDrive: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getLogicalDisk(unit);
				logger.debug("LogicalDisk: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getVideoController(unit);
				logger.debug("VideoController: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getSerialPort(unit);
				logger.debug("SerialPort: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getParallelPort(unit);
				logger.debug("ParallelPort: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getSCSIController(unit);
				logger.debug("SCSIController: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getUSBController(unit);
				logger.debug("USBController: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getUsbHub(unit);
				logger.debug("UsbHub: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getSoundDevice(unit);
				logger.debug("SoundDevice: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getNetworkAdapterSetting(unit);
				logger.debug("NetworkAdapterSetting: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = get1394Controller(unit);
				logger.debug("1394Controller: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getDesktopMonitor(unit);
				logger.debug("DesktopMonitor: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getKeyboard(unit);
				logger.debug("Keyboard: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getPointingDevice(unit);
				logger.debug("PointingDevice: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getSystemSlot(unit);
				logger.debug("SystemSlot: " + estadoOk);
		    }
	
		    // Eva - 24/01/2013 - Faltan Terminal, Device y Package
		    // For NCR ATMs
		    if (estadoOk) {
				estadoOk = getTerminal(unit);
				logger.debug("Terminal: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getDevice(unit);
				logger.debug("Device: " + estadoOk);
		    }
		    if (estadoOk) {
				estadoOk = getPackage(unit);
				logger.debug("Package: " + estadoOk);
		    }
		    //
	
		    logger.debug("Resultado final: " + estadoOk);
		} catch (Throwable th) {
		    logger.error(th);
		}
		return estadoOk;
    }

    private boolean getProduct(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.4.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.2", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.3", i + 2), // IdentifyingNumber
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.4", i + 2), // Language
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.5", i + 2), // InstallDate
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.6", i + 2), // LocalPackage
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.7", i + 2), // PackageName
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.8", i + 2), // ProductID
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.9", i + 2), // Vendor
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.10", i + 2), // Version
				String.format("1.3.6.1.4.1.191.117.27.1.4.%d.11", i + 2) // SWType
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 12) {
			    System.out.println(String.format("Product - #%d", i));
				    /*+ "\n\tName --  " + results[0].getValue().toString()
				    + "\n\tCaption --  " + results[1].getValue().toString()
				    + "\n\tDescription --  " + results[2].getValue().toString()
				    + "\n\tIdentifyingNumber --  "
				    + results[3].toString() + "\n\tLanguage --  "
				    + results[4].toString() + "\n\tInstallDate --  "
				    + results[5].toString() + "\n\tLocalPackage --  "
				    + results[6].toString() + "\n\tPackageName --  "
				    + results[7].toString() + "\n\tProductID --  "
				    + results[8].toString() + "\n\tVendor --  "
				    + results[9].toString() + "\n\tVersion --  "
				    + results[10].toString() + "\n\tSWType --  "
				    + results[11].toString());*/
	
			    Product p = new Product();
			    
			    //EP410008 - 07/02/2013 - Some strings are changed by SNMP to hexa format due to characters unable to be
			    //printed - Source: http://rt.cpan.org/Public/Bup/Display.html?id=1946
			    //Name:
				if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else
				{
					p.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
				
				//Caption:
				if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					p.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
				//Description:
				if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setDescription(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					p.setDescription(results[2].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[2].getValue().toString()));
				}
			    
				//Identifying Number:
				if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setIdentifyingNumber(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tIdentifying Number: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					p.setIdentifyingNumber(results[3].getValue().toString());
					System.out.println(String.format("\tIdentifying Number: " + results[3].getValue().toString()));
				}
				
				//Language:
				if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setLanguage(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tLanguage: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					p.setLanguage(results[4].getValue().toString());
					System.out.println(String.format("\tLanguage: " + results[4].getValue().toString()));
				}
				
				//Install Date:
				if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setInstallDate(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tInstallDate: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					p.setInstallDate(results[5].getValue().toString());
					System.out.println(String.format("\tInstallDate: " + results[5].getValue().toString()));
				}
			    
			    //Local Package:
				if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setLocalPackage(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tLocal Package: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					p.setLocalPackage(results[6].getValue().toString());
					System.out.println(String.format("\tLocal Package: " + results[6].getValue().toString()));
				}
			    
			    //Package Name:
				if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setPackageName(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tPackage Name: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					p.setPackageName(results[7].getValue().toString());
					System.out.println(String.format("\tPackage Name: " + results[7].getValue().toString()));
				}
			    
			    //Product Id:
				if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setProductID(convertHexToString(results[8].getValue().toString().substring(2)));
					System.out.println(String.format("\tProduct Id: " + convertHexToString(results[8].getValue().toString().substring(2))));
				}
				else{
					p.setProductID(results[8].getValue().toString());
					System.out.println(String.format("\tProduct Id: " + results[8].getValue().toString()));
				}
			    
			    //Vendor:
				if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setVendor(convertHexToString(results[9].getValue().toString().substring(2)));
					System.out.println(String.format("\tVendor: " + convertHexToString(results[9].getValue().toString().substring(2))));
				}
				else{
					p.setVendor(results[9].getValue().toString());
					System.out.println(String.format("\tVendor: " + results[9].getValue().toString()));
				}
			    
			    //Version:
				if((results[10].getValue().toString().length() >= 2) && (results[10].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setVersion(convertHexToString(results[10].getValue().toString().substring(2)));
					System.out.println(String.format("\tVersion: " + convertHexToString(results[10].getValue().toString().substring(2))));
				}
				else{
					p.setVersion(results[10].getValue().toString());
					System.out.println(String.format("\tVersion: " + results[10].getValue().toString()));
				}
			    
			    //SWType:
				if((results[11].getValue().toString().length() >= 2) && (results[11].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setSWType(convertHexToString(results[11].getValue().toString().substring(2)));
					System.out.println(String.format("\tSWType: " + convertHexToString(results[11].getValue().toString().substring(2))));
				}
				else{
					p.setSWType(results[11].getValue().toString());
					System.out.println(String.format("\tSWType: " + results[11].getValue().toString()));
				}
				//<--
	
			    unit.setProduct(p);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getHotfix(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.28.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.28.%d.0", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.28.%d.1", i + 2), // HotfixID
				String.format("1.3.6.1.4.1.191.117.27.1.28.%d.2", i + 2), // InstalledOn
				String.format("1.3.6.1.4.1.191.117.27.1.28.%d.3", i + 2) // FixComments
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 4) {
			    System.out.println(String.format("Hotfix - #%d", i));
				    /*+ "\n\tDescription --  " + results[0].toString()
				    + "\n\tHotfixID --  " + results[1].toString()
				    + "\n\tInstalledOn --  " + results[2].toString()
				    + "\n\tFixComments --  " + results[3].toString());*/
	
			    Hotfix hf = new Hotfix();
			    
			    //Description:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					hf.setDescription(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					hf.setDescription(results[0].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[0].getValue().toString()));
				}
			    
			    //Hotfix Id:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					hf.setHotfixID(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tHotfixId: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					hf.setHotfixID(results[1].getValue().toString());
					System.out.println(String.format("\tHotfixId: " + results[1].getValue().toString()));
				}
			    
			    //Installed On:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					hf.setInstalledOn(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tInstalledOn: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					hf.setInstalledOn(results[2].getValue().toString());
					System.out.println(String.format("\tInstalledOn: " + results[2].getValue().toString()));
				}
			    
			    //Fix Comments:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					hf.setFixComments(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tFixComments: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					hf.setFixComments(results[3].getValue().toString());
					System.out.println(String.format("\tFixComments: " + results[3].getValue().toString()));
				}
	
			    unit.setHotfix(hf);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getIExplorer(ATM unit) {
	try {
	    String[] oids = { "1.3.6.1.4.1.191.117.27.1.29.1.0", // Version
	    };

	    varbind[] results = snmputil.get(oids);
	    if (results != null && results.length == 1) {
			//System.out.println("IExplorer\n\tVersion --  " + results[0].toString());
	
			IExplorer ie = new IExplorer();
			if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ie.setVersion(convertHexToString(results[0].getValue().toString().substring(2)));
				System.out.println(String.format("\tIExplorer Version: " + convertHexToString(results[0].getValue().toString().substring(2))));
			}
			else {
				ie.setVersion(results[0].getValue().toString());
				System.out.println(String.format("\tIExplorer Version: " + results[0].getValue().toString()));
			}
	
			unit.setIExplorer(ie);
	
			return true;
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getOperatingSystem(ATM unit) {
	try {
	    String[] oids = { "1.3.6.1.4.1.191.117.27.1.6.1.0", // Name
		    "1.3.6.1.4.1.191.117.27.1.6.1.1", // OSType
		    "1.3.6.1.4.1.191.117.27.1.6.1.2", // Manufacturer
		    "1.3.6.1.4.1.191.117.27.1.6.1.3", // SerialNumber
		    "1.3.6.1.4.1.191.117.27.1.6.1.4", // Version
		    "1.3.6.1.4.1.191.117.27.1.6.1.5", // OSLanguage
		    "1.3.6.1.4.1.191.117.27.1.6.1.6", // SPVersion
		    "1.3.6.1.4.1.191.117.27.1.6.1.7" // Organization
	    };

	    varbind[] results = snmputil.get(oids);
	    if (results != null && results.length == 8) {
			System.out.println("Operating System");
				/*+ results[0].toString() + "\n\tOSType --  "
				+ results[1].toString() + "\n\tManufacturer --  "
				+ results[2].toString() + "\n\tSerialNumber --  "
				+ results[3].toString() + "\n\tVersion --  "
				+ results[4].toString() + "\n\tOSLanguage --  "
				+ results[5].toString() + "\n\tSPVersion --  "
				+ results[6].toString() + "\n\tOrganization --  "
				+ results[7].toString());*/
	
			OperatingSystem os = new OperatingSystem();
			
			//Name:
			if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setName(convertHexToString(results[0].getValue().toString().substring(2)));
				System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
			}
			else{
				os.setName(results[0].getValue().toString());
				System.out.println(String.format("\tName: " + results[0].getValue().toString()));
			}
			 
			//OSType:
			if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setOSType(convertHexToString(results[1].getValue().toString().substring(2)));
				System.out.println(String.format("\tOSType: " + convertHexToString(results[1].getValue().toString().substring(2))));
			}
			else{
				os.setOSType(results[1].getValue().toString());
				System.out.println(String.format("\tOSType: " + results[1].getValue().toString()));
			}
			
			//Manufacturer:
			if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setManufacturer(convertHexToString(results[2].getValue().toString().substring(2)));
				System.out.println(String.format("\tManufacturer: " + convertHexToString(results[2].getValue().toString().substring(2))));
			}
			else{
				os.setManufacturer(results[2].getValue().toString());
				System.out.println(String.format("\tManufacturer: " + results[2].getValue().toString()));
			}
			
			//SerialNumber:
			if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setSerialNumber(convertHexToString(results[3].getValue().toString().substring(2)));
				System.out.println(String.format("\tSerial Number: " + convertHexToString(results[3].getValue().toString().substring(2))));
			}
			else{
				os.setSerialNumber(results[3].getValue().toString());
				System.out.println(String.format("\tSerial Number: " + results[3].getValue().toString()));
			}
			
			//Version:
			if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setVersion(convertHexToString(results[4].getValue().toString().substring(2)));
				System.out.println(String.format("\tVersion: " + convertHexToString(results[4].getValue().toString().substring(2))));
			}
			else{
				os.setVersion(results[4].getValue().toString());
				System.out.println(String.format("\tVersion: " + results[4].getValue().toString()));
			}
			
			//OSLanguage:
			if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setOSLanguage(convertHexToString(results[5].getValue().toString().substring(2)));
				System.out.println(String.format("\tOSLanguage: " + convertHexToString(results[5].getValue().toString().substring(2))));
			}
			else{
				os.setOSLanguage(results[5].getValue().toString());
				System.out.println(String.format("\tOSLanguage: " + results[5].getValue().toString()));
			}
			
			//SPVersion:
			if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setSPVersion(convertHexToString(results[6].getValue().toString().substring(2)));
				System.out.println(String.format("\tSPVersion: " + convertHexToString(results[6].getValue().toString().substring(2))));
			}
			else{
				os.setSPVersion(results[6].getValue().toString());
				System.out.println(String.format("\tSPVersion: " + results[6].getValue().toString()));
			}
			
			//Organization:
			if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				os.setOrganization(convertHexToString(results[7].getValue().toString().substring(2)));
				System.out.println(String.format("\tOrganization: " + convertHexToString(results[7].getValue().toString().substring(2))));
			}
			else{
				os.setOrganization(results[7].getValue().toString());
				System.out.println(String.format("\tOrganization: " + results[7].getValue().toString()));
			}
	
			unit.setOperatingSystem(os);
	
			return true;
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getComputerSystem(ATM unit) {
	try {
	    String[] oids = { "1.3.6.1.4.1.191.117.27.1.5.1.0", // Name
		    "1.3.6.1.4.1.191.117.27.1.5.1.1", // Manufacturer
		    "1.3.6.1.4.1.191.117.27.1.5.1.2", // Model
		    "1.3.6.1.4.1.191.117.27.1.5.1.3", // NumberOfProcessors
		    "1.3.6.1.4.1.191.117.27.1.5.1.4", // Caption
		    "1.3.6.1.4.1.191.117.27.1.5.1.5", // TotalPhysicalMemory
		    "1.3.6.1.4.1.191.117.27.1.5.1.6", // Description
		    "1.3.6.1.4.1.191.117.27.1.5.1.7", // CurrentTimeZone
		    "1.3.6.1.4.1.191.117.27.1.5.1.8", // DaylightInEffect
		    "1.3.6.1.4.1.191.117.27.1.5.1.9", // Domain
		    "1.3.6.1.4.1.191.117.27.1.5.1.10", // Workgroup
		    "1.3.6.1.4.1.191.117.27.1.5.1.11" // Status
	    };

	    varbind[] results = snmputil.get(oids);
	    if (results != null && results.length == 12) {
		System.out.println("Computer System");
			/*+ results[0].toString() + "\n\tManufacturer --  "
			+ results[1].toString() + "\n\tModel --  "
			+ results[2].toString() + "\n\tNumberOfProcessors --  "
			+ results[3].toString() + "\n\tCaption --  "
			+ results[4].toString()
			+ "\n\tTotalPhysicalMemory --  "
			+ results[5].toString() + "\n\tDescription --  "
			+ results[6].toString() + "\n\tCurrentTimeZone --  "
			+ results[7].toString() + "\n\tDaylightInEffect --  "
			+ results[8].toString() + "\n\tDomain --  "
			+ results[9].toString() + "\n\tWorkgroup --  "
			+ results[10].toString() + "\n\tStatus --  "
			+ results[11].toString());*/

			ComputerSystem cs = new ComputerSystem();
			
			//Name:
			if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setName(convertHexToString(results[0].getValue().toString().substring(2)));
				System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
			}
			else{
				cs.setName(results[0].getValue().toString());
				System.out.println(String.format("\tName: " + results[0].getValue().toString()));
			}
			
			//Manufacturer:
			if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
				System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
			}
			else{
				cs.setManufacturer(results[1].getValue().toString());
				System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
			}
			
			//Model:
			if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setModel(convertHexToString(results[2].getValue().toString().substring(2)));
				System.out.println(String.format("\tModel: " + convertHexToString(results[2].getValue().toString().substring(2))));
			}
			else{
				cs.setModel(results[2].getValue().toString());
				System.out.println(String.format("\tModel: " + results[2].getValue().toString()));
			}
			
			//Number Of Processors:
			if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setNumberOfProcessors(convertHexToString(results[3].getValue().toString().substring(2)));
				System.out.println(String.format("\tNumberOfProcessors: " + convertHexToString(results[3].getValue().toString().substring(2))));
			}
			else{
				cs.setNumberOfProcessors(results[3].getValue().toString());
				System.out.println(String.format("\tNumberOfProcessors: " + results[3].getValue().toString()));
			}
			
			//Caption:
			if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setCaption(convertHexToString(results[4].getValue().toString().substring(2)));
				System.out.println(String.format("\tCaption: " + convertHexToString(results[4].getValue().toString().substring(2))));
			}
			else{
				cs.setCaption(results[4].getValue().toString());
				System.out.println(String.format("\tCaption: " + results[4].getValue().toString()));
			}
			
			//TotalPhysicalMemory:
			if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setTotalPhysicalMemory(convertHexToString(results[5].getValue().toString().substring(2)));
				System.out.println(String.format("\tTotalPhysicalMemory: " + convertHexToString(results[5].getValue().toString().substring(2))));
			}
			else{
				cs.setTotalPhysicalMemory(results[5].getValue().toString());
				System.out.println(String.format("\tTotalPhysicalMemory: " + results[5].getValue().toString()));
			}
			
			//Description:
			if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setDescription(convertHexToString(results[6].getValue().toString().substring(2)));
				System.out.println(String.format("\tDescription: " + convertHexToString(results[6].getValue().toString().substring(2))));
			}
			else{
				cs.setDescription(results[6].getValue().toString());
				System.out.println(String.format("\tDescription: " + results[6].getValue().toString()));
			}
			
			//CurrentTimeZone:
			if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setCurrentTimeZone(convertHexToString(results[7].getValue().toString().substring(2)));
				System.out.println(String.format("\tCurrentTimeZone: " + convertHexToString(results[7].getValue().toString().substring(2))));
			}
			else{
				cs.setCurrentTimeZone(results[7].getValue().toString());
				System.out.println(String.format("\tCurrentTimeZone: " + results[7].getValue().toString()));
			}
			
			//DayLightInEffect:
			if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setDaylightInEffect(convertHexToString(results[8].getValue().toString().substring(2)));
				System.out.println(String.format("\tDaylightInEffect: " + convertHexToString(results[8].getValue().toString().substring(2))));
			}
			else{
				cs.setDaylightInEffect(results[8].getValue().toString());
				System.out.println(String.format("\tDaylightInEffect: " + results[8].getValue().toString()));
			}
			
			//Domain:
			if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setDomain(convertHexToString(results[9].getValue().toString().substring(2)));
				System.out.println(String.format("\tDomain: " + convertHexToString(results[9].getValue().toString().substring(2))));
			}
			else{
				cs.setDomain(results[9].getValue().toString());
				System.out.println(String.format("\tDomain: " + results[9].getValue().toString()));
			}
			
			//Workgroup:
			if((results[10].getValue().toString().length() >= 2) && (results[10].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setWorkgroup(convertHexToString(results[10].getValue().toString().substring(2)));
				System.out.println(String.format("\tWorkgroup: " + convertHexToString(results[10].getValue().toString().substring(2))));
			}
			else{
				cs.setWorkgroup(results[10].getValue().toString());
				System.out.println(String.format("\tWorkgroup: " + results[10].getValue().toString()));
			}
			
			//Status:
			if((results[11].getValue().toString().length() >= 2) && (results[11].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				cs.setStatus(convertHexToString(results[11].getValue().toString().substring(2)));
				System.out.println(String.format("\tStatus: " + convertHexToString(results[11].getValue().toString().substring(2))));
			}
			else{
				cs.setStatus(results[11].getValue().toString());
				System.out.println(String.format("\tStatus: " + results[11].getValue().toString()));
			}
	
			unit.setComputerSystem(cs);
	
			return true;
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getBaseBoard(ATM unit) {
	try {
	    String[] oids = { "1.3.6.1.4.1.191.117.27.1.7.1.0", // Name
		    "1.3.6.1.4.1.191.117.27.1.7.1.1", // Manufacturer
		    "1.3.6.1.4.1.191.117.27.1.7.1.2", // Model
		    "1.3.6.1.4.1.191.117.27.1.7.1.3", // Product
		    "1.3.6.1.4.1.191.117.27.1.7.1.4", // SerialNumber
		    "1.3.6.1.4.1.191.117.27.1.7.1.5" // Status
	    };

	    varbind[] results = snmputil.get(oids);
	    if (results != null && results.length == 6) {
		System.out.println("BaseBoard");
		/*+ results[0].toString() + "\n\tManufacturer --  "
			+ results[1].toString() + "\n\tModel --  "
			+ results[2].toString() + "\n\tProduct --  "
			+ results[3].toString() + "\n\tSerialNumber --  "
			+ results[4].toString() + "\n\tStatus --  "
			+ results[5].toString());*/

			BaseBoard bb = new BaseBoard();
			
			//Name:
			if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				bb.setName(convertHexToString(results[0].getValue().toString().substring(2)));
				System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
			}
			else{
				bb.setName(results[0].getValue().toString());
				System.out.println(String.format("\tName: " + results[0].getValue().toString()));
			}
			
			//Manufacturer:
			if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				bb.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
				System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
			}
			else{
				bb.setManufacturer(results[1].getValue().toString());
				System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
			}
			
			//Model:
			if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				bb.setModel(convertHexToString(results[2].getValue().toString().substring(2)));
				System.out.println(String.format("\tModel: " + convertHexToString(results[2].getValue().toString().substring(2))));
			}
			else{
				bb.setModel(results[2].getValue().toString());
				System.out.println(String.format("\tModel: " + results[2].getValue().toString()));
			}
			
			//Product:
			if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				bb.setProduct(convertHexToString(results[3].getValue().toString().substring(2)));
				System.out.println(String.format("\tProduct: " + convertHexToString(results[3].getValue().toString().substring(2))));
			}
			else{
				bb.setProduct(results[3].getValue().toString());
				System.out.println(String.format("\tProduct: " + results[3].getValue().toString()));
			}
			
			//Serial Number:
			if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				bb.setSerialNumber(convertHexToString(results[4].getValue().toString().substring(2)));
				System.out.println(String.format("\tSerial Number: " + convertHexToString(results[4].getValue().toString().substring(2))));
			}
			else{
				bb.setSerialNumber(results[4].getValue().toString());
				System.out.println(String.format("\tSerial Number: " + results[4].getValue().toString()));
			}
			
			//Status:
			if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				bb.setStatus(convertHexToString(results[5].getValue().toString().substring(2)));
				System.out.println(String.format("\tStatus: " + convertHexToString(results[5].getValue().toString().substring(2))));
			}
			else{
				bb.setStatus(results[5].getValue().toString());
				System.out.println(String.format("\tStatus: " + results[5].getValue().toString()));
			}
	
			unit.setBaseBoard(bb);
	
			return true;
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getBios(ATM unit) {
	try {
	    String[] oids = { "1.3.6.1.4.1.191.117.27.1.8.1.0", // Name
		    "1.3.6.1.4.1.191.117.27.1.8.1.1", // Manufacturer
		    "1.3.6.1.4.1.191.117.27.1.8.1.2", // SMBIOSBIOSVersion
		    "1.3.6.1.4.1.191.117.27.1.8.1.3", // SMBIOSMajorVersion
		    "1.3.6.1.4.1.191.117.27.1.8.1.4", // SMBIOSMinorVersion
		    "1.3.6.1.4.1.191.117.27.1.8.1.5", // Caption
		    "1.3.6.1.4.1.191.117.27.1.8.1.6", // CurrentLanguage
		    "1.3.6.1.4.1.191.117.27.1.8.1.7", // PrimaryBIOS
		    "1.3.6.1.4.1.191.117.27.1.8.1.8", // RealeaseDate
		    "1.3.6.1.4.1.191.117.27.1.8.1.9", // SerialNumber
		    "1.3.6.1.4.1.191.117.27.1.8.1.10", // SMBIOSPresent
		    "1.3.6.1.4.1.191.117.27.1.8.1.11", // Version
		    "1.3.6.1.4.1.191.117.27.1.8.1.12" // Status
	    };

	    varbind[] results = snmputil.get(oids);
	    if (results != null && results.length == 13) {
		System.out.println("Bios");
			/*\n\tName --  " + results[0].toString()
			+ "\n\tManufacturer --  " + results[1].toString()
			+ "\n\tSMBIOSBIOSVersion --  " + results[2].toString()
			+ "\n\tSMBIOSMajorVersion --  " + results[3].toString()
			+ "\n\tSMBIOSMinorVersion --  " + results[4].toString()
			+ "\n\tCaption --  " + results[5].toString()
			+ "\n\tCurrentLanguage --  " + results[6].toString()
			+ "\n\tPrimaryBIOS --  " + results[7].toString()
			+ "\n\tReleaseDate --  " + results[8].toString()
			+ "\n\tSerialNumber --  " + results[9].toString()
			+ "\n\tSMBIOSPresent --  " + results[10].toString()
			+ "\n\tVersion --  " + results[11].toString()
			+ "\n\tStatus --  " + results[12].toString());*/

			Bios b = new Bios();
			
			//Name:
			if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setName(convertHexToString(results[0].getValue().toString().substring(2)));
				System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
			}
			else{
				b.setName(results[0].getValue().toString());
				System.out.println(String.format("\tName: " + results[0].getValue().toString()));
			}
			
			//Manufacturer:
			if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
				System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
			}
			else{
				b.setManufacturer(results[1].getValue().toString());
				System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
			}
			
			//SMBiosVersion:
			if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setSmBIOSVersion(convertHexToString(results[2].getValue().toString().substring(2)));
				System.out.println(String.format("\tSmBIOSVersion: " + convertHexToString(results[2].getValue().toString().substring(2))));
			}
			else{
				b.setSmBIOSVersion(results[2].getValue().toString());
				System.out.println(String.format("\tSmBIOSVersion: " + results[2].getValue().toString()));
			}
			
			//SMBiosMajorVersion:
			if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setName(convertHexToString(results[3].getValue().toString().substring(2)));
				System.out.println(String.format("\tSmBIOSMajorVersion: " + convertHexToString(results[3].getValue().toString().substring(2))));
			}
			else{
				b.setSmBIOSMajorVersion(results[3].getValue().toString());
				System.out.println(String.format("\tSmBIOSMajorVersion: " + results[3].getValue().toString()));
			}
			
			//SMBiosMinorVersion:
			if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setSmBIOSMinorVersion(convertHexToString(results[4].getValue().toString().substring(2)));
				System.out.println(String.format("\tSmBIOSMinorVersion: " + convertHexToString(results[4].getValue().toString().substring(2))));
			}
			else{
				b.setSmBIOSMinorVersion(results[4].getValue().toString());
				System.out.println(String.format("\tSmBIOSMinorVersion: " + results[4].getValue().toString()));
			}
			
			//Caption:
			if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setCaption(convertHexToString(results[5].getValue().toString().substring(2)));
				System.out.println(String.format("\tCaption: " + convertHexToString(results[5].getValue().toString().substring(2))));
			}
			else{
				b.setCaption(results[5].getValue().toString());
				System.out.println(String.format("\tCaption: " + results[5].getValue().toString()));
			}
			
			//CurrentLanguage:
			if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setCurrentLanguage(convertHexToString(results[6].getValue().toString().substring(2)));
				System.out.println(String.format("\tCurrentLanguage: " + convertHexToString(results[6].getValue().toString().substring(2))));
			}
			else{
				b.setCurrentLanguage(results[6].getValue().toString());
				System.out.println(String.format("\tCurrentLanguage: " + results[6].getValue().toString()));
			}
			
			//Primary Bios
			if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setPrimaryBIOS(convertHexToString(results[7].getValue().toString().substring(2)));
				System.out.println(String.format("\tPrimary Bios: " + convertHexToString(results[7].getValue().toString().substring(2))));
			}
			else{
				b.setPrimaryBIOS(results[7].getValue().toString());
				System.out.println(String.format("\tPrimary Bios: " + results[7].getValue().toString()));
			}
			
			//Release Note:
			if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setReleaseDate(convertHexToString(results[8].getValue().toString().substring(2)));
				System.out.println(String.format("\tRelease Note: " + convertHexToString(results[8].getValue().toString().substring(2))));
			}
			else{
				b.setReleaseDate(results[8].getValue().toString());
				System.out.println(String.format("\tRelease Note: " + results[8].getValue().toString()));
			}
			
			//Serial Number:
			if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setSerialNumber(convertHexToString(results[9].getValue().toString().substring(2)));
				System.out.println(String.format("\tSerial Number: " + convertHexToString(results[9].getValue().toString().substring(2))));
			}
			else{
				b.setSerialNumber(results[9].getValue().toString());
				System.out.println(String.format("\tSerial Number: " + results[9].getValue().toString()));
			}
			
			//SMBiosPresent:
			if((results[10].getValue().toString().length() >= 2) && (results[10].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setSmBIOSPresent(convertHexToString(results[10].getValue().toString().substring(2)));
				System.out.println(String.format("\tSmBIOSPresent: " + convertHexToString(results[10].getValue().toString().substring(2))));
			}
			else{
				b.setSmBIOSPresent(results[10].getValue().toString());
				System.out.println(String.format("\tSmBIOSPresent: " + results[10].getValue().toString()));
			}
			
			//Version:
			if((results[11].getValue().toString().length() >= 2) && (results[11].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setVersion(convertHexToString(results[11].getValue().toString().substring(2)));
				System.out.println(String.format("\tVersion: " + convertHexToString(results[11].getValue().toString().substring(2))));
			}
			else{
				b.setVersion(results[11].getValue().toString());
				System.out.println(String.format("\tVersion: " + results[11].getValue().toString()));
			}
			
			//Status:
			if((results[12].getValue().toString().length() >= 2) && (results[12].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				b.setStatus(convertHexToString(results[12].getValue().toString().substring(2)));
				System.out.println(String.format("\tStatus: " + convertHexToString(results[12].getValue().toString().substring(2))));
			}
			else{
				b.setStatus(results[12].getValue().toString());
				System.out.println(String.format("\tStatus: " + results[12].getValue().toString()));
			}
	
			unit.setBios(b);
	
			return true;
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getPhysicalMemory(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.9.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.9.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.9.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.9.%d.2", i + 2), // Capacity
				String.format("1.3.6.1.4.1.191.117.27.1.9.%d.3", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 4) {
			    System.out.println(String.format("PhysicalMemory - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tCapacity --  " + results[2].toString()
				    + "\n\tStatus --  " + results[3].toString());*/
	
			    PhysicalMemory pm = new PhysicalMemory();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pm.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					pm.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pm.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					pm.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Capacity:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pm.setCapacity(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCapacity: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					pm.setCapacity(results[2].getValue().toString());
					System.out.println(String.format("\tCapacity: " + results[2].getValue().toString()));
				}
			    
			    //Status:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pm.setStatus(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					pm.setStatus(results[3].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[3].getValue().toString()));
				}
	
			    unit.setPhysicalMemory(pm);
			}
		}
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getProcessor(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.10.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.2", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.3", i + 2), // Architecture
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.4", i + 2), // CurrentClockSpeed
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.5", i + 2), // MaxClockSpeed
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.6", i + 2), // ExtClock
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.7", i + 2), // NumberOfCores
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.8", i + 2), // AddressWidth
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.9", i + 2), // DataWidth
				String.format("1.3.6.1.4.1.191.117.27.1.10.%d.10",
					i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 11) {
			    System.out.println(String.format("Processor - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tCaption --  " + results[1].toString()
				    + "\n\tManufacturer --  " + results[2].toString()
				    + "\n\tArchitecture --  " + results[3].toString()
				    + "\n\tCurrentClockSpeed --  "
				    + results[4].toString() + "\n\tMaxClockSpeed --  "
				    + results[5].toString() + "\n\tExtClock --  "
				    + results[6].toString() + "\n\tNumberOfCores --  "
				    + results[7].toString() + "\n\tAddressWidth --  "
				    + results[8].toString() + "\n\tDataWidth --  "
				    + results[9].toString() + "\n\tStatus --  "
				    + results[10].toString());*/
	
			    Processor p = new Processor();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					p.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					p.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setManufacturer(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					p.setManufacturer(results[2].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[2].getValue().toString()));
				}
			    
			    //Architecture:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setArchitecture(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tArchitecture: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					p.setArchitecture(results[3].getValue().toString());
					System.out.println(String.format("\tArchitecture: " + results[3].getValue().toString()));
				}
			    
			    //CurrentClockSpeed:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setCurrentClockSpeed(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tCurrentClockSpeed: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					p.setCurrentClockSpeed(results[4].getValue().toString());
					System.out.println(String.format("\tCurrentClockSpeed: " + results[4].getValue().toString()));
				}
			    
			    //MaxClockSpeed:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setMaxClockSpeed(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tMaxClockSpeed: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					p.setMaxClockSpeed(results[5].getValue().toString());
					System.out.println(String.format("\tMaxClockSpeed: " + results[5].getValue().toString()));
				}
			    
			    //ExtClock:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setExtClock(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tExtClock: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					p.setExtClock(results[6].getValue().toString());
					System.out.println(String.format("\tExtClock: " + results[6].getValue().toString()));
				}
			    
			    //NumberOfCores:
			    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setNumberOfCores(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tNumber Of Cores: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					p.setNumberOfCores(results[7].getValue().toString());
					System.out.println(String.format("\tNumber Of Cores: " + results[7].getValue().toString()));
				}
			    
			    //AddressWidth:
			    if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setAddressWidth(convertHexToString(results[8].getValue().toString().substring(2)));
					System.out.println(String.format("\tAddressWidth: " + convertHexToString(results[8].getValue().toString().substring(2))));
				}
				else{
					p.setAddressWidth(results[8].getValue().toString());
					System.out.println(String.format("\tAddressWidth: " + results[8].getValue().toString()));
				}
			    
			    //DataWidth:
			    if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setDataWidth(convertHexToString(results[9].getValue().toString().substring(2)));
					System.out.println(String.format("\tDataWidth: " + convertHexToString(results[9].getValue().toString().substring(2))));
				}
				else{
					p.setDataWidth(results[9].getValue().toString());
					System.out.println(String.format("\tDataWidth: " + results[9].getValue().toString()));
				}
			    
			    //Status:
			    if((results[10].getValue().toString().length() >= 2) && (results[10].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					p.setStatus(convertHexToString(results[10].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[10].getValue().toString().substring(2))));
				}
				else{
					p.setStatus(results[10].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[10].getValue().toString()));
				}
	
			    unit.setProcessor(p);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getDiskDrive(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.11.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.2", i + 2), // Model
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.3", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.4", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.5", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.6", i + 2), // FirmwareRevision
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.7", i + 2), // SerialNumber
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.8", i + 2), // MediaType
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.9", i + 2), // MaxMediaSize
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.10",i + 2), // Size
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.11",i + 2), // TotalCylinders
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.12",i + 2), // TracksPerCylinder
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.13",i + 2), // SectorsPerTrack
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.14",i + 2), // BytesPerSector
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.15",i + 2), // Partitions
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.16",i + 2), // Signature
				String.format("1.3.6.1.4.1.191.117.27.1.11.%d.17",i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 18) {
			    System.out.println(String.format("DiskDrive - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tModel --  " + results[2].toString()
				    + "\n\tCaption --  " + results[3].toString()
				    + "\n\tDescription --  " + results[4].toString()
				    + "\n\tDeviceID --  " + results[5].toString()
				    + "\n\tFirmwareRevision --  "
				    + results[6].toString() + "\n\tSerialNumber --  "
				    + results[7].toString() + "\n\tMediaType --  "
				    + results[8].toString() + "\n\tMaxMediaSize --  "
				    + results[9].toString() + "\n\tSize --  "
				    + results[10].toString()
				    + "\n\tTotalCylinders --  "
				    + results[11].toString()
				    + "\n\tTracksPerCylinder --  "
				    + results[12].toString()
				    + "\n\tSectorsPerTrack --  "
				    + results[13].toString()
				    + "\n\tBytesPerSector --  "
				    + results[14].toString() + "\n\tPartitions --  "
				    + results[15].toString() + "\n\tSignature --  "
				    + results[16].toString() + "\n\tStatus --  "
				    + results[17].toString());*/
	
			    DiskDrive dd = new DiskDrive();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					dd.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					dd.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Model:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setModel(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tModel: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					dd.setModel(results[2].getValue().toString());
					System.out.println(String.format("\tModel: " + results[2].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setCaption(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					dd.setCaption(results[3].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[3].getValue().toString()));
				}
			    
			    //Description:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setDescription(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					dd.setDescription(results[4].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[4].getValue().toString()));
				}
			    
			    //DeviceId:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setDeviceID(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceId: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					dd.setDeviceID(results[5].getValue().toString());
					System.out.println(String.format("\tDeviceId: " + results[5].getValue().toString()));
				}
			    
			    //Firmware Revision:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setFirmwareRevision(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tFirmware Revision: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					dd.setFirmwareRevision(results[6].getValue().toString());
					System.out.println(String.format("\tFirmware Revision: " + results[6].getValue().toString()));
				}
			    
			    //Serial Number:
			    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setSerialNumber(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tSerial Number: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					dd.setSerialNumber(results[7].getValue().toString());
					System.out.println(String.format("\tSerial Number: " + results[7].getValue().toString()));
				}
			    
			    //Media Type:
			    if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setMediaType(convertHexToString(results[8].getValue().toString().substring(2)));
					System.out.println(String.format("\tMedia Type: " + convertHexToString(results[8].getValue().toString().substring(2))));
				}
				else{
					dd.setMediaType(results[8].getValue().toString());
					System.out.println(String.format("\tMedia Type: " + results[8].getValue().toString()));
				}
			    
			    //MaxMediaSize
			    if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setMaxMediaSize(convertHexToString(results[9].getValue().toString().substring(2)));
					System.out.println(String.format("\tMaxMediaSize: " + convertHexToString(results[9].getValue().toString().substring(2))));
				}
				else{
					dd.setMaxMediaSize(results[9].getValue().toString());
					System.out.println(String.format("\tMaxMediaSize: " + results[9].getValue().toString()));
				}
			    
			    //Size:
			    if((results[10].getValue().toString().length() >= 2) && (results[10].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setSize(convertHexToString(results[10].getValue().toString().substring(2)));
					System.out.println(String.format("\tSize: " + convertHexToString(results[10].getValue().toString().substring(2))));
				}
				else{
					dd.setSize(results[10].getValue().toString());
					System.out.println(String.format("\tSize: " + results[10].getValue().toString()));
				}
			    
			    //TotalCylinders
			    if((results[11].getValue().toString().length() >= 2) && (results[11].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setTotalCylinders(convertHexToString(results[11].getValue().toString().substring(2)));
					System.out.println(String.format("\tTotalCylinders: " + convertHexToString(results[11].getValue().toString().substring(2))));
				}
				else{
					dd.setTotalCylinders(results[11].getValue().toString());
					System.out.println(String.format("\tTotalCylinders: " + results[11].getValue().toString()));
				}
			    
			    //TracksPerCylinder
			    if((results[12].getValue().toString().length() >= 2) && (results[12].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setTracksPerCylinder(convertHexToString(results[12].getValue().toString().substring(2)));
					System.out.println(String.format("\tTracksPerCylinder: " + convertHexToString(results[12].getValue().toString().substring(2))));
				}
				else{
					dd.setTracksPerCylinder(results[12].getValue().toString());
					System.out.println(String.format("\tTracksPerCylinder: " + results[12].getValue().toString()));
				}
			    
			    //SectorsPerTrack
			    if((results[13].getValue().toString().length() >= 2) && (results[13].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setSectorsPerTrack(convertHexToString(results[13].getValue().toString().substring(2)));
					System.out.println(String.format("\tSectorsPerTrack: " + convertHexToString(results[13].getValue().toString().substring(2))));
				}
				else{
					dd.setSectorsPerTrack(results[13].getValue().toString());
					System.out.println(String.format("\tSectorsPerTrack: " + results[13].getValue().toString()));
				}
			    
			    //BytesPerSector
			    if((results[14].getValue().toString().length() >= 2) && (results[14].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setBytesPerSector(convertHexToString(results[14].getValue().toString().substring(2)));
					System.out.println(String.format("\tBytesPerSector: " + convertHexToString(results[14].getValue().toString().substring(2))));
				}
				else{
					dd.setBytesPerSector(results[14].getValue().toString());
					System.out.println(String.format("\tBytesPerSector: " + results[14].getValue().toString()));
				}
			    
			    //Partitions
			    if((results[5].getValue().toString().length() >= 2) && (results[15].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setPartitions(convertHexToString(results[15].getValue().toString().substring(2)));
					System.out.println(String.format("\tPartitions: " + convertHexToString(results[15].getValue().toString().substring(2))));
				}
				else{
					dd.setPartitions(results[15].getValue().toString());
					System.out.println(String.format("\tPartitions: " + results[15].getValue().toString()));
				}
			    
			    //Signature:
			    if((results[16].getValue().toString().length() >= 2) && (results[16].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setSignature(convertHexToString(results[16].getValue().toString().substring(2)));
					System.out.println(String.format("\tSignature: " + convertHexToString(results[16].getValue().toString().substring(2))));
				}
				else{
					dd.setSignature(results[16].getValue().toString());
					System.out.println(String.format("\tSignature: " + results[16].getValue().toString()));
				}
			    
			    //Status
			    if((results[17].getValue().toString().length() >= 2) && (results[17].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dd.setStatus(convertHexToString(results[17].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[17].getValue().toString().substring(2))));
				}
				else{
					dd.setStatus(results[17].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[17].getValue().toString()));
				}
	
			    unit.setDiskDrive(dd);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getCDROMDrive(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.12.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.12.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.12.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.12.%d.2", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.12.%d.3", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.12.%d.4", i + 2), // MediaType
				String.format("1.3.6.1.4.1.191.117.27.1.12.%d.5", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 6) {
			    System.out.println(String.format("CDROMDrive - #%d", i));
				   /* + "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tCaption --  " + results[2].toString()
				    + "\n\tDeviceID --  " + results[3].toString()
				    + "\n\tMediaType --  " + results[4].toString()
				    + "\n\tStatus --  " + results[5].toString());*/
	
			    CDROMDrive cd = new CDROMDrive();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					cd.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					cd.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					cd.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					cd.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					cd.setCaption(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					cd.setCaption(results[2].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[2].getValue().toString()));
				}
			    
			    //DeviceID:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					cd.setDeviceID(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceID: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					cd.setDeviceID(results[3].getValue().toString());
					System.out.println(String.format("\tDeviceID: " + results[3].getValue().toString()));
				}
			    
			    //MediaType:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					cd.setMediaType(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tMediaType: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					cd.setMediaType(results[4].getValue().toString());
					System.out.println(String.format("\tMediaType: " + results[4].getValue().toString()));
				}
			    
			    //Status:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					cd.setStatus(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					cd.setStatus(results[5].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[5].getValue().toString()));
				}
	
			    unit.setCDROMDrive(cd);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getFloppyDrive(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.13.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.13.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.13.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.13.%d.2", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.13.%d.3", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.13.%d.4", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.13.%d.5", i + 2), // MediaType
				String.format("1.3.6.1.4.1.191.117.27.1.13.%d.6", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 7) {
			    System.out.println(String.format("FloppyDrive - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tCaption --  " + results[2].toString()
				    + "\n\tDescription --  " + results[3].toString()
				    + "\n\tDeviceID --  " + results[4].toString()
				    + "\n\tMediaType --  " + results[5].toString()
				    + "\n\tStatus --  " + results[6].toString());*/
	
			    FloppyDrive fd = new FloppyDrive();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					fd.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					fd.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					fd.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					fd.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					fd.setCaption(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					fd.setCaption(results[2].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[2].getValue().toString()));
				}
			    
			    //Description:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					fd.setDescription(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					fd.setDescription(results[3].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[3].getValue().toString()));
				}
			    
			    //DeviceID
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					fd.setDeviceID(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceId: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					fd.setDeviceID(results[4].getValue().toString());
					System.out.println(String.format("\tDeviceId: " + results[4].getValue().toString()));
				}
			    
			    //MediaType
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					fd.setMediaType(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tMediaType: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					fd.setMediaType(results[5].getValue().toString());
					System.out.println(String.format("\tMediaType: " + results[5].getValue().toString()));
				}
			    
			    //Status:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					fd.setStatus(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					fd.setStatus(results[6].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[6].getValue().toString()));
				}
	
			    unit.setFloppyDrive(fd);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getLogicalDisk(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.14.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.1", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.2", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.3", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.4", i + 2), // Size
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.5", i + 2), // FreeSpace
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.6", i + 2), // FileSystem
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.7", i + 2), // VolumeName
				String.format("1.3.6.1.4.1.191.117.27.1.14.%d.8", i + 2) // VolumeSerialNumber
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 9) {
			    System.out.println(String.format("LogicalDisk - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tDescription --  " + results[1].toString()
				    + "\n\tCaption --  " + results[2].toString()
				    + "\n\tDeviceID --  " + results[3].toString()
				    + "\n\tSize --  " + results[4].toString()
				    + "\n\tFreeSpace --  " + results[5].toString()
				    + "\n\tFileSystem --  " + results[6].toString()
				    + "\n\tVolumeName --  " + results[7].toString()
				    + "\n\tVolumeSerialNumber --  "
				    + results[8].toString());*/
	
			    LogicalDisk ld = new LogicalDisk();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					ld.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Description:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setDescription(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					ld.setDescription(results[1].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[1].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setCaption(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					ld.setCaption(results[2].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[2].getValue().toString()));
				}
			    
			    //DeviceID:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setDeviceID(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceID: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					ld.setDeviceID(results[3].getValue().toString());
					System.out.println(String.format("\tDeviceID: " + results[3].getValue().toString()));
				}
			    
			    //Size:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setSize(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tSize: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					ld.setSize(results[4].getValue().toString());
					System.out.println(String.format("\tSize: " + results[4].getValue().toString()));
				}
			    
			    //FreeSpace:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setFreeSpace(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tFreeSpace: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					ld.setFreeSpace(results[5].getValue().toString());
					System.out.println(String.format("\tFreeSpace: " + results[5].getValue().toString()));
				}
			    
			    //FileSystem:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setFileSystem(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tFile System: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					ld.setFileSystem(results[6].getValue().toString());
					System.out.println(String.format("\tFile System: " + results[6].getValue().toString()));
				}
			    
			    //Volume Name:
			    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setVolumeName(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tVolume Name: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					ld.setVolumeName(results[7].getValue().toString());
					System.out.println(String.format("\tVolume Name: " + results[7].getValue().toString()));
				}
			    
			    //VolumeSerialNumber:
			    if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ld.setVolumeSerialNumber(convertHexToString(results[8].getValue().toString().substring(2)));
					System.out.println(String.format("\tVolume Serial Number: " + convertHexToString(results[8].getValue().toString().substring(2))));
				}
				else{
					ld.setVolumeSerialNumber(results[8].getValue().toString());
					System.out.println(String.format("\tVolume: " + results[8].getValue().toString()));
				}
	
			    unit.setLogicalDisk(ld);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getVideoController(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.15.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.1", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.2", i + 2), // VideoProcessor
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.3", i + 2), // AdapterRAM
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.4", i + 2), // CurrentBitsPerPixel
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.5", i + 2), // CurrentNumberOfColors
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.6", i + 2), // CurrentHorizontalResolution
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.7", i + 2), // CurrentVerticalResolution
				String.format("1.3.6.1.4.1.191.117.27.1.15.%d.8", i + 2) // CurrentRefreshRate
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 9) {
			    System.out.println(String
				    .format("VideoController - #%d", i));
				    /*+ "\n\tName --  "
				    + results[0].toString()
				    + "\n\tDescription --  "
				    + results[1].toString()
				    + "\n\tVideoProcessor --  "
				    + results[2].toString()
				    + "\n\tAdapterRAM --  "
				    + results[3].toString()
				    + "\n\tCurrentBitsPerPixel --  "
				    + results[4].toString()
				    + "\n\tCurrentNumberOfColors --  "
				    + results[5].toString()
				    + "\n\tCurrentHorizontalResolution --  "
				    + results[6].toString()
				    + "\n\tCurrentVerticalResolution --  "
				    + results[7].toString()
				    + "\n\tCurrentRefreshRate --  "
				    + results[8].toString());*/
	
			    VideoController vc = new VideoController();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					vc.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Description:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setDescription(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					vc.setDescription(results[1].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[1].getValue().toString()));
				}
			    
			    //Video Processor:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setVideoProcessor(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tVideoProcessor: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					vc.setVideoProcessor(results[2].getValue().toString());
					System.out.println(String.format("\tVideoProcessor: " + results[2].getValue().toString()));
				}
			    
			    //AdapterRAM:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setAdapterRAM(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tAdapterRAM: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					vc.setAdapterRAM(results[3].getValue().toString());
					System.out.println(String.format("\tAdapterRAM: " + results[3].getValue().toString()));
				}
			    
			    //CurrentBitsPerPixel
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setCurrentBitsPerPixel(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tCurrentBitsPerPixel: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					vc.setCurrentBitsPerPixel(results[4].getValue().toString());
					System.out.println(String.format("\tCurrentBitsPerPixel: " + results[4].getValue().toString()));
				}
			    
			    //CurrentNumberOfColors:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setCurrentNumberOfColors(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tCurrentNumberOfColors: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					vc.setCurrentNumberOfColors(results[5].getValue().toString());
					System.out.println(String.format("\tCurrentNumberOfColors: " + results[5].getValue().toString()));
				}
			    
			    //CurrentHorizontalResolution:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setCurrentHorizontalResolution(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tCurrentHorizontalResolution: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					vc.setCurrentHorizontalResolution(results[6].getValue().toString());
					System.out.println(String.format("\tCurrentHorizontalResolution: " + results[6].getValue().toString()));
				}
			    
			    //CurrentVerticalResolution:
			    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setCurrentVerticalResolution(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tCurrentVerticalResolution: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					vc.setCurrentVerticalResolution(results[7].getValue().toString());
					System.out.println(String.format("\tCurrentVerticalResolution: " + results[7].getValue().toString()));
				}
			    
			    //CurrentRefreshRate:
			    if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					vc.setCurrentRefreshRate(convertHexToString(results[8].getValue().toString().substring(2)));
					System.out.println(String.format("\tCurrentRefreshRate: " + convertHexToString(results[8].getValue().toString().substring(2))));
				}
				else{
					vc.setCurrentRefreshRate(results[8].getValue().toString());
					System.out.println(String.format("\tCurrentRefreshRate: " + results[8].getValue().toString()));
				}
	
			    unit.setVideoController(vc);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getSerialPort(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.16.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.16.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.16.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.16.%d.2", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.16.%d.3", i + 2), // MaxBaudRate
				String.format("1.3.6.1.4.1.191.117.27.1.16.%d.4", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 5) {
			    System.out.println(String.format("SerialPort - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tCaption --  " + results[1].toString()
				    + "\n\tDeviceID --  " + results[2].toString()
				    + "\n\tMaxBaudRate --  " + results[3].toString()
				    + "\n\tStatus --  " + results[4].toString());*/
	
			    SerialPort sp = new SerialPort();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sp.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					sp.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sp.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					sp.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
			    //DeviceId:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sp.setDeviceID(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceID: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					sp.setDeviceID(results[2].getValue().toString());
					System.out.println(String.format("\tDeviceID: " + results[2].getValue().toString()));
				}
			    
			    //MaxBaudRate:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sp.setMaxBaudRate(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tMaxBaudRate: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					sp.setMaxBaudRate(results[3].getValue().toString());
					System.out.println(String.format("\tMaxBaudRate: " + results[3].getValue().toString()));
				}
			    
			    //Status:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sp.setStatus(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					sp.setStatus(results[4].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[4].getValue().toString()));
				}
	
			    unit.setSerialPort(sp);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getParallelPort(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.17.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.17.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.17.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.17.%d.2", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.17.%d.3", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 4) {
			    System.out.println(String.format("ParallelPort - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tCaption --  " + results[1].toString()
				    + "\n\tDeviceID --  " + results[2].toString()
				    + "\n\tStatus --  " + results[3].toString());*/
	
			    ParallelPort pp = new ParallelPort();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pp.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					pp.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pp.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					pp.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
			    //DeviceID:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pp.setDeviceID(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceID: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					pp.setDeviceID(results[2].getValue().toString());
					System.out.println(String.format("\tDeviceID: " + results[2].getValue().toString()));
				}
			    
			    //Status:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pp.setStatus(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					pp.setStatus(results[3].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[3].getValue().toString()));
				}
	
			    unit.setParallelPort(pp);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getSCSIController(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.18.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.18.%d.0", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.18.%d.1", i + 2), // HotfixID
				String.format("1.3.6.1.4.1.191.117.27.1.18.%d.2", i + 2), // InstalledOn
				String.format("1.3.6.1.4.1.191.117.27.1.18.%d.3", i + 2), // FixComments
				String.format("1.3.6.1.4.1.191.117.27.1.18.%d.4", i + 2), // HotfixID
				String.format("1.3.6.1.4.1.191.117.27.1.18.%d.5", i + 2), // InstalledOn
				String.format("1.3.6.1.4.1.191.117.27.1.18.%d.6", i + 2) // FixComments};
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 7) {
			    System.out.println(String.format("SCSIController - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tCaption --  " + results[2].toString()
				    + "\n\tDescription --  " + results[3].toString()
				    + "\n\tHardwareVersion --  "
				    + results[4].toString() + "\n\tDriverName --  "
				    + results[5].toString() + "\n\tStatusInfo --  "
				    + results[6].toString());*/
	
			    SCSIController sc = new SCSIController();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sc.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					sc.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sc.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					sc.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sc.setCaption(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					sc.setCaption(results[2].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[2].getValue().toString()));
				}
			    
			    //Description:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sc.setDescription(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					sc.setDescription(results[3].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[3].getValue().toString()));
				}
			    
			    //HardwareVersion:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sc.setHardwareVersion(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tHardwareVersion: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					sc.setHardwareVersion(results[4].getValue().toString());
					System.out.println(String.format("\tHardwareVersion: " + results[4].getValue().toString()));
				}
			    
			    //DriverName:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sc.setDriverName(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tDriverName: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					sc.setDriverName(results[5].getValue().toString());
					System.out.println(String.format("\tDriverName: " + results[5].getValue().toString()));
				}
			    
			    //Status Info:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sc.setStatusInfo(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus Info: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					sc.setStatusInfo(results[6].getValue().toString());
					System.out.println(String.format("\tStatus Info: " + results[6].getValue().toString()));
				}
	
			    unit.setSCSIController(sc);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getUSBController(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.19.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.19.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.19.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.19.%d.2", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.19.%d.3", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.19.%d.4", i + 2), // ProtocolSupported
				String.format("1.3.6.1.4.1.191.117.27.1.19.%d.5", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 6) {
			    System.out.println(String.format("USBController - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tCaption --  " + results[1].toString()
				    + "\n\tDeviceID --  " + results[2].toString()
				    + "\n\tManufacturer --  " + results[3].toString()
				    + "\n\tProtocolSupported --  "
				    + results[4].toString() + "\n\tStatus --  "
				    + results[5].toString());*/
	
			    USBController uc = new USBController();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uc.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					uc.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uc.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					uc.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
			    //DeviceID:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uc.setDeviceID(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceID: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					uc.setDeviceID(results[2].getValue().toString());
					System.out.println(String.format("\tDeviceID: " + results[2].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uc.setManufacturer(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					uc.setManufacturer(results[3].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[3].getValue().toString()));
				}
			    
			    //Protocol Supported:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uc.setProtocolSupported(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tProtocolSupported: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					uc.setProtocolSupported(results[4].getValue().toString());
					System.out.println(String.format("\tProtocolSupported: " + results[4].getValue().toString()));
				}
			    
			    //Status:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uc.setStatus(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					uc.setStatus(results[5].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[5].getValue().toString()));
				}
	
			    unit.setUSBController(uc);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getUsbHub(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.20.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.20.%d.0", i + 2), // NumberOfPorts
				String.format("1.3.6.1.4.1.191.117.27.1.20.%d.1", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.20.%d.2", i + 2), // ProtocolCode
				String.format("1.3.6.1.4.1.191.117.27.1.20.%d.3", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.20.%d.4", i + 2), // USBVersion
				String.format("1.3.6.1.4.1.191.117.27.1.20.%d.5", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 6) {
			    System.out.println(String.format("UsbHub - #%d", i));
				    /*+ "\n\tNumberOfPorts --  " + results[0].toString()
				    + "\n\tName --  " + results[1].toString()
				    + "\n\tProtocolCode --  " + results[2].toString()
				    + "\n\tDescription --  " + results[3].toString()
				    + "\n\tUSBVersion --  " + results[4].toString()
				    + "\n\tStatus --  " + results[5].toString());*/
	
			    UsbHub uh = new UsbHub();
			    
			    //NumberOfPorts:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uh.setNumberOfPorts(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tNumberOfPorts: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					uh.setNumberOfPorts(results[0].getValue().toString());
					System.out.println(String.format("\tNumberOfPorts: " + results[0].getValue().toString()));
				}
			    
			    //Name:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uh.setName(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					uh.setName(results[1].getValue().toString());
					System.out.println(String.format("\tName: " + results[1].getValue().toString()));
				}
			    
			    //ProtocolCode:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uh.setProtocolCode(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tProtocolCode: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					uh.setProtocolCode(results[2].getValue().toString());
					System.out.println(String.format("\tProtocolCode: " + results[2].getValue().toString()));
				}
			    
			    //Description:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uh.setDescription(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					uh.setDescription(results[3].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[3].getValue().toString()));
				}
			    
			    //Version:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uh.setUsbVersion(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tVersion: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					uh.setUsbVersion(results[4].getValue().toString());
					System.out.println(String.format("\tVersion: " + results[4].getValue().toString()));
				}
			    
			    //Status
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					uh.setStatus(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					uh.setStatus(results[5].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[5].getValue().toString()));
				}
	
			    unit.setUsbHub(uh);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getSoundDevice(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.21.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.21.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.21.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.21.%d.2", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.21.%d.3", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 4) {
			    System.out.println(String.format("SoundDevice - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tCaption --  " + results[2].toString()
				    + "\n\tStatus --  " + results[3].toString());*/
	
			    SoundDevice sd = new SoundDevice();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sd.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					sd.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sd.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					sd.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sd.setCaption(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					sd.setCaption(results[2].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[2].getValue().toString()));
				}
			    
			    //Status:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					sd.setStatus(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					sd.setStatus(results[3].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[3].getValue().toString()));
				}
	
			    unit.setSoundDevice(sd);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getNetworkAdapterSetting(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.22.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.2", i + 2), // AdapterType
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.3", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.4", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.5", i + 2), // DHCPEnabled
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.6", i + 2), // DHCPServer
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.7", i + 2), // IPAddress
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.8", i + 2), // IPSubnet
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.9", i + 2), // DefaultIPGateway
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.10",i + 2), // MacAddress
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.11",i + 2), // Speed
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.12",i + 2), // NetConnectionID
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.13",i + 2), // NetConnectionStatus
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.14",i + 2), // InterfaceIndex
				String.format("1.3.6.1.4.1.191.117.27.1.22.%d.15",i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 16) {
			    System.out.println(String.format("NetworkAdapterSetting - #%d", i));
				    /*+ "\n\tName --  "
				    + results[0].toString()
				    + "\n\tManufacturer --  "
				    + results[1].toString()
				    + "\n\tAdapterType --  "
				    + results[2].toString()
				    + "\n\tCaption --  "
				    + results[3].toString()
				    + "\n\tDescription --  "
				    + results[4].toString()
				    + "\n\tDHCPEnabled --  "
				    + results[5].toString()
				    + "\n\tDHCPServer --  "
				    + results[6].toString()
				    + "\n\tIPAddress --  "
				    + results[7].toString()
				    + "\n\tIPSubnet --  "
				    + results[8].toString()
				    + "\n\tDefaultIPGateway --  "
				    + results[9].toString()
				    + "\n\tMacAddress --  "
				    + results[10].toString()
				    + "\n\tSpeed --  "
				    + results[11].toString()
				    + "\n\tNetConnectionID --  "
				    + results[12].toString()
				    + "\n\tNetConnectionStatus --  "
				    + results[13].toString()
				    + "\n\tInterfaceIndex --  "
				    + results[14].toString()
				    + "\n\tStatus --  "
				    + results[15].toString());*/
	
			    NetworkAdapterSetting nas = new NetworkAdapterSetting();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					nas.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					nas.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tMnufacturer: " + results[1].getValue().toString()));
				}
			    
			    //AdapterType:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setAdapterType(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tAdapterType: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					nas.setAdapterType(results[2].getValue().toString());
					System.out.println(String.format("\tAdapterType: " + results[2].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setCaption(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					nas.setCaption(results[3].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[3].getValue().toString()));
				}
			    
			    //Description:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setDescription(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					nas.setDescription(results[4].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[4].getValue().toString()));
				}
			    
			    //DhcpEnabled:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setDhcpEnabled(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tDhcpEnabled: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					nas.setDhcpEnabled(results[5].getValue().toString());
					System.out.println(String.format("\tDhcpEnabled: " + results[5].getValue().toString()));
				}
			    
			    //DhcpServer:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setDhcpServer(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tDhcpServer: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					nas.setDhcpServer(results[6].getValue().toString());
					System.out.println(String.format("\tDhcpServer: " + results[6].getValue().toString()));
				}
			    
			    //IpAddress:
			    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setIpAddress(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tIpAddress: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					nas.setIpAddress(results[7].getValue().toString());
					System.out.println(String.format("\tIpAddress: " + results[7].getValue().toString()));
				}
			    
			    //IpSubnet:
			    if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setIpSubnet(convertHexToString(results[8].getValue().toString().substring(2)));
					System.out.println(String.format("\tIpSubnet: " + convertHexToString(results[8].getValue().toString().substring(2))));
				}
				else{
					nas.setIpSubnet(results[8].getValue().toString());
					System.out.println(String.format("\tIpSubnet: " + results[8].getValue().toString()));
				}
			    
			    //DefaultIpGateway:
			    if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setDefaultIPGateway(convertHexToString(results[9].getValue().toString().substring(2)));
					System.out.println(String.format("\tDefaultIpGateway: " + convertHexToString(results[9].getValue().toString().substring(2))));
				}
				else{
					nas.setDefaultIPGateway(results[9].getValue().toString());
					System.out.println(String.format("\tDefaultIpGateway: " + results[9].getValue().toString()));
				}
			    
			    //MacAddress:
			    if((results[10].getValue().toString().length() >= 2) && (results[10].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setMacAddress(convertHexToString(results[10].getValue().toString().substring(2)));
					System.out.println(String.format("\tMacAddress: " + convertHexToString(results[10].getValue().toString().substring(2))));
				}
				else{
					nas.setMacAddress(results[10].getValue().toString());
					System.out.println(String.format("\tMacAddress: " + results[10].getValue().toString()));
				}
			    
			    //Speed:
			    if((results[11].getValue().toString().length() >= 2) && (results[11].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setSpeed(convertHexToString(results[11].getValue().toString().substring(2)));
					System.out.println(String.format("\tSpeed: " + convertHexToString(results[11].getValue().toString().substring(2))));
				}
				else{
					nas.setSpeed(results[11].getValue().toString());
					System.out.println(String.format("\tSpeed: " + results[11].getValue().toString()));
				}
			    
			    //NetConnectionId:
			    if((results[12].getValue().toString().length() >= 2) && (results[12].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setNetConnectionID(convertHexToString(results[12].getValue().toString().substring(2)));
					System.out.println(String.format("\tNetConnectionID: " + convertHexToString(results[12].getValue().toString().substring(2))));
				}
				else{
					nas.setNetConnectionID(results[12].getValue().toString());
					System.out.println(String.format("\tNetConnectionID: " + results[12].getValue().toString()));
				}
			    
			    //NetConnectionStatus:
			    if((results[13].getValue().toString().length() >= 2) && (results[13].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setNetConnectionStatus(convertHexToString(results[13].getValue().toString().substring(2)));
					System.out.println(String.format("\tNetConnectionStatus: " + convertHexToString(results[13].getValue().toString().substring(2))));
				}
				else{
					nas.setNetConnectionStatus(results[13].getValue().toString());
					System.out.println(String.format("\tNetConnectionStatus: " + results[13].getValue().toString()));
				}
			    
			    //InterfaceIndex:
			    if((results[14].getValue().toString().length() >= 2) && (results[14].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setInterfaceIndex(convertHexToString(results[14].getValue().toString().substring(2)));
					System.out.println(String.format("\tInterfaceIndex: " + convertHexToString(results[14].getValue().toString().substring(2))));
				}
				else{
					nas.setInterfaceIndex(results[14].getValue().toString());
					System.out.println(String.format("\tInterfaceIndex: " + results[14].getValue().toString()));
				}
			    
			    //Status:
			    if((results[15].getValue().toString().length() >= 2) && (results[15].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					nas.setStatus(convertHexToString(results[15].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[15].getValue().toString().substring(2))));
				}
				else{
					nas.setStatus(results[15].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[15].getValue().toString()));
				}
	
			    unit.setNetworkAdapterSetting(nas);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean get1394Controller(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.23.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.23.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.23.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.23.%d.2", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.23.%d.3", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.23.%d.4", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.23.%d.5", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 6) {
			    System.out.println(String.format("1394Controller - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tCaption --  " + results[1].toString()
				    + "\n\tDescription --  " + results[2].toString()
				    + "\n\tManufacturer --  " + results[3].toString()
				    + "\n\tDeviceID --  " + results[4].toString()
				    + "\n\tStatus --  " + results[5].toString());*/
	
			    _1394Controller c = new _1394Controller();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					c.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					c.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					c.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					c.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
			    //Description:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					c.setDescription(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					c.setDescription(results[2].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[2].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					c.setManufacturer(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					c.setManufacturer(results[3].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[3].getValue().toString()));
				}
			    
			    //DeviceID:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					c.setDeviceID(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceID: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					c.setDeviceID(results[4].getValue().toString());
					System.out.println(String.format("\tDeviceID: " + results[4].getValue().toString()));
				}
			    
			    //Status:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					c.setStatus(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					c.setStatus(results[5].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[5].getValue().toString()));
				}
	
			    unit.set1394Controller(c);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getDesktopMonitor(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.24.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.2", i + 2), // DeviceID
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.3", i + 2), // DisplayType
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.4", i + 2), // MonitorManufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.5", i + 2), // MonitorType
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.6", i + 2), // PixelsPerXLogicalInch
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.7", i + 2), // PixelsPerYLogicalInch
				String.format("1.3.6.1.4.1.191.117.27.1.24.%d.8", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 9) {
			    System.out.println(String.format("DesktopMonitor - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tCaption --  " + results[1].toString()
				    + "\n\tDeviceID --  " + results[2].toString()
				    + "\n\tDisplayType --  " + results[3].toString()
				    + "\n\tMonitorManufacturer --  "
				    + results[4].toString() + "\n\tMonitorType --  "
				    + results[5].toString()
				    + "\n\tPixelsPerXLogicalInch --  "
				    + results[6].toString()
				    + "\n\tPixelsPerYLogicalInch --  "
				    + results[7].toString() + "\n\tStatus --  "
				    + results[8].toString());*/
	
			    DesktopMonitor dm = new DesktopMonitor();
			    
			    //Name
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					dm.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Caption
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					dm.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
			    //DeviceID
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setDeviceID(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tDeviceID: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					dm.setDeviceID(results[2].getValue().toString());
					System.out.println(String.format("\tDeviceID: " + results[2].getValue().toString()));
				}
			    
			    //DisplayType:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setDisplayType(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tDisplayType: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					dm.setDisplayType(results[3].getValue().toString());
					System.out.println(String.format("\tDisplayType: " + results[3].getValue().toString()));
				}
			    
			    //MonitorManufacturer:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setMonitorManufacturer(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tMomitorManufacturer: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					dm.setMonitorManufacturer(results[4].getValue().toString());
					System.out.println(String.format("\tMonitorManufacturer: " + results[4].getValue().toString()));
				}
			    
			    //MonitorType:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setMonitorType(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tMonitorType: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					dm.setMonitorType(results[5].getValue().toString());
					System.out.println(String.format("\tMonitorType: " + results[5].getValue().toString()));
				}
			    
			    //PixelsPerXlogicalInch:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setPixelsPerXLogicalInch(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tPixelsPerXLogicalInch: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					dm.setPixelsPerXLogicalInch(results[6].getValue().toString());
					System.out.println(String.format("\tPixelsPerXLogicalInch: " + results[6].getValue().toString()));
				}
			    
			    //PixelsPerYLogicalInch:
			    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setPixelsPerYLogicalInch(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tPixelsPerYLogicalInch: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					dm.setPixelsPerYLogicalInch(results[7].getValue().toString());
					System.out.println(String.format("\tPixelsPerYLogicalInch: " + results[7].getValue().toString()));
				}
			    
			    //Status:
			    if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					dm.setStatus(convertHexToString(results[8].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[8].getValue().toString().substring(2))));
				}
				else{
					dm.setStatus(results[8].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[8].getValue().toString()));
				}
	
			    unit.setDesktopMonitor(dm);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getKeyboard(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.25.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.25.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.25.%d.1", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.25.%d.2", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.25.%d.3", i + 2), // Layout
				String.format("1.3.6.1.4.1.191.117.27.1.25.%d.4", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 5) {
			    System.out.println(String.format("Keyboard - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tCaption --  " + results[1].toString()
				    + "\n\tDescription --  " + results[2].toString()
				    + "\n\tLayout --  " + results[3].toString()
				    + "\n\tStatus --  " + results[4].toString());*/
	
			    Keyboard kb = new Keyboard();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					kb.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					kb.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					kb.setCaption(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					kb.setCaption(results[1].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[1].getValue().toString()));
				}
			    
			    //Description:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					kb.setDescription(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					kb.setDescription(results[2].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[2].getValue().toString()));
				}
			    
			    //Layout:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					kb.setLayout(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tLayout: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					kb.setLayout(results[3].getValue().toString());
					System.out.println(String.format("\tLayout: " + results[3].getValue().toString()));
				}
			    
			    //Status:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					kb.setStatus(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					kb.setStatus(results[4].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[4].getValue().toString()));
				}
	
			    unit.setKeyboard(kb);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getPointingDevice(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.26.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.26.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.26.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.26.%d.2", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.26.%d.3", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.26.%d.4", i + 2), // HardwareType
				String.format("1.3.6.1.4.1.191.117.27.1.26.%d.5", i + 2), // PointingType
				String.format("1.3.6.1.4.1.191.117.27.1.26.%d.6", i + 2) // Status
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 7) {
			    System.out.println(String.format("PointingDevice - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tCaption --  " + results[2].toString()
				    + "\n\tDescription --  " + results[3].toString()
				    + "\n\tHardwareType --  " + results[4].toString()
				    + "\n\tPointingType --  " + results[5].toString()
				    + "\n\tStatus --  " + results[6].toString());*/
	
			    PointingDevice pd = new PointingDevice();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pd.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					pd.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pd.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					pd.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pd.setCaption(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					pd.setCaption(results[2].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[2].getValue().toString()));
				}
			    
			    //Description:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pd.setDescription(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tDescription: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					pd.setDescription(results[3].getValue().toString());
					System.out.println(String.format("\tDescription: " + results[3].getValue().toString()));
				}
			    
			    //HardwareType:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pd.setHardwareType(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tHardwareType: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					pd.setHardwareType(results[4].getValue().toString());
					System.out.println(String.format("\tHardwareType: " + results[4].getValue().toString()));
				}
			    
			    //PointingType:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pd.setPointingType(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tPointingType: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					pd.setPointingType(results[5].getValue().toString());
					System.out.println(String.format("\tPointingType: " + results[5].getValue().toString()));
				}
			    
			    //Status
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					pd.setStatus(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tStatus: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					pd.setStatus(results[6].getValue().toString());
					System.out.println(String.format("\tStatus: " + results[6].getValue().toString()));
				}
	
			    unit.setPointingDevice(pd);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getSystemSlot(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.27.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.0", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.1", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.2", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.3", i + 2), // CurrentUsage
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.4", i + 2), // SerialNumber
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.5", i + 2), // SlotDesignation
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.6", i + 2), // Tag
				String.format("1.3.6.1.4.1.191.117.27.1.27.%d.7", i + 2) // Version
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 8) {
			    System.out.println(String.format("SystemSlot - #%d", i));
				    /*+ "\n\tName --  " + results[0].toString()
				    + "\n\tManufacturer --  " + results[1].toString()
				    + "\n\tCaption --  " + results[2].toString()
				    + "\n\tCurrentUsage --  " + results[3].toString()
				    + "\n\tSerialNumber --  " + results[4].toString()
				    + "\n\tSlotDesignation --  "
				    + results[5].toString() + "\n\tTag --  "
				    + results[6].toString() + "\n\tVersion --  "
				    + results[7].toString());*/
	
			    SystemSlot ss = new SystemSlot();
			    
			    //Name:
			    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setName(convertHexToString(results[0].getValue().toString().substring(2)));
					System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
				}
				else{
					ss.setName(results[0].getValue().toString());
					System.out.println(String.format("\tName: " + results[0].getValue().toString()));
				}
			    
			    //Manufacturer:
			    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setManufacturer(convertHexToString(results[1].getValue().toString().substring(2)));
					System.out.println(String.format("\tManufacturer: " + convertHexToString(results[1].getValue().toString().substring(2))));
				}
				else{
					ss.setManufacturer(results[1].getValue().toString());
					System.out.println(String.format("\tManufacturer: " + results[1].getValue().toString()));
				}
			    
			    //Caption:
			    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setCaption(convertHexToString(results[2].getValue().toString().substring(2)));
					System.out.println(String.format("\tCaption: " + convertHexToString(results[2].getValue().toString().substring(2))));
				}
				else{
					ss.setCaption(results[2].getValue().toString());
					System.out.println(String.format("\tCaption: " + results[2].getValue().toString()));
				}
			    
			    //CurrentUsage:
			    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setCurrentUsage(convertHexToString(results[3].getValue().toString().substring(2)));
					System.out.println(String.format("\tCurrentUsage: " + convertHexToString(results[3].getValue().toString().substring(2))));
				}
				else{
					ss.setCurrentUsage(results[3].getValue().toString());
					System.out.println(String.format("\tCurrentUsage: " + results[3].getValue().toString()));
				}
			    
			    //SerialNumber:
			    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setSerialNumber(convertHexToString(results[4].getValue().toString().substring(2)));
					System.out.println(String.format("\tSerialNumber: " + convertHexToString(results[4].getValue().toString().substring(2))));
				}
				else{
					ss.setSerialNumber(results[4].getValue().toString());
					System.out.println(String.format("\tSerialNumber: " + results[4].getValue().toString()));
				}
			    
			    //SlotDesignation:
			    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setSlotDesignation(convertHexToString(results[5].getValue().toString().substring(2)));
					System.out.println(String.format("\tSlotDesignation: " + convertHexToString(results[5].getValue().toString().substring(2))));
				}
				else{
					ss.setSlotDesignation(results[5].getValue().toString());
					System.out.println(String.format("\tSlotDesignation: " + results[5].getValue().toString()));
				}
			    
			    //Tag:
			    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setTag(convertHexToString(results[6].getValue().toString().substring(2)));
					System.out.println(String.format("\tTag: " + convertHexToString(results[6].getValue().toString().substring(2))));
				}
				else{
					ss.setTag(results[6].getValue().toString());
					System.out.println(String.format("\tTag: " + results[6].getValue().toString()));
				}
			    
			    //Version:
			    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
					ss.setVersion(convertHexToString(results[7].getValue().toString().substring(2)));
					System.out.println(String.format("\tVersion: " + convertHexToString(results[7].getValue().toString().substring(2))));
				}
				else{
					ss.setVersion(results[7].getValue().toString());
					System.out.println(String.format("\tVersion: " + results[7].getValue().toString()));
				}
	
			    unit.setSystemSlot(ss);
			}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getTerminal(ATM unit) {
	try {
	    String[] oids = { "1.3.6.1.4.1.191.117.27.1.1.1.0", // TerminalType
		    "1.3.6.1.4.1.191.117.27.1.1.1.1", // TerminalVendor
		    "1.3.6.1.4.1.191.117.27.1.1.1.2", // FrontReplenish
		    "1.3.6.1.4.1.191.117.27.1.1.1.3", // GeographicAddress
		    "1.3.6.1.4.1.191.117.27.1.1.1.4", // ManufacturingSite
		    "1.3.6.1.4.1.191.117.27.1.1.1.5", // Model
		    "1.3.6.1.4.1.191.117.27.1.1.1.6", // ProductClass
		    "1.3.6.1.4.1.191.117.27.1.1.1.7", // ProductClassDescription
		    "1.3.6.1.4.1.191.117.27.1.1.1.8", // SerialNumber
		    "1.3.6.1.4.1.191.117.27.1.1.1.9" // TracerNumber
	    };

	    varbind[] results = snmputil.get(oids);
	    if (results != null && results.length == 10) {
			System.out.println("Terminal"); //\n\tTerminalType --  "
				/*+ results[0].toString() + "\n\tTerminalVendor --  "
				+ results[1].toString() + "\n\tFrontReplenish --  "
				+ results[2].toString() + "\n\tGeographicAddress --  "
				+ results[3].toString() + "\n\tManufacturingSite --  "
				+ results[4].toString() + "\n\tModel --  "
				+ results[5].toString() + "\n\tProductClass --  "
				+ results[6].toString()
				+ "\n\tProductClassDescription --  "
				+ results[7].toString() + "\n\tSerialNumber --  "
				+ results[8].toString() + "\n\tTracerNumber --  "
				+ results[9].toString());*/
	
			Terminal ter = new Terminal();
			
			//Terminal Type:
			if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setTerminalType(convertHexToString(results[0].getValue().toString().substring(2)));
				System.out.println(String.format("\tTermminal Type: " + convertHexToString(results[0].getValue().toString().substring(2))));
			}
			else{
				ter.setTerminalType(results[0].getValue().toString());
				System.out.println(String.format("\tTerminal Type: " + results[0].getValue().toString()));
			}
			
			//Terminal Vendor:
			if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setTerminalVendor(convertHexToString(results[1].getValue().toString().substring(2)));
				System.out.println(String.format("\tTermminal Vendor: " + convertHexToString(results[1].getValue().toString().substring(2))));
			}
			else{
				ter.setTerminalVendor(results[1].getValue().toString());
				System.out.println(String.format("\tTerminal Vendor: " + results[1].getValue().toString()));
			}
			
			//Front Replenish:
			if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setFrontReplenish(convertHexToString(results[2].getValue().toString().substring(2)));
				System.out.println(String.format("\tFront Replenish: " + convertHexToString(results[2].getValue().toString().substring(2))));
			}
			else{
				ter.setFrontReplenish(results[2].getValue().toString());
				System.out.println(String.format("\tFront Replenish: " + results[2].getValue().toString()));
			}
			
			//Geographic Address:
			if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setGeographicAddress(convertHexToString(results[3].getValue().toString().substring(2)));
				System.out.println(String.format("\tGeographicAddress: " + convertHexToString(results[3].getValue().toString().substring(2))));
			}
			else{
				ter.setGeographicAddress(results[3].getValue().toString());
				System.out.println(String.format("\tGeographicAddress: " + results[3].getValue().toString()));
			}
			
			//Manufacturing Site:
			if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setManufacturingSite(convertHexToString(results[4].getValue().toString().substring(2)));
				System.out.println(String.format("\tManufacturing Site: " + convertHexToString(results[4].getValue().toString().substring(2))));
			}
			else{
				ter.setManufacturingSite(results[4].getValue().toString());
				System.out.println(String.format("\tManufacturing Site: " + results[4].getValue().toString()));
			}
			
			//Model:
			if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setModel(convertHexToString(results[5].getValue().toString().substring(2)));
				System.out.println(String.format("\tModel: " + convertHexToString(results[5].getValue().toString().substring(2))));
			}
			else{
				ter.setModel(results[5].getValue().toString());
				System.out.println(String.format("\tModel: " + results[5].getValue().toString()));
			}
			
			//Product Class:
			if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setProductClass(convertHexToString(results[6].getValue().toString().substring(2)));
				System.out.println(String.format("\tProduct Class: " + convertHexToString(results[6].getValue().toString().substring(2))));
			}
			else{
				ter.setProductClass(results[6].getValue().toString());
				System.out.println(String.format("\tProduct Class: " + results[6].getValue().toString()));
			}
			
			//Product Class Description:
			if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setProductClassDescription(convertHexToString(results[7].getValue().toString().substring(2)));
				System.out.println(String.format("\tProductClassDescription: " + convertHexToString(results[7].getValue().toString().substring(2))));
			}
			else{
				ter.setProductClassDescription(results[7].getValue().toString());
				System.out.println(String.format("\tProductClassDescription: " + results[7].getValue().toString()));
			}
			
			//Serial Number
			if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setSerialNumber(convertHexToString(results[8].getValue().toString().substring(2)));
				System.out.println(String.format("\tSerial Number: " + convertHexToString(results[8].getValue().toString().substring(2))));
			}
			else{
				ter.setSerialNumber(results[8].getValue().toString());
				System.out.println(String.format("\tSerial Number: " + results[8].getValue().toString()));
			}
			
			//Tracer Number
			if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				ter.setTracerNumber(convertHexToString(results[9].getValue().toString().substring(2)));
				System.out.println(String.format("\tTracerNumber: " + convertHexToString(results[9].getValue().toString().substring(2))));
			}
			else{
				ter.setTracerNumber(results[9].getValue().toString());
				System.out.println(String.format("\tTracerNumber: " + results[9].getValue().toString()));
			}
	
			unit.setTerminal(ter);
			return true;
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    private boolean getDevice(ATM unit) {
		try {
		    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.2.1.0" };
		    varbind[] resNum = snmputil.get(oidn);
		    String number = resNum[0].getValue().toString();
	
		    int i = 0;
		    for (i = 0; i < Integer.parseInt(number); i++) {
			String[] oids = {
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.0", i + 2), // Caption
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.1", i + 2), // Description
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.2", i + 2), // DeviceInstance
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.3", i + 2), // DeviceStatus
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.4", i + 2), // FirmwareVersion
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.5", i + 2), // HotSwappable
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.6", i + 2), // Manufacturer
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.7", i + 2), // Model
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.8", i + 2), // Name
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.9", i + 2), // PMStatus
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.10", i + 2), // Removable
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.11", i + 2), // Replaceable
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.12", i + 2), // SerialNumber
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.13", i + 2), // UniversalId
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.14", i + 2), // Variant
				String.format("1.3.6.1.4.1.191.117.27.1.2.%d.15", i + 2), // Version
			};
	
			varbind[] results = snmputil.get(oids);
			if (results != null && results.length == 16){
			    System.out.println(String.format("Device - #%d", i));
				   /* + "\n\tCaption --  " + results[0].toString()
				    + "\n\tDescription --  " + results[1].toString()
				    + "\n\tDeviceInstance --  " + results[2].toString()
				    + "\n\tDeviceStatus --  " + results[3].toString()
				    + "\n\tFirmwareVersion --  "
				    + results[4].toString() + "\n\tHotSwappable --  "
				    + results[5].toString() + "\n\tManufacturer --  "
				    + results[6].toString() + "\n\tModel --  "
				    + results[7].toString() + "\n\tName --  "
				    + results[8].toString() + "\n\tPMStatus --  "
				    + results[9].toString() + "\n\tRemovable --  "
				    + results[10].toString() + "\n\tReplaceable --  "
				    + results[11].toString() + "\n\tSerialNumber --  "
				    + results[12].toString() + "\n\tUniversalId --  "
				    + results[13].toString() + "\n\tVariant --  "
				    + results[14].toString() + "\n\tVersion --  "
				    + results[15].toString());*/
	
				    Device dev = new Device();
				    
				    //Caption:
				    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setCaption(convertHexToString(results[0].getValue().toString().substring(2)));
						System.out.println(String.format("\tCaption: " + convertHexToString(results[0].getValue().toString().substring(2))));
					}
					else{
						dev.setCaption(results[0].getValue().toString());
						System.out.println(String.format("\tCaption: " + results[0].getValue().toString()));
					}
				    
				    //Description:
				    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setDescription(convertHexToString(results[1].getValue().toString().substring(2)));
						System.out.println(String.format("\tDescription: " + convertHexToString(results[1].getValue().toString().substring(2))));
					}
					else{
						dev.setDescription(results[1].getValue().toString());
						System.out.println(String.format("\tDescription: " + results[1].getValue().toString()));
					}
				    
				    //DeviceInstance:
				    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setDeviceInstance(convertHexToString(results[2].getValue().toString().substring(2)));
						System.out.println(String.format("\tDeviceInstance: " + convertHexToString(results[2].getValue().toString().substring(2))));
					}
					else{
						dev.setDeviceInstance(results[2].getValue().toString());
						System.out.println(String.format("\tDeviceInstance: " + results[2].getValue().toString()));
					}
				    
				    //DeviceStatus:
				    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setDeviceStatus(convertHexToString(results[3].getValue().toString().substring(2)));
						System.out.println(String.format("\tDeviceStatus: " + convertHexToString(results[3].getValue().toString().substring(2))));
					}
					else{
						dev.setDeviceStatus(results[3].getValue().toString());
						System.out.println(String.format("\tDeviceStatus: " + results[3].getValue().toString()));
					}
				    
				    //FirmwareVersion:
				    if((results[4].getValue().toString().length() >= 2) && (results[4].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setFirmwareVersion(convertHexToString(results[4].getValue().toString().substring(2)));
						System.out.println(String.format("\tFirmwareVersion: " + convertHexToString(results[4].getValue().toString().substring(2))));
					}
					else{
						dev.setFirmwareVersion(results[4].getValue().toString());
						System.out.println(String.format("\tFirmwareVersion: " + results[4].getValue().toString()));
					}
				    
				    //HotSwappable
				    if((results[5].getValue().toString().length() >= 2) && (results[5].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setHotSwappable(convertHexToString(results[5].getValue().toString().substring(2)));
						System.out.println(String.format("\tHotSwappable: " + convertHexToString(results[5].getValue().toString().substring(2))));
					}
					else{
						dev.setHotSwappable(results[5].getValue().toString());
						System.out.println(String.format("\tHotSwappable: " + results[5].getValue().toString()));
					}
				    
				    //Manufacturer:
				    if((results[6].getValue().toString().length() >= 2) && (results[6].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setManufacturer(convertHexToString(results[6].getValue().toString().substring(2)));
						System.out.println(String.format("\tManufacturer: " + convertHexToString(results[6].getValue().toString().substring(2))));
					}
					else{
						dev.setManufacturer(results[6].getValue().toString());
						System.out.println(String.format("\tManufacturer: " + results[6].getValue().toString()));
					}
				    
				    //Model:
				    if((results[7].getValue().toString().length() >= 2) && (results[7].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setModel(convertHexToString(results[7].getValue().toString().substring(2)));
						System.out.println(String.format("\tModel: " + convertHexToString(results[7].getValue().toString().substring(2))));
					}
					else{
						dev.setModel(results[7].getValue().toString());
						System.out.println(String.format("\tModel: " + results[7].getValue().toString()));
					}
				    
				    //Name:
				    if((results[8].getValue().toString().length() >= 2) && (results[8].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setName(convertHexToString(results[8].getValue().toString().substring(2)));
						System.out.println(String.format("\tName: " + convertHexToString(results[8].getValue().toString().substring(2))));
					}
					else{
						dev.setName(results[8].getValue().toString());
						System.out.println(String.format("\tName: " + results[8].getValue().toString()));
					}
				    
				    //PMStatus
				    if((results[9].getValue().toString().length() >= 2) && (results[9].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setPMStatus(convertHexToString(results[9].getValue().toString().substring(2)));
						System.out.println(String.format("\tPMStatus: " + convertHexToString(results[9].getValue().toString().substring(2))));
					}
					else{
						dev.setPMStatus(results[9].getValue().toString());
						System.out.println(String.format("\tPMStatus: " + results[9].getValue().toString()));
					}
				    
				    //Removable
				    if((results[10].getValue().toString().length() >= 2) && (results[10].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setRemovable(convertHexToString(results[10].getValue().toString().substring(2)));
						System.out.println(String.format("\tRemovable: " + convertHexToString(results[10].getValue().toString().substring(2))));
					}
					else{
						dev.setRemovable(results[10].getValue().toString());
						System.out.println(String.format("\tRemovable: " + results[10].getValue().toString()));
					}
				    
				    //Replaceable
				    if((results[11].getValue().toString().length() >= 2) && (results[11].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setReplaceable(convertHexToString(results[11].getValue().toString().substring(2)));
						System.out.println(String.format("\tReplaceable: " + convertHexToString(results[11].getValue().toString().substring(2))));
					}
					else{
						dev.setReplaceable(results[11].getValue().toString());
						System.out.println(String.format("\tReplaceable: " + results[11].getValue().toString()));
					}
				    
				    //SerialNumber
				    if((results[12].getValue().toString().length() >= 2) && (results[12].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setSerialNumber(convertHexToString(results[12].getValue().toString().substring(2)));
						System.out.println(String.format("\tSerialNumber: " + convertHexToString(results[12].getValue().toString().substring(2))));
					}
					else{
						dev.setSerialNumber(results[12].getValue().toString());
						System.out.println(String.format("\tSerialNumber: " + results[12].getValue().toString()));
					}
				    
				    //UniversalID
				    if((results[13].getValue().toString().length() >= 2) && (results[13].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setUniversalID(convertHexToString(results[13].getValue().toString().substring(2)));
						System.out.println(String.format("\tUniversalID: " + convertHexToString(results[13].getValue().toString().substring(2))));
					}
					else{
						dev.setUniversalID(results[13].getValue().toString());
						System.out.println(String.format("\tUniversalID: " + results[13].getValue().toString()));
					}
				    
				    //Variant
				    if((results[14].getValue().toString().length() >= 2) && (results[14].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setVariant(convertHexToString(results[14].getValue().toString().substring(2)));
						System.out.println(String.format("\tVariant: " + convertHexToString(results[14].getValue().toString().substring(2))));
					}
					else{
						dev.setVariant(results[14].getValue().toString());
						System.out.println(String.format("\tVariant: " + results[14].getValue().toString()));
					}
				    
				    //Version
				    if((results[15].getValue().toString().length() >= 2) && (results[15].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
						dev.setVersion(convertHexToString(results[15].getValue().toString().substring(2)));
						System.out.println(String.format("\tVersion: " + convertHexToString(results[15].getValue().toString().substring(2))));
					}
					else{
						dev.setVersion(results[15].getValue().toString());
						System.out.println(String.format("\tVersion: " + results[15].getValue().toString()));
					}
		
				    unit.setDevice(dev);
				}
		    }
		    return true;
		} catch (Exception e) {
		    logger.error(e);
		}
		return false;
    }

    private boolean getPackage(ATM unit) {
	try {
	    String[] oidn = { "1.3.6.1.4.1.191.117.27.1.30.1.0" };
	    varbind[] resNum = snmputil.get(oidn);
	    String number = resNum[0].getValue().toString();

	    int i = 0;
	    for (i = 0; i < Integer.parseInt(number); i++) {
		String[] oids = {
			String.format("1.3.6.1.4.1.191.117.27.1.30.%d.0", i + 2), // Name
			String.format("1.3.6.1.4.1.191.117.27.1.30.%d.1", i + 2), // Version
			String.format("1.3.6.1.4.1.191.117.27.1.30.%d.2", i + 2), // Description
			String.format("1.3.6.1.4.1.191.117.27.1.30.%d.3", i + 2) // Profile
		};

		varbind[] results = snmputil.get(oids);
		if (results != null && results.length == 4) {
		    System.out.println(String.format("Package - #%d", i));
			    /*+ "\n\tName --  " + results[0].toString()
			    + "\n\tVersion --  " + results[1].toString()
			    + "\n\tDescription --  " + results[2].toString()
			    + "\n\tProfile --  " + results[3].toString());*/

		    Package pak = new Package();
		    
		    //Name:
		    if((results[0].getValue().toString().length() >= 2) && (results[0].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				pak.setName(convertHexToString(results[0].getValue().toString().substring(2)));
				System.out.println(String.format("\tName: " + convertHexToString(results[0].getValue().toString().substring(2))));
			}
			else{
				pak.setName(results[0].getValue().toString());
				System.out.println(String.format("\tName: " + results[0].getValue().toString()));
			}
		    
		    //Version:
		    if((results[1].getValue().toString().length() >= 2) && (results[1].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				pak.setVersion(convertHexToString(results[1].getValue().toString().substring(2)));
				System.out.println(String.format("\tVersion: " + convertHexToString(results[1].getValue().toString().substring(2))));
			}
			else{
				pak.setVersion(results[1].getValue().toString());
				System.out.println(String.format("\tVersion: " + results[1].getValue().toString()));
			}
		    
		    //Description:
		    if((results[2].getValue().toString().length() >= 2) && (results[2].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				pak.setDescription(convertHexToString(results[2].getValue().toString().substring(2)));
				System.out.println(String.format("\tDescription: " + convertHexToString(results[2].getValue().toString().substring(2))));
			}
			else{
				pak.setDescription(results[2].getValue().toString());
				System.out.println(String.format("\tDescription: " + results[2].getValue().toString()));
			}
		    
		    //Profile:
		    if((results[3].getValue().toString().length() >= 2) && (results[3].getValue().toString().substring(0, 2).equalsIgnoreCase("0x"))){
				pak.setProfile(convertHexToString(results[3].getValue().toString().substring(2)));
				System.out.println(String.format("\tProfile: " + convertHexToString(results[3].getValue().toString().substring(2))));
			}
			else{
				pak.setProfile(results[3].getValue().toString());
				System.out.println(String.format("\tProfile: " + results[3].getValue().toString()));
			}

		    unit.setPackage(pak);
		}
	    }
	    return true;
	} catch (Exception e) {
	    logger.error(e);
	}
	return false;
    }

    public void setData(String action) {
		AsnObject objT = null;
		snmputil.set(action, objT);
    }

    public void liberarRecursos() {
		if (snmputil != null) {
		    snmputil.liberaRecursos();
		}
    }

    private int hashCode(String s) {
		int h = 0;
		int off = 0;
		char val[] = s.toCharArray();
		int len = val.length;
	
		for (int i = 0; i < len; i++) {
		    h = 31 * h + val[off++];
		}
		return h;
    }

    public SNMPUtils getSNMPUtils() {
    	return this.snmputil;
    }
    
    public String convertHexToString(String hex){
		 StringBuilder sb = new StringBuilder();
		 StringBuilder temp = new StringBuilder();
  
		 //Remove the :
		 String parsed = hex.replace(":", "");
 
		 //49204c6f7665204a617661 split into two characters 49, 20, 4c...
		 for( int i=0; i<parsed.length()-1; i+=2 ){
			 //grab the hex in pairs
			 String output = parsed.substring(i, (i + 2));
			 //convert hex to decimal
			 int decimal = Integer.parseInt(output, 16);
			 //convert the decimal to character
			 sb.append((char)decimal);
			 temp.append(decimal);
		 }
		 return sb.toString();
	  }
}