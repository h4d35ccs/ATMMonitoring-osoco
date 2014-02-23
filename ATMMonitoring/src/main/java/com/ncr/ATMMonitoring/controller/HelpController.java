package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * The Class HelpController.
 * 
 * Controller for handling help related HTTP petitions.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */
@Controller
public class HelpController {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Show default help URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param request
     *            the request
     * @return the petition response
     */
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String showHelp(Map<String, Object> map, Principal principal,
	    HttpServletRequest request) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	return "redirect:/help/user-main";
    }

    /**
     * Show section help URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param request
     *            the request
     * @return the petition response
     */
    @RequestMapping(value = "/help/{section}", method = RequestMethod.GET)
    public String showDashboardHelp(@PathVariable("section") String section,
	    Map<String, Object> map, Principal principal,
	    HttpServletRequest request) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	map.put("section", section);
	return "helpTemplate";
    }

}
