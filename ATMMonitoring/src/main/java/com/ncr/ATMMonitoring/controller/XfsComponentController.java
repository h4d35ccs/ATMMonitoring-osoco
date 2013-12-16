package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.XfsComponent;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.service.XfsComponentService;

// TODO: Auto-generated Javadoc
/**
 * The Class XfsComponentController.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class XfsComponentController {

    /** The xfs component service. */
    @Autowired
    private XfsComponentService xfsComponentService;
    
    /** The user service. */
    @Autowired
    private UserService userService;

    // @InitBinder
    // public void binder(WebDataBinder binder) {
    // binder.registerCustomEditor(Date.class, new CustomDateEditor(
    // new SimpleDateFormat("dd/MM/yyyy"), true));
    // }
    //
    // @RequestMapping("/terminals/xfsComponents/list")
    // public String listXfsComponents(Map<String, Object> map) {
    // map.put("xfsComponent", new XfsComponent());
    // map.put("xfsComponentList", xfsComponentService.listXfsComponents());
    //
    // return "xfsComponents";
    // }
    //
    // @RequestMapping(value = { "/terminals/xfsComponents" })
    // public String redirectToXfsComponents() {
    // return "redirect:/terminals/xfsComponents/list";
    // }

    /**
     * Xfs component details.
     *
     * @param xfsComponentId the xfs component id
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping("/terminals/xfsComponents/details/{xfsComponentId}")
    public String xfsComponentDetails(
	    @PathVariable("xfsComponentId") Integer xfsComponentId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	XfsComponent xfsComponent = xfsComponentService
		.getXfsComponent(xfsComponentId);
	if (xfsComponent == null) {
	    return "redirect:/terminals/list";
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    boolean allowed = false;
	    Set<BankCompany> banks = loggedUser.getManageableBankCompanies();
	    for (FinancialDevice dev : xfsComponent.getFinancialDevices()) {
		BankCompany aux = dev.getTerminal().getBankCompany();
		if ((aux == null) || (banks.contains(aux))) {
		    allowed = true;
		    break;
		}
	    }
	    if (!allowed) {
		map.clear();
		return "redirect:/terminals/list";
	    }
	}
	map.put("userMsg", userMsg);
	map.put("xfsComponent", xfsComponent);

	return "xfsComponentDetails";
    }

    /**
     * Jxfs component details.
     *
     * @param jxfsComponentId the jxfs component id
     * @param map the map
     * @param request the request
     * @param principal the principal
     * @return the string
     */
    @RequestMapping("/terminals/jxfsComponents/details/{jxfsComponentId}")
    public String jxfsComponentDetails(
	    @PathVariable("jxfsComponentId") Integer jxfsComponentId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	JxfsComponent jxfsComponent = xfsComponentService
		.getJxfsComponent(jxfsComponentId);
	if (jxfsComponent == null) {
	    return "redirect:/terminals/list";
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    boolean allowed = false;
	    Set<BankCompany> banks = loggedUser.getManageableBankCompanies();
	    for (FinancialDevice dev : jxfsComponent.getFinancialDevices()) {
		BankCompany aux = dev.getTerminal().getBankCompany();
		if ((aux == null) || (banks.contains(aux))) {
		    allowed = true;
		    break;
		}
	    }
	    if (!allowed) {
		map.clear();
		return "redirect:/terminals/list";
	    }
	}
	map.put("userMsg", userMsg);
	map.put("jxfsComponent", jxfsComponent);

	return "jxfsComponentDetails";
    }
    // @RequestMapping(value = "/terminals/xfsComponents/add", method =
    // RequestMethod.POST)
    // public String addXfsComponent(
    //
    // @ModelAttribute("xfsComponent") XfsComponent xfsComponent,
    // BindingResult result) {
    //
    // try {
    // xfsComponentService.addXfsComponent(xfsComponent);
    // } catch (GeneralSecurityException e) { // TODO Auto-generated catch
    // // block
    // e.printStackTrace();
    // }
    //
    // return "redirect:/terminals/xfsComponents/list";
    // }

}