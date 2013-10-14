package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Hotfix;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HotfixDAO {

    public void addHotfix(Hotfix hotfix);

    public List<Hotfix> listHotfix();

    public Hotfix getHotfix(Integer id);

    public void removeHotfix(Integer id);
}
