package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalDAOImpl implements TerminalDAO {

    static private Logger logger = Logger.getLogger(TerminalDAOImpl.class
	    .getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTerminal(Terminal terminal) {
		sessionFactory.getCurrentSession().save(terminal);
		logger.info("Created new terminal with id " + terminal.getId() + " and IP " + terminal.getIp());
    }

    @Override
    public void updateTerminal(Terminal terminal) {
		sessionFactory.getCurrentSession().update(sessionFactory.getCurrentSession().merge(terminal));
		logger.info("Updated terminal with id " + terminal.getId() + " and IP " + terminal.getIp());
    }

    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks) {
		return listTerminalsByBankCompanies(banks, "serialNumber", "asc");
    }

    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String order, String sort) {
		Criterion restriction = (banks.size() > 0) ?
			Restrictions.or(
		        Restrictions.in("bankCompany", banks),
				Restrictions.isNull("bankCompany")) :
			Restrictions.isNull("bankCompany");

		Criteria criteria =
			sessionFactory.getCurrentSession().
			    createCriteria(Terminal.class).add(restriction);

		if ((order != null) && (sort != null)) {
			if ("asc".equals(sort)) {
				criteria.addOrder(Order.asc(order));
			} else {
				criteria.addOrder(Order.desc(order));
			}
		}
		return criteria.list();
    }

    @Override
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank) {
	return sessionFactory
		.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.or(Restrictions.eq("bankCompany", bank),
			Restrictions.isNull("bankCompany")))
		.addOrder(Order.asc("serialNumber")).list();
    }

    @Override
    public List<Terminal> listTerminals() {
    	return sessionFactory.getCurrentSession().createCriteria(Terminal.class).addOrder(Order.asc("serialNumber")).list();
    }

	@Override
    public List<Terminal> getTerminalsByHQL(List<Object> values,
											List<Type> types, String hql) {
		return getTerminalsByHQL(values, types, hql, null, null);
    }

	@Override
    public List<Terminal> getTerminalsByHQL(List<Object> values,
		    List<Type> types, String hql, String sort, String order) {
		if (sort != null) {
			hql += " order by terminal." + sort;
			if (order != null) {
				hql += " " + order;
			}
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameters(values.toArray(), types.toArray(new Type[0]));
		logger.debug("Executing the HQL sentence '" + hql
					 + "' with the values " + values + "and types " + types);
		try {
			return query.list();
		} catch (HibernateException e) {
			logger.error(
						 "There was an error while executing the HQL sentence '"
						 + hql + "' with the values " + values
						 + "and types " + types, e);
			throw e;
		}
    }

    @Override
    public List executeQuery(List<Object> values, List<Type> types, String hql) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameters(values.toArray(), types.toArray(new Type[0]));
		logger.debug("Executing the HQL sentence '" + hql
					 + "' with the values " + values + "and types " + types);
		try {
			return query.list();
		} catch (HibernateException e) {
			logger.error(
						 "There was an error while executing the HQL sentence '"
						 + hql + "' with the values " + values
						 + "and types " + types, e);
			throw e;
		}
    }

    @Override
    public Terminal getTerminal(Integer id) {
	return (Terminal) sessionFactory.getCurrentSession().get(
		Terminal.class, id);
    }

    @Override
    public Terminal getTerminalBySerialNumber(String serialNumber) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("serialNumber", serialNumber))
		.uniqueResult();
	return result;
    }

    @Override
    public Terminal getTerminalByIp(String ip) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class).add(Restrictions.eq("ip", ip))
		.uniqueResult();
	return result;
    }

    @Override
    public Terminal getTerminalByMac(String mac) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("mac", mac)).uniqueResult();
	return result;
    }
}
