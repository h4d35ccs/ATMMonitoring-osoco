package com.ncr.ATMMonitoring.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.type.CalendarType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class Operation.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public abstract class Operation {

    /**
     * The Enum OperationId.
     */
    private static enum OperationId {
	
	/** The is null. */
	IS_NULL, 
 /** The eq str. */
 EQ_STR, 
 /** The eq str case. */
 EQ_STR_CASE, 
 /** The contains. */
 CONTAINS, 
 /** The contains case. */
 CONTAINS_CASE, 
 /** The starts with. */
 STARTS_WITH, 
 /** The starts with case. */
 STARTS_WITH_CASE, 
 /** The ends with. */
 ENDS_WITH, 
 /** The ends with case. */
 ENDS_WITH_CASE, 
 /** The less str. */
 LESS_STR, 
 /** The greater str. */
 GREATER_STR, 
 /** The leq str. */
 LEQ_STR, 
 /** The geq str. */
 GEQ_STR, 
 /** The eq. */
 EQ, 
 /** The leq. */
 LEQ, 
 /** The geq. */
 GEQ, 
 /** The greater. */
 GREATER, 
 /** The less. */
 LESS, 
 /** The is true. */
 IS_TRUE, 
 /** The is false. */
 IS_FALSE, 
 /** The v eq. */
 V_EQ, 
 /** The v leq. */
 V_LEQ, 
 /** The v geq. */
 V_GEQ, 
 /** The v greater. */
 V_GREATER, 
 /** The v less. */
 V_LESS, 
 /** The v under. */
 V_UNDER, 
 /** The date eq. */
 DATE_EQ, 
 /** The date less. */
 DATE_LESS, 
 /** The date greater. */
 DATE_GREATER, 
 /** The date leq. */
 DATE_LEQ, 
 /** The date geq. */
 DATE_GEQ
    }

    /**
     * The Enum DataType.
     */
    public static enum DataType {
    	
	    /** The number. */
	    NUMBER, 
 /** The string. */
 STRING, 
 /** The date. */
 DATE, 
 /** The version. */
 VERSION, 
 /** The boolean. */
 BOOLEAN, 
 /** The all. */
 ALL
    }

    /** The Constant integerType. */
    private static final Type integerType = new IntegerType();
    
    /** The Constant stringType. */
    private static final Type stringType = new StringType();
    
    /** The Constant floatType. */
    private static final Type floatType = new FloatType();
    
    /** The Constant calendarType. */
    private static final Type calendarType = new CalendarType();
    
    /** The Constant operationIds. */
    private static final Map<String, OperationId> operationIds;
    
    /** The Constant operations. */
    private static final Map<DataType, Map> operations;

    static {
		operationIds = new TreeMap<String, OperationId>();
		operationIds.put("is_null", OperationId.IS_NULL);
		operationIds.put("eq_str", OperationId.EQ_STR);
		operationIds.put("eq_str_case", OperationId.EQ_STR_CASE);
		operationIds.put("contains", OperationId.CONTAINS);
		operationIds.put("contains_case", OperationId.CONTAINS_CASE);
		operationIds.put("starts_with", OperationId.STARTS_WITH);
		operationIds.put("starts_with_case", OperationId.STARTS_WITH_CASE);
		operationIds.put("ends_with", OperationId.ENDS_WITH);
		operationIds.put("ends_with_case", OperationId.ENDS_WITH_CASE);
		operationIds.put("less_str", OperationId.LESS_STR);
		operationIds.put("leq_str", OperationId.LEQ_STR);
		operationIds.put("greater_str", OperationId.GREATER_STR);
		operationIds.put("geq_str", OperationId.GEQ_STR);
		operationIds.put("eq", OperationId.EQ);
		operationIds.put("geq", OperationId.GEQ);
		operationIds.put("leq", OperationId.LEQ);
		operationIds.put("less", OperationId.LESS);
		operationIds.put("greater", OperationId.GREATER);
		operationIds.put("is_true", OperationId.IS_TRUE);
		operationIds.put("is_false", OperationId.IS_FALSE);
		operationIds.put("v_under", OperationId.V_UNDER);
		operationIds.put("v_eq", OperationId.V_EQ);
		operationIds.put("v_geq", OperationId.V_GEQ);
		operationIds.put("v_leq", OperationId.V_LEQ);
		operationIds.put("v_less", OperationId.V_LESS);
		operationIds.put("v_greater", OperationId.V_GREATER);
		operationIds.put("date_eq", OperationId.DATE_EQ);
		operationIds.put("date_less", OperationId.DATE_LESS);
		operationIds.put("date_greater", OperationId.DATE_GREATER);
		operationIds.put("date_leq", OperationId.DATE_LEQ);
		operationIds.put("date_geq", OperationId.DATE_GEQ);
	
		operations = new TreeMap<DataType, Map>();
		TreeMap<String, Boolean> values = new TreeMap<String, Boolean>();
		Boolean b_true = new Boolean(true);
		Boolean b_false = new Boolean(false);
		values.put("contains", b_true);
		values.put("contains_case", b_true);
		values.put("eq_str", b_true);
		values.put("eq_str_case", b_true);
		values.put("starts_with", b_true);
		values.put("starts_with_case", b_true);
		values.put("ends_with", b_true);
		values.put("ends_with_case", b_true);
		values.put("less_str", b_true);
		values.put("greater_str", b_true);
		values.put("leq_str", b_true);
		values.put("geq_str", b_true);
		values.put("is_null", b_false);
		operations.put(DataType.STRING, values);
		values = new TreeMap<String, Boolean>();
		values.put("eq", b_true);
		values.put("leq", b_true);
		values.put("less", b_true);
		values.put("geq", b_true);
		values.put("greater", b_true);
		values.put("is_null", b_false);
		operations.put(DataType.NUMBER, values);
		values = new TreeMap<String, Boolean>();
		values.put("is_true", b_false);
		values.put("is_false", b_false);
		values.put("is_null", b_false);
		operations.put(DataType.BOOLEAN, values);
		values = new TreeMap<String, Boolean>();
		values.put("v_under", b_true);
		values.put("v_eq", b_true);
		values.put("v_leq", b_true);
		values.put("v_less", b_true);
		values.put("v_geq", b_true);
		values.put("v_greater", b_true);
		values.put("is_null", b_false);
		operations.put(DataType.VERSION, values);
		values = new TreeMap<String, Boolean>();
		values.put("date_eq", b_true);
		values.put("date_leq", b_true);
		values.put("date_less", b_true);
		values.put("date_geq", b_true);
		values.put("date_greater", b_true);
		values.put("is_null", b_false);
		operations.put(DataType.DATE, values);
		values = new TreeMap<String, Boolean>();
		for (DataType dataType : operations.keySet()) {
			Map<String, Boolean> aux = operations.get(dataType);
			for (String name: aux.keySet()) {
				values.put(name, aux.get(name));
			}
		}
		operations.put(DataType.ALL, values);
	    }
	
	    /**
    	 * Gets the operations by type.
    	 *
    	 * @param type the type
    	 * @return the operations by type
    	 */
    	public static Map<String, Map> getOperationsByType(DataType type) {
		return operations.get(type);
    }

    /**
     * Gets the constraint hql.
     *
     * @param column the column
     * @param operation the operation
     * @param value the value
     * @param values the values
     * @param types the types
     * @param locale the locale
     * @return the constraint hql
     */
    public static String getConstraintHQL(String column, String operation,
	    String value, List<Object> values, List<Type> types, Locale locale) {
		String constraint = "";
		String[] versions;
		Date aux;
		Calendar date, date2;
		OperationId opId = operationIds.get(operation);
		switch (opId) {
		case IS_NULL:
		    return column + " = null";
		case EQ_STR_CASE:
		    values.add(value);
		    types.add(stringType);
		    return column + " = ?";
		case EQ_STR:
		    values.add(value.toLowerCase());
		    types.add(stringType);
		    return "lower(" + column + ") = ?";
		case ENDS_WITH_CASE:
		    values.add("%" + value);
		    types.add(stringType);
		    return column + " like ?";
		case ENDS_WITH:
		    values.add("%" + value.toLowerCase());
		    types.add(stringType);
		    return "lower(" + column + ") like ?";
		case STARTS_WITH_CASE:
		    values.add(value + "%");
		    types.add(stringType);
		    return column + " like ?";
		case STARTS_WITH:
		    values.add(value.toLowerCase() + "%");
		    types.add(stringType);
		    return "lower(" + column + ") like ?";
		case CONTAINS_CASE:
		    values.add("%" + value + "%");
		    types.add(stringType);
		    return column + " like ?";
		case CONTAINS:
		    values.add("%" + value.toLowerCase() + "%");
		    types.add(stringType);
		    return "lower(" + column + ") like ?";
		case LESS_STR:
		    values.add(value.toLowerCase());
		    types.add(stringType);
		    return "lower(" + column + ") < ?";
		case GREATER_STR:
		    values.add(value.toLowerCase());
		    types.add(stringType);
		    return "lower(" + column + ") > ?";
		case LEQ_STR:
		    values.add(value.toLowerCase());
		    types.add(stringType);
		    return "lower(" + column + ") <= ?";
		case GEQ_STR:
		    values.add(value.toLowerCase());
		    types.add(stringType);
		    return "lower(" + column + ") >= ?";
		case EQ:
		    values.add(new Float(value));
		    types.add(floatType);
		    return column + " = ?";
		case LEQ:
		    values.add(new Float(value));
		    types.add(floatType);
		    return column + " <= ?";
		case GEQ:
		    values.add(new Float(value));
		    types.add(floatType);
		    return column + " >= ?";
		case LESS:
		    values.add(new Float(value));
		    types.add(floatType);
		    return column + " < ?";
		case GREATER:
		    values.add(new Float(value));
		    types.add(floatType);
		    return column + " > ?";
		case IS_TRUE:
		    return column + " = true";
		case IS_FALSE:
		    return column + " = false";
		case V_UNDER:
		    versions = value.split("\\.", 5);
		    switch (versions.length) {
		    case 5:
			values.add(versions[4]);
			types.add(stringType);
			constraint += column
				.replace("majorVersion", "remainingVersion").replace(
					"MajorVersion", "RemainingVersion")
				+ " = ? and ";
		    case 4:
			values.add(new Integer(versions[3]));
			types.add(integerType);
			constraint += column.replace("majorVersion", "revisionVersion")
				.replace("MajorVersion", "RevisionVersion")
				+ " = ? and ";
		    case 3:
			values.add(new Integer(versions[2]));
			types.add(integerType);
			constraint += column.replace("majorVersion", "buildVersion")
				.replace("MajorVersion", "BuildVersion") + " = ? and ";
		    case 2:
			values.add(new Integer(versions[1]));
			types.add(integerType);
			constraint += column.replace("majorVersion", "minorVersion")
				.replace("MajorVersion", "MinorVersion") + " = ? and ";
		    case 1:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			constraint += column + " = ?";
		    case 0:
			break;
		    }
		    return constraint;
		case V_EQ:
		    versions = value.split("\\.", 5);
		    switch (versions.length) {
		    case 5:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			values.add(versions[4]);
			types.add(stringType);
			constraint += column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " = ?)";
			break;
		    case 4:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			constraint += column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = ? and ("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " = null or length("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ ") = 0)";
			break;
		    case 3:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			constraint += column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = null and ("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " = null or length("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ ") = 0)";
			break;
		    case 2:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			constraint += column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = null and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = null and ("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " = null or length("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ ") = 0)";
			break;
		    case 1:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			constraint += column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = null and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = null and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = null and ("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " = null or length("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ ") = 0)";
		    case 0:
			break;
		    }
		    return constraint;
		case V_LEQ:
		case V_LESS:
		    versions = value.split("\\.", 5);
		    switch (versions.length) {
		    case 5:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			values.add(versions[4]);
			types.add(stringType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " < ?) or ";
		    case 4:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " < ?) or";
		    case 3:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " < ?) or ";
		    case 2:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " < ?) or ";
		    case 1:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			constraint += column + " < ?";
		    case 0:
			break;
		    }
		    if (opId == OperationId.V_LEQ) {
			constraint = "(" + constraint + ") or (";
			switch (versions.length) {
			case 5:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    values.add(new Integer(versions[2]));
			    types.add(integerType);
			    values.add(new Integer(versions[3]));
			    types.add(integerType);
			    values.add(versions[4]);
			    types.add(stringType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = ?)";
			    break;
			case 4:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    values.add(new Integer(versions[2]));
			    types.add(integerType);
			    values.add(new Integer(versions[3]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = ? and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			    break;
			case 3:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    values.add(new Integer(versions[2]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = null and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			    break;
			case 2:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = null and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = null and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			    break;
			case 1:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = null and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = null and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = null and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			case 0:
			    break;
			}
			constraint += ")";
		    }
		    return constraint;
		case V_GEQ:
		case V_GREATER:
		    versions = value.split("\\.", 5);
		    switch (versions.length) {
		    case 5:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			values.add(versions[4]);
			types.add(stringType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " > ?) or (" + column + " > ?)";
			break;
		    case 4:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[3]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " > ?) or ("
				+ column
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ " != null and length("
				+ column.replace("majorVersion", "remainingVersion")
					.replace("MajorVersion", "RemainingVersion")
				+ ") > 0)";
			break;
		    case 3:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[2]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " > ?) or ("
				+ column
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "revisionVersion")
					.replace("MajorVersion", "RevisionVersion")
				+ " != null)";
			break;
		    case 2:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[1]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " > ?) or ("
				+ column
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " = ? and "
				+ column.replace("majorVersion", "buildVersion")
					.replace("MajorVersion", "BuildVersion")
				+ " != null)";
			break;
		    case 1:
			values.add(new Integer(versions[0]));
			types.add(integerType);
			values.add(new Integer(versions[0]));
			types.add(integerType);
			constraint += "("
				+ column
				+ " > ?) or ("
				+ column
				+ " = ? and "
				+ column.replace("majorVersion", "minorVersion")
					.replace("MajorVersion", "MinorVersion")
				+ " != null)";
		    case 0:
			break;
		    }
		    if (opId == OperationId.V_GEQ) {
			constraint = "(" + constraint + ") or (";
			switch (versions.length) {
			case 5:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    values.add(new Integer(versions[2]));
			    types.add(integerType);
			    values.add(new Integer(versions[3]));
			    types.add(integerType);
			    values.add(versions[4]);
			    types.add(stringType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = ?)";
			    break;
			case 4:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    values.add(new Integer(versions[2]));
			    types.add(integerType);
			    values.add(new Integer(versions[3]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = ? and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			    break;
			case 3:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    values.add(new Integer(versions[2]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = null and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			    break;
			case 2:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    values.add(new Integer(versions[1]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = ? and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = null and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = null and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			    break;
			case 1:
			    values.add(new Integer(versions[0]));
			    types.add(integerType);
			    constraint += column
				    + " = ? and "
				    + column.replace("majorVersion", "minorVersion")
					    .replace("MajorVersion", "MinorVersion")
				    + " = null and "
				    + column.replace("majorVersion", "buildVersion")
					    .replace("MajorVersion", "BuildVersion")
				    + " = null and "
				    + column.replace("majorVersion", "revisionVersion")
					    .replace("MajorVersion", "RevisionVersion")
				    + " = null and ("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + " = null or length("
				    + column.replace("majorVersion", "remainingVersion")
					    .replace("MajorVersion", "RemainingVersion")
				    + ") = 0)";
			case 0:
			    break;
			}
			constraint += ")";
		    }
		    return constraint;
		case DATE_EQ:
		    try {
			aux = DateFormat.getDateInstance(DateFormat.SHORT, locale)
				.parse(value);
		    } catch (ParseException exception) {
			return "";
		    }
		    date = Calendar.getInstance();
		    date.setTime(aux);
		    date2 = Calendar.getInstance();
		    date2.setTime(aux);
	
		    values.add(date);
		    types.add(calendarType);
		    constraint += "(" + column + " >= ? and ";
		    date2.add(Calendar.DAY_OF_MONTH, 1);
		    values.add(date2);
		    types.add(calendarType);
		    constraint += column + " < ?)";
		    return constraint;
		case DATE_LESS:
		    try {
			aux = DateFormat.getDateInstance(DateFormat.SHORT, locale)
				.parse(value);
		    } catch (ParseException exception) {
			return "";
		    }
		    date = Calendar.getInstance();
		    date.setTime(aux);
		    values.add(date);
		    types.add(calendarType);
		    return column + " < ?";
		case DATE_GREATER:
		    try {
			aux = DateFormat.getDateInstance(DateFormat.SHORT, locale)
				.parse(value);
		    } catch (ParseException exception) {
			return "";
		    }
		    date = Calendar.getInstance();
		    date.setTime(aux);
		    date.add(Calendar.DAY_OF_MONTH, 1);
		    values.add(date);
		    types.add(calendarType);
		    return column + " >= ?";
		case DATE_GEQ:
		    try {
			aux = DateFormat.getDateInstance(DateFormat.SHORT, locale)
				.parse(value);
		    } catch (ParseException exception) {
			return "";
		    }
		    date = Calendar.getInstance();
		    date.setTime(aux);
		    values.add(date);
		    types.add(calendarType);
		    return column + " >= ?";
		case DATE_LEQ:
		    try {
			aux = DateFormat.getDateInstance(DateFormat.SHORT, locale)
				.parse(value);
		    } catch (ParseException exception) {
			return "";
		    }
		    date = Calendar.getInstance();
		    date.setTime(aux);
		    date.add(Calendar.DAY_OF_MONTH, 1);
		    values.add(date);
		    types.add(calendarType);
		    return column + " < ?";
		default:
		    return "";
		}
    }

    /**
     * Needs not void value.
     *
     * @param operation the operation
     * @return true, if successful
     */
    public static boolean needsNotVoidValue(String operation) {
		switch (operationIds.get(operation)) {
		case EQ_STR:
		case CONTAINS:
		case EQ_STR_CASE:
		case CONTAINS_CASE:
		case IS_TRUE:
		case IS_FALSE:
		case IS_NULL:
		    return false;
		default:
		    return true;
		}
    }
}