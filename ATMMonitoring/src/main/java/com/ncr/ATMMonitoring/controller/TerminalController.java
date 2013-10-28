package com.ncr.ATMMonitoring.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.controller.propertyEditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.snmp.SnmpService;
import com.ncr.ATMMonitoring.snmp.SnmpTimeOutException;

import org.apache.log4j.Logger;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class TerminalController {

    static private Logger logger = Logger.getLogger(DashboardController.class.getName());

    @Value("${security.terminalsManagementAllowedRoles}")
    private String canAlterTerminalsRoles;
    @Value("${security.scheduledUpdatesAccessAllowedRoles}")
    private String canManageScheduledUpdatesRoles;
    @Value("${config.terminalsPageSize}")
    private int pageSize;
    @Value("${config.terminalModelsPageSize}")
    private int terminalModelsPageSize;

    @Autowired
    private TerminalService terminalService;
    @Autowired
    private TerminalModelService terminalModelService;
    @Autowired
    private InstallationService installationService;
    @Autowired
    private QueryService queryService;
    @Autowired
    private UserService userService;
    @Autowired
    private SnmpService snmpService;

    // @Autowired
    // private SoftwareService softwareService;

    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DatePropertyEditor());
    }

    @RequestMapping(value = "/terminals/request", method = RequestMethod.GET)
    public String requestTerminalsUpdate(Map<String, Object> map, HttpServletRequest request, Principal principal) {
		try {
		    snmpService.updateAllTerminalsSnmp();
		} catch (SnmpTimeOutException e) {
		    String userMsg = "";
		    Locale locale = RequestContextUtils.getLocale(request);
		    if (principal != null) {
			User loggedUser = userService.getUserByUsername(principal
				.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		    }
		    map.put("userMsg", userMsg);
		    map.put("ips", e.getIpsHtmlList());
		    return "snmpTimeOut";
		}

		try {
		    // We wait to avoid not loading the recently added DB data
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/list";
    }

    @RequestMapping("/terminals/request/{terminalId}")
    public String requestTerminalUpdate(
	    @PathVariable("terminalId") Integer terminalId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal)
    {
		Terminal terminal = terminalService.getTerminal(terminalId);
		if (terminal == null) {
			map.clear();
			return "redirect:/terminals/list";
		}
		try {
			snmpService.updateTerminalSnmp(terminal);
		} catch (SnmpTimeOutException e) {
			String userMsg = "";
			Locale locale = RequestContextUtils.getLocale(request);
			if (principal != null) {
				User loggedUser = userService.getUserByUsername(principal.getName());
				userMsg = loggedUser.getHtmlWelcomeMessage(locale);
				Set<BankCompany> bankCompanies = loggedUser
					.getManageableBankCompanies();
				if ((terminal.getBankCompany() != null)
					&& (!bankCompanies.contains(terminal.getBankCompany()))) {
					map.clear();
					return "redirect:/terminals/list";
				}
			}
			map.put("userMsg", userMsg);
			map.put("ips", e.getIpsHtmlList());
			return "snmpTimeOut";
		}

		try {
			// We wait to avoid not loading the recently added DB data
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/details/" + terminalId;
    }

    @RequestMapping(value = "/terminals/list", method = RequestMethod.GET)
    public String listTerminals(Map<String, Object> map, Principal principal,
	    String p, HttpServletRequest request) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	boolean canAdd = false, canManageScheduled = false;
	PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>();
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	Set<Query> userQueries = null;
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getRole() != null)
		    && (canAlterTerminalsRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canAdd = true;
	    }
	    if ((loggedUser.getRole() != null)
		    && (canManageScheduledUpdatesRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canManageScheduled = true;
	    }
	    pagedListHolder = new PagedListHolder<Terminal>(
		    terminalService.listTerminalsByBankCompanies(loggedUser.getManageableBankCompanies()));
	    bankCompanies = loggedUser.getManageableBankCompanies();
	    userQueries = loggedUser.getQueries();
	}
	map.put("banksList", bankCompanies);
	map.put("terminalModelsList", terminalModelService.listTerminalModels());
	map.put("installationsList", installationService.listInstallations());
	map.put("userQueries", userQueries);
	map.put("userMsg", userMsg);
	map.put("canAdd", canAdd);
	map.put("canManageScheduled", canManageScheduled);
	map.put("terminal", new Terminal());
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

	return "terminals";
    }

    @RequestMapping(value = { "/terminals" })
    public String redirectToTerminals() {
	return "redirect:/terminals/list";
    }

    @RequestMapping("/terminals/details/{terminalId}")
    public String terminalDetails(
	    @PathVariable("terminalId") Integer terminalId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Terminal terminal = terminalService.getTerminal(terminalId);
	if (terminal == null) {
	    map.clear();
	    return "redirect:/terminals/list";
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	boolean canEdit = false;
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getRole() != null)
		    && (canAlterTerminalsRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canEdit = true;
	    }
	    bankCompanies = loggedUser.getManageableBankCompanies();
	    if ((terminal.getBankCompany() != null)
		    && (!bankCompanies.contains(terminal.getBankCompany()))) {
			map.clear();
			return "redirect:/terminals/list";
	    }
	}
	map.put("banksList", bankCompanies);
	map.put("terminalModelsList", terminalModelService.listTerminalModels());
	map.put("installationsList", installationService.listInstallations());
	map.put("userMsg", userMsg);
	map.put("canEdit", canEdit);
	map.put("terminal", terminal);
	// Code with support for Terminal Config AUTHORS
	//
	// TerminalConfig newConfig = new TerminalConfig();
	// if (terminal.getCurrentConfig() != null) {
	// newConfig.setSoftware(terminal.getCurrentConfig().getSoftware());
	// }
	// newConfig.getTerminal().setId(terminalId);
	// map.put("newConfig", newConfig);
	//
	// map.put("softwareList", softwareService.listSoftware());

	return "terminalDetails";
    }

    @RequestMapping(value="/terminals/new", method = RequestMethod.GET)
    public String addTerminal(Map<String, Object> map, HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	boolean canAdd = false;
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getRole() != null)
		    && (canAlterTerminalsRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canAdd = true;
	    }
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	map.put("userMsg", userMsg);
	map.put("canAdd", canAdd);
        map.put("terminal", new Terminal());

	return "newTerminal";
   }

   @RequestMapping(value = "/terminals/list", method = RequestMethod.POST)
    public String addTerminal(
	    @Valid @ModelAttribute("terminal") Terminal terminal,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((terminal.getBankCompany() != null)
		&& (terminal.getBankCompany().getId() == null)) {
	    terminal.setBankCompany(null);
	}
	if ((terminal.getInstallation() != null)
		&& (terminal.getInstallation().getId() == null)) {
	    terminal.setInstallation(null);
	}
	if ((terminal.getTerminalModel() != null)
		&& (terminal.getTerminalModel().getId() == null)) {
	    terminal.setTerminalModel(null);
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	boolean canAdd = false;
	PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>();
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getRole() != null)
		    && (canAlterTerminalsRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canAdd = true;
	    }
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    pagedListHolder = new PagedListHolder<Terminal>(
		    terminalService.listTerminalsByBankCompanies(loggedUser
			    .getManageableBankCompanies()));
	    bankCompanies = loggedUser.getManageableBankCompanies();
	    if ((terminal.getBankCompany() != null)
		    && (!bankCompanies.contains(terminal.getBankCompany()))) {
		map.clear();
		return "redirect:/terminals/list";
	    }
	}
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(terminalsPageSize);
	map.put("pagedListHolder", pagedListHolder);
	map.put("banksList", bankCompanies);
	map.put("terminalModelsList", terminalModelService.listTerminalModels());
	map.put("installationsList", installationService.listInstallations());
	if (result.hasErrors()) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    return "terminals";
	}

	if (terminalService.loadTerminalBySerialNumber(terminal
		.getSerialNumber()) != null) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    map.put("duplicatedSerialNumber", true);
	    return "terminals";
	}
	if (terminalService.loadTerminalByIp(terminal.getIp()) != null) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    map.put("duplicatedIp", true);
	    return "terminals";
	}

	if (terminalService.loadTerminalByMac(terminal.getMac()) != null) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    map.put("duplicatedMac", true);
	    return "terminals";
	}

	terminalService.addTerminal(terminal);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/list";
    }

    @RequestMapping(value = "/terminals/update", method = RequestMethod.POST)
    public String updateTerminal(
	    @Valid @ModelAttribute("terminal") Terminal terminal,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((terminal.getBankCompany() != null)
		&& (terminal.getBankCompany().getId() == null)) {
	    terminal.setBankCompany(null);
	}
	if ((terminal.getInstallation() != null)
		&& (terminal.getInstallation().getId() == null)) {
	    terminal.setInstallation(null);
	}
	if ((terminal.getTerminalModel() != null)
		&& (terminal.getTerminalModel().getId() == null)) {
	    terminal.setTerminalModel(null);
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	boolean canEdit = false;
	List<Terminal> terminals = new ArrayList<Terminal>();
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getRole() != null)
		    && (canAlterTerminalsRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canEdit = true;
	    }
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    terminals = terminalService.listTerminalsByBankCompanies(loggedUser
		    .getManageableBankCompanies());
	    bankCompanies = loggedUser.getManageableBankCompanies();
	}
	map.put("banksList", bankCompanies);
	map.put("terminalModelsList", terminalModelService.listTerminalModels());
	map.put("installationsList", installationService.listInstallations());
	map.put("terminalsList", terminals);
	map.put("userMsg", userMsg);
	map.put("canEdit", canEdit);
	if (result.hasErrors()) {
	    return "terminalDetails";
	}

	Terminal auxTerminal = terminalService
		.loadTerminalBySerialNumber(terminal.getSerialNumber());
	if ((auxTerminal != null)
		&& (!auxTerminal.getId().equals(terminal.getId()))) {
	    map.put("duplicatedSerialNumber", true);
	    return "terminalDetails";
	}
	auxTerminal = terminalService.loadTerminalByIp(terminal.getIp());
	if ((auxTerminal != null)
		&& (!auxTerminal.getId().equals(terminal.getId()))) {
	    map.put("duplicatedIp", true);
	    return "terminalDetails";
	}
	auxTerminal = terminalService.loadTerminalByMac(terminal.getMac());
	if ((auxTerminal != null)
		&& (!auxTerminal.getId().equals(terminal.getId()))) {
	    map.put("duplicatedMac", true);
	    return "terminalDetails";
	}

	auxTerminal = terminalService.getTerminal(terminal.getId());
	auxTerminal.replaceTerminalData(terminal);
	terminalService.updateTerminal(auxTerminal);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/details/" + terminal.getId().intValue();
    }

    @RequestMapping(value="terminals/byQuery")
    public String listTerminalsByQuery(Map<String, Object> map,
				       Integer queryId,
				       Principal principal,
				       String p, HttpServletRequest request) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
        Set<Query> userQueries = null;
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	boolean canAdd = false, canManageScheduled = false;
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getRole() != null)
		    && (canAlterTerminalsRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canAdd = true;
	    }
	    if ((loggedUser.getRole() != null)
		    && (canManageScheduledUpdatesRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canManageScheduled = true;
	    }
	    userQueries = loggedUser.getQueries();
	}
        map.put("userQueries", userQueries);
	map.put("userMsg", userMsg);
	map.put("canAdd", canAdd);
	map.put("canManageScheduled", canManageScheduled);
        Query query= null;
	List<Terminal> terminals = null;
        logger.debug ("Query ID: " + queryId);
        if (queryId != null) {
	    query = queryService.getQuery(queryId);
	    terminals= queryService.executeQuery(query, locale);
        }
        if (terminals == null) {
            terminals = terminalService.listTerminals();

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
        map.put("query", query);
	map.put("pagedListHolder", pagedListHolder);

	return "terminals";
    }

    @RequestMapping(value = { "/terminals/models" })
    public String redirectToTerminalModels() {
	return "redirect:/terminals/models/list";
    }

    @RequestMapping(value = "/terminals/models/list", method = RequestMethod.GET)
    public String listTerminalModels(Map<String, Object> map,
	    Principal principal, String p, HttpServletRequest request) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	PagedListHolder<TerminalModel> pagedListHolder = new PagedListHolder<TerminalModel>(
		terminalModelService.listTerminalModels());
	map.put("userMsg", userMsg);
	map.put("terminalModel", new TerminalModel());
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(terminalModelsPageSize);
	map.put("pagedListHolder", pagedListHolder);

	return "terminalModels";
    }

    @RequestMapping(value = "/terminals/models/list", method = RequestMethod.POST)
    public String addTerminalModel(
	    @Valid @ModelAttribute("terminalModel") TerminalModel terminalModel,
	    @RequestParam("file") CommonsMultipartFile photo,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, String p, Principal principal) {

	if (photo != null) {
	    terminalModel.setPhoto(photo.getBytes());
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	if (result.hasErrors()) {
	    PagedListHolder<TerminalModel> pagedListHolder = new PagedListHolder<TerminalModel>(
		    terminalModelService.listTerminalModels());
	    map.put("userMsg", userMsg);
	    int page = 0;
	    if (p != null) {
		try {
		    page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
	    }
	    pagedListHolder.setPage(page);
	    pagedListHolder.setPageSize(terminalModelsPageSize);
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("userMsg", userMsg);
	    return "terminalModels";
	}

	terminalModelService.addTerminalModel(terminalModel);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/models/list";
    }

    @RequestMapping("/terminals/models/details/{terminalModelId}")
    public String terminalModelDetails(
	    @PathVariable("terminalModelId") Integer terminalModelId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	TerminalModel terminalModel = terminalModelService
		.getTerminalModel(terminalModelId);
	if (terminalModel == null) {
	    map.clear();
	    return "redirect:/terminals/models/list";
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	map.put("terminalModel", terminalModel);

	return "terminalModelDetails";
    }

    @RequestMapping(value = "/terminals/models/update", method = RequestMethod.POST)
    public String updateTerminalModel(
	    @Valid @ModelAttribute("terminalModel") TerminalModel terminalModel,
	    @RequestParam("file") CommonsMultipartFile photo,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((photo != null) && (photo.getSize() > 0)) {
	    terminalModel.setPhoto(photo.getBytes());
	}

	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	if (result.hasErrors()) {
	    return "terminalModelDetails";
	}

	terminalModelService.updateTerminalModel(terminalModel);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/models/details/"
		+ terminalModel.getId().intValue();
    }

    @RequestMapping("/terminals/models/delete/{terminalModelId}")
    public String deleteTerminalModel(
	    @PathVariable("terminalModelId") Integer terminalModelId,
	    Principal principal) {
	TerminalModel terminalModel = terminalModelService
		.getTerminalModel(terminalModelId);
	if (terminalModel != null) {
	    terminalModelService.removeTerminalModel(terminalModelId);
	}

	return "redirect:/terminals/models/list";
    }

    @RequestMapping(value = { "terminals/models/image/{terminalModelId}" })
    public void getTerminalModelImage(
	    @PathVariable("terminalModelId") Integer terminalModelId,
	    HttpServletRequest request, HttpServletResponse response) {
	// get the thumb from the user entity

	TerminalModel model = terminalModelService
		.getTerminalModel(terminalModelId);
	try {
	    if ((model != null) && (model.getPhoto() != null)) {
		byte[] bytearray = model.getPhoto();
		BufferedOutputStream output = new BufferedOutputStream(
			response.getOutputStream());
		output.write(bytearray, 0, bytearray.length);
		output.close();
	    } else {
		response.sendRedirect("../../list");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
