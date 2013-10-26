package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.ScheduledUpdateService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class ScheduledUpdateController {

    static private Logger logger = Logger.getLogger(ScheduledUpdateController.class.getName());

    @Autowired
    private ScheduledUpdateService scheduledUpdateService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/terminals/schedules/list", method = RequestMethod.GET)
    public String listSchedules(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	map.put("scheduledUpdate", new ScheduledUpdate());
	map.put("duplicatedScheduledUpdate", false);
	map.put("weeklyScheduledUpdates",
		scheduledUpdateService.listWeeklyScheduledUpdates());
	map.put("monthlyScheduledUpdates",
		scheduledUpdateService.listMonthlyScheduledUpdates());
	return "scheduledUpdates";
    }

    @RequestMapping(value = "/terminals/schedules/updates", method = RequestMethod.GET)
	@ResponseBody
    public List listUpdateEvents(long start, long end, HttpServletRequest request, Principal principal) {
		logger.debug("update events from " + start + " to " + end);
		List updates = null;
		if (principal != null) {
			updates = new ArrayList();
			List<ScheduledUpdate> weeklyUpdates = scheduledUpdateService.listWeeklyScheduledUpdates();
			List<ScheduledUpdate> monthlyUpdates = scheduledUpdateService.listMonthlyScheduledUpdates();
			updates = new ArrayList();
			updates.addAll(weeklyUpdates);
			updates.addAll(monthlyUpdates);
		}
		return toCalendarEventsJSON(updates, start, end);
    }

    @RequestMapping(value = "/terminals/schedules/list", method = RequestMethod.POST)
    public String addScheduledUpdate(
	    @Valid @ModelAttribute("scheduledUpdate") ScheduledUpdate scheduledUpdate,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	boolean duplicatedScheduledUpdate = false;
	ScheduledUpdate newScheduledUpdate;
	if (scheduledUpdateService.existsScheduledUpdate(scheduledUpdate)) {
	    duplicatedScheduledUpdate = true;
	    newScheduledUpdate = scheduledUpdate;
	} else {
	    scheduledUpdateService.addScheduledUpdate(scheduledUpdate);
	    newScheduledUpdate = new ScheduledUpdate();
	}
	map.put("userMsg", userMsg);
	map.put("scheduledUpdate", newScheduledUpdate);
	map.put("duplicatedScheduledUpdate", duplicatedScheduledUpdate);
	map.put("weeklyScheduledUpdates",
		scheduledUpdateService.listWeeklyScheduledUpdates());
	map.put("monthlyScheduledUpdates",
		scheduledUpdateService.listMonthlyScheduledUpdates());

	return "";
    }

    @RequestMapping("/terminals/schedules")
    public String redirectToSchedules() {
	return "redirect:/terminals/schedules/list";
    }

    @RequestMapping("/terminals/schedules/delete/{scheduledUpdateId}")
    public String deleteScheduledUpdate(
	    @PathVariable("scheduledUpdateId") Integer scheduledUpdateId) {
	scheduledUpdateService.removeScheduledUpdate(scheduledUpdateId);
	return "redirect:/terminals/schedules/list";
    }

	private List<Map> toCalendarEventsJSON(List<ScheduledUpdate> updates, long from, long to) {
		logger.debug("updates: " + updates);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		List json = new ArrayList();
		if (updates != null) {
			for(ScheduledUpdate update: updates) {
				List<Date> eventDates = update.getEventDates(from, to);
				for (Date eventDate: eventDates) {
					Map event = new HashMap();
					event.put("id", update.getId());
					event.put("title", "Event " + update.getId());
					event.put("className", (update.isWeekly()) ? "weekly" : "monthly");
					event.put("start", df.format(eventDate.getTime()));
					json.add(event);
				}
			}
		}
		logger.debug("json: " + json);
		return json;
	}

}
