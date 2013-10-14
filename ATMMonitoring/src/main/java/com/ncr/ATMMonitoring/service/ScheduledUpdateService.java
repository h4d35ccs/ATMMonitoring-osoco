package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface ScheduledUpdateService {

    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate);

    public void removeScheduledUpdate(Integer id);

    public List<ScheduledUpdate> listWeeklyScheduledUpdates();

    public List<ScheduledUpdate> listMonthlyScheduledUpdates();

    public void checkCurrentUpdates();

    public boolean existsScheduledUpdate(ScheduledUpdate scheduledUpdate);
}