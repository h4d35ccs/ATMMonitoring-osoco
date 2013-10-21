package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "scheduled_updates", uniqueConstraints = {
	@UniqueConstraint(columnNames = { "month_day", "hours", "minutes" }),
	@UniqueConstraint(columnNames = { "week_day", "hours", "minutes" }) })
public class ScheduledUpdate {

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
}