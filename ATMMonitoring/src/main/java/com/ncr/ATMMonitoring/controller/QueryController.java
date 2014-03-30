package com.ncr.ATMMonitoring.controller;

import static com.ncr.ATMMonitoring.controller.helper.QueryCombosHelper.generateComboOptionsByDataType;
import static com.ncr.ATMMonitoring.controller.helper.QueryCombosHelper.generateDeviceTypeFieldComboOptions;
import static com.ncr.ATMMonitoring.controller.helper.QueryCombosHelper.generateFieldComboOptions;
import static com.ncr.ATMMonitoring.controller.helper.QueryCombosHelper.generateHardwareDeviceComboOptions;
import static com.ncr.ATMMonitoring.controller.helper.QueryCombosHelper.getQueryCombosActualValues;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.Hotfix;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.XfsComponent;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * The Class QueryController.
 * 
 * Controller for handling query related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */
@Controller
public class QueryController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(QueryController.class
	    .getName());

    /** The default field for sorting terminals in csv downloads. */
    public static final String DEFAULT_SORT = "serialNumber";

    /** The default sorting order for terminals in csv downloads. */
    public static final String DEFAULT_ORDER = "asc";

    private static final String COMBO_TYPE_TERMINAL = "terminal";
    private static final String COMBO_TYPE_FINANCIALDEVICE = "financialDevice";
    private static final String COMBO_TYPE_XFSCOMPONENT = "xfsComponent";
    private static final String COMBO_TYPE_JXFSCOMPONENT = "jxfsComponent";
    private static final String COMBO_TYPE_HOTFIX = "hotfix";
    private static final String COMBO_TYPE_IEXPLORER = "internetExplorer";
    private static final String COMBO_TYPE_OS = "operatingSystem";
    private static final String COMBO_TYPE_SOFTWARE = "software";
    private static final String COMBO_TYPE_XFSSW = "xfsSw";
    private static final String COMBO_TYPE_FEATSW = "featSw";
    private static final String COMBO_TYPE_HWDEVICE = "hardwareDevice";

    /** The query page size. */
    @Value("${config.queriesPageSize}")
    private int pageSize;

    /** The query service. */
    @Autowired
    private QueryService queryService;

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Create query URL.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/create", method = RequestMethod.GET)
    public String createQuery(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	// String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);

	// if (principal != null) {
	// userMsg = this.getUserGreeting(principal, request);
	// }

	String datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(
		DateFormat.SHORT, locale)).toLocalizedPattern();

	if (!datePattern.contains("dd")) {
	    datePattern = datePattern.replace("d", "dd");
	}

	// map.put("userMsg", userMsg);
	map.put("query", new Query());
	map.put("values", Query.getComboboxes());

	return "newQuery";

    }

    /**
     * Show user query URL.
     * 
     * @param queryId
     *            the query id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/show", method = RequestMethod.GET)
    public String showUserQuery(Integer queryId, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	// String userMsg = "";
	Query query = null;

	if (queryId != null) {
	    query = queryService.getQuery(queryId);
	}
	Locale locale = RequestContextUtils.getLocale(request);
	// if (principal != null) {
	// //userMsg = this.getUserGreeting(principal, request);
	// }
	Gson gson = new GsonBuilder().create();
	// map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("queryJson",
		(gson.toJson(getQueryCombosActualValues(query, locale))));

	// map.put("values", Query.getComboboxes());
	return "queries";

    }

    /**
     * Delete user query URL.
     * 
     * @param queryId
     *            the query id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/delete")
    public String deleteUserQuery(Integer queryId, Map<String, Object> map,
	    HttpServletRequest request, Principal principal,
	    final RedirectAttributes redirectAttributes) {

	Query query = null;
	if (queryId != null) {
	    query = queryService.getQuery(queryId);
	    if (query != null) {
		try {
		    queryService.deleteQuery(query);
		    redirectAttributes.addFlashAttribute("success",
			    "success.deletingNewQuery");

		} catch (Throwable e) {
		    redirectAttributes.addFlashAttribute("error",
			    "error.deletingQuery");
		}
	    }
	}
	return "redirect:/queries/list";
	// if (principal != null) {
	// //userMsg = this.getUserGreeting(principal, request);
	// }
	// PagedListHolder<Query> pagedListHolder = new PagedListHolder<Query>(
	// new ArrayList<Query>(userQueries));
	// int page = 0;
	//
	// pagedListHolder.setPage(page);
	// pagedListHolder.setPageSize(pageSize);
	// map.put("pagedListHolder", pagedListHolder);
	//
	// //map.put("userMsg", userMsg);
	//
	// return "queryList";

    }

    /**
     * Select user query URL.
     * 
     * @param query
     *            the query
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/create", method = RequestMethod.POST)
    public String selectUserQuery(@ModelAttribute("query") Query query,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Set<Query> userQueries = null;
	// String userMsg = "";

	Locale locale = RequestContextUtils.getLocale(request);

	if (query.getId() != null) {
	    query = queryService.getQuery(query.getId());
	    if (WebUtils.hasSubmitParameter(request, "delete")) {
		queryService.deleteQuery(query);
		query = new Query();
	    }
	} else {
	    query = new Query();
	}

	// if (principal != null) {
	// userMsg = this.getUserGreeting(principal, request);
	// }

	String datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(
		DateFormat.SHORT, locale)).toLocalizedPattern();

	if (!datePattern.contains("dd")) {
	    datePattern = datePattern.replace("d", "dd");
	}

	// map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("userQueries", userQueries);
	map.put("datePattern", datePattern);
	map.put("values", Query.getComboboxes());

	return "queries";

    }

    /**
     * Redirect to queries URL.
     * 
     * @return the petition response
     */
    @RequestMapping("/queries")
    public String redirectToQueries() {

	return "redirect:/queries/list";
    }

    /**
     * List queries URL.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @param p
     *            the page number
     * @return the petition response
     */
    @RequestMapping("/queries/list")
    public String listQueries(Map<String, Object> map,
	    HttpServletRequest request, Principal principal, String p) {
	Set<Query> userQueries = null;
	// String userMsg = "";

	if (principal != null) {
	    // userMsg = this.getUserGreeting(principal, request);
	    userQueries = this.queryService.getQueriesByUser(principal
		    .getName());
	}

	PagedListHolder<Query> pagedListHolder = new PagedListHolder<Query>(
		new ArrayList<Query>(userQueries));
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(pageSize);
	map.put("pagedListHolder", pagedListHolder);
	// map.put("userMsg", userMsg);
	return "queryList";
    }

    /**
     * Save or update query URL.
     * 
     * @param query
     *            the query
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @param redirectAttributes
     *            the redirect attributes
     * @param p
     *            the page number
     * @param sort
     *            the sort
     * @param order
     *            the order
     * @return the petition response
     * @throws Exception
     *             the exception
     */
    @RequestMapping(value = "/queries/results", method = RequestMethod.POST)
    public String saveOrUpdateQuery(@ModelAttribute("query") Query query,
	    @RequestParam("action") String action, Map<String, Object> map,
	    HttpServletRequest request, Principal principal,
	    RedirectAttributes redirectAttributes, String p, String sort,
	    String order) throws Exception {

	Locale locale = RequestContextUtils.getLocale(request);
	if (StringUtils.isNotEmpty(action) && action.equals("save")) {
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		query.setUser(loggedUser);
		if (query.getName() != null
			&& !query.getName().trim().isEmpty()) {
		    if (query.getId() != null) {
			try {
			    logger.debug("Updating query - " + query.getName());
			    queryService.updateQuery(query);
			    redirectAttributes.addFlashAttribute("success",
				    "success.updatingQuery");
			} catch (Exception e) {
			    redirectAttributes.addFlashAttribute("error",
				    "error.updatingQuery");
			}
		    } else {
			query.setCreationDate(new Date());
			query.setTrueLocale(locale);
			try {
			    logger.debug("Guardando nueva query- "
				    + query.getName());
			    queryService.addQuery(query);
			    redirectAttributes.addFlashAttribute("success",
				    "success.savingNewQuery");
			} catch (Exception e) {
			    redirectAttributes.addFlashAttribute("error",
				    "error.savingNewQuery");
			}
		    }
		} else {
		    map.put("error", "query.name.blank");
		    map.put("userMsg", loggedUser.getHtmlWelcomeMessage(locale));
		    map.put("query", query);
		    map.put("values", Query.getComboboxes());

		    return "newQuery";
		}
	    }
	    return "redirect:/queries/list";
	} else if (WebUtils.hasSubmitParameter(request, "update")) {
	    if (principal != null) {
		if (query.getId() != null) {
		    try {
			logger.debug("Updating query - " + query.getName());
			this.queryService.updateQuery(query,
				principal.getName());
			redirectAttributes.addFlashAttribute("success",
				"success.updatingQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error",
				"error.updatingQuery");
		    }
		} else {
		    query.setCreationDate(new Date());
		    query.setTrueLocale(locale);
		    try {
			logger.debug("Guardando nueva query- "
				+ query.getName());
			queryService.addQuery(query, principal.getName());
			redirectAttributes.addFlashAttribute("success",
				"success.savingNewQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error",
				"error.savingNewQuery");
		    }
		}
	    }
	    return "redirect:/queries/list";
	} else if (StringUtils.isNotEmpty(action) && action.equals("execute")) {
	    logger.debug("Executing query... " + query.getName());
	    String sortValue = (sort == null) ? DEFAULT_SORT : sort;
	    String orderValue = (order == null) ? DEFAULT_ORDER : order;
	    List<Terminal> terminals = queryService.executeQuery(query, locale,
		    sortValue, orderValue);

	    logger.debug("terminals " + terminals);

	    if (terminals == null) {
		throw new Exception("Query execution returned a NULL list.");
	    }

	    PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>(
		    terminals);
	    int page = 0;
	    if (p != null) {
		try {
		    page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
	    }
	    pagedListHolder.setPage(page);
	    pagedListHolder.setPageSize(pageSize);

	    logger.debug("pageListHolder " + pagedListHolder);

	    map.put("userMsg", this.getUserGreeting(principal, request));
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("query", query);
	    map.put("values", Query.getComboboxes());
	    map.put("p", page);
	    map.put("sort", sortValue);
	    map.put("order", orderValue);

	} else if (StringUtils.isNotEmpty(action) && action.equals("delete")) {
	    logger.debug("Deleting query -" + query.getName());
	    return "redirect:/queries/delete?queryId=" + query.getId();
	}
	return "queryResults";

    }

    /**
     * Wrong download query results as csv URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = "/queries/results", method = RequestMethod.GET)
    public String redirectFromWrongResults() {

	return "redirect:/queries/create";
    }

    /**
     * Wrong download query results as csv URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = "/queries/results/export", method = RequestMethod.GET)
    public String redirectFromWrongResultsExport() {
	return "redirect:/queries/create";
    }

    /**
     * Download query results as csv URL.
     * 
     * @param query
     *            the query
     * @param response
     *            the response
     * @param request
     *            the request
     * @param sort
     *            the fields for sorting the results
     * @param order
     *            the sorting order
     */
    @RequestMapping(value = "/queries/results/export", method = RequestMethod.POST)
    public void downloadResultsCsv(@ModelAttribute("query") Query query,
	    HttpServletResponse response, HttpServletRequest request,
	    String sort, String order) {
	try {
	    String sortValue = (sort == null) ? DEFAULT_SORT : sort;
	    String orderValue = (order == null) ? DEFAULT_ORDER : order;
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"terminals.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Terminal.getCsvHeader());
	    List<Terminal> terminals = queryService.executeQuery(query,
		    RequestContextUtils.getLocale(request), sortValue,
		    orderValue);
	    for (Terminal terminal : terminals) {
		outputwriter.write("\n" + terminal.getCsvDescription());
	    }
	    outputwriter.flush();
	    outputwriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    /**
     * Gets the content for the query combo
     * 
     * @param comboType
     * @return
     */
    @RequestMapping(value = "/queries/combos/{comboType}/{locale}", method = RequestMethod.GET)
    @ResponseBody
    public String getComboForQueries(
	    @PathVariable("comboType") String comboType,
	    @PathVariable("locale") String localeParam) {

	Map<String, String> options = null;

	Locale locale = getLocale(localeParam);

	if (comboType.equals(COMBO_TYPE_TERMINAL)) {
	    options = generateFieldComboOptions(Terminal.class, comboType,
		    locale);
	} else {
	    if (comboType.equals(COMBO_TYPE_FINANCIALDEVICE)) {
		options = generateFieldComboOptions(FinancialDevice.class,
			comboType, locale);
	    } else {
		if (comboType.equals(COMBO_TYPE_XFSCOMPONENT)) {
		    options = generateFieldComboOptions(XfsComponent.class,
			    comboType, locale);
		} else {
		    if (comboType.equals(COMBO_TYPE_JXFSCOMPONENT)) {
			options = generateFieldComboOptions(
				JxfsComponent.class, comboType, locale);
		    } else {
			if (comboType.equals(COMBO_TYPE_HOTFIX)) {
			    options = generateFieldComboOptions(Hotfix.class,
				    comboType, locale);
			} else {
			    if (comboType.equals(COMBO_TYPE_IEXPLORER)) {
				options = generateFieldComboOptions(
					InternetExplorer.class, comboType,
					locale);
			    } else {
				if (comboType.equals(COMBO_TYPE_OS)) {
				    options = generateFieldComboOptions(
					    OperatingSystem.class, comboType,
					    locale);
				} else {
				    if (comboType.equals(COMBO_TYPE_SOFTWARE)) {
					options = generateFieldComboOptions(
						Software.class, comboType,
						locale);
				    } else {
					if (comboType.equals(COMBO_TYPE_XFSSW)) {
					    options = generateFieldComboOptions(
						    Software.class, comboType,
						    locale);
					} else {
					    if (comboType
						    .equals(COMBO_TYPE_FEATSW)) {
						options = generateFieldComboOptions(
							Software.class,
							comboType, locale);
					    } else {
						if (comboType
							.equals(COMBO_TYPE_HWDEVICE)) {
						    options = generateHardwareDeviceComboOptions(locale);
						} else {
						    logger.warn("unrecognized option to generate query combobox: "
							    + comboType);
						}
					    }
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}
	return generateComboboxOptionsJSON(this.sortHashMapByValues(options));
    }

    /**
     * Generates the options for the comparison combobox
     * 
     * @param comboType
     * @param fieldname
     * @param localeParam
     * @return String
     */
    @RequestMapping(value = "/queries/combos/comparison/{comboType}/{fieldname}/{locale}", method = RequestMethod.GET)
    @ResponseBody
    public String getComboOptionsComparisionOperation(
	    @PathVariable("comboType") String comboType,
	    @PathVariable("fieldname") String fieldname,
	    @PathVariable("locale") String localeParam) {

	Map<String, String> options = null;
	Locale locale = getLocale(localeParam);

	if (comboType.equals(COMBO_TYPE_TERMINAL)) {
	    options = generateComboOptionsByDataType(Terminal.class, fieldname,
		    locale);
	} else {
	    if (comboType.equals(COMBO_TYPE_FINANCIALDEVICE)) {
		options = generateComboOptionsByDataType(FinancialDevice.class,
			fieldname, locale);
	    } else {
		if (comboType.equals(COMBO_TYPE_XFSCOMPONENT)) {
		    options = generateComboOptionsByDataType(
			    XfsComponent.class, fieldname, locale);
		} else {
		    if (comboType.equals(COMBO_TYPE_JXFSCOMPONENT)) {
			options = generateComboOptionsByDataType(
				JxfsComponent.class, fieldname, locale);
		    } else {
			if (comboType.equals(COMBO_TYPE_HOTFIX)) {
			    options = generateComboOptionsByDataType(
				    Hotfix.class, fieldname, locale);
			} else {
			    if (comboType.equals(COMBO_TYPE_IEXPLORER)) {
				options = generateComboOptionsByDataType(
					InternetExplorer.class, fieldname,
					locale);
			    } else {
				if (comboType.equals(COMBO_TYPE_OS)) {
				    options = generateComboOptionsByDataType(
					    OperatingSystem.class, fieldname,
					    locale);
				} else {
				    if (comboType.equals(COMBO_TYPE_SOFTWARE)) {
					options = generateComboOptionsByDataType(
						Software.class, fieldname,
						locale);
				    } else {
					if (comboType.equals(COMBO_TYPE_XFSSW)) {
					    options = generateComboOptionsByDataType(
						    Software.class, fieldname,
						    locale);
					} else {
					    if (comboType
						    .equals(COMBO_TYPE_FEATSW)) {
						options = generateComboOptionsByDataType(
							Software.class,
							fieldname, locale);
					    } else {
						if (comboType
							.equals(COMBO_TYPE_HWDEVICE)) {
						    options = generateComboOptionsByDataType(
							    HardwareDevice.class,
							    fieldname, locale);
						} else {
						    logger.warn("unrecongnized option to generate query combobox: "
							    + comboType);
						}
					    }
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}

	return this.generateComboboxOptionsJSON(this
		.sortHashMapByValues(options));
    }

    @RequestMapping(value = "/queries/combos/comparison/{deviceType}/{locale}", method = RequestMethod.GET)
    @ResponseBody
    public String getComboOptionsFieldsByDeviceType(
	    @PathVariable("deviceType") String deviceType,
	    @PathVariable("locale") String localeParam) {

	Map<String, String> options = null;
	Locale locale = getLocale(localeParam);

	options = generateDeviceTypeFieldComboOptions(HardwareDevice.class,
		deviceType, locale);
	// switch (deviceType) {
	// case ComboQueryOption.GROUP_HARDWARE_1394_CONTROLLER:
	// generateDeviceTypeFieldComboOptions(HardwareDevice.class,deviceType)

	// break;
	//
	// case ComboQueryOption.GROUP_HARDWARE_BASE_BOARD:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_BIOS:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_CDROM_DRIVE:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_COMPUTER_SYSTEM:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_DESKTOP_MONITOR:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_DISK_DRIVE:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_DISPLAY_CONFIGURATION:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_FLOPPY_DRIVE:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_KEYBOARD:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_LOGICAL_DISK:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_NETWORK_ADAPTER:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_PARALLEL_PORT:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_PHYSICAL_MEMORY:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_POINTING_DEVICE:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_PROCESSOR:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_SCSI_CONTROLLER:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_SERIAL_PORT:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_SOUND_DEVICE:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_SYSTEM_SLOT:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_USB_CONTROLLER:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_USB_HUB:
	// break;
	// case ComboQueryOption.GROUP_HARDWARE_VIDEO_CONTROLLER:
	// break;
	//
	// }
	return this.generateComboboxOptionsJSON(this
		.sortHashMapByValues(options));
    }

    /**
     * Gets the default locale
     * 
     * @param localeParam
     *            String with a valid locale such as en, es,fr, etc
     * @return
     */
    private Locale getLocale(String localeParam) {
	Locale locale = null;
	if (localeParam == null) {

	    locale = Locale.getDefault();
	} else {
	    locale = new Locale(localeParam);
	}
	return locale;
    }

    /**
     * Sorts the contents of a map based on the values
     * 
     * @param passedMap
     * @return
     */
    private LinkedHashMap<String, String> sortHashMapByValues(
	    Map<String, String> passedMap) {
	List<String> mapKeys = new ArrayList<String>(passedMap.keySet());
	List<String> mapValues = new ArrayList<String>(passedMap.values());
	Collections.sort(mapValues);
	Collections.sort(mapKeys);

	LinkedHashMap<String, String> sortedMap = new LinkedHashMap<String, String>();

	Iterator<String> valueIt = mapValues.iterator();
	while (valueIt.hasNext()) {
	    Object val = valueIt.next();
	    Iterator<String> keyIt = mapKeys.iterator();

	    while (keyIt.hasNext()) {
		Object key = keyIt.next();
		String comp1 = passedMap.get(key).toString();
		String comp2 = val.toString();

		if (comp1.equals(comp2)) {
		    passedMap.remove(key);
		    mapKeys.remove(key);
		    sortedMap.put((String) key, (String) val);
		    break;
		}

	    }

	}
	return sortedMap;
    }

}
