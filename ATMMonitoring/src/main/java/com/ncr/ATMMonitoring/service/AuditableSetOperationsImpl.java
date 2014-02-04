package com.ncr.ATMMonitoring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.pojo.Auditable;

public class AuditableSetOperationsImpl implements AuditableSetOperations {

	/**
	 * @see AuditableSetOperations
	 */
	public Map<Date, Integer> buildAuditableChangesForCollection(Set<? extends Auditable> auditableElements) {

		Map<Date, Integer> auditableElementsDates = new HashMap<Date, Integer>();

		for(Auditable auditableElement : auditableElements) {
			Date startDate = auditableElement.getStartDate();
			Date endDate = auditableElement.getEndDate();

			List<Date> targetDates = Arrays.asList(new Date[]{startDate, endDate});
			
			for(Date targetDate : targetDates ) {
				if(targetDate != null) {
					Integer numberOfChanges = auditableElementsDates.get(targetDate);
					int nextNumberOfChanges = numberOfChanges == null ? 1 : ++numberOfChanges;
					auditableElementsDates.put(targetDate, nextNumberOfChanges);
				}
			}
		}

		return auditableElementsDates;
	}
	
	/**
	 * @see AuditableSetOperations
	 */
	public <T extends Auditable> T getCurrentAuditableElementByDate( Set <T> auditableElements, 
			Date date) {

		Set<T> auditableElementsByDate = getCreatedAuditableElementsByDate(auditableElements, date);

		for (T auditableElement : auditableElementsByDate) {
			if(auditableElement.isActive(date)) {
				return auditableElement;
			}
		}
		return null;
	}

	/**
	 * @see AuditableSetOperations
	 */
	public <T extends Auditable> T getCurrentAuditable(Set <T> auditableElements) {
		return getCurrentAuditableElementByDate(auditableElements, null);
	}

	/**
	 * @see AuditableSetOperations
	 */
	public <T extends Auditable> void setCurrentAuditableElement( Set<T> auditableElements,
				T newauditableElement) {

		T oldauditableElement = getCurrentAuditable(auditableElements);
		if (oldauditableElement != null) {
			oldauditableElement.setEndDate(newauditableElement.getStartDate());
		}
		auditableElements.add(newauditableElement);
	}

	/**
	 * @see AuditableSetOperations
	 */
	public <T extends Auditable> Set<T> getCreatedAuditableElementsByDate(Set<T> auditableElements, Date date) {

		Set<T> auditableElementsByDate = new HashSet<T>();
		for(T auditableElement  : auditableElements) {
			if(auditableElement.exists(date)) {
				auditableElementsByDate.add(auditableElement);
			}
		}
		return auditableElementsByDate;
	}

	/**
	 * @see AuditableSetOperations
	 */
	public <T extends Auditable> Set<T> getActiveAuditableElementsByDate(Set<T> auditableElements, Date date) {

		Set<T> auditableElementsByDate = new HashSet<T>();
		for(T auditableElement  : auditableElements) {
			if(auditableElement.isActive(date)) {
				auditableElementsByDate.add(auditableElement);
			}
		}
		return auditableElementsByDate;
	}
	
}
