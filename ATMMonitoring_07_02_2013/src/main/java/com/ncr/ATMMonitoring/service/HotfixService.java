package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Hotfix;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HotfixService {

    public void addHotfix(Hotfix hotfix);

    public void removeHotfix(Integer id);

    public Hotfix getHotfix(Integer id);

    public List<Hotfix> listHotfix();
}