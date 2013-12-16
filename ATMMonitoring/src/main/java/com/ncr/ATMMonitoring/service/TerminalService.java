package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.agent.baseData.ATMDataStorePojo;

// TODO: Auto-generated Javadoc
/**
 * The Interface TerminalService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalService {

    /**
     * Adds the terminal.
     *
     * @param terminal the terminal
     */
    public void addTerminal(Terminal terminal);

    /**
     * Gets the terminal.
     *
     * @param id the id
     * @return the terminal
     */
    public Terminal getTerminal(Integer id);

    /**
     * Update terminal.
     *
     * @param terminal the terminal
     */
    public void updateTerminal(Terminal terminal);

    /**
     * List terminals by bank company.
     *
     * @param bank the bank
     * @return the list
     */
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank);

    /**
     * List terminals by bank companies.
     *
     * @param banks the banks
     * @return the list
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks);
    
    /**
     * List terminals by bank companies.
     *
     * @param banks the banks
     * @param sort the sort
     * @param order the order
     * @return the list
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String sort, String order);

    /**
     * List terminals.
     *
     * @return the list
     */
    public List<Terminal> listTerminals();

    /**
     * Load terminal by serial number.
     *
     * @param serialNumber the serial number
     * @return the terminal
     */
    public Terminal loadTerminalBySerialNumber(String serialNumber);

    /**
     * Load terminal by ip.
     *
     * @param ip the ip
     * @return the terminal
     */
    public Terminal loadTerminalByIp(String ip);

    /**
     * Load terminal by mac.
     *
     * @param mac the mac
     * @return the terminal
     */
    public Terminal loadTerminalByMac(String mac);

    /**
     * Load terminal by matricula.
     *
     * @param matricula the matricula
     * @return the terminal
     */
    public Terminal loadTerminalByMatricula(Long matricula);

    /**
     * Import json terminal.
     *
     * @param jsonFile the json file
     * @return true, if successful
     */
    public boolean importJsonTerminal(CommonsMultipartFile jsonFile);

    /**
     * Persist data store terminal.
     *
     * @param dataStoreTerminal the data store terminal
     * @return the terminal
     */
    public Terminal persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal);
}