package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.InstallationDAO;
import com.ncr.ATMMonitoring.pojo.Installation;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class InstallationServiceImpl implements InstallationService {

    @Autowired
    private InstallationDAO installationDAO;

    @Override
    public void addInstallation(Installation role) {
	installationDAO.addInstallation(role);
    }

    @Override
    public Installation getInstallation(Integer id) {
	return installationDAO.getInstallation(id);
    }

    @Override
    public List<Installation> listInstallations() {
	return installationDAO.listInstallations();
    }

    @Override
    public void updateInstallation(Installation installation) {
	installationDAO.updateInstallation(installation);
    }

    @Override
    public void removeInstallation(Integer id) {
	installationDAO.removeInstallation(id);
    }
}