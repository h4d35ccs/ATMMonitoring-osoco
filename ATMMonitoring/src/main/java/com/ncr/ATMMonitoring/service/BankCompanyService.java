package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.BankCompany;

// TODO: Auto-generated Javadoc
/**
 * The Interface BankCompanyService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface BankCompanyService {

    /**
     * Adds the bank company.
     *
     * @param bank the bank
     */
    public void addBankCompany(BankCompany bank);

    /**
     * Gets the bank company.
     *
     * @param id the id
     * @return the bank company
     */
    public BankCompany getBankCompany(Integer id);

    /**
     * List bank companies.
     *
     * @return the list
     */
    public List<BankCompany> listBankCompanies();

    /**
     * Update bank company.
     *
     * @param bank the bank
     */
    public void updateBankCompany(BankCompany bank);

    /**
     * Removes the bank company.
     *
     * @param id the id
     */
    public void removeBankCompany(Integer id);
}