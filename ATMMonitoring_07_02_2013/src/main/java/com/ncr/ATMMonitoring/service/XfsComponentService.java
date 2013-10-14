package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface XfsComponentService {

    public void addXfsComponent(XfsComponent xfsComponent);

    public XfsComponent getXfsComponent(Integer id);

    public List<XfsComponent> listXfsComponents();
}