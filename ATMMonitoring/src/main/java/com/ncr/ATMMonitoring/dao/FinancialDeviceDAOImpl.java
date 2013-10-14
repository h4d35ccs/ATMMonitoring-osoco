package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class FinancialDeviceDAOImpl implements FinancialDeviceDAO {

    static private Logger logger = Logger.getLogger(FinancialDeviceDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addFinancialDevice(FinancialDevice financialDevice) {
		sessionFactory.getCurrentSession().save(financialDevice);
		logger.debug("Created new Financial Device with id "+ financialDevice.getId());
    }

    @Override
    public List<FinancialDevice> listFinancialDevices() {
		return sessionFactory.getCurrentSession().createCriteria(FinancialDevice.class).list();
    }

    @Override
    public FinancialDevice getFinancialDevice(Integer id) {
		return (FinancialDevice) sessionFactory.getCurrentSession().get(FinancialDevice.class, id);
    }

    @Override
    public void removeFinancialDevice(Integer id) {
		FinancialDevice financialDevice = (FinancialDevice) sessionFactory.getCurrentSession().load(FinancialDevice.class, id);
		if (financialDevice != null) {
		    sessionFactory.getCurrentSession().delete(financialDevice);
		}
    }
}