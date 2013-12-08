package com.ncr.ATMMonitoring.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;

// TODO: Auto-generated Javadoc
/**
 * The Class ScheduledUpdateDAOImpl.
 *
 * @author Jorge L�pez Fern�ndez (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class ScheduledUpdateDAOImpl implements ScheduledUpdateDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(ScheduledUpdateDAOImpl.class.getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#addScheduledUpdate(com.ncr.ATMMonitoring.pojo.ScheduledUpdate)
     */
    @Override
    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	sessionFactory.getCurrentSession().save(scheduledUpdate);
	logger.debug("Created new Scheduled Update with id "
		+ scheduledUpdate.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#listWeeklyScheduledUpdates()
     */
    @Override
    public List<ScheduledUpdate> listWeeklyScheduledUpdates() {
	return sessionFactory.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.isNotNull("weekDay"))
		.addOrder(Order.asc("weekDay")).addOrder(Order.asc("hour"))
		.addOrder(Order.asc("minute")).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#listMonthlyScheduledUpdates()
     */
    @Override
    public List<ScheduledUpdate> listMonthlyScheduledUpdates() {
	return sessionFactory.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.isNotNull("monthDay"))
		.addOrder(Order.asc("monthDay")).addOrder(Order.asc("hour"))
		.addOrder(Order.asc("minute")).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#getScheduledUpdate(java.lang.Integer)
     */
    @Override
    public ScheduledUpdate getScheduledUpdate(Integer id) {
	return (ScheduledUpdate) sessionFactory.getCurrentSession().get(
		ScheduledUpdate.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#removeScheduledUpdate(java.lang.Integer)
     */
    @Override
    public void removeScheduledUpdate(Integer id) {
	ScheduledUpdate scheduledUpdate = (ScheduledUpdate) sessionFactory
		.getCurrentSession().load(ScheduledUpdate.class, id);
	if (scheduledUpdate != null) {
	    sessionFactory.getCurrentSession().delete(scheduledUpdate);
	}
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#existsMonthlyScheduledUpdate(com.ncr.ATMMonitoring.pojo.ScheduledUpdate)
     */
    @Override
    public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	Criteria query = sessionFactory
		.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.eq("hour", scheduledUpdate.getHour()))
		.add(Restrictions.eq("timeZone", scheduledUpdate.getTimeZone()))
		.add(Restrictions.eq("minute", scheduledUpdate.getMinute()))
		.add(Restrictions.eq("monthDay", scheduledUpdate.getMonthDay()))
		.add(Restrictions.eq("query", scheduledUpdate.getQuery()));
	return (query.uniqueResult() != null);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#existsWeeklyScheduledUpdate(com.ncr.ATMMonitoring.pojo.ScheduledUpdate)
     */
    @Override
    public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	Criteria query = sessionFactory
		.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.eq("hour", scheduledUpdate.getHour()))
		.add(Restrictions.eq("timeZone", scheduledUpdate.getTimeZone()))
		.add(Restrictions.eq("minute", scheduledUpdate.getMinute()))
		.add(Restrictions.eq("weekDay", scheduledUpdate.getWeekDay()))
		.add(Restrictions.eq("query", scheduledUpdate.getQuery()));
	return (query.uniqueResult() != null);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO#listValidScheduledUpdates(java.util.Calendar)
     */
    @Override
    public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date) {
	date.setTimeZone(TimeZone.getTimeZone("GMT"));
	return sessionFactory
		.getCurrentSession()
		.createCriteria(ScheduledUpdate.class)
		.add(Restrictions.and(Restrictions.le("startDate", new Date()),
			Restrictions.eq("gmtHour",
				new Integer(date.get(Calendar.HOUR_OF_DAY))
					.shortValue()), Restrictions.eq(
				"minute",
				new Integer(date.get(Calendar.MINUTE))
					.shortValue()), Restrictions.or(
				Restrictions.eq(
					"gmtMonthDay",
					new Integer(date
						.get(Calendar.DAY_OF_MONTH))
						.shortValue()),
				Restrictions.eq(
					"gmtWeekDay",
					new Integer(date
						.get(Calendar.DAY_OF_WEEK))
						.shortValue())))).list();
    }
}