package com.ncr.ATMMonitoring.controller.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

// TODO: Auto-generated Javadoc
/**
 * The Class DatePropertyEditor.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class DatePropertyEditor extends PropertyEditorSupport {

    /** The now as default. */
    private boolean nowAsDefault = false;

    /**
     * Instantiates a new date property editor.
     */
    public DatePropertyEditor() {
    }

    /**
     * Instantiates a new date property editor.
     *
     * @param nowAsDefault the now as default
     */
    public DatePropertyEditor(boolean nowAsDefault) {
	this.nowAsDefault = nowAsDefault;
    }

    /* (non-Javadoc)
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(final String date) {
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