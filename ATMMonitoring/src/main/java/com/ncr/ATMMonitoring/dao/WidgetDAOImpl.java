package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Class WidgetDAOImpl.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Repository
public class WidgetDAOImpl implements WidgetDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(WidgetDAOImpl.class.getName());

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.WidgetDAO#save(com.ncr.ATMMonitoring.pojo.Widget)
     */
    @Override
    public void save(Widget widget) {
		sessionFactory.getCurrentSession().save(widget);
		logger.debug("Created new Widget with id " + widget.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.WidgetDAO#update(com.ncr.ATMMonitoring.pojo.Widget)
     */
    @Override
    public void update(Widget widget) {
		sessionFactory.getCurrentSession().update(
		    sessionFactory.getCurrentSession().merge(widget));
		logger.debug("Updated Widget with id " + widget.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.WidgetDAO#findDefaultWidgets()
     */
    @Override
    public List<Widget> findDefaultWidgets() {
		return sessionFactory.getCurrentSession().createCriteria(Widget.class).
			add(Restrictions.eq("defaultWidget", true)).addOrder(Order.asc("title")).list();
    }

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.dao.WidgetDAO#findById(int)
	 */
	@Override
	public Widget findById(int id) {
		return (Widget) sessionFactory.getCurrentSession().get(Widget.class, id);
	}

}
