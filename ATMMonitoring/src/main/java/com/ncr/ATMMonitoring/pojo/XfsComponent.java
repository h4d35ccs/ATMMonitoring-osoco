package com.ncr.ATMMonitoring.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
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
 * The XfsComponent Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "xfs_components")
public class XfsComponent {

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;
    
    /** The Constant xfsClasses. */
    private static final Set<String> xfsClasses;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> boolOperations = Operation
		.getOperationsByType(Operation.DataType.BOOLEAN);
	Map<String, Map> numOperations = Operation
		.getOperationsByType(Operation.DataType.NUMBER);
	comboboxes.put("xfsClass", stringOperations);
	comboboxes.put("acceptMedia", boolOperations);
	comboboxes.put("algorithms", stringOperations);
	comboboxes.put("autobeep", stringOperations);
	comboboxes.put("autodeposit", boolOperations);
	comboboxes.put("autoretractPeriod", numOperations);
	comboboxes.put("auxiliaries", stringOperations);
	comboboxes.put("backImageColorFormat", stringOperations);
	comboboxes.put("backscanColor", stringOperations);
	comboboxes.put("cameras", stringOperations);
	comboboxes.put("camdata", stringOperations);
	comboboxes.put("canFilterSymbologies", boolOperations);
	comboboxes.put("cards", numOperations);
	comboboxes.put("cashin", boolOperations);
	comboboxes.put("charSupport", stringOperations);
	comboboxes.put("chipio", boolOperations);
	comboboxes.put("chipPower", stringOperations);
	comboboxes.put("chipProtocol", stringOperations);
	comboboxes.put("codeLineFormat", stringOperations);
	comboboxes.put("coins", boolOperations);
	comboboxes.put("compound", boolOperations);
	comboboxes.put("comparemagneticstripe", boolOperations);
	comboboxes.put("control", stringOperations);
	comboboxes.put("cursor", boolOperations);
	comboboxes.put("cylinders", boolOperations);
	comboboxes.put("defaultBackscanColor", stringOperations);
	comboboxes.put("defaultFrontscanColor", stringOperations);
	comboboxes.put("deptransport", boolOperations);
	comboboxes.put("derivationAlgorithms", stringOperations);
	comboboxes.put("isPrepareDispense", stringOperations);
	comboboxes.put("dipMode", stringOperations);
	comboboxes.put("dispenseTo", stringOperations);
	comboboxes.put("display", stringOperations);
	comboboxes.put("displayLight", boolOperations);
	comboboxes.put("doors", stringOperations);
	comboboxes.put("ejectPosition", stringOperations);
	comboboxes.put("emvHashAlgorithm", stringOperations);
	comboboxes.put("emvImportSchemes", stringOperations);
	comboboxes.put("encioProtocols", stringOperations);
	comboboxes.put("encoder", boolOperations);
	comboboxes.put("encodenames", stringOperations);
	comboboxes.put("endorser", boolOperations);
	comboboxes.put("envelopesupply", stringOperations);
	comboboxes.put("exchangeTypes", stringOperations);
	comboboxes.put("extents", stringOperations);
	comboboxes.put("extra", stringOperations);
	comboboxes.put("fontnames", stringOperations);
	comboboxes.put("forms", boolOperations);
	comboboxes.put("frontImageColorFormat", stringOperations);
	comboboxes.put("frontscanColor", stringOperations);
	comboboxes.put("guidlights", stringOperations);
	comboboxes.put("hasCashBox", boolOperations);
	comboboxes.put("hasInsertedSensor", boolOperations);
	comboboxes.put("hasShutter", boolOperations);
	comboboxes.put("hasTakenSensor", boolOperations);
	comboboxes.put("hsmVendor", stringOperations);
	comboboxes.put("idConnect", boolOperations);
	comboboxes.put("idKey", stringOperations);
	comboboxes.put("imagecapture", stringOperations);
	comboboxes.put("imageSource", stringOperations);
	comboboxes.put("imageType", stringOperations);
	comboboxes.put("indicators", stringOperations);
	comboboxes.put("insertOrientation", stringOperations);
	comboboxes.put("intermediateStacker", numOperations);
	comboboxes.put("isApplicationRefuse", boolOperations);
	comboboxes.put("isAutofeed", boolOperations);
	comboboxes.put("isCardTakenSensor", boolOperations);
	comboboxes.put("isCompareSignatures", boolOperations);
	comboboxes.put("isHsmJournaling", boolOperations);
	comboboxes.put("isIntermediateStacker", boolOperations);
	comboboxes.put("isItemsTakenSensor", boolOperations);
	comboboxes.put("isKeyImportThroughParts", boolOperations);
	comboboxes.put("isMediaPresented", boolOperations);
	comboboxes.put("isPinCanPersistAfterUse", boolOperations);
	comboboxes.put("isPresentControl", boolOperations);
	comboboxes.put("isRescan", boolOperations);
	comboboxes.put("isRetractCountsItems", boolOperations);
	comboboxes.put("isRetractToTransport", boolOperations);
	comboboxes.put("isSafeDoor", boolOperations);
	comboboxes.put("isSetPinBlockDataRequired", boolOperations);
	comboboxes.put("isStamp", boolOperations);
	comboboxes.put("isTypeCombined", boolOperations);
	comboboxes.put("itemInfoTypes", stringOperations);
	comboboxes.put("keyBlockImportFormats", stringOperations);
	comboboxes.put("keyCheckModes", stringOperations);
	comboboxes.put("keyLock", boolOperations);
	comboboxes.put("keyNum", numOperations);
	comboboxes.put("keys", stringOperations);
	comboboxes.put("logical", stringOperations);
	comboboxes.put("magneticstriperead", boolOperations);
	comboboxes.put("magneticstripewrite", boolOperations);
	comboboxes.put("max2Retract", numOperations);
	comboboxes.put("maxBills", numOperations);
	comboboxes.put("maxCashInItems", numOperations);
	comboboxes.put("maxCoins", numOperations);
	comboboxes.put("maxDataLength", numOperations);
	comboboxes.put("maxDispenseItems", numOperations);
	comboboxes.put("maxMediaOnStacker", numOperations);
	comboboxes.put("maxNumChars", numOperations);
	comboboxes.put("maxPictures", numOperations);
	comboboxes.put("maxRetract", stringOperations);
	comboboxes.put("mediaTaken", boolOperations);
	comboboxes.put("memoryChipProtocols", stringOperations);
	comboboxes.put("micr", boolOperations);
	comboboxes.put("moveItems", stringOperations);
	comboboxes.put("multiPage", boolOperations);
	comboboxes.put("numLeds", numOperations);
	comboboxes.put("ocr", stringOperations);
	comboboxes.put("outputPositions",stringOperations);
	comboboxes.put("paperSources", stringOperations);
	comboboxes.put("pinFormats", stringOperations);
	comboboxes.put("pockets", numOperations);
	comboboxes.put("powerOff", stringOperations);
	comboboxes.put("powerOn", stringOperations);
	comboboxes.put("powerSaveControl", boolOperations);
	comboboxes.put("presentationAlgorithms", stringOperations);
	comboboxes.put("printer", boolOperations);
	comboboxes.put("printOnRetracts", boolOperations);
	comboboxes.put("printSize", stringOperations);
	comboboxes.put("programaticallyDeactivate", boolOperations);
	comboboxes.put("provider", stringOperations);
	comboboxes.put("readForm", stringOperations);
	comboboxes.put("readTracks", stringOperations);
	comboboxes.put("refill", boolOperations);
	comboboxes.put("resetControl", stringOperations);
	comboboxes.put("resolutions", stringOperations);
	comboboxes.put("retract", boolOperations);
	comboboxes.put("retractAreas", stringOperations);
	comboboxes.put("retractBins", stringOperations);
	comboboxes.put("retractenvelope", stringOperations);
	comboboxes.put("retractStackerActions", stringOperations);
	comboboxes.put("retractTransportActions", stringOperations);
	comboboxes.put("retractToDeposit", boolOperations);
	comboboxes.put("rsaAuthenticationScheme", stringOperations);
	comboboxes.put("rsaCryptAlgorithm", stringOperations);
	comboboxes.put("rsaKeycheckMode", stringOperations);
	comboboxes.put("rsaSignatureAlgorithm", stringOperations);
	comboboxes.put("securityType", stringOperations);
	comboboxes.put("sensors", stringOperations);
	comboboxes.put("shutterControl", boolOperations);
	comboboxes.put("signatureScheme", stringOperations);
	comboboxes.put("stamp", stringOperations);
	comboboxes.put("positions", stringOperations);
	comboboxes.put("symbologies", stringOperations);
	comboboxes.put("toner", boolOperations);
	comboboxes.put("type", stringOperations);
	comboboxes.put("validationAlgorithms", stringOperations);
	comboboxes.put("vandalCheck", boolOperations);
	comboboxes.put("windowsPrinter", stringOperations);
	comboboxes.put("writeForm", stringOperations);
	comboboxes.put("writeMode", stringOperations);
	comboboxes.put("writeTracks", stringOperations);

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

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xfs_components_id_seq")
    @SequenceGenerator(name = "xfs_components_id_seq", sequenceName = "xfs_components_id_seq", allocationSize = 1)
    private Integer id;

