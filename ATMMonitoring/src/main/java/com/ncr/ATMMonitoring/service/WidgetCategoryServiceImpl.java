package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.WidgetCategoryDAO;
import com.ncr.ATMMonitoring.pojo.WidgetCategory;

@Service("WidgetCategoryService")
@Transactional
public class WidgetCategoryServiceImpl implements WidgetCategoryService {

    @Autowired
    private WidgetCategoryDAO widgetCategoryDAO;

    @Override
	public List<WidgetCategory> findAll() {
		return widgetCategoryDAO.findAll();
	}

	@Override
	public void updateWidgetCategory(WidgetCategory widgetCategory) {
		widgetCategoryDAO.updateWidgetCategory(widgetCategory);
	}

}
