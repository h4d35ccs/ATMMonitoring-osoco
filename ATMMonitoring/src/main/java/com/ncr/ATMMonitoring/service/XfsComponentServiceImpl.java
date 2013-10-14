package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.XfsComponentDAO;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("xfsComponentService")
@Transactional
public class XfsComponentServiceImpl implements XfsComponentService {

    @Autowired
    private XfsComponentDAO xfsComponentDAO;

    @Override
    public void addXfsComponent(XfsComponent xfsComponent) {
	xfsComponentDAO.addXfsComponent(xfsComponent);
    }

    @Override
    public List<XfsComponent> listXfsComponents() {
	return xfsComponentDAO.listXfsComponents();
    }

    @Override
    public XfsComponent getXfsComponent(Integer id) {
	return xfsComponentDAO.getXfsComponent(id);
    }
}