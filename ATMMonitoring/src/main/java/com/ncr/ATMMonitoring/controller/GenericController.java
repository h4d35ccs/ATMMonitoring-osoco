package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * The class GenericController
 * 
 * Holds the common method between the controllers
 * 
 * @author Otto Abreu
 * 
 */
@Controller
public abstract class GenericController {

    /** The User service. */
    @Autowired
    private UserService userService;

    /** The user greeting session parameter id. */
    private static final String USER_GREETING = "userGreeting";
    private static final String USER_LOGINTIME = "logintime";

    /**
     * Obtains the greeting for the user from the current session (or from DB if
     * the session doesn't have it).
     * 
     * @param principal
     *            the user principal
     * @param request
     *            the http request
     * @return the greeting message
     */
    protected String getUserGreeting(Principal principal,
	    HttpServletRequest request) {

	String greeting = (String) request.getSession().getAttribute(
		USER_GREETING);

	if (greeting == null) {

	    User user = this.userService.getUserByUsername(principal.getName());
	    greeting = this.getUserGreetingFromUser(user, request);
	}
	return greeting;
    }

    /**
     * Gets the last login time for the user and put it ito the session
     * 
     * @param principal
     * @param request
     * @return
     */
    protected long getUserLastLogin(Principal principal,
	    HttpServletRequest request) {

	Long lastLogin = (Long) request.getSession().getAttribute(
		USER_LOGINTIME);

	if (lastLogin == null) {

	    User user = this.userService.getUserByUsername(principal.getName());
	    if (user.getLastLogin() != null) {

		lastLogin = user.getLastLogin().getTime();

	    } else {
		lastLogin = new Date().getTime();
	    }
	    request.getSession().setAttribute(USER_LOGINTIME, lastLogin);
	}
	return lastLogin;
    }

    /**
     * Obtains the greeting for the user from the current session (or from DB if
     * the session doesn't have it).
     * 
     * @param loggedUser
     *            the logged user
     * @param request
     *            the http request
     * @return the greeting message
     */
    protected String getUserGreeting(User loggedUser, HttpServletRequest request) {

	String greeting = (String) request.getSession().getAttribute(
		USER_GREETING);

	if (greeting == null) {

	    greeting = this.getUserGreetingFromUser(loggedUser, request);
	}
	return greeting;
    }

    /**
     * Clears a value from the session.
     * 
     * @param request
     *            the http request
     * @param sessionKey
     *            the value to clear
     */
    protected void clearSession(HttpServletRequest request, String sessionKey) {
	request.getSession().setAttribute(sessionKey, null);
    }

    /**
     * Obtains the greeting for the user from DB.
     * 
     * @param loggedUser
     *            the logged user
     * @param request
     *            the http request
     * @return the greeting message
     */
    private String getUserGreetingFromUser(User loggedUser,
	    HttpServletRequest request) {
	String greeting = "";
	Locale locale = RequestContextUtils.getLocale(request);
	greeting = loggedUser.getHtmlWelcomeMessage(locale);
	request.getSession().setAttribute(USER_GREETING, greeting);

	return greeting;
    }

    /**
     * Generates a JSON response like {response: success}
     * 
     * @param isError
     * @return String
     */
    protected String generateJsonResponse(boolean isError) {
	final Map<String, String> response = new HashMap<String, String>();
	final String responseKey = "response";
	String responseType = "success";
	if (isError) {
	    responseType = "error";
	}
	response.put(responseKey, responseType);
	Gson gson = new GsonBuilder().create();
	return gson.toJson(response);
    }

    /**
     * Generates a JSON response like {response: success}
     * 
     * @param isError
     * @return String
     */
    protected String generateJsonResponse(boolean isError,
	    Map<String, String> otherParamsToResponse) {
	final Map<String, String> response = new HashMap<String, String>();
	final String responseKey = "response";
	String responseType = "success";
	if (isError) {
	    responseType = "error";
	}
	response.put(responseKey, responseType);
	response.putAll(otherParamsToResponse);
	Gson gson = new GsonBuilder().create();
	return gson.toJson(response);
    }

    /**
     * Encodes a image to be send inside a JSON message
     * 
     * @param imagename
     *            name to give to the image
     * @param imageType
     *            arbitrary type given
     * @param imageBytes
     *            byte array
     * @param aditionalParams
     *            aditional params to send
     * @return String
     */
    protected String generatelImageForJson(String imagename, String imageType,
	    byte[] imageBytes, Map<String, String> aditionalParams) {
	final Map<String, String> response = new HashMap<String, String>();
	final String imageNameKey = "imagename";
	final String imageTypeKey = "imagetype";
	final String imagekey = "imagebinary";
	String imageBase64 = null;

	if (imageBytes != null) {

	    imageBase64 = Base64.encodeBase64String(imageBytes);
	}

	response.put(imageNameKey, imagename);
	response.put(imageTypeKey, imageType);
	response.put(imagekey, imageBase64);

	if (aditionalParams != null) {

	    response.putAll(aditionalParams);
	}
	Gson gson = new GsonBuilder().create();
	return gson.toJson(response);
    }

    /**
     * Generate a json for comboboxes
     * 
     * @param options
     * @return
     */
    protected String generateComboboxOptionsJSON(Map<String, String> options) {

	final Map<String, Object> responseMap = new HashMap<String, Object>();
	responseMap.put("selectoptions", options);
	responseMap.put("optionslength", options.size());
	Gson gson = new GsonBuilder().create();
	return gson.toJson(responseMap);
    }
}
