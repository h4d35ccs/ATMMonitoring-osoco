package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Software;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareDAO {

    public void addSoftware(Software software);

    public List<Software> listSoftware();

    public Software getSoftware(Integer id);

    public Software getSoftwareByIdentifyingNumber(String id);
}
