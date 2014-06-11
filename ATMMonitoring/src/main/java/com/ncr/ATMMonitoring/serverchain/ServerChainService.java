/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain;

import java.util.Map;

/**
 * Service in charge of manage the Network Mapping for Serverchain
 * @author Otto Abreu
 *
 */
public interface ServerChainService {
    /**
     * Return the current network map in JSON Format
     * @return
     */
    String getNetworkJSON();
    
    /**
     * Edit the router table in a leaf node
     * @param addressee  url and port of the leaf node
     * @param routerTableValues map with values
     */
    void editRouterTable(String addressee, Map<String,String> routerTableValues);
    
    /**
     * Execute the network mapping 
     */
    void requestNetworkMapping();
 

}
