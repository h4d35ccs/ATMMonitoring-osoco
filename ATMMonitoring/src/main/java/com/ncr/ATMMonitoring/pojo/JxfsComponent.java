package com.ncr.ATMMonitoring.pojo;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.standard.jxfs.alm.CapabilitiesJxfsALMCollector;
import com.ncr.agent.baseData.standard.jxfs.cam.CapabilitiesJxfsCAMCollector;
import com.ncr.agent.baseData.standard.jxfs.cdr.CapabilitiesJxfsCDRCollector;
import com.ncr.agent.baseData.standard.jxfs.cdr.PositionsJxfsCDRCollector;
import com.ncr.agent.baseData.standard.jxfs.chk.CapabilitiesJxfsCHKCollector;
import com.ncr.agent.baseData.standard.jxfs.dep.CapabilitiesJxfsDEPCollector;
import com.ncr.agent.baseData.standard.jxfs.msd.CapabilitiesJxfsMSDCollector;
import com.ncr.agent.baseData.standard.jxfs.pin.CapabilitiesJxfsPINCollector;
import com.ncr.agent.baseData.standard.jxfs.pin.PINSecureKeyDetailCollector;
import com.ncr.agent.baseData.standard.jxfs.ptr.CapabilitiesJxfsPTRCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.BarcodeCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.CapabilitiesJxfsSCNCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.ChequeCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.ImageCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.ScnCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.siu.CapabilitiesJxfsSIUCollector;
import com.ncr.agent.baseData.standard.jxfs.tio.CapabilitiesJxfsTIOCollector;
import com.ncr.agent.baseData.standard.jxfs.vdm.CapabilitiesJxfsVDMCollector;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "jxfs_components")
public class JxfsComponent {

    private static final Map<String, Map> comboboxes;
    private static final Set<String> jxfsClasses;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> numOperations = Operation
		.getOperationsByType(Operation.DataType.NUMBER);
	comboboxes.put("jxfsClass", stringOperations);
	comboboxes.put("acceptLimit", stringOperations);
	comboboxes.put("autopresent", stringOperations);
	comboboxes.put("auxiliaries", stringOperations);
	comboboxes.put("availableResolution", stringOperations);
	comboboxes.put("baitTrap", stringOperations);
	comboboxes.put("barcodeCapabilities", stringOperations);
	comboboxes.put("beepOnPressSupported", stringOperations);
	comboboxes.put("beepSupported", stringOperations);
	comboboxes.put("billsTakenSensor", stringOperations);
	comboboxes.put("cashbox", stringOperations);
	comboboxes.put("category2", stringOperations);
	comboboxes.put("category3", stringOperations);
	comboboxes.put("cdType", stringOperations);
	comboboxes.put("checkVandalism", stringOperations);
	comboboxes.put("chequeCapabilities", stringOperations);
	comboboxes.put("coins", stringOperations);
	comboboxes.put("complex", stringOperations);
	comboboxes.put("compound", stringOperations);
	comboboxes.put("createSignatureCommandSupported", stringOperations);
	comboboxes.put("ctrlTurn", stringOperations);
	comboboxes.put("cursorSupported", stringOperations);
	comboboxes.put("cylinders", stringOperations);
	comboboxes.put("defaultInputPosition", stringOperations);
	comboboxes.put("defaultOutputPosition", stringOperations);
	comboboxes.put("defaultRollbackPosition", numOperations);
	comboboxes.put("deposit", stringOperations);
	comboboxes.put("detector", stringOperations);
	comboboxes.put("deviceControlName", stringOperations);
	comboboxes.put("deviceId", stringOperations);
	comboboxes.put("deviceOrientation", stringOperations);
	comboboxes.put("deviceScanningBothLongSide", stringOperations);
	comboboxes.put("deviceScanningBothShortSide", stringOperations);
	comboboxes.put("deviceServiceName", stringOperations);
	comboboxes.put("deviceType", stringOperations);
	comboboxes.put("dispense", stringOperations);
	comboboxes.put("displayLightSupported", stringOperations);
	comboboxes.put("keyboardLockSupported", stringOperations);
	comboboxes.put("keyboardSupported", stringOperations);
	comboboxes.put("keysSupported", stringOperations);
	comboboxes.put("doors", stringOperations);
	comboboxes.put("ejectStatus", stringOperations);
	comboboxes.put("entry", stringOperations);
	comboboxes.put("envSupply", stringOperations);
	comboboxes.put("escrow", stringOperations);
	comboboxes.put("escrowSize", numOperations);
	comboboxes.put("eventOnStartSupported", stringOperations);
	comboboxes.put("extent", stringOperations);
	comboboxes.put("guidlights", stringOperations);
	comboboxes.put("idKey", stringOperations);
	comboboxes.put("imageCapture", stringOperations);
	comboboxes.put("imageCapabilities", stringOperations);
	comboboxes.put("indicators", stringOperations);
	comboboxes.put("inputCookSupported", stringOperations);
	comboboxes.put("inputPositions", stringOperations);
	comboboxes.put("inputRawSupported", stringOperations);
	comboboxes.put("intermediateStacker", stringOperations);
	comboboxes.put("insertTextSupported", stringOperations);
	comboboxes.put("maxDataLength", numOperations);
	comboboxes.put("maxInBills", numOperations);
	comboboxes.put("maxInCoins", numOperations);
	comboboxes.put("maxLed", numOperations);
	comboboxes.put("maxNumOfChars", numOperations);
	comboboxes.put("maxOutBills", numOperations);
	comboboxes.put("maxOutCoins", numOperations);
	comboboxes.put("maxPictures", numOperations);
	comboboxes.put("maxRetract", numOperations);
	comboboxes.put("maxStacker", numOperations);
	comboboxes.put("multipleCurrenciesCashInSupported", stringOperations);
	comboboxes.put("numberOfKeys", numOperations);
	comboboxes.put("orientationToBeScanned", stringOperations);
	comboboxes.put("outputPositions", stringOperations);
	comboboxes.put("print", stringOperations);
	comboboxes.put("positions", stringOperations);
	comboboxes.put("powerOff", stringOperations);
	comboboxes.put("powerOn", stringOperations);
	comboboxes.put("ptrCapabilities", stringOperations);
	comboboxes.put("ptrControlMedia", stringOperations);
	comboboxes.put("readForm", stringOperations);
	comboboxes.put("readFonts", stringOperations);
	comboboxes.put("readImage", stringOperations);
	comboboxes.put("readKeyboardDataWithDefault", stringOperations);
	comboboxes.put("readMicr", stringOperations);
	comboboxes.put("readOcr", stringOperations);
	comboboxes.put("readStatus", stringOperations);
	comboboxes.put("refill", stringOperations);
	comboboxes.put("remoteKeyLoad", stringOperations);
	comboboxes.put("retain", stringOperations);
	comboboxes.put("retract", stringOperations);
	comboboxes.put("safeDoorCmd", stringOperations);
	comboboxes.put("safeDoorSequence", stringOperations);
	comboboxes.put("scnCapabilities", stringOperations);
	comboboxes.put("secureKeyDetail", stringOperations);
	comboboxes.put("secureKeyEntryState", stringOperations);
	comboboxes.put("secureKeyEntrySupported", stringOperations);
	comboboxes.put("secureModuleType", stringOperations);
	comboboxes.put("sensors", stringOperations);
	comboboxes.put("status", stringOperations);
	comboboxes.put("supportedChipPresentationModes", stringOperations);
	comboboxes.put("supportedChipProtocols", stringOperations);
	comboboxes.put("supportedCryptoModes", stringOperations);
	comboboxes.put("supportedFdKeys", stringOperations);
	comboboxes.put("supportedPinFormats", stringOperations);
	comboboxes.put("supportedReadTracks", stringOperations);
	comboboxes.put("supportedTextAttributes", stringOperations);
	comboboxes.put("supportedValidationAlgorithms", stringOperations);
	comboboxes.put("supportedWriteHicoTracks", stringOperations);
	comboboxes.put("supportedWriteTracks", stringOperations);
	comboboxes.put("shutterCmd", stringOperations);
	comboboxes.put("silentAlarm", stringOperations);
	comboboxes.put("testCashUnit", stringOperations);
	comboboxes.put("transport", stringOperations);
	comboboxes.put("trustedUser", stringOperations);
	comboboxes.put("unfit", stringOperations);
	comboboxes.put("vendorData", stringOperations);
	comboboxes.put("writeForm", stringOperations);
	comboboxes.put("writeMode", stringOperations);

