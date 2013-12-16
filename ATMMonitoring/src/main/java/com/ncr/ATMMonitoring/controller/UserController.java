package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.controller.propertyEditor.RolePropertyEditor;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Role;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.RoleService;
import com.ncr.ATMMonitoring.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class UserController {

    /** The user service. */
    @Autowired
    private UserService userService;
    
    /** The role service. */
    @Autowired
    private RoleService roleService;

    /**
     * Binder.
     *
     * @param binder the binder
     * @throws Exception the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Role.class, new RolePropertyEditor(
		roleService));
    }

    /**
     * List users.
     *
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    public String listUsers(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	List<User> users = new ArrayList<User>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    bankCompanies = loggedUser.getManageableBankCompanies();
	    users = userService.listUsersByBankCompanies(bankCompanies);
	}
	map.put("banksList", bankCompanies);
	map.put("userMsg", userMsg);
	map.put("user", new User());
	map.put("usersList", users);
	map.put("manageableRolesList", roleService.listManageableRoles());
	// DEBUG CODE FOR SHOWING THE ROLES
	// map.put("rolesList", roleService.listRoles());

	return "users";
    }

    /**
     * Redirect to users.
     *
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping("/users")
    public String redirectToUsers(Map<String, Object> map,
		    HttpServletRequest request, Principal principal) {
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
				.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}
		map.put("userMsg", userMsg);
		return "newUsers";
    }

    /**
     * User details.
     *
     * @param userId the user id
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping("/users/details/{userId}")
    public String userDetails(@PathVariable("userId") Integer userId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	User user = userService.getUser(userId);
	if (user == null) {
	    return "redirect:/users/list";
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	boolean sameUser = false;
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getId() != null)
		    && (loggedUser.getId().intValue() == userId)) {
		sameUser = true;
	    }
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    bankCompanies = loggedUser.getManageableBankCompanies();
	    if ((user.getBankCompany() != null)
		    && (!bankCompanies.contains(user.getBankCompany()))) {
		return "redirect:/users/list";
	    }
	}
	map.put("banksList", bankCompanies);
	map.put("userMsg", userMsg);
	map.put("sameUser", sameUser);
	map.put("manageableRolesList", roleService.listManageableRoles());
	map.put("user", user);

	return "userDetails";
    }

    /**
     * Adds the user.
     *
     * @param user the user
     * @param result the result
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping(value = "/users/list", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((user.getBankCompany() != null)
		&& (user.getBankCompany().getId() == null)) {
	    user.setBankCompany(null);
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	List<User> users = new ArrayList<User>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    bankCompanies = loggedUser.getManageableBankCompanies();
	    if ((user.getBankCompany() != null)
		    && (!bankCompanies.contains(user.getBankCompany()))) {
		return "redirect:/users/list";
	    }
	    users = userService.listUsersByBankCompanies(bankCompanies);
	}
	map.put("banksList", bankCompanies);
	map.put("usersList", users);

	if (result.hasErrors()) {
	    map.put("userMsg", userMsg);
	    map.put("manageableRolesList", roleService.listManageableRoles());
	    // DEBUG CODE FOR SHOWING THE ROLES
	    // map.put("rolesList", roleService.listRoles());
	    return "users";
	}

	try {
	    if (userService.getUserByUsername(user.getUsername()) != null) {
		map.put("userMsg", userMsg);
		map.put("manageableRolesList",
			roleService.listManageableRoles());
		map.put("duplicatedUsername", true);
		// DEBUG CODE FOR SHOWING THE ROLES
		// map.put("rolesList", roleService.listRoles());
		return "users";
	    }
	} catch (UsernameNotFoundException e) {
	}

	user.setRole(roleService.getRole(user.getRole().getId()));
	if ((user.getRole() != null) && (user.getRole().getManageable())) {
	    userService.addUser(user);
	}

	map.clear();
	return "redirect:/users/list";
    }

    /**
     * Update user.
     *
     * @param user the user
     * @param result the result
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public String updateUser(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((user.getBankCompany() != null)
		&& (user.getBankCompany().getId() == null)) {
	    user.setBankCompany(null);
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    bankCompanies = loggedUser.getManageableBankCompanies();
	}
	map.put("banksList", bankCompanies);
	map.put("userMsg", userMsg);

	user.setRole(roleService.getRole(user.getRole().getId()));
	if (result.hasErrors()) {
	    boolean sameUser = false;
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		if ((loggedUser.getId() != null)
			&& (loggedUser.getId().intValue() == user.getId()
				.intValue())) {
		    sameUser = true;
		}
		userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    }
	    map.put("sameUser", sameUser);
	    map.put("manageableRolesList", roleService.listManageableRoles());
	    return "userDetails";
	}

	try {
	    User auxUser = userService.getUserByUsername(user.getUsername());
	    if ((auxUser != null) && (!auxUser.getId().equals(user.getId()))) {
		map.put("duplicatedUsername", true);
		map.put("manageableRolesList",
			roleService.listManageableRoles());
		return "userDetails";
	    }
	} catch (UsernameNotFoundException e) {
	}

	if ((user.getRole() != null) && (user.getRole().getManageable())) {
	    userService.updateUser(user);
	} else {
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		if ((loggedUser.getId() != null)
			&& (loggedUser.getId().equals(user.getId()))) {
		    userService.updateUser(user);
		}
	    }
	}

	map.clear();
	return "redirect:/users/details/" + user.getId().intValue();
    }

    /**
     * Update password.
     *
     * @param user the user
     * @param result the result
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping(value = "/users/updatepw", method = RequestMethod.POST)
    public String updatePassword(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    bankCompanies = loggedUser.getManageableBankCompanies();
	    if ((user.getBankCompany() != null)
		    && (!bankCompanies.contains(user.getBankCompany()))) {
		return "redirect:/users/list";
	    }
	}
	map.put("banksList", bankCompanies);
	map.put("userMsg", userMsg);

	user.setRole(roleService.getRole(user.getRole().getId()));
	if (result.hasErrors()) {
	    boolean sameUser = false;
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		if ((loggedUser.getId() != null)
			&& (loggedUser.getId().intValue() == user.getId()
				.intValue())) {
		    sameUser = true;
		}
	    }
	    map.put("user", user);
	    map.put("sameUser", sameUser);
	    map.put("manageableRolesList", roleService.listManageableRoles());
	    return "userDetails";
	}

	if ((user.getRole() != null) && (user.getRole().getManageable())) {
	    userService.updatePassword(user);
	} else {
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		if ((loggedUser.getId() != null)
			&& (loggedUser.getId().equals(user.getId()))) {
		    userService.updatePassword(user);
		}
	    }
	}

	map.clear();
	return "redirect:/users/details/" + user.getId().intValue();
    }

    /**
     * Delete user.
     *
     * @param userId the user id
     * @param principal the principal
     * @return the string
     */
    @RequestMapping("/users/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId,
	    Principal principal) {
	User user = userService.getUser(userId);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    Set<BankCompany> bankCompanies = loggedUser
		    .getManageableBankCompanies();
	    if ((user.getBankCompany() != null)
		    && (!bankCompanies.contains(user.getBankCompany()))) {
		return "redirect:/users/list";
	    }
	}
	if ((user != null) && (user.getRole() != null)
		&& (user.getRole().getManageable())) {
	    userService.removeUser(userId);
	}

	return "redirect:/users/list";
    }

	/**
	 * New group.
	 *
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/users/newGroup")
    public String newGroup() {
    	return "newGroup";
    }

}
