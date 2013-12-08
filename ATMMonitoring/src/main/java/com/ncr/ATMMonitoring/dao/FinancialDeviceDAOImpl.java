package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

// TODO: Auto-generated Javadoc
/**
 * The Class FinancialDeviceDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class FinancialDeviceDAOImpl implements FinancialDeviceDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(FinancialDeviceDAOImpl.class.getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#addFinancialDevice(com.ncr.ATMMonitoring.pojo.FinancialDevice)
     */
    @Override
    public void addFinancialDevice(FinancialDevice financialDevice) {
		sessionFactory.getCurrentSession().save(financialDevice);
		logger.debug("Created new Financial Device with id "+ financialDevice.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#listFinancialDevices()
     */
    @Override
    public List<FinancialDevice> listFinancialDevices() {
		return sessionFactory.getCurrentSession().createCriteria(FinancialDevice.class).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#getFinancialDevice(java.lang.Integer)
     */
    @Override
    public FinancialDevice getFinancialDevice(Integer id) {
		return (FinancialDevice) sessionFactory.getCurrentSession().get(FinancialDevice.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#removeFinancialDevice(java.lang.Integer)
     */
    @Override
    public void removeFinancialDevice(Integer id) {
		FinancialDevice financialDevice = (FinancialDevice) sessionFactory.getCurrentSession().load(FinancialDevice.class, id);
		if (financialDevice != null) {
		    sessionFactory.getCurrentSession().delete(financialDevice);
		}
    }
}