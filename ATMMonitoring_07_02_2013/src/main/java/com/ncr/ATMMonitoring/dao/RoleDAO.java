package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Role;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface RoleDAO {

    public void addRole(Role role);

    public Role getRole(Integer id);

    public List<Role> listRoles();

    public List<Role> listManageableRoles();

    public void removeRole(Integer id);
}
