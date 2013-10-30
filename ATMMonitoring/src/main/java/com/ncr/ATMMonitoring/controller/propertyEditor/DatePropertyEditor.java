package com.ncr.ATMMonitoring.controller.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class DatePropertyEditor extends PropertyEditorSupport {

    private boolean nowAsDefault = false;

    public DatePropertyEditor() {
    }

    public DatePropertyEditor(boolean nowAsDefault) {
	this.nowAsDefault = nowAsDefault;
    }

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

    @Override
    public String getAsText() {
	Date value = (Date) getValue();
	return (value != null) ? DateFormat.getDateInstance(DateFormat.SHORT,
		Locale.getDefault()).format(value) : "";
    }
}