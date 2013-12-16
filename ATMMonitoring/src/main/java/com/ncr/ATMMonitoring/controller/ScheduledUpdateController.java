package com.ncr.ATMMonitoring.controller;

import java.security.Principal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.controller.propertyEditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.ScheduledUpdateService;
import com.ncr.ATMMonitoring.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class ScheduledUpdateController.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class ScheduledUpdateController {

    /** The logger. */
    private static Logger logger = Logger.getLogger(ScheduledUpdateController.class.getName());
	
	/** The event date format. */
	private static SimpleDateFormat eventDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	/** The weekly title date format. */
	private static SimpleDateFormat weeklyTitleDateFormat = new SimpleDateFormat("EEEE");
	
	/** The monthly title date format. */
	private static SimpleDateFormat monthlyTitleDateFormat = new SimpleDateFormat("'día' d");
	
	/** The event duration in millis. */
	private static long EVENT_DURATION_IN_MILLIS = 60 * 60 * 1000;

    /** The scheduled update service. */
    @Autowired
    private ScheduledUpdateService scheduledUpdateService;

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Binder.
     *
     * @param binder the binder
     * @throws Exception the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
    	binder.registerCustomEditor(Date.class, new DatePropertyEditor(true));
    }

    /**
     * List schedules.
     *
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping(value = "/terminals/schedules/list", method = RequestMethod.GET)
    public String listSchedules(Map<String, Object> map,
								HttpServletRequest request, Principal principal) {
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
				.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
			map.put("userMsg", userMsg);
			map.put("weeklyScheduledUpdates",
					loggedUser.getWeeklyScheduledUpdates());
			map.put("monthlyScheduledUpdates",
					loggedUser.getMonthlyScheduledUpdates());
		}
		return "scheduledUpdates";
    }

    /**
     * New scheduled update.
     *
     * @param map the map
     * @param queryId the query id
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping(value = "/terminals/schedules/new", method = RequestMethod.GET)
    public String newScheduledUpdate(Map<String, Object> map,
				     String queryId,
				     HttpServletRequest request, Principal principal) {
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
				.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
			Set userQueries = loggedUser.getQueries();
			map.put("userQueries", userQueries);
			map.put("userMsg", userMsg);
			map.put("scheduledUpdate", new ScheduledUpdate());
		}
		if (queryId != null) {

		    Query query = new Query();
		    query.setId(Integer.parseInt(queryId));
		    map.put("query", query);
		}
		return "newScheduledUpdate";
    }

    /**
     * List update events.
     *
     * @param start the start
     * @param end the end
     * @param request the request
     * @param principal the principal
     * @return the list
     */
    @RequestMapping(value = "/terminals/schedules/updates", method = RequestMethod.GET)
	@ResponseBody
    public List listUpdateEvents(long start, long end, HttpServletRequest request, Principal principal) {
		logger.debug("update events from " + start + " to " + end);
		List updates = null;
		if (principal != null) {
			User loggedUser = userService.getUserByUsername(principal.getName());
			updates = new ArrayList();
			List<ScheduledUpdate> weeklyUpdates = loggedUser.getWeeklyScheduledUpdates();
			List<ScheduledUpdate> monthlyUpdates = loggedUser.getMonthlyScheduledUpdates();
			updates = new ArrayList();
			updates.addAll(weeklyUpdates);
			updates.addAll(monthlyUpdates);
		}
		return toCalendarEventsJSON(updates, start, end);
    }

    /**
     * Adds the scheduled update.
     *
     * @param scheduledUpdate the scheduled update
     * @param result the result
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @RequestMapping(value = "/terminals/schedules/list", method = RequestMethod.POST)
    public String addScheduledUpdate(
            @Valid @ModelAttribute("scheduledUpdate")
			ScheduledUpdate scheduledUpdate,
			BindingResult result,
			Map<String, Object> map,
			HttpServletRequest request,
			Principal principal,
		    RedirectAttributes redirectAttributes) {
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
				.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
			Set userQueries = loggedUser.getQueries();
			map.put("userQueries", userQueries);
			map.put("userMsg", userMsg);
		}

		logger.debug("update's query': " + scheduledUpdate.getQuery().getId());

		if ((scheduledUpdate.getQuery() == null) || (scheduledUpdate.getQuery().getId() == null)) {
			map.put("error", "scheduledUpdate.nullQuery");
		} else if ((scheduledUpdate.getWeekDay() == null) && (scheduledUpdate.getMonthDay() == null)) {
			map.put("error", "scheduledUpdate.missing.mandatory.fields");
		} else if (scheduledUpdateService.existsScheduledUpdate(scheduledUpdate)) {
			map.put("error", "duplicated.scheduledUpdate");
		}

		if (map.get("error") != null) {
			ScheduledUpdate newScheduledUpdate = scheduledUpdate;
			map.put("scheduledUpdate", newScheduledUpdate);
			return "newScheduledUpdate";
		} else {
			scheduledUpdateService.addScheduledUpdate(scheduledUpdate);
			redirectAttributes.addFlashAttribute("success", "label.new.scheduledUpdate.created");
			return "redirect:/terminals/schedules/list";
		}
	}

    /**
     * Redirect to schedules.
     *
     * @return the string
     */
    @RequestMapping("/terminals/schedules")
    public String redirectToSchedules() {
	return "redirect:/terminals/schedules/list";
    }

    /**
     * Delete scheduled update.
     *
     * @param scheduledUpdateId the scheduled update id
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @RequestMapping("/terminals/schedules/delete/{scheduledUpdateId}")
    public String deleteScheduledUpdate(
		    @PathVariable("scheduledUpdateId") Integer scheduledUpdateId,
			RedirectAttributes redirectAttributes) {
		scheduledUpdateService.removeScheduledUpdate(scheduledUpdateId);
		redirectAttributes.addFlashAttribute("success", "label.new.scheduledUpdate.deleted");
		return "redirect:/terminals/schedules/list";
    }

	/**
	 * To calendar events json.
	 *
	 * @param updates the updates
	 * @param from the from
	 * @param to the to
	 * @return the list
	 */
	private List<Map> toCalendarEventsJSON(List<ScheduledUpdate> updates, long from, long to) {
		logger.debug("updates: " + updates);
		List json = new ArrayList();
		if (updates != null) {
			for(ScheduledUpdate update: updates) {
				List<Date> eventDates = update.getEventDates(from, to);
				for (Date eventDate: eventDates) {
					Map event = new HashMap();
					event.put("id", update.getId());
					event.put("className", (update.isWeekly()) ? "weekly" : "monthly");
					SimpleDateFormat titleDateFormat =
						(update.isWeekly()) ? weeklyTitleDateFormat : monthlyTitleDateFormat;
					event.put("title", titleDateFormat.format(eventDate));
					event.put("start", eventDateFormat.format(eventDate.getTime()));
					Date endDate = new Date(eventDate.getTime() + EVENT_DURATION_IN_MILLIS);
					event.put("end", eventDateFormat.format(endDate.getTime()));
					json.add(event);
				}
			}
		}
		return json;
	}

}
