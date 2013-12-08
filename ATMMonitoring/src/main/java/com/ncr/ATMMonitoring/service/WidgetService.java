package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Interface WidgetService.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */
public interface WidgetService {

	/**
	 * Find default widgets.
	 *
	 * @return the list
	 */
	public List<Widget> findDefaultWidgets();

	/**
	 * Find widget by id.
	 *
	 * @param widgetId the widget id
	 * @return the widget
	 */
	public Widget findWidgetById(int widgetId);

	/**
	 * Builds the default widgets.
	 */
	public void buildDefaultWidgets();

	/**
	 * Save widget.
	 *
	 * @param widget the widget
	 */
	public void saveWidget(Widget widget);

	/**
	 * Copy default widgets to user dashboard.
	 *
	 * @param user the user
	 * @param dashboard the dashboard
	 * @return the list
	 */
	public List<Widget> copyDefaultWidgetsToUserDashboard(User user, Dashboard dashboard);

	/**
	 * Execute query.
	 *
	 * @param widget the widget
	 * @param locale the locale
	 * @return the list
	 */
	public List executeQuery(Widget widget, Locale locale);

}
