package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.BankCompanyService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class BankCompanyController {

    @Value("${config.bankCompaniesPageSize}")
    private int bankCompaniesPageSize;

    @Autowired
    private BankCompanyService bankCompanyService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/banks" })
    public String redirectToBankCompanys() {
	return "redirect:/banks/list";
    }

    @RequestMapping(value = "/banks/list", method = RequestMethod.GET)
    public String listBankCompanies(Map<String, Object> map,
	    Principal principal, String p, HttpServletRequest request) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	PagedListHolder<BankCompany> pagedListHolder = new PagedListHolder<BankCompany>(
		bankCompanyService.listBankCompanies());
	map.put("userMsg", userMsg);
	map.put("bankCompany", new BankCompany());
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(bankCompaniesPageSize);
	map.put("pagedListHolder", pagedListHolder);
	map.put("bankCompaniesList", bankCompanyService.listBankCompanies());

	return "bankCompanies";
    }

    @RequestMapping(value = "/banks/list", method = RequestMethod.POST)
    public String addBankCompany(
	    @Valid @ModelAttribute("bankCompany") BankCompany bankCompany,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, String p, Principal principal) {
	if ((bankCompany.getParentCompany() != null)
		&& (bankCompany.getParentCompany().getId() == null)) {
	    bankCompany.setParentCompany(null);
	}

	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}

	if (result.hasErrors()) {
	    PagedListHolder<BankCompany> pagedListHolder = new PagedListHolder<BankCompany>(
		    bankCompanyService.listBankCompanies());
	    map.put("userMsg", userMsg);
	    int page = 0;
	    if (p != null) {
		try {
		    page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
	    }
	    pagedListHolder.setPage(page);
	    pagedListHolder.setPageSize(bankCompaniesPageSize);
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("userMsg", userMsg);
	    map.put("bankCompaniesList", bankCompanyService.listBankCompanies());
	    return "bankCompanies";
	}

	bankCompanyService.addBankCompany(bankCompany);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/banks/list";
    }

    @RequestMapping("/banks/details/{bankCompanyId}")
    public String bankCompanyDetails(
	    @PathVariable("bankCompanyId") Integer bankCompanyId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	BankCompany bankCompany = bankCompanyService
		.getBankCompany(bankCompanyId);
	if (bankCompany == null) {
	    map.clear();
	    return "redirect:/banks/list";
	}
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	map.put("bankCompany", bankCompany);
	map.put("bankCompaniesList", bankCompanyService.listBankCompanies());

	return "bankCompanyDetails";
    }

    @RequestMapping(value = "/banks/update", method = RequestMethod.POST)
    public String updateBankCompany(
	    @Valid @ModelAttribute("bankCompany") BankCompany bankCompany,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((bankCompany.getParentCompany() != null)
		&& (bankCompany.getParentCompany().getId() == null)) {
	    bankCompany.setParentCompany(null);
	}
	BankCompany aux = bankCompanyService
		.getBankCompany(bankCompany.getId());
	bankCompany.setSubBankCompanies(aux.getSubBankCompanies());

	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    User loggedUser = userService
		    .getUserByUsername(principal.getName());
	    userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	}
	map.put("userMsg", userMsg);
	if (result.hasErrors()) {
	    map.put("bankCompaniesList", bankCompanyService.listBankCompanies());
	    return "bankCompanyDetails";
	}

	bankCompanyService.updateBankCompany(bankCompany);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/banks/details/" + bankCompany.getId().intValue();
    }

    @RequestMapping("/banks/delete/{bankCompanyId}")
    public String deleteBankCompany(
	    @PathVariable("bankCompanyId") Integer bankCompanyId,
	    Principal principal) {
	BankCompany bankCompany = bankCompanyService
		.getBankCompany(bankCompanyId);
	if (bankCompany != null) {
	    bankCompanyService.removeBankCompany(bankCompanyId);
	}

	return "redirect:/banks/list";
    }
}