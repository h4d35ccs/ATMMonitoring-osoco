package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Query;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface QueryDAO {

    public void addQuery(Query query);

    public void deleteQuery(Query query);

    public List<Query> listQueries();

    public Query getQuery(Integer id);

    public void updateQuery(Query query);
}
