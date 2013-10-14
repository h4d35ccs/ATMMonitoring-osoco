package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Role;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class RoleDAOImpl implements RoleDAO {

    static private Logger logger = Logger
	    .getLogger(RoleDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Role role) {
	sessionFactory.getCurrentSession().save(role);
	logger.debug("Created new Role with id " + role.getId());
    }

    @Override
    public Role getRole(Integer id) {
	return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public List<Role> listRoles() {
	return sessionFactory.getCurrentSession().createCriteria(Role.class)
		.list();
    }

    @Override
    public List<Role> listManageableRoles() {
	return sessionFactory.getCurrentSession().createCriteria(Role.class)
		.add(Restrictions.eq("manageable", true)).list();
    }

    @Override
    public void removeRole(Integer id) {
	Role role = (Role) sessionFactory.getCurrentSession().load(Role.class,
		id);
	if (null != role) {
	    sessionFactory.getCurrentSession().delete(role);
	}

    }
}