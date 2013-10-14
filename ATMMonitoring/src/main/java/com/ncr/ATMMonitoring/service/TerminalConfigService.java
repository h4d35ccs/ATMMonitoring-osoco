package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalConfigService {

    public void addTerminalConfig(TerminalConfig terminalConfig);

    public TerminalConfig getTerminalConfig(Integer id);

    public List<TerminalConfig> listTerminalConfig();
}