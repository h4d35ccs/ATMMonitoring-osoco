package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.RoleDAO;
import com.ncr.ATMMonitoring.pojo.Role;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleServiceImpl.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    /** The role dao. */
    @Autowired
    private RoleDAO roleDAO;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.RoleService#addRole(com.ncr.ATMMonitoring.pojo.Role)
     */
    @Override
    public void addRole(Role role) {
	roleDAO.addRole(role);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.RoleService#getRole(java.lang.Integer)
     */
    @Override
    public Role getRole(Integer id) {
	return roleDAO.getRole(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.RoleService#listRoles()
     */
    @Override
    public List<Role> listRoles() {
	return roleDAO.listRoles();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.RoleService#listManageableRoles()
     */
    @Override
    public List<Role> listManageableRoles() {
	return roleDAO.listManageableRoles();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.RoleService#removeRole(java.lang.Integer)
     */
    @Override
    public void removeRole(Integer id) {
	roleDAO.removeRole(id);
    }
}