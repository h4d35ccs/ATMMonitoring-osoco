package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.RoleDAO;
import com.ncr.ATMMonitoring.pojo.Role;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void addRole(Role role) {
	roleDAO.addRole(role);
    }

    @Override
    public Role getRole(Integer id) {
	return roleDAO.getRole(id);
    }

    @Override
    public List<Role> listRoles() {
	return roleDAO.listRoles();
    }

    @Override
    public List<Role> listManageableRoles() {
	return roleDAO.listManageableRoles();
    }

    @Override
    public void removeRole(Integer id) {
	roleDAO.removeRole(id);
    }
}