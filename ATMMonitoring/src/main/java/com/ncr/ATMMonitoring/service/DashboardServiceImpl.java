package com.ncr.ATMMonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.DashboardDAO;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * @author Rafael Luque (OSOCO)
 */

@Service("dashboardService")
@Transactional
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private WidgetService widgetService;

	@Autowired
	private UserService userService;

	@Autowired
	private DashboardDAO dashboardDAO;

    @Override
    public Dashboard findDashboardByUser(User user) {
		return (user != null) ? user.getDashboard() : null;
    }

    @Override
    public Dashboard findOrCreateDashboardByUser(User user) {
		Dashboard aDashboard = findDashboardByUser(user);
		if (aDashboard == null) {
			aDashboard = createDefaultDashboardForUser(user);
		}
	    return aDashboard;
    }

	@Override
	public Dashboard createDefaultDashboardForUser(User user) {
		Dashboard aDashboard = new Dashboard();
		aDashboard.setColumns(4); // TODO: retrieve value from config
		saveDashboard(aDashboard);
		widgetService.copyDefaultWidgetsToUserDashboard(user, aDashboard);
		user.setDashboard(aDashboard);
		userService.updateUser(user);
		return aDashboard;
	}

	@Override
	public void saveDashboard(Dashboard dashboard) {
		dashboardDAO.save(dashboard);
	}

}
