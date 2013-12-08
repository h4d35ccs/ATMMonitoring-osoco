package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

// TODO: Auto-generated Javadoc
/**
 * The Interface TerminalConfigService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalConfigService {

    /**
     * Adds the terminal config.
     *
     * @param terminalConfig the terminal config
     */
    public void addTerminalConfig(TerminalConfig terminalConfig);

    /**
     * Gets the terminal config.
     *
     * @param id the id
     * @return the terminal config
     */
    public TerminalConfig getTerminalConfig(Integer id);

    /**
     * List terminal config.
     *
     * @return the list
     */
    public List<TerminalConfig> listTerminalConfig();
}