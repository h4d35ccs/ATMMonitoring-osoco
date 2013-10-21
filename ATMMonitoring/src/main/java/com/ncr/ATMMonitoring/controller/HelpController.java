package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @author Rafael Luque (OSOCO)
 */
@Controller
public class HelpController {


    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String showDashboard(Map<String, Object> map, Principal principal, HttpServletRequest request) {
        return "help";
    }

}
