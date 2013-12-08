package com.ncr.ATMMonitoring.dao;

import java.util.Calendar;
import java.util.List;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;

// TODO: Auto-generated Javadoc
/**
 * The Interface ScheduledUpdateDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface ScheduledUpdateDAO {

    /**
     * Adds the scheduled update.
     *
     * @param scheduledUpdate the scheduled update
     */
    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate);

    /**
     * List monthly scheduled updates.
     *
     * @return the list
     */
    public List<ScheduledUpdate> listMonthlyScheduledUpdates();

    /**
     * List weekly scheduled updates.
     *
     * @return the list
     */
    public List<ScheduledUpdate> listWeeklyScheduledUpdates();

    /**
     * Gets the scheduled update.
     *
     * @param id the id
     * @return the scheduled update
     */
    public ScheduledUpdate getScheduledUpdate(Integer id);

    /**
     * Removes the scheduled update.
     *
     * @param id the id
     */
    public void removeScheduledUpdate(Integer id);

    /**
     * List valid scheduled updates.
     *
     * @param date the date
     * @return the list
     */
    public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date);

    /**
     * Exists monthly scheduled update.
     *
     * @param scheduledUpdate the scheduled update
     * @return true, if successful
     */
    public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate);

    /**
     * Exists weekly scheduled update.
     *
     * @param scheduledUpdate the scheduled update
     * @return true, if successful
     */
    public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate);
}
