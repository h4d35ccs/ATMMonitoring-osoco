package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.agent.baseData.ATMDataStorePojo;

// TODO: Auto-generated Javadoc
/**
 * The Interface TerminalDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalDAO {

    /**
     * Adds the terminal.
     *
     * @param terminal the terminal
     */
    public void addTerminal(Terminal terminal);

    /**
     * List terminals by bank companies.
     *
     * @param bank the bank
     * @return the list
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank);

    /**
     * List terminals by bank companies.
     *
     * @param bank the bank
     * @param sort the sort
     * @param order the order
     * @return the list
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank, String sort, String order);

    /**
     * List terminals by bank company.
     *
     * @param bank the bank
     * @return the list
     */
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank);

    /**
     * List terminals.
     *
     * @return the list
     */
    public List<Terminal> listTerminals();

    /**
     * Gets the terminal.
     *
     * @param id the id
     * @return the terminal
     */
    public Terminal getTerminal(Integer id);

    /**
     * Gets the terminals by hql.
     *
     * @param values the values
     * @param types the types
     * @param hql the hql
     * @return the terminals by hql
     */
    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql);

    /**
     * Gets the terminals by hql.
     *
     * @param values the values
     * @param types the types
     * @param hql the hql
     * @param sort the sort
     * @param order the order
     * @return the terminals by hql
     */
    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql, String sort, String order);

    /**
     * Execute query.
     *
     * @param values the values
     * @param types the types
     * @param hql the hql
     * @return the list
     */
    public List executeQuery(List<Object> values, List<Type> types, String hql);

    /**
     * Update terminal.
     *
     * @param terminal the terminal
     */
    public void updateTerminal(Terminal terminal);

    /**
     * Gets the terminal by serial number.
     *
     * @param serialNumber the serial number
     * @return the terminal by serial number
     */
    public Terminal getTerminalBySerialNumber(String serialNumber);

    /**
     * Gets the terminal by ip.
     *
     * @param ip the ip
     * @return the terminal by ip
     */
    public Terminal getTerminalByIp(String ip);

    /**
     * Gets the terminal by mac.
     *
     * @param mac the mac
     * @return the terminal by mac
     */
    public Terminal getTerminalByMac(String mac);

    /**
     * Gets the terminal by matricula.
     *
     * @param matricula the matricula
     * @return the terminal by matricula
     */
    public Terminal getTerminalByMatricula(Long matricula);

    /**
     * Gets the terminal by similarity.
     *
     * @param terminal the terminal
     * @return the terminal by similarity
     */
    public Terminal getTerminalBySimilarity(ATMDataStorePojo terminal);
}
