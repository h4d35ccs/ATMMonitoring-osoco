package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalDAO {

    public void addTerminal(Terminal terminal);

    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank);

    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank, String sort, String order);

    public List<Terminal> listTerminalsByBankCompany(BankCompany bank);

    public List<Terminal> listTerminals();

    public Terminal getTerminal(Integer id);

    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql);

    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql, String sort, String order);

    public List executeQuery(List<Object> values,
											List<Type> types, String hql);

    public void updateTerminal(Terminal terminal);

    public Terminal getTerminalBySerialNumber(String serialNumber);

    public Terminal getTerminalByIp(String ip);

    public Terminal getTerminalByMac(String mac);

    public Terminal getTerminalByMatricula(String matricula);
}
