package com.ncr.ATMMonitoring.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.standard.jxfs.alm.CapabilitiesJxfsALMCollector;
import com.ncr.agent.baseData.standard.jxfs.cam.CapabilitiesJxfsCAMCollector;
import com.ncr.agent.baseData.standard.jxfs.cdr.CapabilitiesJxfsCDRCollector;
import com.ncr.agent.baseData.standard.jxfs.chk.CapabilitiesJxfsCHKCollector;
import com.ncr.agent.baseData.standard.jxfs.dep.CapabilitiesJxfsDEPCollector;
import com.ncr.agent.baseData.standard.jxfs.msd.CapabilitiesJxfsMSDCollector;
import com.ncr.agent.baseData.standard.jxfs.pin.CapabilitiesJxfsPINCollector;
import com.ncr.agent.baseData.standard.jxfs.ptr.CapabilitiesJxfsPTRCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.CapabilitiesJxfsSCNCollector;
import com.ncr.agent.baseData.standard.jxfs.siu.CapabilitiesJxfsSIUCollector;
import com.ncr.agent.baseData.standard.jxfs.tio.CapabilitiesJxfsTIOCollector;
import com.ncr.agent.baseData.standard.jxfs.vdm.CapabilitiesJxfsVDMCollector;

@Entity
@Table(name = "jxfs_components")
public class JxfsComponent {

    private static final char separator = ';';

    private static final Set<String> jxfsClasses;

