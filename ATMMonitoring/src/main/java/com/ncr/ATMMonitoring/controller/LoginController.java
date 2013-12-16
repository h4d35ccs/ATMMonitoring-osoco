package com.ncr.ATMMonitoring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class LoginController {

    /**
     * Prints the welcome.
     *
     * @return the string
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome() {
	return "redirect:/login";
    }

    /**
     * Redirect to index.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String redirectToIndex() {
	return "redirect:/login";
    }

    /**
     * Login.
     *
     * @return the string
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
	return "login";
    }

    /**
     * Login failed.
     *
     * @param map the map
     * @return the string
     */
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailed(Map<String, Object> map) {
	map.put("error", true);
	return "login";
    }
}