	jxfsClasses = new HashSet<String>();
	jxfsClasses.add("ALM");
	jxfsClasses.add("CAM");
	jxfsClasses.add("CDR");
	jxfsClasses.add("CHK");
	jxfsClasses.add("DEP");
	jxfsClasses.add("MSD");
	jxfsClasses.add("PIN");
	jxfsClasses.add("PTR");
	jxfsClasses.add("SCN");
	jxfsClasses.add("SIU");
	jxfsClasses.add("TIO");
	jxfsClasses.add("VDM");
    }

    public String getBarcodeCapabilities() {
		return barcodeCapabilities;
	}

	public void setBarcodeCapabilities(String barcodeCapabilities) {
		this.barcodeCapabilities = barcodeCapabilities;
	}

	public String getChequeCapabilities() {
		return chequeCapabilities;
	}

	public void setChequeCapabilities(String chequeCapabilities) {
		this.chequeCapabilities = chequeCapabilities;
	}

	public String getImageCapabilities() {
		return imageCapabilities;
	}

	public void setImageCapabilities(String imageCapabilities) {
		this.imageCapabilities = imageCapabilities;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public String getScnCapabilities() {
		return scnCapabilities;
	}

	public void setScnCapabilities(String scnCapabilities) {
		this.scnCapabilities = scnCapabilities;
	}

	public String getSecureKeyDetail() {
		return secureKeyDetail;
	}

	public void setSecureKeyDetail(String secureKeyDetail) {
		this.secureKeyDetail = secureKeyDetail;
	}

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jxfs_components_id_seq")
    @SequenceGenerator(name = "jxfs_components_id_seq", sequenceName = "jxfs_components_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.REFRESH)
    @JoinTable(name = "financial_device_jxfs_component", joinColumns = { @JoinColumn(name = "jxfs_component_id") }, inverseJoinColumns = { @JoinColumn(name = "financial_device_id") })
    private Set<FinancialDevice> financialDevices = new HashSet<FinancialDevice>();

    @Column(name = "jxfs_class", length = 50, nullable = false)
    private String jxfsClass;

    @Column(name = "accept_limit")
    @Type(type = "text")
    private String acceptLimit;

    @Column(name = "autopresent")
    @Type(type = "text")
    private String autopresent;

    @Column(name = "auxiliaries")
    @Type(type = "text")
    private String auxiliaries;

    @Column(name = "available_resolution")
    @Type(type = "text")
    private String availableResolution;

    @Column(name = "bait_trap")
    @Type(type = "text")
    private String baitTrap;

    @Column(name = "barcode_capabilites")
    @Type(type = "text")
    private String barcodeCapabilities;

    @Column(name = "beep_on_press_supp")
    @Type(type = "text")
    private String beepOnPressSupported;

    @Column(name = "beep_supp")
    @Type(type = "text")
    private String beepSupported;

    @Column(name = "bills_taken_sensor")
    @Type(type = "text")
    private String billsTakenSensor;

    @Column(name = "cashbox")
    @Type(type = "text")
    private String cashbox;

    @Column(name = "category2")
    @Type(type = "text")
    private String category2;

    @Column(name = "category3")
    @Type(type = "text")
    private String category3;

    @Column(name = "cd_type")
    @Type(type = "text")
    private String cdType;

    @Column(name = "check_vandalism")
    @Type(type = "text")
    private String checkVandalism;

    @Column(name = "cheque_capabilities")
    @Type(type = "text")
    private String chequeCapabilities;

    @Column(name = "coins")
    @Type(type = "text")
    private String coins;

    @Column(name = "complex")
    @Type(type = "text")
    private String complex;

    @Column(name = "compound")
    @Type(type = "text")
    private String compound;

    @Column(name = "create_sign_cmd_supported")
    @Type(type = "text")
    private String createSignatureCommandSupported;

    @Column(name = "ctrl_turn")
    @Type(type = "text")
    private String ctrlTurn;

    @Column(name = "cursor_supp")
    @Type(type = "text")
    private String cursorSupported;

    @Column(name = "cylinders")
    @Type(type = "text")
    private String cylinders;

    @Column(name = "default_input_position")
    @Type(type = "text")
    private String defaultInputPosition;

    @Column(name = "default_output_position")
    @Type(type = "text")
    private String defaultOutputPosition;

    @Column(name = "default_rollback_position")
    private Integer defaultRollbackPosition;

    @Column(name = "deposit")
    @Type(type = "text")
    private String deposit;

    @Column(name = "detector")
    @Type(type = "text")
    private String detector;

    @Column(name = "device_control_name")
    @Type(type = "text")
    private String deviceControlName;

    @Column(name = "device_id")
    @Type(type = "text")
    private String deviceId;

    @Column(name = "device_orientation")
    @Type(type = "text")
    private String deviceOrientation;

    @Column(name = "device_scan_both_long_side")
    @Type(type = "text")
    private String deviceScanningBothLongSide;

    @Column(name = "device_scan_both_short_side")
    @Type(type = "text")
    private String deviceScanningBothShortSide;

    @Column(name = "device_service_name")
    @Type(type = "text")
    private String deviceServiceName;

    @Column(name = "device_type")
    @Type(type = "text")
    private String deviceType;

    @Column(name = "dispense")
    @Type(type = "text")
    private String dispense;

    @Column(name = "display_light_supp")
    @Type(type = "text")
    private String displayLightSupported;

    @Column(name = "keyboard_lock_supp")
    @Type(type = "text")
    private String keyboardLockSupported;

    @Column(name = "keyboard_supp")
    @Type(type = "text")
    private String keyboardSupported;

    @Column(name = "keys_supp")
    @Type(type = "text")
    private String keysSupported;

    @Column(name = "doors")
    @Type(type = "text")
    private String doors;

    @Column(name = "eject_status")
    @Type(type = "text")
    private String ejectStatus;

    @Column(name = "entry")
    @Type(type = "text")
    private String entry;

    @Column(name = "env_supply")
    @Type(type = "text")
    private String envSupply;

    @Column(name = "escrow")
    @Type(type = "text")
    private String escrow;

    @Column(name = "escrow_size")
    private Integer escrowSize;

    @Column(name = "event_on_start_supp")
    @Type(type = "text")
    private String eventOnStartSupported;

    @Column(name = "extent")
    @Type(type = "text")
    private String extent;

    @Column(name = "guidlights")
    @Type(type = "text")
    private String guidlights;

    @Column(name = "id_key")
    @Type(type = "text")
    private String idKey;

    @Column(name = "image_capabilities")
    @Type(type = "text")
    private String imageCapabilities;

    @Column(name = "image_capture")
    @Type(type = "text")
    private String imageCapture;

    @Column(name = "indicators")
    @Type(type = "text")
    private String indicators;

    @Column(name = "input_cook_supp")
    @Type(type = "text")
    private String inputCookSupported;

    @Column(name = "input_positions")
    @Type(type = "text")
    private String inputPositions;

    @Column(name = "input_raw_supp")
    @Type(type = "text")
    private String inputRawSupported;

    @Column(name = "intermediate_stacker")
    @Type(type = "text")
    private String intermediateStacker;

    @Column(name = "insert_text_supported")
    @Type(type = "text")
    private String insertTextSupported;

    @Column(name = "max_data_length")
    private Integer maxDataLength;

    @Column(name = "max_in_bills")
    private Integer maxInBills;

    @Column(name = "max_in_coins")
    private Integer maxInCoins;

    @Column(name = "max_led")
    private Integer maxLed;

    @Column(name = "max_num_of_chars")
    private Integer maxNumOfChars;

    @Column(name = "max_out_bills")
    private Integer maxOutBills;

    @Column(name = "max_out_coins")
    private Integer maxOutCoins;

    @Column(name = "max_pictures")
    private Integer maxPictures;

    @Column(name = "max_retract")
    private Integer maxRetract;

    @Column(name = "max_stacker")
    private Integer maxStacker;

    @Column(name = "mult_curr_cash_in_supported")
    @Type(type = "text")
    private String multipleCurrenciesCashInSupported;

    @Column(name = "number_of_keys")
    private Integer numberOfKeys;

    @Column(name = "orientation_to_be_scanned")
    @Type(type = "text")
    private String orientationToBeScanned;

    @Column(name = "output_positions")
    @Type(type = "text")
    private String outputPositions;

    @Column(name = "print")
    @Type(type = "text")
    private String print;

    @Column(name = "positions")
    @Type(type = "text")
    private String positions;

    @Column(name = "power_off")
    @Type(type = "text")
    private String powerOff;

    @Column(name = "power_on")
    @Type(type = "text")
    private String powerOn;

    @Column(name = "ptr_capabilities")
    @Type(type = "text")
    private String ptrCapabilities;

    @Column(name = "ptr_control_media")
    @Type(type = "text")
    private String ptrControlMedia;

    @Column(name = "read_form")
    @Type(type = "text")
    private String readForm;

    @Column(name = "read_fonts")
    @Type(type = "text")
    private String readFonts;

    @Column(name = "read_image")
    @Type(type = "text")
    private String readImage;

    @Column(name = "read_keyboard_data_w_default")
    @Type(type = "text")
    private String readKeyboardDataWithDefault;

    @Column(name = "read_micr")
    @Type(type = "text")
    private String readMicr;

    @Column(name = "read_ocr")
    @Type(type = "text")
    private String readOcr;

    @Column(name = "read_status")
    @Type(type = "text")
    private String readStatus;

    @Column(name = "refill")
    @Type(type = "text")
    private String refill;

    @Column(name = "remote_key_load")
    @Type(type = "text")
    private String remoteKeyLoad;

    @Column(name = "retain")
    @Type(type = "text")
    private String retain;

    @Column(name = "retract")
    @Type(type = "text")
    private String retract;

    @Column(name = "safe_door_cmd")
    @Type(type = "text")
    private String safeDoorCmd;

    @Column(name = "sade_door_seq")
    @Type(type = "text")
    private String safeDoorSequence;

    @Column(name = "scn_capabilities")
    @Type(type = "text")
    private String scnCapabilities;

    @Column(name = "secure_key_detail")
    @Type(type = "text")
    private String secureKeyDetail;

    @Column(name = "secure_key_entry_state")
    @Type(type = "text")
    private String secureKeyEntryState;

    @Column(name = "secure_key_entry_supp")
    @Type(type = "text")
    private String secureKeyEntrySupported;

    @Column(name = "secure_module_type")
    @Type(type = "text")
    private String secureModuleType;

    @Column(name = "sensors")
    @Type(type = "text")
    private String sensors;

    @Column(name = "status")
    @Type(type = "text")
    private String status;

    @Column(name = "supp_chip_presentation_modes")
    @Type(type = "text")
    private String supportedChipPresentationModes;

    @Column(name = "supp_chip_protocols")
    @Type(type = "text")
    private String supportedChipProtocols;

    @Column(name = "supp_crypto_modes")
    @Type(type = "text")
    private String supportedCryptoModes;

    @Column(name = "supp_fd_keys")
    @Type(type = "text")
    private String supportedFdKeys;

    @Column(name = "supp_pin_formats")
    @Type(type = "text")
    private String supportedPinFormats;

    @Column(name = "supp_read_tracks")
    @Type(type = "text")
    private String supportedReadTracks;

    @Column(name = "supp_text_attributes")
    @Type(type = "text")
    private String supportedTextAttributes;

    @Column(name = "supp_validation_algorithms")
    @Type(type = "text")
    private String supportedValidationAlgorithms;

    @Column(name = "supp_write_hico_tracks")
    @Type(type = "text")
    private String supportedWriteHicoTracks;

    @Column(name = "supp_write_tracks")
    @Type(type = "text")
    private String supportedWriteTracks;

    @Column(name = "shutter_cmd")
    @Type(type = "text")
    private String shutterCmd;

    @Column(name = "silent_alarm")
    @Type(type = "text")
    private String silentAlarm;

    @Column(name = "test_cash_unit")
    @Type(type = "text")
    private String testCashUnit;

    @Column(name = "transport")
    @Type(type = "text")
    private String transport;

    @Column(name = "trusted_user")
    @Type(type = "text")
    private String trustedUser;

    @Column(name = "unfit")
    @Type(type = "text")
    private String unfit;

    @Column(name = "vendor_data")
    @Type(type = "text")
    private String vendorData;

    // @Column(name = "vendor_info")
    // @Type(type = "text")
    // private String vendorInfo;

    @Column(name = "write_form")
    @Type(type = "text")
    private String writeForm;

    @Column(name = "write_mode")
    @Type(type = "text")
    private String writeMode;

    public JxfsComponent() {
    }

    public JxfsComponent(CapabilitiesJxfsALMCollector jxfs) {
	jxfsClass = "ALM";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsCAMCollector jxfs) {
	jxfsClass = "CAM";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	insertTextSupported = jxfs.getInserttextsupported();
	maxDataLength = jxfs.getMaxdatalength();
	maxPictures = jxfs.getMaxpictures();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsCDRCollector jxfs) {
	jxfsClass = "CDR";
	acceptLimit = jxfs.getAcceptlimit();
	autopresent = jxfs.getAutopresent();
	baitTrap = jxfs.getBaittrap();
	billsTakenSensor = jxfs.getBillstakensensor();
	cashbox = jxfs.getCashbox();
	category2 = jxfs.getCategory2();
	category3 = jxfs.getCategory3();
	cdType = jxfs.getCdtype();
	checkVandalism = jxfs.getCheckvandalism();
	coins = jxfs.getCoins();
	compound = jxfs.getCompound();
	createSignatureCommandSupported = jxfs
		.getCreatesignaturecommandsupported();
	cylinders = jxfs.getCylinders();
	defaultInputPosition = jxfs.getDefaultinputposition();
	defaultOutputPosition = jxfs.getDefaultoutputposition();
	defaultRollbackPosition = jxfs.getDefaultrollbackposition();
	deposit = jxfs.getDeposit();
	detector = jxfs.getDetector();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceOrientation = jxfs.getDeviceorientation();
	deviceScanningBothLongSide = jxfs.getDevicescanningbothlongside();
	deviceScanningBothShortSide = jxfs.getDevicescanningbothshortside();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	dispense = jxfs.getDispense();
	escrow = jxfs.getEscrow();
	escrowSize = jxfs.getEscrowsize();
	inputPositions = jxfs.getInputpositions();
	intermediateStacker = jxfs.getIntermediatestacker();
	maxInBills = jxfs.getMaxinbills();
	maxInCoins = jxfs.getMaxincoins();
	maxOutBills = jxfs.getMaxoutbills();
	maxOutCoins = jxfs.getMaxoutcoins();
	multipleCurrenciesCashInSupported = jxfs
		.getMultiplecurrenciescashinsupported();
	orientationToBeScanned = jxfs.getOrientationtobescanned();
	outputPositions = jxfs.getOutputpositions();
	positions = (jxfs.getPositions() != null) ? Utils.toJson(jxfs
		.getPositions().toArray(new PositionsJxfsCDRCollector[0]))
		: null;
	refill = jxfs.getRefill();
	retract = jxfs.getRetract();
	safeDoorCmd = jxfs.getSafedoorcmd();
	safeDoorSequence = jxfs.getSafedoorsequence();
	shutterCmd = jxfs.getShuttercmd();
	silentAlarm = jxfs.getSilentalarm();
	testCashUnit = jxfs.getTestcashunit();
	trustedUser = jxfs.getTrusteduser();
	unfit = jxfs.getUnfit();
	vendorData = jxfs.getVendordata();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsCHKCollector jxfs) {
	jxfsClass = "CHK";
	complex = jxfs.getComplex();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	imageCapture = jxfs.getImagecapture();
	readFonts = jxfs.getReadfonts();
	readMicr = jxfs.getReadmicr();
	readOcr = jxfs.getReadocr();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsDEPCollector jxfs) {
	jxfsClass = "DEP";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	entry = jxfs.getEntry();
	envSupply = jxfs.getEnvsupply();
	maxNumOfChars = jxfs.getMaxnumofchars();
	print = jxfs.getPrint();
	readImage = jxfs.getReadimage();
	retract = jxfs.getRetract();
	transport = jxfs.getTransport();
    }

    public JxfsComponent(CapabilitiesJxfsMSDCollector jxfs) {
	jxfsClass = "MSD";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	powerOff = jxfs.getPoweroff();
	powerOn = jxfs.getPoweron();
	retain = jxfs.getRetain();
	secureModuleType = jxfs.getSecuremoduletype();
	supportedChipProtocols = jxfs.getSupportedchipprotocols();
	supportedReadTracks = jxfs.getSupportedreadtracks();
	supportedWriteHicoTracks = jxfs.getSupportedwritehicotracks();
	supportedWriteTracks = jxfs.getSupportedwritetracks();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
	writeMode = jxfs.getWritemode();
    }

    public JxfsComponent(CapabilitiesJxfsPINCollector jxfs) {
	jxfsClass = "PIN";
	beepOnPressSupported = jxfs.getBeeponpresssupported();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	eventOnStartSupported = jxfs.getEventonstartsupported();
	idKey = jxfs.getIdkey();
	inputCookSupported = jxfs.getInputcookedsupported();
	inputRawSupported = jxfs.getInputrawsupported();
	numberOfKeys = jxfs.getNumberofkeys();
	remoteKeyLoad = jxfs.getRemotekeyload();
	secureKeyDetail = (jxfs.getSecurekeydetail() != null) ? Utils
		.toJson(jxfs.getSecurekeydetail().toArray(
			new PINSecureKeyDetailCollector[0])) : null;
	secureKeyEntryState = jxfs.getSecurekeyentrystate();
	secureKeyEntrySupported = jxfs.getSecurekeyentrysupported();
	supportedChipPresentationModes = jxfs
		.getSupportedchippresentationmodes();
	supportedCryptoModes = jxfs.getSupportedcryptomodes();
	supportedFdKeys = jxfs.getSupportedfdkeys();
	supportedPinFormats = jxfs.getSupportedpinformats();
	supportedValidationAlgorithms = jxfs.getSupportedvalidationalgorithms();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsPTRCollector jxfs) {
	jxfsClass = "PTR";
	ctrlTurn = jxfs.getCtrlturn();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	ejectStatus = jxfs.getEjectstatus();
	extent = jxfs.getExtent();
	maxRetract = jxfs.getMaxretract();
	maxStacker = jxfs.getMaxstacker();
	ptrCapabilities = jxfs.getPtrcapabilities();
	ptrControlMedia = jxfs.getPtrcontrolmedia();
	readForm = jxfs.getReadform();
	readImage = jxfs.getReadimage();
	readStatus = jxfs.getReadstatus();
	status = jxfs.getStatus();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
	writeForm = jxfs.getWriteform();
    }

    public JxfsComponent(CapabilitiesJxfsSCNCollector jxfs) {
	jxfsClass = "SCN";
	barcodeCapabilities = (jxfs.getBarcodecapabilities() != null) ? Utils
		.toJson(jxfs.getBarcodecapabilities().toArray(
			new BarcodeCapabilitiesCollector[0])) : null;
	chequeCapabilities = (jxfs.getChequecapabilities() != null) ? Utils
		.toJson(jxfs.getChequecapabilities().toArray(
			new ChequeCapabilitiesCollector[0])) : null;
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	imageCapabilities = (jxfs.getImagecapabilities() != null) ? Utils
		.toJson(jxfs.getImagecapabilities().toArray(
			new ImageCapabilitiesCollector[0])) : null;
	scnCapabilities = (jxfs.getScncapabilities() != null) ? Utils
		.toJson(jxfs.getScncapabilities().toArray(
			new ScnCapabilitiesCollector[0])) : null;
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsSIUCollector jxfs) {
	jxfsClass = "SIU";
	auxiliaries = jxfs.getAuxiliaries();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	doors = jxfs.getDoors();
	guidlights = jxfs.getGuidlights();
	indicators = jxfs.getIndicators();
	sensors = jxfs.getSensors();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsTIOCollector jxfs) {
	jxfsClass = "TIO";
	availableResolution = jxfs.getAvailableresolution();
	beepSupported = jxfs.getBeepsupported();
	cursorSupported = jxfs.getCursorsupported();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	displayLightSupported = jxfs.getDisplaylightsupported();
	keyboardLockSupported = jxfs.getKeyboardlocksupported();
	keyboardSupported = jxfs.getKeyboardsupported();
	keysSupported = jxfs.getKeyssupported();
	maxLed = jxfs.getMaxled();
	readKeyboardDataWithDefault = jxfs.getReadkeyboarddatawithdefault();
	supportedTextAttributes = jxfs.getSupportedtextattributes();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsVDMCollector jxfs) {
	jxfsClass = "VDM";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    // /**
    // * @param vendor
    // * info the vendor info as a List<String> to set
    // */
    // public void setVendorInfoSplit(List<String> vendorInfo) {
    // this.vendorInfo = Utils.concatStrings(vendorInfo,
    // JxfsComponent.separator);
    // }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Set<FinancialDevice> getFinancialDevices() {
	return financialDevices;
    }

    public void setFinancialDevices(Set<FinancialDevice> financialDevices) {
	this.financialDevices = financialDevices;
    }

    public String getJxfsClass() {
	return jxfsClass;
    }

    public void setJxfsClass(String jxfsClass) {
	this.jxfsClass = jxfsClass;
    }

    public String getAcceptLimit() {
	return acceptLimit;
    }

    public void setAcceptLimit(String acceptLimit) {
	this.acceptLimit = acceptLimit;
    }

    public String getAutopresent() {
	return autopresent;
    }

    public void setAutopresent(String autopresent) {
	this.autopresent = autopresent;
    }

    public String getAuxiliaries() {
	return auxiliaries;
    }

    public void setAuxiliaries(String auxiliaries) {
	this.auxiliaries = auxiliaries;
    }

    public String getAvailableResolution() {
	return availableResolution;
    }

    public void setAvailableResolution(String availableResolution) {
	this.availableResolution = availableResolution;
    }

    public String getBaitTrap() {
	return baitTrap;
    }

    public void setBaitTrap(String baitTrap) {
	this.baitTrap = baitTrap;
    }

    public String getBeepOnPressSupported() {
	return beepOnPressSupported;
    }

    public void setBeepOnPressSupported(String beepOnPressSupported) {
	this.beepOnPressSupported = beepOnPressSupported;
    }

    public String getBeepSupported() {
	return beepSupported;
    }

    public void setBeepSupported(String beepSupported) {
	this.beepSupported = beepSupported;
    }

    public String getBillsTakenSensor() {
	return billsTakenSensor;
    }

    public void setBillsTakenSensor(String billsTakenSensor) {
	this.billsTakenSensor = billsTakenSensor;
    }

    public String getCashbox() {
	return cashbox;
    }

    public void setCashbox(String cashbox) {
	this.cashbox = cashbox;
    }

    public String getCategory2() {
	return category2;
    }

    public void setCategory2(String category2) {
	this.category2 = category2;
    }

    public String getCategory3() {
	return category3;
    }

    public void setCategory3(String category3) {
	this.category3 = category3;
    }

    public String getCdType() {
	return cdType;
    }

    public void setCdType(String cdType) {
	this.cdType = cdType;
    }

    public String getCheckVandalism() {
	return checkVandalism;
    }

    public void setCheckVandalism(String checkVandalism) {
	this.checkVandalism = checkVandalism;
    }

    public String getCoins() {
	return coins;
    }

    public void setCoins(String coins) {
	this.coins = coins;
    }

    public String getComplex() {
	return complex;
    }

    public void setComplex(String complex) {
	this.complex = complex;
    }

    public String getCompound() {
	return compound;
    }

    public void setCompound(String compound) {
	this.compound = compound;
    }

    public String getCreateSignatureCommandSupported() {
	return createSignatureCommandSupported;
    }

    public void setCreateSignatureCommandSupported(
	    String createSignatureCommandSupported) {
	this.createSignatureCommandSupported = createSignatureCommandSupported;
    }

    public String getCtrlTurn() {
	return ctrlTurn;
    }

    public void setCtrlTurn(String ctrlTurn) {
	this.ctrlTurn = ctrlTurn;
    }

    public String getCursorSupported() {
	return cursorSupported;
    }

    public void setCursorSupported(String cursorSupported) {
	this.cursorSupported = cursorSupported;
    }

    public String getCylinders() {
	return cylinders;
    }

    public void setCylinders(String cylinders) {
	this.cylinders = cylinders;
    }

    public String getDefaultInputPosition() {
	return defaultInputPosition;
    }

    public void setDefaultInputPosition(String defaultInputPosition) {
	this.defaultInputPosition = defaultInputPosition;
    }

    public String getDefaultOutputPosition() {
	return defaultOutputPosition;
    }

    public void setDefaultOutputPosition(String defaultOutputPosition) {
	this.defaultOutputPosition = defaultOutputPosition;
    }

    public Integer getDefaultRollbackPosition() {
	return defaultRollbackPosition;
    }

    public void setDefaultRollbackPosition(Integer defaultRollbackPosition) {
	this.defaultRollbackPosition = defaultRollbackPosition;
    }

    public String getDeposit() {
	return deposit;
    }

    public void setDeposit(String deposit) {
	this.deposit = deposit;
    }

    public String getDetector() {
	return detector;
    }

    public void setDetector(String detector) {
	this.detector = detector;
    }

    public String getDeviceControlName() {
	return deviceControlName;
    }

    public void setDeviceControlName(String deviceControlName) {
	this.deviceControlName = deviceControlName;
    }

    public String getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(String deviceId) {
	this.deviceId = deviceId;
    }

    public String getDeviceOrientation() {
	return deviceOrientation;
    }

    public void setDeviceOrientation(String deviceOrientation) {
	this.deviceOrientation = deviceOrientation;
    }

    public String getDeviceScanningBothLongSide() {
	return deviceScanningBothLongSide;
    }

    public void setDeviceScanningBothLongSide(String deviceScanningBothLongSide) {
	this.deviceScanningBothLongSide = deviceScanningBothLongSide;
    }

    public String getDeviceScanningBothShortSide() {
	return deviceScanningBothShortSide;
    }

    public void setDeviceScanningBothShortSide(
	    String deviceScanningBothShortSide) {
	this.deviceScanningBothShortSide = deviceScanningBothShortSide;
    }

    public String getDeviceServiceName() {
	return deviceServiceName;
    }

    public void setDeviceServiceName(String deviceServiceName) {
	this.deviceServiceName = deviceServiceName;
    }

    public String getDeviceType() {
	return deviceType;
    }

    public void setDeviceType(String deviceType) {
	this.deviceType = deviceType;
    }

    public String getDispense() {
	return dispense;
    }

    public void setDispense(String dispense) {
	this.dispense = dispense;
    }

    public String getDisplayLightSupported() {
	return displayLightSupported;
    }

    public void setDisplayLightSupported(String displayLightSupported) {
	this.displayLightSupported = displayLightSupported;
    }

    public String getKeyboardLockSupported() {
	return keyboardLockSupported;
    }

    public void setKeyboardLockSupported(String keyboardLockSupported) {
	this.keyboardLockSupported = keyboardLockSupported;
    }

    public String getKeyboardSupported() {
	return keyboardSupported;
    }

    public void setKeyboardSupported(String keyboardSupported) {
	this.keyboardSupported = keyboardSupported;
    }

    public String getKeysSupported() {
	return keysSupported;
    }

    public void setKeysSupported(String keysSupported) {
	this.keysSupported = keysSupported;
    }

    public String getDoors() {
	return doors;
    }

    public void setDoors(String doors) {
	this.doors = doors;
    }

    public String getEjectStatus() {
	return ejectStatus;
    }

    public void setEjectStatus(String ejectStatus) {
	this.ejectStatus = ejectStatus;
    }

    public String getEntry() {
	return entry;
    }

    public void setEntry(String entry) {
	this.entry = entry;
    }

    public String getEnvSupply() {
	return envSupply;
    }

    public void setEnvSupply(String envSupply) {
	this.envSupply = envSupply;
    }

    public String getEscrow() {
	return escrow;
    }

    public void setEscrow(String escrow) {
	this.escrow = escrow;
    }

    public Integer getEscrowSize() {
	return escrowSize;
    }

    public void setEscrowSize(Integer escrowSize) {
	this.escrowSize = escrowSize;
    }

    public String getEventOnStartSupported() {
	return eventOnStartSupported;
    }

    public void setEventOnStartSupported(String eventOnStartSupported) {
	this.eventOnStartSupported = eventOnStartSupported;
    }

    public String getExtent() {
	return extent;
    }

    public void setExtent(String extent) {
	this.extent = extent;
    }

    public String getGuidlights() {
	return guidlights;
    }

    public void setGuidlights(String guidlights) {
	this.guidlights = guidlights;
    }

    public String getIdKey() {
	return idKey;
    }

    public void setIdKey(String idKey) {
	this.idKey = idKey;
    }

    public String getImageCapture() {
	return imageCapture;
    }

    public void setImageCapture(String imageCapture) {
	this.imageCapture = imageCapture;
    }

    public String getIndicators() {
	return indicators;
    }

    public void setIndicators(String indicators) {
	this.indicators = indicators;
    }

    public String getInputCookSupported() {
	return inputCookSupported;
    }

    public void setInputCookSupported(String inputCookSupported) {
	this.inputCookSupported = inputCookSupported;
    }

    public String getInputPositions() {
	return inputPositions;
    }

    public void setInputPositions(String inputPositions) {
	this.inputPositions = inputPositions;
    }

    public String getInputRawSupported() {
	return inputRawSupported;
    }

    public void setInputRawSupported(String inputRawSupported) {
	this.inputRawSupported = inputRawSupported;
    }

    public String getIntermediateStacker() {
	return intermediateStacker;
    }

    public void setIntermediateStacker(String intermediateStacker) {
	this.intermediateStacker = intermediateStacker;
    }

    public String getInsertTextSupported() {
	return insertTextSupported;
    }

    public void setInsertTextSupported(String insertTextSupported) {
	this.insertTextSupported = insertTextSupported;
    }

    public Integer getMaxDataLength() {
	return maxDataLength;
    }

    public void setMaxDataLength(Integer maxDataLength) {
	this.maxDataLength = maxDataLength;
    }

    public Integer getMaxInBills() {
	return maxInBills;
    }

    public void setMaxInBills(Integer maxInBills) {
	this.maxInBills = maxInBills;
    }

    public Integer getMaxInCoins() {
	return maxInCoins;
    }

    public void setMaxInCoins(Integer maxInCoins) {
	this.maxInCoins = maxInCoins;
    }

    public Integer getMaxLed() {
	return maxLed;
    }

    public void setMaxLed(Integer maxLed) {
	this.maxLed = maxLed;
    }

    public Integer getMaxNumOfChars() {
	return maxNumOfChars;
    }

    public void setMaxNumOfChars(Integer maxNumOfChars) {
	this.maxNumOfChars = maxNumOfChars;
    }

    public Integer getMaxOutBills() {
	return maxOutBills;
    }

    public void setMaxOutBills(Integer maxOutBills) {
	this.maxOutBills = maxOutBills;
    }

    public Integer getMaxOutCoins() {
	return maxOutCoins;
    }

    public void setMaxOutCoins(Integer maxOutCoins) {
	this.maxOutCoins = maxOutCoins;
    }

    public Integer getMaxPictures() {
	return maxPictures;
    }

    public void setMaxPictures(Integer maxPictures) {
	this.maxPictures = maxPictures;
    }

    public Integer getMaxRetract() {
	return maxRetract;
    }

    public void setMaxRetract(Integer maxRetract) {
	this.maxRetract = maxRetract;
    }

    public Integer getMaxStacker() {
	return maxStacker;
    }

    public void setMaxStacker(Integer maxStacker) {
	this.maxStacker = maxStacker;
    }

    public String getMultipleCurrenciesCashInSupported() {
	return multipleCurrenciesCashInSupported;
    }

    public void setMultipleCurrenciesCashInSupported(
	    String multipleCurrenciesCashInSupported) {
	this.multipleCurrenciesCashInSupported = multipleCurrenciesCashInSupported;
    }

    public Integer getNumberOfKeys() {
	return numberOfKeys;
    }

    public void setNumberOfKeys(Integer numberOfKeys) {
	this.numberOfKeys = numberOfKeys;
    }

    public String getOrientationToBeScanned() {
	return orientationToBeScanned;
    }

    public void setOrientationToBeScanned(String orientationToBeScanned) {
	this.orientationToBeScanned = orientationToBeScanned;
    }

    public String getOutputPositions() {
	return outputPositions;
    }

    public void setOutputPositions(String outputPositions) {
	this.outputPositions = outputPositions;
    }

    public String getPrint() {
	return print;
    }

    public void setPrint(String print) {
	this.print = print;
    }

    public String getPowerOff() {
	return powerOff;
    }

    public void setPowerOff(String powerOff) {
	this.powerOff = powerOff;
    }

    public String getPowerOn() {
	return powerOn;
    }

    public void setPowerOn(String powerOn) {
	this.powerOn = powerOn;
    }

    public String getPtrCapabilities() {
	return ptrCapabilities;
    }

    public void setPtrCapabilities(String ptrCapabilities) {
	this.ptrCapabilities = ptrCapabilities;
    }

    public String getPtrControlMedia() {
	return ptrControlMedia;
    }

    public void setPtrControlMedia(String ptrControlMedia) {
	this.ptrControlMedia = ptrControlMedia;
    }

    public String getReadForm() {
	return readForm;
    }

    public void setReadForm(String readForm) {
	this.readForm = readForm;
    }

    public String getReadFonts() {
	return readFonts;
    }

    public void setReadFonts(String readFonts) {
	this.readFonts = readFonts;
    }

    public String getReadImage() {
	return readImage;
    }

    public void setReadImage(String readImage) {
	this.readImage = readImage;
    }

    public String getReadKeyboardDataWithDefault() {
	return readKeyboardDataWithDefault;
    }

    public void setReadKeyboardDataWithDefault(
	    String readKeyboardDataWithDefault) {
	this.readKeyboardDataWithDefault = readKeyboardDataWithDefault;
    }

    public String getReadMicr() {
	return readMicr;
    }

    public void setReadMicr(String readMicr) {
	this.readMicr = readMicr;
    }

    public String getReadOcr() {
	return readOcr;
    }

    public void setReadOcr(String readOcr) {
	this.readOcr = readOcr;
    }

    public String getReadStatus() {
	return readStatus;
    }

    public void setReadStatus(String readStatus) {
	this.readStatus = readStatus;
    }

    public String getRefill() {
	return refill;
    }

    public void setRefill(String refill) {
	this.refill = refill;
    }

    public String getRemoteKeyLoad() {
	return remoteKeyLoad;
    }

    public void setRemoteKeyLoad(String remoteKeyLoad) {
	this.remoteKeyLoad = remoteKeyLoad;
    }

    public String getRetain() {
	return retain;
    }

    public void setRetain(String retain) {
	this.retain = retain;
    }

    public String getRetract() {
	return retract;
    }

    public void setRetract(String retract) {
	this.retract = retract;
    }

    public String getSafeDoorCmd() {
	return safeDoorCmd;
    }

    public void setSafeDoorCmd(String safeDoorCmd) {
	this.safeDoorCmd = safeDoorCmd;
    }

    public String getSafeDoorSequence() {
	return safeDoorSequence;
    }

    public void setSafeDoorSequence(String safeDoorSequence) {
	this.safeDoorSequence = safeDoorSequence;
    }

    public String getSecureKeyEntryState() {
	return secureKeyEntryState;
    }

    public void setSecureKeyEntryState(String secureKeyEntryState) {
	this.secureKeyEntryState = secureKeyEntryState;
    }

    public String getSecureKeyEntrySupported() {
	return secureKeyEntrySupported;
    }

    public void setSecureKeyEntrySupported(String secureKeyEntrySupported) {
	this.secureKeyEntrySupported = secureKeyEntrySupported;
    }

    public String getSecureModuleType() {
	return secureModuleType;
    }

    public void setSecureModuleType(String secureModuleType) {
	this.secureModuleType = secureModuleType;
    }

    public String getSensors() {
	return sensors;
    }

    public void setSensors(String sensors) {
	this.sensors = sensors;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getSupportedChipPresentationModes() {
	return supportedChipPresentationModes;
    }

    public void setSupportedChipPresentationModes(
	    String supportedChipPresentationModes) {
	this.supportedChipPresentationModes = supportedChipPresentationModes;
    }

    public String getSupportedChipProtocols() {
	return supportedChipProtocols;
    }

    public void setSupportedChipProtocols(String supportedChipProtocols) {
	this.supportedChipProtocols = supportedChipProtocols;
    }

    public String getSupportedCryptoModes() {
	return supportedCryptoModes;
    }

    public void setSupportedCryptoModes(String supportedCryptoModes) {
	this.supportedCryptoModes = supportedCryptoModes;
    }

    public String getSupportedFdKeys() {
	return supportedFdKeys;
    }

    public void setSupportedFdKeys(String supportedFdKeys) {
	this.supportedFdKeys = supportedFdKeys;
    }

    public String getSupportedPinFormats() {
	return supportedPinFormats;
    }

    public void setSupportedPinFormats(String supportedPinFormats) {
	this.supportedPinFormats = supportedPinFormats;
    }

    public String getSupportedReadTracks() {
	return supportedReadTracks;
    }

    public void setSupportedReadTracks(String supportedReadTracks) {
	this.supportedReadTracks = supportedReadTracks;
    }

    public String getSupportedTextAttributes() {
	return supportedTextAttributes;
    }

    public void setSupportedTextAttributes(String supportedTextAttributes) {
	this.supportedTextAttributes = supportedTextAttributes;
    }

    public String getSupportedValidationAlgorithms() {
	return supportedValidationAlgorithms;
    }

    public void setSupportedValidationAlgorithms(
	    String supportedValidationAlgorithms) {
	this.supportedValidationAlgorithms = supportedValidationAlgorithms;
    }

    public String getSupportedWriteHicoTracks() {
	return supportedWriteHicoTracks;
    }

    public void setSupportedWriteHicoTracks(String supportedWriteHicoTracks) {
	this.supportedWriteHicoTracks = supportedWriteHicoTracks;
    }

    public String getSupportedWriteTracks() {
	return supportedWriteTracks;
    }

    public void setSupportedWriteTracks(String supportedWriteTracks) {
	this.supportedWriteTracks = supportedWriteTracks;
    }

    public String getShutterCmd() {
	return shutterCmd;
    }

    public void setShutterCmd(String shutterCmd) {
	this.shutterCmd = shutterCmd;
    }

    public String getSilentAlarm() {
	return silentAlarm;
    }

    public void setSilentAlarm(String silentAlarm) {
	this.silentAlarm = silentAlarm;
    }

    public String getTestCashUnit() {
	return testCashUnit;
    }

    public void setTestCashUnit(String testCashUnit) {
	this.testCashUnit = testCashUnit;
    }

    public String getTransport() {
	return transport;
    }

    public void setTransport(String transport) {
	this.transport = transport;
    }

    public String getTrustedUser() {
	return trustedUser;
    }

    public void setTrustedUser(String trustedUser) {
	this.trustedUser = trustedUser;
    }

    public String getUnfit() {
	return unfit;
    }

    public void setUnfit(String unfit) {
	this.unfit = unfit;
    }

    public String getVendorData() {
	return vendorData;
    }

    public void setVendorData(String vendorData) {
	this.vendorData = vendorData;
    }

    // public String getVendorInfo() {
    // return vendorInfo;
    // }
    //
    // public void setVendorInfo(String vendorInfo) {
    // this.vendorInfo = vendorInfo;
    // }

    public String getWriteForm() {
	return writeForm;
    }

    public void setWriteForm(String writeForm) {
	this.writeForm = writeForm;
    }

    public String getWriteMode() {
	return writeMode;
    }

    public void setWriteMode(String writeMode) {
	this.writeMode = writeMode;
    }

    public static Set<String> getJxfsclasses() {
	return jxfsClasses;
    }

    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

}
