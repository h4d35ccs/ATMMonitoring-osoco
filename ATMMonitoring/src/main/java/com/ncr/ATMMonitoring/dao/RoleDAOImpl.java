package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Role;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * The Class RoleDAOImpl.
 * 
 * Default implementation of RoleDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class RoleDAOImpl extends AbstractGenericDAO<Role> implements RoleDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(RoleDAOImpl.class.getName());

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#addRole(com.ncr.ATMMonitoring.pojo.Role)
     */
    @Override
    public void addRole(Role role) {
	add(role);
	logger.debug("Created new Role with id " + role.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#getRole(java.lang.Integer)
     */
    @Override
    public Role getRole(Integer id) {
	return get(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#listRoles()
     */
    @Override
    public List<Role> listRoles() {
	return list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#listManageableRoles()
     */
    @Override
    public List<Role> listManageableRoles() {
	return sessionFactory.getCurrentSession().createCriteria(Role.class)
		.add(Restrictions.eq("manageable", true)).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.RoleDAO#listManageableRoles(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<Role> listManageableRoles(String sort, String order) {
	Criteria criteria = sessionFactory.getCurrentSession()
		.createCriteria(Role.class)
		.add(Restrictions.eq("manageable", true));

	if ((sort != null) && (order != null)) {
	    if ("asc".equals(order)) {
		criteria.addOrder(Order.asc(sort));
	    } else {
		criteria.addOrder(Order.desc(sort));
	    }
	}
	return criteria.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#removeRole(java.lang.Integer)
     */
    @Override
    public void removeRole(Integer id) {
	delete(id);
    }
}