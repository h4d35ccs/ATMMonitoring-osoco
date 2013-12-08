package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.TerminalModel;

// TODO: Auto-generated Javadoc
/**
 * The Class TerminalModelDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalModelDAOImpl implements TerminalModelDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalModelDAOImpl.class
	    .getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#addTerminalModel(com.ncr.ATMMonitoring.pojo.TerminalModel)
     */
    @Override
    public void addTerminalModel(TerminalModel terminalModel) {
	sessionFactory.getCurrentSession().save(terminalModel);
	logger.debug("Created new Terminal Model with id "
		+ terminalModel.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#getTerminalModel(java.lang.Integer)
     */
    @Override
    public TerminalModel getTerminalModel(Integer id) {
	return (TerminalModel) sessionFactory.getCurrentSession().get(
		TerminalModel.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#listTerminalModels()
     */
    @Override
    public List<TerminalModel> listTerminalModels() {
	return sessionFactory.getCurrentSession()
		.createCriteria(TerminalModel.class).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#updateTerminalModel(com.ncr.ATMMonitoring.pojo.TerminalModel)
     */
    @Override
    public void updateTerminalModel(TerminalModel terminalModel) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(terminalModel));
	logger.info("Updated Terminal Model with id " + terminalModel.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#removeTerminalModel(java.lang.Integer)
     */
    @Override
    public void removeTerminalModel(Integer id) {
	TerminalModel terminalModel = (TerminalModel) sessionFactory
		.getCurrentSession().load(TerminalModel.class, id);
	if (null != terminalModel) {
	    sessionFactory.getCurrentSession().delete(terminalModel);
	}

    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#getTerminalModelByModel(java.lang.String)
     */
    @Override
    public TerminalModel getTerminalModelByModel(String model) {
	return (TerminalModel) sessionFactory.getCurrentSession()
		.createCriteria(TerminalModel.class)
		.add(Restrictions.eq("model", model)).uniqueResult();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#getTerminalModelByProductClass(java.lang.String)
     */
    @Override
    public TerminalModel getTerminalModelByProductClass(String productClass) {
	return (TerminalModel) sessionFactory.getCurrentSession()
		.createCriteria(TerminalModel.class)
		.add(Restrictions.eq("productClass", productClass))
		.uniqueResult();
    }
}