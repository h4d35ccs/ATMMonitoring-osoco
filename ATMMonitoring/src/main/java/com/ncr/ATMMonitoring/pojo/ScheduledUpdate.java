package com.ncr.ATMMonitoring.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Formula;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "scheduled_updates", uniqueConstraints = {
	@UniqueConstraint(columnNames = { "month_day", "hours", "minutes" }),
	@UniqueConstraint(columnNames = { "week_day", "hours", "minutes" }) })
public class ScheduledUpdate {

    static private Logger logger = Logger.getLogger(ScheduledUpdate.class
	    .getName());

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheduled_updates_id_seq")
    @SequenceGenerator(name = "scheduled_updates_id_seq", sequenceName = "scheduled_updates_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "week_day")
    @Min(0)
    @Max(6)
    private Short weekDay = null;

    @Column(name = "month_day")
    @Min(1)
    @Max(31)
    private Short monthDay = null;

    @Column(name = "hours")
    @Min(0)
    @Max(23)
    private Short hour = 0;

    @Column(name = "minutes")
    @Min(0)
    @Max(59)
    private Short minute = 0;

    @Column(name = "time_zone")
    @Min(-12)
    @Max(12)
    private Short timeZone = new Double(
	    TimeZone.getDefault().getRawOffset() / (3600000)).shortValue();

    @Formula("hours - time_zone")
    private Short gmtHour;

    @ManyToOne
    @JoinColumn(name = "query_id")
    private Query query;

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the weekDay
     */
    public Short getWeekDay() {
	return weekDay;
    }

    /**
     * @param weekDay
     *            the weekDay to set
     */
    public void setWeekDay(Short weekDay) {
	this.weekDay = weekDay;
    }

    /**
     * @return the monthDay
     */
    public Short getMonthDay() {
	return monthDay;
    }

    /**
     * @param monthDay
     *            the monthDay to set
     */
    public void setMonthDay(Short monthDay) {
	this.monthDay = monthDay;
    }

    /**
     * @return the hour
     */
    public Short getHour() {
	return hour;
    }

    /**
     * @param hour
     *            the hour to set
     */
    public void setHour(Short hour) {
	this.hour = hour;
    }

    /**
     * @return the minute
     */
    public Short getMinute() {
	return minute;
    }

    /**
     * @param minute
     *            the minute to set
     */
    public void setMinute(Short minute) {
	this.minute = minute;
    }

    public Query getQuery() {
	return query;
    }

    public void setQuery(Query query) {
	this.query = query;
    }

    public boolean isWeekly() {
	return (monthDay == null);
    }

    public List<Date> getEventDates(long fromUnixTime, long toUnixTime) {
	List<Date> events = new ArrayList();
	Date fromDate = new Date(fromUnixTime * 1000L);
	Date toDate = new Date(toUnixTime * 1000L);
	logger.debug("fromDate: " + fromDate + ", toDate: " + toDate);
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(fromDate);
	calendar.set(Calendar.HOUR_OF_DAY, hour);
	calendar.set(Calendar.MINUTE, minute);

	if (isWeekly()) {
	    calendar.set(Calendar.DAY_OF_WEEK, weekDay);
	} else {
	    calendar.set(Calendar.DAY_OF_MONTH, monthDay);
	    Date event = calendar.getTime();
	    if (event.getTime() < fromDate.getTime()) {
		calendar.add(Calendar.MONTH, 1);
	    }
	}

	while (calendar.getTime().getTime() < toDate.getTime()) {
	    Date event = calendar.getTime();
	    events.add(event);
	    if (isWeekly()) {
		calendar.add(Calendar.DAY_OF_MONTH, 7);
	    } else {
		calendar.add(Calendar.MONTH, 1);
	    }
	}

	return events;
    }

    public String getCompleteHour() {
	String completeHour = "";
	if (hour < 10) {
	    completeHour += "0";
	}
	completeHour += hour.toString() + ":";
	if (minute < 10) {
	    completeHour += "0";
	}
	completeHour += minute.toString();
	return completeHour;
    }

    public Short getTimeZone() {
	return timeZone;
    }

    public String getTimeZoneName() {
	String name = "GMT ";
	if (timeZone > 0) {
	    name += "+";
	}
	return (name + timeZone);
    }

    public void setTimeZone(Short timeZone) {
	this.timeZone = timeZone;
    }

    public Short getGmtHour() {
	return gmtHour;
    }

    public void setGmtHour(Short gmtHour) {
	this.gmtHour = gmtHour;
    }
}