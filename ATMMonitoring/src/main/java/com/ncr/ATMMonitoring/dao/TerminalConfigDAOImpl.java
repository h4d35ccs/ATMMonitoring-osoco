package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class TerminalConfigDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalConfigDAOImpl implements TerminalConfigDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalConfigDAOImpl.class.getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalConfigDAO#addTerminalConfig(com.ncr.ATMMonitoring.pojo.TerminalConfig)
     */
    @Override
    public void addTerminalConfig(TerminalConfig terminalConfig) {
		sessionFactory.getCurrentSession().save(terminalConfig);
		logger.debug("Created new Terminal Config with id " + terminalConfig.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalConfigDAO#listTerminalConfig()
     */
    @Override
    public List<TerminalConfig> listTerminalConfig() {
		return sessionFactory.getCurrentSession().createCriteria(TerminalConfig.class).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalConfigDAO#getTerminalConfig(java.lang.Integer)
     */
    @Override
    public TerminalConfig getTerminalConfig(Integer id) {
		return (TerminalConfig) sessionFactory.getCurrentSession().get(TerminalConfig.class, id);
    }
}