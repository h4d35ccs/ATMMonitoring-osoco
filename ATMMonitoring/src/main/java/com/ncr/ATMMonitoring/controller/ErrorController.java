package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * The Class ErrorController.
 * 
 * Controller for handling HTTP petitions that resulted in an error.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class ErrorController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(ErrorController.class
	    .getName());
    // KEY FOR ERRORS
    private static final String ERROR_ATTRIBUTE_KEY = "error";

    /**
     * 404 error.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/404" })
    public String error404(HttpServletRequest request,
	    HttpServletResponse response, RedirectAttributes redirectAttr) {

	redirectAttr.addFlashAttribute(ERROR_ATTRIBUTE_KEY, "404");
	logger.debug("error 404 on: " + getPreviousRequest(request));
	return "redirect:main";
    }

    /**
     * 403 error.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/403" })
    public String error403(Map<String, Object> map, HttpServletRequest request,
	    Principal principal, RedirectAttributes redirectAttr) {
	logger.warn("user : " + principal.getName()
		+ " is trying to access a non allowed resource: "
		+ getPreviousRequest(request));
	redirectAttr.addFlashAttribute(ERROR_ATTRIBUTE_KEY, "403");
	return "redirect:main";
    }

    /**
     * Generic error.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/error" })
    public String error(RedirectAttributes redirectAttr) {
	return "error";
    }

    /**
     * Shows the 404 page
     * 
     * @return
     */
    @RequestMapping(value = { "/show404" })
    public String error404Jsp() {
	return "404";
    }

    /**
     * Shows the 403 page
     * 
     * @return
     */
    @RequestMapping(value = { "/show403" })
    public String error403Jsp() {
	return "403";
    }

    /**
     * Gets the previous request that generate the call to one of the errors
     * 
     * @param request
     *            HttpServletRequest
     * @return String
     */
    private static String getPreviousRequest(HttpServletRequest request) {
	String prevoiusRequest = "";

	if (request.getAttribute("javax.servlet.forward.request_uri") != null) {
	    prevoiusRequest = request.getAttribute(
		    "javax.servlet.forward.request_uri").toString();
	}
	return prevoiusRequest;
    }

}
