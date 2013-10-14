package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface XfsComponentDAO {

    public void addXfsComponent(XfsComponent xfsComponent);

    public List<XfsComponent> listXfsComponents();

    public XfsComponent getXfsComponent(Integer id);
}
