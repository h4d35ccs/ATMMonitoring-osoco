package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class JxfsComponentDAOImpl implements JxfsComponentDAO {

    static private Logger logger = Logger.getLogger(JxfsComponentDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addJxfsComponent(JxfsComponent jxfsComponent) {
	sessionFactory.getCurrentSession().save(jxfsComponent);
	logger.debug("Created new Jxfs Component with id "
		+ jxfsComponent.getId());
    }

    @Override
    public List<JxfsComponent> listJxfsComponents() {
	return sessionFactory.getCurrentSession()
		.createCriteria(JxfsComponent.class).list();
    }

    @Override
    public JxfsComponent getJxfsComponent(Integer id) {
	return (JxfsComponent) sessionFactory.getCurrentSession().get(
		JxfsComponent.class, id);
    }
}