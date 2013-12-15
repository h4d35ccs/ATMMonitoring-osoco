package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Hotfix;

// TODO: Auto-generated Javadoc
/**
 * The Interface HotfixDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HotfixDAO {

    /**
     * Adds the hotfix.
     *
     * @param hotfix the hotfix
     */
    public void addHotfix(Hotfix hotfix);

    /**
     * List hotfix.
     *
     * @return the list
     */
    public List<Hotfix> listHotfix();

    /**
     * Gets the hotfix.
     *
     * @param id the id
     * @return the hotfix
     */
    public Hotfix getHotfix(Integer id);

    /**
     * Removes the hotfix.
     *
     * @param id the id
     */
    public void removeHotfix(Integer id);
}
