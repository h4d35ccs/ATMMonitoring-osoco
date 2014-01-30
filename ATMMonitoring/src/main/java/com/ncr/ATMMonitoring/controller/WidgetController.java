package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.service.WidgetCategoryService;
import com.ncr.ATMMonitoring.service.WidgetService;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;
import com.ncr.ATMMonitoring.utils.RegionType;

@Controller
public class WidgetController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(WidgetController.class.getName());

	@Autowired
    private QueryService queryService;

	/** The widget service. */
    @Autowired
    private WidgetService widgetService;
    
    @Autowired
    private WidgetCategoryService widgetCategoryService;
    
    /** The user service. */
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/newWidget")
    public String newWidget() {
    	return "widget/newWidget";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/create")
    public String createWidget(
    		Map<String, Object> model,
    		Principal principal) {
    	
    	return createOrEditWidget(model, principal, null);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/createFromLibrary")
    public String createWidgetFromLibrary(
    		Map<String, Object> model,
    		Principal principal) {
    	
    	if (principal != null) {
    		model.put("categories", widgetService.findLibraryWidgetsByCategory());
    	}
    	
    	return "widget/createFromLibrary";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/dashboard/edit/{widgetId}")
    public String editWidget(
    		Map<String, Object> model,
    		@PathVariable("widgetId") Integer widgetId, 
    		Principal principal) {
    	
    	return createOrEditWidget(model, principal, widgetId);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/dashboard/delete")
	@ResponseStatus(HttpStatus.OK)
    public void deleteWidget(
    		@RequestParam("widgetId") Integer widgetId,  
    		Principal principal) {
    	
		User loggedUser = null;
        if (principal != null) {
	        try {
	        	loggedUser = userService.getUserByUsername(principal.getName());
				widgetService.deleteWidgetFromUser(widgetId, loggedUser);
	        } catch (Exception e) {
	        	logger.error("An error occurs", e);
	        }
        }
    }
    
    @RequestMapping(value = "/dashboard/save", method = RequestMethod.POST)
    public String updateWidget(
	    @Valid @ModelAttribute("widget") Widget widget,
	    BindingResult result, 
	    Map<String, Object> model,
	    HttpServletRequest request,
	    Principal principal) {
    	
        if (widget != null && principal != null) {
        	User loggedUser = userService.getUserByUsername(principal.getName());
        	widgetService.createWidgetForUser(widget, loggedUser);
        }
    	
    	return "closeIframeUpdateParent";
    }
    
    @RequestMapping(value = "/dashboard/addFromLibrary", method = RequestMethod.POST)
    public String addFromLibrary(
    		@RequestParam(value="widgetIds", required = false) ArrayList<Integer> widgetIds,
    		Principal principal) {

    	if (widgetIds != null && principal != null) {
    		User loggedUser = userService.getUserByUsername(principal.getName());
    		widgetService.addWidgetsFromLibrary(widgetIds, loggedUser);
    	}

    	return "closeIframeUpdateParent";
    }
    
    @RequestMapping(value = "/dashboard/showAddToLibraryForm/{widgetId}", method = RequestMethod.GET)
    public String showAddToLibraryForm(
    		Map<String, Object> model,
    		@PathVariable("widgetId") Integer widgetId, 
    		Principal principal) {
    	
    	model.put("widgetId", widgetId);
    	model.put("categories", widgetCategoryService.findAll());
    	
    	return "widget/addToLibrary";
    }
    
    @RequestMapping(value = "/dashboard/addToLibrary", method = RequestMethod.POST)
    public String addToLibrary(
    		@RequestParam(value="widgetId") Integer widgetId,
    		@RequestParam(value="categoryId") Integer categoryId,
    		Principal principal) {
    	addOrRemoveWidgetFromLibrary(widgetId, principal, categoryId);
    	return "closeIframeUpdateParent";
    }
    
    @RequestMapping(value = "/dashboard/removeFromLibrary", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void removeFrom(
    		@RequestParam(value="widgetId") Integer widgetId,
    		Principal principal) {
    	addOrRemoveWidgetFromLibrary(widgetId, principal, null);
    }
    
    @RequestMapping(value = "/dashboard/setAsDefault", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void setAsDefault(
    		@RequestParam(value="widgetId") Integer widgetId,
    		Principal principal) {
    	setWidgetDefault(widgetId, principal, true);
    }
    
    @RequestMapping(value = "/dashboard/unsetAsDefault", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void unsetAsDefault(
    		@RequestParam(value="widgetId") Integer widgetId,
    		Principal principal) {
    	setWidgetDefault(widgetId, principal, false);
    }
    
    private void setWidgetDefault(Integer widgetId, Principal principal, boolean isDefault) {
    	if (widgetId != null && principal != null) {
    		User loggedUser = userService.getUserByUsername(principal.getName());
    		widgetService.setWidgetDefault(widgetId, loggedUser, isDefault);
    	}
    }
    
    private String createOrEditWidget(Map<String, Object> model, Principal principal,  Integer widgetId) {
    	User loggedUser = null;
        Set<Query> userQueries = null;
        String operationType = "create";
        Widget widget = new Widget();
        
        if (principal != null) {
            loggedUser = userService.getUserByUsername(principal.getName());
            userQueries = loggedUser.getQueries();
            
            if( widgetId != null ) {
            	Widget widgetToEdit = widgetService.findWidgetById(widgetId);
            	if(widgetService.isWidgetOwnedByUser(widgetToEdit, loggedUser)) {
            		widget = widgetToEdit;
            		operationType = "edit";
            	}
            }
        }
    	
    	model.put("userQueries", userQueries);

    	model.put("chartTypes", Widget.ChartType.values());
    	model.put("regionTypes", RegionType.values());
    	model.put("resolutionTypes", Widget.ResolutionType.values());
    	model.put("displayModeTypes", Widget.DisplayModeType.values());
    	
    	model.put("queryTypes", WidgetQueryAssociationType.values());
    	model.put("widget", widget);
    	model.put("operationType", operationType);
    	
    	return "widget/createOrEdit";
    }
    
    private void addOrRemoveWidgetFromLibrary(Integer widgetId, Principal principal, Integer categoryId) {
    	if (widgetId != null && principal != null) {
    		User loggedUser = userService.getUserByUsername(principal.getName());
    		widgetService.addOrRemoveWidgetToLibrary(widgetId, loggedUser, categoryId);
    	}
    }
}
