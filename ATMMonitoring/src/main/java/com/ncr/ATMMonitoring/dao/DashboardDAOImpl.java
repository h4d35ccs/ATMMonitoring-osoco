package com.ncr.ATMMonitoring.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.Query;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardDAOImpl.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Repository
public class DashboardDAOImpl extends AbstractGenericDAO<Dashboard> implements
	DashboardDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(DashboardDAOImpl.class.getName());

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.DashboardDAO#save(com.ncr.ATMMonitoring.pojo.Dashboard)
     */
    @Override
    public void save(Dashboard dashboard) {
	add(dashboard);
	logger.debug("Created new Dashboard with id " + dashboard.getId());
    }

}
