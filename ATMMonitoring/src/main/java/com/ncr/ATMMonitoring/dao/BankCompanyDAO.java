package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.BankCompany;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface BankCompanyDAO {

    public void addBankCompany(BankCompany bank);

    public BankCompany getBankCompany(Integer id);

    public List<BankCompany> listBankCompanies();

    public void updateBankCompany(BankCompany bank);

    public void removeBankCompany(Integer id);
}
