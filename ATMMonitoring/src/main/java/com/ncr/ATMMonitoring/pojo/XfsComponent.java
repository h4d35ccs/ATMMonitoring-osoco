package com.ncr.ATMMonitoring.pojo;

import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.standard.xfs.module.ALM;
import com.ncr.agent.baseData.standard.xfs.module.BCR;
import com.ncr.agent.baseData.standard.xfs.module.CAM;
import com.ncr.agent.baseData.standard.xfs.module.CDM;
import com.ncr.agent.baseData.standard.xfs.module.CEU;
import com.ncr.agent.baseData.standard.xfs.module.CHK;
import com.ncr.agent.baseData.standard.xfs.module.CIM;
import com.ncr.agent.baseData.standard.xfs.module.CRD;
import com.ncr.agent.baseData.standard.xfs.module.DEP;
import com.ncr.agent.baseData.standard.xfs.module.IDC;
import com.ncr.agent.baseData.standard.xfs.module.IPM;
import com.ncr.agent.baseData.standard.xfs.module.PIN;
import com.ncr.agent.baseData.standard.xfs.module.PTR;
import com.ncr.agent.baseData.standard.xfs.module.SIU;
import com.ncr.agent.baseData.standard.xfs.module.TTU;
import com.ncr.agent.baseData.standard.xfs.module.VDM;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "xfs_components")
public class XfsComponent {

    private static final Set<String> xfsClasses;