    /** The financial devices. */
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.REFRESH)
    @JoinTable(name = "financial_device_xfs_component", joinColumns = { @JoinColumn(name = "xfs_component_id") }, inverseJoinColumns = { @JoinColumn(name = "financial_device_id") })
    private List<FinancialDevice> financialDevices = new ArrayList<FinancialDevice>();

    /** The logical cash units. */
    @OneToMany(mappedBy = "xfsComponent", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("type")
    private List<LogicalCashUnit> logicalCashUnits = new ArrayList<LogicalCashUnit>();

    /** The xfs class. */
    @Column(name = "xfs_class", length = 50, nullable = false)
    private String xfsClass;

    /** The accept media. */
    @Column(name = "accept_media")
    private Boolean acceptMedia;

    /** The algorithms. */
    @Column(name = "algorithms")
    @Type(type = "text")
    private String algorithms;
    
    /** The autobeep. */
    @Column(name = "autobeep")
    @Type(type = "text")
    private String autobeep;

    /** The autodeposit. */
    @Column(name = "autodeposit")
    private Boolean autodeposit;

    /** The autoretract period. */
    @Column(name = "autoretract_period")
    private Integer autoretractPeriod;

    /** The auxiliaries. */
    @Column(name = "auxiliaries")
    @Type(type = "text")
    private String auxiliaries;

    /** The back image color format. */
    @Column(name = "back_image_color_format")
    @Type(type = "text")
    private String backImageColorFormat;

    /** The backscan color. */
    @Column(name = "backscan_color")
    @Type(type = "text")
    private String backscanColor;
    
    /** The cameras. */
    @Column(name = "cameras")
    @Type(type = "text")
    private String cameras;

    /** The camdata. */
    @Column(name = "cam_data")
    @Type(type = "text")
    private String camdata;

    /** The cards. */
    @Column(name = "cards")
    private Integer cards;
    
    /** The cashin. */
    @Column(name = "cash_in")
    private Boolean cashin;

    /** The char support. */
    @Column(name = "char_support")
    @Type(type = "text")
    private String charSupport;
    
    /** The chipio. */
    @Column(name = "chip_io")
    private Boolean chipio;

    /** The chip power. */
    @Column(name = "chip_power")
    @Type(type = "text")
    private String chipPower;

    /** The chip protocol. */
    @Column(name = "chip_protocol")
    @Type(type = "text")
    private String chipProtocol;

    /** The code line format. */
    @Column(name = "code_line_format")
    @Type(type = "text")
    private String codeLineFormat;

    /** The coins. */
    @Column(name = "coins")
    private Boolean coins;

    /** The compound. */
    @Column(name = "compound")
    private Boolean compound;
    
    /** The comparemagneticstripe. */
    @Column(name = "compare_magnetic_stripe")
    private Boolean comparemagneticstripe;

    /** The control. */
    @Column(name = "control")
    @Type(type = "text")
    private String control;

    /** The cursor. */
    @Column(name = "cursor")
    private Boolean cursor;

    /** The cylinders. */
    @Column(name = "cylinders")
    private Boolean cylinders;

    /** The default backscan color. */
    @Column(name = "default_backscan_color")
    @Type(type = "text")
    private String defaultBackscanColor;

    /** The default frontscan color. */
    @Column(name = "default_frontscan_color")
    @Type(type = "text")
    private String defaultFrontscanColor;
    
    /** The deptransport. */
    @Column(name = "dep_transport")
    private Boolean deptransport;

    /** The derivation algorithms. */
    @Column(name = "derivation_algorithms")
    @Type(type = "text")
    private String derivationAlgorithms;

    /** The is prepare dispense. */
    @Column(name = "is_prepare_dispense")
    private Boolean isPrepareDispense;

    /** The dip mode. */
    @Column(name = "dip_mode")
    @Type(type = "text")
    private String dipMode;

    /** The dispense to. */
    @Column(name = "dispense_to")
    @Type(type = "text")
    private String dispenseTo;

    /** The display. */
    @Column(name = "display")
    @Type(type = "text")
    private String display;

    /** The display light. */
    @Column(name = "display_light")
    private Boolean displayLight;
    
    /** The doors. */
    @Column(name = "doors")
    @Type(type = "text")
    private String doors;

    /** The eject position. */
    @Column(name = "eject_position")
    @Type(type = "text")
    private String ejectPosition;

    /** The emv hash algorithm. */
    @Column(name = "emv_hash_algorithm")
    @Type(type = "text")
    private String emvHashAlgorithm;

    /** The emv import schemes. */
    @Column(name = "emv_import_schemes")
    @Type(type = "text")
    private String emvImportSchemes;

    /** The encio protocols. */
    @Column(name = "encio_protocols")
    @Type(type = "text")
    private String encioProtocols;

    /** The encoder. */
    @Column(name = "encoder")
    private Boolean encoder;

    /** The encodenames. */
    @Column(name = "encode_names")
    @Type(type = "text")
    private String encodenames;

    /** The endorser. */
    @Column(name = "endorser")
    private Boolean endorser;

    /** The envelopesupply. */
    @Column(name = "envelope_supply")
    @Type(type = "text")
    private String envelopesupply;

    /** The exchange types. */
    @Column(name = "exchange_types")
    @Type(type = "text")
    private String exchangeTypes;

    /** The extents. */
    @Column(name = "extents")
    @Type(type = "text")
    private String extents;

    /** The extra. */
    @Column(name = "extra")
    @Type(type = "text")
    private String extra;

    /** The fontnames. */
    @Column(name = "font_names")
    @Type(type = "text")
    private String fontnames;

    /** The forms. */
    @Column(name = "forms")
    private Boolean forms;

    /** The front image color format. */
    @Column(name = "front_image_color_format")
    @Type(type = "text")
    private String frontImageColorFormat;

    /** The frontscan color. */
    @Column(name = "frontscan_color")
    @Type(type = "text")
    private String frontscanColor;
    
    /** The guidlights. */
    @Column(name = "guidlights")
    @Type(type = "text")
    private String guidlights;

    /** The has cash box. */
    @Column(name = "has_cash_box")
    private Boolean hasCashBox;

    /** The has inserted sensor. */
    @Column(name = "has_inserted_sensor")
    private Boolean hasInsertedSensor;

    /** The has shutter. */
    @Column(name = "has_shutter")
    private Boolean hasShutter;

    /** The has taken sensor. */
    @Column(name = "has_taken_sensor")
    private Boolean hasTakenSensor;

    /** The hsm vendor. */
    @Column(name = "hsm_vendor")
    @Type(type = "text")
    private String hsmVendor;

    /** The id connect. */
    @Column(name = "id_connect")
    private Boolean idConnect;
    
    /** The id key. */
    @Column(name = "id_key")
    @Type(type = "text")
    private String idKey;

    /** The imagecapture. */
    @Column(name = "image_capture")
    @Type(type = "text")
    private String imagecapture;

    /** The image source. */
    @Column(name = "image_source")
    @Type(type = "text")
    private String imageSource;

    /** The image type. */
    @Column(name = "image_type")
    @Type(type = "text")
    private String imageType;
    
    /** The indicators. */
    @Column(name = "indicators")
    @Type(type = "text")
    private String indicators;
    
    /** The insert orientation. */
    @Column(name = "insert_orientation")
    @Type(type = "text")
    private String insertOrientation;

    /** The intermediate stacker. */
    @Column(name = "intermediate_stacker")
    private Integer intermediateStacker;

    /** The is application refuse. */
    @Column(name = "is_application_refuse")
    private Boolean isApplicationRefuse;

    /** The is autofeed. */
    @Column(name = "is_autofeed")
    private Boolean isAutofeed;

    /** The is card taken sensor. */
    @Column(name = "is_card_taken_sensor")
    private Boolean isCardTakenSensor;

    /** The is compare signatures. */
    @Column(name = "is_compare_signatures")
    private Boolean isCompareSignatures;

    /** The is hsm journaling. */
    @Column(name = "is_hsm_journaling")
    private Boolean isHsmJournaling;

    /** The is intermediate stacker. */
    @Column(name = "is_intermediate_stacker")
    private Boolean isIntermediateStacker;

    /** The is items taken sensor. */
    @Column(name = "is_items_taken_sensor")
    private Boolean isItemsTakenSensor;

    /** The is key import through parts. */
    @Column(name = "is_key_import_through_parts")
    private Boolean isKeyImportThroughParts;

    /** The is media presented. */
    @Column(name = "is_media_presented")
    private Boolean isMediaPresented;

    /** The is pin can persist after use. */
    @Column(name = "is_pin_can_persist_after_use")
    private Boolean isPinCanPersistAfterUse;

    /** The is present control. */
    @Column(name = "is_present_control")
    private Boolean isPresentControl;

    /** The is rescan. */
    @Column(name = "is_rescan")
    private Boolean isRescan;

    /** The is retract counts items. */
    @Column(name = "is_retract_counts_items")
    private Boolean isRetractCountsItems;

    /** The is retract to transport. */
    @Column(name = "is_retract_to_transport")
    private Boolean isRetractToTransport;

    /** The is safe door. */
    @Column(name = "is_safe_door")
    private Boolean isSafeDoor;

    /** The is set pin block data required. */
    @Column(name = "is_set_pin_block_data_requited")
    private Boolean isSetPinBlockDataRequired;

    /** The is stamp. */
    @Column(name = "is_stamp")
    private Boolean isStamp;

    /** The is type combined. */
    @Column(name = "is_type_combined")
    private Boolean isTypeCombined;

    /** The item info types. */
    @Column(name = "item_info_types")
    @Type(type = "text")
    private String itemInfoTypes;

    /** The key block import formats. */
    @Column(name = "key_block_import_formats")
    @Type(type = "text")
    private String keyBlockImportFormats;

    /** The key check modes. */
    @Column(name = "key_check_modes")
    @Type(type = "text")
    private String keyCheckModes;

    /** The key lock. */
    @Column(name = "key_lock")
    private Boolean keyLock;

    /** The key num. */
    @Column(name = "key_num")
    private Integer keyNum;

    /** The keys. */
    @Column(name = "keys")
    @Type(type = "text")
    private String keys;

    /** The logical. */
    @Column(name = "logical")
    @Type(type = "text")
    private String logical;
    
    /** The magneticstriperead. */
    @Column(name = "magnetic_stripe_read")
    private Boolean magneticstriperead;

    /** The magneticstripewrite. */
    @Column(name = "magnetic_stripe_write")
    private Boolean magneticstripewrite;

    /** The max 2 retract. */
    @Column(name = "max_2_retract")
    private Integer max2Retract;

    /** The max bills. */
    @Column(name = "max_bills")
    private Integer maxBills;

    /** The max cash in items. */
    @Column(name = "max_cash_in_items")
    private Integer maxCashInItems;

    /** The max coins. */
    @Column(name = "max_coins")
    private Integer maxCoins;
    
    /** The max data length. */
    @Column(name = "max_data_length")
    private Integer maxDataLength;

    /** The max dispense items. */
    @Column(name = "max_dispense_items")
    private Integer maxDispenseItems;

    /** The max media on stacker. */
    @Column(name = "max_media_on_stacker")
    private Integer maxMediaOnStacker;
    
    /** The max num chars. */
    @Column(name = "max_num_chars")
    private Integer maxNumChars;

    /** The max pictures. */
    @Column(name = "max_pictures")
    private Integer maxPictures;

    /** The max retract. */
    @Column(name = "max_retract")
    @Type(type = "text")
    private String maxRetract;

    /** The media taken. */
    @Column(name = "media_taken")
    private Boolean mediaTaken;

    /** The memory chip protocols. */
    @Column(name = "memory_chip_protocols")
    @Type(type = "text")
    private String memoryChipProtocols;
    
    /** The micr. */
    @Column(name = "micr")
    private Boolean micr;

    /** The move items. */
    @Column(name = "move_items")
    @Type(type = "text")
    private String moveItems;

    /** The multi page. */
    @Column(name = "multi_page")
    private Boolean multiPage;

    /** The num leds. */
    @Column(name = "num_leds")
    private Integer numLeds;
    
    /** The ocr. */
    @Column(name = "ocr")
    private Boolean ocr;

    /** The output positions. */
    @Column(name = "output_positions")
    @Type(type = "text")
    private String outputPositions;

    /** The paper sources. */
    @Column(name = "paper_sources")
    @Type(type = "text")
    private String paperSources;

    /** The pin formats. */
    @Column(name = "pin_formats")
    @Type(type = "text")
    private String pinFormats;

    /** The pockets. */
    @Column(name = "pockets")
    private Integer pockets;

    /** The power off. */
    @Column(name = "power_off")
    @Type(type = "text")
    private String powerOff;

    /** The power on. */
    @Column(name = "power_on")
    @Type(type = "text")
    private String powerOn;

    /** The power save control. */
    @Column(name = "power_save_control")
    private Boolean powerSaveControl;

    /** The presentation algorithms. */
    @Column(name = "presentation_algorithms")
    @Type(type = "text")
    private String presentationAlgorithms;
    
    /** The printer. */
    @Column(name = "printer")
    private Boolean printer;

    /** The print on retracts. */
    @Column(name = "print_on_retracts")
    private Boolean printOnRetracts;

    /** The print size. */
    @Column(name = "print_size")
    @Type(type = "text")
    private String printSize;

    /** The programatically deactivate. */
    @Column(name = "programatically_deactivate")
    private Boolean programaticallyDeactivate;

    /** The provider. */
    @Column(name = "provider")
    @Type(type = "text")
    private String provider;

    /** The read form. */
    @Column(name = "read_form")
    @Type(type = "text")
    private String readForm;

    /** The read tracks. */
    @Column(name = "read_tracks")
    @Type(type = "text")
    private String readTracks;

    /** The refill. */
    @Column(name = "refill")
    private Boolean refill;

    /** The reset control. */
    @Column(name = "reset_control")
    @Type(type = "text")
    private String resetControl;

    /** The resolutions. */
    @Column(name = "resolutions")
    @Type(type = "text")
    private String resolutions;
    
    /** The retract. */
    @Column(name = "retract")
    private Boolean retract;

    /** The retract areas. */
    @Column(name = "retract_areas")
    @Type(type = "text")
    private String retractAreas;

    /** The retract bins. */
    @Column(name = "retract_bins")
    @Type(type = "text")
    private String retractBins;
    
    /** The retractenvelope. */
    @Column(name = "retract_envelope")
    @Type(type = "text")
    private String retractenvelope;

    /** The retract stacker actions. */
    @Column(name = "retract_stacker_actions")
    @Type(type = "text")
    private String retractStackerActions;

    /** The retract to deposit. */
    @Column(name = "retract_to_deposit")
    private Boolean retractToDeposit;

    /** The retract transport actions. */
    @Column(name = "retract_transport_actions")
    @Type(type = "text")
    private String retractTransportActions;

    /** The rsa authentication scheme. */
    @Column(name = "rsa_auth_scheme")
    @Type(type = "text")
    private String rsaAuthenticationScheme;

    /** The rsa crypt algorithm. */
    @Column(name = "rsa_crypt_algorithm")
    @Type(type = "text")
    private String rsaCryptAlgorithm;

    /** The rsa keycheck mode. */
    @Column(name = "rsa_keycheck_mode")
    @Type(type = "text")
    private String rsaKeycheckMode;

    /** The rsa signature algorithm. */
    @Column(name = "rsa_signature_algorithm")
    @Type(type = "text")
    private String rsaSignatureAlgorithm;

    /** The security type. */
    @Column(name = "security_type")
    @Type(type = "text")
    private String securityType;
    
    /** The sensors. */
    @Column(name = "sensors")
    @Type(type = "text")
    private String sensors;

    /** The shutter control. */
    @Column(name = "shutter_control")
    private Boolean shutterControl;
    
    /** The signature scheme. */
    @Column(name = "signature_scheme")
    @Type(type = "text")
    private String signatureScheme;

    /** The stamp. */
    @Column(name = "stamp")
    @Type(type = "text")
    private String stamp;

    /** The positions. */
    @Column(name = "positions")
    @Type(type = "text")
    private String positions;

    /** The symbologies. */
    @Column(name = "symbologies")
    @Type(type = "text")
    private String symbologies;

    /** The can filter symbologies. */
    @Column(name = "can_filter_symbologies")
    private Boolean canFilterSymbologies;
    
    /** The toner. */
    @Column(name = "toner")
    private Boolean toner;

    /** The type. */
    @Column(name = "type")
    @Type(type = "text")
    private String type;

    /** The validation algorithms. */
    @Column(name = "validation_algorithms")
    @Type(type = "text")
    private String validationAlgorithms;

    /** The vandal check. */
    @Column(name = "vandal_check")
    private Boolean vandalCheck;

    /** The windows printer. */
    @Column(name = "windows_printer")
    @Type(type = "text")
    private String windowsPrinter;

    /** The write form. */
    @Column(name = "write_form")
    @Type(type = "text")
    private String writeForm;

    /** The write mode. */
    @Column(name = "write_mode")
    @Type(type = "text")
    private String writeMode;

    /** The write tracks. */
    @Column(name = "write_tracks")
    @Type(type = "text")
    private String writeTracks;

    /**
     * Instantiates a new xfs component.
     */
    public XfsComponent() {
    }

    /**
     * Instantiates a new xfs component based on ALM data from the agent.
     * 
     * @param xfs
     *            the ALM
     */
    public XfsComponent(ALM xfs) {
	xfsClass = "ALM";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	programaticallyDeactivate = xfs.isProgramaticallydeactivate();
    }

    /**
     * Instantiates a new xfs component based on BCR data from the agent.
     * 
     * @param xfs
     *            the BCR
     */
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

    /**
     * Instantiates a new xfs component based on CAM data from the agent.
     * 
     * @param xfs
     *            the CAM
     */
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

    /**
     * Instantiates a new xfs component based on CDM data from the agent.
     * 
     * @param xfs
     *            the CDM
     */
    public XfsComponent(CDM xfs) {
	xfsClass = "CDM";
	//EP410008 - 28/01/2014
	retract = xfs.isRetract();
	cashin = xfs.isCashin();
	//<--
	exchangeTypes = xfs.getExchangetype();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	maxBills = xfs.getMaxbills();
	maxCoins = xfs.getMaxcoins();
	maxDispenseItems = xfs.getMaxdispenseitems();
	moveItems = xfs.getMoveitems();
	outputPositions = xfs.getOutputpositions();
	positions = xfs.getPositions();
	provider = xfs.getProvider();
	retractAreas = xfs.getRetractareas();
	retractStackerActions = xfs.getRetractstackeractions();
	retractTransportActions = xfs.getRetracttransportactions();
	type = xfs.getType();
	autodeposit = xfs.isAutodeposit();
	hasCashBox = xfs.isCashbox();
	coins = xfs.isCoins();
	compound = xfs.isCompound();
	cylinders = xfs.isCylinders();
	isIntermediateStacker = xfs.isIntermediatestacker();
	hasTakenSensor = xfs.isItemstakensensor();
	powerSaveControl = xfs.isPowersavecontrol();
	isPrepareDispense = xfs.isPreparedispense();
	refill = xfs.isRefill();
	isSafeDoor = xfs.isSafedoor();
	hasShutter = xfs.isShutter();
	shutterControl = xfs.isShuttercontrol();
	vandalCheck = xfs.isVandalcheck();
    }

    /**
     * Instantiates a new xfs component based on CEU data from the agent.
     * 
     * @param xfs
     *            the CEU
     */
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

    /**
     * Instantiates a new xfs component based on CHK data from the agent.
     * 
     * @param xfs
     *            the CHK
     */
    public XfsComponent(CHK xfs) {
	xfsClass = "CHK";
	charSupport = xfs.getCharsupport();
	encodenames = xfs.getEncodenames();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	fontnames = xfs.getFontnames();
	guidlights = xfs.getGuidlights();
	imagecapture = xfs.getImagecapture();
	logical = xfs.getLogical();
	pockets = xfs.getPockets();
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

    /**
     * Instantiates a new xfs component based on CIM data from the agent.
     * 
     * @param xfs
     *            the CIM
     */
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

    /**
     * Instantiates a new xfs component based on CRD data from the agent.
     * 
     * @param xfs
     *            the CRD
     */
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

    /**
     * Instantiates a new xfs component based on DEP data from the agent.
     * 
     * @param xfs
     *            the DEP
     */
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
	retractToDeposit = xfs.isRetracttodeposit();
	hasShutter = xfs.isShutter();
	toner = xfs.isToner();
    }

    /**
     * Instantiates a new xfs component based on IDC data from the agent.
     * 
     * @param xfs
     *            the IDC
     */
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

    /**
     * Instantiates a new xfs component based on IPM data from the agent.
     * 
     * @param xfs
     *            the IPM
     */
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

    /**
     * Instantiates a new xfs component based on PIN data from the agent.
     * 
     * @param xfs
     *            the PIN
     */
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

    /**
     * Instantiates a new xfs component based on PTR data from the agent.
     * 
     * @param xfs
     *            the PTR
     */
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
	max2Retract = xfs.getMax2retract();
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

    /**
     * Instantiates a new xfs component based on SIU data from the agent.
     * 
     * @param xfs
     *            the SIU
     */
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

    /**
     * Instantiates a new xfs component based on TTU data from the agent.
     * 
     * @param xfs
     *            the TTU
     */
    public XfsComponent(TTU xfs) {
	xfsClass = "TTU";
	charSupport = xfs.getCharsupport();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	keys = xfs.getKeys();
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

    /**
     * Instantiates a new xfs component based on VDM data from the agent.
     * 
     * @param xfs
     *            the VDM
     */
    public XfsComponent(VDM xfs) {
	xfsClass = "VDM";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
    }

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
     * @param id the new id
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the financial devices.
     *
     * @return the financial devices
     */
    public List<FinancialDevice> getFinancialDevices() {
	return financialDevices;
    }

    /**
     * Sets the financial devices.
     *
     * @param financialDevices the new financial devices
     */
    public void setFinancialDevices(List<FinancialDevice> financialDevices) {
	this.financialDevices = financialDevices;
    }

    /**
     * Gets the logical cash units.
     *
     * @return the logical cash units
     */
    public List<LogicalCashUnit> getLogicalCashUnits() {
	return logicalCashUnits;
    }

    /**
     * Sets the logical cash units.
     *
     * @param logicalCashUnits the new logical cash units
     */
    public void setLogicalCashUnits(List<LogicalCashUnit> logicalCashUnits) {
	this.logicalCashUnits = logicalCashUnits;
    }

    /**
     * Gets the xfs class.
     *
     * @return the xfs class
     */
    public String getXfsClass() {
	return xfsClass;
    }

    /**
     * Sets the xfs class.
     *
     * @param xfsClass the new xfs class
     */
    public void setXfsClass(String xfsClass) {
	this.xfsClass = xfsClass;
    }

    /**
     * Gets the accept media.
     *
     * @return the accept media
     */
    public Boolean getAcceptMedia() {
	return acceptMedia;
    }

    /**
     * Sets the accept media.
     *
     * @param acceptMedia the new accept media
     */
    public void setAcceptMedia(Boolean acceptMedia) {
	this.acceptMedia = acceptMedia;
    }

    /**
     * Gets the algorithms.
     *
     * @return the algorithms
     */
    public String getAlgorithms() {
	return algorithms;
    }

    /**
     * Sets the algorithms.
     *
     * @param algorithms the new algorithms
     */
    public void setAlgorithms(String algorithms) {
	this.algorithms = algorithms;
    }

    /**
     * Gets the autobeep.
     *
     * @return the autobeep
     */
    public String getAutobeep() {
	return autobeep;
    }

    /**
     * Sets the autobeep.
     *
     * @param autobeep the new autobeep
     */
    public void setAutobeep(String autobeep) {
	this.autobeep = autobeep;
    }

    /**
     * Gets the autoretract period.
     *
     * @return the autoretract period
     */
    public Integer getAutoretractPeriod() {
	return autoretractPeriod;
    }

    /**
     * Sets the autoretract period.
     *
     * @param autoretractPeriod the new autoretract period
     */
    public void setAutoretractPeriod(Integer autoretractPeriod) {
	this.autoretractPeriod = autoretractPeriod;
    }

    /**
     * Gets the auxiliaries.
     *
     * @return the auxiliaries
     */
    public String getAuxiliaries() {
	return auxiliaries;
    }

    /**
     * Sets the auxiliaries.
     *
     * @param auxiliaries the new auxiliaries
     */
    public void setAuxiliaries(String auxiliaries) {
	this.auxiliaries = auxiliaries;
    }

    /**
     * Gets the back image color format.
     *
     * @return the back image color format
     */
    public String getBackImageColorFormat() {
	return backImageColorFormat;
    }

    /**
     * Sets the back image color format.
     *
     * @param backImageColorFormat the new back image color format
     */
    public void setBackImageColorFormat(String backImageColorFormat) {
	this.backImageColorFormat = backImageColorFormat;
    }

    /**
     * Gets the backscan color.
     *
     * @return the backscan color
     */
    public String getBackscanColor() {
	return backscanColor;
    }

    /**
     * Sets the backscan color.
     *
     * @param backscanColor the new backscan color
     */
    public void setBackscanColor(String backscanColor) {
	this.backscanColor = backscanColor;
    }

    /**
     * Gets the cameras.
     *
     * @return the cameras
     */
    public String getCameras() {
	return cameras;
    }

    /**
     * Sets the cameras.
     *
     * @param cameras the new cameras
     */
    public void setCameras(String cameras) {
	this.cameras = cameras;
    }

    /**
     * Gets the camdata.
     *
     * @return the camdata
     */
    public String getCamdata() {
	return camdata;
    }

    /**
     * Sets the camdata.
     *
     * @param camdata the new camdata
     */
    public void setCamdata(String camdata) {
	this.camdata = camdata;
    }

    /**
     * Gets the cards.
     *
     * @return the cards
     */
    public Integer getCards() {
	return cards;
    }

    /**
     * Sets the cards.
     *
     * @param cards the new cards
     */
    public void setCards(Integer cards) {
	this.cards = cards;
    }

    /**
     * Gets the char support.
     *
     * @return the char support
     */
    public String getCharSupport() {
	return charSupport;
    }

    /**
     * Sets the char support.
     *
     * @param charSupport the new char support
     */
    public void setCharSupport(String charSupport) {
	this.charSupport = charSupport;
    }

    /**
     * Gets the chipio.
     *
     * @return the chipio
     */
    public Boolean getChipio() {
	return chipio;
    }

    /**
     * Sets the chipio.
     *
     * @param chipio the new chipio
     */
    public void setChipio(Boolean chipio) {
	this.chipio = chipio;
    }

    /**
     * Gets the chip power.
     *
     * @return the chip power
     */
    public String getChipPower() {
	return chipPower;
    }

    /**
     * Sets the chip power.
     *
     * @param chipPower the new chip power
     */
    public void setChipPower(String chipPower) {
	this.chipPower = chipPower;
    }

    /**
     * Gets the chip protocol.
     *
     * @return the chip protocol
     */
    public String getChipProtocol() {
	return chipProtocol;
    }

    /**
     * Sets the chip protocol.
     *
     * @param chipProtocol the new chip protocol
     */
    public void setChipProtocol(String chipProtocol) {
	this.chipProtocol = chipProtocol;
    }

    /**
     * Gets the code line format.
     *
     * @return the code line format
     */
    public String getCodeLineFormat() {
	return codeLineFormat;
    }

    /**
     * Sets the code line format.
     *
     * @param codeLineFormat the new code line format
     */
    public void setCodeLineFormat(String codeLineFormat) {
	this.codeLineFormat = codeLineFormat;
    }

    /**
     * Gets the compound.
     *
     * @return the compound
     */
    public Boolean getCompound() {
	return compound;
    }

    /**
     * Sets the compound.
     *
     * @param compound the new compound
     */
    public void setCompound(Boolean compound) {
	this.compound = compound;
    }

    /**
     * Gets the comparemagneticstripe.
     *
     * @return the comparemagneticstripe
     */
    public Boolean getComparemagneticstripe() {
	return comparemagneticstripe;
    }

    /**
     * Sets the comparemagneticstripe.
     *
     * @param comparemagneticstripe the new comparemagneticstripe
     */
    public void setComparemagneticstripe(Boolean comparemagneticstripe) {
	this.comparemagneticstripe = comparemagneticstripe;
    }

    /**
     * Gets the control.
     *
     * @return the control
     */
    public String getControl() {
	return control;
    }

    /**
     * Sets the control.
     *
     * @param control the new control
     */
    public void setControl(String control) {
	this.control = control;
    }

    /**
     * Gets the cursor.
     *
     * @return the cursor
     */
    public Boolean getCursor() {
	return cursor;
    }

    /**
     * Sets the cursor.
     *
     * @param cursor the new cursor
     */
    public void setCursor(Boolean cursor) {
	this.cursor = cursor;
    }

    /**
     * Gets the default backscan color.
     *
     * @return the default backscan color
     */
    public String getDefaultBackscanColor() {
	return defaultBackscanColor;
    }

    /**
     * Sets the default backscan color.
     *
     * @param defaultBackscanColor the new default backscan color
     */
    public void setDefaultBackscanColor(String defaultBackscanColor) {
	this.defaultBackscanColor = defaultBackscanColor;
    }

    /**
     * Gets the default frontscan color.
     *
     * @return the default frontscan color
     */
    public String getDefaultFrontscanColor() {
	return defaultFrontscanColor;
    }

    /**
     * Sets the default frontscan color.
     *
     * @param defaultFrontscanColor the new default frontscan color
     */
    public void setDefaultFrontscanColor(String defaultFrontscanColor) {
	this.defaultFrontscanColor = defaultFrontscanColor;
    }

    /**
     * Gets the deptransport.
     *
     * @return the deptransport
     */
    public Boolean getDeptransport() {
	return deptransport;
    }

    /**
     * Sets the deptransport.
     *
     * @param deptransport the new deptransport
     */
    public void setDeptransport(Boolean deptransport) {
	this.deptransport = deptransport;
    }

    /**
     * Gets the derivation algorithms.
     *
     * @return the derivation algorithms
     */
    public String getDerivationAlgorithms() {
	return derivationAlgorithms;
    }

    /**
     * Sets the derivation algorithms.
     *
     * @param derivationAlgorithms the new derivation algorithms
     */
    public void setDerivationAlgorithms(String derivationAlgorithms) {
	this.derivationAlgorithms = derivationAlgorithms;
    }

    /**
     * Gets the checks if is prepare dispense.
     *
     * @return the checks if is prepare dispense
     */
    public Boolean getIsPrepareDispense() {
	return isPrepareDispense;
    }

    /**
     * Sets the checks if is prepare dispense.
     *
     * @param isPrepareDispense the new checks if is prepare dispense
     */
    public void setIsPrepareDispense(Boolean isPrepareDispense) {
	this.isPrepareDispense = isPrepareDispense;
    }

    /**
     * Gets the dip mode.
     *
     * @return the dip mode
     */
    public String getDipMode() {
	return dipMode;
    }

    /**
     * Sets the dip mode.
     *
     * @param dipMode the new dip mode
     */
    public void setDipMode(String dipMode) {
	this.dipMode = dipMode;
    }

    /**
     * Gets the dispense to.
     *
     * @return the dispense to
     */
    public String getDispenseTo() {
	return dispenseTo;
    }

    /**
     * Sets the dispense to.
     *
     * @param dispenseTo the new dispense to
     */
    public void setDispenseTo(String dispenseTo) {
	this.dispenseTo = dispenseTo;
    }

    /**
     * Gets the display.
     *
     * @return the display
     */
    public String getDisplay() {
	return display;
    }

    /**
     * Sets the display.
     *
     * @param display the new display
     */
    public void setDisplay(String display) {
	this.display = display;
    }

    /**
     * Gets the display light.
     *
     * @return the display light
     */
    public Boolean getDisplayLight() {
	return displayLight;
    }

    /**
     * Sets the display light.
     *
     * @param displayLight the new display light
     */
    public void setDisplayLight(Boolean displayLight) {
	this.displayLight = displayLight;
    }

    /**
     * Gets the doors.
     *
     * @return the doors
     */
    public String getDoors() {
	return doors;
    }

    /**
     * Sets the doors.
     *
     * @param doors the new doors
     */
    public void setDoors(String doors) {
	this.doors = doors;
    }

    /**
     * Gets the eject position.
     *
     * @return the eject position
     */
    public String getEjectPosition() {
	return ejectPosition;
    }

    /**
     * Sets the eject position.
     *
     * @param ejectPosition the new eject position
     */
    public void setEjectPosition(String ejectPosition) {
	this.ejectPosition = ejectPosition;
    }

    /**
     * Gets the emv hash algorithm.
     *
     * @return the emv hash algorithm
     */
    public String getEmvHashAlgorithm() {
	return emvHashAlgorithm;
    }

    /**
     * Sets the emv hash algorithm.
     *
     * @param emvHashAlgorithm the new emv hash algorithm
     */
    public void setEmvHashAlgorithm(String emvHashAlgorithm) {
	this.emvHashAlgorithm = emvHashAlgorithm;
    }

    /**
     * Gets the emv import schemes.
     *
     * @return the emv import schemes
     */
    public String getEmvImportSchemes() {
	return emvImportSchemes;
    }

    /**
     * Sets the emv import schemes.
     *
     * @param emvImportSchemes the new emv import schemes
     */
    public void setEmvImportSchemes(String emvImportSchemes) {
	this.emvImportSchemes = emvImportSchemes;
    }

    /**
     * Gets the encio protocols.
     *
     * @return the encio protocols
     */
    public String getEncioProtocols() {
	return encioProtocols;
    }

    /**
     * Sets the encio protocols.
     *
     * @param encioProtocols the new encio protocols
     */
    public void setEncioProtocols(String encioProtocols) {
	this.encioProtocols = encioProtocols;
    }

    /**
     * Gets the encoder.
     *
     * @return the encoder
     */
    public Boolean getEncoder() {
	return encoder;
    }

    /**
     * Sets the encoder.
     *
     * @param encoder the new encoder
     */
    public void setEncoder(Boolean encoder) {
	this.encoder = encoder;
    }

    /**
     * Gets the encodenames.
     *
     * @return the encodenames
     */
    public String getEncodenames() {
	return encodenames;
    }

    /**
     * Sets the encodenames.
     *
     * @param encodenames the new encodenames
     */
    public void setEncodenames(String encodenames) {
	this.encodenames = encodenames;
    }

    /**
     * Gets the endorser.
     *
     * @return the endorser
     */
    public Boolean getEndorser() {
	return endorser;
    }

    /**
     * Sets the endorser.
     *
     * @param endorser the new endorser
     */
    public void setEndorser(Boolean endorser) {
	this.endorser = endorser;
    }

    /**
     * Gets the envelopesupply.
     *
     * @return the envelopesupply
     */
    public String getEnvelopesupply() {
	return envelopesupply;
    }

    /**
     * Sets the envelopesupply.
     *
     * @param envelopesupply the new envelopesupply
     */
    public void setEnvelopesupply(String envelopesupply) {
	this.envelopesupply = envelopesupply;
    }

    /**
     * Gets the exchange types.
     *
     * @return the exchange types
     */
    public String getExchangeTypes() {
	return exchangeTypes;
    }

    /**
     * Sets the exchange types.
     *
     * @param exchangeTypes the new exchange types
     */
    public void setExchangeTypes(String exchangeTypes) {
	this.exchangeTypes = exchangeTypes;
    }

    /**
     * Gets the extents.
     *
     * @return the extents
     */
    public String getExtents() {
	return extents;
    }

    /**
     * Sets the extents.
     *
     * @param extents the new extents
     */
    public void setExtents(String extents) {
	this.extents = extents;
    }

    /**
     * Gets the extra.
     *
     * @return the extra
     */
    public String getExtra() {
	return extra;
    }

    /**
     * Sets the extra.
     *
     * @param extra the new extra
     */
    public void setExtra(String extra) {
	this.extra = extra;
    }

    /**
     * Gets the fontnames.
     *
     * @return the fontnames
     */
    public String getFontnames() {
	return fontnames;
    }

    /**
     * Sets the fontnames.
     *
     * @param fontnames the new fontnames
     */
    public void setFontnames(String fontnames) {
	this.fontnames = fontnames;
    }

    /**
     * Gets the forms.
     *
     * @return the forms
     */
    public Boolean getForms() {
	return forms;
    }

    /**
     * Sets the forms.
     *
     * @param forms the new forms
     */
    public void setForms(Boolean forms) {
	this.forms = forms;
    }

    /**
     * Gets the front image color format.
     *
     * @return the front image color format
     */
    public String getFrontImageColorFormat() {
	return frontImageColorFormat;
    }

    /**
     * Sets the front image color format.
     *
     * @param frontImageColorFormat the new front image color format
     */
    public void setFrontImageColorFormat(String frontImageColorFormat) {
	this.frontImageColorFormat = frontImageColorFormat;
    }

    /**
     * Gets the frontscan color.
     *
     * @return the frontscan color
     */
    public String getFrontscanColor() {
	return frontscanColor;
    }

    /**
     * Sets the frontscan color.
     *
     * @param frontscanColor the new frontscan color
     */
    public void setFrontscanColor(String frontscanColor) {
	this.frontscanColor = frontscanColor;
    }

    /**
     * Gets the guidlights.
     *
     * @return the guidlights
     */
    public String getGuidlights() {
	return guidlights;
    }

    /**
     * Sets the guidlights.
     *
     * @param guidlights the new guidlights
     */
    public void setGuidlights(String guidlights) {
	this.guidlights = guidlights;
    }

    /**
     * Gets the checks for cash box.
     *
     * @return the checks for cash box
     */
    public Boolean getHasCashBox() {
	return hasCashBox;
    }

    /**
     * Sets the checks for cash box.
     *
     * @param hasCashBox the new checks for cash box
     */
    public void setHasCashBox(Boolean hasCashBox) {
	this.hasCashBox = hasCashBox;
    }

    /**
     * Gets the checks for inserted sensor.
     *
     * @return the checks for inserted sensor
     */
    public Boolean getHasInsertedSensor() {
	return hasInsertedSensor;
    }

    /**
     * Sets the checks for inserted sensor.
     *
     * @param hasInsertedSensor the new checks for inserted sensor
     */
    public void setHasInsertedSensor(Boolean hasInsertedSensor) {
	this.hasInsertedSensor = hasInsertedSensor;
    }

    /**
     * Gets the checks for shutter.
     *
     * @return the checks for shutter
     */
    public Boolean getHasShutter() {
	return hasShutter;
    }

    /**
     * Sets the checks for shutter.
     *
     * @param hasShutter the new checks for shutter
     */
    public void setHasShutter(Boolean hasShutter) {
	this.hasShutter = hasShutter;
    }

    /**
     * Gets the checks for taken sensor.
     *
     * @return the checks for taken sensor
     */
    public Boolean getHasTakenSensor() {
	return hasTakenSensor;
    }

    /**
     * Sets the checks for taken sensor.
     *
     * @param hasTakenSensor the new checks for taken sensor
     */
    public void setHasTakenSensor(Boolean hasTakenSensor) {
	this.hasTakenSensor = hasTakenSensor;
    }

    /**
     * Gets the hsm vendor.
     *
     * @return the hsm vendor
     */
    public String getHsmVendor() {
	return hsmVendor;
    }

    /**
     * Sets the hsm vendor.
     *
     * @param hsmVendor the new hsm vendor
     */
    public void setHsmVendor(String hsmVendor) {
	this.hsmVendor = hsmVendor;
    }

    /**
     * Gets the id connect.
     *
     * @return the id connect
     */
    public Boolean getIdConnect() {
	return idConnect;
    }

    /**
     * Sets the id connect.
     *
     * @param idConnect the new id connect
     */
    public void setIdConnect(Boolean idConnect) {
	this.idConnect = idConnect;
    }

    /**
     * Gets the id key.
     *
     * @return the id key
     */
    public String getIdKey() {
	return idKey;
    }

    /**
     * Sets the id key.
     *
     * @param idKey the new id key
     */
    public void setIdKey(String idKey) {
	this.idKey = idKey;
    }

    /**
     * Gets the imagecapture.
     *
     * @return the imagecapture
     */
    public String getImagecapture() {
	return imagecapture;
    }

    /**
     * Sets the imagecapture.
     *
     * @param imagecapture the new imagecapture
     */
    public void setImagecapture(String imagecapture) {
	this.imagecapture = imagecapture;
    }

    /**
     * Gets the image source.
     *
     * @return the image source
     */
    public String getImageSource() {
	return imageSource;
    }

    /**
     * Sets the image source.
     *
     * @param imageSource the new image source
     */
    public void setImageSource(String imageSource) {
	this.imageSource = imageSource;
    }

    /**
     * Gets the image type.
     *
     * @return the image type
     */
    public String getImageType() {
	return imageType;
    }

    /**
     * Sets the image type.
     *
     * @param imageType the new image type
     */
    public void setImageType(String imageType) {
	this.imageType = imageType;
    }

    /**
     * Gets the indicators.
     *
     * @return the indicators
     */
    public String getIndicators() {
	return indicators;
    }

    /**
     * Sets the indicators.
     *
     * @param indicators the new indicators
     */
    public void setIndicators(String indicators) {
	this.indicators = indicators;
    }

    /**
     * Gets the insert orientation.
     *
     * @return the insert orientation
     */
    public String getInsertOrientation() {
	return insertOrientation;
    }

    /**
     * Sets the insert orientation.
     *
     * @param insertOrientation the new insert orientation
     */
    public void setInsertOrientation(String insertOrientation) {
	this.insertOrientation = insertOrientation;
    }

    /**
     * Gets the intermediate stacker.
     *
     * @return the intermediate stacker
     */
    public Integer getIntermediateStacker() {
	return intermediateStacker;
    }

    /**
     * Sets the intermediate stacker.
     *
     * @param intermediateStacker the new intermediate stacker
     */
    public void setIntermediateStacker(Integer intermediateStacker) {
	this.intermediateStacker = intermediateStacker;
    }

    /**
     * Gets the checks if is application refuse.
     *
     * @return the checks if is application refuse
     */
    public Boolean getIsApplicationRefuse() {
	return isApplicationRefuse;
    }

    /**
     * Sets the checks if is application refuse.
     *
     * @param isApplicationRefuse the new checks if is application refuse
     */
    public void setIsApplicationRefuse(Boolean isApplicationRefuse) {
	this.isApplicationRefuse = isApplicationRefuse;
    }

    /**
     * Gets the checks if is autofeed.
     *
     * @return the checks if is autofeed
     */
    public Boolean getIsAutofeed() {
	return isAutofeed;
    }

    /**
     * Sets the checks if is autofeed.
     *
     * @param isAutofeed the new checks if is autofeed
     */
    public void setIsAutofeed(Boolean isAutofeed) {
	this.isAutofeed = isAutofeed;
    }

    /**
     * Gets the checks if is card taken sensor.
     *
     * @return the checks if is card taken sensor
     */
    public Boolean getIsCardTakenSensor() {
	return isCardTakenSensor;
    }

    /**
     * Sets the checks if is card taken sensor.
     *
     * @param isCardTakenSensor the new checks if is card taken sensor
     */
    public void setIsCardTakenSensor(Boolean isCardTakenSensor) {
	this.isCardTakenSensor = isCardTakenSensor;
    }

    /**
     * Gets the checks if is compare signatures.
     *
     * @return the checks if is compare signatures
     */
    public Boolean getIsCompareSignatures() {
	return isCompareSignatures;
    }

    /**
     * Sets the checks if is compare signatures.
     *
     * @param isCompareSignatures the new checks if is compare signatures
     */
    public void setIsCompareSignatures(Boolean isCompareSignatures) {
	this.isCompareSignatures = isCompareSignatures;
    }

    /**
     * Gets the checks if is hsm journaling.
     *
     * @return the checks if is hsm journaling
     */
    public Boolean getIsHsmJournaling() {
	return isHsmJournaling;
    }

    /**
     * Sets the checks if is hsm journaling.
     *
     * @param isHsmJournaling the new checks if is hsm journaling
     */
    public void setIsHsmJournaling(Boolean isHsmJournaling) {
	this.isHsmJournaling = isHsmJournaling;
    }

    /**
     * Gets the checks if is intermediate stacker.
     *
     * @return the checks if is intermediate stacker
     */
    public Boolean getIsIntermediateStacker() {
	return isIntermediateStacker;
    }

    /**
     * Sets the checks if is intermediate stacker.
     *
     * @param isIntermediateStacker the new checks if is intermediate stacker
     */
    public void setIsIntermediateStacker(Boolean isIntermediateStacker) {
	this.isIntermediateStacker = isIntermediateStacker;
    }

    /**
     * Gets the checks if is items taken sensor.
     *
     * @return the checks if is items taken sensor
     */
    public Boolean getIsItemsTakenSensor() {
	return isItemsTakenSensor;
    }

    /**
     * Sets the checks if is items taken sensor.
     *
     * @param isItemsTakenSensor the new checks if is items taken sensor
     */
    public void setIsItemsTakenSensor(Boolean isItemsTakenSensor) {
	this.isItemsTakenSensor = isItemsTakenSensor;
    }

    /**
     * Gets the checks if is key import through parts.
     *
     * @return the checks if is key import through parts
     */
    public Boolean getIsKeyImportThroughParts() {
	return isKeyImportThroughParts;
    }

    /**
     * Sets the checks if is key import through parts.
     *
     * @param isKeyImportThroughParts the new checks if is key import through parts
     */
    public void setIsKeyImportThroughParts(Boolean isKeyImportThroughParts) {
	this.isKeyImportThroughParts = isKeyImportThroughParts;
    }

    /**
     * Gets the checks if is media presented.
     *
     * @return the checks if is media presented
     */
    public Boolean getIsMediaPresented() {
	return isMediaPresented;
    }

    /**
     * Sets the checks if is media presented.
     *
     * @param isMediaPresented the new checks if is media presented
     */
    public void setIsMediaPresented(Boolean isMediaPresented) {
	this.isMediaPresented = isMediaPresented;
    }

    /**
     * Gets the checks if is pin can persist after use.
     *
     * @return the checks if is pin can persist after use
     */
    public Boolean getIsPinCanPersistAfterUse() {
	return isPinCanPersistAfterUse;
    }

    /**
     * Sets the checks if is pin can persist after use.
     *
     * @param isPinCanPersistAfterUse the new checks if is pin can persist after use
     */
    public void setIsPinCanPersistAfterUse(Boolean isPinCanPersistAfterUse) {
	this.isPinCanPersistAfterUse = isPinCanPersistAfterUse;
    }

    /**
     * Gets the checks if is present control.
     *
     * @return the checks if is present control
     */
    public Boolean getIsPresentControl() {
	return isPresentControl;
    }

    /**
     * Sets the checks if is present control.
     *
     * @param isPresentControl the new checks if is present control
     */
    public void setIsPresentControl(Boolean isPresentControl) {
	this.isPresentControl = isPresentControl;
    }

    /**
     * Gets the checks if is rescan.
     *
     * @return the checks if is rescan
     */
    public Boolean getIsRescan() {
	return isRescan;
    }

    /**
     * Sets the checks if is rescan.
     *
     * @param isRescan the new checks if is rescan
     */
    public void setIsRescan(Boolean isRescan) {
	this.isRescan = isRescan;
    }

    /**
     * Gets the checks if is retract counts items.
     *
     * @return the checks if is retract counts items
     */
    public Boolean getIsRetractCountsItems() {
	return isRetractCountsItems;
    }

    /**
     * Sets the checks if is retract counts items.
     *
     * @param isRetractCountsItems the new checks if is retract counts items
     */
    public void setIsRetractCountsItems(Boolean isRetractCountsItems) {
	this.isRetractCountsItems = isRetractCountsItems;
    }

    /**
     * Gets the checks if is retract to transport.
     *
     * @return the checks if is retract to transport
     */
    public Boolean getIsRetractToTransport() {
	return isRetractToTransport;
    }

    /**
     * Sets the checks if is retract to transport.
     *
     * @param isRetractToTransport the new checks if is retract to transport
     */
    public void setIsRetractToTransport(Boolean isRetractToTransport) {
	this.isRetractToTransport = isRetractToTransport;
    }

    /**
     * Gets the checks if is safe door.
     *
     * @return the checks if is safe door
     */
    public Boolean getIsSafeDoor() {
	return isSafeDoor;
    }

    /**
     * Sets the checks if is safe door.
     *
     * @param isSafeDoor the new checks if is safe door
     */
    public void setIsSafeDoor(Boolean isSafeDoor) {
	this.isSafeDoor = isSafeDoor;
    }

    /**
     * Gets the checks if is set pin block data required.
     *
     * @return the checks if is set pin block data required
     */
    public Boolean getIsSetPinBlockDataRequired() {
	return isSetPinBlockDataRequired;
    }

    /**
     * Sets the checks if is set pin block data required.
     *
     * @param isSetPinBlockDataRequired the new checks if is set pin block data required
     */
    public void setIsSetPinBlockDataRequired(Boolean isSetPinBlockDataRequired) {
	this.isSetPinBlockDataRequired = isSetPinBlockDataRequired;
    }

    /**
     * Gets the checks if is stamp.
     *
     * @return the checks if is stamp
     */
    public Boolean getIsStamp() {
	return isStamp;
    }

    /**
     * Sets the checks if is stamp.
     *
     * @param isStamp the new checks if is stamp
     */
    public void setIsStamp(Boolean isStamp) {
	this.isStamp = isStamp;
    }

    /**
     * Gets the checks if is type combined.
     *
     * @return the checks if is type combined
     */
    public Boolean getIsTypeCombined() {
	return isTypeCombined;
    }

    /**
     * Sets the checks if is type combined.
     *
     * @param isTypeCombined the new checks if is type combined
     */
    public void setIsTypeCombined(Boolean isTypeCombined) {
	this.isTypeCombined = isTypeCombined;
    }

    /**
     * Gets the item info types.
     *
     * @return the item info types
     */
    public String getItemInfoTypes() {
	return itemInfoTypes;
    }

    /**
     * Sets the item info types.
     *
     * @param itemInfoTypes the new item info types
     */
    public void setItemInfoTypes(String itemInfoTypes) {
	this.itemInfoTypes = itemInfoTypes;
    }

    /**
     * Gets the key block import formats.
     *
     * @return the key block import formats
     */
    public String getKeyBlockImportFormats() {
	return keyBlockImportFormats;
    }

    /**
     * Sets the key block import formats.
     *
     * @param keyBlockImportFormats the new key block import formats
     */
    public void setKeyBlockImportFormats(String keyBlockImportFormats) {
	this.keyBlockImportFormats = keyBlockImportFormats;
    }

    /**
     * Gets the key check modes.
     *
     * @return the key check modes
     */
    public String getKeyCheckModes() {
	return keyCheckModes;
    }

    /**
     * Sets the key check modes.
     *
     * @param keyCheckModes the new key check modes
     */
    public void setKeyCheckModes(String keyCheckModes) {
	this.keyCheckModes = keyCheckModes;
    }

    /**
     * Gets the key lock.
     *
     * @return the key lock
     */
    public Boolean getKeyLock() {
	return keyLock;
    }

    /**
     * Sets the key lock.
     *
     * @param keyLock the new key lock
     */
    public void setKeyLock(Boolean keyLock) {
	this.keyLock = keyLock;
    }

    /**
     * Gets the key num.
     *
     * @return the key num
     */
    public Integer getKeyNum() {
	return keyNum;
    }

    /**
     * Sets the key num.
     *
     * @param keyNum the new key num
     */
    public void setKeyNum(Integer keyNum) {
	this.keyNum = keyNum;
    }

    /**
     * Gets the logical.
     *
     * @return the logical
     */
    public String getLogical() {
	return logical;
    }

    /**
     * Sets the logical.
     *
     * @param logical the new logical
     */
    public void setLogical(String logical) {
	this.logical = logical;
    }

    /**
     * Gets the magneticstriperead.
     *
     * @return the magneticstriperead
     */
    public Boolean getMagneticstriperead() {
	return magneticstriperead;
    }

    /**
     * Sets the magneticstriperead.
     *
     * @param magneticstriperead the new magneticstriperead
     */
    public void setMagneticstriperead(Boolean magneticstriperead) {
	this.magneticstriperead = magneticstriperead;
    }

    /**
     * Gets the magneticstripewrite.
     *
     * @return the magneticstripewrite
     */
    public Boolean getMagneticstripewrite() {
	return magneticstripewrite;
    }

    /**
     * Sets the magneticstripewrite.
     *
     * @param magneticstripewrite the new magneticstripewrite
     */
    public void setMagneticstripewrite(Boolean magneticstripewrite) {
	this.magneticstripewrite = magneticstripewrite;
    }

    /**
     * Gets the max cash in items.
     *
     * @return the max cash in items
     */
    public Integer getMaxCashInItems() {
	return maxCashInItems;
    }

    /**
     * Sets the max cash in items.
     *
     * @param maxCashInItems the new max cash in items
     */
    public void setMaxCashInItems(Integer maxCashInItems) {
	this.maxCashInItems = maxCashInItems;
    }

    /**
     * Gets the max data length.
     *
     * @return the max data length
     */
    public Integer getMaxDataLength() {
	return maxDataLength;
    }

    /**
     * Sets the max data length.
     *
     * @param maxDataLength the new max data length
     */
    public void setMaxDataLength(Integer maxDataLength) {
	this.maxDataLength = maxDataLength;
    }

    /**
     * Gets the max dispense items.
     *
     * @return the max dispense items
     */
    public Integer getMaxDispenseItems() {
	return maxDispenseItems;
    }

    /**
     * Sets the max dispense items.
     *
     * @param maxDispenseItems the new max dispense items
     */
    public void setMaxDispenseItems(Integer maxDispenseItems) {
	this.maxDispenseItems = maxDispenseItems;
    }

    /**
     * Gets the max media on stacker.
     *
     * @return the max media on stacker
     */
    public Integer getMaxMediaOnStacker() {
	return maxMediaOnStacker;
    }

    /**
     * Sets the max media on stacker.
     *
     * @param maxMediaOnStacker the new max media on stacker
     */
    public void setMaxMediaOnStacker(Integer maxMediaOnStacker) {
	this.maxMediaOnStacker = maxMediaOnStacker;
    }

    /**
     * Gets the max num chars.
     *
     * @return the max num chars
     */
    public Integer getMaxNumChars() {
	return maxNumChars;
    }

    /**
     * Sets the max num chars.
     *
     * @param maxNumChars the new max num chars
     */
    public void setMaxNumChars(Integer maxNumChars) {
	this.maxNumChars = maxNumChars;
    }

    /**
     * Gets the max pictures.
     *
     * @return the max pictures
     */
    public Integer getMaxPictures() {
	return maxPictures;
    }

    /**
     * Sets the max pictures.
     *
     * @param maxPictures the new max pictures
     */
    public void setMaxPictures(Integer maxPictures) {
	this.maxPictures = maxPictures;
    }

    /**
     * Gets the max retract.
     *
     * @return the max retract
     */
    public String getMaxRetract() {
	return maxRetract;
    }

    /**
     * Sets the max retract.
     *
     * @param maxRetract the new max retract
     */
    public void setMaxRetract(String maxRetract) {
	this.maxRetract = maxRetract;
    }

    /**
     * Gets the media taken.
     *
     * @return the media taken
     */
    public Boolean getMediaTaken() {
	return mediaTaken;
    }

    /**
     * Sets the media taken.
     *
     * @param mediaTaken the new media taken
     */
    public void setMediaTaken(Boolean mediaTaken) {
	this.mediaTaken = mediaTaken;
    }

    /**
     * Gets the memory chip protocols.
     *
     * @return the memory chip protocols
     */
    public String getMemoryChipProtocols() {
	return memoryChipProtocols;
    }

    /**
     * Sets the memory chip protocols.
     *
     * @param memoryChipProtocols the new memory chip protocols
     */
    public void setMemoryChipProtocols(String memoryChipProtocols) {
	this.memoryChipProtocols = memoryChipProtocols;
    }

    /**
     * Gets the micr.
     *
     * @return the micr
     */
    public Boolean getMicr() {
	return micr;
    }

    /**
     * Sets the micr.
     *
     * @param micr the new micr
     */
    public void setMicr(Boolean micr) {
	this.micr = micr;
    }

    /**
     * Gets the move items.
     *
     * @return the move items
     */
    public String getMoveItems() {
	return moveItems;
    }

    /**
     * Sets the move items.
     *
     * @param moveItems the new move items
     */
    public void setMoveItems(String moveItems) {
	this.moveItems = moveItems;
    }

    /**
     * Gets the multi page.
     *
     * @return the multi page
     */
    public Boolean getMultiPage() {
	return multiPage;
    }

    /**
     * Sets the multi page.
     *
     * @param multiPage the new multi page
     */
    public void setMultiPage(Boolean multiPage) {
	this.multiPage = multiPage;
    }

    /**
     * Gets the num leds.
     *
     * @return the num leds
     */
    public Integer getNumLeds() {
	return numLeds;
    }

    /**
     * Sets the num leds.
     *
     * @param numLeds the new num leds
     */
    public void setNumLeds(Integer numLeds) {
	this.numLeds = numLeds;
    }

    /**
     * Gets the ocr.
     *
     * @return the ocr
     */
    public Boolean getOcr() {
	return ocr;
    }

    /**
     * Sets the ocr.
     *
     * @param ocr the new ocr
     */
    public void setOcr(Boolean ocr) {
	this.ocr = ocr;
    }

    /**
     * Gets the paper sources.
     *
     * @return the paper sources
     */
    public String getPaperSources() {
	return paperSources;
    }

    /**
     * Sets the paper sources.
     *
     * @param paperSources the new paper sources
     */
    public void setPaperSources(String paperSources) {
	this.paperSources = paperSources;
    }

    /**
     * Gets the pin formats.
     *
     * @return the pin formats
     */
    public String getPinFormats() {
	return pinFormats;
    }

    /**
     * Sets the pin formats.
     *
     * @param pinFormats the new pin formats
     */
    public void setPinFormats(String pinFormats) {
	this.pinFormats = pinFormats;
    }

    /**
     * Gets the power off.
     *
     * @return the power off
     */
    public String getPowerOff() {
	return powerOff;
    }

    /**
     * Sets the power off.
     *
     * @param powerOff the new power off
     */
    public void setPowerOff(String powerOff) {
	this.powerOff = powerOff;
    }

    /**
     * Gets the power on.
     *
     * @return the power on
     */
    public String getPowerOn() {
	return powerOn;
    }

    /**
     * Sets the power on.
     *
     * @param powerOn the new power on
     */
    public void setPowerOn(String powerOn) {
	this.powerOn = powerOn;
    }

    /**
     * Gets the power save control.
     *
     * @return the power save control
     */
    public Boolean getPowerSaveControl() {
	return powerSaveControl;
    }

    /**
     * Sets the power save control.
     *
     * @param powerSaveControl the new power save control
     */
    public void setPowerSaveControl(Boolean powerSaveControl) {
	this.powerSaveControl = powerSaveControl;
    }

    /**
     * Gets the presentation algorithms.
     *
     * @return the presentation algorithms
     */
    public String getPresentationAlgorithms() {
	return presentationAlgorithms;
    }

    /**
     * Sets the presentation algorithms.
     *
     * @param presentationAlgorithms the new presentation algorithms
     */
    public void setPresentationAlgorithms(String presentationAlgorithms) {
	this.presentationAlgorithms = presentationAlgorithms;
    }

    /**
     * Gets the printer.
     *
     * @return the printer
     */
    public Boolean getPrinter() {
	return printer;
    }

    /**
     * Sets the printer.
     *
     * @param printer the new printer
     */
    public void setPrinter(Boolean printer) {
	this.printer = printer;
    }

    /**
     * Gets the prints the on retracts.
     *
     * @return the prints the on retracts
     */
    public Boolean getPrintOnRetracts() {
	return printOnRetracts;
    }

    /**
     * Sets the prints the on retracts.
     *
     * @param printOnRetracts the new prints the on retracts
     */
    public void setPrintOnRetracts(Boolean printOnRetracts) {
	this.printOnRetracts = printOnRetracts;
    }

    /**
     * Gets the prints the size.
     *
     * @return the prints the size
     */
    public String getPrintSize() {
	return printSize;
    }

    /**
     * Sets the prints the size.
     *
     * @param printSize the new prints the size
     */
    public void setPrintSize(String printSize) {
	this.printSize = printSize;
    }

    /**
     * Gets the programatically deactivate.
     *
     * @return the programatically deactivate
     */
    public Boolean getProgramaticallyDeactivate() {
	return programaticallyDeactivate;
    }

    /**
     * Sets the programatically deactivate.
     *
     * @param programaticallyDeactivate the new programatically deactivate
     */
    public void setProgramaticallyDeactivate(Boolean programaticallyDeactivate) {
	this.programaticallyDeactivate = programaticallyDeactivate;
    }

    /**
     * Gets the provider.
     *
     * @return the provider
     */
    public String getProvider() {
	return provider;
    }

    /**
     * Sets the provider.
     *
     * @param provider the new provider
     */
    public void setProvider(String provider) {
	this.provider = provider;
    }

    /**
     * Gets the read form.
     *
     * @return the read form
     */
    public String getReadForm() {
	return readForm;
    }

    /**
     * Sets the read form.
     *
     * @param readForm the new read form
     */
    public void setReadForm(String readForm) {
	this.readForm = readForm;
    }

    /**
     * Gets the read tracks.
     *
     * @return the read tracks
     */
    public String getReadTracks() {
	return readTracks;
    }

    /**
     * Sets the read tracks.
     *
     * @param readTracks the new read tracks
     */
    public void setReadTracks(String readTracks) {
	this.readTracks = readTracks;
    }

    /**
     * Gets the refill.
     *
     * @return the refill
     */
    public Boolean getRefill() {
	return refill;
    }

    /**
     * Sets the refill.
     *
     * @param refill the new refill
     */
    public void setRefill(Boolean refill) {
	this.refill = refill;
    }

    /**
     * Gets the reset control.
     *
     * @return the reset control
     */
    public String getResetControl() {
	return resetControl;
    }

    /**
     * Sets the reset control.
     *
     * @param resetControl the new reset control
     */
    public void setResetControl(String resetControl) {
	this.resetControl = resetControl;
    }

    /**
     * Gets the resolutions.
     *
     * @return the resolutions
     */
    public String getResolutions() {
	return resolutions;
    }

    /**
     * Sets the resolutions.
     *
     * @param resolutions the new resolutions
     */
    public void setResolutions(String resolutions) {
	this.resolutions = resolutions;
    }

    /**
     * Gets the retract areas.
     *
     * @return the retract areas
     */
    public String getRetractAreas() {
	return retractAreas;
    }

    /**
     * Sets the retract areas.
     *
     * @param retractAreas the new retract areas
     */
    public void setRetractAreas(String retractAreas) {
	this.retractAreas = retractAreas;
    }

    /**
     * Gets the retract bins.
     *
     * @return the retract bins
     */
    public String getRetractBins() {
	return retractBins;
    }

    /**
     * Sets the retract bins.
     *
     * @param retractBins the new retract bins
     */
    public void setRetractBins(String retractBins) {
	this.retractBins = retractBins;
    }

    /**
     * Gets the retractenvelope.
     *
     * @return the retractenvelope
     */
    public String getRetractenvelope() {
	return retractenvelope;
    }

    /**
     * Sets the retractenvelope.
     *
     * @param retractenvelope the new retractenvelope
     */
    public void setRetractenvelope(String retractenvelope) {
	this.retractenvelope = retractenvelope;
    }

    /**
     * Gets the retract stacker actions.
     *
     * @return the retract stacker actions
     */
    public String getRetractStackerActions() {
	return retractStackerActions;
    }

    /**
     * Sets the retract stacker actions.
     *
     * @param retractStackerActions the new retract stacker actions
     */
    public void setRetractStackerActions(String retractStackerActions) {
	this.retractStackerActions = retractStackerActions;
    }

    /**
     * Gets the retract transport actions.
     *
     * @return the retract transport actions
     */
    public String getRetractTransportActions() {
	return retractTransportActions;
    }

    /**
     * Sets the retract transport actions.
     *
     * @param retractTransportActions the new retract transport actions
     */
    public void setRetractTransportActions(String retractTransportActions) {
	this.retractTransportActions = retractTransportActions;
    }

    /**
     * Gets the rsa authentication scheme.
     *
     * @return the rsa authentication scheme
     */
    public String getRsaAuthenticationScheme() {
	return rsaAuthenticationScheme;
    }

    /**
     * Sets the rsa authentication scheme.
     *
     * @param rsaAuthenticationScheme the new rsa authentication scheme
     */
    public void setRsaAuthenticationScheme(String rsaAuthenticationScheme) {
	this.rsaAuthenticationScheme = rsaAuthenticationScheme;
    }

    /**
     * Gets the rsa crypt algorithm.
     *
     * @return the rsa crypt algorithm
     */
    public String getRsaCryptAlgorithm() {
	return rsaCryptAlgorithm;
    }

    /**
     * Sets the rsa crypt algorithm.
     *
     * @param rsaCryptAlgorithm the new rsa crypt algorithm
     */
    public void setRsaCryptAlgorithm(String rsaCryptAlgorithm) {
	this.rsaCryptAlgorithm = rsaCryptAlgorithm;
    }

    /**
     * Gets the rsa keycheck mode.
     *
     * @return the rsa keycheck mode
     */
    public String getRsaKeycheckMode() {
	return rsaKeycheckMode;
    }

    /**
     * Sets the rsa keycheck mode.
     *
     * @param rsaKeycheckMode the new rsa keycheck mode
     */
    public void setRsaKeycheckMode(String rsaKeycheckMode) {
	this.rsaKeycheckMode = rsaKeycheckMode;
    }

    /**
     * Gets the rsa signature algorithm.
     *
     * @return the rsa signature algorithm
     */
    public String getRsaSignatureAlgorithm() {
	return rsaSignatureAlgorithm;
    }

    /**
     * Sets the rsa signature algorithm.
     *
     * @param rsaSignatureAlgorithm the new rsa signature algorithm
     */
    public void setRsaSignatureAlgorithm(String rsaSignatureAlgorithm) {
	this.rsaSignatureAlgorithm = rsaSignatureAlgorithm;
    }

    /**
     * Gets the security type.
     *
     * @return the security type
     */
    public String getSecurityType() {
	return securityType;
    }

    /**
     * Sets the security type.
     *
     * @param securityType the new security type
     */
    public void setSecurityType(String securityType) {
	this.securityType = securityType;
    }

    /**
     * Gets the sensors.
     *
     * @return the sensors
     */
    public String getSensors() {
	return sensors;
    }

    /**
     * Sets the sensors.
     *
     * @param sensors the new sensors
     */
    public void setSensors(String sensors) {
	this.sensors = sensors;
    }

    /**
     * Gets the shutter control.
     *
     * @return the shutter control
     */
    public Boolean getShutterControl() {
	return shutterControl;
    }

    /**
     * Sets the shutter control.
     *
     * @param shutterControl the new shutter control
     */
    public void setShutterControl(Boolean shutterControl) {
	this.shutterControl = shutterControl;
    }

    /**
     * Gets the signature scheme.
     *
     * @return the signature scheme
     */
    public String getSignatureScheme() {
	return signatureScheme;
    }

    /**
     * Sets the signature scheme.
     *
     * @param signatureScheme the new signature scheme
     */
    public void setSignatureScheme(String signatureScheme) {
	this.signatureScheme = signatureScheme;
    }

    /**
     * Gets the stamp.
     *
     * @return the stamp
     */
    public String getStamp() {
	return stamp;
    }

    /**
     * Sets the stamp.
     *
     * @param stamp the new stamp
     */
    public void setStamp(String stamp) {
	this.stamp = stamp;
    }

    /**
     * Gets the positions.
     *
     * @return the positions
     */
    public String getPositions() {
	return positions;
    }

    /**
     * Sets the positions.
     *
     * @param positions the new positions
     */
    public void setPositions(String positions) {
	this.positions = positions;
    }

    /**
     * Gets the symbologies.
     *
     * @return the symbologies
     */
    public String getSymbologies() {
	return symbologies;
    }

    /**
     * Sets the symbologies.
     *
     * @param symbologies the new symbologies
     */
    public void setSymbologies(String symbologies) {
	this.symbologies = symbologies;
    }

    /**
     * Gets the can filter symbologies.
     *
     * @return the can filter symbologies
     */
    public Boolean getCanFilterSymbologies() {
	return canFilterSymbologies;
    }

    /**
     * Sets the can filter symbologies.
     *
     * @param canFilterSymbologies the new can filter symbologies
     */
    public void setCanFilterSymbologies(Boolean canFilterSymbologies) {
	this.canFilterSymbologies = canFilterSymbologies;
    }

    /**
     * Gets the toner.
     *
     * @return the toner
     */
    public Boolean getToner() {
	return toner;
    }

    /**
     * Sets the toner.
     *
     * @param toner the new toner
     */
    public void setToner(Boolean toner) {
	this.toner = toner;
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
     * @param type the new type
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Gets the validation algorithms.
     *
     * @return the validation algorithms
     */
    public String getValidationAlgorithms() {
	return validationAlgorithms;
    }

    /**
     * Sets the validation algorithms.
     *
     * @param validationAlgorithms the new validation algorithms
     */
    public void setValidationAlgorithms(String validationAlgorithms) {
	this.validationAlgorithms = validationAlgorithms;
    }

    /**
     * Gets the windows printer.
     *
     * @return the windows printer
     */
    public String getWindowsPrinter() {
	return windowsPrinter;
    }

    /**
     * Sets the windows printer.
     *
     * @param windowsPrinter the new windows printer
     */
    public void setWindowsPrinter(String windowsPrinter) {
	this.windowsPrinter = windowsPrinter;
    }

    /**
     * Gets the write form.
     *
     * @return the write form
     */
    public String getWriteForm() {
	return writeForm;
    }

    /**
     * Sets the write form.
     *
     * @param writeForm the new write form
     */
    public void setWriteForm(String writeForm) {
	this.writeForm = writeForm;
    }

    /**
     * Gets the write mode.
     *
     * @return the write mode
     */
    public String getWriteMode() {
	return writeMode;
    }

    /**
     * Sets the write mode.
     *
     * @param writeMode the new write mode
     */
    public void setWriteMode(String writeMode) {
	this.writeMode = writeMode;
    }

    /**
     * Gets the write tracks.
     *
     * @return the write tracks
     */
    public String getWriteTracks() {
	return writeTracks;
    }

    /**
     * Sets the write tracks.
     *
     * @param writeTracks the new write tracks
     */
    public void setWriteTracks(String writeTracks) {
	this.writeTracks = writeTracks;
    }

    /**
     * Gets the xfsclasses (i.e. ALM, BCR, CAM, CDM...).
     * 
     * @return the xfsclasses
     */
    public static Set<String> getXfsclasses() {
	return xfsClasses;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    public Boolean getAutodeposit() {
	return autodeposit;
    }

    public void setAutodeposit(Boolean autodeposit) {
	this.autodeposit = autodeposit;
    }

    public Boolean getCoins() {
	return coins;
    }

    public void setCoins(Boolean coins) {
	this.coins = coins;
    }

    public Boolean getCylinders() {
	return cylinders;
    }

    public void setCylinders(Boolean cylinders) {
	this.cylinders = cylinders;
    }

    public String getKeys() {
	return keys;
    }

    public void setKeys(String keys) {
	this.keys = keys;
    }

    public Integer getMax2Retract() {
	return max2Retract;
    }

    public void setMax2Retract(Integer max2Retract) {
	this.max2Retract = max2Retract;
    }

    public Integer getMaxBills() {
	return maxBills;
    }

    public void setMaxBills(Integer maxBills) {
	this.maxBills = maxBills;
    }

    public Integer getMaxCoins() {
	return maxCoins;
    }

    public void setMaxCoins(Integer maxCoins) {
	this.maxCoins = maxCoins;
    }

    public String getOutputPositions() {
	return outputPositions;
    }

    public void setOutputPositions(String outputPositions) {
	this.outputPositions = outputPositions;
    }

    public Integer getPockets() {
	return pockets;
    }

    public void setPockets(Integer pockets) {
	this.pockets = pockets;
    }

    public Boolean getRetractToDeposit() {
	return retractToDeposit;
    }

    public void setRetractToDeposit(Boolean retractToDeposit) {
	this.retractToDeposit = retractToDeposit;
    }

    public Boolean getVandalCheck() {
	return vandalCheck;
    }

    public void setVandalCheck(Boolean vandalCheck) {
	this.vandalCheck = vandalCheck;
    }
    
  //EP410008 - 28/01/2014
    public Boolean getCashin() {
    	return cashin;
    }

    public void setCashin(Boolean cashin) {
    	this.cashin = cashin;
    }
    
    public Boolean getRetract() {
    	return retract;
    }

    public void setRetract(Boolean retract) {
    	this.retract = retract;
    }
    //<--
}