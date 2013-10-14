package com.ncr.ATMMonitoring.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.ncr.ATMMonitoring.service.SoftwareService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SoftwarePropertyEditor extends PropertyEditorSupport {

    private SoftwareService softwareService;

    public SoftwarePropertyEditor(SoftwareService softwareService) {
    	this.softwareService = softwareService;
    }

    @Override
    public void setAsText(final String name) {
    	setValue(softwareService.getSoftware(Integer.valueOf(name)));
    }
}