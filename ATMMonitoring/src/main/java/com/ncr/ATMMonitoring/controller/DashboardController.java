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

import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * @author Rafael Luque (OSOCO)
 */
@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(Map<String, Object> map, Principal principal, HttpServletRequest request) {
        String userMsg = "";
        Locale locale = RequestContextUtils.getLocale(request);
        if (principal != null) {
            User loggedUser = userService.getUserByUsername(principal.getName());
            userMsg = loggedUser.getHtmlWelcomeMessage(locale);
        }

        map.put("userMsg", userMsg);

        return "dashboard";
    }

}
