package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 * The Interface UpsService.
 * 
 * It contains the UPS related methods.
 * 
 * @author Otto Abreu
 * 
 */

public interface UpsService {

    /**
     * Generates the XML files, extracts the information and stores it in the
     * database. It will return the list of not processed (parsed) files, empty
     * if all were processed
     * 
     * @param xmlFiles
     *            List<String> with valid file paths
     * @return List<String> with the not processed files
     */
    public List<String> storeUPSinfo(List<String> xmlFiles);

    /**
     * Generates the XML file, extracts the information and stores it in the
     * database. Return true if the file was processed by the parser
     * 
     * @param xmlFile
     *            InputStream with a valid XML file
     * @return true if the file was parsed, false otherwise
     */
    public boolean storeUPSinfo(InputStream xmlFile);

    /**
     * Generates the XML files, extracts the information and stores it in the
     * database. It will return the List of not processed (parsed) files, empty
     * if all were processed.
     * 
     * @param xmlFiles
     *            Collection<InputStream> with valid inputstreams
     * @return List<InputStream> with the not processed files
     */
    public List<InputStream> storeUPSinfo(Collection<InputStream> xmlFiles);

    /**
     * Generates the XML files, extract the information and store it in the
     * database. Returns true if the file was processed by the parser
     * 
     * @param xmlFiles
     *            String with a valid file path
     * @return true if the file was parsed, false otherwise
     */
    public boolean storeUPSinfo(String xmlFile);

    /**
     * Deletes the information related to an UPS
     * 
     * @param id
     *            the id of the UPS we want to delete
     */
    public void deleteUPS(int id);

}
