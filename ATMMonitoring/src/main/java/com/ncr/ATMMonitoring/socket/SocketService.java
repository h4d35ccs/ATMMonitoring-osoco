package com.ncr.ATMMonitoring.socket;

import java.util.Collection;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * The Interface SocketService.
 * 
 * This service contains the methods used for requesting the terminals' data
 * through the agent.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SocketService {

    /**
     * Insert all terminals' ip's into the waiting ones list.
     */
    public void updateAllTerminalsSocket();

    /**
     * Insert a terminal's ip into the waiting ones list.
     * 
     * @param terminal
     *            the terminal whose ip we want to request
     */
    public void updateTerminalSocket(Terminal terminal);

    /**
     * Insert an ip into the waiting ones list.
     * 
     * @param ip
     *            the ip to insert
     */
    public void updateTerminalSocket(String ip);

    /**
     * Insert a series of ip's into the waiting ones list.
     * 
     * @param ips
     *            the ips to insert
     */
    public void updateTerminalsSocket(Collection<String> ips);

    /**
     * Execute a query and insert the resulting terminals' ip's into the waiting
     * ones list.
     * 
     * @param query
     *            the query to execute
     */
    public void updateTerminalsSocket(Query query);

    /**
     * Process ips waiting to be requested their data.
     */
    public void processAwaitingIps();

    /**
     * Process terminal json.
     * 
     * @param json
     *            the json
     * @return the generated id of the resulting ATM, or null if there was an
     *         error
     */
    public Long processTerminalJson(String json);

    /**
     * Gets the configurable hash seed.
     * 
     * @return the configurable hash seed
     */
    public String getHashSeed();

    /**
     * Gets the old configurable hash seed.
     * 
     * @return the old configurable hash seed
     */
    public String getOldHashSeed();
}