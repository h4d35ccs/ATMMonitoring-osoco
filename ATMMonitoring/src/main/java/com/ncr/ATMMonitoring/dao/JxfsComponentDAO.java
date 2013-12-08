package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

// TODO: Auto-generated Javadoc
/**
 * The Interface JxfsComponentDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface JxfsComponentDAO {

    /**
     * Adds the jxfs component.
     *
     * @param jxfsComponent the jxfs component
     */
    public void addJxfsComponent(JxfsComponent jxfsComponent);

    /**
     * List jxfs components.
     *
     * @return the list
     */
    public List<JxfsComponent> listJxfsComponents();

    /**
     * Gets the jxfs component.
     *
     * @param id the id
     * @return the jxfs component
     */
    public JxfsComponent getJxfsComponent(Integer id);
}
