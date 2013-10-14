package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Software;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareService {

    public void addSoftware(Software software);

    public Software getSoftware(Integer id);

    public Software getSoftwareByIdentifyingNumber(String id);

    public List<Software> listSoftware();
}