package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

// TODO: Auto-generated Javadoc
/**
 * The Interface XfsComponentService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface XfsComponentService {

    /**
     * Adds the xfs component.
     *
     * @param xfsComponent the xfs component
     */
    public void addXfsComponent(XfsComponent xfsComponent);

    /**
     * Gets the xfs component.
     *
     * @param id the id
     * @return the xfs component
     */
    public XfsComponent getXfsComponent(Integer id);

    /**
     * List xfs components.
     *
     * @return the list
     */
    public List<XfsComponent> listXfsComponents();

    /**
     * Adds the jxfs component.
     *
     * @param jxfsComponent the jxfs component
     */
    public void addJxfsComponent(JxfsComponent jxfsComponent);

    /**
     * Gets the jxfs component.
     *
     * @param id the id
     * @return the jxfs component
     */
    public JxfsComponent getJxfsComponent(Integer id);

    /**
     * List jxfs components.
     *
     * @return the list
     */
    public List<JxfsComponent> listJxfsComponents();
}