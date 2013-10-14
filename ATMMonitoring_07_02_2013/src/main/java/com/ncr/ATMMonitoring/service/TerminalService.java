package com.ncr.ATMMonitoring.service;

import java.util.List;

import ncr.inventory.data.ATM;

import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalService {

    public void addTerminal(Terminal terminal);

    public Terminal getTerminal(Integer id);

    public void updateTerminal(Terminal terminal);

    public List<Terminal> listTerminals();

    public Terminal loadTerminalBySerialNumber(String serialNumber);

    public Terminal loadTerminalByIp(String ip);

    public Terminal loadTerminalByMac(String mac);

    public void persistSnmpTerminal(ATM snmpTerminal);
}