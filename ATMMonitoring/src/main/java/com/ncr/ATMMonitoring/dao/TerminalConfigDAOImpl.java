package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalConfigDAOImpl implements TerminalConfigDAO {

    static private Logger logger = Logger.getLogger(TerminalConfigDAOImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTerminalConfig(TerminalConfig terminalConfig) {
		sessionFactory.getCurrentSession().save(terminalConfig);
		logger.debug("Created new Terminal Config with id " + terminalConfig.getId());
    }

    @Override
    public List<TerminalConfig> listTerminalConfig() {
		return sessionFactory.getCurrentSession().createCriteria(TerminalConfig.class).list();
    }

    @Override
    public TerminalConfig getTerminalConfig(Integer id) {
		return (TerminalConfig) sessionFactory.getCurrentSession().get(TerminalConfig.class, id);
    }
}