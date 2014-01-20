package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.service.WidgetService;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;

@Controller
public class WidgetController {

	@Autowired
    private QueryService queryService;

	/** The widget service. */
    @Autowired
    private WidgetService widgetService;
    
    /** The user service. */
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/create")
    public String createWidget(
    		Map<String, Object> model,
    		Principal principal) {
    	
    	return createOrEditWidget(model, principal, null);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/dashboard/edit/{queryId}")
    public String createWidget(
    		Map<String, Object> model,
    		@PathVariable("queryId") Integer queryId, 
    		Principal principal) {
    	
    	return createOrEditWidget(model, principal, queryId);
    }
    
    @RequestMapping(value = "/dashboard/save", method = RequestMethod.POST)
    public String createWidget(
	    @Valid @ModelAttribute("widget") Widget widget,
	    BindingResult result, 
	    Map<String, Object> model,
	    HttpServletRequest request,
	    Principal principal) {
    	
        if (widget != null && principal != null) {
        	User loggedUser = userService.getUserByUsername(principal.getName());
        	Set<Query> userQueries = loggedUser.getQueries();
            Dashboard dashboard = loggedUser.getDashboard();
        	
            Integer queryId = widget.getQuery().getId(); 
            if(queryId != null) {
            	widget.setQuery(queryService.getQuery(queryId));
            }
            
            if (userQueries.contains(widget.getQuery())) {
            	widget.setOwner(loggedUser);
            	widget.setDashboard(dashboard);
            	widget.setOrder(dashboard.getWidgets().size());
            	
            	widgetService.saveWidget(widget);
            }
        }
    	
    	return "closeIframeUpdateParent";
    }
    
    private String createOrEditWidget(Map<String, Object> model, Principal principal,  Integer widgetId) {
    	User loggedUser = null;
        Set<Query> userQueries = null;
        Widget widget = new Widget();
        
        if (principal != null) {
            loggedUser = userService.getUserByUsername(principal.getName());
            userQueries = loggedUser.getQueries();
            
            if( widgetId != null ) {
            	Widget widgetToEdit = widgetService.findWidgetById(widgetId);
            	if(loggedUser.getDashboard().getWidgets().contains(widgetToEdit)) {
            		widget = widgetToEdit;
            	}
            }
        }
    	
    	model.put("userQueries", userQueries);
    	model.put("chartTypes", Widget.ChartType.values());
    	model.put("queryTypes", WidgetQueryAssociationType.values());
    	model.put("widget", widget);
    	
    	return "newWidget";
    }
}
