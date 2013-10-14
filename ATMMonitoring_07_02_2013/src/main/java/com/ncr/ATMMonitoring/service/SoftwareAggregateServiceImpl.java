package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.SoftwareAggregateDAO;
import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("softwareAggregateService")
@Transactional
public class SoftwareAggregateServiceImpl implements SoftwareAggregateService {

    @Autowired
    private SoftwareAggregateDAO softwareAggregateDAO;

    @Override
    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate) {
    	softwareAggregateDAO.addSoftwareAggregate(softwareAggregate);
    }

    @Override
    public List<SoftwareAggregate> listSoftwareAggregate() {
    	return softwareAggregateDAO.listSoftwareAggregate();
    }

    @Override
    public SoftwareAggregate getSoftwareAggregate(Integer id) {
    	return softwareAggregateDAO.getSoftwareAggregate(id);
    }

    @Override
    public SoftwareAggregate getSoftwareAggregateByVersionName(Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name) {
    	return softwareAggregateDAO.getSoftwareAggregateByVersionName(majorVersion, minorVersion, buildVersion, revisionVersion,remainingVersion, name);
    }

    @Override
    public void removeSoftwareAggregate(Integer id) {
    	softwareAggregateDAO.removeSoftwareAggregate(id);
    }
}