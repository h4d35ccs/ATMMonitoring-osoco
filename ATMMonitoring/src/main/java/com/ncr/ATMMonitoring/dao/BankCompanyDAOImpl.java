package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class BankCompanyDAOImpl implements BankCompanyDAO {

    static private Logger logger = Logger.getLogger(BankCompanyDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBankCompany(BankCompany bank) {
	sessionFactory.getCurrentSession().save(bank);
	logger.debug("Created new Bank Company with id " + bank.getId());
    }

    @Override
    public BankCompany getBankCompany(Integer id) {
	return (BankCompany) sessionFactory.getCurrentSession().get(
		BankCompany.class, id);
    }

    @Override
    public List<BankCompany> listBankCompanies() {
	return sessionFactory.getCurrentSession()
		.createCriteria(BankCompany.class).list();
    }

    @Override
    public void updateBankCompany(BankCompany bankCompany) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(bankCompany));
	logger.info("Updated Bank Company with id " + bankCompany.getId());
    }

    @Override
    public void removeBankCompany(Integer id) {
	BankCompany bank = (BankCompany) sessionFactory.getCurrentSession()
		.load(BankCompany.class, id);
	if (null != bank) {
	    sessionFactory.getCurrentSession().delete(bank);
	}

    }
}