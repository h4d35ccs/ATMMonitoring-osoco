package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.WidgetCategory;

public interface WidgetCategoryDAO {

	public List<WidgetCategory> findLibraryWidgetsByCategory();

	public WidgetCategory findCategoryById(Integer categoryId);

	public List<WidgetCategory> findAll();
	
    public void updateWidgetCategory(WidgetCategory widgetCategory);

}
