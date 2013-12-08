package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Interface WidgetDAO.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

public interface WidgetDAO {

    /**
     * Save.
     *
     * @param widget the widget
     */
    public void save(Widget widget);

    /**
     * Update.
     *
     * @param widget the widget
     */
    public void update(Widget widget);

	/**
	 * Find default widgets.
	 *
	 * @return the list
	 */
	public List<Widget> findDefaultWidgets();

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the widget
	 */
	public Widget findById(int id);

}
