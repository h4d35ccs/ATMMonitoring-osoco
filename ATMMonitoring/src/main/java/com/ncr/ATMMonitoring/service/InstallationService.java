package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Installation;

// TODO: Auto-generated Javadoc
/**
 * The Interface InstallationService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InstallationService {

    /**
     * Adds the installation.
     *
     * @param installation the installation
     */
    public void addInstallation(Installation installation);

    /**
     * Gets the installation.
     *
     * @param id the id
     * @return the installation
     */
    public Installation getInstallation(Integer id);

    /**
     * List installations.
     *
     * @return the list
     */
    public List<Installation> listInstallations();

    /**
     * Update installation.
     *
     * @param installation the installation
     */
    public void updateInstallation(Installation installation);

    /**
     * Removes the installation.
     *
     * @param id the id
     */
    public void removeInstallation(Integer id);
}