package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

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
import com.ncr.ATMMonitoring.pojo.Role;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.RoleService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Role.class, new RolePropertyEditor(
		roleService));
    }

    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    public String listUsers(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	map.put("user", new User());
	map.put("usersList", userService.listUsers());
	map.put("manageableRolesList", roleService.listManageableRoles());
	// DEBUG CODE FOR SHOWING THE ROLES
	// map.put("rolesList", roleService.listRoles());

	return "users";
    }

    @RequestMapping("/users")
    public String redirectToUsers() {
	return "redirect:/users/list";
    }

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
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    if ((loggedUser.getId() != null)
		    && (loggedUser.getId().intValue() == userId)) {
		sameUser = true;
	    }
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	map.put("sameUser", sameUser);
	map.put("manageableRolesList", roleService.listManageableRoles());
	map.put("user", user);

	return "userDetails";
    }

    @RequestMapping(value = "/users/list", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	if (result.hasErrors()) {
	    map.put("userMsg", userMsg);
	    map.put("manageableRolesList", roleService.listManageableRoles());
	    map.put("rolesList", roleService.listRoles());
	    map.put("usersList", userService.listUsers());
	    return "users";
	}

	try {
	    if (userService.getUserByUsername(user.getUsername()) != null) {
		map.put("userMsg", userMsg);
		map.put("manageableRolesList",
			roleService.listManageableRoles());
		map.put("rolesList", roleService.listRoles());
		map.put("duplicatedUsername", true);
		map.put("usersList", userService.listUsers());
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

    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public String updateUser(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
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

    @RequestMapping(value = "/users/updatepw", method = RequestMethod.POST)
    public String updatePassword(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
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

    @RequestMapping("/users/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {
	User user = userService.getUser(userId);
	if ((user != null) && (user.getRole() != null)
		&& (user.getRole().getManageable())) {
	    userService.removeUser(userId);
	}

	return "redirect:/users/list";
    }
}