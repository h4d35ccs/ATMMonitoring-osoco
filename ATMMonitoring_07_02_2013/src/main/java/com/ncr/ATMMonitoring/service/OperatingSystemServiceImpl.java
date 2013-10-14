package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.OperatingSystemDAO;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("operatingSystemService")
@Transactional
public class OperatingSystemServiceImpl implements OperatingSystemService {

    @Autowired
    private OperatingSystemDAO operatingSystemDAO;

    @Override
    public void addOperatingSystem(OperatingSystem operatingSystem) {
	operatingSystemDAO.addOperatingSystem(operatingSystem);
    }

    @Override
    public List<OperatingSystem> listOperatingSystem() {
	return operatingSystemDAO.listOperatingSystem();
    }

    @Override
    public OperatingSystem getOperatingSystemBySerialNumber(String number) {
	return operatingSystemDAO.getOperatingSystemBySerialNumber(number);
    }

    @Override
    public OperatingSystem getOperatingSystem(Integer id) {
	return operatingSystemDAO.getOperatingSystem(id);
    }
}