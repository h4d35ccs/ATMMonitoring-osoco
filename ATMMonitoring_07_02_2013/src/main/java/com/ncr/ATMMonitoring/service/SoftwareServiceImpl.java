package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.SoftwareDAO;
import com.ncr.ATMMonitoring.pojo.Software;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("softwareService")
@Transactional
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    private SoftwareDAO softwareDAO;

    @Override
    public void addSoftware(Software software) {
	softwareDAO.addSoftware(software);
    }

    @Override
    public List<Software> listSoftware() {
	return softwareDAO.listSoftware();
    }

    @Override
    public Software getSoftware(Integer id) {
	return softwareDAO.getSoftware(id);
    }

    @Override
    public Software getSoftwareByIdentifyingNumber(String id) {
	return softwareDAO.getSoftwareByIdentifyingNumber(id);
    }
}