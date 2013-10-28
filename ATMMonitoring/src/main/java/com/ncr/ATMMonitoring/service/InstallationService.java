package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Installation;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InstallationService {

    public void addInstallation(Installation installation);

    public Installation getInstallation(Integer id);

    public List<Installation> listInstallations();

    public void updateInstallation(Installation installation);

    public void removeInstallation(Integer id);
}