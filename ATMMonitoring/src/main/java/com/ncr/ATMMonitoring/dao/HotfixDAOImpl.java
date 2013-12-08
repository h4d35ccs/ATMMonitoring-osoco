package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Hotfix;

// TODO: Auto-generated Javadoc
/**
 * The Class HotfixDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class HotfixDAOImpl implements HotfixDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(HotfixDAOImpl.class
	    .getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.HotfixDAO#addHotfix(com.ncr.ATMMonitoring.pojo.Hotfix)
     */
    @Override
    public void addHotfix(Hotfix hotfix) {
	sessionFactory.getCurrentSession().save(hotfix);
	logger.debug("Created new Hotfix with id " + hotfix.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.HotfixDAO#listHotfix()
     */
    @Override
    public List<Hotfix> listHotfix() {
	return sessionFactory.getCurrentSession().createCriteria(Hotfix.class)
		.addOrder(Order.asc("name"))
		.addOrder(Order.desc("major_version"))
		.addOrder(Order.desc("minor_version"))
		.addOrder(Order.desc("build_version"))
		.addOrder(Order.desc("revision_version"))
		.addOrder(Order.asc("remaining_version")).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.HotfixDAO#getHotfix(java.lang.Integer)
     */
    @Override
    public Hotfix getHotfix(Integer id) {
	return (Hotfix) sessionFactory.getCurrentSession()
		.get(Hotfix.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.HotfixDAO#removeHotfix(java.lang.Integer)
     */
    @Override
    public void removeHotfix(Integer id) {
	Hotfix hotfix = (Hotfix) sessionFactory.getCurrentSession().load(
		Hotfix.class, id);
	if (hotfix != null) {
	    sessionFactory.getCurrentSession().delete(hotfix);
	}
    }
}