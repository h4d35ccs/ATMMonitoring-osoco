package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Widget;

/**
 * @author Rafael Luque (OSOCO)
 */

@Repository
public class WidgetDAOImpl implements WidgetDAO {

    static private Logger logger = Logger.getLogger(WidgetDAOImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Widget widget) {
		sessionFactory.getCurrentSession().save(widget);
		logger.debug("Created new Widget with id " + widget.getId());
    }

    @Override
    public void update(Widget widget) {
		sessionFactory.getCurrentSession().update(
		    sessionFactory.getCurrentSession().merge(widget));
		logger.debug("Updated Widget with id " + widget.getId());
    }

    @Override
    public List<Widget> findDefaultWidgets() {
		return sessionFactory.getCurrentSession().createCriteria(Widget.class).
			add(Restrictions.eq("defaultWidget", true)).addOrder(Order.asc("title")).list();
    }

	@Override
	public Widget findById(int id) {
		return (Widget) sessionFactory.getCurrentSession().get(Widget.class, id);
	}

}
