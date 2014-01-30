package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.WidgetCategory;

@Repository
public class WidgetCategoryDAOImpl extends AbstractGenericDAO<WidgetCategory> implements WidgetCategoryDAO {
	
	@Override
	public List<WidgetCategory> findLibraryWidgetsByCategory() {
    	return sessionFactory.getCurrentSession().createCriteria(WidgetCategory.class)
    			.add(Restrictions.not(Restrictions.isEmpty("widgets")))
    			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
    			.list();
    }

	@Override
	public WidgetCategory findCategoryById(Integer categoryId) {
		return get(categoryId);
	}

	@Override
	public List<WidgetCategory> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(WidgetCategory.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}
	
	@Override
    public void updateWidgetCategory(WidgetCategory widgetCategory) {
		update(widgetCategory);
	}
}
