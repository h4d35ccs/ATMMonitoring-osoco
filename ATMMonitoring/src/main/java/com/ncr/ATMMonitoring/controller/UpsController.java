package com.ncr.ATMMonitoring.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncr.ATMMonitoring.controller.propertyeditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Ups;
import com.ncr.ATMMonitoring.service.UpsService;
import com.ncr.ATMMonitoring.servicefacade.AtmFacade;

/**
 * The Class UpsController.
 * 
 * Controller for handling ups related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class UpsController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(UpsController.class
	    .getName());

    /** The Constant DEFAULT_SORT. */
    public static final String DEFAULT_SORT = "seriesNumber";

    /** The Constant DEFAULT_ORDER. */
    public static final String DEFAULT_ORDER = AtmFacade.ORDER_ASC;

    /** The can alter terminals roles. */
    @Value("${security.upsManagementAllowedRoles}")
    private String canManageUpsRoles;

    /** The page size. */
    @Value("${config.upsPageSize}")
    private int pageSize;

    /** The ups service. */
    @Autowired
    private UpsService upsService;

    /**
     * Binds custom property editors.
     * 
     * @param binder
     *            the binder
     * @throws Exception
     *             the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Date.class, new DatePropertyEditor());
    }

    /**
     * List terminals URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param p
     *            the page number
     * @param sort
     *            the fields for sorting terminals
     * @param order
     *            the order for sorting terminals
     * @param request
     *            the request
     * @param request
     *            the queryDate
     * @return the petition response
     */
    @RequestMapping(value = "/ups/list", method = RequestMethod.GET)
    public String listUps(Map<String, Object> map, Principal principal,
	    String p, String sort, String order, HttpServletRequest request) {

	PagedListHolder<Ups> pagedListHolder = new PagedListHolder<Ups>();
	Set<Query> userQueries = new HashSet<Query>();
	String sortValue = (sort == null) ? DEFAULT_SORT : sort;
	String orderValue = (order == null) ? DEFAULT_ORDER : order;
	if (principal != null) {
	    List<Ups> ups = upsService.listUps(sort, order);
	    pagedListHolder = new PagedListHolder<Ups>(ups);

	    // TODO
	    // userQueries = queryService.getQueriesByUser(principal.getName());
	}
	map.put("userQueries", userQueries);
	map.put("ups", new Ups());
	map.put("sort", sortValue);
	map.put("order", orderValue);
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

	return "ups";
    }

    /**
     * Redirect to ups URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/ups" })
    public String redirectToUps() {
	return "redirect:/ups/list";
    }

    /**
     * Ups details URL.
     * 
     * @param upsId
     *            the ups id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/ups/details/{upsId}")
    public String upsDetails(@PathVariable("upsId") Integer upsId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {

	Ups ups = upsService.getUps(upsId);
	if (ups == null) {
	    map.clear();
	    return "redirect:/ups/list";
	}

	map.put("ups", ups);

	return "upsDetails";
    }

    //
    // /**
    // * New UPS form URL.
    // *
    // * @param map
    // * the map
    // * @param request
    // * the request
    // * @param principal
    // * the principal
    // * @return the petition response
    // */
    // @RequestMapping(value = "/ups/new", method = RequestMethod.GET)
    // public String viewNewTerminal(Map<String, Object> map,
    // HttpServletRequest request, Principal principal) {
    //
    // map.put("ups", new Ups());
    //
    // return "newUps";
    // }
    //
    // /**
    // * Add UPS URL.
    // *
    // * @param ups
    // * the ups
    // * @param result
    // * the result
    // * @param map
    // * the map
    // * @param request
    // * the request
    // * @param principal
    // * the principal
    // * @param p
    // * the page number
    // * @return the petition response
    // */
    // @RequestMapping(value = "/ups/list", method = RequestMethod.POST)
    // public String addUps(@Valid @ModelAttribute("ups") Ups ups,
    // BindingResult result, Map<String, Object> map,
    // HttpServletRequest request, Principal principal, String p) {
    //
    // if (result.hasErrors()) {
    // PagedListHolder<Ups> pagedListHolder = new PagedListHolder<Ups>();
    // Set<Query> userQueries = new HashSet<Query>();
    // int page = 0;
    // if (p != null) {
    // try {
    // page = Integer.parseInt(p);
    // } catch (NumberFormatException e) {
    // e.printStackTrace();
    // }
    // }
    // if (principal != null) {
    // // TODO
    // // userQueries = queryService
    // // .getQueriesByUser(principal.getName());
    // pagedListHolder = new PagedListHolder<Ups>(
    // this.upsService.listUps());
    // }
    // pagedListHolder.setPage(page);
    // pagedListHolder.setPageSize(pageSize);
    // map.put("userQueries", userQueries);
    // map.put("pagedListHolder", pagedListHolder);
    // return "ups";
    // }
    //
    // upsService.addUps(ups);
    //
    // // try {
    // // // We wait to avoid not loading the recently added DB data
    // // Thread.sleep(500);
    // // } catch (InterruptedException e) {
    // // e.printStackTrace();
    // // }
    //
    // map.clear();
    // return "redirect:/ups/list";
    // }

    /**
     * Update UPS URL.
     * 
     * @param ups
     *            the ups
     * @param result
     *            the result
     * @param map
     *            the map
     * @param redirectAttributes
     *            the redirect attributes
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/ups/update", method = RequestMethod.POST)
    public String updateUps(@Valid @ModelAttribute("ups") Ups ups,
	    BindingResult result, Map<String, Object> map,
	    RedirectAttributes redirectAttributes, HttpServletRequest request,
	    Principal principal) {
	Ups ups_aux = upsService.getUpsBySeriesNumber(ups.getSeriesNumber());
	boolean duplicatedSeriesNumber = (ups_aux != null && ups_aux.getId() != ups
		.getId());
	if (result.hasErrors() || duplicatedSeriesNumber) {
	    map.put("duplicatedSeriesNumber", duplicatedSeriesNumber);
	    map.put("errors", true);
	    return "upsDetails";
	}

	upsService.updateUps(ups);
	redirectAttributes.addFlashAttribute("success", "success.updatingUps");
	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/ups/details/" + ups.getId().intValue();
    }

    //
    // /**
    // * List UPS by query URL.
    // *
    // * @param map
    // * the map
    // * @param queryId
    // * the UPS query id
    // * @param principal
    // * the principal
    // * @param p
    // * the page number
    // * @param sort
    // * the fields for sorting terminals
    // * @param order
    // * the order for sorting terminals
    // * @param request
    // * the request
    // * @param queryDate
    // * the date the date
    // * @return the petition response
    // */
    // @RequestMapping(value = "terminals/byQuery")
    // public String listTerminalsByQuery(Map<String, Object> map,
    // Integer queryId, Principal principal, String p, String sort,
    // String order, HttpServletRequest request, Date queryDate) {
    // // String // userMsg = "";
    // Locale locale = RequestContextUtils.getLocale(request);
    // Set<Query> userQueries = null;
    // String sortValue = (sort == null) ? DEFAULT_SORT : sort;
    // String orderValue = (order == null) ? DEFAULT_ORDER : order;
    //
    // if (principal != null) {
    // // //userMsg = this.getUserGreeting(principal, request);
    // userQueries = this.queryService.getQueriesByUser(principal
    // .getName());
    // }
    // map.put("userQueries", userQueries);
    // // //map.put("userMsg", userMsg)
    // Query query = null;
    // List<Terminal> terminals = null;
    // if (queryId != null) {
    // query = this.queryService.getQuery(queryId);
    // terminals = this.queryService.executeQuery(query, locale,
    // sortValue, orderValue, queryDate);
    // }
    // if (terminals == null) {
    // // terminals = terminalService.listTerminals();
    // terminals = this.atmservice.listAllATM();
    // }
    //
    // PagedListHolder<Terminal> pagedListHolder = new
    // PagedListHolder<Terminal>(
    // terminals);
    //
    // int page = 0;
    // if (p != null) {
    // try {
    // page = Integer.parseInt(p);
    // } catch (NumberFormatException e) {
    // e.printStackTrace();
    // }
    // }
    // pagedListHolder.setPage(page);
    // pagedListHolder.setPageSize(pageSize);
    // map.put("query", query);
    // map.put("pagedListHolder", pagedListHolder);
    // map.put("sort", sortValue);
    // map.put("order", orderValue);
    // map.put("queryDate", queryDate);
    // map.put("terminalIdsByLocation",
    // buildTerminalIdsByLocationModel(terminals, queryDate));
    //
    // return "terminals";
    // }

    // /**
    // * Download UPS data csv from query URL.
    // *
    // * @param queryId
    // * the query id
    // * @param response
    // * the response
    // * @param request
    // * the request
    // */
    // @RequestMapping(value = "/terminals/export/{queryId}", method =
    // RequestMethod.GET)
    // public void downloadResultsCsvForQuery(
    // @PathVariable("queryId") Integer queryId,
    // HttpServletResponse response, HttpServletRequest request) {
    // try {
    // response.setContentType("text/csv;charset=utf-8");
    // response.setHeader("Content-Disposition",
    // "attachment; filename=\"terminals.csv\"");
    // OutputStream resOs = response.getOutputStream();
    // OutputStream buffOs = new BufferedOutputStream(resOs);
    // OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
    // outputwriter.write(Terminal.getCsvHeader());
    // List<Terminal> terminals = null;
    // if (queryId != null) {
    // Query query = queryService.getQuery(queryId);
    // if (query != null) {
    // logger.debug("Retrieving terminals from query " + queryId
    // + " for csv export");
    // terminals = queryService.executeQuery(query,
    // RequestContextUtils.getLocale(request));
    // }
    // }
    // for (Terminal terminal : terminals) {
    // outputwriter.write("\n" + terminal.getCsvDescription());
    // }
    // outputwriter.flush();
    // outputwriter.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    //
    // }

    /**
     * Download all UPS data as csv URL.
     * 
     * @param response
     *            the response
     * @param request
     *            the request
     * @param principal
     *            the principal
     */
    @RequestMapping(value = "/ups/exportAll", method = RequestMethod.GET)
    public void downloadResultsCsv(HttpServletResponse response,
	    HttpServletRequest request, Principal principal) {
	try {
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"terminals.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Ups.getCsvHeader());
	    List<Ups> upsList = null;
	    logger.debug("Exporting to CSV all UPS");
	    upsList = upsService.listUps();

	    for (Ups ups : upsList) {
		outputwriter.write("\n" + ups.getCsvDescription());
	    }
	    outputwriter.flush();
	    outputwriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
