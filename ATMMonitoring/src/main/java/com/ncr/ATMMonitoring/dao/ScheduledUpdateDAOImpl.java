package com.ncr.ATMMonitoring.dao;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class ScheduledUpdateDAOImpl implements ScheduledUpdateDAO {

    static private Logger logger = Logger
	    .getLogger(ScheduledUpdateDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	sessionFactory.getCurrentSession().save(scheduledUpdate);
	logger.debug("Created new Scheduled Update with id "
		+ scheduledUpdate.getId());
    }

    @Override
    public List<ScheduledUpdate> listWeeklyScheduledUpdates() {
	return sessionFactory.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.isNotNull("weekDay"))
		.addOrder(Order.asc("weekDay")).addOrder(Order.asc("hour"))
		.addOrder(Order.asc("minute")).list();
    }

    @Override
    public List<ScheduledUpdate> listMonthlyScheduledUpdates() {
	return sessionFactory.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.isNotNull("monthDay"))
		.addOrder(Order.asc("monthDay")).addOrder(Order.asc("hour"))
		.addOrder(Order.asc("minute")).list();
    }

    @Override
    public ScheduledUpdate getScheduledUpdate(Integer id) {
	return (ScheduledUpdate) sessionFactory.getCurrentSession().get(
		ScheduledUpdate.class, id);
    }

    @Override
    public void removeScheduledUpdate(Integer id) {
	ScheduledUpdate scheduledUpdate = (ScheduledUpdate) sessionFactory
		.getCurrentSession().load(ScheduledUpdate.class, id);
	if (scheduledUpdate != null) {
	    sessionFactory.getCurrentSession().delete(scheduledUpdate);
	}
    }

    @Override
    public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	Criteria query = sessionFactory
		.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.eq("hour", scheduledUpdate.getHour()))
		.add(Restrictions.eq("minute", scheduledUpdate.getMinute()))
		.add(Restrictions.eq("monthDay", scheduledUpdate.getMonthDay()))
		.add(Restrictions.eq("query", scheduledUpdate.getQuery()));
	return (query.uniqueResult() != null);
    }

    @Override
    public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	Criteria query = sessionFactory.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.eq("hour", scheduledUpdate.getHour()))
		.add(Restrictions.eq("minute", scheduledUpdate.getMinute()))
		.add(Restrictions.eq("weekDay", scheduledUpdate.getWeekDay()))
		.add(Restrictions.eq("query", scheduledUpdate.getQuery()));
	return (query.uniqueResult() != null);
    }

    @Override
    public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date) {
	return sessionFactory
		.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.or(Restrictions.and(Restrictions.eq("hour",
			new Integer(date.get(Calendar.HOUR_OF_DAY))
				.shortValue()), Restrictions.eq("minute",
			new Integer(date.get(Calendar.MINUTE)).shortValue()),
			Restrictions.eq("monthDay",
				new Integer(date.get(Calendar.DAY_OF_MONTH))
					.shortValue())), Restrictions.and(
			Restrictions.eq("hour",
				new Integer(date.get(Calendar.HOUR_OF_DAY))
					.shortValue()), Restrictions.eq(
				"minute",
				new Integer(date.get(Calendar.MINUTE))
					.shortValue()), Restrictions.eq(
				"weekDay",
				new Integer(date.get(Calendar.DAY_OF_WEEK))
					.shortValue())))).list();
    }
}