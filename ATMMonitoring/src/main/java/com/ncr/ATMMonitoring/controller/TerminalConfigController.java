package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.controller.propertyEditor.SoftwarePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.SoftwareService;
import com.ncr.ATMMonitoring.service.TerminalConfigService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class TerminalConfigController {

    @Autowired
    private TerminalConfigService terminalConfigService;
    @Autowired
    private SoftwareService softwareService;
    @Autowired
    private UserService userService;

    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Software.class, new SoftwarePropertyEditor(
		softwareService));
    }

    @RequestMapping("/terminals/swConfigs/details/{configId}")
    public String terminalConfigDetails(
	    @PathVariable("configId") Integer terminalConfigId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	TerminalConfig terminalConfig = terminalConfigService
		.getTerminalConfig(terminalConfigId);
	if (terminalConfig == null) {
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
	map.put("config", terminalConfig);

	return "terminalConfigDetails";
    }

    // Code with support for Terminal Config AUTHORS
    //
    // @RequestMapping(value = "/terminals/swConfigs/add", method =
    // RequestMethod.POST)
    // public String addTerminalConfig(
    // @ModelAttribute("newConfig") TerminalConfig config,
    // BindingResult result, Principal principal) {
    // if (principal != null) {
    // User loggedUser = userService.loadUserByUsername(principal
    // .getName());
    // if (loggedUser != null) {
    // config.setStartDate(new Date());
    // config.setAuthor(loggedUser);
    // terminalConfigService.addTerminalConfig(config);
    // }
    // }
    //
    // return "redirect:/terminals/details/" + config.getTerminal().getId();
    // }
}