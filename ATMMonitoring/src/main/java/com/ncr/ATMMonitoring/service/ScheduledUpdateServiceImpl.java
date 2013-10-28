package com.ncr.ATMMonitoring.service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.ScheduledUpdateDAO;
import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.snmp.SnmpService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("scheduledUpdateService")
@Transactional
public class ScheduledUpdateServiceImpl implements ScheduledUpdateService {

    static private Logger logger = Logger
	    .getLogger(ScheduledUpdateServiceImpl.class.getName());

    @Autowired
    private ScheduledUpdateDAO scheduledUpdateDAO;
    @Autowired
    private SnmpService snmpService;
    @Autowired
    private QueryService queryService;

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
	logger.info("Checking scheduled updates...");
	Calendar currentDate = Calendar.getInstance();
	List<ScheduledUpdate> updates = scheduledUpdateDAO
		.listValidScheduledUpdates(currentDate);
	for (ScheduledUpdate update : updates) {
	    if (update.getQuery() == null) {
		logger.info("General update found for instant "
			+ DateFormat.getDateTimeInstance(DateFormat.SHORT,
				DateFormat.SHORT).format(currentDate.getTime()));
		snmpService.updateAllTerminalsSnmpAsync();
		return;
	    }
	}
	Set<String> ips = new HashSet<String>();
	for (ScheduledUpdate update : updates) {
	    List<Terminal> terminals = queryService.executeQuery(update
		    .getQuery());
	    for (Terminal terminal : terminals) {
		ips.add(terminal.getIp());
	    }
	}
	snmpService.updateTerminalsSnmp(ips);
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