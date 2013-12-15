package com.ncr.ATMMonitoring.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbstractGenericDAO<T> {
    
    private Class<T> domainClass = getDomainClass();

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class getDomainClass() {
	if (domainClass == null) {
	    ParameterizedType thisType = (ParameterizedType) getClass()
		    .getGenericSuperclass();
	    domainClass = (Class) thisType.getActualTypeArguments()[0];
	}
	return domainClass;
    }

    protected void add(T object) {
	sessionFactory.getCurrentSession().save(object);
    }

    protected void delete(T object) {
	sessionFactory.getCurrentSession().delete(object);
    }

    protected void delete(Integer id) {
	T object = (T) sessionFactory.getCurrentSession().load(
		getDomainClass(), id);
	if (object != null) {
	    delete(object);
	}
    }

    protected void update(T object) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(object));
    }

    protected List<T> list() {
	return sessionFactory.getCurrentSession()
		.createCriteria(getDomainClass()).list();
    }

    protected T get(Integer id) {
	return (T) sessionFactory.getCurrentSession().get(getDomainClass(), id);
    }
}
