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
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;
import com.ncr.ATMMonitoring.dao.WidgetDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class WidgetServiceImpl.
 * 
 * Default implementation of the WidgetService.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Service("widgetService")
@Transactional
public class WidgetServiceImpl implements WidgetService {

    /** The logger. */
    static private Logger logger = Logger.getLogger(WidgetServiceImpl.class.getName());

	/** The query service. */
	@Autowired
	private QueryService queryService;

	/** The user service. */
	@Autowired
	private UserService userService;

    /** The widget dao. */
    @Autowired
    private WidgetDAO widgetDAO;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.WidgetService#findDefaultWidgets()
     */
    @Override
	public List<Widget> findDefaultWidgets() {
		return widgetDAO.findDefaultWidgets();
	}

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.WidgetService#saveWidget(com.ncr.ATMMonitoring.pojo.Widget)
	 */
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

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.WidgetService#copyDefaultWidgetsToUserDashboard(com.ncr.ATMMonitoring.pojo.User, com.ncr.ATMMonitoring.pojo.Dashboard)
	 */
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

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.WidgetService#buildDefaultWidgets()
	 */
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
		    "Bancos", 1, allTerminalsQuery, WidgetQueryAssociationType.TERMINAL, "bank", ChartType.PIE_CHART);
		defaultWidgets.add(widget1);
		
		Widget widget2 = buildDefaultWidget(
		    "Fabricantes", 2, allTerminalsQuery, WidgetQueryAssociationType.TERMINAL, "terminalVendor", ChartType.BAR_CHART);
		defaultWidgets.add(widget2);
		
		Widget widget3 = buildDefaultWidget( "Por ciudad", 3, allTerminalsQuery, WidgetQueryAssociationType.INSTALLATION, 
				"location.addressCity", ChartType.GEO_CHART);
		defaultWidgets.add(widget3);
		
		Widget widget4 = buildDefaultWidget(
				"Versiones IE", 4, allTerminalsQuery, WidgetQueryAssociationType.INTERNET_EXPLORER, 
				"internetExplorer.majorVersion", ChartType.PIE_CHART);
		defaultWidgets.add(widget4);
		
		Widget widget5 = buildDefaultWidget("Ciudades", 5, allTerminalsQuery, WidgetQueryAssociationType.INSTALLATION,
				"location.addressCity", ChartType.PIE_CHART);
		defaultWidgets.add(widget5);
		
		Widget widget6 = buildDefaultWidget("Sistemas operativos", 6, allTerminalsQuery, 
				WidgetQueryAssociationType.OPERATING_SYSTEM, "name", ChartType.PIE_CHART);
		defaultWidgets.add(widget6);
		
		for (Widget widget: defaultWidgets) {
			if (!currentDefaultWidgets.contains(widget)) {
				logger.debug("Creating default widget '" + widget.getTitle() + "'");
				saveWidget(widget);
			}
		}
	}
	
	@Override
	public void deleteWidgetFromUser(Integer widgetId, User user) {
		Widget widget = findWidgetById(widgetId);
		if (isWidgetOwnedByUser(widget, user)) {
			user.getDashboard().getWidgets().remove(widget);
			userService.updateUser(user);
			widgetDAO.delete(widget);
		}
	}
	
	@Override
	public Boolean isWidgetOwnedByUser(Widget widget, User user) {
		return user != null && widget != null && user.equals(widget.getOwner());
	}

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.WidgetService#findWidgetById(int)
	 */
	@Override
	public Widget findWidgetById(int widgetId) {
		return widgetDAO.findById(widgetId);
	}

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.WidgetService#executeQuery(com.ncr.ATMMonitoring.pojo.Widget, java.util.Locale)
	 */
	@Override
	public List executeQuery(Widget widget, Locale locale) {
		return queryService.executeQueryGroupingBy(
		    widget.getQuery(),
			widget.getGroupByEntity(),
			widget.getGroupBy(),
			locale);
	}

	/**
	 * Builds the default widget.
	 *
	 * @param title the title
	 * @param order the order
	 * @param query the query
	 * @param groupByEntity the group by entity
	 * @param groupBy the group by
	 * @param chartType the chart type
	 * @return the widget
	 */
	private Widget buildDefaultWidget(
	    String title,
		int order,
		Query query,
		WidgetQueryAssociationType groupByEntity,
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
