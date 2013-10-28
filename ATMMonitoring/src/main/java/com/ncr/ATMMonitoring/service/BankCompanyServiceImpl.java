package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.BankCompanyDAO;
import com.ncr.ATMMonitoring.pojo.BankCompany;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class BankCompanyServiceImpl implements BankCompanyService {

    @Autowired
    private BankCompanyDAO bankDAO;

    @Override
    public void addBankCompany(BankCompany bank) {
	bankDAO.addBankCompany(bank);
    }

    @Override
    public BankCompany getBankCompany(Integer id) {
	return bankDAO.getBankCompany(id);
    }

    @Override
    public List<BankCompany> listBankCompanies() {
	return bankDAO.listBankCompanies();
    }

    @Override
    public void removeBankCompany(Integer id) {
	bankDAO.removeBankCompany(id);
    }

    @Override
    public void updateBankCompany(BankCompany bank) {
	bankDAO.updateBankCompany(bank);
    }
}