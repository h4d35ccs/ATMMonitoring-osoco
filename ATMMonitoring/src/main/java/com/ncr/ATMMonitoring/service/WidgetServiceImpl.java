package com.ncr.ATMMonitoring.service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.pojo.Widget.ChartType;
import com.ncr.ATMMonitoring.dao.WidgetDAO;

/**
 * @author Rafael Luque (OSOCO)
 */

@Service("widgetService")
@Transactional
public class WidgetServiceImpl implements WidgetService {

    static private Logger logger = Logger.getLogger(WidgetServiceImpl.class.getName());

	@Autowired
	private QueryService queryService;

	@Autowired
	private UserService userService;

    @Autowired
    private WidgetDAO widgetDAO;

    @Override
	public List<Widget> findDefaultWidgets() {
		return widgetDAO.findDefaultWidgets();
	}

	@Override
	public void saveWidget(Widget widget) {
		if (widget.getId() == null) {
			logger.debug("Saving widget " + widget);
			widgetDAO.save(widget);
		} else {
			logger.debug("Updating widget " + widget.getId());
			widgetDAO.update(widget);
		}
	}

	@Override
	public List<Widget> copyDefaultWidgetsToUserDashboard(User user, Dashboard dashboard) {
		List<Widget> defaultWidgets = findDefaultWidgets();
		List<Widget> userDefaultWidgets = new ArrayList<Widget> ();
		for (Widget defaultWidget: defaultWidgets) {
			Widget userWidget = new Widget(defaultWidget);
			userWidget.setDefaultWidget(false);
			userWidget.setOwner(user);
			userWidget.setDashboard(dashboard);
			saveWidget(userWidget);
			userDefaultWidgets.add(userWidget);
		}
		return userDefaultWidgets;
	}

	@Override
	public void buildDefaultWidgets() {
		List<Widget> currentDefaultWidgets = findDefaultWidgets();
		List<Widget> defaultWidgets = new ArrayList<Widget>();

		User admin = userService.getUserByUsername("admin");

		Query allTerminalsQuery = new Query();
		allTerminalsQuery.setName("All Terminals");
		allTerminalsQuery.setUser(admin);
		allTerminalsQuery = queryService.findOrCreateQuery(allTerminalsQuery);

		Widget widget1 = buildDefaultWidget(
		    "Bancos", 1, allTerminalsQuery, null, "bank", ChartType.PIE_CHART);
		defaultWidgets.add(widget1);
		Widget widget2 = buildDefaultWidget(
		    "Fabricantes", 2, allTerminalsQuery, null, "terminalVendor", ChartType.BAR_CHART);
		defaultWidgets.add(widget2);
		Widget widget3 = buildDefaultWidget(
		    "Por ciudad", 3, allTerminalsQuery, null, "city", ChartType.GEO_CHART);
		defaultWidgets.add(widget3);
		Widget widget4 = buildDefaultWidget("Versiones IE", 4, allTerminalsQuery, "internetExplorers", "majorVersion", ChartType.PIE_CHART);
		defaultWidgets.add(widget4);
		Widget widget5 = buildDefaultWidget("Modelos", 5, allTerminalsQuery, null, "model", ChartType.PIE_CHART);
		defaultWidgets.add(widget5);

		for (Widget widget: defaultWidgets) {
			if (!currentDefaultWidgets.contains(widget)) {
				logger.debug("Creating default widget '" + widget.getTitle() + "'");
				saveWidget(widget);
			}
		}
	}

	@Override
	public Widget findWidgetById(int widgetId) {
		return widgetDAO.findById(widgetId);
	}

	@Override
	public List executeQuery(Widget widget, Locale locale) {
		return queryService.executeQueryGroupingBy(
		    widget.getQuery(),
			widget.getGroupByEntity(),
			widget.getGroupBy(),
			locale);
	}

	private Widget buildDefaultWidget(
	    String title,
		int order,
		Query query,
		String groupByEntity,
		String groupBy,
		Widget.ChartType chartType) {

		Widget aWidget = new Widget();
		aWidget.setTitle(title);
		aWidget.setOrder(order);
		aWidget.setQuery(query);
		aWidget.setGroupByEntity(groupByEntity);
		aWidget.setGroupBy(groupBy);
		aWidget.setChartType(chartType);
		aWidget.setOwner(userService.getUserByUsername("admin"));
		aWidget.setDefaultWidget(true);
		aWidget.setVisible(true);
		return aWidget;
	}
}
