package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Query;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class QueryDAOImpl implements QueryDAO {

    static private Logger logger = Logger.getLogger(QueryDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addQuery(Query query) {
	sessionFactory.getCurrentSession().save(query);
	logger.debug("Created new Query with id " + query.getId());
    }

    @Override
    public void deleteQuery(Query query) {
	sessionFactory.getCurrentSession().delete(query);
    }

    @Override
    public void updateQuery(Query query) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(query));
    }

    @Override
    public List<Query> listQueries() {
	return sessionFactory.getCurrentSession().createCriteria(Query.class)
		.addOrder(Order.asc("serialNumber")).list();
    }

    @Override
    public Query getQuery(Integer id) {
	return (Query) sessionFactory.getCurrentSession().get(Query.class, id);
    }
}