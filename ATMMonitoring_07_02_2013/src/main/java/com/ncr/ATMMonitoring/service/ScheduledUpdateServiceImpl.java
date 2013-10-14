package com.ncr.ATMMonitoring.service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO;
import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;
import com.ncr.ATMMonitoring.snmp.SnmpService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class ScheduledUpdateServiceImpl implements ScheduledUpdateService {

    static private Logger logger = Logger
	    .getLogger(ScheduledUpdateServiceImpl.class.getName());

    @Autowired
    private ScheduledUpdateDAO scheduledUpdateDAO;
    @Autowired
    private SnmpService snmpService;

    @Override
    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	scheduledUpdateDAO.addScheduledUpdate(scheduledUpdate);
    }

    @Override
    public List<ScheduledUpdate> listWeeklyScheduledUpdates() {
	return scheduledUpdateDAO.listWeeklyScheduledUpdates();
    }

    @Override
    public List<ScheduledUpdate> listMonthlyScheduledUpdates() {
	return scheduledUpdateDAO.listMonthlyScheduledUpdates();
    }

    @Override
    public void removeScheduledUpdate(Integer id) {
	scheduledUpdateDAO.removeScheduledUpdate(id);
    }

    @Override
    @Scheduled(cron = "0 * * * * *")
    public void checkCurrentUpdates() {
	Calendar currentDate = Calendar.getInstance();
	if (scheduledUpdateDAO.existsMonthlyScheduledUpdate(currentDate)
		|| scheduledUpdateDAO.existsWeeklyScheduledUpdate(currentDate)) {
	    logger.info("Update found for instant "
		    + DateFormat.getDateTimeInstance(DateFormat.SHORT,
			    DateFormat.SHORT).format(currentDate.getTime()));
	    snmpService.updateAllTerminalsSnmpAsync();
	} else {
	    if (logger.isDebugEnabled()) {
		logger.debug("No update found for instant "
			+ DateFormat.getDateTimeInstance(DateFormat.SHORT,
				DateFormat.SHORT).format(currentDate.getTime()));
	    }
	}
    }

    @Override
    public boolean existsScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	if (scheduledUpdate.getMonthDay() != null) {
	    return scheduledUpdateDAO
		    .existsMonthlyScheduledUpdate(scheduledUpdate);
	}
	if (scheduledUpdate.getWeekDay() != null) {
	    return scheduledUpdateDAO
		    .existsWeeklyScheduledUpdate(scheduledUpdate);
	}
	return false;
    }
}