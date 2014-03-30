package com.ncr.ATMMonitoring.controller.helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Id;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.commons.collections.Predicate;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.annotation.ComboQueryOption;

public class QueryCombosHelper {

    /** The logger. */
    static private Logger logger = Logger.getLogger(QueryCombosHelper.class);

    private static final String GENERAL_MESSAGE_LABEL = "label.";

    private static final String COMPARISON_MESSAGE_BASE = GENERAL_MESSAGE_LABEL
	    + "query.operation";
    /**
	 * 
	 */
    private static final String HARDWARE_DEVICE_TYPE_MESSAGE_BASE = GENERAL_MESSAGE_LABEL
	    + "hardwareDevice";

    /**
     * Returns the map with the options to use in a query combobox
     * 
     * @param entity
     * @param messageKeyBase
     * @param options
     * @param rb
     */
    public static Map<String, String> generateFieldComboOptions(
	    Class<?> entity, String comboType, Locale locale) {

	String messageKeyBase = GENERAL_MESSAGE_LABEL + comboType;
	Map<String, String> options = new HashMap<String, String>();
	ResourceBundle rb = getResourceBundle(locale);

	for (String option : entityFieldNamesToComboBox(entity, null)) {
	    try {
		options.put(option, rb.getString(messageKeyBase + "." + option));
	    } catch (MissingResourceException e) {
		logger.debug("the field name: "
			+ option
			+ " does not have an property key to show in the combo, is an valid combo option?");
	    }
	}
	return options;
    }

    /**
     * Generates the options according to the data type
     * 
     * @param entity
     * @param messageKeyBase
     * @param deviceType
     * @param locale
     * @return
     */
    public static Map<String, String> generateDeviceTypeFieldComboOptions(
	    Class<?> entity, String deviceType, Locale locale) {

	Map<String, String> options = new HashMap<String, String>();
	ResourceBundle rb = getResourceBundle(locale);

	for (String option : entityFieldNamesToComboBox(entity, deviceType)) {
	    try {
		options.put(
			option,
			rb.getString(HARDWARE_DEVICE_TYPE_MESSAGE_BASE + "."
				+ option));
	    } catch (MissingResourceException e) {
		logger.debug("the field name: "
			+ option
			+ " does not have an property key to show in the combo, is an valid combo option?");
	    }
	}
	return options;
    }

    /**
     * generates the map of options to use in a query data types combobox
     * 
     * @param entity
     * @param fieldname
     * @param locale
     * @return
     */
    public static Map<String, String> generateComboOptionsByDataType(
	    Class<?> entity, String fieldname, Locale locale) {
	Map<String, String> options = new HashMap<String, String>();
	ResourceBundle rb = getResourceBundle(locale);

	for (String option : entityFieldDataTypeKeysToComboBox(entity,
		fieldname)) {
	    try {
		options.put(option,
			rb.getString(COMPARISON_MESSAGE_BASE + "." + option));
	    } catch (MissingResourceException e) {
		logger.debug("the fieldtype name: "
			+ option
			+ " does not have an property key to show in the combo, is an valid combo option?");
	    }
	}
	return options;
    }

