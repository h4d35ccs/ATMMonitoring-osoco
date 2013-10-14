package com.ncr.ATMMonitoring.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.ncr.ATMMonitoring.service.RoleService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RolePropertyEditor extends PropertyEditorSupport {

    private RoleService roleService;

    public RolePropertyEditor(RoleService roleService) {
	this.roleService = roleService;
    }

    @Override
    public void setAsText(final String name) {
	setValue(roleService.getRole(Integer.valueOf(name)));
    }
}