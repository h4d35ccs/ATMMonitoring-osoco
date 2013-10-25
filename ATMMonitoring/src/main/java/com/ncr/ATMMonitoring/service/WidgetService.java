package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;

/**
 * @author Rafael Luque (OSOCO)
 */
public interface WidgetService {

	public List<Widget> findDefaultWidgets();

	public Widget findWidgetById(int widgetId);

	public void buildDefaultWidgets();

	public void saveWidget(Widget widget);

	public List<Widget> copyDefaultWidgetsToUserDashboard(User user, Dashboard dashboard);

	public List executeQuery(Widget widget, Locale locale);

}
