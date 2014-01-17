package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.agent.baseData.ATMDataStorePojo;

/**
 * The Interface TerminalService.
 * 
 * It contains the terminal related methods.
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
     * Gets the terminal by its id.
     * 
     * @param id
     *            the terminal id
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
     * @param bank
     *            the bank company
     * @return the terminal list
     */
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank);

    /**
     * List terminals by bank companies.
     * 
     * @param banks
     *            the bank companies
     * @return the terminal list
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks);
    
    /**
     * List terminals by bank companies.
     * 
     * @param banks
     *            the bank companies
     * @param sort
     *            the fields for sorting terminals
     * @param order
     *            the order for sorting terminals
     * @return the terminal list
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String sort, String order);

    /**
     * List terminals.
     * 
     * @return the terminal list
     */
    public List<Terminal> listTerminals();

    /**
     * Get terminal by serial number.
     * 
     * @param serialNumber
     *            the serial number
     * @return the terminal
     */
    public Terminal loadTerminalBySerialNumber(String serialNumber);

    /**
     * Get terminal by ip.
     * 
     * @param ip
     *            the ip
     * @return the terminal
     */
    public Terminal loadTerminalByIp(String ip);

    /**
     * Get terminal by mac.
     * 
     * @param mac
     *            the mac
     * @return the terminal
     */
    public Terminal loadTerminalByMac(String mac);

    /**
     * Get terminal by matricula.
     * 
     * @param matricula
     *            the matricula
     * @return the terminal
     */
    public Terminal loadTerminalByMatricula(Long matricula);

    /**
     * Import terminal from json.
     * 
     * @param jsonFile
     *            the json file
     * @return true, if successful
     */
    public boolean importJsonTerminal(CommonsMultipartFile jsonFile);

    /**
     * Persist data store terminal from an agent's pojo.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the terminal
     */
    public Terminal persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal);

	public void addInstallationAndUpdateHistoricalData(Terminal terminal, Installation installation);

	public List<Terminal> listTerminalsByIdsAndBankCompanies(List<Integer> terminalIds, Set<BankCompany> bankCompanies);
	
}