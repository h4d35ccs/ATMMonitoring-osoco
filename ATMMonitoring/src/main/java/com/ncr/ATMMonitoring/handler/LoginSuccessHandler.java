package com.ncr.ATMMonitoring.handler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * The handler LoginSuccessHandler.
 * 
 * Custom login success handler that sends user managers to the users management
 * page after login, and every other user to the dashboard.
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    /** The users access allowed roles. */
    @Value("${security.usersAccessAllowedRoles}")
    private String usersAccessAllowedRoles;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.web.authentication.AuthenticationSuccessHandler
     * #onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	for (String role : usersAccessAllowedRoles.split(",")) {
	    if (roles.contains(role.replace("'", ""))) {
		response.sendRedirect("/atm/users");
		return;
	    }
        }
	response.sendRedirect("/atm/dashboard");
    }    
}
