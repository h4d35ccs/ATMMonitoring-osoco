package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.HotfixDAO;
import com.ncr.ATMMonitoring.pojo.Hotfix;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("hotfixService")
@Transactional
public class HotfixServiceImpl implements HotfixService {

    @Autowired
    private HotfixDAO hotfixDAO;

    @Override
    public void addHotfix(Hotfix hotfix) {
	hotfixDAO.addHotfix(hotfix);
    }

    @Override
    public List<Hotfix> listHotfix() {
	return hotfixDAO.listHotfix();
    }

    @Override
    public Hotfix getHotfix(Integer id) {
	return hotfixDAO.getHotfix(id);
    }

    @Override
    public void removeHotfix(Integer id) {
	hotfixDAO.removeHotfix(id);
    }
}