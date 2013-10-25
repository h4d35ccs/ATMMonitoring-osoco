package com.ncr.ATMMonitoring.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Dashboard;

/**
 * @author Rafael Luque (OSOCO)
 */

@Repository
public class DashboardDAOImpl implements DashboardDAO {

    static private Logger logger = Logger.getLogger(DashboardDAOImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Dashboard dashboard) {
		sessionFactory.getCurrentSession().save(dashboard);
		logger.debug("Created new Dashboard with id " + dashboard.getId());
    }

}
