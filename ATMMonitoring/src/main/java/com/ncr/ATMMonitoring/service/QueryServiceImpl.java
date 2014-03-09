package com.ncr.ATMMonitoring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.QueryDAO;
import com.ncr.ATMMonitoring.dao.TerminalDAO;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;

/**
 * The Class QueryServiceImpl.
 * 
 * Default implementation of the QueryService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("queryService")
@Transactional
public class QueryServiceImpl implements QueryService {

	/** The logger. */
	static private Logger logger = Logger.getLogger(QueryServiceImpl.class
			.getName());

	/** The query dao. */
	@Autowired
	private QueryDAO queryDAO;

	/** The terminal dao. */
	@Autowired
	private TerminalDAO terminalDAO;

	@Autowired
	private UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#addQuery(com.ncr.ATMMonitoring
	 * .pojo.Query)
	 */
	@Override
	public void addQuery(Query query) {
		queryDAO.addQuery(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#deleteQuery(com.ncr.ATMMonitoring
	 * .pojo.Query)
	 */
	@Override
	public void deleteQuery(Query query) {
		queryDAO.deleteQuery(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#updateQuery(com.ncr.ATMMonitoring
	 * .pojo.Query)
	 */
	@Override
	public void updateQuery(Query query) {
		queryDAO.updateQuery(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ncr.ATMMonitoring.service.QueryService#listQueries()
	 */
	@Override
	public List<Query> listQueries() {
		return queryDAO.listQueries();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#getQuery(java.lang.Integer)
	 */
	@Override
	public Query getQuery(Integer id) {
		return queryDAO.getQuery(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#executeQuery(com.ncr.ATMMonitoring
	 * .pojo.Query)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#executeQuery(com.ncr.ATMMonitoring
	 * .pojo.Query, java.util.Locale)
	 */
	@Override
	public List<Terminal> executeQuery(Query query, Locale locale) {
		return executeQuery(query, locale, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#executeQuery(com.ncr.ATMMonitoring
	 * .pojo.Query, java.util.Locale, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Terminal> executeQuery(Query query, Locale locale, String sort,
			String order) {
		return executeQuery(query, locale, sort, order, null);
	}

	@Override
	public List<Terminal> executeQuery(Query query, Locale locale, String sort,
			String order, Date queryDate) {
		List<Object> values = new ArrayList<Object>();
		List<Type> types = new ArrayList<Type>();
		String hql = query.getHQL(values, types, locale, false, queryDate);
		if ((hql == null) || (hql.equals(""))) {
			return null;
		}
		return terminalDAO.getTerminalsByHQL(values, types, hql, sort, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#findOrCreateQuery(com.ncr.
	 * ATMMonitoring.pojo.Query)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#executeQueryGroupingBy(com
	 * .ncr.ATMMonitoring.pojo.Query, java.lang.String, java.lang.String,
	 * java.util.Locale)
	 */
	@Override
	public List<?> executeQueryGroupingBy(Query query,
			WidgetQueryAssociationType groupByEntity, String groupByField,
			Locale locale, Date queryDate) {
		List<?> results = null;
		List<Object> values = new ArrayList<Object>();
		List<Type> types = new ArrayList<Type>();
		String hql = query.getHQLGroupingBy(values, types, locale,
				groupByEntity, groupByField, queryDate);
		logger.debug("HQL for widget's query is: " + hql);
		if ((hql != null) && (!hql.equals(""))) {
			results = terminalDAO.getTerminalsByHQL(values, types, hql);
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#getQueriesByUser(java.lang
	 * .String)
	 */
	@Override
	public Set<Query> getQueriesByUser(String username) {
		Set<Query> queries = null;
		User loggedUser = this.userService.getUserByUsername(username);
		if (loggedUser != null) {
			queries = this.getQueriesByUser(loggedUser);
		}
		return queries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ncr.ATMMonitoring.service.QueryService#getQueriesByUser(com.ncr.
	 * ATMMonitoring.pojo.User)
	 */
	@Override
	public Set<Query> getQueriesByUser(User user) {

		return user.getQueries();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#queryBelongToUser(com.ncr.
	 * ATMMonitoring.pojo.Query, java.lang.String)
	 */
	@Override
	public boolean queryBelongToUser(Query query, String username) {

		boolean queryBelongs = false;

		User loggedUser = this.userService.getUserByUsername(username);
		if (query.getUser().getId().equals(loggedUser.getId())) {
			queryBelongs = true;
		}
		return queryBelongs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#addQuery(com.ncr.ATMMonitoring
	 * .pojo.Query, java.lang.String)
	 */
	@Override
	public void addQuery(Query query, String username) {
		User loggedUser = this.userService.getUserByUsername(username);
		if (loggedUser != null) {
			query.setUser(loggedUser);
			this.addQuery(query);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.service.QueryService#updateQuery(com.ncr.ATMMonitoring
	 * .pojo.Query, java.lang.String)
	 */
	@Override
	public void updateQuery(Query query, String username) {
		User loggedUser = this.userService.getUserByUsername(username);
		if (loggedUser != null) {
			query.setUser(loggedUser);
			this.updateQuery(query);
		}

	}
}
