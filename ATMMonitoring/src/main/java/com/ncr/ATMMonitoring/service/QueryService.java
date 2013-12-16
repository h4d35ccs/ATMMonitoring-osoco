package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Map;
import java.util.Locale;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;

// TODO: Auto-generated Javadoc
/**
 * The Interface QueryService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface QueryService {

    /**
     * Adds the query.
     *
     * @param query the query
     */
    public void addQuery(Query query);

    /**
     * Delete query.
     *
     * @param query the query
     */
    public void deleteQuery(Query query);

    /**
     * Gets the query.
     *
     * @param id the id
     * @return the query
     */
    public Query getQuery(Integer id);

    /**
     * Update query.
     *
     * @param query the query
     */
    public void updateQuery(Query query);

    /**
     * Execute query.
     *
     * @param query the query
     * @param locale the locale
     * @param sort the sort
     * @param order the order
     * @return the list
     */
    public List<Terminal> executeQuery(Query query, Locale locale, String sort, String order);

    /**
     * Execute query.
     *
     * @param query the query
     * @param locale the locale
     * @return the list
     */
    public List<Terminal> executeQuery(Query query, Locale locale);

    /**
     * Execute query.
     *
     * @param query the query
     * @return the list
     */
    public List<Terminal> executeQuery(Query query);

    /**
     * List queries.
     *
     * @return the list
     */
    public List<Query> listQueries();

	/**
	 * Find or create query.
	 *
	 * @param query the query
	 * @return the query
	 */
	public Query findOrCreateQuery(Query query);

	/**
	 * Execute query grouping by.
	 *
	 * @param query the query
	 * @param groupByEntity the group by entity
	 * @param groupBy the group by
	 * @param locale the locale
	 * @return the list
	 */
	public List executeQueryGroupingBy(Query query, String groupByEntity, String groupBy, Locale locale);

}
