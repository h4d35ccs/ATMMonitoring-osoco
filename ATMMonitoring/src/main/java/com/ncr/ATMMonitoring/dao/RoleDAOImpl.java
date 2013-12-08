package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Role;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleDAOImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class RoleDAOImpl implements RoleDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(RoleDAOImpl.class.getName());
    
    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#addRole(com.ncr.ATMMonitoring.pojo.Role)
     */
    @Override
    public void addRole(Role role) {
	sessionFactory.getCurrentSession().save(role);
	logger.debug("Created new Role with id " + role.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#getRole(java.lang.Integer)
     */
    @Override
    public Role getRole(Integer id) {
	return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#listRoles()
     */
    @Override
    public List<Role> listRoles() {
	return sessionFactory.getCurrentSession().createCriteria(Role.class)
		.list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#listManageableRoles()
     */
    @Override
    public List<Role> listManageableRoles() {
	return sessionFactory.getCurrentSession().createCriteria(Role.class)
		.add(Restrictions.eq("manageable", true)).list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#removeRole(java.lang.Integer)
     */
    @Override
    public void removeRole(Integer id) {
	Role role = (Role) sessionFactory.getCurrentSession().load(Role.class,
		id);
	if (null != role) {
	    sessionFactory.getCurrentSession().delete(role);
	}

    }
}