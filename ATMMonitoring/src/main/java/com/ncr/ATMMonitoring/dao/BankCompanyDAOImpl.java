package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;

// TODO: Auto-generated Javadoc
/**
 * The Class BankCompanyDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class BankCompanyDAOImpl implements BankCompanyDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(BankCompanyDAOImpl.class
	    .getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.BankCompanyDAO#addBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public void addBankCompany(BankCompany bank) {
	sessionFactory.getCurrentSession().save(bank);
	logger.debug("Created new Bank Company with id " + bank.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.BankCompanyDAO#getBankCompany(java.lang.Integer)
     */
    @Override
    public BankCompany getBankCompany(Integer id) {
	return (BankCompany) sessionFactory.getCurrentSession().get(
		BankCompany.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.BankCompanyDAO#listBankCompanies()
     */
    @Override
    public List<BankCompany> listBankCompanies() {
	return sessionFactory.getCurrentSession()
		.createCriteria(BankCompany.class).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.BankCompanyDAO#updateBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public void updateBankCompany(BankCompany bankCompany) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(bankCompany));
	logger.info("Updated Bank Company with id " + bankCompany.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.BankCompanyDAO#removeBankCompany(java.lang.Integer)
     */
    @Override
    public void removeBankCompany(Integer id) {
	BankCompany bank = (BankCompany) sessionFactory.getCurrentSession()
		.load(BankCompany.class, id);
	if (null != bank) {
	    sessionFactory.getCurrentSession().delete(bank);
	}

    }
}