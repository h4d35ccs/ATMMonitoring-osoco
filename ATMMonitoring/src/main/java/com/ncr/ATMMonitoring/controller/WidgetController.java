package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ncr.ATMMonitoring.controller.propertyEditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.service.WidgetCategoryService;
import com.ncr.ATMMonitoring.service.WidgetService;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;
import com.ncr.ATMMonitoring.utils.RegionType;

/**
 * Controller for Widget related actions.
 * 
 * @author jmartin
 *
 */
@Controller
public class WidgetController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(WidgetController.class.getName());

	/** The query service */
	@Autowired
    private QueryService queryService;

	/** The widget service. */
    @Autowired
    private WidgetService widgetService;
    
    /** The widget category service*/
    @Autowired
    private WidgetCategoryService widgetCategoryService;
    
    /** The user service. */
    @Autowired
    private UserService userService;
    
    /**
     * Binds custom editors.
     * @param binder the binder
     * @throws Exception the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
    	binder.registerCustomEditor(Date.class, new DatePropertyEditor());
    }
    
    /**
     * Show new widget form
     * @return the petition response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/newWidget")
    public String newWidget() {
    	return "widget/newWidget";
    }
   
    /**
     * Show creates new widget form
     * @param model The model
     * @param principal The principal user
     * @return the request response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/create")
    public String createWidget(
    		Map<String, Object> model,
    		Principal principal) {
    	
    	return createOrEditWidget(model, principal, null);
    }
    
    /**
     * Creates a new widget from library
     * @param model The model
     * @param principal The principal user
     * @return The request response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/createFromLibrary")
    public String createWidgetFromLibrary(
    		Map<String, Object> model,
    		Principal principal) {
    	
    	if (principal != null) {
    		model.put("categories", widgetService.findLibraryWidgetsByCategory());
    	}
    	
    	return "widget/createFromLibrary";
    }
	
    /**
     * Edit a widget
     * @param model The model
     * @param widgetId The widget id
     * @param principal The principal user
     * @return The request response
     */
	@RequestMapping(method = RequestMethod.GET, value = "/dashboard/edit/{widgetId}")
    public String editWidget(
    		Map<String, Object> model,
    		@PathVariable("widgetId") Integer widgetId, 
    		Principal principal) {
    	
    	return createOrEditWidget(model, principal, widgetId);
    }
	
	/**
	 * Delete a widget
	 * @param widgetId The widget id
	 * @param principal The principal user
	 */
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
    
	/**
	 * Update a widget
	 * @param widget The widget
	 * @param result The binding result
	 * @param model The model
	 * @param request The request
	 * @param principal The principal user
	 * @return The request response
	 */
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
    
    /**
     * Add a widget to user dashboard from library
     * 
     * @param widgetIds A list with the widgets ids
     * @param principal The principal user
     * @return The request response
     */
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
    
    /**
     * Show add widget to library form
     * @param model The model
     * @param widgetId The widget id
     * @param principal The principal user
     * @return The petition response
     */
    @RequestMapping(value = "/dashboard/showAddToLibraryForm/{widgetId}", method = RequestMethod.GET)
    public String showAddToLibraryForm(
    		Map<String, Object> model,
    		@PathVariable("widgetId") Integer widgetId, 
    		Principal principal) {
    	
    	model.put("widgetId", widgetId);
    	model.put("categories", widgetCategoryService.findAll());
    	
    	return "widget/addToLibrary";
    }
    
    /**
     * Add a widget to library
     * @param widgetId The widget id
     * @param categoryId The category id
     * @param principal The principal user
     * @return The request response
     */
    @RequestMapping(value = "/dashboard/addToLibrary", method = RequestMethod.POST)
    public String addToLibrary(
    		@RequestParam(value="widgetId") Integer widgetId,
    		@RequestParam(value="categoryId") Integer categoryId,
    		Principal principal) {
    	addOrRemoveWidgetFromLibrary(widgetId, principal, categoryId);
    	return "closeIframeUpdateParent";
    }
    
    /**
     * Remove a widget from library
     * @param widgetId The widget id
     * @param principal The principal user
     */
    @RequestMapping(value = "/dashboard/removeFromLibrary", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void removeFromLibrary(
    		@RequestParam(value="widgetId") Integer widgetId,
    		Principal principal) {
    	addOrRemoveWidgetFromLibrary(widgetId, principal, null);
    }
    
    /**
     * Set a widget as default
     * @param widgetId The widget id
     * @param principal The principal user
     */
    @RequestMapping(value = "/dashboard/setAsDefault", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void setAsDefault(
    		@RequestParam(value="widgetId") Integer widgetId,
    		Principal principal) {
    	setWidgetDefault(widgetId, principal, true);
    }
    
    /**
     * Unset a widget as default
     * @param widgetId The widget id
     * @param principal The principal user
     */
    @RequestMapping(value = "/dashboard/unsetAsDefault", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void unsetAsDefault(
    		@RequestParam(value="widgetId") Integer widgetId,
    		Principal principal) {
    	setWidgetDefault(widgetId, principal, false);
    }
    
    /**
     * Set a widget as default
     * @param widgetId The widget id
     * @param principal The principal user
     * @param isDefault Indicates if default is true or false
     */
    private void setWidgetDefault(Integer widgetId, Principal principal, boolean isDefault) {
    	if (widgetId != null && principal != null) {
    		User loggedUser = userService.getUserByUsername(principal.getName());
    		widgetService.setWidgetDefault(widgetId, loggedUser, isDefault);
    	}
    }
    
    /**
     * Create or edit a widget
     * @param model The model
     * @param principal The principal user
     * @param widgetId The widget id
     * @return The petition response
     */
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
    	
    	model.put("queryTypes", WidgetQueryAssociationType.values());
    	model.put("widget", widget);
    	model.put("operationType", operationType);
    	
    	return "widget/createOrEdit";
    }
    /**
     * Add or remove a widget from library
     * @param widgetId the widget id
     * @param principal the principal user
     * @param categoryId the category id
     */
    private void addOrRemoveWidgetFromLibrary(Integer widgetId, Principal principal, Integer categoryId) {
    	if (widgetId != null && principal != null) {
    		User loggedUser = userService.getUserByUsername(principal.getName());
    		widgetService.addOrRemoveWidgetToLibrary(widgetId, loggedUser, categoryId);
    	}
    }
}
