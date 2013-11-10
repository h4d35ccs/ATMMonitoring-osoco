package com.ncr.ATMMonitoring.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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

import ncr.inventory.data.BaseBoard;
import ncr.inventory.data.Bios;
import ncr.inventory.data.CDROMDrive;
import ncr.inventory.data.ComputerSystem;
import ncr.inventory.data.DesktopMonitor;
import ncr.inventory.data.DiskDrive;
import ncr.inventory.data.FloppyDrive;
import ncr.inventory.data.Keyboard;
import ncr.inventory.data.LogicalDisk;
import ncr.inventory.data.NetworkAdapterSetting;
import ncr.inventory.data.ParallelPort;
import ncr.inventory.data.PhysicalMemory;
import ncr.inventory.data.PointingDevice;
import ncr.inventory.data.Processor;
import ncr.inventory.data.SCSIController;
import ncr.inventory.data.SerialPort;
import ncr.inventory.data.SoundDevice;
import ncr.inventory.data.SystemSlot;
import ncr.inventory.data.USBController;
import ncr.inventory.data.UsbHub;
import ncr.inventory.data.VideoController;
import ncr.inventory.data._1394Controller;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.os.module.BaseBoardPojo;
import com.ncr.agent.baseData.os.module.BiosPojo;
import com.ncr.agent.baseData.os.module.CDROMDrivePojo;
import com.ncr.agent.baseData.os.module.ComputerSystemPojo;
import com.ncr.agent.baseData.os.module.DesktopMonitorPojo;
import com.ncr.agent.baseData.os.module.DiskDrivePojo;
import com.ncr.agent.baseData.os.module.FloppyDrivePojo;
import com.ncr.agent.baseData.os.module.KeyboardPojo;
import com.ncr.agent.baseData.os.module.LogicalDiskPojo;
import com.ncr.agent.baseData.os.module.NetworkAdapterSettingPojo;
import com.ncr.agent.baseData.os.module.ParallelPortPojo;
import com.ncr.agent.baseData.os.module.PhysicalMemoryPojo;
import com.ncr.agent.baseData.os.module.PointingDevicePojo;
import com.ncr.agent.baseData.os.module.ProcessorPojo;
import com.ncr.agent.baseData.os.module.SCSIControllerPojo;
import com.ncr.agent.baseData.os.module.SerialPortPojo;
import com.ncr.agent.baseData.os.module.SoundDevicePojo;
import com.ncr.agent.baseData.os.module.SystemSlotPojo;
import com.ncr.agent.baseData.os.module.USBControllerPojo;
import com.ncr.agent.baseData.os.module.UsbHubPojo;
import com.ncr.agent.baseData.os.module.VideoControllerPojo;
import com.ncr.agent.baseData.os.module._1394ControllerPojo;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "hardware_devices")
public class HardwareDevice {

    static private Logger logger = Logger.getLogger(HardwareDevice.class
	    .getName());

    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> dateOperations = Operation
		.getOperationsByType(Operation.DataType.DATE);
	Map<String, Map> numberOperations = Operation
		.getOperationsByType(Operation.DataType.NUMBER);
	Map<String, Map> boolOperations = Operation
		.getOperationsByType(Operation.DataType.BOOLEAN);

	Map<String, Map> values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("model", stringOperations);
	values.put("description", stringOperations);
	values.put("numberOfProcessors", numberOperations);
	values.put("totalPhysicalMemory", numberOperations);
	values.put("domain", stringOperations);
	values.put("workgroup", stringOperations);
	values.put("status", stringOperations);
	values.put("currentTimeZone", numberOperations);
	values.put("daylightInEffect", boolOperations);
	comboboxes.put("Win32_ComputerSystem", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("architecture", stringOperations);
	values.put("addressWidth", numberOperations);
	values.put("dataWidth", numberOperations);
	values.put("currentClockSpeed", numberOperations);
	values.put("maxClockSpeed", numberOperations);
	values.put("extClock", numberOperations);
	values.put("stepping", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_Processor", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("capacity", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_PhysicalMemory", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("model", stringOperations);
	values.put("caption", stringOperations);
	values.put("partitions", numberOperations);
	values.put("size", numberOperations);
	values.put("status", stringOperations);
	values.put("description", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("firmwareRevision", stringOperations);
	values.put("serialNumber", stringOperations);
	values.put("mediaType", stringOperations);
	values.put("maxMediaSize", numberOperations);
	values.put("totalCylinders", numberOperations);
	values.put("tracksPerCylinder", numberOperations);
	values.put("sectorsPerTrack", numberOperations);
	values.put("bytesPerSector", numberOperations);
	values.put("signature", stringOperations);
	comboboxes.put("Win32_DiskDrive", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("size", numberOperations);
	values.put("freeSpace", numberOperations);
	values.put("fileSystem", stringOperations);
	values.put("caption", stringOperations);
	values.put("description", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("volumeName", stringOperations);
	values.put("volumeSerialNumber", stringOperations);
	comboboxes.put("Win32_LogicalDisk", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("model", stringOperations);
	values.put("status", stringOperations);
	values.put("product", stringOperations);
	values.put("serialNumber", stringOperations);
	comboboxes.put("Win32_BaseBoard", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("adapterType", stringOperations);
	values.put("description", stringOperations);
	values.put("caption", stringOperations);
	values.put("dhcpEnabled", boolOperations);
	values.put("dhcpServer", stringOperations);
	values.put("ipAddress", stringOperations);
	values.put("ipSubnet", stringOperations);
	values.put("defaultIpGateway", stringOperations);
	values.put("macAddress", stringOperations);
	values.put("speed", numberOperations);
	values.put("netConnectionId", stringOperations);
	values.put("netConnectionStatus", stringOperations);
	values.put("status", stringOperations);
	values.put("interfaceIndex", numberOperations);
	comboboxes.put("Win32_NetworkAdapter", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("mediaType", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("description", stringOperations);
	values.put("status", stringOperations);
	values.put("caption", stringOperations);
	comboboxes.put("Win32_FloppyDrive", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("mediaType", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("status", stringOperations);
	values.put("caption", stringOperations);
	comboboxes.put("Win32_CDROMDrive", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("caption", stringOperations);
	comboboxes.put("Win32_SoundDevice", values);

	// values = new TreeMap<String, Map>();
	// values.put("name", stringOperations);
	// values.put("videoProcessor", stringOperations);
	// values.put("videoMemory", numberOperations);
	// values.put("bitsPerPixel", numberOperations);
	// values.put("colors", numberOperations);
	// values.put("horizontalRes", numberOperations);
	// values.put("verticalRes", numberOperations);
	// values.put("refreshRate", numberOperations);
	// values.put("description", stringOperations);
	// comboboxes.put("Win32_DisplayConfiguration", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("protocolSupported", numberOperations);
	comboboxes.put("Win32_USBController", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("numberOfPorts", numberOperations);
	values.put("description", stringOperations);
	values.put("protocolCode", stringOperations);
	values.put("usbVersion", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_USBHub", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("maxBaudRate", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_SerialPort", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_ParallelPort", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("description", stringOperations);
	comboboxes.put("Win32_1394Controller", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("description", stringOperations);
	values.put("caption", stringOperations);
	values.put("statusInfo", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("driverName", stringOperations);
	values.put("hardwareVersion", stringOperations);
	comboboxes.put("Win32_SCSIController", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("displayType", boolOperations);
	values.put("monitorType", stringOperations);
	values.put("monitorManufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("pixelsPerXLogicalInch", numberOperations);
	values.put("pixelsPerYLogicalInch", numberOperations);
	comboboxes.put("Win32_DesktopMonitor", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("description", stringOperations);
	values.put("layout", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_Keyboard", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("description", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("hardwareType", stringOperations);
	values.put("pointingType", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_PointingDevice", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("caption", stringOperations);
	values.put("serialNumber", stringOperations);
	values.put("slotDesignation", stringOperations);
	values.put("currentUsage", numberOperations);
	values.put("tag", stringOperations);
	values.put("version", stringOperations);
	comboboxes.put("Win32_SystemSlot", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("smbiosVersion", stringOperations);
	values.put("smbiosMajorVersion", numberOperations);
	values.put("smbiosMinorVersion", numberOperations);
	values.put("caption", stringOperations);
	values.put("currentLanguage", stringOperations);
	values.put("primaryBios", boolOperations);
	values.put("releaseDate", dateOperations);
	values.put("serialNumber", stringOperations);
	values.put("smbiosPresent", boolOperations);
	values.put("version", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_Bios", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("videoProcessor", stringOperations);
	values.put("description", stringOperations);
	values.put("adapterRam", numberOperations);
	values.put("currentBitsPerPixel", numberOperations);
	values.put("currentNumberOfColors", numberOperations);
	values.put("currentHorizontalResolution", numberOperations);
	values.put("currentVerticalResolution", numberOperations);
	values.put("currentRefreshRate", numberOperations);
	comboboxes.put("Win32_VideoController", values);
	values = new TreeMap<String, Map>();
	for (String hwDevice : comboboxes.keySet()) {
	    Map<String, Map> aux = comboboxes.get(hwDevice);
	    for (String name : aux.keySet()) {
		values.put(name, aux.get(name));
	    }
	}
	comboboxes.put("allHwDevices", values);
    }

    private static final char separator = ';';

    private static final Map<DeviceClassId, String> deviceClasses;

    private static enum DeviceClassId {
	COMPUTER_SYSTEM, PROCESSOR, PHYSICAL_MEMORY, DISK_DRIVE, LOGICAL_DISK, BASE_BOARD, NETWORK_ADAPTER, FLOPPY_DRIVE, CDROM_DRIVE, SOUND_DEVICE, DISPLAY_CONFIGURATION, USB_CONTROLLER, USB_HUB, SERIAL_PORT, PARALLEL_PORT, _1394_CONTROLLER, SCSI_CONTROLLER, DESKTOP_MONITOR, KEYBOARD, POINTING_DEVICE, SYSTEM_SLOT, BIOS, VIDEO_CONTROLLER
    }

    static {
	deviceClasses = new HashMap<DeviceClassId, String>();
	deviceClasses
		.put(DeviceClassId.COMPUTER_SYSTEM, "Win32_ComputerSystem");
	deviceClasses.put(DeviceClassId.PROCESSOR, "Win32_Processor");
	deviceClasses
		.put(DeviceClassId.PHYSICAL_MEMORY, "Win32_PhysicalMemory");
	deviceClasses.put(DeviceClassId.DISK_DRIVE, "Win32_DiskDrive");
	deviceClasses.put(DeviceClassId.LOGICAL_DISK, "Win32_LogicalDisk");
	deviceClasses.put(DeviceClassId.BASE_BOARD, "Win32_BaseBoard");
	deviceClasses
		.put(DeviceClassId.NETWORK_ADAPTER, "Win32_NetworkAdapter");
	deviceClasses.put(DeviceClassId.FLOPPY_DRIVE, "Win32_FloppyDrive");
	deviceClasses.put(DeviceClassId.CDROM_DRIVE, "Win32_CDROMDrive");
	deviceClasses.put(DeviceClassId.SOUND_DEVICE, "Win32_SoundDevice");
	deviceClasses.put(DeviceClassId.DISPLAY_CONFIGURATION,
		"Win32_DisplayConfiguration");
	deviceClasses.put(DeviceClassId.USB_CONTROLLER, "Win32_USBController");
	deviceClasses.put(DeviceClassId.USB_HUB, "Win32_USBHub");
	deviceClasses.put(DeviceClassId.SERIAL_PORT, "Win32_SerialPort");
	deviceClasses.put(DeviceClassId.PARALLEL_PORT, "Win32_ParallelPort");
	deviceClasses.put(DeviceClassId._1394_CONTROLLER,
		"Win32_1394Controller");
	deviceClasses
		.put(DeviceClassId.SCSI_CONTROLLER, "Win32_SCSIController");
	deviceClasses
		.put(DeviceClassId.DESKTOP_MONITOR, "Win32_DesktopMonitor");
	deviceClasses.put(DeviceClassId.KEYBOARD, "Win32_Keyboard");
	deviceClasses
		.put(DeviceClassId.POINTING_DEVICE, "Win32_PointingDevice");
	deviceClasses.put(DeviceClassId.SYSTEM_SLOT, "Win32_SystemSlot");
	deviceClasses.put(DeviceClassId.BIOS, "Win32_Bios");
	deviceClasses.put(DeviceClassId.VIDEO_CONTROLLER,
		"Win32_VideoController");
    }

    private static Set<HardwareDevice> filterByClass(
	    Set<HardwareDevice> hardwareDevs, String deviceClass) {
	Set<HardwareDevice> result = new HashSet<HardwareDevice>();
	for (HardwareDevice dev : hardwareDevs) {
	    if ((dev.getHardwareClass() != null)
		    && (dev.getHardwareClass().equals(deviceClass))) {
		result.add(dev);
	    }
	}
	return result;
    }

    public static Set<HardwareDevice> filterComputerSystem(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.COMPUTER_SYSTEM));
    }

    public static Set<HardwareDevice> filterProcessor(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.PROCESSOR));
    }

    public static Set<HardwareDevice> filterPhysicalMemory(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.PHYSICAL_MEMORY));
    }

    public static Set<HardwareDevice> filterDiskDrive(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.DISK_DRIVE));
    }

    public static Set<HardwareDevice> filterLogicalDisk(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.LOGICAL_DISK));
    }

    public static Set<HardwareDevice> filterBaseBoard(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.BASE_BOARD));
    }

    public static Set<HardwareDevice> filterNetworkAdapter(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.NETWORK_ADAPTER));
    }

    public static Set<HardwareDevice> filterFloppyDrive(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.FLOPPY_DRIVE));
    }

    public static Set<HardwareDevice> filterCdromDrive(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.CDROM_DRIVE));
    }

    public static Set<HardwareDevice> filterSoundDevice(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SOUND_DEVICE));
    }

    public static Set<HardwareDevice> filterDisplayConfiguration(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.DISPLAY_CONFIGURATION));
    }

