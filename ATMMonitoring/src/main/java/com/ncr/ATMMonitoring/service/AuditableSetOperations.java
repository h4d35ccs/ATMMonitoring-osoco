package com.ncr.ATMMonitoring.service;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.Auditable;

/**
 * 
 * @author Julián Martín
 *
 */
public interface AuditableSetOperations {

	public  Map<Date, Integer> buildAuditableChangesForCollection(Set<? extends Auditable> auditableElements); 	

	public <T extends Auditable> T getCurrentAuditableElementByDate(Set <T> auditableElements, Date date);

	public <T extends Auditable> T getCurrentAuditable(Set <T> auditableElements);
	
	public <T extends Auditable> Set<T> getCreatedAuditableElementsByDate(Set<T> auditableElements, Date date); 

	public <T extends Auditable> Set<T> getActiveAuditableElementsByDate(Set<T> auditableElements, Date date);
	
	public <T extends Auditable> void setCurrentAuditableElement(Set<T> auditableElements, 
			T newauditableElement);
}
