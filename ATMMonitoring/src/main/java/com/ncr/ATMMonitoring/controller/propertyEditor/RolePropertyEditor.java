package com.ncr.ATMMonitoring.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.ncr.ATMMonitoring.service.RoleService;

// TODO: Auto-generated Javadoc
/**
 * The Class RolePropertyEditor.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RolePropertyEditor extends PropertyEditorSupport {

    /** The role service. */
    private RoleService roleService;

    /**
     * Instantiates a new role property editor.
     *
     * @param roleService the role service
     */
    public RolePropertyEditor(RoleService roleService) {
	this.roleService = roleService;
    }

    /* (non-Javadoc)
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(final String name) {
	setValue(roleService.getRole(Integer.valueOf(name)));
    }
}