    static {
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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jxfs_components_id_seq")
    @SequenceGenerator(name = "jxfs_components_id_seq", sequenceName = "jxfs_components_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "financial_device_id")
    private FinancialDevice financialDevice;

    @Column(name = "jxfs_class", length = 50, nullable = false)
    private String jxfsClass;

    @Column(name = "accept_limit", length = 100)
    private String acceptLimit;

    @Column(name = "autopresent", length = 100)
    private String autopresent;

    @Column(name = "auxiliaries", length = 100)
    private String auxiliaries;

    @Column(name = "available_resolution", length = 100)
    private String availableResolution;

    @Column(name = "bait_trap", length = 100)
    private String baitTrap;

    @Column(name = "beep_on_press_supp", length = 100)
    private String beepOnPressSupported;

    @Column(name = "beep_supp", length = 100)
    private String beepSupported;

    @Column(name = "bills_taken_sensor", length = 100)
    private String billsTakenSensor;

    @Column(name = "cashbox", length = 100)
    private String cashbox;

    @Column(name = "category2", length = 100)
    private String category2;

    @Column(name = "category3", length = 100)
    private String category3;

    @Column(name = "cd_type", length = 100)
    private String cdType;

    @Column(name = "check_vandalism", length = 100)
    private String checkVandalism;

    @Column(name = "coins", length = 100)
    private String coins;

    @Column(name = "complex", length = 100)
    private String complex;

    @Column(name = "compound", length = 100)
    private String compound;

    @Column(name = "create_sign_cmd_supported", length = 100)
    private String createSignatureCommandSupported;

    @Column(name = "ctrl_turn", length = 100)
    private String ctrlTurn;

    @Column(name = "cursor_supp", length = 100)
    private String cursorSupported;

    @Column(name = "cylinders", length = 100)
    private String cylinders;

    @Column(name = "default_input_position", length = 100)
    private String defaultInputPosition;

    @Column(name = "default_output_position", length = 100)
    private String defaultOutputPosition;

    @Column(name = "default_rollback_position")
    private Integer defaultRollbackPosition;

    @Column(name = "deposit", length = 100)
    private String deposit;

    @Column(name = "detector", length = 100)
    private String detector;

    @Column(name = "device_control_name", length = 200)
    private String deviceControlName;

    @Column(name = "device_id", length = 100)
    private String deviceId;

    @Column(name = "device_orientation", length = 100)
    private String deviceOrientation;

    @Column(name = "device_scan_both_long_side", length = 100)
    private String deviceScanningBothLongSide;

    @Column(name = "device_scan_both_short_side", length = 100)
    private String deviceScanningBothShortSide;

    @Column(name = "device_service_name", length = 200)
    private String deviceServiceName;

    @Column(name = "device_type", length = 100)
    private String deviceType;

    @Column(name = "dispense", length = 100)
    private String dispense;

    @Column(name = "display_light_supp", length = 100)
    private String displayLightSupported;

    @Column(name = "keyboard_lock_supp", length = 100)
    private String keyboardLockSupported;

    @Column(name = "keyboard_supp", length = 100)
    private String keyboardSupported;

    @Column(name = "keys_supp", length = 100)
    private String keysSupported;

    @Column(name = "doors", length = 100)
    private String doors;

    @Column(name = "eject_status", length = 100)
    private String ejectStatus;

    @Column(name = "entry", length = 100)
    private String entry;

    @Column(name = "env_supply", length = 100)
    private String envSupply;

    @Column(name = "escrow", length = 100)
    private String escrow;

    @Column(name = "escrow_size")
    private Integer escrowSize;

    @Column(name = "event_on_start_supp", length = 100)
    private String eventOnStartSupported;

    @Column(name = "extent", length = 100)
    private String extent;

    @Column(name = "guidlights", length = 100)
    private String guidlights;

    @Column(name = "id_key", length = 100)
    private String idKey;

    @Column(name = "image_capture", length = 100)
    private String imageCapture;

    @Column(name = "indicators", length = 100)
    private String indicators;

    @Column(name = "input_cook_supp", length = 100)
    private String inputCookSupported;

    @Column(name = "input_positions", length = 100)
    private String inputPositions;

    @Column(name = "input_raw_supp", length = 100)
    private String inputRawSupported;

    @Column(name = "intermediate_stacker", length = 100)
    private String intermediateStacker;

    @Column(name = "insert_text_supported", length = 50)
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

    @Column(name = "mult_curr_cash_in_supported", length = 100)
    private String multipleCurrenciesCashInSupported;

    @Column(name = "number_of_keys")
    private Integer numberOfKeys;

    @Column(name = "orientation_to_be_scanned", length = 100)
    private String orientationToBeScanned;

    @Column(name = "output_positions", length = 100)
    private String outputPositions;

    @Column(name = "print", length = 100)
    private String print;

    @Column(name = "power_off", length = 100)
    private String powerOff;

    @Column(name = "power_on", length = 100)
    private String powerOn;

    @Column(name = "ptr_capabilities", length = 200)
    private String ptrCapabilities;

    @Column(name = "ptr_control_media", length = 200)
    private String ptrControlMedia;

    @Column(name = "read_form", length = 100)
    private String readForm;

    @Column(name = "read_fonts", length = 100)
    private String readFonts;

    @Column(name = "read_image", length = 100)
    private String readImage;

    @Column(name = "read_keyboard_data_w_default", length = 100)
    private String readKeyboardDataWithDefault;

    @Column(name = "read_micr", length = 100)
    private String readMicr;

    @Column(name = "read_ocr", length = 100)
    private String readOcr;

    @Column(name = "read_status", length = 100)
    private String readStatus;

    @Column(name = "refill", length = 100)
    private String refill;

    @Column(name = "remote_key_load", length = 100)
    private String remoteKeyLoad;

    @Column(name = "retain", length = 100)
    private String retain;

    @Column(name = "retract", length = 100)
    private String retract;

    @Column(name = "safe_door_cmd", length = 100)
    private String safeDoorCmd;

    @Column(name = "sade_door_seq", length = 100)
    private String safeDoorSequence;

    @Column(name = "secure_key_entry_state", length = 100)
    private String secureKeyEntryState;

    @Column(name = "secure_key_entry_supp", length = 100)
    private String secureKeyEntrySupported;

    @Column(name = "secure_module_type", length = 100)
    private String secureModuleType;

    @Column(name = "sensors", length = 100)
    private String sensors;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "supp_chip_presentation_modes", length = 100)
    private String supportedChipPresentationModes;

    @Column(name = "supp_chip_protocols", length = 100)
    private String supportedChipProtocols;

    @Column(name = "supp_crypto_modes", length = 100)
    private String supportedCryptoModes;

    @Column(name = "supp_fd_keys", length = 100)
    private String supportedFdKeys;

    @Column(name = "supp_pin_formats", length = 100)
    private String supportedPinFormats;

    @Column(name = "supp_read_tracks", length = 100)
    private String supportedReadTracks;

    @Column(name = "supp_text_attributes", length = 100)
    private String supportedTextAttributes;

    @Column(name = "supp_validation_algorithms", length = 100)
    private String supportedValidationAlgorithms;

    @Column(name = "supp_write_hico_tracks", length = 100)
    private String supportedWriteHicoTracks;

    @Column(name = "supp_write_tracks", length = 100)
    private String supportedWriteTracks;

    @Column(name = "shutter_cmd", length = 100)
    private String shutterCmd;

    @Column(name = "silent_alarm", length = 100)
    private String silentAlarm;

    @Column(name = "test_cash_unit", length = 100)
    private String testCashUnit;

    @Column(name = "transport", length = 100)
    private String transport;

    @Column(name = "trusted_user", length = 100)
    private String trustedUser;

    @Column(name = "unfit", length = 100)
    private String unfit;

    @Column(name = "vendor_data", length = 100)
    private String vendorData;

    @Column(name = "vendor_info", length = 100)
    private String vendorInfo;

    @Column(name = "write_form", length = 100)
    private String writeForm;

    @Column(name = "write_mode", length = 100)
    private String writeMode;

    public JxfsComponent(CapabilitiesJxfsALMCollector jxfs) {
	jxfsClass = "ALM";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
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
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
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
	jxfs.getPositions(); // TODO
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
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsCHKCollector jxfs) {
	complex = jxfs.getComplex();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	imageCapture = jxfs.getImagecapture();
	readFonts = jxfs.getReadfonts();
	readMicr = jxfs.getReadmicr();
	readOcr = jxfs.getReadocr();
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsDEPCollector jxfs) {
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
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
	writeMode = jxfs.getWritemode();
    }

    public JxfsComponent(CapabilitiesJxfsPINCollector jxfs) {
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
	jxfs.getSecurekeydetail(); // TODO
	secureKeyEntryState = jxfs.getSecurekeyentrystate();
	secureKeyEntrySupported = jxfs.getSecurekeyentrysupported();
	supportedChipPresentationModes = jxfs
		.getSupportedchippresentationmodes();
	supportedCryptoModes = jxfs.getSupportedcryptomodes();
	supportedFdKeys = jxfs.getSupportedfdkeys();
	supportedPinFormats = jxfs.getSupportedpinformats();
	supportedValidationAlgorithms = jxfs.getSupportedvalidationalgorithms();
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsPTRCollector jxfs) {
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
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
	writeForm = jxfs.getWriteform();
    }

    public JxfsComponent(CapabilitiesJxfsSCNCollector jxfs) {
	jxfs.getBarcodecapabilities(); // TODO
	jxfs.getChequecapabilities(); // TODO
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	jxfs.getImagecapabilities(); // TODO
	jxfs.getScncapabilities(); // TODO
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsSIUCollector jxfs) {
	auxiliaries = jxfs.getAuxiliaries();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	doors = jxfs.getDoors();
	guidlights = jxfs.getGuidlights();
	indicators = jxfs.getIndicators();
	sensors = jxfs.getSensors();
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsTIOCollector jxfs) {
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
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
    }

    public JxfsComponent(CapabilitiesJxfsVDMCollector jxfs) {
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
		.getVendorinfo())));
    }

    /**
     * @param vendor
     *            info the vendor info as a List<String> to set
     */
    public void setVendorInfoSplit(List<String> vendorInfo) {
	this.vendorInfo = Utils.concatStrings(vendorInfo,
		JxfsComponent.separator);
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public FinancialDevice getFinancialDevice() {
	return financialDevice;
    }

    public void setFinancialDevice(FinancialDevice financialDevice) {
	this.financialDevice = financialDevice;
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

    public String getVendorInfo() {
	return vendorInfo;
    }

    public void setVendorInfo(String vendorInfo) {
	this.vendorInfo = vendorInfo;
    }

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

}