    public static Set<HardwareDevice> filterUsbController(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.USB_CONTROLLER));
    }

    public static Set<HardwareDevice> filterUsbHub(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.USB_HUB));
    }

    public static Set<HardwareDevice> filterSerialPort(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SERIAL_PORT));
    }

    public static Set<HardwareDevice> filterParallelPort(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.PARALLEL_PORT));
    }

    public static Set<HardwareDevice> filter1394Controller(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId._1394_CONTROLLER));
    }

    public static Set<HardwareDevice> filterScsiController(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SCSI_CONTROLLER));
    }

    public static Set<HardwareDevice> filterDesktopMonitor(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.DESKTOP_MONITOR));
    }

    public static Set<HardwareDevice> filterKeyboard(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.KEYBOARD));
    }

    public static Set<HardwareDevice> filterPointingDevice(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.POINTING_DEVICE));
    }

    public static Set<HardwareDevice> filterSystemSlot(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SYSTEM_SLOT));
    }

    public static Set<HardwareDevice> filterBios(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.BIOS));
    }

    public static Set<HardwareDevice> filterVideoController(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.VIDEO_CONTROLLER));
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hardware_devices_id_seq")
    @SequenceGenerator(name = "hardware_devices_id_seq", sequenceName = "hardware_devices_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @Column(name = "hardware_class", length = 100, nullable = false)
    private String hardwareClass;

    @Column(name = "name", length = 300)
    private String name;

    @Column(name = "manufacturer", length = 300)
    private String manufacturer;

    @Column(name = "model", length = 300)
    private String model;

    @Column(name = "number_of_processors")
    private Integer numberOfProcessors;

    @Column(name = "caption", length = 300)
    private String caption;

    @Column(name = "total_physical_memory")
    private Long totalPhysicalMemory;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "current_time_zone")
    private Integer currentTimeZone;

    @Column(name = "daylight_in_effect")
    private Boolean daylightInEffect;

    @Column(name = "domain", length = 300)
    private String domain;

    @Column(name = "workgroup", length = 300)
    private String workgroup;

    @Column(name = "status", length = 300)
    private String status;

    @Column(name = "architecture", length = 300)
    private String architecture;

    @Column(name = "protocol_code", length = 300)
    private String protocolCode;

    @Column(name = "address_width")
    private Integer addressWidth;

    @Column(name = "data_width")
    private Integer dataWidth;

    @Column(name = "number_of_ports")
    private Integer numberOfPorts;

    @Column(name = "current_clock_speed")
    private Integer currentClockSpeed;

    @Column(name = "ext_clock")
    private Integer extClock;

    @Column(name = "stepping")
    private Integer stepping;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "speed")
    private Long speed;

    @Column(name = "partitions")
    private Integer partitions;

    @Column(name = "size_")
    private Long size;

    @Column(name = "free_space")
    private Long freeSpace;

    @Column(name = "product", length = 100)
    private String product;

    @Column(name = "file_system", length = 300)
    private String fileSystem;

    @Column(name = "version", length = 200)
    private String version;

    @Column(name = "usb_version", length = 200)
    private String usbVersion;

    @Column(name = "adapter_type", length = 300)
    private String adapterType;

    @Column(name = "dhcp_enabled")
    private Boolean dhcpEnabled;

    @Column(name = "dhcp_server", length = 150)
    private String dhcpServer;

    @Column(name = "ip_address", length = 150)
    private String ipAddress;

    @Column(name = "ip_subnet", length = 150)
    private String ipSubnet;

    @Column(name = "default_ip_gateway", length = 150)
    private String defaultIpGateway;

    @Column(name = "mac_address", length = 17)
    private String macAddress;

    @Column(name = "net_connection_id", length = 300)
    private String netConnectionId;

    @Column(name = "net_connection_status", length = 100)
    private String netConnectionStatus;

    @Column(name = "video_memory")
    private Integer videoMemory;

    @Column(name = "device_id", length = 300)
    private String deviceId;

    @Column(name = "max_baud_rate")
    private Integer maxBaudRate;

    @Column(name = "display_type")
    private Boolean displayType;

    @Column(name = "monitor_manufacturer", length = 300)
    private String monitorManufacturer;

    @Column(name = "signature", length = 300)
    private String signature;

    @Column(name = "monitor_type", length = 300)
    private String monitorType;

    @Column(name = "pixels_per_x_logical_inch")
    private Integer pixelsPerXLogicalInch;

    @Column(name = "pixels_per_y_logical_inch")
    private Integer pixelsPerYLogicalInch;

    @Column(name = "layout", length = 300)
    private String layout;

    @Column(name = "hardware_type", length = 300)
    private String hardwareType;

    @Column(name = "pointing_type")
    private Integer pointingType;

    @Column(name = "current_usage")
    private Integer currentUsage;

    @Column(name = "serial_number", length = 300)
    private String serialNumber;

    @Column(name = "slot_designation", length = 100)
    private String slotDesignation;

    @Column(name = "tag", length = 300)
    private String tag;

    @Column(name = "smbios_version", length = 100)
    private String smbiosVersion;

    @Column(name = "smbios_major_version")
    private Integer smbiosMajorVersion;

    @Column(name = "smbios_minor_version")
    private Integer smbiosMinorVersion;

    @Column(name = "current_language", length = 100)
    private String currentLanguage;

    @Column(name = "primary_bios")
    private Boolean primaryBios;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "smbios_present")
    private Boolean smbiosPresent;

    @Column(name = "bits_per_pixel")
    private Integer BitsPerPixel;

    @Column(name = "current_bits_per_pixel")
    private Integer currentBitsPerPixel;

    @Column(name = "current_number_of_colors")
    private Long currentNumberOfColors;

    @Column(name = "colors")
    private Integer colors;

    @Column(name = "current_refresh_rate")
    private Integer currentRefreshRate;

    @Column(name = "current_horizontal_resolution")
    private Integer currentHorizontalResolution;

    @Column(name = "current_vertical_resolution")
    private Integer currentVerticalResolution;

    @Column(name = "refresh_rate")
    private Integer refreshRate;

    @Column(name = "horizontal_res")
    private Integer horizontalRes;

    @Column(name = "vertical_res")
    private Integer verticalRes;

    @Column(name = "adapter_ram")
    private Integer adapterRam;

    @Column(name = "firmware_revision", length = 50)
    private String firmwareRevision;

    @Column(name = "max_clock_speed")
    private Integer maxClockSpeed;

    @Column(name = "max_media_size")
    private Integer maxMediaSize;

    @Column(name = "media_type", length = 100)
    private String mediaType;

    @Column(name = "hardware_version", length = 50)
    private String hardwareVersion;

    @Column(name = "status_info", length = 100)
    private String statusInfo;

    @Column(name = "total_cylinders")
    private Integer totalCylinders;

    @Column(name = "tracks_per_cylinder")
    private Integer tracksPerCylinder;

    @Column(name = "sectors_per_track")
    private Integer sectorsPerTrack;

    @Column(name = "bytes_per_sector")
    private Integer bytesPerSector;

    @Column(name = "video_processor", length = 100)
    private String videoProcessor;

    @Column(name = "volume_serial_number", length = 100)
    private String volumeSerialNumber;

    @Column(name = "driver_name", length = 100)
    private String driverName;

    @Column(name = "interface_index")
    private Integer interfaceIndex;

    @Column(name = "protocol_supported")
    private Integer protocolSupported;

    @Column(name = "volume_name", length = 100)
    private String volumeName;

    public HardwareDevice() {
    }

    public HardwareDevice(_1394Controller hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId._1394_CONTROLLER));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(BaseBoard hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.BASE_BOARD));
	this.model = hw.getModel();
	this.product = hw.getProduct();
	this.serialNumber = hw.getSerialNumber();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(Bios hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.BIOS));
	this.setCurrentLanguage(hw.getCurrentLanguage());
	this.setPrimaryBios(Boolean.parseBoolean(hw.getPrimaryBIOS()));
	if (hw.getReleaseDate().length() > 0) {
	    try {
		this.setReleaseDate(new SimpleDateFormat("yyyyMMdd").parse(hw
			.getReleaseDate().substring(0, 8)));
	    } catch (ParseException e) {
		logger.error("Couldn't parse Bios date.", e);
		this.releaseDate = null;
	    }
	}
	this.setSmbiosVersion(Utils.unescapeJsonChain(hw.getSmBIOSVersion()));
	this.setVersion(Utils.unescapeJsonChain(hw.getVersion()));
	this.serialNumber = hw.getSerialNumber();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(CDROMDrive hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.CDROM_DRIVE));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.mediaType = hw.getMediaType();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(ComputerSystem hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.COMPUTER_SYSTEM));
	this.caption = hw.getCaption();
	if (hw.getCurrentTimeZone().length() > 0) {
	    this.currentTimeZone = Integer.parseInt(hw.getCurrentTimeZone());
	}
	this.daylightInEffect = Boolean.parseBoolean(hw.getDaylightInEffect());
	this.description = hw.getDescription();
	this.domain = hw.getDomain();
	this.manufacturer = hw.getManufacturer();
	this.model = hw.getModel();
	this.name = hw.getName();
	if (hw.getNumberOfProcessors().length() > 0) {
	    this.numberOfProcessors = Integer.parseInt(hw
		    .getNumberOfProcessors());
	}
	this.status = hw.getStatus();

	// EP410008 - 12/02/2013 - Added length > 0
	if (hw.getTotalPhysicalMemory().length() > 0) {
	    this.totalPhysicalMemory = Long.parseLong(hw
		    .getTotalPhysicalMemory());
	}
	// <--
	this.workgroup = hw.getWorkgroup();
    }

    public HardwareDevice(DesktopMonitor hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.DESKTOP_MONITOR));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.displayType = Boolean.parseBoolean(hw.getDisplayType());
	this.monitorManufacturer = hw.getMonitorManufacturer();
	this.monitorType = hw.getMonitorType();
	this.name = hw.getName();
	if (hw.getPixelsPerXLogicalInch().length() > 0) {
	    this.pixelsPerXLogicalInch = Integer.parseInt(hw
		    .getPixelsPerXLogicalInch());
	}
	if (hw.getPixelsPerYLogicalInch().length() > 0) {
	    this.pixelsPerYLogicalInch = Integer.parseInt(hw
		    .getPixelsPerYLogicalInch());
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(DiskDrive hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.DISK_DRIVE));
	if (hw.getBytesPerSector().length() > 0) {
	    this.bytesPerSector = Integer.parseInt(hw.getBytesPerSector());
	}
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	if (hw.getMaxMediaSize().length() > 0) {
	    this.maxMediaSize = Integer.parseInt(hw.getMaxMediaSize());
	}
	this.firmwareRevision = hw.getFirmwareRevision();
	this.mediaType = hw.getMediaType();
	this.model = hw.getModel();
	this.name = hw.getName();
	if (hw.getPartitions().length() > 0) {
	    this.partitions = Integer.parseInt(hw.getPartitions());
	}
	if (hw.getSectorsPerTrack().length() > 0) {
	    this.sectorsPerTrack = Integer.parseInt(hw.getSectorsPerTrack());
	}
	this.serialNumber = hw.getSerialNumber();
	this.signature = hw.getSignature();
	this.size = Long.parseLong(hw.getSize());
	this.status = hw.getStatus();
	if (hw.getTotalCylinders().length() > 0) {
	    this.totalCylinders = Integer.parseInt(hw.getTotalCylinders());
	}
	if (hw.getTracksPerCylinder().length() > 0) {
	    this.tracksPerCylinder = Integer
		    .parseInt(hw.getTracksPerCylinder());
	}
    }

    public HardwareDevice(FloppyDrive hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.FLOPPY_DRIVE));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.mediaType = hw.getMediaType();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(Keyboard hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.KEYBOARD));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.layout = hw.getLayout();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(LogicalDisk hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.LOGICAL_DISK));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.fileSystem = hw.getFileSystem();
	this.freeSpace = Long.parseLong(hw.getFreeSpace());
	this.name = hw.getName();
	this.size = Long.parseLong(hw.getSize());
	this.volumeName = hw.getVolumeName();
	this.volumeSerialNumber = hw.getVolumeSerialNumber();
    }

    public HardwareDevice(NetworkAdapterSetting hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.NETWORK_ADAPTER));
	this.adapterType = hw.getAdapterType();
	this.caption = hw.getCaption();
	this.defaultIpGateway = hw.getDefaultIPGateway();
	this.description = hw.getDescription();
	this.dhcpEnabled = Boolean.parseBoolean(hw.getDhcpEnabled());
	this.dhcpServer = hw.getDhcpServer();
	if (hw.getInterfaceIndex().length() > 0) {
	    this.interfaceIndex = Integer.parseInt(hw.getInterfaceIndex());
	}
	this.ipAddress = hw.getIpAddress();
	this.ipSubnet = hw.getIpSubnet();
	this.macAddress = hw.getMacAddress();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.netConnectionId = hw.getNetConnectionID();
	this.netConnectionStatus = hw.getNetConnectionStatus();
	if (hw.getSpeed().length() > 0) {
	    this.speed = Long.parseLong(hw.getSpeed());
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(ParallelPort hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PARALLEL_PORT));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(PhysicalMemory hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PHYSICAL_MEMORY));
	this.capacity = Long.parseLong(hw.getCapacity());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(PointingDevice hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.POINTING_DEVICE));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.hardwareType = hw.getHardwareType();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	if (hw.getPointingType().length() > 0) {
	    this.pointingType = Integer.parseInt(hw.getPointingType());
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(Processor hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PROCESSOR));
	if (hw.getAddressWidth().length() > 0) {
	    this.addressWidth = Integer.parseInt(hw.getAddressWidth());
	}
	this.architecture = hw.getArchitecture();
	this.caption = hw.getCaption();
	if (hw.getCurrentClockSpeed().length() > 0) {
	    this.currentClockSpeed = Integer
		    .parseInt(hw.getCurrentClockSpeed());
	}
	if (hw.getDataWidth().length() > 0) {
	    this.dataWidth = Integer.parseInt(hw.getDataWidth());
	}
	if (hw.getExtClock().length() > 0) {
	    this.extClock = Integer.parseInt(hw.getExtClock());
	}
	this.manufacturer = hw.getManufacturer();
	if (hw.getMaxClockSpeed().length() > 0) {
	    this.maxClockSpeed = Integer.parseInt(hw.getMaxClockSpeed());
	}
	this.name = hw.getName();
	if (hw.getNumberOfCores().length() > 0) {
	    this.numberOfProcessors = Integer.parseInt(hw.getNumberOfCores());
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(SCSIController hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SCSI_CONTROLLER));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.driverName = hw.getDriverName();
	this.setHardwareVersion(hw.getHardwareVersion());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.statusInfo = hw.getStatusInfo();
    }

    public HardwareDevice(SerialPort hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SERIAL_PORT));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	if (hw.getMaxBaudRate().length() > 0) {
	    this.maxBaudRate = Integer.parseInt(hw.getMaxBaudRate());
	}
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(SoundDevice hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SOUND_DEVICE));
	this.caption = hw.getCaption();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(SystemSlot hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SYSTEM_SLOT));
	this.caption = hw.getCaption();
	if (hw.getCurrentUsage().length() > 0) {
	    this.currentUsage = Integer.parseInt(hw.getCurrentUsage());
	}
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.serialNumber = hw.getSerialNumber();
	this.slotDesignation = hw.getSlotDesignation();
	this.tag = hw.getTag();
	this.setVersion(Utils.unescapeJsonChain(hw.getVersion()));
    }

    public HardwareDevice(USBController hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.USB_CONTROLLER));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	if (hw.getProtocolSupported().length() > 0) {
	    this.protocolSupported = Integer
		    .parseInt(hw.getProtocolSupported());
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(UsbHub hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.USB_HUB));
	this.description = hw.getDescription();
	this.name = hw.getName();
	if (hw.getNumberOfPorts().length() > 0) {
	    this.numberOfPorts = Integer.parseInt(hw.getNumberOfPorts());
	}
	this.protocolCode = hw.getProtocolCode();
	this.status = hw.getStatus();
	this.setUsbVersion(hw.getUsbVersion());
    }

    public HardwareDevice(VideoController hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.VIDEO_CONTROLLER));
	if (hw.getAdapterRAM().length() > 0) {
	    this.adapterRam = Integer.parseInt(hw.getAdapterRAM());
	}
	// EP410008 - 12/02/2013 - Added length > 0
	if (hw.getCurrentBitsPerPixel().length() > 0) {
	    this.currentBitsPerPixel = Integer.parseInt(hw
		    .getCurrentBitsPerPixel());
	}
	// <--
	if (hw.getCurrentHorizontalResolution().length() > 0) {
	    this.currentHorizontalResolution = Integer.parseInt(hw
		    .getCurrentHorizontalResolution());
	}
	if (hw.getCurrentNumberOfColors().length() > 0) {
	    this.currentNumberOfColors = Long.parseLong(hw
		    .getCurrentNumberOfColors());
	}
	if (hw.getCurrentRefreshRate().length() > 0) {
	    this.currentRefreshRate = Integer.parseInt(hw
		    .getCurrentRefreshRate());
	}
	if (hw.getCurrentVerticalResolution().length() > 0) {
	    this.currentVerticalResolution = Integer.parseInt(hw
		    .getCurrentVerticalResolution());
	}
	this.description = hw.getDescription();
	this.name = hw.getName();
	this.videoProcessor = hw.getVideoProcessor();
    }

    public HardwareDevice(_1394ControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId._1394_CONTROLLER));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(BaseBoardPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.BASE_BOARD));
	this.model = hw.getModel();
	this.product = hw.getProduct();
	this.serialNumber = hw.getSerialNumber();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(BiosPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.BIOS));
	this.setCurrentLanguage(hw.getCurrentLanguage());
	this.setPrimaryBios(Boolean.parseBoolean(hw.getPrimaryBIOS()));
	if ((hw.getReleaseDate() != null) && (hw.getReleaseDate().length() > 0)
		&& (!hw.getReleaseDate().equals("null"))) {
	    try {
		this.setReleaseDate(new SimpleDateFormat("yyyyMMdd").parse(hw
			.getReleaseDate().substring(0, 8)));
	    } catch (ParseException e) {
		logger.error("Couldn't parse Bios date.", e);
		this.releaseDate = null;
	    }
	}
	this.setSmbiosVersion(Utils.unescapeJsonChain(hw.getSmBIOSVersion()));
	this.setVersion(Utils.unescapeJsonChain(hw.getVersion()));
	this.serialNumber = hw.getSerialNumber();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(CDROMDrivePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.CDROM_DRIVE));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.mediaType = hw.getMediaType();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(ComputerSystemPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.COMPUTER_SYSTEM));
	this.caption = hw.getCaption();
	if ((hw.getCurrentTimeZone() != null)
		&& (hw.getCurrentTimeZone().length() > 0)
		&& (!hw.getCurrentTimeZone().equals("null"))) {
	    try {
		this.currentTimeZone = Integer
			.parseInt(hw.getCurrentTimeZone());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.daylightInEffect = Boolean.parseBoolean(hw.getDaylightInEffect());
	this.description = hw.getDescription();
	this.domain = hw.getDomain();
	this.manufacturer = hw.getManufacturer();
	this.model = hw.getModel();
	this.name = hw.getName();
	if ((hw.getNumberOfProcessors() != null)
		&& (hw.getNumberOfProcessors().length() > 0)
		&& (!hw.getNumberOfProcessors().equals("null"))) {
	    try {
		this.numberOfProcessors = Integer.parseInt(hw
			.getNumberOfProcessors());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();

	// EP410008 - 12/02/2013 - Added length > 0
	if ((hw.getTotalPhysicalMemory() != null)
		&& (hw.getTotalPhysicalMemory().length() > 0)
		&& (!hw.getTotalPhysicalMemory().equals("null"))) {
	    try {
		this.totalPhysicalMemory = Long.parseLong(hw
			.getTotalPhysicalMemory());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// <--
	this.workgroup = hw.getWorkgroup();
    }

    public HardwareDevice(DesktopMonitorPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.DESKTOP_MONITOR));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.displayType = Boolean.parseBoolean(hw.getDisplayType());
	this.monitorManufacturer = hw.getMonitorManufacturer();
	this.monitorType = hw.getMonitorType();
	this.name = hw.getName();
	if ((hw.getPixelsPerXLogicalInch() != null)
		&& (hw.getPixelsPerXLogicalInch().length() > 0)
		&& (!hw.getPixelsPerXLogicalInch().equals("null"))) {
	    try {
		this.pixelsPerXLogicalInch = Integer.parseInt(hw
			.getPixelsPerXLogicalInch());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getPixelsPerYLogicalInch() != null)
		&& (hw.getPixelsPerYLogicalInch().length() > 0)
		&& (!hw.getPixelsPerYLogicalInch().equals("null"))) {
	    try {
		this.pixelsPerYLogicalInch = Integer.parseInt(hw
			.getPixelsPerYLogicalInch());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(DiskDrivePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.DISK_DRIVE));
	if ((hw.getBytesPerSector() != null)
		&& (hw.getBytesPerSector().length() > 0)
		&& (!hw.getBytesPerSector().equals("null"))) {
	    try {
		this.bytesPerSector = Integer.parseInt(hw.getBytesPerSector());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	if ((hw.getMaxMediaSize() != null)
		&& (hw.getMaxMediaSize().length() > 0)
		&& (!hw.getMaxMediaSize().equals("null"))) {
	    try {
		this.maxMediaSize = Integer.parseInt(hw.getMaxMediaSize());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// this.firmwareRevision = hw.getFirmwareRevision();
	this.mediaType = hw.getMediaType();
	this.model = hw.getModel();
	this.name = hw.getName();
	if ((hw.getPartitions() != null) && (hw.getPartitions().length() > 0)
		&& (!hw.getPartitions().equals("null"))) {
	    try {
		this.partitions = Integer.parseInt(hw.getPartitions());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getSectorsPerTrack() != null)
		&& (hw.getSectorsPerTrack().length() > 0)
		&& (!hw.getSectorsPerTrack().equals("null"))) {
	    try {
		this.sectorsPerTrack = Integer
			.parseInt(hw.getSectorsPerTrack());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// this.serialNumber = hw.getSerialNumber();
	this.signature = hw.getSignature();
	this.size = Long.parseLong(hw.getSize());
	this.status = hw.getStatus();
	if ((hw.getTotalCylinders() != null)
		&& (hw.getTotalCylinders().length() > 0)
		&& (!hw.getTotalCylinders().equals("null"))) {
	    try {
		this.totalCylinders = Integer.parseInt(hw.getTotalCylinders());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getTracksPerCylinder() != null)
		&& (hw.getTracksPerCylinder().length() > 0)
		&& (!hw.getTracksPerCylinder().equals("null"))) {
	    try {
		this.tracksPerCylinder = Integer.parseInt(hw
			.getTracksPerCylinder());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
    }

    public HardwareDevice(FloppyDrivePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.FLOPPY_DRIVE));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	// this.mediaType = hw.getMediaType();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(KeyboardPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.KEYBOARD));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.layout = hw.getLayout();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(LogicalDiskPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.LOGICAL_DISK));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.fileSystem = hw.getFileSystem();
	if ((hw.getFreeSpace() != null) && (hw.getFreeSpace().length() > 0)
		&& (!hw.getFreeSpace().equals("null"))) {
	    try {
		this.freeSpace = Long.parseLong(hw.getFreeSpace());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.name = hw.getName();
	if ((hw.getSize() != null) && (hw.getSize().length() > 0)
		&& (!hw.getSize().equals("null"))) {
	    try {
		this.size = Long.parseLong(hw.getSize());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.volumeName = hw.getVolumeName();
	this.volumeSerialNumber = hw.getVolumeSerialNumber();
    }

    public HardwareDevice(NetworkAdapterSettingPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.NETWORK_ADAPTER));
	this.adapterType = hw.getAdapterType();
	this.caption = hw.getCaption();
	this.defaultIpGateway = hw.getDefaultIPGateway();
	this.description = hw.getDescription();
	this.dhcpEnabled = Boolean.parseBoolean(hw.getDhcpEnabled());
	this.dhcpServer = hw.getDhcpServer();
	if ((hw.getInterfaceIndex() != null)
		&& (hw.getInterfaceIndex().length() > 0)
		&& (!hw.getInterfaceIndex().equals("null"))) {
	    try {
		this.interfaceIndex = Integer.parseInt(hw.getInterfaceIndex());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.ipAddress = hw.getIpAddress();
	this.ipSubnet = hw.getIpSubnet();
	this.macAddress = hw.getMacAddress();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.netConnectionId = hw.getNetConnectionID();
	this.netConnectionStatus = hw.getNetConnectionStatus();
	if ((hw.getSpeed() != null) && (hw.getSpeed().length() > 0)
		&& (!hw.getSpeed().equals("null"))) {
	    try {
		this.speed = Long.parseLong(hw.getSpeed());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(ParallelPortPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PARALLEL_PORT));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(PhysicalMemoryPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PHYSICAL_MEMORY));
	if ((hw.getCapacity() != null) && (hw.getCapacity().length() > 0)
		&& (!hw.getCapacity().equals("null"))) {
	    try {
		this.capacity = Long.parseLong(hw.getCapacity());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(PointingDevicePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.POINTING_DEVICE));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.hardwareType = hw.getHardwareType();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	if ((hw.getPointingType() != null)
		&& (hw.getPointingType().length() > 0)
		&& (!hw.getPointingType().equals("null"))) {
	    try {
		this.pointingType = Integer.parseInt(hw.getPointingType());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(ProcessorPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PROCESSOR));
	if ((hw.getAddressWidth() != null)
		&& (hw.getAddressWidth().length() > 0)
		&& (!hw.getAddressWidth().equals("null"))) {
	    try {
		this.addressWidth = Integer.parseInt(hw.getAddressWidth());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.architecture = hw.getArchitecture();
	this.caption = hw.getCaption();
	if ((hw.getCurrentClockSpeed() != null)
		&& (hw.getCurrentClockSpeed().length() > 0)
		&& (!hw.getCurrentClockSpeed().equals("null"))) {
	    try {
		this.currentClockSpeed = Integer.parseInt(hw
			.getCurrentClockSpeed());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getDataWidth() != null) && (hw.getDataWidth().length() > 0)
		&& (!hw.getDataWidth().equals("null"))) {
	    try {
		this.dataWidth = Integer.parseInt(hw.getDataWidth());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getExtClock() != null) && (hw.getExtClock().length() > 0)
		&& (!hw.getExtClock().equals("null"))) {
	    try {
		this.extClock = Integer.parseInt(hw.getExtClock());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.manufacturer = hw.getManufacturer();
	if ((hw.getMaxClockSpeed() != null)
		&& (hw.getMaxClockSpeed().length() > 0)
		&& (!hw.getMaxClockSpeed().equals("null"))) {
	    try {
		this.maxClockSpeed = Integer.parseInt(hw.getMaxClockSpeed());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.name = hw.getName();
	// if (hw.getNumberOfCores().length() > 0) {
	// this.numberOfProcessors = Integer.parseInt(hw.getNumberOfCores());
	// }
	this.status = hw.getStatus();
    }

    public HardwareDevice(SCSIControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SCSI_CONTROLLER));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.driverName = hw.getDriverName();
	this.setHardwareVersion(hw.getHardwareVersion());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.statusInfo = hw.getStatusInfo();
    }

    public HardwareDevice(SerialPortPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SERIAL_PORT));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	if ((hw.getMaxBaudRate() != null) && (hw.getMaxBaudRate().length() > 0)
		&& (!hw.getMaxBaudRate().equals("null"))) {
	    try {
		this.maxBaudRate = Integer.parseInt(hw.getMaxBaudRate());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(SoundDevicePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SOUND_DEVICE));
	this.caption = hw.getCaption();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    public HardwareDevice(SystemSlotPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SYSTEM_SLOT));
	this.caption = hw.getCaption();
	if ((hw.getCurrentUsage() != null)
		&& (hw.getCurrentUsage().length() > 0)
		&& (!hw.getCurrentUsage().equals("null"))) {
	    try {
		this.currentUsage = Integer.parseInt(hw.getCurrentUsage());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.serialNumber = hw.getSerialNumber();
	this.slotDesignation = hw.getSlotDesignation();
	this.tag = hw.getTag();
	this.setVersion(Utils.unescapeJsonChain(hw.getVersion()));
    }

    public HardwareDevice(USBControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.USB_CONTROLLER));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	if ((hw.getProtocolSupported() != null)
		&& (hw.getProtocolSupported().length() > 0)
		&& (!hw.getProtocolSupported().equals("null"))) {
	    try {
		this.protocolSupported = Integer.parseInt(hw
			.getProtocolSupported());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    public HardwareDevice(UsbHubPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.USB_HUB));
	this.description = hw.getDescription();
	this.name = hw.getName();
	if ((hw.getNumberOfPorts() != null)
		&& (hw.getNumberOfPorts().length() > 0)
		&& (!hw.getNumberOfPorts().equals("null"))) {
	    try {
		this.numberOfPorts = Integer.parseInt(hw.getNumberOfPorts());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.protocolCode = hw.getProtocolCode();
	this.status = hw.getStatus();
	this.setUsbVersion(hw.getUsbVersion());
    }

    public HardwareDevice(VideoControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.VIDEO_CONTROLLER));
	if ((hw.getAdapterRAM() != null) && (hw.getAdapterRAM().length() > 0)
		&& (!hw.getAdapterRAM().equals("null"))) {
	    try {
		this.adapterRam = Integer.parseInt(hw.getAdapterRAM());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// EP410008 - 12/02/2013 - Added length > 0
	if ((hw.getCurrentBitsPerPixel() != null)
		&& (hw.getCurrentBitsPerPixel().length() > 0)
		&& (!hw.getCurrentBitsPerPixel().equals("null"))) {
	    try {
		this.currentBitsPerPixel = Integer.parseInt(hw
			.getCurrentBitsPerPixel());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentHorizontalResolution() != null)
		&& (hw.getCurrentHorizontalResolution().length() > 0)
		&& (!hw.getCurrentHorizontalResolution().equals("null"))) {
	    try {
		this.currentHorizontalResolution = Integer.parseInt(hw
			.getCurrentHorizontalResolution());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentNumberOfColors() != null)
		&& (hw.getCurrentNumberOfColors().length() > 0)
		&& (!hw.getCurrentNumberOfColors().equals("null"))) {
	    try {
		this.currentNumberOfColors = Long.parseLong(hw
			.getCurrentNumberOfColors());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentRefreshRate() != null)
		&& (hw.getCurrentRefreshRate().length() > 0)
		&& (!hw.getCurrentRefreshRate().equals("null"))) {
	    try {
		this.currentRefreshRate = Integer.parseInt(hw
			.getCurrentRefreshRate());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentVerticalResolution() != null)
		&& (hw.getCurrentVerticalResolution().length() > 0)
		&& (!hw.getCurrentVerticalResolution().equals("null"))) {
	    try {
		this.currentVerticalResolution = Integer.parseInt(hw
			.getCurrentVerticalResolution());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.description = hw.getDescription();
	this.name = hw.getName();
	this.videoProcessor = hw.getVideoProcessor();
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
     * @return the hardwareClass
     */
    public String getHardwareClass() {
	return hardwareClass;
    }

    /**
     * @param hardwareClass
     *            the hardwareClass to set
     */
    public void setHardwareClass(String hardwareClass) {
	this.hardwareClass = hardwareClass;
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

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
	return manufacturer;
    }

    /**
     * @param manufacturer
     *            the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    /**
     * @return the model
     */
    public String getModel() {
	return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * @return the numberOfProcessors
     */
    public Integer getNumberOfProcessors() {
	return numberOfProcessors;
    }

    /**
     * @param numberOfProcessors
     *            the numberOfProcessors to set
     */
    public void setNumberOfProcessors(Integer numberOfProcessors) {
	this.numberOfProcessors = numberOfProcessors;
    }

    /**
     * @return the caption
     */
    public String getCaption() {
	return caption;
    }

    /**
     * @param caption
     *            the caption to set
     */
    public void setCaption(String caption) {
	this.caption = caption;
    }

    /**
     * @return the totalPhysicalMemory
     */
    public Long getTotalPhysicalMemory() {
	return totalPhysicalMemory;
    }

    /**
     * @param totalPhysicalMemory
     *            the totalPhysicalMemory to set
     */
    public void setTotalPhysicalMemory(Long totalPhysicalMemory) {
	this.totalPhysicalMemory = totalPhysicalMemory;
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
     * @return the currentTimeZone
     */
    public Integer getCurrentTimeZone() {
	return currentTimeZone;
    }

    /**
     * @param currentTimeZone
     *            the currentTimeZone to set
     */
    public void setCurrentTimeZone(Integer currentTimeZone) {
	this.currentTimeZone = currentTimeZone;
    }

    /**
     * @return the daylightInEffect
     */
    public Boolean getDaylightInEffect() {
	return daylightInEffect;
    }

    /**
     * @param daylightInEffect
     *            the daylightInEffect to set
     */
    public void setDaylightInEffect(Boolean daylightInEffect) {
	this.daylightInEffect = daylightInEffect;
    }

    /**
     * @return the domain
     */
    public String getDomain() {
	return domain;
    }

    /**
     * @param domain
     *            the domain to set
     */
    public void setDomain(String domain) {
	this.domain = domain;
    }

    /**
     * @return the workgroup
     */
    public String getWorkgroup() {
	return workgroup;
    }

    /**
     * @param workgroup
     *            the workgroup to set
     */
    public void setWorkgroup(String workgroup) {
	this.workgroup = workgroup;
    }

    /**
     * @return the status
     */
    public String getStatus() {
	return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
	this.status = status;
    }

    /**
     * @return the architecture
     */
    public String getArchitecture() {
	return architecture;
    }

    /**
     * @param architecture
     *            the architecture to set
     */
    public void setArchitecture(String architecture) {
	this.architecture = architecture;
    }

    /**
     * @return the addressWidth
     */
    public Integer getAddressWidth() {
	return addressWidth;
    }

    /**
     * @param addressWidth
     *            the addressWidth to set
     */
    public void setAddressWidth(Integer addressWidth) {
	this.addressWidth = addressWidth;
    }

    /**
     * @return the currentClockSpeed
     */
    public Integer getCurrentClockSpeed() {
	return currentClockSpeed;
    }

    /**
     * @param currentClockSpeed
     *            the currentClockSpeed to set
     */
    public void setCurrentClockSpeed(Integer currentClockSpeed) {
	this.currentClockSpeed = currentClockSpeed;
    }

    /**
     * @return the extClock
     */
    public Integer getExtClock() {
	return extClock;
    }

    /**
     * @param extClock
     *            the extClock to set
     */
    public void setExtClock(Integer extClock) {
	this.extClock = extClock;
    }

    /**
     * @return the stepping
     */
    public Integer getStepping() {
	return stepping;
    }

    /**
     * @param stepping
     *            the stepping to set
     */
    public void setStepping(Integer stepping) {
	this.stepping = stepping;
    }

    /**
     * @return the capacity
     */
    public Long getCapacity() {
	return capacity;
    }

    /**
     * @param capacity
     *            the capacity to set
     */
    public void setCapacity(Long capacity) {
	this.capacity = capacity;
    }

    /**
     * @return the speed
     */
    public Long getSpeed() {
	return speed;
    }

    /**
     * @param speed
     *            the speed to set
     */
    public void setSpeed(Long speed) {
	this.speed = speed;
    }

    /**
     * @return the partitions
     */
    public Integer getPartitions() {
	return partitions;
    }

    /**
     * @param partitions
     *            the partitions to set
     */
    public void setPartitions(Integer partitions) {
	this.partitions = partitions;
    }

    /**
     * @return the size
     */
    public Long getSize() {
	return size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(Long size) {
	this.size = size;
    }

    /**
     * @return the freeSpace
     */
    public Long getFreeSpace() {
	return freeSpace;
    }

    /**
     * @param freeSpace
     *            the freeSpace to set
     */
    public void setFreeSpace(Long freeSpace) {
	this.freeSpace = freeSpace;
    }

    /**
     * @return the fileSystem
     */
    public String getFileSystem() {
	return fileSystem;
    }

    /**
     * @param fileSystem
     *            the fileSystem to set
     */
    public void setFileSystem(String fileSystem) {
	this.fileSystem = fileSystem;
    }

    /**
     * @return the version
     */
    public String getVersion() {
	return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(String version) {
	this.version = version;
    }

    /**
     * @return the name and version concatenated
     */
    public String getNameVersion() {
	return name + " (V. " + getVersion() + ")";
    }

    /**
     * @return the adapterType
     */
    public String getAdapterType() {
	return adapterType;
    }

    /**
     * @param adapterType
     *            the adapterType to set
     */
    public void setAdapterType(String adapterType) {
	this.adapterType = adapterType;
    }

    /**
     * @return the dhcpEnabled
     */
    public Boolean getDhcpEnabled() {
	return dhcpEnabled;
    }

    /**
     * @param dhcpEnabled
     *            the dhcpEnabled to set
     */
    public void setDhcpEnabled(Boolean dhcpEnabled) {
	this.dhcpEnabled = dhcpEnabled;
    }

    /**
     * @return the dhcpServer
     */
    public String getDhcpServer() {
	return dhcpServer;
    }

    /**
     * @param dhcpServer
     *            the dhcpServer to set
     */
    public void setDhcpServer(String dhcpServer) {
	this.dhcpServer = dhcpServer;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
	return ipAddress;
    }

    /**
     * @param ipAddress
     *            the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
    }

    /**
     * @return the ipSubnet
     */
    public String getIpSubnet() {
	return ipSubnet;
    }

    /**
     * @param ipSubnet
     *            the ipSubnet to set
     */
    public void setIpSubnet(String ipSubnet) {
	this.ipSubnet = ipSubnet;
    }

    /**
     * @return the defaultIpGateway
     */
    public String getDefaultIpGateway() {
	return defaultIpGateway;
    }

    /**
     * @param defaultIpGateway
     *            the defaultIpGateway to set
     */
    public void setDefaultIpGateway(String defaultIpGateway) {
	this.defaultIpGateway = defaultIpGateway;
    }

    /**
     * @return the macAddress
     */
    public String getMacAddress() {
	return macAddress;
    }

    /**
     * @param macAddress
     *            the macAddress to set
     */
    public void setMacAddress(String macAddress) {
	this.macAddress = macAddress;
    }

    /**
     * @return the netConnectionId
     */
    public String getNetConnectionId() {
	return netConnectionId;
    }

    /**
     * @param netConnectionId
     *            the netConnectionId to set
     */
    public void setNetConnectionId(String netConnectionId) {
	this.netConnectionId = netConnectionId;
    }

    /**
     * @return the netConnectionStatus
     */
    public String getNetConnectionStatus() {
	return netConnectionStatus;
    }

    /**
     * @param netConnectionStatus
     *            the netConnectionStatus to set
     */
    public void setNetConnectionStatus(String netConnectionStatus) {
	this.netConnectionStatus = netConnectionStatus;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {
	return deviceId;
    }

    /**
     * @param deviceId
     *            the deviceId to set
     */
    public void setDeviceId(String deviceId) {
	this.deviceId = deviceId;
    }

    /**
     * @return the maxBaudRate
     */
    public Integer getMaxBaudRate() {
	return maxBaudRate;
    }

    /**
     * @param maxBaudRate
     *            the maxBaudRate to set
     */
    public void setMaxBaudRate(Integer maxBaudRate) {
	this.maxBaudRate = maxBaudRate;
    }

    /**
     * @return the displayType
     */
    public Boolean getDisplayType() {
	return displayType;
    }

    /**
     * @param displayType
     *            the displayType to set
     */
    public void setDisplayType(Boolean displayType) {
	this.displayType = displayType;
    }

    /**
     * @return the monitorManufacturer
     */
    public String getMonitorManufacturer() {
	return monitorManufacturer;
    }

    /**
     * @param monitorManufacturer
     *            the monitorManufacturer to set
     */
    public void setMonitorManufacturer(String monitorManufacturer) {
	this.monitorManufacturer = monitorManufacturer;
    }

    /**
     * @return the monitorType
     */
    public String getMonitorType() {
	return monitorType;
    }

    /**
     * @param monitorType
     *            the monitorType to set
     */
    public void setMonitorType(String monitorType) {
	this.monitorType = monitorType;
    }

    /**
     * @return the pixelsPerXLogicalInch
     */
    public Integer getPixelsPerXLogicalInch() {
	return pixelsPerXLogicalInch;
    }

    /**
     * @param pixelsPerXLogicalInch
     *            the pixelsPerXLogicalInch to set
     */
    public void setPixelsPerXLogicalInch(Integer pixelsPerXLogicalInch) {
	this.pixelsPerXLogicalInch = pixelsPerXLogicalInch;
    }

    /**
     * @return the pixelsPerYLogicalInch
     */
    public Integer getPixelsPerYLogicalInch() {
	return pixelsPerYLogicalInch;
    }

    /**
     * @param pixelsPerYLogicalInch
     *            the pixelsPerYLogicalInch to set
     */
    public void setPixelsPerYLogicalInch(Integer pixelsPerYLogicalInch) {
	this.pixelsPerYLogicalInch = pixelsPerYLogicalInch;
    }

    /**
     * @return the layout
     */
    public String getLayout() {
	return layout;
    }

    /**
     * @param layout
     *            the layout to set
     */
    public void setLayout(String layout) {
	this.layout = layout;
    }

    /**
     * @return the hardwareType
     */
    public String getHardwareType() {
	return hardwareType;
    }

    /**
     * @param hardwareType
     *            the hardwareType to set
     */
    public void setHardwareType(String hardwareType) {
	this.hardwareType = hardwareType;
    }

    /**
     * @return the pointingType
     */
    public Integer getPointingType() {
	return pointingType;
    }

    /**
     * @param pointingType
     *            the pointingType to set
     */
    public void setPointingType(Integer pointingType) {
	this.pointingType = pointingType;
    }

    /**
     * @return the currentUsage
     */
    public Integer getCurrentUsage() {
	return currentUsage;
    }

    /**
     * @param currentUsage
     *            the currentUsage to set
     */
    public void setCurrentUsage(Integer currentUsage) {
	this.currentUsage = currentUsage;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
	return serialNumber;
    }

    /**
     * @param serialNumber
     *            the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * @return the slotDesignation
     */
    public String getSlotDesignation() {
	return slotDesignation;
    }

    /**
     * @param slotDesignation
     *            the slotDesignation to set
     */
    public void setSlotDesignation(String slotDesignation) {
	this.slotDesignation = slotDesignation;
    }

    /**
     * @return the tag
     */
    public String getTag() {
	return tag;
    }

    /**
     * @param tag
     *            the tag to set
     */
    public void setTag(String tag) {
	this.tag = tag;
    }

    /**
     * @return the smbiosVersion
     */
    public String getSmbiosVersion() {
	return smbiosVersion;
    }

    /**
     * @param smbiosVersion
     *            the smbiosVersion to set
     */
    public void setSmbiosVersion(String smbiosVersion) {
	this.smbiosVersion = smbiosVersion;
    }

    /**
     * @return the smbiosMajorVersion
     */
    public Integer getSmbiosMajorVersion() {
	return smbiosMajorVersion;
    }

    /**
     * @param smbiosMajorVersion
     *            the smbiosMajorVersion to set
     */
    public void setSmbiosMajorVersion(Integer smbiosMajorVersion) {
	this.smbiosMajorVersion = smbiosMajorVersion;
    }

    /**
     * @return the smbiosMinorVersion
     */
    public Integer getSmbiosMinorVersion() {
	return smbiosMinorVersion;
    }

    /**
     * @param smbiosMinorVersion
     *            the smbiosMinorVersion to set
     */
    public void setSmbiosMinorVersion(Integer smbiosMinorVersion) {
	this.smbiosMinorVersion = smbiosMinorVersion;
    }

    /**
     * @return the currentLanguage
     */
    public String getCurrentLanguage() {
	return currentLanguage;
    }

    /**
     * @param currentLanguage
     *            the currentLanguage to set
     */
    public void setCurrentLanguage(String currentLanguage) {
	this.currentLanguage = currentLanguage;
    }

    /**
     * @return the primaryBios
     */
    public Boolean getPrimaryBios() {
	return primaryBios;
    }

    /**
     * @param primaryBios
     *            the primaryBios to set
     */
    public void setPrimaryBios(Boolean primaryBios) {
	this.primaryBios = primaryBios;
    }

    /**
     * @return the releaseDate
     */
    public Date getReleaseDate() {
	return releaseDate;
    }

    /**
     * @param releaseDate
     *            the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
    }

    /**
     * @return the smbiosPresent
     */
    public Boolean getSmbiosPresent() {
	return smbiosPresent;
    }

    /**
     * @param smbiosPresent
     *            the smbiosPresent to set
     */
    public void setSmbiosPresent(Boolean smbiosPresent) {
	this.smbiosPresent = smbiosPresent;
    }

    /**
     * @return the bitsPerPixel
     */
    public Integer getBitsPerPixel() {
	return BitsPerPixel;
    }

    /**
     * @param bitsPerPixel
     *            the bitsPerPixel to set
     */
    public void setBitsPerPixel(Integer bitsPerPixel) {
	BitsPerPixel = bitsPerPixel;
    }

    /**
     * @return the deviceclasses
     */
    public static Collection<String> getDeviceclasses() {
	return deviceClasses.values();
    }

    /**
     * @return the currentBitsPerPixel
     */
    public Integer getCurrentBitsPerPixel() {
	return currentBitsPerPixel;
    }

    /**
     * @param currentBitsPerPixel
     *            the currentBitsPerPixel to set
     */
    public void setCurrentBitsPerPixel(Integer currentBitsPerPixel) {
	this.currentBitsPerPixel = currentBitsPerPixel;
    }

    /**
     * @return the currentNumberOfColors
     */
    public Long getCurrentNumberOfColors() {
	return currentNumberOfColors;
    }

    /**
     * @param currentNumberOfColors
     *            the currentNumberOfColors to set
     */
    public void setCurrentNumberOfColors(Long currentNumberOfColors) {
	this.currentNumberOfColors = currentNumberOfColors;
    }

    /**
     * @return the currentRefreshRate
     */
    public Integer getCurrentRefreshRate() {
	return currentRefreshRate;
    }

    /**
     * @param currentRefreshRate
     *            the currentRefreshRate to set
     */
    public void setCurrentRefreshRate(Integer currentRefreshRate) {
	this.currentRefreshRate = currentRefreshRate;
    }

    /**
     * @return the currentHorizontalResolution
     */
    public Integer getCurrentHorizontalResolution() {
	return currentHorizontalResolution;
    }

    /**
     * @param currentHorizontalResolution
     *            the currentHorizontalResolution to set
     */
    public void setCurrentHorizontalResolution(
	    Integer currentHorizontalResolution) {
	this.currentHorizontalResolution = currentHorizontalResolution;
    }

    /**
     * @return the currentVerticalResolution
     */
    public Integer getCurrentVerticalResolution() {
	return currentVerticalResolution;
    }

    /**
     * @param currentVerticalResolution
     *            the currentVerticalResolution to set
     */
    public void setCurrentVerticalResolution(Integer currentVerticalResolution) {
	this.currentVerticalResolution = currentVerticalResolution;
    }

    /**
     * @return the adapterRam
     */
    public Integer getAdapterRam() {
	return adapterRam;
    }

    /**
     * @param adapterRam
     *            the adapterRam to set
     */
    public void setAdapterRam(Integer adapterRam) {
	this.adapterRam = adapterRam;
    }

    /**
     * @return the firmwareRevision
     */
    public String getFirmwareRevision() {
	return firmwareRevision;
    }

    /**
     * @param firmwareRevision
     *            the firmwareRevision to set
     */
    public void setFirmwareRevision(String firmwareRevision) {
	this.firmwareRevision = firmwareRevision;
    }

    /**
     * @return the maxClockSpeed
     */
    public Integer getMaxClockSpeed() {
	return maxClockSpeed;
    }

    /**
     * @param maxClockSpeed
     *            the maxClockSpeed to set
     */
    public void setMaxClockSpeed(Integer maxClockSpeed) {
	this.maxClockSpeed = maxClockSpeed;
    }

    /**
     * @return the maxMediaSize
     */
    public Integer getMaxMediaSize() {
	return maxMediaSize;
    }

    /**
     * @param maxMediaSize
     *            the maxMediaSize to set
     */
    public void setMaxMediaSize(Integer maxMediaSize) {
	this.maxMediaSize = maxMediaSize;
    }

    /**
     * @return the mediaType
     */
    public String getMediaType() {
	return mediaType;
    }

    /**
     * @param mediaType
     *            the mediaType to set
     */
    public void setMediaType(String mediaType) {
	this.mediaType = mediaType;
    }

    /**
     * @return the hardwareVersion
     */
    public String getHardwareVersion() {
	return hardwareVersion;
    }

    /**
     * @param hardwareVersion
     *            the hardwareVersion to set
     */
    public void setHardwareVersion(String hardwareVersion) {
	this.hardwareVersion = hardwareVersion;
    }

    /**
     * @return the hardware name and version concatenated
     */
    public String getHardwareNameVersion() {
	return name + " (V. " + getHardwareVersion() + ")";
    }

    /**
     * @return the statusInfo
     */
    public String getStatusInfo() {
	return statusInfo;
    }

    /**
     * @param statusInfo
     *            the statusInfo to set
     */
    public void setStatusInfo(String statusInfo) {
	this.statusInfo = statusInfo;
    }

    /**
     * @return the totalCylinders
     */
    public Integer getTotalCylinders() {
	return totalCylinders;
    }

    /**
     * @param totalCylinders
     *            the totalCylinders to set
     */
    public void setTotalCylinders(Integer totalCylinders) {
	this.totalCylinders = totalCylinders;
    }

    /**
     * @return the tracksPerCylinder
     */
    public Integer getTracksPerCylinder() {
	return tracksPerCylinder;
    }

    /**
     * @param tracksPerCylinder
     *            the tracksPerCylinder to set
     */
    public void setTracksPerCylinder(Integer tracksPerCylinder) {
	this.tracksPerCylinder = tracksPerCylinder;
    }

    /**
     * @return the sectorsPerTrack
     */
    public Integer getSectorsPerTrack() {
	return sectorsPerTrack;
    }

    /**
     * @param sectorsPerTrack
     *            the sectorsPerTrack to set
     */
    public void setSectorsPerTrack(Integer sectorsPerTrack) {
	this.sectorsPerTrack = sectorsPerTrack;
    }

    /**
     * @return the videoProcessor
     */
    public String getVideoProcessor() {
	return videoProcessor;
    }

    /**
     * @param videoProcessor
     *            the videoProcessor to set
     */
    public void setVideoProcessor(String videoProcessor) {
	this.videoProcessor = videoProcessor;
    }

    /**
     * @return the volumeSerialNumber
     */
    public String getVolumeSerialNumber() {
	return volumeSerialNumber;
    }

    /**
     * @param volumeSerialNumber
     *            the volumeSerialNumber to set
     */
    public void setVolumeSerialNumber(String volumeSerialNumber) {
	this.volumeSerialNumber = volumeSerialNumber;
    }

    /**
     * @return the driverName
     */
    public String getDriverName() {
	return driverName;
    }

    /**
     * @param driverName
     *            the driverName to set
     */
    public void setDriverName(String driverName) {
	this.driverName = driverName;
    }

    /**
     * @return the interfaceIndex
     */
    public Integer getInterfaceIndex() {
	return interfaceIndex;
    }

    /**
     * @param interfaceIndex
     *            the interfaceIndex to set
     */
    public void setInterfaceIndex(Integer interfaceIndex) {
	this.interfaceIndex = interfaceIndex;
    }

    /**
     * @return the protocolSupported
     */
    public Integer getProtocolSupported() {
	return protocolSupported;
    }

    /**
     * @param protocolSupported
     *            the protocolSupported to set
     */
    public void setProtocolSupported(Integer protocolSupported) {
	this.protocolSupported = protocolSupported;
    }

    /**
     * @return the volumeName
     */
    public String getVolumeName() {
	return volumeName;
    }

    /**
     * @param volumeName
     *            the volumeName to set
     */
    public void setVolumeName(String volumeName) {
	this.volumeName = volumeName;
    }

    /**
     * @return the bytesPerSector
     */
    public Integer getBytesPerSector() {
	return bytesPerSector;
    }

    /**
     * @param bytesPerSector
     *            the bytesPerSector to set
     */
    public void setBytesPerSector(Integer bytesPerSector) {
	this.bytesPerSector = bytesPerSector;
    }

    /**
     * @return the dataWidth
     */
    public Integer getDataWidth() {
	return dataWidth;
    }

    /**
     * @param dataWidth
     *            the dataWidth to set
     */
    public void setDataWidth(Integer dataWidth) {
	this.dataWidth = dataWidth;
    }

    /**
     * @return the product
     */
    public String getProduct() {
	return product;
    }

    /**
     * @param product
     *            the product to set
     */
    public void setProduct(String product) {
	this.product = product;
    }

    /**
     * @return the colors
     */
    public Integer getColors() {
	return colors;
    }

    /**
     * @param colors
     *            the colors to set
     */
    public void setColors(Integer colors) {
	this.colors = colors;
    }

    /**
     * @return the refreshRate
     */
    public Integer getRefreshRate() {
	return refreshRate;
    }

    /**
     * @param refreshRate
     *            the refreshRate to set
     */
    public void setRefreshRate(Integer refreshRate) {
	this.refreshRate = refreshRate;
    }

    /**
     * @return the horizontalRes
     */
    public Integer getHorizontalRes() {
	return horizontalRes;
    }

    /**
     * @param horizontalRes
     *            the horizontalRes to set
     */
    public void setHorizontalRes(Integer horizontalRes) {
	this.horizontalRes = horizontalRes;
    }

    /**
     * @return the verticalRes
     */
    public Integer getVerticalRes() {
	return verticalRes;
    }

    /**
     * @param verticalRes
     *            the verticalRes to set
     */
    public void setVerticalRes(Integer verticalRes) {
	this.verticalRes = verticalRes;
    }

    /**
     * @return the videoMemory
     */
    public Integer getVideoMemory() {
	return videoMemory;
    }

    /**
     * @param videoMemory
     *            the videoMemory to set
     */
    public void setVideoMemory(Integer videoMemory) {
	this.videoMemory = videoMemory;
    }

    /**
     * @return the protocolCode
     */
    public String getProtocolCode() {
	return protocolCode;
    }

    /**
     * @param protocolCode
     *            the protocolCode to set
     */
    public void setProtocolCode(String protocolCode) {
	this.protocolCode = protocolCode;
    }

    /**
     * @return the numberOfPorts
     */
    public Integer getNumberOfPorts() {
	return numberOfPorts;
    }

    /**
     * @param numberOfPorts
     *            the numberOfPorts to set
     */
    public void setNumberOfPorts(Integer numberOfPorts) {
	this.numberOfPorts = numberOfPorts;
    }

    /**
     * @return the usbRemainingVersion
     */
    public String getUsbVersion() {
	return usbVersion;
    }

    /**
     * @param usbVersion
     *            the usbVersion to set
     */
    public void setUsbVersion(String usbVersion) {
	this.usbVersion = usbVersion;
    }

    /**
     * @return the separator
     */
    public static char getSeparator() {
	return separator;
    }

    /**
     * @return the signature
     */
    public String getSignature() {
	return signature;
    }

    /**
     * @param signature
     *            the signature to set
     */
    public void setSignature(String signature) {
	this.signature = signature;
    }
}