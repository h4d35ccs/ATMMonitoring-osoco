package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class HardwareDeviceDAOImpl implements HardwareDeviceDAO {

    static private Logger logger = Logger.getLogger(HardwareDeviceDAOImpl.class
	    .getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addHardwareDevice(HardwareDevice hardwareDevice) {
	sessionFactory.getCurrentSession().save(hardwareDevice);
	logger.debug("Created new Hardware Device with id "
		+ hardwareDevice.getId());
    }

    @Override
    public List<HardwareDevice> listHardwareDevices() {
	return sessionFactory.getCurrentSession()
		.createCriteria(HardwareDevice.class).list();
    }

    @Override
    public HardwareDevice getHardwareDevice(Integer id) {
	return (HardwareDevice) sessionFactory.getCurrentSession().get(
		HardwareDevice.class, id);
    }

    @Override
    public void removeHardwareDevice(Integer id) {
	HardwareDevice hardwareDevice = (HardwareDevice) sessionFactory
		.getCurrentSession().load(HardwareDevice.class, id);
	if (hardwareDevice != null) {
	    sessionFactory.getCurrentSession().delete(hardwareDevice);
	}
    }
}