    static {
	xfsClasses = new HashSet<String>();
	xfsClasses.add("ALM");
	xfsClasses.add("BCR");
	xfsClasses.add("CAM");
	xfsClasses.add("CDM");
	xfsClasses.add("CEU");
	xfsClasses.add("CHK");
	xfsClasses.add("CIM");
	xfsClasses.add("CRD");
	xfsClasses.add("DEP");
	xfsClasses.add("IDC");
	xfsClasses.add("IPM");
	xfsClasses.add("PIN");
	xfsClasses.add("PTR");
	xfsClasses.add("SIU");
	xfsClasses.add("TTU");
	xfsClasses.add("VDM");
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xfs_components_id_seq")
    @SequenceGenerator(name = "xfs_components_id_seq", sequenceName = "xfs_components_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.REFRESH)
    @JoinTable(name = "financial_device_xfs_component", joinColumns = { @JoinColumn(name = "xfs_component_id") }, inverseJoinColumns = { @JoinColumn(name = "financial_device_id") })
    private List<FinancialDevice> financialDevices = new ArrayList<FinancialDevice>();

    @OneToMany(mappedBy = "xfsComponent", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("type")
    private List<LogicalCashUnit> logicalCashUnits = new ArrayList<LogicalCashUnit>();

    @Column(name = "xfs_class", length = 50, nullable = false)
    private String xfsClass;

    @Column(name = "accept_media")
    private Boolean acceptMedia;

    @Column(name = "algorithms", length = 500)
    private String algorithms;
    
    @Column(name = "autobeep", length = 200)
    private String autobeep;

    @Column(name = "autoretract_period")
    private Integer autoretractPeriod;

    @Column(name = "auxiliaries", length = 100)
    private String auxiliaries;

    @Column(name = "back_image_color_format", length = 500)
    private String backImageColorFormat;

    @Column(name = "backscan_color", length = 200)
    private String backscanColor;
    
    @Column(name = "cameras", length = 200)
    private String cameras;

    @Column(name = "cam_data", length = 200)
    private String camdata;

    @Column(name = "cards")
    private Integer cards;

    @Column(name = "char_support", length = 500)
    private String charSupport;
    
    @Column(name = "chip_io")
    private Boolean chipio;

    @Column(name = "chip_power", length = 500)
    private String chipPower;

    @Column(name = "chip_protocol", length = 500)
    private String chipProtocol;

    @Column(name = "code_line_format", length = 500)
    private String codeLineFormat;

    @Column(name = "compound")
    private Boolean compound;
    
    @Column(name = "compare_magnetic_stripe")
    private Boolean comparemagneticstripe;

    @Column(name = "control", length = 500)
    private String control;

    @Column(name = "cursor")
    private Boolean cursor;

    @Column(name = "default_backscan_color", length = 200)
    private String defaultBackscanColor;

    @Column(name = "default_frontscan_color", length = 200)
    private String defaultFrontscanColor;
    
    @Column(name = "dep_transport")
    private Boolean deptransport;

    @Column(name = "derivation_algorithms", length = 500)
    private String derivationAlgorithms;

    @Column(name = "is_prepare_dispense")
    private Boolean isPrepareDispense;

    @Column(name = "dip_mode", length = 200)
    private String dipMode;

    @Column(name = "dispense_to", length = 200)
    private String dispenseTo;

    @Column(name = "display", length = 500)
    private String display;

    @Column(name = "display_light")
    private Boolean displayLight;
    
    @Column(name = "doors", length = 100)
    private String doors;

    @Column(name = "eject_position", length = 200)
    private String ejectPosition;

    @Column(name = "emv_hash_algorithm", length = 200)
    private String emvHashAlgorithm;

    @Column(name = "emv_import_schemes", length = 200)
    private String emvImportSchemes;

    @Column(name = "encio_protocols", length = 200)
    private String encioProtocols;

    @Column(name = "encoder")
    private Boolean encoder;

    @Column(name = "encode_names", length = 200)
    private String encodenames;

    @Column(name = "endorser")
    private Boolean endorser;

    @Column(name = "envelope_supply", length = 200)
    private String envelopesupply;

    @Column(name = "exchange_types", length = 500)
    private String exchangeTypes;

    @Column(name = "extents", length = 500)
    private String extents;

    @Column(name = "extra", length = 500)
    private String extra;

    @Column(name = "font_names", length = 200)
    private String fontnames;

    @Column(name = "forms")
    private Boolean forms;

    @Column(name = "front_image_color_format", length = 500)
    private String frontImageColorFormat;

    @Column(name = "frontscan_color", length = 200)
    private String frontscanColor;
    
    @Column(name = "guidlights", length = 100)
    private String guidlights;

    @Column(name = "has_cash_box")
    private Boolean hasCashBox;

    @Column(name = "has_inserted_sensor")
    private Boolean hasInsertedSensor;

    @Column(name = "has_shutter")
    private Boolean hasShutter;

    @Column(name = "has_taken_sensor")
    private Boolean hasTakenSensor;

    @Column(name = "hsm_vendor", length = 200)
    private String hsmVendor;

    @Column(name = "id_connect")
    private Boolean idConnect;
    
    @Column(name = "id_key", length = 200)
    private String idKey;

    @Column(name = "image_capture", length = 200)
    private String imagecapture;

    @Column(name = "image_source", length = 500)
    private String imageSource;

    @Column(name = "image_type", length = 500)
    private String imageType;
    
    @Column(name = "indicators", length = 100)
    private String indicators;
    
    @Column(name = "insert_orientation", length = 200)
    private String insertOrientation;

    @Column(name = "intermediate_stacker")
    private Integer intermediateStacker;

    @Column(name = "is_application_refuse")
    private Boolean isApplicationRefuse;

    @Column(name = "is_autofeed")
    private Boolean isAutofeed;

    @Column(name = "is_card_taken_sensor")
    private Boolean isCardTakenSensor;

    @Column(name = "is_compare_signatures")
    private Boolean isCompareSignatures;

    @Column(name = "is_hsm_journaling")
    private Boolean isHsmJournaling;

    @Column(name = "is_intermediate_stacker")
    private Boolean isIntermediateStacker;

    @Column(name = "is_items_taken_sensor")
    private Boolean isItemsTakenSensor;

    @Column(name = "is_key_import_through_parts")
    private Boolean isKeyImportThroughParts;

    @Column(name = "is_media_presented")
    private Boolean isMediaPresented;

    @Column(name = "is_pin_can_persist_after_use")
    private Boolean isPinCanPersistAfterUse;

    @Column(name = "is_present_control")
    private Boolean isPresentControl;

    @Column(name = "is_rescan")
    private Boolean isRescan;

    @Column(name = "is_retract_counts_items")
    private Boolean isRetractCountsItems;

    @Column(name = "is_retract_to_transport")
    private Boolean isRetractToTransport;

    @Column(name = "is_safe_door")
    private Boolean isSafeDoor;

    @Column(name = "is_set_pin_block_data_requited")
    private Boolean isSetPinBlockDataRequired;

    @Column(name = "is_stamp")
    private Boolean isStamp;

    @Column(name = "is_type_combined")
    private Boolean isTypeCombined;

    @Column(name = "item_info_types", length = 200)
    private String itemInfoTypes;

    @Column(name = "key_block_import_formats", length = 200)
    private String keyBlockImportFormats;

    @Column(name = "key_check_modes", length = 500)
    private String keyCheckModes;

    @Column(name = "key_lock")
    private Boolean keyLock;

    @Column(name = "key_num")
    private Integer keyNum;

    @Column(name = "logical", length = 200)
    private String logical;
    
    @Column(name = "magnetic_stripe_read")
    private Boolean magneticstriperead;

    @Column(name = "magnetic_stripe_write")
    private Boolean magneticstripewrite;

    @Column(name = "max_cash_in_items")
    private Integer maxCashInItems;
    
    @Column(name = "max_data_length")
    private Integer maxDataLength;

    @Column(name = "max_dispense_items")
    private Integer maxDispenseItems;

    @Column(name = "max_media_on_stacker")
    private Integer maxMediaOnStacker;
    
    @Column(name = "max_num_chars")
    private Integer maxNumChars;

    @Column(name = "max_pictures")
    private Integer maxPictures;

    @Column(name = "max_retract", length = 200)
    private String maxRetract;

    @Column(name = "media_taken")
    private Boolean mediaTaken;

    @Column(name = "memory_chip_protocols", length = 200)
    private String memoryChipProtocols;
    
    @Column(name = "micr")
    private Boolean micr;

    @Column(name = "move_items", length = 500)
    private String moveItems;

    @Column(name = "multi_page")
    private Boolean multiPage;

    @Column(name = "num_leds")
    private Integer numLeds;
    
    @Column(name = "ocr")
    private Boolean ocr;

    @Column(name = "paper_sources", length = 500)
    private String paperSources;

    @Column(name = "pin_formats", length = 500)
    private String pinFormats;

    @Column(name = "power_off", length = 500)
    private String powerOff;

    @Column(name = "power_on", length = 500)
    private String powerOn;

    @Column(name = "power_save_control")
    private Boolean powerSaveControl;

    @Column(name = "presentation_algorithms", length = 500)
    private String presentationAlgorithms;
    
    @Column(name = "printer")
    private Boolean printer;

    @Column(name = "print_on_retracts")
    private Boolean printOnRetracts;

    @Column(name = "print_size", length = 200)
    private String printSize;

    @Column(name = "programatically_deactivate")
    private Boolean programaticallyDeactivate;

    @Column(name = "provider", length = 200)
    private String provider;

    @Column(name = "read_form", length = 500)
    private String readForm;

    @Column(name = "read_tracks", length = 500)
    private String readTracks;

    @Column(name = "refill")
    private Boolean refill;

    @Column(name = "reset_control", length = 200)
    private String resetControl;

    @Column(name = "resolutions", length = 500)
    private String resolutions;

    @Column(name = "retract_areas", length = 500)
    private String retractAreas;

    @Column(name = "retract_bins", length = 500)
    private String retractBins;
    
    @Column(name = "retract_envelope", length = 200)
    private String retractenvelope;

    @Column(name = "retract_stacker_actions", length = 500)
    private String retractStackerActions;

    @Column(name = "retract_transport_actions", length = 500)
    private String retractTransportActions;

    @Column(name = "rsa_auth_scheme", length = 200)
    private String rsaAuthenticationScheme;

    @Column(name = "rsa_crypt_algorithm", length = 200)
    private String rsaCryptAlgorithm;

    @Column(name = "rsa_keycheck_mode", length = 200)
    private String rsaKeycheckMode;

    @Column(name = "rsa_signature_algorithm", length = 200)
    private String rsaSignatureAlgorithm;

    @Column(name = "security_type", length = 500)
    private String securityType;
    
    @Column(name = "sensors", length = 100)
    private String sensors;

    @Column(name = "shutter_control")
    private Boolean shutterControl;
    
    @Column(name = "signature_scheme", length = 200)
    private String signatureScheme;

    @Column(name = "stamp", length = 200)
    private String stamp;

    @Column(name = "positions", length = 500)
    private String positions;

    @Column(name = "symbologies", length = 200)
    private String symbologies;

    @Column(name = "can_filter_symbologies")
    private Boolean canFilterSymbologies;
    
    @Column(name = "toner")
    private Boolean toner;

    @Column(name = "type", length = 500)
    private String type;

    @Column(name = "validation_algorithms", length = 500)
    private String validationAlgorithms;

    @Column(name = "windows_printer", length = 200)
    private String windowsPrinter;

    @Column(name = "write_form", length = 500)
    private String writeForm;

    @Column(name = "write_mode", length = 500)
    private String writeMode;

    @Column(name = "write_tracks", length = 500)
    private String writeTracks;

    public XfsComponent() {
    }

    public XfsComponent(ALM xfs) {
	xfsClass = "ALM";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	programaticallyDeactivate = xfs.isProgramaticallydeactivate();
    }

    public XfsComponent(BCR xfs) {
	xfsClass = "BCR";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	compound = xfs.isCompound();
	symbologies = xfs.getSymbologies();
	canFilterSymbologies = xfs.isCanfiltersymbologies();
	powerSaveControl = xfs.isPowersavecontrol();
    }

    public XfsComponent(CAM xfs) {
	xfsClass = "CAM";
	camdata = xfs.getCamdata();
	cameras = xfs.getCameras();
	charSupport = xfs.getCharsupport();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	maxDataLength = xfs.getMaxdatalength();
	maxPictures = xfs.getMaxpictures();
	provider = xfs.getProvider();
	type = xfs.getType();
    }

    public XfsComponent(CDM xfs) {
	xfsClass = "CDM";
	exchangeTypes = xfs.getExchangetype();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	maxDispenseItems = xfs.getMaxdispenseitems();
	moveItems = xfs.getMoveitems();
	positions = xfs.getPositions();
	provider = xfs.getProvider();
	retractAreas = xfs.getRetractareas();
	retractStackerActions = xfs.getRetractstackeractions();
	retractTransportActions = xfs.getRetracttransportactions();
	type = xfs.getType();
	hasCashBox = xfs.isCashbox();
	compound = xfs.isCompound();
	isIntermediateStacker = xfs.isIntermediatestacker();
	hasTakenSensor = xfs.isItemstakensensor();
	powerSaveControl = xfs.isPowersavecontrol();
	isPrepareDispense = xfs.isPreparedispense();
	isSafeDoor = xfs.isSafedoor();
	hasShutter = xfs.isShutter();
	shutterControl = xfs.isShuttercontrol();
    }

    public XfsComponent(CEU xfs) {
	xfsClass = "CEU";
	chipProtocol = xfs.getChipprotocol();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	chipio = xfs.isChipio();
	comparemagneticstripe = xfs.isComparemagneticstripe();
	compound = xfs.isCompound();
	magneticstriperead = xfs.isMagneticstriperead();
	magneticstripewrite = xfs.isMagneticstripewrite();
	powerSaveControl = xfs.isPowersavecontrol();
    }

    public XfsComponent(CHK xfs) {
	xfsClass = "CHK";
	charSupport = xfs.getCharsupport();
	encodenames = xfs.getEncodenames();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	fontnames = xfs.getFontnames();
	guidlights = xfs.getGuidlights();
	imagecapture = xfs.getImagecapture();
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	stamp = xfs.getStamp();
	type = xfs.getType();
	isAutofeed = xfs.isAutofeed();
	compound = xfs.isCompound();
	encoder = xfs.isEncoder();
	endorser = xfs.isEndorser();
	micr = xfs.isMicr();
	ocr = xfs.isOcr();
	powerSaveControl = xfs.isPowersavecontrol();
    }

    public XfsComponent(CIM xfs) {
	xfsClass = "CIM";
	exchangeTypes = xfs.getExchangetype();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	intermediateStacker = xfs.getIntermediatestacker();
	logical = xfs.getLogical();
	maxCashInItems = xfs.getMaxCashInItems();
	positions = xfs.getPositions();
	provider = xfs.getProvider();
	retractAreas = xfs.getRetractareas();
	retractStackerActions = xfs.getRetractstackeractions();
	retractTransportActions = xfs.getRetracttransportactions();
	type = xfs.getType();
	hasCashBox = xfs.isCashbox();
	compound = xfs.isCompound();
	hasInsertedSensor = xfs.isItemsinsertedsensor();
	powerSaveControl = xfs.isPowersavecontrol();
	refill = xfs.isRefill();
	isSafeDoor = xfs.isSafedoor();
	itemInfoTypes = xfs.getIteminfotypes();
	isCompareSignatures = xfs.isComparesignatures();
	isItemsTakenSensor = xfs.isItemstakensensor();
	hasShutter = xfs.isShutter();
	shutterControl = xfs.isShuttercontrol();
    }

    public XfsComponent(CRD xfs) {
	xfsClass = "CRD";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	powerOff = xfs.getPoweroffoption();
	powerOn = xfs.getPoweronoption();
	provider = xfs.getProvider();
	dispenseTo = xfs.getDispenseto();
	isCardTakenSensor = xfs.isCardtakensensor();
	compound = xfs.isCompound();
	powerSaveControl = xfs.isPowersavecontrol();
    }

    public XfsComponent(DEP xfs) {
	xfsClass = "DEP";
	charSupport = xfs.getCharsupport();
	envelopesupply = xfs.getEnvsupply();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	maxNumChars = xfs.getMaxnumchars();
	provider = xfs.getProvider();
	retractenvelope = xfs.getRetractenvelope();
	type = xfs.getType();
	deptransport = xfs.isDeptransport();
	powerSaveControl = xfs.isPowersavecontrol();
	printer = xfs.isPrinter();
	printOnRetracts = xfs.isPrintonretracts();
	hasShutter = xfs.isShutter();
	toner = xfs.isToner();
    }

    public XfsComponent(IDC xfs) {
	xfsClass = "IDC";
	cards = xfs.getCards();
	chipPower = xfs.getChippower();
	chipProtocol = xfs.getChipprotocols();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	dipMode = xfs.getDipmode();
	ejectPosition = xfs.getEjectposition();
	memoryChipProtocols = xfs.getMemorychipprotocols();
	powerOff = xfs.getPoweroffoption();
	powerOn = xfs.getPoweronoption();
	provider = xfs.getProvider();
	readTracks = xfs.getReadtracks();
	securityType = xfs.getSectype();
	type = xfs.getType();
	writeMode = xfs.getWritemode();
	writeTracks = xfs.getWritetracks();
    }

    public XfsComponent(IPM xfs) {
	xfsClass = "IPM";
	backImageColorFormat = xfs.getBackimagecolorformat();
	codeLineFormat = xfs.getCodelineformat();
	imageSource = xfs.getDatasource();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	frontImageColorFormat = xfs.getFrontimagecolorformat();
	guidlights = xfs.getGuidlights();
	imageType = xfs.getImagetype();
	logical = xfs.getLogical();
	maxMediaOnStacker = xfs.getMaxmediaonstacker();
	positions = xfs.getPositions();
	provider = xfs.getProvider();
	retractAreas = xfs.getRetractlocation();
	type = xfs.getType();
	compound = xfs.isCompound();
	powerSaveControl = xfs.isPowersavecontrol();
	backscanColor = xfs.getBackscancolor();
	defaultBackscanColor = xfs.getDefaultbackscancolor();
	defaultFrontscanColor = xfs.getDefaultfrontscancolor();
	frontscanColor = xfs.getFrontscancolor();
	insertOrientation = xfs.getInsertorientation();
	printSize = xfs.getPrintsize();
	resetControl = xfs.getResetcontrol();
	isApplicationRefuse = xfs.isApplicationrefuse();
	isPresentControl = xfs.isPresentcontrol();
	isRescan = xfs.isRescan();
	isRetractCountsItems = xfs.isRetractcountsitems();
	isStamp = xfs.isStamp();
    }

    public XfsComponent(PIN xfs) {
	xfsClass = "PIN";
	algorithms = xfs.getAlgorithms();
	derivationAlgorithms = xfs.getDerivationalgorithms();
	display = xfs.getDisplay();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	keyCheckModes = xfs.getKeycheckmodes();
	keyNum = xfs.getKeynum();
	logical = xfs.getLogical();
	pinFormats = xfs.getPinformats();
	presentationAlgorithms = xfs.getPresentationalgorithms();
	provider = xfs.getProvider();
	type = xfs.getType();
	validationAlgorithms = xfs.getValidationalgorithms();
	compound = xfs.isCompound();
	idConnect = xfs.isIdconnect();
	powerSaveControl = xfs.isPowersavecontrol();
	autobeep = xfs.getAutobeep();
	emvHashAlgorithm = xfs.getEmvhashalgorithm();
	emvImportSchemes = xfs.getEmvimportschemes();
	encioProtocols = xfs.getEncioprotocols();
	hsmVendor = xfs.getHsmvendor();
	idKey = xfs.getIdkey();
	keyBlockImportFormats = xfs.getKeyblockimportformats();
	rsaAuthenticationScheme = xfs.getRsaauthenticationscheme();
	rsaCryptAlgorithm = xfs.getRsacryptalgorithm();
	rsaKeycheckMode = xfs.getRsakeycheckmode();
	rsaSignatureAlgorithm = xfs.getRsasignaturealgorithm();
	signatureScheme = xfs.getSignaturescheme();
	isHsmJournaling = xfs.isHsmjournaling();
	isKeyImportThroughParts = xfs.isKeyimportthroughparts();
	isPinCanPersistAfterUse = xfs.isPincanpersistafteruse();
	isSetPinBlockDataRequired = xfs.isSetpinblockdatarequired();
	isTypeCombined = xfs.isTypecombined();
    }

    public XfsComponent(PTR xfs) {
	xfsClass = "PTR";
	backImageColorFormat = xfs.getBackimagecolorformat();
	charSupport = xfs.getCharsupport();
	codeLineFormat = xfs.getCodelineformat();
	control = xfs.getControl();
	extents = xfs.getExtents();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	frontImageColorFormat = xfs.getFrontimagecolorformat();
	guidlights = xfs.getGuidlights();
	imageSource = xfs.getImagesource();
	imageType = xfs.getImagetype();
	logical = xfs.getLogical();
	maxMediaOnStacker = xfs.getMaxmediaonstacker();
	paperSources = xfs.getPapersources();
	provider = xfs.getProvider();
	readForm = xfs.getReadform();
	resolutions = xfs.getResolution();
	retractBins = new Integer(xfs.getRetractbins()).toString();
	type = xfs.getType();
	writeForm = xfs.getWriteform();
	acceptMedia = xfs.isAcceptmedia();
	compound = xfs.isCompound();
	isPrepareDispense = xfs.isDispensepaper();
	mediaTaken = xfs.isMediataken();
	multiPage = xfs.isMultipage();
	powerSaveControl = xfs.isPowersavecontrol();
	autoretractPeriod = xfs.getAutoretractperiod();
	maxRetract = xfs.getMaxretract();
	windowsPrinter = xfs.getWindowsprinter();
	isMediaPresented = xfs.isMediapresented();
	isRetractToTransport = xfs.isRetracttotransport();
    }

    public XfsComponent(SIU xfs) {
	xfsClass = "SIU";
	auxiliaries = xfs.getAuxiliaries();
	doors = xfs.getDoors();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	indicators = xfs.getIndicators();
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	sensors = xfs.getSensors();
	type = xfs.getType();
	powerSaveControl = xfs.isPowersavecontrol();
    }

    public XfsComponent(TTU xfs) {
	xfsClass = "TTU";
	charSupport = xfs.getCharsupport();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	numLeds = xfs.getNumofleds();
	provider = xfs.getProvider();
	resolutions = xfs.getResolutions();
	type = xfs.getType();
	cursor = xfs.isCursor();
	displayLight = xfs.isDisplaylight();
	forms = xfs.isForms();
	keyLock = xfs.isKeylock();
	powerSaveControl = xfs.isPowersavecontrol();
    }

    public XfsComponent(VDM xfs) {
	xfsClass = "VDM";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public List<FinancialDevice> getFinancialDevices() {
	return financialDevices;
    }

    public void setFinancialDevices(List<FinancialDevice> financialDevices) {
	this.financialDevices = financialDevices;
    }

    public List<LogicalCashUnit> getLogicalCashUnits() {
	return logicalCashUnits;
    }

    public void setLogicalCashUnits(List<LogicalCashUnit> logicalCashUnits) {
	this.logicalCashUnits = logicalCashUnits;
    }

    public String getXfsClass() {
	return xfsClass;
    }

    public void setXfsClass(String xfsClass) {
	this.xfsClass = xfsClass;
    }

    public Boolean getAcceptMedia() {
	return acceptMedia;
    }

    public void setAcceptMedia(Boolean acceptMedia) {
	this.acceptMedia = acceptMedia;
    }

    public String getAlgorithms() {
	return algorithms;
    }

    public void setAlgorithms(String algorithms) {
	this.algorithms = algorithms;
    }

    public String getAutobeep() {
	return autobeep;
    }

    public void setAutobeep(String autobeep) {
	this.autobeep = autobeep;
    }

    public Integer getAutoretractPeriod() {
	return autoretractPeriod;
    }

    public void setAutoretractPeriod(Integer autoretractPeriod) {
	this.autoretractPeriod = autoretractPeriod;
    }

    public String getAuxiliaries() {
	return auxiliaries;
    }

    public void setAuxiliaries(String auxiliaries) {
	this.auxiliaries = auxiliaries;
    }

    public String getBackImageColorFormat() {
	return backImageColorFormat;
    }

    public void setBackImageColorFormat(String backImageColorFormat) {
	this.backImageColorFormat = backImageColorFormat;
    }

    public String getBackscanColor() {
	return backscanColor;
    }

    public void setBackscanColor(String backscanColor) {
	this.backscanColor = backscanColor;
    }

    public String getCameras() {
	return cameras;
    }

    public void setCameras(String cameras) {
	this.cameras = cameras;
    }

    public String getCamdata() {
	return camdata;
    }

    public void setCamdata(String camdata) {
	this.camdata = camdata;
    }

    public Integer getCards() {
	return cards;
    }

    public void setCards(Integer cards) {
	this.cards = cards;
    }

    public String getCharSupport() {
	return charSupport;
    }

    public void setCharSupport(String charSupport) {
	this.charSupport = charSupport;
    }

    public Boolean getChipio() {
	return chipio;
    }

    public void setChipio(Boolean chipio) {
	this.chipio = chipio;
    }

    public String getChipPower() {
	return chipPower;
    }

    public void setChipPower(String chipPower) {
	this.chipPower = chipPower;
    }

    public String getChipProtocol() {
	return chipProtocol;
    }

    public void setChipProtocol(String chipProtocol) {
	this.chipProtocol = chipProtocol;
    }

    public String getCodeLineFormat() {
	return codeLineFormat;
    }

    public void setCodeLineFormat(String codeLineFormat) {
	this.codeLineFormat = codeLineFormat;
    }

    public Boolean getCompound() {
	return compound;
    }

    public void setCompound(Boolean compound) {
	this.compound = compound;
    }

    public Boolean getComparemagneticstripe() {
	return comparemagneticstripe;
    }

    public void setComparemagneticstripe(Boolean comparemagneticstripe) {
	this.comparemagneticstripe = comparemagneticstripe;
    }

    public String getControl() {
	return control;
    }

    public void setControl(String control) {
	this.control = control;
    }

    public Boolean getCursor() {
	return cursor;
    }

    public void setCursor(Boolean cursor) {
	this.cursor = cursor;
    }

    public String getDefaultBackscanColor() {
	return defaultBackscanColor;
    }

    public void setDefaultBackscanColor(String defaultBackscanColor) {
	this.defaultBackscanColor = defaultBackscanColor;
    }

    public String getDefaultFrontscanColor() {
	return defaultFrontscanColor;
    }

    public void setDefaultFrontscanColor(String defaultFrontscanColor) {
	this.defaultFrontscanColor = defaultFrontscanColor;
    }

    public Boolean getDeptransport() {
	return deptransport;
    }

    public void setDeptransport(Boolean deptransport) {
	this.deptransport = deptransport;
    }

    public String getDerivationAlgorithms() {
	return derivationAlgorithms;
    }

    public void setDerivationAlgorithms(String derivationAlgorithms) {
	this.derivationAlgorithms = derivationAlgorithms;
    }

    public Boolean getIsPrepareDispense() {
	return isPrepareDispense;
    }

    public void setIsPrepareDispense(Boolean isPrepareDispense) {
	this.isPrepareDispense = isPrepareDispense;
    }

    public String getDipMode() {
	return dipMode;
    }

    public void setDipMode(String dipMode) {
	this.dipMode = dipMode;
    }

    public String getDispenseTo() {
	return dispenseTo;
    }

    public void setDispenseTo(String dispenseTo) {
	this.dispenseTo = dispenseTo;
    }

    public String getDisplay() {
	return display;
    }

    public void setDisplay(String display) {
	this.display = display;
    }

    public Boolean getDisplayLight() {
	return displayLight;
    }

    public void setDisplayLight(Boolean displayLight) {
	this.displayLight = displayLight;
    }

    public String getDoors() {
	return doors;
    }

    public void setDoors(String doors) {
	this.doors = doors;
    }

    public String getEjectPosition() {
	return ejectPosition;
    }

    public void setEjectPosition(String ejectPosition) {
	this.ejectPosition = ejectPosition;
    }

    public String getEmvHashAlgorithm() {
	return emvHashAlgorithm;
    }

    public void setEmvHashAlgorithm(String emvHashAlgorithm) {
	this.emvHashAlgorithm = emvHashAlgorithm;
    }

    public String getEmvImportSchemes() {
	return emvImportSchemes;
    }

    public void setEmvImportSchemes(String emvImportSchemes) {
	this.emvImportSchemes = emvImportSchemes;
    }

    public String getEncioProtocols() {
	return encioProtocols;
    }

    public void setEncioProtocols(String encioProtocols) {
	this.encioProtocols = encioProtocols;
    }

    public Boolean getEncoder() {
	return encoder;
    }

    public void setEncoder(Boolean encoder) {
	this.encoder = encoder;
    }

    public String getEncodenames() {
	return encodenames;
    }

    public void setEncodenames(String encodenames) {
	this.encodenames = encodenames;
    }

    public Boolean getEndorser() {
	return endorser;
    }

    public void setEndorser(Boolean endorser) {
	this.endorser = endorser;
    }

    public String getEnvelopesupply() {
	return envelopesupply;
    }

    public void setEnvelopesupply(String envelopesupply) {
	this.envelopesupply = envelopesupply;
    }

    public String getExchangeTypes() {
	return exchangeTypes;
    }

    public void setExchangeTypes(String exchangeTypes) {
	this.exchangeTypes = exchangeTypes;
    }

    public String getExtents() {
	return extents;
    }

    public void setExtents(String extents) {
	this.extents = extents;
    }

    public String getExtra() {
	return extra;
    }

    public void setExtra(String extra) {
	this.extra = extra;
    }

    public String getFontnames() {
	return fontnames;
    }

    public void setFontnames(String fontnames) {
	this.fontnames = fontnames;
    }

    public Boolean getForms() {
	return forms;
    }

    public void setForms(Boolean forms) {
	this.forms = forms;
    }

    public String getFrontImageColorFormat() {
	return frontImageColorFormat;
    }

    public void setFrontImageColorFormat(String frontImageColorFormat) {
	this.frontImageColorFormat = frontImageColorFormat;
    }

    public String getFrontscanColor() {
	return frontscanColor;
    }

    public void setFrontscanColor(String frontscanColor) {
	this.frontscanColor = frontscanColor;
    }

    public String getGuidlights() {
	return guidlights;
    }

    public void setGuidlights(String guidlights) {
	this.guidlights = guidlights;
    }

    public Boolean getHasCashBox() {
	return hasCashBox;
    }

    public void setHasCashBox(Boolean hasCashBox) {
	this.hasCashBox = hasCashBox;
    }

    public Boolean getHasInsertedSensor() {
	return hasInsertedSensor;
    }

    public void setHasInsertedSensor(Boolean hasInsertedSensor) {
	this.hasInsertedSensor = hasInsertedSensor;
    }

    public Boolean getHasShutter() {
	return hasShutter;
    }

    public void setHasShutter(Boolean hasShutter) {
	this.hasShutter = hasShutter;
    }

    public Boolean getHasTakenSensor() {
	return hasTakenSensor;
    }

    public void setHasTakenSensor(Boolean hasTakenSensor) {
	this.hasTakenSensor = hasTakenSensor;
    }

    public String getHsmVendor() {
	return hsmVendor;
    }

    public void setHsmVendor(String hsmVendor) {
	this.hsmVendor = hsmVendor;
    }

    public Boolean getIdConnect() {
	return idConnect;
    }

    public void setIdConnect(Boolean idConnect) {
	this.idConnect = idConnect;
    }

    public String getIdKey() {
	return idKey;
    }

    public void setIdKey(String idKey) {
	this.idKey = idKey;
    }

    public String getImagecapture() {
	return imagecapture;
    }

    public void setImagecapture(String imagecapture) {
	this.imagecapture = imagecapture;
    }

    public String getImageSource() {
	return imageSource;
    }

    public void setImageSource(String imageSource) {
	this.imageSource = imageSource;
    }

    public String getImageType() {
	return imageType;
    }

    public void setImageType(String imageType) {
	this.imageType = imageType;
    }

    public String getIndicators() {
	return indicators;
    }

    public void setIndicators(String indicators) {
	this.indicators = indicators;
    }

    public String getInsertOrientation() {
	return insertOrientation;
    }

    public void setInsertOrientation(String insertOrientation) {
	this.insertOrientation = insertOrientation;
    }

    public Integer getIntermediateStacker() {
	return intermediateStacker;
    }

    public void setIntermediateStacker(Integer intermediateStacker) {
	this.intermediateStacker = intermediateStacker;
    }

    public Boolean getIsApplicationRefuse() {
	return isApplicationRefuse;
    }

    public void setIsApplicationRefuse(Boolean isApplicationRefuse) {
	this.isApplicationRefuse = isApplicationRefuse;
    }

    public Boolean getIsAutofeed() {
	return isAutofeed;
    }

    public void setIsAutofeed(Boolean isAutofeed) {
	this.isAutofeed = isAutofeed;
    }

    public Boolean getIsCardTakenSensor() {
	return isCardTakenSensor;
    }

    public void setIsCardTakenSensor(Boolean isCardTakenSensor) {
	this.isCardTakenSensor = isCardTakenSensor;
    }

    public Boolean getIsCompareSignatures() {
	return isCompareSignatures;
    }

    public void setIsCompareSignatures(Boolean isCompareSignatures) {
	this.isCompareSignatures = isCompareSignatures;
    }

    public Boolean getIsHsmJournaling() {
	return isHsmJournaling;
    }

    public void setIsHsmJournaling(Boolean isHsmJournaling) {
	this.isHsmJournaling = isHsmJournaling;
    }

    public Boolean getIsIntermediateStacker() {
	return isIntermediateStacker;
    }

    public void setIsIntermediateStacker(Boolean isIntermediateStacker) {
	this.isIntermediateStacker = isIntermediateStacker;
    }

    public Boolean getIsItemsTakenSensor() {
	return isItemsTakenSensor;
    }

    public void setIsItemsTakenSensor(Boolean isItemsTakenSensor) {
	this.isItemsTakenSensor = isItemsTakenSensor;
    }

    public Boolean getIsKeyImportThroughParts() {
	return isKeyImportThroughParts;
    }

    public void setIsKeyImportThroughParts(Boolean isKeyImportThroughParts) {
	this.isKeyImportThroughParts = isKeyImportThroughParts;
    }

    public Boolean getIsMediaPresented() {
	return isMediaPresented;
    }

    public void setIsMediaPresented(Boolean isMediaPresented) {
	this.isMediaPresented = isMediaPresented;
    }

    public Boolean getIsPinCanPersistAfterUse() {
	return isPinCanPersistAfterUse;
    }

    public void setIsPinCanPersistAfterUse(Boolean isPinCanPersistAfterUse) {
	this.isPinCanPersistAfterUse = isPinCanPersistAfterUse;
    }

    public Boolean getIsPresentControl() {
	return isPresentControl;
    }

    public void setIsPresentControl(Boolean isPresentControl) {
	this.isPresentControl = isPresentControl;
    }

    public Boolean getIsRescan() {
	return isRescan;
    }

    public void setIsRescan(Boolean isRescan) {
	this.isRescan = isRescan;
    }

    public Boolean getIsRetractCountsItems() {
	return isRetractCountsItems;
    }

    public void setIsRetractCountsItems(Boolean isRetractCountsItems) {
	this.isRetractCountsItems = isRetractCountsItems;
    }

    public Boolean getIsRetractToTransport() {
	return isRetractToTransport;
    }

    public void setIsRetractToTransport(Boolean isRetractToTransport) {
	this.isRetractToTransport = isRetractToTransport;
    }

    public Boolean getIsSafeDoor() {
	return isSafeDoor;
    }

    public void setIsSafeDoor(Boolean isSafeDoor) {
	this.isSafeDoor = isSafeDoor;
    }

    public Boolean getIsSetPinBlockDataRequired() {
	return isSetPinBlockDataRequired;
    }

    public void setIsSetPinBlockDataRequired(Boolean isSetPinBlockDataRequired) {
	this.isSetPinBlockDataRequired = isSetPinBlockDataRequired;
    }

    public Boolean getIsStamp() {
	return isStamp;
    }

    public void setIsStamp(Boolean isStamp) {
	this.isStamp = isStamp;
    }

    public Boolean getIsTypeCombined() {
	return isTypeCombined;
    }

    public void setIsTypeCombined(Boolean isTypeCombined) {
	this.isTypeCombined = isTypeCombined;
    }

    public String getItemInfoTypes() {
	return itemInfoTypes;
    }

    public void setItemInfoTypes(String itemInfoTypes) {
	this.itemInfoTypes = itemInfoTypes;
    }

    public String getKeyBlockImportFormats() {
	return keyBlockImportFormats;
    }

    public void setKeyBlockImportFormats(String keyBlockImportFormats) {
	this.keyBlockImportFormats = keyBlockImportFormats;
    }

    public String getKeyCheckModes() {
	return keyCheckModes;
    }

    public void setKeyCheckModes(String keyCheckModes) {
	this.keyCheckModes = keyCheckModes;
    }

    public Boolean getKeyLock() {
	return keyLock;
    }

    public void setKeyLock(Boolean keyLock) {
	this.keyLock = keyLock;
    }

    public Integer getKeyNum() {
	return keyNum;
    }

    public void setKeyNum(Integer keyNum) {
	this.keyNum = keyNum;
    }

    public String getLogical() {
	return logical;
    }

    public void setLogical(String logical) {
	this.logical = logical;
    }

    public Boolean getMagneticstriperead() {
	return magneticstriperead;
    }

    public void setMagneticstriperead(Boolean magneticstriperead) {
	this.magneticstriperead = magneticstriperead;
    }

    public Boolean getMagneticstripewrite() {
	return magneticstripewrite;
    }

    public void setMagneticstripewrite(Boolean magneticstripewrite) {
	this.magneticstripewrite = magneticstripewrite;
    }

    public Integer getMaxCashInItems() {
	return maxCashInItems;
    }

    public void setMaxCashInItems(Integer maxCashInItems) {
	this.maxCashInItems = maxCashInItems;
    }

    public Integer getMaxDataLength() {
	return maxDataLength;
    }

    public void setMaxDataLength(Integer maxDataLength) {
	this.maxDataLength = maxDataLength;
    }

    public Integer getMaxDispenseItems() {
	return maxDispenseItems;
    }

    public void setMaxDispenseItems(Integer maxDispenseItems) {
	this.maxDispenseItems = maxDispenseItems;
    }

    public Integer getMaxMediaOnStacker() {
	return maxMediaOnStacker;
    }

    public void setMaxMediaOnStacker(Integer maxMediaOnStacker) {
	this.maxMediaOnStacker = maxMediaOnStacker;
    }

    public Integer getMaxNumChars() {
	return maxNumChars;
    }

    public void setMaxNumChars(Integer maxNumChars) {
	this.maxNumChars = maxNumChars;
    }

    public Integer getMaxPictures() {
	return maxPictures;
    }

    public void setMaxPictures(Integer maxPictures) {
	this.maxPictures = maxPictures;
    }

    public String getMaxRetract() {
	return maxRetract;
    }

    public void setMaxRetract(String maxRetract) {
	this.maxRetract = maxRetract;
    }

    public Boolean getMediaTaken() {
	return mediaTaken;
    }

    public void setMediaTaken(Boolean mediaTaken) {
	this.mediaTaken = mediaTaken;
    }

    public String getMemoryChipProtocols() {
	return memoryChipProtocols;
    }

    public void setMemoryChipProtocols(String memoryChipProtocols) {
	this.memoryChipProtocols = memoryChipProtocols;
    }

    public Boolean getMicr() {
	return micr;
    }

    public void setMicr(Boolean micr) {
	this.micr = micr;
    }

    public String getMoveItems() {
	return moveItems;
    }

    public void setMoveItems(String moveItems) {
	this.moveItems = moveItems;
    }

    public Boolean getMultiPage() {
	return multiPage;
    }

    public void setMultiPage(Boolean multiPage) {
	this.multiPage = multiPage;
    }

    public Integer getNumLeds() {
	return numLeds;
    }

    public void setNumLeds(Integer numLeds) {
	this.numLeds = numLeds;
    }

    public Boolean getOcr() {
	return ocr;
    }

    public void setOcr(Boolean ocr) {
	this.ocr = ocr;
    }

    public String getPaperSources() {
	return paperSources;
    }

    public void setPaperSources(String paperSources) {
	this.paperSources = paperSources;
    }

    public String getPinFormats() {
	return pinFormats;
    }

    public void setPinFormats(String pinFormats) {
	this.pinFormats = pinFormats;
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

    public Boolean getPowerSaveControl() {
	return powerSaveControl;
    }

    public void setPowerSaveControl(Boolean powerSaveControl) {
	this.powerSaveControl = powerSaveControl;
    }

    public String getPresentationAlgorithms() {
	return presentationAlgorithms;
    }

    public void setPresentationAlgorithms(String presentationAlgorithms) {
	this.presentationAlgorithms = presentationAlgorithms;
    }

    public Boolean getPrinter() {
	return printer;
    }

    public void setPrinter(Boolean printer) {
	this.printer = printer;
    }

    public Boolean getPrintOnRetracts() {
	return printOnRetracts;
    }

    public void setPrintOnRetracts(Boolean printOnRetracts) {
	this.printOnRetracts = printOnRetracts;
    }

    public String getPrintSize() {
	return printSize;
    }

    public void setPrintSize(String printSize) {
	this.printSize = printSize;
    }

    public Boolean getProgramaticallyDeactivate() {
	return programaticallyDeactivate;
    }

    public void setProgramaticallyDeactivate(Boolean programaticallyDeactivate) {
	this.programaticallyDeactivate = programaticallyDeactivate;
    }

    public String getProvider() {
	return provider;
    }

    public void setProvider(String provider) {
	this.provider = provider;
    }

    public String getReadForm() {
	return readForm;
    }

    public void setReadForm(String readForm) {
	this.readForm = readForm;
    }

    public String getReadTracks() {
	return readTracks;
    }

    public void setReadTracks(String readTracks) {
	this.readTracks = readTracks;
    }

    public Boolean getRefill() {
	return refill;
    }

    public void setRefill(Boolean refill) {
	this.refill = refill;
    }

    public String getResetControl() {
	return resetControl;
    }

    public void setResetControl(String resetControl) {
	this.resetControl = resetControl;
    }

    public String getResolutions() {
	return resolutions;
    }

    public void setResolutions(String resolutions) {
	this.resolutions = resolutions;
    }

    public String getRetractAreas() {
	return retractAreas;
    }

    public void setRetractAreas(String retractAreas) {
	this.retractAreas = retractAreas;
    }

    public String getRetractBins() {
	return retractBins;
    }

    public void setRetractBins(String retractBins) {
	this.retractBins = retractBins;
    }

    public String getRetractenvelope() {
	return retractenvelope;
    }

    public void setRetractenvelope(String retractenvelope) {
	this.retractenvelope = retractenvelope;
    }

    public String getRetractStackerActions() {
	return retractStackerActions;
    }

    public void setRetractStackerActions(String retractStackerActions) {
	this.retractStackerActions = retractStackerActions;
    }

    public String getRetractTransportActions() {
	return retractTransportActions;
    }

    public void setRetractTransportActions(String retractTransportActions) {
	this.retractTransportActions = retractTransportActions;
    }

    public String getRsaAuthenticationScheme() {
	return rsaAuthenticationScheme;
    }

    public void setRsaAuthenticationScheme(String rsaAuthenticationScheme) {
	this.rsaAuthenticationScheme = rsaAuthenticationScheme;
    }

    public String getRsaCryptAlgorithm() {
	return rsaCryptAlgorithm;
    }

    public void setRsaCryptAlgorithm(String rsaCryptAlgorithm) {
	this.rsaCryptAlgorithm = rsaCryptAlgorithm;
    }

    public String getRsaKeycheckMode() {
	return rsaKeycheckMode;
    }

    public void setRsaKeycheckMode(String rsaKeycheckMode) {
	this.rsaKeycheckMode = rsaKeycheckMode;
    }

    public String getRsaSignatureAlgorithm() {
	return rsaSignatureAlgorithm;
    }

    public void setRsaSignatureAlgorithm(String rsaSignatureAlgorithm) {
	this.rsaSignatureAlgorithm = rsaSignatureAlgorithm;
    }

    public String getSecurityType() {
	return securityType;
    }

    public void setSecurityType(String securityType) {
	this.securityType = securityType;
    }

    public String getSensors() {
	return sensors;
    }

    public void setSensors(String sensors) {
	this.sensors = sensors;
    }

    public Boolean getShutterControl() {
	return shutterControl;
    }

    public void setShutterControl(Boolean shutterControl) {
	this.shutterControl = shutterControl;
    }

    public String getSignatureScheme() {
	return signatureScheme;
    }

    public void setSignatureScheme(String signatureScheme) {
	this.signatureScheme = signatureScheme;
    }

    public String getStamp() {
	return stamp;
    }

    public void setStamp(String stamp) {
	this.stamp = stamp;
    }

    public String getPositions() {
	return positions;
    }

    public void setPositions(String positions) {
	this.positions = positions;
    }

    public String getSymbologies() {
	return symbologies;
    }

    public void setSymbologies(String symbologies) {
	this.symbologies = symbologies;
    }

    public Boolean getCanFilterSymbologies() {
	return canFilterSymbologies;
    }

    public void setCanFilterSymbologies(Boolean canFilterSymbologies) {
	this.canFilterSymbologies = canFilterSymbologies;
    }

    public Boolean getToner() {
	return toner;
    }

    public void setToner(Boolean toner) {
	this.toner = toner;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getValidationAlgorithms() {
	return validationAlgorithms;
    }

    public void setValidationAlgorithms(String validationAlgorithms) {
	this.validationAlgorithms = validationAlgorithms;
    }

    public String getWindowsPrinter() {
	return windowsPrinter;
    }

    public void setWindowsPrinter(String windowsPrinter) {
	this.windowsPrinter = windowsPrinter;
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

    public String getWriteTracks() {
	return writeTracks;
    }

    public void setWriteTracks(String writeTracks) {
	this.writeTracks = writeTracks;
    }

    public static Set<String> getXfsclasses() {
	return xfsClasses;
    }
}