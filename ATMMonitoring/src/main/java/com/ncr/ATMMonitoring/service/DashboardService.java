package com.ncr.ATMMonitoring.service;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * @author Rafael Luque (OSOCO)
 */
public interface DashboardService {

	public Dashboard findDashboardByUser(User user);

	public Dashboard findOrCreateDashboardByUser(User user);

	public Dashboard createDefaultDashboardForUser(User user);

	public void saveDashboard(Dashboard dashboard);

}
