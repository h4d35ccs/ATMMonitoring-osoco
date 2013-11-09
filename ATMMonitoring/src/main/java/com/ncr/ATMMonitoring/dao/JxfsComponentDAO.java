package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface JxfsComponentDAO {

    public void addJxfsComponent(JxfsComponent jxfsComponent);

    public List<JxfsComponent> listJxfsComponents();

    public JxfsComponent getJxfsComponent(Integer id);
}
