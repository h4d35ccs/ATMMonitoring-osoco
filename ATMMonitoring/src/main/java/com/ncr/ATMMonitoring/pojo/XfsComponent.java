package com.ncr.ATMMonitoring.pojo;

import java.util.Arrays;
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
import javax.persistence.ManyToOne;
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

    private static final char separator = ';';

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

    @ManyToOne
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "financial_device_id")
    private FinancialDevice financialDevice;

    @OneToMany(mappedBy = "xfsComponent", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("type")
    private Set<LogicalCashUnit> logicalCashUnits = new HashSet<LogicalCashUnit>();

    @Column(name = "xfs_class", length = 50, nullable = false)
    private String xfsClass;

    @Column(name = "accept_media")
    private Boolean acceptMedia;

    @Column(name = "algorithms", length = 500)
    private String algorithms;
    
    @Column(name = "autofix")
    private Boolean autofix;

    /*@Column(name = "aux_15")
    private Integer auxiliary15;

    @Column(name = "aux_audible_alarm")
    private Boolean auxiliaryAudibleAlarm;

    @Column(name = "aux_enhanced_audio_control")
    private Boolean auxiliaryEnhancedAudioControl;

    @Column(name = "aux_remote_status_monitor")
    private Boolean auxiliaryRemoteStatusMonitor;

    @Column(name = "aux_ups")
    private Boolean auxiliaryUps;

    @Column(name = "aux_volume")
    private Boolean auxiliaryVolume;*/
    
    @Column(name = "auxiliaries", length = 100)
    private String auxiliaries;

    @Column(name = "back_image_color_format", length = 500)
    private String backImageColorFormat;
    
    @Column(name = "cameras", length = 200)
    private String cameras;

    @Column(name = "cam_data", length = 200)
    private String camdata;

    @Column(name = "can_open_safe_door")
    private Boolean canOpenSafeDoor;

    @Column(name = "cards", length = 500)
    private String cards;

    @Column(name = "cash_units", length = 500)
    private String cashUnits;

    @Column(name = "cen_major_version")
    private Integer cenMajorVersion;

    @Column(name = "cen_minor_version")
    private Integer cenMinorVersion;

    @Column(name = "cen_build_version")
    private Integer cenBuildVersion;

    @Column(name = "cen_revision_version")
    private Integer cenRevisionVersion;

    @Column(name = "cen_remaining_version", length = 20)
    private String cenRemainingVersion;

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
    
    @Column(name = "dep_transport")
    private Boolean deptransport;

    @Column(name = "derivation_algorithms", length = 500)
    private String derivationAlgorithms;

    @Column(name = "dispense_paper")
    private Boolean dispensePaper;

    @Column(name = "display", length = 500)
    private String display;

    @Column(name = "display_light")
    private Boolean displayLight;

    /*@Column(name = "door_cabinet")
    private Boolean doorCabinet;

    @Column(name = "door_safe", length = 500)
    private String doorSafe;*/

    @Column(name = "door_safe")
    private Boolean doorSafe;

    @Column(name = "door_vandal_shield")
    private Boolean doorVandalShield;
    
    @Column(name = "doors", length = 100)
    private String doors;

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

    @Column(name = "flux")
    private Boolean flux;

    @Column(name = "font_names", length = 200)
    private String fontnames;

    @Column(name = "forms")
    private Boolean forms;

    @Column(name = "front_image_color_format", length = 500)
    private String frontImageColorFormat;

    /*@Column(name = "g_light_bill_acceptor")
    private Boolean guideLightBillAcceptor;

    @Column(name = "g_light_card_unit")
    private Boolean guideLightCardUnit;

    @Column(name = "g_light_cheque_unit")
    private Boolean guideLightChequeUnit;

    @Column(name = "g_light_coin_acceptor")
    private Boolean guideLightCoinAcceptor;

    @Column(name = "g_light_coin_dispenser")
    private Boolean guideLightCoinDispenser;

    @Column(name = "g_light_document_printer")
    private Boolean guideLightDocumentPrinter;

    @Column(name = "g_light_envelope_depository")
    private Boolean guideLightEnvelopeDepository;

    @Column(name = "g_light_envelope_dispenser")
    private Boolean guideLightEnvelopeDispenser;

    @Column(name = "g_light_note_dispenser")
    private Boolean guideLightNoteDispenser;

    @Column(name = "g_light_passbook_dispenser")
    private Boolean guideLightPassbookDispenser;

    @Column(name = "g_light_pin_pad")
    private Boolean guideLightPinPad;

    @Column(name = "g_light_receipt_printer")
    private Boolean guideLightReceiptPrinter;

    @Column(name = "g_light_scanner")
    private Boolean guideLightScanner;*/
    
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

    @Column(name = "id_connect")
    private Boolean idConnect;

    /*@Column(name = "id_key")
    private Boolean idKey;*/
    
    @Column(name = "id_key")
    private Integer idKey;
    
    @Column(name = "image_capture", length = 200)
    private String imagecapture;

    @Column(name = "image_source", length = 500)
    private String imageSource;

    @Column(name = "image_type", length = 500)
    private String imageType;
    
    @Column(name = "indicators", length = 100)
    private String indicators;

    /*@Column(name = "indicator_audio")
    private Boolean indicatorAudio;

    @Column(name = "indicator_fascia_light")
    private Boolean indicatorFasciaLight;

    @Column(name = "indicator_heating")
    private Boolean indicatorHeating;

    @Column(name = "indicator_open_close")
    private Boolean indicatorOpenClose;

    @Column(name = "intermediate_stacker")
    private Boolean intermediateStacker;*/
    
    @Column(name = "intermediate_stacker")
    private Integer intermediateStacker;

    @Column(name = "key_check_modes", length = 500)
    private String keyCheckModes;

    @Column(name = "key_lock")
    private Boolean keyLock;

    @Column(name = "key_num")
    private Integer keyNum;

    @Column(name = "logical_name", length = 500)
    private String logicalName;
    
    @Column(name = "magnetic_stripe_read")
    private Boolean magneticstriperead;

    @Column(name = "magnetic_stripe_write")
    private Boolean magneticstripewrite;

    @Column(name = "max_cash_in_items")
    private Integer maxCashInItems;
    
    @Column(name = "max_data_length")
    private Integer maxdatalength;

    @Column(name = "max_dispense_items")
    private Integer maxDispenseItems;

    @Column(name = "max_media_on_stacker")
    private Integer maxMediaOnStacker;
    
    @Column(name = "max_num_chars")
    private Integer maxnumchars;

    @Column(name = "max_pictures")
    private Integer maxpictures;

    @Column(name = "max_retract")
    private Integer maxRetract;

    @Column(name = "media_taken")
    private Boolean mediaTaken;
    
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

    @Column(name = "presentation_algorithms", length = 500)
    private String presentationAlgorithms;
    
    @Column(name = "printer")
    private Boolean printer;

    @Column(name = "print_on_retracts")
    private Boolean printonretracts;

    @Column(name = "programatically_deactivate")
    private Boolean programaticallydeactivate;

    @Column(name = "read_form", length = 500)
    private String readForm;

    @Column(name = "read_tracks", length = 500)
    private String readTracks;

    @Column(name = "read_write_after_eject")
    private Boolean readWriteAfterEject;

    @Column(name = "refill")
    private Boolean refill;

    @Column(name = "resolution", length = 500)
    private String resolution;

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

    @Column(name = "security_type", length = 500)
    private String securityType;

    /*@Column(name = "sensor_30")
    private Integer sensor30;

    @Column(name = "sensor_31")
    private Integer sensor31;

    @Column(name = "sensor_ambient_light")
    private Boolean sensorAmbientLight;

    @Column(name = "sensor_enhanced_audio")
    private Boolean sensorEnhancedAudio;

    @Column(name = "sensor_heat")
    private Boolean sensorHeat;

    @Column(name = "sensor_internal_tamper")
    private Boolean sensorInternalTamper;

    @Column(name = "sensor_operator_switch", length = 500)
    private String sensorOperatorSwitch;

    @Column(name = "sensor_proximity")
    private Boolean sensorProximity;

    @Column(name = "sensor_seismic")
    private Boolean sensorSeismic;

    @Column(name = "sensor_tamper")
    private Boolean sensorTamper;*/
    
    @Column(name = "sensors", length = 100)
    private String sensors;

    @Column(name = "service_provider", length = 500)
    private String serviceProvider;

    @Column(name = "shutter_control")
    private Boolean shutterControl;
    
    @Column(name = "stamp", length = 200)
    private String stamp;

    @Column(name = "supported_positions", length = 500)
    private String supportedPositions;
    
    @Column(name = "toner")
    private Boolean toner;

    @Column(name = "type", length = 500)
    private String type;

    @Column(name = "validation_algorithms", length = 500)
    private String validationAlgorithms;

    @Column(name = "vendor", length = 500)
    private String vendor;

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
	extra = xfs.getExtra();
	xfs.getLogical();
	xfs.getProvider();
	programaticallydeactivate = xfs.isProgramaticallydeactivate();
    }

    public XfsComponent(BCR xfs) {
	xfsClass = "BCR";
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	xfs.getLogical();
	xfs.getProvider();
	xfs.getSymbologies();
	xfs.isCanfiltersymbologies();
	compound = xfs.isCompound();
	xfs.isPowersavecontrol();
    }

    public XfsComponent(CAM xfs) {
	xfsClass = "CAM";
	camdata = xfs.getCamdata();
	cameras = xfs.getCameras();
	charSupport = xfs.getCharsupport();
	extra = xfs.getExtra();
	xfs.getLogical();
	maxdatalength = xfs.getMaxdatalength();
	maxpictures = xfs.getMaxpictures();
	xfs.getProvider();
	type = xfs.getType();
    }

    public XfsComponent(CDM xfs) {
	xfsClass = "CDM";
	exchangeTypes = xfs.getExchangetype();
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	xfs.getLogical();
	maxDispenseItems = xfs.getMaxdispenseitems();
	moveItems = xfs.getMoveitems();
	supportedPositions = xfs.getPositions();
	xfs.getProvider();
	retractAreas = xfs.getRetractareas();
	retractStackerActions = xfs.getRetractstackeractions();
	retractTransportActions = xfs.getRetracttransportactions();
	type = xfs.getType();
	hasCashBox = xfs.isCashbox();
	compound = xfs.isCompound();
	xfs.isIntermediatestacker();
	hasTakenSensor = xfs.isItemstakensensor();
	xfs.isPowersavecontrol();
	dispensePaper = xfs.isPreparedispense();
	canOpenSafeDoor = xfs.isSafedoor(); // ??????????????????????????????????
	hasShutter = xfs.isShutter();
	shutterControl = xfs.isShuttercontrol();
    }

    public XfsComponent(CEU xfs) {
	xfsClass = "CEU";
	chipProtocol = xfs.getChipprotocol();
	extra = xfs.getExtra();
	xfs.getLogical();
	xfs.getProvider();
	chipio = xfs.isChipio();
	comparemagneticstripe = xfs.isComparemagneticstripe();
	compound = xfs.isCompound();
	magneticstriperead = xfs.isMagneticstriperead();
	magneticstripewrite = xfs.isMagneticstripewrite();
	xfs.isPowersavecontrol();
    }

    public XfsComponent(CHK xfs) {
	xfsClass = "CHK";
	charSupport = xfs.getCharsupport();
	encodenames = xfs.getEncodenames();
	extra = xfs.getExtra();
	fontnames = xfs.getFontnames();
	guidlights = xfs.getGuidlights();
	imagecapture = xfs.getImagecapture();
	xfs.getLogical();
	xfs.getProvider();
	stamp = xfs.getStamp();
	type = xfs.getType();
	xfs.isAutofeed();
	compound = xfs.isCompound();
	encoder = xfs.isEncoder();
	endorser = xfs.isEndorser();
	micr = xfs.isMicr();
	ocr = xfs.isOcr();
	xfs.isPowersavecontrol();
    }

    public XfsComponent(CIM xfs) {
	xfsClass = "CIM";
	exchangeTypes = xfs.getExchangetype();
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	intermediateStacker = xfs.getIntermediatestacker();
	xfs.getIteminfotypes();
	xfs.getLogical();
	maxCashInItems = xfs.getMaxCashInItems();
	supportedPositions = xfs.getPositions();
	xfs.getProvider();
	retractAreas = xfs.getRetractareas();
	retractStackerActions = xfs.getRetractstackeractions();
	retractTransportActions = xfs.getRetracttransportactions();
	type = xfs.getType();
	hasCashBox = xfs.isCashbox();
	xfs.isComparesignatures();
	compound = xfs.isCompound();
	hasInsertedSensor = xfs.isItemsinsertedsensor();
	xfs.isItemstakensensor();
	xfs.isPowersavecontrol();
	refill = xfs.isRefill();
	xfs.isSafedoor();
	hasShutter = xfs.isShutter();
	shutterControl = xfs.isShuttercontrol();
    }

    public XfsComponent(CRD xfs) {
	xfsClass = "CRD";
	xfs.getDispenseto();
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	xfs.getLogical();
	powerOff = xfs.getPoweroffoption();
	powerOn = xfs.getPoweronoption();
	xfs.getProvider();
	xfs.isCardtakensensor();
	compound = xfs.isCompound();
	xfs.isPowersavecontrol();
    }

    public XfsComponent(DEP xfs) {
	xfsClass = "DEP";
	charSupport = xfs.getCharsupport();
	envelopesupply = xfs.getEnvsupply();
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	xfs.getLogical();
	maxnumchars = xfs.getMaxnumchars();
	xfs.getProvider();
	retractenvelope = xfs.getRetractenvelope();
	type = xfs.getType();
	deptransport = xfs.isDeptransport();
	xfs.isPowersavecontrol();
	printer = xfs.isPrinter();
	printonretracts = xfs.isPrintonretracts();
	hasShutter = xfs.isShutter();
	toner = xfs.isToner();
    }

    public XfsComponent(IDC xfs) {
	xfsClass = "IDC";
	cards = new Integer(xfs.getCards()).toString();
	chipPower = xfs.getChippower();
	chipProtocol = xfs.getChipprotocols();
	xfs.getDipmode();
	xfs.getEjectposition();
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	xfs.getLogical();
	xfs.getMemorychipprotocols();
	powerOff = xfs.getPoweroffoption();
	powerOn = xfs.getPoweronoption();
	xfs.getProvider();
	readTracks = xfs.getReadtracks();
	securityType = xfs.getSectype();
	type = xfs.getType();
	writeMode = xfs.getWritemode();
	writeTracks = xfs.getWritetracks();
    }

    public XfsComponent(IPM xfs) {
	xfsClass = "IPM";
	backImageColorFormat = xfs.getBackimagecolorformat();
	xfs.getBackscancolor();
	codeLineFormat = xfs.getCodelineformat();
	imageSource = xfs.getDatasource();
	xfs.getDefaultbackscancolor();
	xfs.getDefaultfrontscancolor();
	extra = xfs.getExtra();
	frontImageColorFormat = xfs.getFrontimagecolorformat();
	xfs.getFrontscancolor();
	guidlights = xfs.getGuidlights();
	imageType = xfs.getImagetype();
	xfs.getInsertorientation();
	xfs.getLogical();
	maxMediaOnStacker = xfs.getMaxmediaonstacker();
	supportedPositions = xfs.getPositions();
	xfs.getPrintsize();
	xfs.getProvider();
	xfs.getResetcontrol();
	retractAreas = xfs.getRetractlocation();
	type = xfs.getType();
	xfs.isApplicationrefuse();
	compound = xfs.isCompound();
	xfs.isPowersavecontrol();
	xfs.isPresentcontrol();
	xfs.isRescan();
	xfs.isRetractcountsitems();
	xfs.isStamp();
    }

    public XfsComponent(PIN xfs) {
	xfsClass = "PIN";
	algorithms = xfs.getAlgorithms();
	xfs.getAutobeep();
	derivationAlgorithms = xfs.getDerivationalgorithms();
	display = xfs.getDisplay();
	xfs.getEmvhashalgorithm();
	xfs.getEmvimportschemes();
	xfs.getEncioprotocols();
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	xfs.getHsmvendor();
	// idKey = xfs.getIdkey(); TODO ????????? String -> Integer
	xfs.getKeyblockimportformats();
	keyCheckModes = xfs.getKeycheckmodes();
	keyNum = xfs.getKeynum();
	xfs.getLogical();
	pinFormats = xfs.getPinformats();
	presentationAlgorithms = xfs.getPresentationalgorithms();
	xfs.getProvider();
	xfs.getRsaauthenticationscheme();
	xfs.getRsacryptalgorithm();
	xfs.getRsakeycheckmode();
	xfs.getRsasignaturealgorithm();
	xfs.getSignaturescheme();
	type = xfs.getType();
	validationAlgorithms = xfs.getValidationalgorithms();
	compound = xfs.isCompound();
	xfs.isHsmjournaling();
	idConnect = xfs.isIdconnect();
	xfs.isKeyimportthroughparts();
	xfs.isPincanpersistafteruse();
	xfs.isPowersavecontrol();
	xfs.isSetpinblockdatarequired();
	xfs.isTypecombined();
    }

    public XfsComponent(PTR xfs) {
	xfsClass = "PTR";
	xfs.getAutoretractperiod();
	backImageColorFormat = xfs.getBackimagecolorformat();
	charSupport = xfs.getCharsupport();
	codeLineFormat = xfs.getCodelineformat();
	control = xfs.getControl();
	extents = xfs.getExtents();
	extra = xfs.getExtra();
	frontImageColorFormat = xfs.getFrontimagecolorformat();
	guidlights = xfs.getGuidlights();
	imageSource = xfs.getImagesource();
	imageType = xfs.getImagetype();
	xfs.getLogical();
	maxMediaOnStacker = xfs.getMaxmediaonstacker();
	// maxRetract = xfs.getMaxretract(); TODO ?????? String -> Integer
	paperSources = xfs.getPapersources();
	xfs.getProvider();
	readForm = xfs.getReadform();
	resolutions = xfs.getResolution();
	retractBins = new Integer(xfs.getRetractbins()).toString();
	type = xfs.getType();
	xfs.getWindowsprinter();
	writeForm = xfs.getWriteform();
	acceptMedia = xfs.isAcceptmedia();
	compound = xfs.isCompound();
	dispensePaper = xfs.isDispensepaper();
	xfs.isMediapresented();
	mediaTaken = xfs.isMediataken();
	multiPage = xfs.isMultipage();
	xfs.isPowersavecontrol();
	xfs.isRetracttotransport();
    }

    public XfsComponent(SIU xfs) {
	xfsClass = "SIU";
	auxiliaries = xfs.getAuxiliaries();
	doors = xfs.getDoors();
	extra = xfs.getExtra();
	guidlights = xfs.getGuidlights();
	indicators = xfs.getIndicators();
	xfs.getLogical();
	xfs.getProvider();
	sensors = xfs.getSensors();
	type = xfs.getType();
	xfs.isPowersavecontrol();
    }

    public XfsComponent(TTU xfs) {
	xfsClass = "TTU";
	charSupport = xfs.getCharsupport();
	extra = xfs.getExtra();
	xfs.getLogical();
	numLeds = xfs.getNumofleds();
	xfs.getProvider();
	resolutions = xfs.getResolutions();
	type = xfs.getType();
	cursor = xfs.isCursor();
	displayLight = xfs.isDisplaylight();
	forms = xfs.isForms();
	keyLock = xfs.isKeylock();
	xfs.isPowersavecontrol();
    }

    public XfsComponent(VDM xfs) {
	xfsClass = "VDM";
	extra = xfs.getExtra();
	xfs.getLogical();
	xfs.getProvider();
    }

    /**
     * @return the financialDevice
     */
    public FinancialDevice getFinancialDevice() {
	return financialDevice;
    }

    /**
     * @param financialDevice
     *            the financialDevice to set
     */
    public void setFinancialDevice(FinancialDevice financialDevice) {
	this.financialDevice = financialDevice;
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
     * @return the xfsClass
     */
    public String getXfsClass() {
	return xfsClass;
    }

    /**
     * @param xfsClass
     *            the xfsClass to set
     */
    public void setXfsClass(String xfsClass) {
	this.xfsClass = xfsClass;
    }

    /**
     * @return the acceptMedia
     */
    public Boolean getAcceptMedia() {
	return acceptMedia;
    }

    /**
     * @param acceptMedia
     *            the acceptMedia to set
     */
    public void setAcceptMedia(Boolean acceptMedia) {
	this.acceptMedia = acceptMedia;
    }

    /**
     * @return the algorithms
     */
    public String getAlgorithms() {
	return algorithms;
    }

    /**
     * @param algorithms
     *            the algorithms to set
     */
    public void setAlgorithms(String algorithms) {
	this.algorithms = algorithms;
    }

    /**
     * @return the algorithms as a List<String>
     */
    public List<String> getAlgorithmsSplit() {
	return Utils.splitStrings(algorithms, XfsComponent.separator);
    }

    /**
     * @param algorithms
     *            the algorithms as a List<String> to set
     */
    public void setAlgorithmsSplit(List<String> algorithms) {
	this.algorithms = Utils.concatStrings(algorithms,
		XfsComponent.separator);
    }

    /**
     * @return the auxiliary15
     */
//    public Integer getAuxiliary15() {
//	return auxiliary15;
//    }

    /**
     * @param auxiliary15
     *            the auxiliary15 to set
     */
//    public void setAuxiliary15(Integer auxiliary15) {
//	this.auxiliary15 = auxiliary15;
//    }

    /**
     * @return the auxiliaryAudibleAlarm
     */
//    public Boolean getAuxiliaryAudibleAlarm() {
//	return auxiliaryAudibleAlarm;
//    }

    /**
     * @param auxiliaryAudibleAlarm
     *            the auxiliaryAudibleAlarm to set
     */
//    public void setAuxiliaryAudibleAlarm(Boolean auxiliaryAudibleAlarm) {
//	this.auxiliaryAudibleAlarm = auxiliaryAudibleAlarm;
//    }

    /**
     * @return the auxiliaryEnhancedAudioControl
     */
//    public Boolean getAuxiliaryEnhancedAudioControl() {
//	return auxiliaryEnhancedAudioControl;
//    }

    /**
     * @param auxiliaryEnhancedAudioControl
     *            the auxiliaryEnhancedAudioControl to set
     */
//    public void setAuxiliaryEnhancedAudioControl(
//	    Boolean auxiliaryEnhancedAudioControl) {
//	this.auxiliaryEnhancedAudioControl = auxiliaryEnhancedAudioControl;
//    }

    /**
     * @return the auxiliaryRemoteStatusMonitor
     */
//    public Boolean getAuxiliaryRemoteStatusMonitor() {
//	return auxiliaryRemoteStatusMonitor;
//    }

    /**
     * @param auxiliaryRemoteStatusMonitor
     *            the auxiliaryRemoteStatusMonitor to set
     */
//    public void setAuxiliaryRemoteStatusMonitor(
//	    Boolean auxiliaryRemoteStatusMonitor) {
//	this.auxiliaryRemoteStatusMonitor = auxiliaryRemoteStatusMonitor;
//    }

    /**
     * @return the auxiliaryUps
     */
//    public Boolean getAuxiliaryUps() {
//	return auxiliaryUps;
//    }

    /**
     * @param auxiliaryUps
     *            the auxiliaryUps to set
     */
//    public void setAuxiliaryUps(Boolean auxiliaryUps) {
//	this.auxiliaryUps = auxiliaryUps;
//    }

    /**
     * @return the auxiliaryVolume
     */
//    public Boolean getAuxiliaryVolume() {
//	return auxiliaryVolume;
//    }

    /**
     * @param auxiliaryVolume
     *            the auxiliaryVolume to set
     */
//    public void setAuxiliaryVolume(Boolean auxiliaryVolume) {
//	this.auxiliaryVolume = auxiliaryVolume;
//    }

    /**
     * @return the backImageColorFormat
     */
    public String getBackImageColorFormat() {
	return backImageColorFormat;
    }

    /**
     * @param backImageColorFormat
     *            the backImageColorFormat to set
     */
    public void setBackImageColorFormat(String backImageColorFormat) {
	this.backImageColorFormat = backImageColorFormat;
    }

    /**
     * @return the backImageColorFormat as a List<String>
     */
    public List<String> getBackImageColorFormatSplit() {
	return Utils.splitStrings(backImageColorFormat, XfsComponent.separator);
    }

    /**
     * @param backImageColorFormat
     *            the backImageColorFormat as a List<String> to set
     */
    public void setBackImageColorFormatSplit(List<String> backImageColorFormat) {
	this.backImageColorFormat = Utils.concatStrings(backImageColorFormat,
		XfsComponent.separator);
    }

    /**
     * @return the canOpenSafeDoor
     */
    public Boolean getCanOpenSafeDoor() {
	return canOpenSafeDoor;
    }

    /**
     * @param canOpenSafeDoor
     *            the canOpenSafeDoor to set
     */
    public void setCanOpenSafeDoor(Boolean canOpenSafeDoor) {
	this.canOpenSafeDoor = canOpenSafeDoor;
    }

    /**
     * @return the cards
     */
    public String getCards() {
	return cards;
    }

    /**
     * @param cards
     *            the cards to set
     */
    public void setCards(String cards) {
	this.cards = cards;
    }

    /**
     * @return the cards as a List<String>
     */
    public List<String> getCardsSplit() {
	return Utils.splitStrings(cards, XfsComponent.separator);
    }

    /**
     * @param cards
     *            the cards as a List<String> to set
     */
    public void setCardsSplit(List<String> cards) {
	this.cards = Utils.concatStrings(cards, XfsComponent.separator);
    }

    /**
     * @return the cashUnits
     */
    public String getCashUnits() {
	return cashUnits;
    }

    /**
     * @param cashUnits
     *            the cashUnits to set
     */
    public void setCashUnits(String cashUnits) {
	this.cashUnits = cashUnits;
    }

    /**
     * @return the cashUnits as a List<String>
     */
    public List<String> getCashUnitsSplit() {
	return Utils.splitStrings(cashUnits, XfsComponent.separator);
    }

    /**
     * @param cashUnits
     *            the cashUnits as a List<String> to set
     */
    public void setCashUnitsSplit(List<String> cashUnits) {
	this.cashUnits = Utils.concatStrings(cashUnits, XfsComponent.separator);
    }

    /**
     * @return the cenMajorVersion
     */
    public Integer getCenMajorVersion() {
	return cenMajorVersion;
    }

    /**
     * @return the cenMinorVersion
     */
    public Integer getCenMinorVersion() {
	return cenMinorVersion;
    }

    /**
     * @return the cenBuildVersion
     */
    public Integer getCenBuildVersion() {
	return cenBuildVersion;
    }

    /**
     * @return the cenRevisionVersion
     */
    public Integer getCenRevisionVersion() {
	return cenRevisionVersion;
    }

    /**
     * @return the cenRemainingVersion
     */
    public String getCenRemainingVersion() {
	return cenRemainingVersion;
    }

    /**
     * @param cenMajorVersion
     *            the cenMajorVersion to set
     */
    public void setCenMajorVersion(Integer cenMajorVersion) {
	this.cenMajorVersion = cenMajorVersion;
    }

    /**
     * @param cenMinorVersion
     *            the cenMinorVersion to set
     */
    public void setCenMinorVersion(Integer cenMinorVersion) {
	this.cenMinorVersion = cenMinorVersion;
    }

    /**
     * @param cenBuildVersion
     *            the cenBuildVersion to set
     */
    public void setCenBuildVersion(Integer cenBuildVersion) {
	this.cenBuildVersion = cenBuildVersion;
    }

    /**
     * @param cenRevisionVersion
     *            the cenRevisionVersion to set
     */
    public void setCenRevisionVersion(Integer cenRevisionVersion) {
	this.cenRevisionVersion = cenRevisionVersion;
    }

    /**
     * @param cenRemainingVersion
     *            the cenRemainingVersion to set
     */
    public void setCenRemainingVersion(String cenRemainingVersion) {
	this.cenRemainingVersion = cenRemainingVersion;
    }

    /**
     * @return the Cen version complete
     */
    public String getCenVersion() {
	String version = null;
	if (cenMajorVersion != null) {
	    version = cenMajorVersion.toString();
	    if (cenMinorVersion != null) {
		version += "." + cenMinorVersion.toString();
		if (cenBuildVersion != null) {
		    version += "." + cenBuildVersion.toString();
		    if (cenRevisionVersion != null) {
			version += "." + cenRevisionVersion.toString();
			if (cenRemainingVersion != null) {
			    version += "." + cenRemainingVersion;
			}
		    }
		}
	    }
	} else {
	    if ((cenRemainingVersion != null) && (cenRemainingVersion != "")) {
		version = cenRemainingVersion;
	    }
	}
	return version;
    }

    /**
     * @param version
     *            the complete Cen version to set
     */
    public void setCenVersion(String version) {
	String[] versions = version.split("\\.", 5);
	switch (versions.length) {
	case 5:
	    setCenRemainingVersion(versions[4]);
	case 4:
	    setCenRevisionVersion(new Integer(versions[3]));
	case 3:
	    setCenBuildVersion(new Integer(versions[2]));
	case 2:
	    setCenMinorVersion(new Integer(versions[1]));
	    setCenMajorVersion(new Integer(versions[0]));
	    break;
	case 1:
	    try {
		setCenMajorVersion(new Integer(versions[0]));
	    } catch (NumberFormatException e) {
		setCenRemainingVersion(versions[0]);
	    }
	case 0:
	    break;
	}
    }

    /**
     * @return the charSupport
     */
    public String getCharSupport() {
	return charSupport;
    }

    /**
     * @param charSupport
     *            the charSupport to set
     */
    public void setCharSupport(String charSupport) {
	this.charSupport = charSupport;
    }

    /**
     * @return the chipPower
     */
    public String getChipPower() {
	return chipPower;
    }

    /**
     * @param chipPower
     *            the chipPower to set
     */
    public void setChipPower(String chipPower) {
	this.chipPower = chipPower;
    }

    /**
     * @return the chipPower as a List<String>
     */
    public List<String> getChipPowerSplit() {
	return Utils.splitStrings(cashUnits, XfsComponent.separator);
    }

    /**
     * @param chipPower
     *            the chipPower as a List<String> to set
     */
    public void setChipPowerSplit(List<String> chipPower) {
	this.chipPower = Utils.concatStrings(chipPower, XfsComponent.separator);
    }

    /**
     * @return the chipProtocol
     */
    public String getChipProtocol() {
	return chipProtocol;
    }

    /**
     * @param chipProtocol
     *            the chipProtocol to set
     */
    public void setChipProtocol(String chipProtocol) {
	this.chipProtocol = chipProtocol;
    }

    /**
     * @return the chipProtocol as a List<String>
     */
    public List<String> getChipProtocolSplit() {
	return Utils.splitStrings(chipProtocol, XfsComponent.separator);
    }

    /**
     * @param chipProtocol
     *            the chipProtocol as a List<String> to set
     */
    public void setChipProtocolSplit(List<String> chipProtocol) {
	this.chipProtocol = Utils.concatStrings(chipProtocol,
		XfsComponent.separator);
    }

    /**
     * @return the codeLineFormat
     */
    public String getCodeLineFormat() {
	return codeLineFormat;
    }

    /**
     * @param codeLineFormat
     *            the codeLineFormat to set
     */
    public void setCodeLineFormat(String codeLineFormat) {
	this.codeLineFormat = codeLineFormat;
    }

    /**
     * @return the codeLineFormat as a List<String>
     */
    public List<String> getCodeLineFormatSplit() {
	return Utils.splitStrings(codeLineFormat, XfsComponent.separator);
    }

    /**
     * @param codeLineFormat
     *            the codeLineFormat as a List<String> to set
     */
    public void setCodeLineFormatSplit(List<String> codeLineFormat) {
	this.codeLineFormat = Utils.concatStrings(codeLineFormat,
		XfsComponent.separator);
    }

    /**
     * @return the compound
     */
    public Boolean getCompound() {
	return compound;
    }

    /**
     * @param compound
     *            the compound to set
     */
    public void setCompound(Boolean compound) {
	this.compound = compound;
    }

    /**
     * @return the control
     */
    public String getControl() {
	return control;
    }

    /**
     * @param control
     *            the control to set
     */
    public void setControl(String control) {
	this.control = control;
    }

    /**
     * @return the cursor
     */
    public Boolean getCursor() {
	return cursor;
    }

    /**
     * @param cursor
     *            the cursor to set
     */
    public void setCursor(Boolean cursor) {
	this.cursor = cursor;
    }

    /**
     * @return the derivationAlgorithms
     */
    public String getDerivationAlgorithms() {
	return derivationAlgorithms;
    }

    /**
     * @param derivationAlgorithms
     *            the derivationAlgorithms to set
     */
    public void setDerivationAlgorithms(String derivationAlgorithms) {
	this.derivationAlgorithms = derivationAlgorithms;
    }

    /**
     * @return the derivationAlgorithms as a List<String>
     */
    public List<String> getDerivationAlgorithmsSplit() {
	return Utils.splitStrings(derivationAlgorithms, XfsComponent.separator);
    }

    /**
     * @param derivationAlgorithms
     *            the derivationAlgorithms as a List<String> to set
     */
    public void setDerivationAlgorithmsSplit(List<String> derivationAlgorithms) {
	this.derivationAlgorithms = Utils.concatStrings(derivationAlgorithms,
		XfsComponent.separator);
    }

    /**
     * @return the dispensePaper
     */
    public Boolean getDispensePaper() {
	return dispensePaper;
    }

    /**
     * @param dispensePaper
     *            the dispensePaper to set
     */
    public void setDispensePaper(Boolean dispensePaper) {
	this.dispensePaper = dispensePaper;
    }

    /**
     * @return the display
     */
    public String getDisplay() {
	return display;
    }

    /**
     * @param display
     *            the display to set
     */
    public void setDisplay(String display) {
	this.display = display;
    }

    /**
     * @return the display as a List<String>
     */
    public List<String> getDisplaySplit() {
	return Utils.splitStrings(display, XfsComponent.separator);
    }

    /**
     * @param display
     *            the display as a List<String> to set
     */
    public void setDisplaySplit(List<String> display) {
	this.display = Utils.concatStrings(display, XfsComponent.separator);
    }

    /**
     * @return the displayLight
     */
    public Boolean getDisplayLight() {
	return displayLight;
    }

    /**
     * @param displayLight
     *            the displayLight to set
     */
    public void setDisplayLight(Boolean displayLight) {
	this.displayLight = displayLight;
    }

    /**
     * @return the doorCabinet
     */
//    public Boolean getDoorCabinet() {
//	return doorCabinet;
//    }

    /**
     * @param doorCabinet
     *            the doorCabinet to set
     */
//    public void setDoorCabinet(Boolean doorCabinet) {
//	this.doorCabinet = doorCabinet;
//    }

    /**
     * @return the doorSafe
     */
    public Boolean getDoorSafe() {
    	return doorSafe;
    }

    /**
     * @param doorSafe
     *            the doorSafe to set
     */
    public void setDoorSafe(Boolean doorSafe) {
    	this.doorSafe = doorSafe;
    }

    /**
     * @return the doorSafe as a List<String>
     */
//    public List<String> getDoorSafeSplit() {
//	return Utils.splitStrings(doorSafe, XfsComponent.separator);
//    }

    /**
     * @param doorSafe
     *            the doorSafe as a List<String> to set
     */
//    public void setDoorSafeSplit(List<String> doorSafe) {
//	this.doorSafe = Utils.concatStrings(doorSafe, XfsComponent.separator);
//    }

    /**
     * @return the doorVandalShield
     */
    public Boolean getDoorVandalShield() {
	return doorVandalShield;
    }

    /**
     * @param doorVandalShield
     *            the doorVandalShield to set
     */
    public void setDoorVandalShield(Boolean doorVandalShield) {
	this.doorVandalShield = doorVandalShield;
    }

    /**
     * @return the exchangeTypes
     */
    public String getExchangeTypes() {
	return exchangeTypes;
    }

    /**
     * @param exchangeTypes
     *            the exchangeTypes to set
     */
    public void setExchangeTypes(String exchangeTypes) {
	this.exchangeTypes = exchangeTypes;
    }

    /**
     * @return the exchangeTypes as a List<String>
     */
    public List<String> getExchangeTypesSplit() {
	return Utils.splitStrings(exchangeTypes, XfsComponent.separator);
    }

    /**
     * @param exchangeTypes
     *            the exchangeTypes as a List<String> to set
     */
    public void setExchangeTypesSplit(List<String> exchangeTypes) {
	this.exchangeTypes = Utils.concatStrings(exchangeTypes,
		XfsComponent.separator);
    }

    /**
     * @return the extents
     */
    public String getExtents() {
	return extents;
    }

    /**
     * @param extents
     *            the extents to set
     */
    public void setExtents(String extents) {
	this.extents = extents;
    }

    /**
     * @return the extents as a List<String>
     */
    public List<String> getExtentsSplit() {
	return Utils.splitStrings(extents, XfsComponent.separator);
    }

    /**
     * @param extents
     *            the extents as a List<String> to set
     */
    public void setExtentsSplit(List<String> extents) {
	this.extents = Utils.concatStrings(extents, XfsComponent.separator);
    }

    /**
     * @return the extra
     */
    public String getExtra() {
	return extra;
    }

    /**
     * @param extra
     *            the extra to set
     */
    public void setExtra(String extra) {
	this.extra = extra;
    }

    /**
     * @return the extra as a List<String>
     */
    public List<String> getExtraSplit() {
	return Arrays
		.asList(extra.split(String.valueOf(XfsComponent.separator)));
    }

    /**
     * @param extra
     *            the extra as a List<String> to set
     */
    public void setExtraSplit(List<String> extra) {
	this.extra = Utils.concatStrings(extra, XfsComponent.separator);
    }

    /**
     * @return the flux
     */
    public Boolean getFlux() {
	return flux;
    }

    /**
     * @param flux
     *            the flux to set
     */
    public void setFlux(Boolean flux) {
	this.flux = flux;
    }

    /**
     * @return the forms
     */
    public Boolean getForms() {
	return forms;
    }

    /**
     * @param forms
     *            the forms to set
     */
    public void setForms(Boolean forms) {
	this.forms = forms;
    }

    /**
     * @return the frontImageColorFormat
     */
    public String getFrontImageColorFormat() {
	return frontImageColorFormat;
    }

    /**
     * @param frontImageColorFormat
     *            the frontImageColorFormat to set
     */
    public void setFrontImageColorFormat(String frontImageColorFormat) {
	this.frontImageColorFormat = frontImageColorFormat;
    }

    /**
     * @return the frontImageColorFormat as a List<String>
     */
    public List<String> getFrontImageColorFormatSplit() {
	return Utils
		.splitStrings(frontImageColorFormat, XfsComponent.separator);
    }

    /**
     * @param frontImageColorFormat
     *            the frontImageColorFormat as a List<String> to set
     */
    public void setFrontImageColorFormatSplit(List<String> frontImageColorFormat) {
	this.frontImageColorFormat = Utils.concatStrings(frontImageColorFormat,
		XfsComponent.separator);
    }

    /**
     * @return the guideLightBillAcceptor
     */
//    public Boolean getguideLightBillAcceptor() {
//	return guideLightBillAcceptor;
//    }

    /**
     * @param guideLightBillAcceptor
     *            the guideLightBillAcceptor to set
     */
//    public void setguideLightBillAcceptor(Boolean guideLightBillAcceptor) {
//	this.guideLightBillAcceptor = guideLightBillAcceptor;
//    }

    /**
     * @return the guideLightCardUnit
     */
//    public Boolean getguideLightCardUnit() {
//	return guideLightCardUnit;
//    }

    /**
     * @param guideLightCardUnit
     *            the guideLightCardUnit to set
     */
//    public void setguideLightCardUnit(Boolean guideLightCardUnit) {
//	this.guideLightCardUnit = guideLightCardUnit;
//    }

    /**
     * @return the guideLightChequeUnit
     */
//    public Boolean getguideLightChequeUnit() {
//	return guideLightChequeUnit;
//    }

    /**
     * @param guideLightChequeUnit
     *            the guideLightChequeUnit to set
     */
//    public void setguideLightChequeUnit(Boolean guideLightChequeUnit) {
//	this.guideLightChequeUnit = guideLightChequeUnit;
//    }

    /**
     * @return the guideLightCoinAcceptor
     */
//    public Boolean getguideLightCoinAcceptor() {
//	return guideLightCoinAcceptor;
//    }

    /**
     * @param guideLightCoinAcceptor
     *            the guideLightCoinAcceptor to set
     */
//    public void setguideLightCoinAcceptor(Boolean guideLightCoinAcceptor) {
//	this.guideLightCoinAcceptor = guideLightCoinAcceptor;
//    }

    /**
     * @return the guideLightCoinDispenser
     */
//    public Boolean getguideLightCoinDispenser() {
//	return guideLightCoinDispenser;
//    }

    /**
     * @param guideLightCoinDispenser
     *            the guideLightCoinDispenser to set
     */
//    public void setguideLightCoinDispenser(Boolean guideLightCoinDispenser) {
//	this.guideLightCoinDispenser = guideLightCoinDispenser;
//    }

    /**
     * @return the guideLightDocumentPrinter
     */
//    public Boolean getguideLightDocumentPrinter() {
//	return guideLightDocumentPrinter;
//    }

    /**
     * @param guideLightDocumentPrinter
     *            the guideLightDocumentPrinter to set
     */
//    public void setguideLightDocumentPrinter(Boolean guideLightDocumentPrinter) {
//	this.guideLightDocumentPrinter = guideLightDocumentPrinter;
//    }

    /**
     * @return the guideLightEnvelopeDepository
     */
//    public Boolean getguideLightEnvelopeDepository() {
//	return guideLightEnvelopeDepository;
//    }

    /**
     * @param guideLightEnvelopeDepository
     *            the guideLightEnvelopeDepository to set
     */
//    public void setguideLightEnvelopeDepository(
//	    Boolean guideLightEnvelopeDepository) {
//	this.guideLightEnvelopeDepository = guideLightEnvelopeDepository;
//    }

    /**
     * @return the guideLightEnvelopeDispenser
     */
//    public Boolean getguideLightEnvelopeDispenser() {
//	return guideLightEnvelopeDispenser;
//    }

    /**
     * @param guideLightEnvelopeDispenser
     *            the guideLightEnvelopeDispenser to set
     */
//    public void setguideLightEnvelopeDispenser(
//	    Boolean guideLightEnvelopeDispenser) {
//	this.guideLightEnvelopeDispenser = guideLightEnvelopeDispenser;
//    }

    /**
     * @return the guideLightNoteDispenser
     */
//    public Boolean getguideLightNoteDispenser() {
//	return guideLightNoteDispenser;
//    }

    /**
     * @param guideLightNoteDispenser
     *            the guideLightNoteDispenser to set
     */
//    public void setguideLightNoteDispenser(Boolean guideLightNoteDispenser) {
//	this.guideLightNoteDispenser = guideLightNoteDispenser;
//    }

    /**
     * @return the guideLightPassbookDispenser
     */
//    public Boolean getguideLightPassbookDispenser() {
//	return guideLightPassbookDispenser;
//    }

    /**
     * @param guideLightPassbookDispenser
     *            the guideLightPassbookDispenser to set
     */
//    public void setguideLightPassbookDispenser(
//	    Boolean guideLightPassbookDispenser) {
//	this.guideLightPassbookDispenser = guideLightPassbookDispenser;
//    }

    /**
     * @return the guideLightPinPad
     */
//    public Boolean getguideLightPinPad() {
//	return guideLightPinPad;
//    }

    /**
     * @param guideLightPinPad
     *            the guideLightPinPad to set
     */
//    public void setguideLightPinPad(Boolean guideLightPinPad) {
//	this.guideLightPinPad = guideLightPinPad;
//    }

    /**
     * @return the guideLightReceiptPrinter
     */
//    public Boolean getguideLightReceiptPrinter() {
//	return guideLightReceiptPrinter;
//    }

    /**
     * @param guideLightReceiptPrinter
     *            the guideLightReceiptPrinter to set
     */
//    public void setguideLightReceiptPrinter(Boolean guideLightReceiptPrinter) {
//	this.guideLightReceiptPrinter = guideLightReceiptPrinter;
//    }

    /**
     * @return the guideLightScanner
     */
//    public Boolean getguideLightScanner() {
//	return guideLightScanner;
//    }

    /**
     * @param guideLightScanner
     *            the guideLightScanner to set
     */
//    public void setguideLightScanner(Boolean guideLightScanner) {
//	this.guideLightScanner = guideLightScanner;
//    }

    /**
     * @return the hasCashBox
     */
    public Boolean getHasCashBox() {
	return hasCashBox;
    }

    /**
     * @param hasCashBox
     *            the hasCashBox to set
     */
    public void setHasCashBox(Boolean hasCashBox) {
	this.hasCashBox = hasCashBox;
    }

    /**
     * @return the hasInsertedSensor
     */
    public Boolean getHasInsertedSensor() {
	return hasInsertedSensor;
    }

    /**
     * @param hasInsertedSensor
     *            the hasInsertedSensor to set
     */
    public void setHasInsertedSensor(Boolean hasInsertedSensor) {
	this.hasInsertedSensor = hasInsertedSensor;
    }

    /**
     * @return the hasShutter
     */
    public Boolean getHasShutter() {
	return hasShutter;
    }

    /**
     * @param hasShutter
     *            the hasShutter to set
     */
    public void setHasShutter(Boolean hasShutter) {
	this.hasShutter = hasShutter;
    }

    /**
     * @return the hasTakenSensor
     */
    public Boolean getHasTakenSensor() {
	return hasTakenSensor;
    }

    /**
     * @param hasTakenSensor
     *            the hasTakenSensor to set
     */
    public void setHasTakenSensor(Boolean hasTakenSensor) {
	this.hasTakenSensor = hasTakenSensor;
    }

    /**
     * @return the idConnect
     */
    public Boolean getIdConnect() {
	return idConnect;
    }

    /**
     * @param idConnect
     *            the idConnect to set
     */
    public void setIdConnect(Boolean idConnect) {
	this.idConnect = idConnect;
    }

    /**
     * @return the idKey
     */
    public Integer getIdKey() {
	return idKey;
    }

    /**
     * @param idKey
     *            the idKey to set
     */
    public void setIdKey(Integer idKey) {
	this.idKey = idKey;
    }

    /**
     * @return the imageSource
     */
    public String getImageSource() {
	return imageSource;
    }

    /**
     * @param imageSource
     *            the imageSource to set
     */
    public void setImageSource(String imageSource) {
	this.imageSource = imageSource;
    }

    /**
     * @return the imageSource as a List<String>
     */
    public List<String> getImageSourceSplit() {
	return Utils.splitStrings(imageSource, XfsComponent.separator);
    }

    /**
     * @param imageSource
     *            the imageSource as a List<String> to set
     */
    public void setImageSourceSplit(List<String> imageSource) {
	this.imageSource = Utils.concatStrings(imageSource,
		XfsComponent.separator);
    }

    /**
     * @return the imageType
     */
    public String getImageType() {
	return imageType;
    }

    /**
     * @param imageType
     *            the imageType to set
     */
    public void setImageType(String imageType) {
	this.imageType = imageType;
    }

    /**
     * @return the imageType as a List<String>
     */
    public List<String> getImageTypeSplit() {
	return Utils.splitStrings(imageType, XfsComponent.separator);
    }

    /**
     * @param imageType
     *            the imageType as a List<String> to set
     */
    public void setImageTypeSplit(List<String> imageType) {
	this.imageType = Utils.concatStrings(imageType, XfsComponent.separator);
    }

    /**
     * @return the indicatorAudio
     */
//    public Boolean getIndicatorAudio() {
//	return indicatorAudio;
//    }

    /**
     * @param indicatorAudio
     *            the indicatorAudio to set
     */
//    public void setIndicatorAudio(Boolean indicatorAudio) {
//	this.indicatorAudio = indicatorAudio;
//    }

    /**
     * @return the indicatorFasciaLight
     */
//    public Boolean getIndicatorFasciaLight() {
//	return indicatorFasciaLight;
//    }

    /**
     * @param indicatorFasciaLight
     *            the indicatorFasciaLight to set
     */
//    public void setIndicatorFasciaLight(Boolean indicatorFasciaLight) {
//	this.indicatorFasciaLight = indicatorFasciaLight;
//    }

    /**
     * @return the indicatorHeating
     */
//    public Boolean getIndicatorHeating() {
//	return indicatorHeating;
//    }

    /**
     * @param indicatorHeating
     *            the indicatorHeating to set
     */
//    public void setIndicatorHeating(Boolean indicatorHeating) {
//	this.indicatorHeating = indicatorHeating;
//    }

    /**
     * @return the indicatorOpenClose
     */
//    public Boolean getIndicatorOpenClose() {
//	return indicatorOpenClose;
//    }

    /**
     * @param indicatorOpenClose
     *            the indicatorOpenClose to set
     */
//    public void setIndicatorOpenClose(Boolean indicatorOpenClose) {
//	this.indicatorOpenClose = indicatorOpenClose;
//    }

    /**
     * @return the intermediateStacker
     */
    public Integer getIntermediateStacker() {
	return intermediateStacker;
    }

    /**
     * @param intermediateStacker
     *            the intermediateStacker to set
     */
    public void setIntermediateStacker(Integer intermediateStacker) {
	this.intermediateStacker = intermediateStacker;
    }

    /**
     * @return the keyCheckModes
     */
    public String getKeyCheckModes() {
	return keyCheckModes;
    }

    /**
     * @param keyCheckModes
     *            the keyCheckModes to set
     */
    public void setKeyCheckModes(String keyCheckModes) {
	this.keyCheckModes = keyCheckModes;
    }

    /**
     * @return the keyCheckModes as a List<String>
     */
    public List<String> getKeyCheckModesSplit() {
	return Utils.splitStrings(keyCheckModes, XfsComponent.separator);
    }

    /**
     * @param keyCheckModes
     *            the keyCheckModes as a List<String> to set
     */
    public void setKeyCheckModesSplit(List<String> keyCheckModes) {
	this.keyCheckModes = Utils.concatStrings(keyCheckModes,
		XfsComponent.separator);
    }

    /**
     * @return the keyLock
     */
    public Boolean getKeyLock() {
	return keyLock;
    }

    /**
     * @param keyLock
     *            the keyLock to set
     */
    public void setKeyLock(Boolean keyLock) {
	this.keyLock = keyLock;
    }

    /**
     * @return the keyNum
     */
    public Integer getKeyNum() {
	return keyNum;
    }

    /**
     * @param keyNum
     *            the keyNum to set
     */
    public void setKeyNum(Integer keyNum) {
	this.keyNum = keyNum;
    }

    /**
     * @return the logicalName
     */
    public String getLogicalName() {
	return logicalName;
    }

    /**
     * @param logicalName
     *            the logicalName to set
     */
    public void setLogicalName(String logicalName) {
	this.logicalName = logicalName;
    }

    /**
     * @return the maxCashInItems
     */
    public Integer getMaxCashInItems() {
	return maxCashInItems;
    }

    /**
     * @param maxCashInItems
     *            the maxCashInItems to set
     */
    public void setMaxCashInItems(Integer maxCashInItems) {
	this.maxCashInItems = maxCashInItems;
    }

    /**
     * @return the maxDispenseItems
     */
    public Integer getMaxDispenseItems() {
	return maxDispenseItems;
    }

    /**
     * @param maxDispenseItems
     *            the maxDispenseItems to set
     */
    public void setMaxDispenseItems(Integer maxDispenseItems) {
	this.maxDispenseItems = maxDispenseItems;
    }

    /**
     * @return the maxMediaOnStacker
     */
    public Integer getMaxMediaOnStacker() {
	return maxMediaOnStacker;
    }

    /**
     * @param maxMediaOnStacker
     *            the maxMediaOnStacker to set
     */
    public void setMaxMediaOnStacker(Integer maxMediaOnStacker) {
	this.maxMediaOnStacker = maxMediaOnStacker;
    }

    /**
     * @return the maxRetract
     */
    public Integer getMaxRetract() {
	return maxRetract;
    }

    /**
     * @param maxRetract
     *            the maxRetract to set
     */
    public void setMaxRetract(Integer maxRetract) {
	this.maxRetract = maxRetract;
    }

    /**
     * @return the mediaTaken
     */
    public Boolean getMediaTaken() {
	return mediaTaken;
    }

    /**
     * @param mediaTaken
     *            the mediaTaken to set
     */
    public void setMediaTaken(Boolean mediaTaken) {
	this.mediaTaken = mediaTaken;
    }

    /**
     * @return the multiPage
     */
    public Boolean getMultiPage() {
	return multiPage;
    }

    /**
     * @param multiPage
     *            the multiPage to set
     */
    public void setMultiPage(Boolean multiPage) {
	this.multiPage = multiPage;
    }

    /**
     * @return the numLeds
     */
    public Integer getNumLeds() {
	return numLeds;
    }

    /**
     * @param numLeds
     *            the numLeds to set
     */
    public void setNumLeds(Integer numLeds) {
	this.numLeds = numLeds;
    }

    /**
     * @return the paperSources
     */
    public String getPaperSources() {
	return paperSources;
    }

    /**
     * @param paperSources
     *            the paperSources to set
     */
    public void setPaperSources(String paperSources) {
	this.paperSources = paperSources;
    }

    /**
     * @return the paperSources as a List<String>
     */
    public List<String> getPaperSourcesSplit() {
	return Utils.splitStrings(paperSources, XfsComponent.separator);
    }

    /**
     * @param paperSources
     *            the paperSources as a List<String> to set
     */
    public void setPaperSourcesSplit(List<String> paperSources) {
	this.paperSources = Utils.concatStrings(paperSources,
		XfsComponent.separator);
    }

    /**
     * @return the pinFormats
     */
    public String getPinFormats() {
	return pinFormats;
    }

    /**
     * @param pinFormats
     *            the pinFormats to set
     */
    public void setPinFormats(String pinFormats) {
	this.pinFormats = pinFormats;
    }

    /**
     * @return the pinFormats as a List<String>
     */
    public List<String> getPinFormatsSplit() {
	return Utils.splitStrings(pinFormats, XfsComponent.separator);
    }

    /**
     * @param pinFormats
     *            the pinFormats as a List<String> to set
     */
    public void setPinFormatsSplit(List<String> pinFormats) {
	this.pinFormats = Utils.concatStrings(pinFormats,
		XfsComponent.separator);
    }

    /**
     * @return the powerOff
     */
    public String getPowerOff() {
	return powerOff;
    }

    /**
     * @param powerOff
     *            the powerOff to set
     */
    public void setPowerOff(String powerOff) {
	this.powerOff = powerOff;
    }

    /**
     * @return the powerOn
     */
    public String getPowerOn() {
	return powerOn;
    }

    /**
     * @param powerOn
     *            the powerOn to set
     */
    public void setPowerOn(String powerOn) {
	this.powerOn = powerOn;
    }

    /**
     * @return the presentationAlgorithms
     */
    public String getPresentationAlgorithms() {
	return presentationAlgorithms;
    }

    /**
     * @param presentationAlgorithms
     *            the presentationAlgorithms to set
     */
    public void setPresentationAlgorithms(String presentationAlgorithms) {
	this.presentationAlgorithms = presentationAlgorithms;
    }

    /**
     * @return the presentationAlgorithms as a List<String>
     */
    public List<String> getPresentationAlgorithmsSplit() {
	return Utils.splitStrings(presentationAlgorithms,
		XfsComponent.separator);
    }

    /**
     * @param presentationAlgorithms
     *            the presentationAlgorithms as a List<String> to set
     */
    public void setPresentationAlgorithmsSplit(
	    List<String> presentationAlgorithms) {
	this.presentationAlgorithms = Utils.concatStrings(
		presentationAlgorithms, XfsComponent.separator);
    }

    /**
     * @return the readForm
     */
    public String getReadForm() {
	return readForm;
    }

    /**
     * @param readForm
     *            the readForm to set
     */
    public void setReadForm(String readForm) {
	this.readForm = readForm;
    }

    /**
     * @return the readTracks
     */
    public String getReadTracks() {
	return readTracks;
    }

    /**
     * @param readTracks
     *            the readTracks to set
     */
    public void setReadTracks(String readTracks) {
	this.readTracks = readTracks;
    }

    /**
     * @return the readTracks as a List<String>
     */
    public List<String> getReadTracksSplit() {
	return Utils.splitStrings(readTracks, XfsComponent.separator);
    }

    /**
     * @param readTracks
     *            the readTracks as a List<String> to set
     */
    public void setReadTracksSplit(List<String> readTracks) {
	this.readTracks = Utils.concatStrings(readTracks,
		XfsComponent.separator);
    }

    /**
     * @return the readWriteAfterEject
     */
    public Boolean getReadWriteAfterEject() {
	return readWriteAfterEject;
    }

    /**
     * @param readWriteAfterEject
     *            the readWriteAfterEject to set
     */
    public void setReadWriteAfterEject(Boolean readWriteAfterEject) {
	this.readWriteAfterEject = readWriteAfterEject;
    }

    /**
     * @return the refill
     */
    public Boolean getRefill() {
	return refill;
    }

    /**
     * @param refill
     *            the refill to set
     */
    public void setRefill(Boolean refill) {
	this.refill = refill;
    }

    /**
     * @return the resolution
     */
    public String getResolution() {
	return resolution;
    }

    /**
     * @param resolution
     *            the resolution to set
     */
    public void setResolution(String resolution) {
	this.resolution = resolution;
    }

    /**
     * @return the resolutions
     */
    public String getResolutions() {
	return resolutions;
    }

    /**
     * @param resolutions
     *            the resolutions to set
     */
    public void setResolutions(String resolutions) {
	this.resolutions = resolutions;
    }

    /**
     * @return the retractAreas
     */
    public String getRetractAreas() {
	return retractAreas;
    }

    /**
     * @param retractAreas
     *            the retractAreas to set
     */
    public void setRetractAreas(String retractAreas) {
	this.retractAreas = retractAreas;
    }

    /**
     * @return the retractAreas as a List<String>
     */
    public List<String> getRetractAreasSplit() {
	return Utils.splitStrings(retractAreas, XfsComponent.separator);
    }

    /**
     * @param retractAreas
     *            the retractAreas as a List<String> to set
     */
    public void setRetractAreasSplit(List<String> retractAreas) {
	this.retractAreas = Utils.concatStrings(retractAreas,
		XfsComponent.separator);
    }

    /**
     * @return the retractBins
     */
    public String getRetractBins() {
	return retractBins;
    }

    /**
     * @param retractBins
     *            the retractBins to set
     */
    public void setRetractBins(String retractBins) {
	this.retractBins = retractBins;
    }

    /**
     * @return the retractBins as a List<String>
     */
    public List<String> getRetractBinsSplit() {
	return Utils.splitStrings(retractBins, XfsComponent.separator);
    }

    /**
     * @param retractBins
     *            the retractBins as a List<String> to set
     */
    public void setRetractBinsSplit(List<String> retractBins) {
	this.retractBins = Utils.concatStrings(retractBins,
		XfsComponent.separator);
    }

    /**
     * @return the retractStackerActions
     */
    public String getRetractStackerActions() {
	return retractStackerActions;
    }

    /**
     * @param retractStackerActions
     *            the retractStackerActions to set
     */
    public void setRetractStackerActions(String retractStackerActions) {
	this.retractStackerActions = retractStackerActions;
    }

    /**
     * @return the retractStackerActions as a List<String>
     */
    public List<String> getRetractStackerActionsSplit() {
	return Utils
		.splitStrings(retractStackerActions, XfsComponent.separator);
    }

    /**
     * @param retractStackerActions
     *            the retractStackerActions as a List<String> to set
     */
    public void setRetractStackerActionsSplit(List<String> retractStackerActions) {
	this.retractStackerActions = Utils.concatStrings(retractStackerActions,
		XfsComponent.separator);
    }

    /**
     * @return the retractTransportActions
     */
    public String getRetractTransportActions() {
	return retractTransportActions;
    }

    /**
     * @param retractTransportActions
     *            the retractTransportActions to set
     */
    public void setRetractTransportActions(String retractTransportActions) {
	this.retractTransportActions = retractTransportActions;
    }

    /**
     * @return the retractTransportActions as a List<String>
     */
    public List<String> getRetractTransportActionsSplit() {
	return Utils.splitStrings(retractTransportActions,
		XfsComponent.separator);
    }

    /**
     * @param retractTransportActions
     *            the retractTransportActions as a List<String> to set
     */
    public void setRetractTransportActionsSplit(
	    List<String> retractTransportActions) {
	this.retractTransportActions = Utils.concatStrings(
		retractTransportActions, XfsComponent.separator);
    }

    /**
     * @return the securityType
     */
    public String getSecurityType() {
	return securityType;
    }

    /**
     * @param securityType
     *            the securityType to set
     */
    public void setSecurityType(String securityType) {
	this.securityType = securityType;
    }

    /**
     * @return the sensor30
     */
//    public Integer getSensor30() {
//	return sensor30;
//    }

    /**
     * @param sensor30
     *            the sensor30 to set
     */
//    public void setSensor30(Integer sensor30) {
//	this.sensor30 = sensor30;
//    }

    /**
     * @return the sensor31
     */
//    public Integer getSensor31() {
//	return sensor31;
//    }

    /**
     * @param sensor31
     *            the sensor31 to set
     */
//    public void setSensor31(Integer sensor31) {
//	this.sensor31 = sensor31;
//    }

    /**
     * @return the sensorAmbientLight
     */
//    public Boolean getSensorAmbientLight() {
//	return sensorAmbientLight;
//    }

    /**
     * @param sensorAmbientLight
     *            the sensorAmbientLight to set
     */
//    public void setSensorAmbientLight(Boolean sensorAmbientLight) {
//	this.sensorAmbientLight = sensorAmbientLight;
//    }

    /**
     * @return the sensorEnhancedAudio
     */
//    public Boolean getSensorEnhancedAudio() {
//	return sensorEnhancedAudio;
//    }

    /**
     * @param sensorEnhancedAudio
     *            the sensorEnhancedAudio to set
     */
//    public void setSensorEnhancedAudio(Boolean sensorEnhancedAudio) {
//	this.sensorEnhancedAudio = sensorEnhancedAudio;
//    }

    /**
     * @return the sensorHeat
     */
//    public Boolean getSensorHeat() {
//	return sensorHeat;
//    }

    /**
     * @param sensorHeat
     *            the sensorHeat to set
     */
//    public void setSensorHeat(Boolean sensorHeat) {
//	this.sensorHeat = sensorHeat;
//    }

    /**
     * @return the sensorInternalTamper
     */
//    public Boolean getSensorInternalTamper() {
//	return sensorInternalTamper;
//    }

    /**
     * @param sensorInternalTamper
     *            the sensorInternalTamper to set
     */
//    public void setSensorInternalTamper(Boolean sensorInternalTamper) {
//	this.sensorInternalTamper = sensorInternalTamper;
//    }

    /**
     * @return the sensorOperatorSwitch
     */
//    public String getSensorOperatorSwitch() {
//	return sensorOperatorSwitch;
//    }

    /**
     * @param sensorOperatorSwitch
     *            the sensorOperatorSwitch to set
     */
//    public void setSensorOperatorSwitch(String sensorOperatorSwitch) {
//	this.sensorOperatorSwitch = sensorOperatorSwitch;
//    }

    /**
     * @return the sensorOperatorSwitch as a List<String>
     */
//    public List<String> getSensorOperatorSwitchSplit() {
//	return Utils.splitStrings(sensorOperatorSwitch, XfsComponent.separator);
//    }

    /**
     * @param sensorOperatorSwitch
     *            the sensorOperatorSwitch as a List<String> to set
     */
//    public void setSensorOperatorSwitchSplit(List<String> sensorOperatorSwitch) {
//	this.sensorOperatorSwitch = Utils.concatStrings(sensorOperatorSwitch,
//		XfsComponent.separator);
//    }

    /**
     * @return the sensorProximity
     */
//    public Boolean getSensorProximity() {
//	return sensorProximity;
//    }

    /**
     * @param sensorProximity
     *            the sensorProximity to set
     */
//    public void setSensorProximity(Boolean sensorProximity) {
//	this.sensorProximity = sensorProximity;
//    }

    /**
     * @return the sensorSeismic
     */
//    public Boolean getSensorSeismic() {
//	return sensorSeismic;
//    }

    /**
     * @param sensorSeismic
     *            the sensorSeismic to set
     */
//    public void setSensorSeismic(Boolean sensorSeismic) {
//	this.sensorSeismic = sensorSeismic;
//    }

    /**
     * @return the sensorTamper
     */
//    public Boolean getSensorTamper() {
//	return sensorTamper;
//    }

    /**
     * @param sensorTamper
     *            the sensorTamper to set
     */
//    public void setSensorTamper(Boolean sensorTamper) {
//	this.sensorTamper = sensorTamper;
//    }

    /**
     * @return the serviceProvider
     */
    public String getServiceProvider() {
	return serviceProvider;
    }

    /**
     * @param serviceProvider
     *            the serviceProvider to set
     */
    public void setServiceProvider(String serviceProvider) {
	this.serviceProvider = serviceProvider;
    }

    /**
     * @return the shutterControl
     */
    public Boolean getShutterControl() {
	return shutterControl;
    }

    /**
     * @param shutterControl
     *            the shutterControl to set
     */
    public void setShutterControl(Boolean shutterControl) {
	this.shutterControl = shutterControl;
    }

    /**
     * @return the supportedPositions
     */
    public String getSupportedPositions() {
	return supportedPositions;
    }

    /**
     * @param supportedPositions
     *            the supportedPositions to set
     */
    public void setSupportedPositions(String supportedPositions) {
	this.supportedPositions = supportedPositions;
    }

    /**
     * @return the supportedPositions as a List<String>
     */
    public List<String> getSupportedPositionsSplit() {
	return Utils.splitStrings(supportedPositions, XfsComponent.separator);
    }

    /**
     * @param supportedPositions
     *            the supportedPositions as a List<String> to set
     */
    public void setSupportedPositionsSplit(List<String> supportedPositions) {
	this.supportedPositions = Utils.concatStrings(supportedPositions,
		XfsComponent.separator);
    }

    /**
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the type as a List<String>
     */
    public List<String> getTypeSplit() {
	return Arrays
		.asList(type.split(String.valueOf(XfsComponent.separator)));
    }

    /**
     * @param type
     *            the type as a List<String> to set
     */
    public void setTypeSplit(List<String> type) {
	this.type = Utils.concatStrings(type, XfsComponent.separator);
    }

    /**
     * @return the validationAlgorithms
     */
    public String getValidationAlgorithms() {
	return validationAlgorithms;
    }

    /**
     * @param validationAlgorithms
     *            the validationAlgorithms to set
     */
    public void setValidationAlgorithms(String validationAlgorithms) {
	this.validationAlgorithms = validationAlgorithms;
    }

    /**
     * @return the validationAlgorithms as a List<String>
     */
    public List<String> getValidationAlgorithmsSplit() {
	return Utils.splitStrings(validationAlgorithms, XfsComponent.separator);
    }

    /**
     * @param validationAlgorithms
     *            the validationAlgorithms as a List<String> to set
     */
    public void setValidationAlgorithmsSplit(List<String> validationAlgorithms) {
	this.validationAlgorithms = Utils.concatStrings(validationAlgorithms,
		XfsComponent.separator);
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
	return vendor;
    }

    /**
     * @param vendor
     *            the vendor to set
     */
    public void setVendor(String vendor) {
	this.vendor = vendor;
    }

    /**
     * @return the writeForm
     */
    public String getWriteForm() {
	return writeForm;
    }

    /**
     * @param writeForm
     *            the writeForm to set
     */
    public void setWriteForm(String writeForm) {
	this.writeForm = writeForm;
    }

    /**
     * @return the writeMode
     */
    public String getWriteMode() {
	return writeMode;
    }

    /**
     * @param writeMode
     *            the writeMode to set
     */
    public void setWriteMode(String writeMode) {
	this.writeMode = writeMode;
    }

    /**
     * @return the writeTracks
     */
    public String getWriteTracks() {
	return writeTracks;
    }

    /**
     * @param writeTracks
     *            the writeTracks to set
     */
    public void setWriteTracks(String writeTracks) {
	this.writeTracks = writeTracks;
    }

    /**
     * @return the writeTracks as a List<String>
     */
    public List<String> getWriteTracksSplit() {
	return Utils.splitStrings(writeTracks, XfsComponent.separator);
    }

    /**
     * @param writeTracks
     *            the writeTracks as a List<String> to set
     */
    public void setWriteTracksSplit(List<String> writeTracks) {
	this.writeTracks = Utils.concatStrings(writeTracks,
		XfsComponent.separator);
    }

    /**
     * @return the xfsclasses
     */
    public static Set<String> getXfsclasses() {
	return xfsClasses;
    }

    /**
     * @return the logicalCashUnits
     */
    public Set<LogicalCashUnit> getLogicalCashUnits() {
	return logicalCashUnits;
    }

    /**
     * @param logicalCashUnits
     *            the logicalCashUnits to set
     */
    public void setLogicalCashUnits(Set<LogicalCashUnit> logicalCashUnits) {
	this.logicalCashUnits = logicalCashUnits;
    }

    /**
     * @return the moveItems
     */
    public String getMoveItems() {
	return moveItems;
    }

    /**
     * @param moveItems
     *            the moveItems to set
     */
    public void setMoveItems(String moveItems) {
	this.moveItems = moveItems;
    }

    /**
     * @return the moveItems as a List<String>
     */
    public List<String> getMoveItemsSplit() {
	return Utils.splitStrings(moveItems, XfsComponent.separator);
    }

    /**
     * @param moveItems
     *            the moveItems as a List<String> to set
     */
    public void setMoveItemsSplit(List<String> moveItems) {
	this.moveItems = Utils.concatStrings(moveItems, XfsComponent.separator);
    }

    //EP410008 - 26/02/2013 - Changes in the xfs_component database
    
    /**
     * @return the autofix
     */
	public Boolean getAutofix() {
		return autofix;
	}

    /**
     * @param autofix
     *            the autofix to set
     */
	public void setAutofix(Boolean autofix) {
		this.autofix = autofix;
	}

	/**
     * @return the auxiliaries
     */
	public String getAuxiliaries() {
		return auxiliaries;
	}

	 /**
     * @param auxiliaries
     *            the auxiliaries to set
     */
	public void setAuxiliaries(String auxiliaries) {
		this.auxiliaries = auxiliaries;
	}

	/**
     * @return the cameras
     */
	public String getCameras() {
		return cameras;
	}

	 /**
     * @param cameras
     *            the cameras to set
     */
	public void setCameras(String cameras) {
		this.cameras = cameras;
	}

	/**
     * @return the camdata
     */
	public String getCamdata() {
		return camdata;
	}

	 /**
     * @param camdata
     *            the camdata to set
     */
	public void setCamdata(String camdata) {
		this.camdata = camdata;
	}

	/**
     * @return the chipio
     */
	public Boolean getChipio() {
		return chipio;
	}

	 /**
     * @param chipio
     *            the chipio to set
     */
	public void setChipio(Boolean chipio) {
		this.chipio = chipio;
	}

	/**
     * @return the comparemagneticstripe
     */
	public Boolean getComparemagneticstripe() {
		return comparemagneticstripe;
	}

	 /**
     * @param comparemagneticstripe
     *            the comparemagneticstripe to set
     */
	public void setComparemagneticstripe(Boolean comparemagneticstripe) {
		this.comparemagneticstripe = comparemagneticstripe;
	}

	/**
     * @return the deptransport
     */
	public Boolean getDeptransport() {
		return deptransport;
	}

	 /**
     * @param deptransport
     *            the deptransport to set
     */
	public void setDeptransport(Boolean deptransport) {
		this.deptransport = deptransport;
	}

	/**
     * @return the doors
     */
	public String getDoors() {
		return doors;
	}

	 /**
     * @param doors
     *            the doors to set
     */
	public void setDoors(String doors) {
		this.doors = doors;
	}

	/**
     * @return the encoder
     */
	public Boolean getEncoder() {
		return encoder;
	}

	 /**
     * @param encoder
     *            the encoder to set
     */
	public void setEncoder(Boolean encoder) {
		this.encoder = encoder;
	}

	/**
     * @return the encodenames
     */
	public String getEncodenames() {
		return encodenames;
	}

	 /**
     * @param encodenames
     *            the encodenames to set
     */
	public void setEncodenames(String encodenames) {
		this.encodenames = encodenames;
	}

	/**
     * @return the envelopesupply
     */
	public String getEnvelopesupply() {
		return envelopesupply;
	}

	 /**
     * @param envelopesupply
     *            the envelopesupply to set
     */
	public void setEnvelopesupply(String envelopesupply) {
		this.envelopesupply = envelopesupply;
	}

	/**
     * @return the endorser
     */
	public Boolean getEndorser() {
		return endorser;
	}

	 /**
     * @param endorser
     *            the endorser to set
     */
	public void setEndorser(Boolean endorser) {
		this.endorser = endorser;
	}

	/**
     * @return the fontnames
     */
	public String getFontnames() {
		return fontnames;
	}

	 /**
     * @param fontnames
     *            the fontnames to set
     */
	public void setFontnames(String fontnames) {
		this.fontnames = fontnames;
	}

	/**
     * @return the guidlight
     */
	public String getGuidlights() {
		return guidlights;
	}

	 /**
     * @param guidlights
     *            the guidlights to set
     */
	public void setGuidlights(String guidlights) {
		this.guidlights = guidlights;
	}

	/**
     * @return the imagecapture
     */
	public String getImagecapture() {
		return imagecapture;
	}

	 /**
     * @param imagecapture
     *            the imagecapture to set
     */
	public void setImagecapture(String imagecapture) {
		this.imagecapture = imagecapture;
	}

	/**
     * @return the indicators
     */
	public String getIndicators() {
		return indicators;
	}

	 /**
     * @param indicators
     *            the indicators to set
     */
	public void setIndicators(String indicators) {
		this.indicators = indicators;
	}

	/**
     * @return the magneticstriperead
     */
	public Boolean getMagneticstriperead() {
		return magneticstriperead;
	}

	 /**
     * @param magneticstriperead
     *            the magneticstriperead to set
     */
	public void setMagneticstriperead(Boolean magneticstriperead) {
		this.magneticstriperead = magneticstriperead;
	}

	/**
     * @return the magneticstripewrite
     */
	public Boolean getMagneticstripewrite() {
		return magneticstripewrite;
	}

	 /**
     * @param magneticstripewrite
     *            the magneticstripewrite to set
     */
	public void setMagneticstripewrite(Boolean magneticstripewrite) {
		this.magneticstripewrite = magneticstripewrite;
	}

	/**
     * @return the maxdatalength
     */
	public Integer getMaxdatalength() {
		return maxdatalength;
	}

	 /**
     * @param maxdatalength
     *            the maxdatalength to set
     */
	public void setMaxdatalength(Integer maxdatalength) {
		this.maxdatalength = maxdatalength;
	}

	/**
     * @return the maxnumchars
     */
	public Integer getMaxnumchars() {
		return maxnumchars;
	}

	 /**
     * @param maxnumchars
     *            the maxnumchars to set
     */
	public void setMaxnumchars(Integer maxnumchars) {
		this.maxnumchars = maxnumchars;
	}

	/**
     * @return the maxpictures
     */
	public Integer getMaxpictures() {
		return maxpictures;
	}

	 /**
     * @param maxpictures
     *            the maxpictures to set
     */
	public void setMaxpictures(Integer maxpictures) {
		this.maxpictures = maxpictures;
	}

	/**
     * @return the micr
     */
	public Boolean getMicr() {
		return micr;
	}

	 /**
     * @param micr
     *            the micr to set
     */
	public void setMicr(Boolean micr) {
		this.micr = micr;
	}

	/**
     * @return the ocr
     */
	public Boolean getOcr() {
		return ocr;
	}

	 /**
     * @param ocr
     *            the ocr to set
     */
	public void setOcr(Boolean ocr) {
		this.ocr = ocr;
	}

	/**
     * @return the printer
     */
	public Boolean getPrinter() {
		return printer;
	}

	 /**
     * @param printer
     *            the printer to set
     */
	public void setPrinter(Boolean printer) {
		this.printer = printer;
	}

	/**
     * @return the printonretracts
     */
	public Boolean getPrintonretracts() {
		return printonretracts;
	}

	 /**
     * @param printonretracts
     *            the printonretracts to set
     */
	public void setPrintonretracts(Boolean printonretracts) {
		this.printonretracts = printonretracts;
	}

	/**
     * @return the programaticallydeactivate
     */
	public Boolean getProgramaticallydeactivate() {
		return programaticallydeactivate;
	}

	 /**
     * @param programaticallydeactivate
     *            the programaticallydeactivate to set
     */
	public void setProgramaticallydeactivate(Boolean programaticallydeactivate) {
		this.programaticallydeactivate = programaticallydeactivate;
	}

	/**
     * @return the retractenvelope
     */
	public String getRetractenvelope() {
		return retractenvelope;
	}

	 /**
     * @param retractenvelope
     *            the retractenvelope to set
     */
	public void setRetractenvelope(String retractenvelope) {
		this.retractenvelope = retractenvelope;
	}

	/**
     * @return the sensors
     */
	public String getSensors() {
		return sensors;
	}

	 /**
     * @param sensors
     *            the sensors to set
     */
	public void setSensors(String sensors) {
		this.sensors = sensors;
	}

	/**
     * @return the stamp
     */
	public String getStamp() {
		return stamp;
	}

	 /**
     * @param stamp
     *            the stamp to set
     */
	public void setStamp(String stamp) {
		this.stamp = stamp;
	}

	/**
     * @return the toner
     */
	public Boolean getToner() {
		return toner;
	}

	 /**
     * @param toner
     *            the toner to set
     */
	public void setToner(Boolean toner) {
		this.toner = toner;
	}
}