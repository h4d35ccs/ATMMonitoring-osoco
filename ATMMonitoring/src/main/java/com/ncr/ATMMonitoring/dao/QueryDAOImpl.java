package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Query;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryDAOImpl.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class QueryDAOImpl extends AbstractGenericDAO<Query> implements QueryDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(QueryDAOImpl.class
	    .getName());

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.QueryDAO#addQuery(com.ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public void addQuery(Query query) {
	add(query);
	logger.debug("Created new Query with id " + query.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.QueryDAO#deleteQuery(com.ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public void deleteQuery(Query query) {
	delete(query);
	logger.debug("Deleted Query with id " + query.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.QueryDAO#updateQuery(com.ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public void updateQuery(Query query) {
	update(query);
	logger.debug("Updated Query with id " + query.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.QueryDAO#listQueries()
     */
    @Override
    public List<Query> listQueries() {
	return sessionFactory.getCurrentSession().createCriteria(Query.class)
		.addOrder(Order.asc("name")).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.QueryDAO#getQuery(java.lang.Integer)
     */
    @Override
    public Query getQuery(Integer id) {
	return get(id);
    }
}
