package com.ncr.ATMMonitoring.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class QueryController {

    @Value("${config.terminalsPageSize}")
    private int pageSize;
    @Autowired
    private QueryService queryService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queries/create", method = RequestMethod.GET)
    public String createQuery(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	Set<Query> userQueries = null;
	String userMsg = "";

	Locale locale = RequestContextUtils.getLocale(request);

	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userQueries = loggedUser.getQueries();
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	String datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(
		DateFormat.SHORT, locale)).toLocalizedPattern();

	if (!datePattern.contains("dd")) {
	    datePattern = datePattern.replace("d", "dd");
	}

	map.put("userMsg", userMsg);
	map.put("query", new Query());
	map.put("userQueries", userQueries);
	map.put("datePattern", datePattern);
	map.put("values", Query.getComboboxes());

	return "queries";

    }

    @RequestMapping(value = "/queries/create", method = RequestMethod.POST)
    public String selectUserQuery(@ModelAttribute("query") Query query,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Set<Query> userQueries = null;
	String userMsg = "";

	Locale locale = RequestContextUtils.getLocale(request);

	if (query.getId() != null) {
	    query = queryService.getQuery(query.getId());
	    if (WebUtils.hasSubmitParameter(request, "delete")) {
		queryService.deleteQuery(query);
		query = new Query();
	    }
	} else {
	    query = new Query();
	}

	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userQueries = loggedUser.getQueries();
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	String datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(
		DateFormat.SHORT, locale)).toLocalizedPattern();

	if (!datePattern.contains("dd")) {
	    datePattern = datePattern.replace("d", "dd");
	}

	map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("userQueries", userQueries);
	map.put("datePattern", datePattern);
	map.put("values", Query.getComboboxes());

	return "queries";

    }

    @RequestMapping("/queries")
    public String redirectToQueries() {
	return "redirect:/queries/create";
    }

    @RequestMapping(value = "/queries/results", method = RequestMethod.POST)
    public String executeQuery(@ModelAttribute("query") Query query,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal, String p) throws Exception {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);

	if (WebUtils.hasSubmitParameter(request, "save_execute")) {
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		query.setUser(loggedUser);
		query.setId(null);
		queryService.addQuery(query);
		userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    }
	}

	List<Terminal> terminals = queryService.executeQuery(query, locale);

	if (terminals == null) {
	    throw new Exception("Query execution returned a NULL list.");
	}

	PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>(
		terminals);
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(pageSize);
	map.put("userMsg", userMsg);
	map.put("pagedListHolder", pagedListHolder);
	map.put("query", query);

	return "queryResults";
    }

    @RequestMapping(value = "/queries/results", method = RequestMethod.GET)
    public String redirectFromWrongResults() {
	return "redirect:/queries/create";
    }

    @RequestMapping(value = "/queries/results/export", method = RequestMethod.GET)
    public String redirectFromWrongResultsExport() {
	return "redirect:/queries/create";
    }

    @RequestMapping(value = "/queries/results/export", method = RequestMethod.POST)
    public void downloadResultsCsv(@ModelAttribute("query") Query query,
	    HttpServletResponse response, HttpServletRequest request) {
	try {
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"terminals.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Terminal.getCsvHeader());
	    List<Terminal> terminals = queryService.executeQuery(query,
		    RequestContextUtils.getLocale(request));
	    for (Terminal terminal : terminals) {
		outputwriter.write("\n" + terminal.getCsvDescription());
	    }
	    outputwriter.flush();
	    outputwriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}