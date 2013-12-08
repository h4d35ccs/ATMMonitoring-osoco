package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

// TODO: Auto-generated Javadoc
/**
 * The Class JxfsComponentDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class JxfsComponentDAOImpl implements JxfsComponentDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(JxfsComponentDAOImpl.class
	    .getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.JxfsComponentDAO#addJxfsComponent(com.ncr.ATMMonitoring.pojo.JxfsComponent)
     */
    @Override
    public void addJxfsComponent(JxfsComponent jxfsComponent) {
	sessionFactory.getCurrentSession().save(jxfsComponent);
	logger.debug("Created new Jxfs Component with id "
		+ jxfsComponent.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.JxfsComponentDAO#listJxfsComponents()
     */
    @Override
    public List<JxfsComponent> listJxfsComponents() {
	return sessionFactory.getCurrentSession()
		.createCriteria(JxfsComponent.class).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.JxfsComponentDAO#getJxfsComponent(java.lang.Integer)
     */
    @Override
    public JxfsComponent getJxfsComponent(Integer id) {
	return (JxfsComponent) sessionFactory.getCurrentSession().get(
		JxfsComponent.class, id);
    }
}