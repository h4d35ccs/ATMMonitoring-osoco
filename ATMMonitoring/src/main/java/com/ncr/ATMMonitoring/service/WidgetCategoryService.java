package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.WidgetCategory;

public interface WidgetCategoryService {

	public List<WidgetCategory> findAll();

	public void updateWidgetCategory(WidgetCategory widgetCategory);
}

