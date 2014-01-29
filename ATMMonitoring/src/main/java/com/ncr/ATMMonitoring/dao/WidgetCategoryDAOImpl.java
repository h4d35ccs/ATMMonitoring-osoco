package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.pojo.WidgetCategory;

@Repository
public class WidgetCategoryDAOImpl extends AbstractGenericDAO<WidgetCategory> implements WidgetCategoryDAO {
	@Override
	public List<WidgetCategory> findLibraryWidgetsByCategory() {
    	return sessionFactory.getCurrentSession().createCriteria(WidgetCategory.class)
    			.add(Restrictions.not(Restrictions.isNull("category")))
				.addOrder(Order.asc("title"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
