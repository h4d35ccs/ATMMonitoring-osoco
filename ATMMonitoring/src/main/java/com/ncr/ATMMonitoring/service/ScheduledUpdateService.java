package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;

// TODO: Auto-generated Javadoc
/**
 * The Interface ScheduledUpdateService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface ScheduledUpdateService {

    /**
     * Adds the scheduled update.
     *
     * @param scheduledUpdate the scheduled update
     */
    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate);

    /**
     * Removes the scheduled update.
     *
     * @param id the id
     */
    public void removeScheduledUpdate(Integer id);

    /**
     * List weekly scheduled updates.
     *
     * @return the list
     */
    public List<ScheduledUpdate> listWeeklyScheduledUpdates();

    /**
     * List monthly scheduled updates.
     *
     * @return the list
     */
    public List<ScheduledUpdate> listMonthlyScheduledUpdates();

    /**
     * Check current updates.
     */
    public void checkCurrentUpdates();

    /**
     * Exists scheduled update.
     *
     * @param scheduledUpdate the scheduled update
     * @return true, if successful
     */
    public boolean existsScheduledUpdate(ScheduledUpdate scheduledUpdate);
}