    /**
     * 
     * @param locale
     * @param messageKeyBase
     * @return
     */
    public static Map<String, String> generateHardwareDeviceComboOptions(
	    Locale locale) {

	Map<String, String> options = new HashMap<String, String>();
	ResourceBundle rb = getResourceBundle(locale);
	String messageKeyBase = HARDWARE_DEVICE_TYPE_MESSAGE_BASE;
	options.put(
		ComboQueryOption.GROUP_HARDWARE_COMPUTER_SYSTEM,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_COMPUTER_SYSTEM));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_PROCESSOR,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_PROCESSOR));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_PHYSICAL_MEMORY,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_PHYSICAL_MEMORY));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_DISK_DRIVE,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_DISK_DRIVE));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_LOGICAL_DISK,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_LOGICAL_DISK));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_BASE_BOARD,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_BASE_BOARD));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_NETWORK_ADAPTER,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_NETWORK_ADAPTER));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_FLOPPY_DRIVE,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_FLOPPY_DRIVE));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_CDROM_DRIVE,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_CDROM_DRIVE));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_SOUND_DEVICE,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_SOUND_DEVICE));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_DISPLAY_CONFIGURATION,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_DISPLAY_CONFIGURATION));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_USB_CONTROLLER,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_USB_CONTROLLER));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_USB_HUB,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_USB_HUB));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_SERIAL_PORT,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_SERIAL_PORT));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_PARALLEL_PORT,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_PARALLEL_PORT));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_1394_CONTROLLER,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_1394_CONTROLLER));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_SCSI_CONTROLLER,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_SCSI_CONTROLLER));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_DESKTOP_MONITOR,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_DESKTOP_MONITOR));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_KEYBOARD,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_KEYBOARD));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_POINTING_DEVICE,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_POINTING_DEVICE));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_SYSTEM_SLOT,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_SYSTEM_SLOT));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_BIOS,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_BIOS));
	options.put(
		ComboQueryOption.GROUP_HARDWARE_VIDEO_CONTROLLER,
		rb.getString(messageKeyBase + "."
			+ ComboQueryOption.GROUP_HARDWARE_VIDEO_CONTROLLER));
	return options;
    }

    /**
     * Gets the values from the entity and generates a map with the currents
     * values that can be transformed into JSON
     * 
     * @param query
     * @param locale
     * @return Map<String, String>
     */
    public static Map<String, String> getQueryCombosActualValues(Query query,
	    Locale locale) {
	Map<String, String> comboActualValues = new HashMap<String, String>();
	Field[] fields = query.getClass().getDeclaredFields();
	ResourceBundle rb = getResourceBundle(locale);
	Pattern patternComboFields = Pattern.compile("Combo\\d1");
	Pattern patternComboComparison = Pattern.compile("Combo\\d2");
	Pattern patternComboComparisonHardware = Pattern.compile("Combo\\d3");

	Matcher matcherComboFields = null;
	Matcher matcherComboComparison = null;
	Matcher matcherComboComparisonHardware = null;

	for (int i = 0; i < fields.length; i++) {
	    Field field = fields[i];

	    if (field.isAnnotationPresent(Column.class)
		    && !field.isAnnotationPresent(Id.class)) {
		String fieldName = field.getName();
		// gets only those field needed to fill the combos
		if (fieldName.contains("Combo") || fieldName.contains("Field")
			|| fieldName.contains("CB")) {

		    String getMethodName = "get"
			    + fieldName.substring(0, 1).toUpperCase()
			    + fieldName.substring(1, fieldName.length());
		    try {

			Method getMethod = query.getClass().getDeclaredMethod(
				getMethodName, new Class<?>[] {});
			String getMethodValue = getMethod.invoke(query,
				new Object[] {}).toString();
			comboActualValues.put(fieldName, getMethodValue);
			// i try yo get the labels for the combos only if there
			// is some value
			if (!getMethodValue.equals("")) {
			    matcherComboFields = patternComboFields
				    .matcher(fieldName);
			    matcherComboComparison = patternComboComparison
				    .matcher(fieldName);
			    matcherComboComparisonHardware = patternComboComparisonHardware
				    .matcher(fieldName);

			    String messageBundleKey = GENERAL_MESSAGE_LABEL;

			    if (matcherComboFields.find()) {

				String groupBase = fieldName
					.split(patternComboFields.pattern())[0];
				messageBundleKey += groupBase + "."
					+ getMethodValue;

				comboActualValues.put(fieldName + "Label",
					rb.getString(messageBundleKey));

				comboActualValues.put(fieldName + "Group",
					groupBase);
			    } else if (matcherComboComparison.find()
				    || matcherComboComparisonHardware.find()) {

				if (!fieldName
					.matches("hardwareDeviceCombo\\d2")) {
				    messageBundleKey = COMPARISON_MESSAGE_BASE
					    + "." + getMethodValue;
				} else {
				    messageBundleKey = HARDWARE_DEVICE_TYPE_MESSAGE_BASE
					    + "." + getMethodValue;
				}

				String groupBase = fieldName
					.split(patternComboComparison.pattern())[0];

				comboActualValues.put(fieldName + "Label",
					rb.getString(messageBundleKey));

				comboActualValues.put(fieldName + "Group",
					groupBase);
			    }

			}

		    } catch (NoSuchMethodException e) {
			comboActualValues.put(fieldName, "");
			e.printStackTrace();
		    } catch (SecurityException e) {
			comboActualValues.put(fieldName, "");
			e.printStackTrace();
		    } catch (IllegalAccessException e) {
			comboActualValues.put(fieldName, "");
			e.printStackTrace();
		    } catch (IllegalArgumentException e) {
			comboActualValues.put(fieldName, "");
			e.printStackTrace();
		    } catch (InvocationTargetException e) {
			comboActualValues.put(fieldName, "");
			e.printStackTrace();
		    }

		}
	    }
	}

	return comboActualValues;
    }

    /**
     * Gets all the field names from the class that have present the annotation
     * {@link ComboQueryOption} and put them into a list
     * 
     * @param entityClass
     * @return List<String>
     */
    private static List<String> entityFieldNamesToComboBox(
	    Class<?> entityClass, String group) {
	Field[] fields = entityClass.getDeclaredFields();
	final List<String> comboOptions = new ArrayList<String>();

	for (Field field : fields) {

	    if (field.isAnnotationPresent(ComboQueryOption.class)) {
		if (group != null) {
		    if (belongsToGroup(
			    field.getAnnotation(ComboQueryOption.class), group)) {

			comboOptions.add(field.getName());
		    }
		} else {
		    comboOptions.add(field.getName());

		}

	    }
	}
	return comboOptions;
    }

    /**
     * Gets the options keys for a combobox asociated to datatypes
     * 
     * @param entityClass
     * @param fieldname
     * @return
     */
    private static List<String> entityFieldDataTypeKeysToComboBox(
	    Class<?> entityClass, String fieldname) {

	List<String> dataTypeOptionsKeys = new ArrayList<String>();
	try {

	    Field field = entityClass.getDeclaredField(fieldname);
	    ComboQueryOption queryOptionAnnoation = field
		    .getAnnotation(ComboQueryOption.class);

	    if (queryOptionAnnoation.versionComparison()) {

		dataTypeOptionsKeys = getVersionOperationsComboBoxOptions();

	    } else {

		Class<?> type = field.getType();

		if (type.equals(String.class)) {
		    dataTypeOptionsKeys = getStringOperationsComboBoxOptions();
		} else if (type.equals(Boolean.class)
			|| type.equals(boolean.class)) {

		    dataTypeOptionsKeys = getBooleanOperationsComboBoxOptions();

		} else if ((type.equals(Integer.class) || type
			.equals(int.class))
			|| (type.equals(Float.class) || type
				.equals(float.class))
			|| (type.equals(Double.class) || type
				.equals(double.class))) {

		    dataTypeOptionsKeys = getNumericalOperationsComboBoxOptions();

		} else if (type.equals(Date.class)
			|| type.equals(Timestamp.class)) {

		    dataTypeOptionsKeys = getDateOperationsComboBoxOptions();
		}
	    }

	} catch (NoSuchFieldException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return dataTypeOptionsKeys;
    }

    /**
     * Checks if the given group is present in the field annotation ( return
     * true)
     * 
     * @param annotation
     * @param groupToCheck
     * @return boolean
     */
    private static boolean belongsToGroup(ComboQueryOption annotation,
	    final String groupToCheck) {
	boolean belongsToGroup = false;

	List<String> groups = Arrays.asList(annotation.belongsToGroups());
	List<String> noBelongTogroups = Arrays.asList(annotation
		.doNotBelongsToGroups());
	// check if the field belongs to a group
	if (groups != null && groups.size() > 0) {

	    belongsToGroup = CollectionUtils.exists(groups, new Predicate() {

		@Override
		public boolean evaluate(Object arg0) {

		    String actualGroup = (String) arg0;
		    return actualGroup.equals(groupToCheck);
		}

	    });

	    // checks if the field do not belongs to this particular group
	} else if (noBelongTogroups != null && noBelongTogroups.size() > 0) {
	    // the field do not belongs to the given group
	    boolean notBelongToGroups = CollectionUtils.exists(
		    noBelongTogroups, new Predicate() {

			@Override
			public boolean evaluate(Object arg0) {

			    String actualGroup = (String) arg0;
			    return actualGroup.equals(groupToCheck);
			}

		    });

	    if (!notBelongToGroups) {
		belongsToGroup = true;
	    }

	    // checks if the field belongs to all groups
	} else if (annotation.belongToAllGroups()) {
	    belongsToGroup = true;
	}
	return belongsToGroup;
    }

    /**
     * Returns the property file according to the local given in order to obtain
     * the options labels
     * 
     * @param locale
     * @return ResourceBundle
     */
    private static ResourceBundle getResourceBundle(Locale locale) {
	return ResourceBundle.getBundle("messages", locale);
    }

    /**
     * Gets the query operations related to String types
     * 
     * @return
     */
    private static List<String> getStringOperationsComboBoxOptions() {
	List<String> option = new ArrayList<String>();
	option.add("greater_str");// Alphabetically After//
	option.add("geq_str");// Alphabetically After or Equals//
	option.add("less_str");// Alphabetically Before//
	option.add("leq_str");// Alphabetically Before or Equals//
	option.add("contains");// Contains//
	option.add("contains_case");// Contains (case sensitive)//
	option.add("ends_with");// Ends With//
	option.add("ends_with_case");// Ends With (case sensitive)//
	option.add("eq_str");// Equals//
	option.add("eq_str_case");// Equals (case sensitive)//
	option.add("is_null");// Is Null//
	option.add("starts_with");// Starts With//
	option.add("starts_with_case");// Starts With (case sensitive)//
	return option;

    }

    /**
     * Gets the query operations related to date types
     * 
     * @return List<String>
     */
    private static List<String> getDateOperationsComboBoxOptions() {
	List<String> option = new ArrayList<String>();
	option.add("date_greater");// After Date;//
	option.add("date_geq");// After or Exact Date;//
	option.add("date_less");// Before Date;//
	option.add("date_leq");// Before or Exact Date;//
	option.add("date_eq");// Exact Date;//
	option.add("is_null");// Is Null;//
	return option;
    }

    /**
     * Gets the query operations related to Software versions related types
     * 
     * @return List<String>
     */
    private static List<String> getVersionOperationsComboBoxOptions() {
	List<String> option = new ArrayList<String>();
	option.add("v_greater");// After Version;//
	option.add("v_geq");// After or Exact Version;//
	option.add("v_less");// Before Version;//
	option.add("v_leq");// Before or Exact Version;//
	option.add("v_eq");// Exact Version;//
	option.add("is_null");// Is Null;//
	option.add("v_under");// Under Version;//
	return option;
    }

    /**
     * Gets the query operations related to numerical types
     * 
     * @return List<String>
     */
    private static List<String> getNumericalOperationsComboBoxOptions() {
	List<String> option = new ArrayList<String>();
	option.add("less");// <;//
	option.add("eq");// =;//
	option.add("greater");// );//;//
	option.add("is_null");// Is Null;//
	option.add("leq");// >;//
	option.add("geq");// <;//
	return option;
    }

    /**
     * Gets the query operations related to boolean types
     * 
     * @return
     */
    private static List<String> getBooleanOperationsComboBoxOptions() {
	List<String> option = new ArrayList<String>();
	option.add("is_true");// is true <;//
	option.add("is_false");// is false//
	option.add("is_null");// Is Null;//
	return option;
    }

}
