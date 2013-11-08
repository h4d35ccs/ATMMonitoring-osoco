package com.ncr.ATMMonitoring.tag;

import com.ncr.ATMMonitoring.pojo.Terminal;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author Rafael Luque (OSOCO)
 */
public class TemplateModelPhotoUrlTag extends SimpleTagSupport {

	private Terminal atm;
	private String manufacturer;
	private Integer width;

    public void doTag() throws JspException, IOException {
		String url = null;
		if (manufacturer != null) {
			url = "resources/images/logo/" + manufacturer.toLowerCase() + ".png";
	    } else if ((atm != null) && (atm.getTerminalModel() != null)) {
			if (atm.getTerminalModel().getPhoto() != null) {
				url = "terminals/models/image/" + atm.getTerminalModel().getId();
				if (width != null) {
					url += "?width=" + width;
				}
			} else {
				url = "resources/images/logo/" + atm.getTerminalModel().getManufacturer().toLowerCase() + ".png";
			}
		} else {
			url = "resources/images/ejemplo/no_photo.png";
		}
        getJspContext().getOut().write(url);
    }

	public void setAtm(Terminal atm) {
		this.atm = atm;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

}
