package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.BankCompanyDAO;
import com.ncr.ATMMonitoring.pojo.BankCompany;

/**
 * The Class BankCompanyServiceImpl.
 * 
 * Default implementation of the BankCompanyService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class BankCompanyServiceImpl implements BankCompanyService {

    /** The bank dao. */
    @Autowired
    private BankCompanyDAO bankDAO;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.BankCompanyService#addBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public void addBankCompany(BankCompany bank) {
	bankDAO.addBankCompany(bank);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.BankCompanyService#getBankCompany(java.lang.Integer)
     */
    @Override
    public BankCompany getBankCompany(Integer id) {
	return bankDAO.getBankCompany(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.BankCompanyService#listBankCompanies()
     */
    @Override
    public List<BankCompany> listBankCompanies() {
	return bankDAO.listBankCompanies();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.BankCompanyService#removeBankCompany(java.lang.Integer)
     */
    @Override
    public void removeBankCompany(Integer id) {
	bankDAO.removeBankCompany(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.BankCompanyService#updateBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public void updateBankCompany(BankCompany bank) {
	bankDAO.updateBankCompany(bank);
    }
}