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

    private static Logger logger = Logger.getLogger(ScheduledUpdateController.class.getName());
	private static SimpleDateFormat eventDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	private static SimpleDateFormat weeklyTitleDateFormat = new SimpleDateFormat("EEEE");
	private static SimpleDateFormat monthlyTitleDateFormat = new SimpleDateFormat("'día' d");
	private static long EVENT_DURATION_IN_MILLIS = 60 * 60 * 1000;

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
			map.put("userMsg", userMsg);
			map.put("weeklyScheduledUpdates",
					scheduledUpdateService.listWeeklyScheduledUpdates());
			map.put("monthlyScheduledUpdates",
					scheduledUpdateService.listMonthlyScheduledUpdates());
		}
		return "scheduledUpdates";
    }

    @RequestMapping(value = "/terminals/schedules/new", method = RequestMethod.GET)
    public String newScheduledUpdate(Map<String, Object> map,
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
			map.put("duplicatedScheduledUpdate", false);
		}
		return "newScheduledUpdate";
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

		map.put("userMsg", userMsg);

	    logger.debug("update: " + scheduledUpdate);

		if (scheduledUpdateService.existsScheduledUpdate(scheduledUpdate)) {
			boolean duplicatedScheduledUpdate = true;
			ScheduledUpdate newScheduledUpdate = scheduledUpdate;
			map.put("scheduledUpdate", newScheduledUpdate);
			map.put("duplicatedScheduledUpdate", duplicatedScheduledUpdate);
			return "newScheduledUpdate";
		} else {
			scheduledUpdateService.addScheduledUpdate(scheduledUpdate);
			return "redirect:/terminals/schedules/list";
		}
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
