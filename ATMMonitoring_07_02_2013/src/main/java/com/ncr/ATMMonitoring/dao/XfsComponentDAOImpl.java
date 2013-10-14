package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class XfsComponentDAOImpl implements XfsComponentDAO {

    static private Logger logger = Logger.getLogger(XfsComponentDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addXfsComponent(XfsComponent xfsComponent) {
	sessionFactory.getCurrentSession().save(xfsComponent);
	logger.debug("Created new Xfs Component with id "
		+ xfsComponent.getId());
    }

    @Override
    public List<XfsComponent> listXfsComponents() {
	return sessionFactory.getCurrentSession()
		.createCriteria(XfsComponent.class).list();
    }

    @Override
    public XfsComponent getXfsComponent(Integer id) {
	return (XfsComponent) sessionFactory.getCurrentSession().get(
		XfsComponent.class, id);
    }
}