package com.ncr.ATMMonitoring.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;
import org.apache.log4j.Logger;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */
@Controller
public class QueryController {

    static private Logger logger = Logger.getLogger(QueryController.class.getName());

	public static final String DEFAULT_SORT = "serialNumber";

	public static final String DEFAULT_ORDER = "asc";

    @Value("${config.queriesPageSize}")
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
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	String datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(
		DateFormat.SHORT, locale)).toLocalizedPattern();

	if (!datePattern.contains("dd")) {
	    datePattern = datePattern.replace("d", "dd");
	}


	map.put("userMsg", userMsg);
	map.put("query", new Query());
	map.put("values", Query.getComboboxes());

	return "newQuery";

    }



    @RequestMapping(value = "/queries/show", method = RequestMethod.GET)
    public String showUserQuery(Integer queryId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {

	String userMsg = "";
        Query query = null;
	Locale locale = RequestContextUtils.getLocale(request);

	if (queryId != null) {
	    query = queryService.getQuery(queryId);
	}

	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}


	map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("values", query.getComboboxes());

	return "queries";

    }

 @RequestMapping(value = "/queries/delete", method = RequestMethod.GET)
    public String deleteUserQuery(Integer queryId,
	    Map<String, Object> map, HttpServletRequest request,
				  Principal principal) {

	String userMsg = "";
        Query query = null;
        Set<Query> userQueries = null;
	Locale locale = RequestContextUtils.getLocale(request);

	if (queryId != null) {
	    query = queryService.getQuery(queryId);
	    if (query != null) {
		try {
		    queryService.deleteQuery(query);
		    map.put("success", "success.deletingNewQuery");
	        }catch (Throwable e) {
		    map.put("error", "error.deletingQuery");
		}
            }
	}

	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
            userQueries = loggedUser.getQueries();
	}
	PagedListHolder<Query> pagedListHolder =
	    new PagedListHolder<Query>( new ArrayList(userQueries));
	int page = 0;

	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(pageSize);
	map.put("pagedListHolder", pagedListHolder);

        map.put("userMsg", userMsg);

	return "queryList";

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
		return "redirect:/queries/list";
    }

    @RequestMapping("/queries/list")
    public String listQueries(Map<String, Object> map,
			      HttpServletRequest request,
			      Principal principal,
                              String p) {
        Set<Query> userQueries = null;
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);

	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userQueries = loggedUser.getQueries();
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	PagedListHolder<Query> pagedListHolder =
	    new PagedListHolder<Query>( new ArrayList(userQueries));
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
	map.put("pagedListHolder", pagedListHolder);

	//  map.put("userQueries", userQueries);
        map.put("userMsg", userMsg);
	return "queryList";
    }


    @RequestMapping(value = "/queries/results", method = RequestMethod.POST)
    public String saveOrUpdateQuery(@ModelAttribute("query") Query query,
	    Map<String, Object> map, HttpServletRequest request,
		Principal principal, RedirectAttributes redirectAttributes,
        String p, String sort, String order) throws Exception {

	Locale locale = RequestContextUtils.getLocale(request);
	User loggedUser = null;
	if (principal != null) {
		loggedUser = userService.getUserByUsername(principal.getName());
	}

	if (WebUtils.hasSubmitParameter(request, "save")) {
	    if (principal != null) {
		query.setUser(loggedUser);
		if (query.getId() != null) {
		    try {
			logger.debug("Updating query - " + query.getName());
			queryService.updateQuery(query);
			redirectAttributes.addFlashAttribute("success", "success.updatingQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "error.updatingQuery");
		    }
		} else {
		    query.setCreationDate(new Date());
			query.setTrueLocale(locale);
		    try {
			logger.debug("Guardando nueva query- " + query.getName());
			queryService.addQuery(query);
			redirectAttributes.addFlashAttribute("success", "success.savingNewQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "error.savingNewQuery");
		    }
		}
	    }
	    return "redirect:/queries/list";
	} else if (WebUtils.hasSubmitParameter(request, "execute")) {
	    if (principal != null) {
		query.setUser(loggedUser);
	    }
	    logger.debug("Executing query... " + query.getName());
		String sortValue = (sort == null) ? DEFAULT_SORT : sort;
		String orderValue = (order == null) ? DEFAULT_ORDER : order;
		List<Terminal> terminals = queryService.executeQuery(query, locale, sortValue, orderValue);

		logger.debug("terminals " + terminals);

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

		logger.debug("pageListHolder " + pagedListHolder);

		map.put("userMsg", loggedUser.getHtmlWelcomeMessage(locale));
		map.put("pagedListHolder", pagedListHolder);
		map.put("query", query);
		map.put("values", Query.getComboboxes());
		map.put("p", page);
		map.put("sort", sortValue);
		map.put("order", orderValue);

	}  else if (WebUtils.hasSubmitParameter(request, "delete")) {
	   logger.debug("Deleting query -" + query.getName());
	    return "redirect:/queries/delete?queryId="+query.getId();
	}
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
            HttpServletResponse response, HttpServletRequest request,
			String sort, String order) {
	try {
		String sortValue = (sort == null) ? DEFAULT_SORT : sort;
		String orderValue = (order == null) ? DEFAULT_ORDER : order;
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"terminals.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Terminal.getCsvHeader());
	    List<Terminal> terminals = queryService.executeQuery(query, RequestContextUtils.getLocale(request), sortValue, orderValue);
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
