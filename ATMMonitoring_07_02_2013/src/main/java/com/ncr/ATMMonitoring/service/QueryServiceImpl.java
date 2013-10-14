package com.ncr.ATMMonitoring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.QueryDAO;
import com.ncr.ATMMonitoring.dao.TerminalDAO;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("queryService")
@Transactional
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryDAO queryDAO;
    @Autowired
    private TerminalDAO terminalDAO;

    @Override
    public void addQuery(Query query) {
	queryDAO.addQuery(query);
    }

    @Override
    public void deleteQuery(Query query) {
	queryDAO.deleteQuery(query);
    }

    @Override
    public void updateQuery(Query query) {
	queryDAO.updateQuery(query);
    }

    @Override
    public List<Query> listQueries() {
	return queryDAO.listQueries();
    }

    @Override
    public Query getQuery(Integer id) {
	return queryDAO.getQuery(id);
    }

    @Override
    public List<Terminal> executeQuery(Query query, Locale locale) {
	List<Object> values = new ArrayList<Object>();
	List<Type> types = new ArrayList<Type>();
	String hql = query.getHQL(values, types, locale);
	if ((hql == null) || (hql.equals(""))) {
	    return null;
	}
	return terminalDAO.getTerminalsByHQL(values, types, hql);
    }
}