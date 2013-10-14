package com.ncr.ATMMonitoring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome() {
	return "redirect:/login";
    }

    @RequestMapping("/")
    public String redirectToIndex() {
	return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

	return "login";

    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailed(Map<String, Object> map) {

	map.put("error", true);

	return "login";

    }
}