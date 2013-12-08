package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Hotfix;

// TODO: Auto-generated Javadoc
/**
 * The Interface HotfixService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HotfixService {

    /**
     * Adds the hotfix.
     *
     * @param hotfix the hotfix
     */
    public void addHotfix(Hotfix hotfix);

    /**
     * Removes the hotfix.
     *
     * @param id the id
     */
    public void removeHotfix(Integer id);

    /**
     * Gets the hotfix.
     *
     * @param id the id
     * @return the hotfix
     */
    public Hotfix getHotfix(Integer id);

    /**
     * List hotfix.
     *
     * @return the list
     */
    public List<Hotfix> listHotfix();
}