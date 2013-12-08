package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

// TODO: Auto-generated Javadoc
/**
 * The Interface TerminalConfigDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalConfigDAO {

    /**
     * Adds the terminal config.
     *
     * @param terminalConfig the terminal config
     */
    public void addTerminalConfig(TerminalConfig terminalConfig);

    /**
     * List terminal config.
     *
     * @return the list
     */
    public List<TerminalConfig> listTerminalConfig();

    /**
     * Gets the terminal config.
     *
     * @param id the id
     * @return the terminal config
     */
    public TerminalConfig getTerminalConfig(Integer id);
}
