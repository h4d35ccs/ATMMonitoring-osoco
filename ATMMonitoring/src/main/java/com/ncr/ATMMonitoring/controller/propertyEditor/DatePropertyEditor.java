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

    public DatePropertyEditor() {
    }

    @Override
    public void setAsText(final String date) {
	try {
	    setValue(DateFormat.getDateInstance(DateFormat.SHORT,
		    Locale.getDefault()).parse(date));
	} catch (ParseException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public String getAsText() {
	Date value = (Date) getValue();
	return (value != null) ? DateFormat.getDateInstance(DateFormat.SHORT,
		Locale.getDefault()).format(value) : "";
    }
}