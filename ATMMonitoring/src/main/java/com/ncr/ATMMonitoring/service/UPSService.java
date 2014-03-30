/**
 * 
 */
package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 * Interface that define the operations related to the UPS
 * 
 * @author Otto Abreu
 * 
 */

public interface UPSService {
    /**
     * Generates the XML files, extract the information and store it in the
     * database<br>
     * will return the list of not processed (parsed) files, empty if all was
     * processed
     * 
     * @param xmlFiles
     *            List<String> with valid file paths
     * @return List<String> with the not processed files
     */
    List<String> storeUPSinfo(List<String> xmlFiles);

    /**
     * Generates the XML file, extract the information and store it in the
     * database<br>
     * Return true if the file was processed by the parser
     * 
     * @param xmlFile
     *            InputStream with a valid XML file
     * @return boolean true if the file was parsed, false otherwise
     */
    boolean storeUPSinfo(InputStream xmlFile);

    /**
     * Generates the XML files, extract the information and store it in the
     * database will return the List of not processed (parsed) files, empty if
     * all was processed
     * 
     * @param xmlFiles
     *            Collection<InputStream> with valid inputstreams
     * @return List<InputStream> with the not processed files
     */
    List<InputStream> storeUPSinfo(Collection<InputStream> xmlFiles);

    /**
     * Generates the XML files, extract the information and store it in the
     * database<br>
     * Return true if the file was processed by the parser
     * 
     * @param xmlFiles
     *            String with a valid file path
     * @return boolean true if the file was parsed, false otherwise
     */
    boolean storeUPSinfo(String xmlFile);

    /**
     * Deletes the information related to an UPS
     * 
     * @param id
     */
    void deleteUPS(int id);

}
