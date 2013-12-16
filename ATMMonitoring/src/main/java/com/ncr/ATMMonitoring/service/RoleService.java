package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Role;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleService.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface RoleService {

    /**
     * Adds the role.
     *
     * @param role the role
     */
    public void addRole(Role role);

    /**
     * Gets the role.
     *
     * @param id the id
     * @return the role
     */
    public Role getRole(Integer id);

    /**
     * List roles.
     *
     * @return the list
     */
    public List<Role> listRoles();

    /**
     * List manageable roles.
     *
     * @return the list
     */
    public List<Role> listManageableRoles();

    /**
     * Removes the role.
     *
     * @param id the id
     */
    public void removeRole(Integer id);
}