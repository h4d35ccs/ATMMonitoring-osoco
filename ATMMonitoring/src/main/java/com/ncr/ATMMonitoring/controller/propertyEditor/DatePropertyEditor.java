package com.ncr.ATMMonitoring.controller.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * The Class DatePropertyEditor.
 * 
 * Custom PropertyEditor for Date input values.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class DatePropertyEditor extends PropertyEditorSupport {

    /**
     * Flag for using current time as default value if a void or invalid one is
     * supplied.
     */
    private boolean nowAsDefault = false;

    /**
     * Instantiates a new date property editor.
     */
    public DatePropertyEditor() {
    }

    /**
     * Instantiates a new date property editor.
     * 
     * @param nowAsDefault
     *            flag for using current time as default value if a void or
     *            invalid one is supplied.
     */
    public DatePropertyEditor(boolean nowAsDefault) {
	this.nowAsDefault = nowAsDefault;
    }

    @Override
    public void setAsText(final String date) {
    	if(nowAsDefault || date != null && !date.equals("")) {
    		try {
    			setValue(DateFormat.getDateInstance(DateFormat.SHORT,
    					Locale.getDefault()).parse(date));
    		} catch (ParseException e) {
    			if (nowAsDefault) {
    				setValue(new Date());
    			} else {
    				e.printStackTrace();
    			}
    		}	
    	}
    }

    /* (non-Javadoc)
     * @see java.beans.PropertyEditorSupport#getAsText()
     */
    @Override
    public String getAsText() {
	Date value = (Date) getValue();
	return (value != null) ? DateFormat.getDateInstance(DateFormat.SHORT,
		Locale.getDefault()).format(value) : "";
    }
}