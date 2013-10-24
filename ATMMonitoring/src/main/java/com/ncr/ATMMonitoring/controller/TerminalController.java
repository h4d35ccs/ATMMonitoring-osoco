package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.snmp.SnmpService;
import com.ncr.ATMMonitoring.snmp.SnmpTimeOutException;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class TerminalController {

    @Value("${security.terminalsManagementAllowedRoles}")
    private String canAlterTerminalsRoles;
    @Value("${security.scheduledUpdatesAccessAllowedRoles}")
    private String canManageScheduledUpdatesRoles;
    @Value("${config.terminalsPageSize}")
    private int pageSize;

    @Autowired
    private TerminalService terminalService;
    @Autowired
    private UserService userService;
    @Autowired
    private SnmpService snmpService;

    // @Autowired
    // private SoftwareService softwareService;

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
	return "redirect:/terminals/details/" + terminalId;
    }

    @RequestMapping(value = "/terminals/list", method = RequestMethod.GET)
    public String listTerminals(Map<String, Object> map, Principal principal,
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
	map.put("terminal", new Terminal());
	PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>(
		terminalService.listTerminals());
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
	map.put("userMsg", userMsg);
	boolean canEdit = false;
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getRole() != null)
		    && (canAlterTerminalsRoles.contains("'ROLE_"
			    + loggedUser.getRole().getName().toUpperCase()
			    + "'"))) {
		canEdit = true;
	    }
	}
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

    @RequestMapping(value = "/terminals/list", method = RequestMethod.POST)
    public String addTerminal(
	    @Valid @ModelAttribute("terminal") Terminal terminal,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
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
	if (result.hasErrors()) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    map.put("terminalsList", terminalService.listTerminals());
	    return "terminals";
	}

	if (terminalService.loadTerminalBySerialNumber(terminal
		.getSerialNumber()) != null) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    map.put("duplicatedSerialNumber", true);
	    map.put("terminalsList", terminalService.listTerminals());
	    return "terminals";
	}
	if (terminalService.loadTerminalByIp(terminal.getIp()) != null) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    map.put("duplicatedIp", true);
	    map.put("terminalsList", terminalService.listTerminals());
	    return "terminals";
	}

	if (terminalService.loadTerminalByMac(terminal.getMac()) != null) {
	    map.put("userMsg", userMsg);
	    map.put("canAdd", canAdd);
	    map.put("duplicatedMac", true);
	    map.put("terminalsList", terminalService.listTerminals());
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
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	boolean canEdit = false;
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
	}
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
	    map.put("terminalsList", terminalService.listTerminals());
	    return "terminalDetails";
	}
	auxTerminal = terminalService.loadTerminalByIp(terminal.getIp());
	if ((auxTerminal != null)
		&& (!auxTerminal.getId().equals(terminal.getId()))) {
	    map.put("duplicatedIp", true);
	    map.put("terminalsList", terminalService.listTerminals());
	    return "terminalDetails";
	}
	auxTerminal = terminalService.loadTerminalByMac(terminal.getMac());
	if ((auxTerminal != null)
		&& (!auxTerminal.getId().equals(terminal.getId()))) {
	    map.put("duplicatedMac", true);
	    map.put("terminalsList", terminalService.listTerminals());
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

    @RequestMapping("/terminals/installation")
    public String terminalInstallation() {
    	return "terminalInstallation";
    }

}
