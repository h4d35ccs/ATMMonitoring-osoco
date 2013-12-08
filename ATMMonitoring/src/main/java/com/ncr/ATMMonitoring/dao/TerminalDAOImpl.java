package com.ncr.ATMMonitoring.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.Vector;

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
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.agent.baseData.os.module.BaseBoardPojo;

// TODO: Auto-generated Javadoc
/**
 * The Class TerminalDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalDAOImpl implements TerminalDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalDAOImpl.class
	    .getName());

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#addTerminal(com.ncr.ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void addTerminal(Terminal terminal) {
	if (terminal.getMatricula() == null) {
	    terminal.setMatricula(getNextMatricula());
	    sessionFactory.getCurrentSession().save(terminal);
	    logger.info("Created new terminal with id " + terminal.getId()
		    + ", IP " + terminal.getIp() + " and NEW matricula "
		    + terminal.getMatricula());
	} else {
	    sessionFactory.getCurrentSession().save(terminal);
	    logger.info("Created new terminal with id " + terminal.getId()
		    + ", IP " + terminal.getIp() + " and matricula "
		    + terminal.getMatricula());
	}
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#updateTerminal(com.ncr.ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void updateTerminal(Terminal terminal) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(terminal));
	logger.info("Updated terminal with id " + terminal.getId() + ", IP "
		+ terminal.getIp() + " and matricula "
		+ terminal.getMatricula());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminalsByBankCompanies(java.util.Set)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks) {
	return listTerminalsByBankCompanies(banks, "serialNumber", "asc");
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminalsByBankCompanies(java.util.Set, java.lang.String, java.lang.String)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks,
	    String order, String sort) {
	Criterion restriction = (banks.size() > 0) ? Restrictions.or(
		Restrictions.in("bankCompany", banks),
		Restrictions.isNull("bankCompany")) : Restrictions
		.isNull("bankCompany");

	Criteria criteria = sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class).add(restriction);

	if ((order != null) && (sort != null)) {
	    if ("asc".equals(sort)) {
		criteria.addOrder(Order.asc(order));
	    } else {
		criteria.addOrder(Order.desc(order));
	    }
	}
	return criteria.list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminalsByBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank) {
	return sessionFactory
		.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.or(Restrictions.eq("bankCompany", bank),
			Restrictions.isNull("bankCompany")))
		.addOrder(Order.asc("serialNumber")).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminals()
     */
    @Override
    public List<Terminal> listTerminals() {
	return sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.addOrder(Order.asc("serialNumber")).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalsByHQL(java.util.List, java.util.List, java.lang.String)
     */
    @Override
    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql) {
	return getTerminalsByHQL(values, types, hql, null, null);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalsByHQL(java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.String)
     */
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

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#executeQuery(java.util.List, java.util.List, java.lang.String)
     */
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

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminal(java.lang.Integer)
     */
    @Override
    public Terminal getTerminal(Integer id) {
	return (Terminal) sessionFactory.getCurrentSession().get(
		Terminal.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalBySerialNumber(java.lang.String)
     */
    @Override
    public Terminal getTerminalBySerialNumber(String serialNumber) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("serialNumber", serialNumber))
		.setMaxResults(1).uniqueResult();
	return result;
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalByIp(java.lang.String)
     */
    @Override
    public Terminal getTerminalByIp(String ip) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class).add(Restrictions.eq("ip", ip))
		.setMaxResults(1).uniqueResult();
	return result;
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalByMac(java.lang.String)
     */
    @Override
    public Terminal getTerminalByMac(String mac) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("mac", mac)).setMaxResults(1)
		.uniqueResult();
	return result;
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalByMatricula(java.lang.Long)
     */
    @Override
    public Terminal getTerminalByMatricula(Long matricula) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("matricula", matricula)).setMaxResults(1)
		.uniqueResult();
	return result;
    }

    /**
     * Gets the next matricula.
     *
     * @return the next matricula
     */
    private Long getNextMatricula() {
	BigInteger seq = (BigInteger) sessionFactory.getCurrentSession()
		.createSQLQuery("select nextval('terminals_matricula_seq')")
		.uniqueResult();
	return seq.longValue();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalBySimilarity(com.ncr.agent.baseData.ATMDataStorePojo)
     */
    @Override
    public Terminal getTerminalBySimilarity(ATMDataStorePojo terminal) {
	Vector baseBoards = terminal.getvBaseBoard();
	String serialNumber = (baseBoards.size() > 0) ? ((BaseBoardPojo) baseBoards
		.get(0)).getSerialNumber() : null;
	logger.debug("SERIAL: " + serialNumber);
	Terminal result = (Terminal) sessionFactory
		.getCurrentSession()
		.createCriteria(Terminal.class)
		.createAlias("hardwareDevices", "hw")
		.add(Restrictions.or(
			Restrictions.and(Restrictions.eq("ip",
					terminal.getCurrentip()),
					Restrictions.eq("mac",
						terminal.getCurrentmac()),
					Restrictions.isNotNull("mac"),
				Restrictions.isNotNull("ip"), Restrictions.ne(
					"mac", ""), Restrictions.ne("ip", "")),
			Restrictions.and(
				Restrictions.eq("ip", terminal.getCurrentip()),
				Restrictions
					.eq("hw.serialNumber", serialNumber),
				Restrictions
					.eq("hw.hardwareClass",
						HardwareDevice
							.getDeviceclasses()
							.get(HardwareDevice.DeviceClassId.BASE_BOARD)),
				Restrictions.isNotNull("hw.serialNumber"),
				Restrictions.isNotNull("ip"), Restrictions.ne(
					"hw.serialNumber", ""), Restrictions
					.ne("ip", "")),
			Restrictions.and(
				Restrictions
					.eq("mac", terminal.getCurrentmac()),
				Restrictions
					.eq("hw.serialNumber", serialNumber),
				Restrictions
					.eq("hw.hardwareClass",
						HardwareDevice
							.getDeviceclasses()
							.get(HardwareDevice.DeviceClassId.BASE_BOARD)),
				Restrictions.isNotNull("hw.serialNumber"),
				Restrictions.isNotNull("mac"), Restrictions.ne(
					"hw.serialNumber", ""), Restrictions
					.ne("mac", ""))))
		.setMaxResults(1).uniqueResult();
	return result;
    }
}
