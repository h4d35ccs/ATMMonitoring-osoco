package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.service.DashboardService;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.service.WidgetService;

// TODO: Auto-generated Javadoc
/**
 * Controller for Dashboard related actions.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */
@Controller
public class DashboardController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(DashboardController.class.getName());

    /** The user service. */
    @Autowired
    private UserService userService;

	/** The dashboard service. */
	@Autowired
	private DashboardService dashboardService;

    /** The widget service. */
    @Autowired
    private WidgetService widgetService;
    
    
    /**
     * Show dashboard.
     *
     * @param map the map
     * @param principal the principal
     * @param request the request
     * @return the string
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(Map<String, Object> map, Principal principal, HttpServletRequest request) {
		User loggedUser = null;
        String userMsg = "";
		Dashboard dashboard = null;
        Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
            loggedUser = userService.getUserByUsername(principal.getName());
            userMsg = loggedUser.getHtmlWelcomeMessage(locale);
			dashboard = dashboardService.findOrCreateDashboardByUser(loggedUser);
        }

        map.put("userMsg", userMsg);
		map.put("dashboard", dashboard);
		map.put("columnOptions", Dashboard.ColumnOptions.values());
        return "dashboard";
    }

	/**
	 * Show dashboard chart.
	 *
	 * @param request the request
	 * @param principal the principal
	 * @return the map
	 */
	@RequestMapping(
	    method = RequestMethod.GET,
		value ="/dashboard/charts")
	@ResponseBody
	public Map showDashboardChart(HttpServletRequest request, Principal principal) {
		Map result = null;
		User loggedUser = null;
        if (principal != null) {
            loggedUser = userService.getUserByUsername(principal.getName());
			Dashboard dashboard = loggedUser.getDashboard();
			List<Widget> visibleWidgets = dashboard.getVisibleWidgets();
			List<Widget> hiddenWidgets = dashboard.getWidgets();
			hiddenWidgets.removeAll(visibleWidgets);

			result = new HashMap();
			result.put("visibleCharts", toJSON(visibleWidgets));
			result.put("hiddenCharts", toJSON(hiddenWidgets));
		}
		return result;
    }

	/**
	 * Show dashboard chart.
	 *
	 * @param widgetId the widget id
	 * @param request the request
	 * @param principal the principal
	 * @return the map
	 */
	@RequestMapping(
	    method = RequestMethod.GET,
		value ="/dashboard/chart",
		params = "widgetId")
	@ResponseBody
	public Map showDashboardChart(@RequestParam int widgetId, HttpServletRequest request, Principal principal) {
		Map result = null;
		User loggedUser = null;
        if (principal != null) {
	        try {
	        	loggedUser = userService.getUserByUsername(principal.getName());
				Widget widget = widgetService.findWidgetById(widgetId);
				if ((widget != null) && (widget.getOwner().equals(loggedUser))) {
					logger.debug("Found widget: " + widget.getId());
					Locale locale = RequestContextUtils.getLocale(request);
					List queryResults = widgetService.executeQuery(widget, locale);
					result = toGoogleChartJSON(queryResults);
				}
	        } catch (Exception e) {
	        	logger.error("An error occurs", e);
	        }
        }

		return result;
    }

	/**
	 * Update chart position.
	 *
	 * @param widgetId the widget id
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 * @param request the request
	 * @param principal the principal
	 */
	@RequestMapping(
		method = RequestMethod.POST,
		value ="/dashboard/updateChartPosition")
	@ResponseStatus(HttpStatus.OK)
    public void updateChartPosition(
            @RequestParam("widgetId") int widgetId,
			@RequestParam("oldPosition") int oldPosition,
			@RequestParam("newPosition") int newPosition,
			HttpServletRequest request,
			Principal principal) {
		User loggedUser = null;
        if ((principal != null) && (oldPosition != newPosition)) {
            loggedUser = userService.getUserByUsername(principal.getName());
			Widget widget = widgetService.findWidgetById(widgetId);
			if ((widget != null) && (widget.getOwner().equals(loggedUser))) {
				Dashboard dashboard = loggedUser.getDashboard();
				List<Widget> widgets = dashboard.getVisibleWidgets();
				logger.debug("Moving widget " + widget.getId() + " from position " + oldPosition + " to " + newPosition);
				// TODO Move to WidgetService
				moveWidgetFromTo(widgets, oldPosition, newPosition);
			}
        }
    }

	/**
	 * Hide chart.
	 *
	 * @param widgetId the widget id
	 * @param request the request
	 * @param principal the principal
	 */
	@RequestMapping(
	    method = RequestMethod.POST,
		value ="/dashboard/hideChart")
	@ResponseStatus(HttpStatus.OK)
	public void hideChart(
	        @RequestParam("widgetId") int widgetId,
			HttpServletRequest request,
			Principal principal) {
		User loggedUser = null;
        if (principal != null) {
            loggedUser = userService.getUserByUsername(principal.getName());
			Widget widget = widgetService.findWidgetById(widgetId);
			if ((widget != null) && (widget.getOwner().equals(loggedUser))) {
				logger.debug("Hiding widget " + widget.getId());
				widget.setVisible(false);
				widget.setOrder(0);
				widgetService.saveWidget(widget);
			}
        }
    }

	/**
	 * Show chart.
	 *
	 * @param widgetId the widget id
	 * @param request the request
	 * @param principal the principal
	 */
	@RequestMapping(
	    method = RequestMethod.POST,
		value ="/dashboard/showChart")
		@ResponseStatus(HttpStatus.OK)
	public void showChart(
	        @RequestParam("widgetId") int widgetId,
			HttpServletRequest request,
			Principal principal) {
		// TODO: replace by widgetService.isWidgetOwnedByUser()
		User loggedUser = null;
        if (principal != null) {
            loggedUser = userService.getUserByUsername(principal.getName());
			Widget widget = widgetService.findWidgetById(widgetId);
			if (widgetService.isWidgetOwnedByUser(widget, loggedUser )) {
				logger.debug("Showing widget " + widget.getId());
				// TODO: replace by widgetService.makeVisible()
				widget.setVisible(true);
				List<Widget> widgets = loggedUser.getDashboard().getWidgets();
				int maxOrder = widgets.get(widgets.size() - 1).getOrder();
				widget.setOrder(maxOrder + 1);
				widgetService.saveWidget(widget);
			}
        }
    }

	/**
	 * Change columns.
	 *
	 * @param columns the columns
	 * @param request the request
	 * @param principal the principal
	 */
	@RequestMapping(
	    method = RequestMethod.POST,
		value ="/dashboard/changeColumns")
	@ResponseStatus(HttpStatus.OK)
	public void changeColumns(
            @RequestParam("columns") int columns,
			HttpServletRequest request,
			Principal principal) {
        if (principal != null) {
            User loggedUser = userService.getUserByUsername(principal.getName());
			Dashboard dashboard = loggedUser.getDashboard();
			dashboard.setColumns(columns);
			dashboardService.saveDashboard(dashboard);
        }
    }

    
	

	// Private Methods ----------------------------------------------------------------------

	/**
	 * Move widget from to.
	 *
	 * @param widgets the widgets
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 */
	private void moveWidgetFromTo(List<Widget> widgets, int oldPosition, int newPosition) {
		logger.debug("old widget list: " + widgets);
		if (oldPosition < newPosition) {
			Collections.rotate(widgets.subList(oldPosition, newPosition + 1), -1);
		} else {
			Collections.rotate(widgets.subList(newPosition, oldPosition + 1), 1);
		}
		logger.debug("new widget list: " + widgets);
		for (int i = 0; i < widgets.size(); i++) {
			Widget widget = (Widget)widgets.get(i);
			widget.setOrder(i + 1);
			widgetService.saveWidget(widget);
		}
	}


	/**
	 * To google chart json.
	 *
	 * @param queryResults the query results
	 * @return the map
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<String, List> toGoogleChartJSON(List queryResults) {
		logger.debug("Converting query results [" + queryResults + "] into Google Charts JSON...");
		Map<String, List> result = new HashMap<String, List>();

		List columns = new ArrayList();
		Map column1 = new HashMap();
		column1.put("label", "Terminals");
		column1.put("type", "string");

		Map column2 = new HashMap();
		column2.put("label", "Count");
		column2.put("type", "number");

		columns.add(column1);
		columns.add(column2);

		List rows = new ArrayList(queryResults.size());

		for (int i = 0; i < queryResults.size(); i++) {
			Object label = ((Map)queryResults.get(i)).get("groupName");
			label = (label == null || label.equals("")) ? "Desconocido" : label;
			Long value = (Long)((Map)queryResults.get(i)).get("count");
			logger.debug(label + " -> " + value);

			Map row = new HashMap();
			List cells = new ArrayList();
			Map cell1 = new HashMap();
			cell1.put("v", label);

			Map cell2 = new HashMap();
			cell2.put("v", value);

			cells.add(cell1);
			cells.add(cell2);

			row.put("c", cells);
			rows.add(row);
		}

		result.put("cols", columns);
		result.put("rows", rows);

		return result;
	}

	/**
	 * To json.
	 *
	 * @param widgets the widgets
	 * @return the list
	 */
	private List<Map> toJSON(List<Widget> widgets) {
		List<Map> result = new ArrayList<Map>(widgets.size());
		for (Widget widget: widgets) {
			result.add(widget.toJSON());
		}
		return result;
	}

}
