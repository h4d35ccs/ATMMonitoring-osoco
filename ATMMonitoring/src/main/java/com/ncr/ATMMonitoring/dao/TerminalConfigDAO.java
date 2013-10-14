package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalConfigDAO {

    public void addTerminalConfig(TerminalConfig terminalConfig);

    public List<TerminalConfig> listTerminalConfig();

    public TerminalConfig getTerminalConfig(Integer id);
}
