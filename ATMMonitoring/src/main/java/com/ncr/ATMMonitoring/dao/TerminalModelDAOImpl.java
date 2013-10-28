package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalModelDAOImpl implements TerminalModelDAO {

    static private Logger logger = Logger.getLogger(TerminalModelDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTerminalModel(TerminalModel terminalModel) {
	sessionFactory.getCurrentSession().save(terminalModel);
	logger.debug("Created new Terminal Model with id "
		+ terminalModel.getId());
    }

    @Override
    public TerminalModel getTerminalModel(Integer id) {
	return (TerminalModel) sessionFactory.getCurrentSession().get(
		TerminalModel.class, id);
    }

    @Override
    public List<TerminalModel> listTerminalModels() {
	return sessionFactory.getCurrentSession()
		.createCriteria(TerminalModel.class).list();
    }

    @Override
    public void updateTerminalModel(TerminalModel terminalModel) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(terminalModel));
	logger.info("Updated Terminal Model with id " + terminalModel.getId());
    }

    @Override
    public void removeTerminalModel(Integer id) {
	TerminalModel terminalModel = (TerminalModel) sessionFactory
		.getCurrentSession().load(TerminalModel.class, id);
	if (null != terminalModel) {
	    sessionFactory.getCurrentSession().delete(terminalModel);
	}

    }
}