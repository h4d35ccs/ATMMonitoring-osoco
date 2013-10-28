package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Map;
import java.util.Locale;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface QueryService {

    public void addQuery(Query query);

    public void deleteQuery(Query query);

    public Query getQuery(Integer id);

    public void updateQuery(Query query);

    public List<Terminal> executeQuery(Query query, Locale locale);

    public List<Terminal> executeQuery(Query query);

    public List<Query> listQueries();

	public Query findOrCreateQuery(Query query);

	public List executeQueryGroupingBy(Query query, String groupByEntity, String groupBy, Locale locale);

}
