package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Locale;

import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.pojo.WidgetCategory;

/**
 * The Interface WidgetService.
 * 
 * It contains the widget related methods.
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
	public List<Widget> copyDefaultWidgetsToUserDashboard(User user);

	/**
	 * Execute query.
	 *
	 * @param widget the widget
	 * @param locale the locale
	 * @return the list
	 */
	public List<?> executeQuery(Widget widget, Locale locale);
	
	public void deleteWidgetFromUser(Integer widgetId, User loggedUser);

	public Boolean isWidgetOwnedByUser(Widget widget, User user);

	public void createWidgetForUser(Widget widget, User user);

	public void addWidgetsFromLibrary(List<Integer> widgetIds, User user);

	public List<WidgetCategory> findLibraryWidgetsByCategory();

	public void addOrRemoveWidgetToLibrary(Integer widgetId, User user, Integer categoryId);

	public void setWidgetDefault(Integer widgetId, User user, boolean isDefault);

	public WidgetCategory findCategoryById(Integer categoryId);
}
