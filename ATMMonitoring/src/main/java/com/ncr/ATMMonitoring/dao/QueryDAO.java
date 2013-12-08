package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Query;

// TODO: Auto-generated Javadoc
/**
 * The Interface QueryDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface QueryDAO {

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
     * List queries.
     *
     * @return the list
     */
    public List<Query> listQueries();

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
}
