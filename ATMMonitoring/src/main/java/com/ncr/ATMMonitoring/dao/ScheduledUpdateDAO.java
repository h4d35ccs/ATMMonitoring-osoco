package com.ncr.ATMMonitoring.dao;

import java.util.Calendar;
import java.util.List;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface ScheduledUpdateDAO {

    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate);

    public List<ScheduledUpdate> listMonthlyScheduledUpdates();

    public List<ScheduledUpdate> listWeeklyScheduledUpdates();

    public ScheduledUpdate getScheduledUpdate(Integer id);

    public void removeScheduledUpdate(Integer id);

    public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date);

    public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate);

    public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate);
}
