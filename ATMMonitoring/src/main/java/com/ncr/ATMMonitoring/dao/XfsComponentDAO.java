package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.XfsComponent;

// TODO: Auto-generated Javadoc
/**
 * The Interface XfsComponentDAO.
 *
 * @author Jorge L�pez Fern�ndez (lopez.fernandez.jorge@gmail.com)
 */

public interface XfsComponentDAO {

    /**
     * Adds the xfs component.
     *
     * @param xfsComponent the xfs component
     */
    public void addXfsComponent(XfsComponent xfsComponent);

    /**
     * List xfs components.
     *
     * @return the list
     */
    public List<XfsComponent> listXfsComponents();

    /**
     * Gets the xfs component.
     *
     * @param id the id
     * @return the xfs component
     */
    public XfsComponent getXfsComponent(Integer id);
}
