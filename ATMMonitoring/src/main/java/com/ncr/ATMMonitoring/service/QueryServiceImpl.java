package com.ncr.ATMMonitoring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.QueryDAO;
import com.ncr.ATMMonitoring.dao.TerminalDAO;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryServiceImpl.
 *
 * @author Jorge L�pez Fern�ndez (lopez.fernandez.jorge@gmail.com)
 */

@Service("queryService")
@Transactional
public class QueryServiceImpl implements QueryService {

	/** The logger. */
	static private Logger logger = Logger.getLogger(QueryServiceImpl.class.getName());

    /** The query dao. */
    @Autowired
    private QueryDAO queryDAO;

    /** The terminal dao. */
    @Autowired
    private TerminalDAO terminalDAO;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#addQuery(com.ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public void addQuery(Query query) {
	queryDAO.addQuery(query);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#deleteQuery(com.ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public void deleteQuery(Query query) {
	queryDAO.deleteQuery(query);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#updateQuery(com.ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public void updateQuery(Query query) {
	queryDAO.updateQuery(query);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#listQueries()
     */
    @Override
    public List<Query> listQueries() {
	return queryDAO.listQueries();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#getQuery(java.lang.Integer)
     */
    @Override
    public Query getQuery(Integer id) {
	return queryDAO.getQuery(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#executeQuery(com.ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public List<Terminal> executeQuery(Query query) {
		Locale locale = query.getTrueLocale();
		if (locale == null) {
			logger.warn("No stored locale for query with id '" + query.getId()
						+ "'. Will try to execute with default Locale.");
			locale = Locale.getDefault();
		}
		List<Object> values = new ArrayList<Object>();
		List<Type> types = new ArrayList<Type>();
		String hql = query.getHQL(values, types, locale);
		if ((hql == null) || (hql.equals(""))) {
			return null;
		}
		return terminalDAO.getTerminalsByHQL(values, types, hql);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#executeQuery(com.ncr.ATMMonitoring.pojo.Query, java.util.Locale)
     */
    @Override
    public List<Terminal> executeQuery(Query query, Locale locale) {
		return executeQuery(query, locale, null, null);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.QueryService#executeQuery(com.ncr.ATMMonitoring.pojo.Query, java.util.Locale, java.lang.String, java.lang.String)
     */
    @Override
    public List<Terminal> executeQuery(Query query, Locale locale, String sort, String order) {
		List<Object> values = new ArrayList<Object>();
		List<Type> types = new ArrayList<Type>();
		String hql = query.getHQL(values, types, locale, false);
		if ((hql == null) || (hql.equals(""))) {
			return null;
		}
		return terminalDAO.getTerminalsByHQL(values, types, hql, sort, order);
    }

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.QueryService#findOrCreateQuery(com.ncr.ATMMonitoring.pojo.Query)
	 */
	@Override
	public Query findOrCreateQuery(Query query) {
		Query result = null;
		List<Query> queries = listQueries();
		if (!queries.contains(query)) {
			addQuery(query);
			result = query;
		} else {
			result = queries.get(queries.indexOf(query));
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.QueryService#executeQueryGroupingBy(com.ncr.ATMMonitoring.pojo.Query, java.lang.String, java.lang.String, java.util.Locale)
	 */
	@Override
	public List executeQueryGroupingBy(Query query, String groupByEntity, String groupByField, Locale locale) {
		List results = null;
		List<Object> values = new ArrayList<Object>();
		List<Type> types = new ArrayList<Type>();
		String hql = query.getHQLGroupingBy(values, types, locale, groupByEntity, groupByField);
        logger.debug("HQL for widget's query is: " + hql);
		if ((hql != null) && (!hql.equals(""))) {
			results = terminalDAO.executeQuery(values, types, hql);
		}
		return results;
	}

}
