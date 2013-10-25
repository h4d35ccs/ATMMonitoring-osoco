package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Widget;

/**
 * @author Rafael Luque (OSOCO)
 */

public interface WidgetDAO {

    public void save(Widget widget);

    public void update(Widget widget);

	public List<Widget> findDefaultWidgets();

	public Widget findById(int id);

}
