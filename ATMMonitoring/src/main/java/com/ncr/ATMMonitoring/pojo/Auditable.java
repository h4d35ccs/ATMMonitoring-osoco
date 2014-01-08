package com.ncr.ATMMonitoring.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Auditable {

    @Column(name = "date_created")
    protected Date dateCreated = new Date();
    
    @Column(name = "start_date")
    protected Date startDate;

	@Column(name = "end_date")
	protected Date endDate;

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public boolean isActive(Date searchDate) {
		return (searchDate == null) ? isActiveNow() : isBetweenStartAndEndDate(searchDate);
	}
	
	public boolean isActiveNow() {
		return isBetweenStartAndEndDate(new Date());
	}

	public boolean exists(Date searchDate) {
		return (searchDate == null) ? true : isGreaterOrEqualsThanStartDate(searchDate);
	}
	
	private boolean isBetweenStartAndEndDate(Date searchDate) {
		return isGreaterOrEqualsThanStartDate(searchDate) && isLowerOrEqualsThanStartDate(searchDate);
	}
	
	private boolean isGreaterOrEqualsThanStartDate(Date searchDate) {
		return startDate == null || searchDate.compareTo(startDate) >= 0;
	}
	
	private boolean isLowerOrEqualsThanStartDate(Date searchDate) {
		return endDate == null || searchDate.compareTo(endDate) <= 0;
	}
}
