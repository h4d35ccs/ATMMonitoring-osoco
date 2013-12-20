package com.ncr.ATMMonitoring.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.controller.propertyEditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.TerminalModel;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.InstallationService;
import com.ncr.ATMMonitoring.service.LocationService;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.TerminalModelService;
import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.socket.SocketService;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class TerminalController {

	static private Logger logger = Logger.getLogger(TerminalController.class.getName());

	public static final String DEFAULT_SORT = "serialNumber";

	public static final String DEFAULT_ORDER = "asc";

	@Value("${security.terminalsManagementAllowedRoles}")
	private String canAlterTerminalsRoles;
	@Value("${security.scheduledUpdatesAccessAllowedRoles}")
	private String canManageScheduledUpdatesRoles;
	@Value("${config.terminalsPageSize}")
	private int pageSize;
	@Value("${config.terminalModelsPageSize}")
	private int terminalModelsPageSize;

	@Autowired
	private TerminalService terminalService;
	@Autowired
	private TerminalModelService terminalModelService;
	@Autowired
	private InstallationService installationService;
	@Autowired
	private QueryService queryService;
	@Autowired
	private UserService userService;
	@Autowired
	private SocketService socketService;
	@Autowired
	private LocationService locationService;

	// @Autowired
	// private SoftwareService softwareService;

	@InitBinder
	protected void binder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DatePropertyEditor());
	}

	@RequestMapping(value = "/terminals/request", method = RequestMethod.GET)
	public String requestTerminalsUpdate(Map<String, Object> map, String queryId, HttpServletRequest request,
			Principal principal,
			RedirectAttributes redirectAttributes) {
		if ((queryId != null) && (principal != null)) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			Query query = queryService.getQuery(Integer.parseInt(queryId));
			if (query.getUser().getId().equals(loggedUser.getId())) {
				socketService.updateTerminalsSocket(query);
			}
		} else {
			// try {
			socketService.updateAllTerminalsSocket();
			redirectAttributes.addFlashAttribute("success", "success.snmpUpdateAll");
			//		} catch (SnmpTimeOutException e) {
			//		    String userMsg = "";
			//		    Locale locale = RequestContextUtils.getLocale(request);
			//		    if (principal != null) {
			//			User loggedUser = userService.getUserByUsername(principal
			//				.getName());
			//			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
			//
			//		    }
			//		    map.put("userMsg", userMsg);
			//		    map.put("ips", e.getIpsHtmlList());
			//		    redirectAttributes.addFlashAttribute("timeout", "timeout.snmpUpdateAll");
			//		}
		}

		try {
			// We wait to avoid not loading the recently added DB data
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/list";
	}

	@RequestMapping("/terminals/request/{terminalId}")
	public String requestTerminalUpdate(
			@PathVariable("terminalId") Integer terminalId,
			Map<String, Object> map, HttpServletRequest request,
			RedirectAttributes redirectAttributes,
			Principal principal)
	{
		Terminal terminal = terminalService.getTerminal(terminalId);
		if (terminal == null) {
			map.clear();
			return "redirect:/terminals/list";
		}
		// try {
		logger.debug("request snmp update for terminal" + terminalId);
		socketService.updateTerminalSocket(terminal);
		redirectAttributes.addFlashAttribute("success", "success.snmpUpdateTerminal");
		// } catch (SnmpTimeOutException e) {
		// String userMsg = "";
		// Locale locale = RequestContextUtils.getLocale(request);
		// if (principal != null) {
		// User loggedUser = userService.getUserByUsername(principal.getName());
		// userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		// Set<BankCompany> bankCompanies = loggedUser
		// .getManageableBankCompanies();
		// if ((terminal.getBankCompany() != null)
		// && (!bankCompanies.contains(terminal.getBankCompany()))) {
		// map.clear();
		// return "redirect:/terminals/list";
		// }
		// }
		// map.put("userMsg", userMsg);
		// map.put("ips", e.getIpsHtmlList());
		// redirectAttributes.addFlashAttribute("timeout",
		// "timeout.snmpUpdateTerminal");
		// return "redirect:/terminals/details/" + terminalId;
		// }

		try {
			// We wait to avoid not loading the recently added DB data
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/details/" + terminalId;
	}

	@RequestMapping(value = "/terminals/list", method = RequestMethod.GET)
	public String listTerminals(
			Map<String, Object> map,
			Principal principal,
			String p,
			String sort,
			String order,
			HttpServletRequest request) {
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}
		boolean canAdd = false, canManageScheduled = false;
		PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>();
		Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
		Set<Query> userQueries = null;
		String sortValue = (sort == null) ? DEFAULT_SORT : sort;
		String orderValue = (order == null) ? DEFAULT_ORDER : order;
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			if ((loggedUser.getRole() != null)
					&& (canAlterTerminalsRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canAdd = true;
			}
			if ((loggedUser.getRole() != null)
					&& (canManageScheduledUpdatesRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canManageScheduled = true;
			}
			pagedListHolder = new PagedListHolder<Terminal>(
					terminalService.listTerminalsByBankCompanies(
							loggedUser.getManageableBankCompanies(), sortValue, orderValue));
			bankCompanies = loggedUser.getManageableBankCompanies();
			userQueries = loggedUser.getQueries();
		}
		map.put("banksList", bankCompanies);
		map.put("installationsList", installationService.listInstallations());
		map.put("userQueries", userQueries);
		map.put("userMsg", userMsg);
		map.put("canAdd", canAdd);
		map.put("canManageScheduled", canManageScheduled);
		map.put("terminal", new Terminal());
		map.put("sort", sortValue);
		map.put("order", orderValue);
		int page = 0;
		if (p != null) {
			try {
				page = Integer.parseInt(p);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(pageSize);
		map.put("pagedListHolder", pagedListHolder);

		return "terminals";
	}

	@RequestMapping(value = { "/terminals" })
	public String redirectToTerminals() {
		return "redirect:/terminals/list";
	}

	@RequestMapping("/terminals/details/{terminalId}")
	public String terminalDetails(
			@PathVariable("terminalId") Integer terminalId, Date date,
			Map<String, Object> map, HttpServletRequest request,
			Principal principal) {

		Terminal terminal = terminalService.getTerminal(terminalId);
		if (terminal == null) {
			map.clear();
			return "redirect:/terminals/list";
		}
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}
		boolean canEdit = false;
		Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			if ((loggedUser.getRole() != null)
					&& (canAlterTerminalsRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canEdit = true;
			}
			bankCompanies = loggedUser.getManageableBankCompanies();
			if ((terminal.getBankCompany() != null)
					&& (!bankCompanies.contains(terminal.getBankCompany()))) {
				map.clear();
				return "redirect:/terminals/list";
			}
		}
		map.put("banksList", bankCompanies);
		map.put("installationsList", installationService.listInstallations());
		map.put("values",
				terminalModelService.listTerminalModelsByManufacturer());
		map.put("userMsg", userMsg);
		map.put("canEdit", canEdit);
		map.put("terminal", terminal);
		map.put("date", date);
		map.put("historicalChanges",terminal.buildHistoricalChanges());
		// Code with support for Terminal Config AUTHORS
		//
		// TerminalConfig newConfig = new TerminalConfig();
		// if (terminal.getCurrentConfig() != null) {
		// newConfig.setSoftware(terminal.getCurrentConfig().getSoftware());
		// }
		// newConfig.getTerminal().setId(terminalId);
		// map.put("newConfig", newConfig);
		//
		// map.put("softwareList", softwareService.listSoftware());

		return "terminalDetails";
	}

	@RequestMapping(value = "/terminals/import", method = RequestMethod.POST)
	public String importTerminal(
			@RequestParam("file") CommonsMultipartFile file,
			Map<String, Object> map, HttpServletRequest request,
			Principal principal) {

		boolean importResult = false;
		if (file != null) {
			importResult = terminalService.importJsonTerminal(file);
		}
		return "redirect:/terminals/list";
	}

	@RequestMapping(value="/terminals/new", method = RequestMethod.GET)
	public String viewNewTerminal(Map<String, Object> map,
			HttpServletRequest request, Principal principal) {
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		boolean canAdd = false;
		Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			if ((loggedUser.getRole() != null)
					&& (canAlterTerminalsRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canAdd = true;
			}
			bankCompanies = loggedUser.getManageableBankCompanies();
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}

		map.put("values", terminalModelService.listTerminalModelsByManufacturer());
		map.put("banksList", bankCompanies);
		map.put("canAdd", canAdd);
		map.put("terminal", new Terminal());

		return "newTerminal";
	}

	@RequestMapping(value = "/terminals/list", method = RequestMethod.POST)
	public String addTerminal(
			@Valid @ModelAttribute("terminal") Terminal terminal,
			BindingResult result, Map<String, Object> map,
			HttpServletRequest request, Principal principal, String p) {
		if ((terminal.getBankCompany() != null)
				&& (terminal.getBankCompany().getId() == null)) {
			terminal.setBankCompany(null);
		}
		/*
		if ((terminal.getInstallation() != null)
				&& (terminal.getInstallation().getId() == null)) {
			terminal.setInstallation(null);
		}*/
		if ((terminal.getTerminalModel() != null)
				&& (terminal.getTerminalModel().getId() == null)) {
			terminal.setTerminalModel(null);
		}
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		boolean canAdd = false;
		PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>();
		Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			if ((loggedUser.getRole() != null)
					&& (canAlterTerminalsRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canAdd = true;
			}
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
			Set<Query> userQueries = loggedUser.getQueries();

			map.put("userQueries", userQueries);
			pagedListHolder = new PagedListHolder<Terminal>(
					terminalService.listTerminalsByBankCompanies(loggedUser
							.getManageableBankCompanies()));
			bankCompanies = loggedUser.getManageableBankCompanies();
			if ((terminal.getBankCompany() != null)
					&& (!bankCompanies.contains(terminal.getBankCompany()))) {
				map.clear();
				return "redirect:/terminals/list";
			}
		}
		int page = 0;
		if (p != null) {
			try {
				page = Integer.parseInt(p);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(pageSize);
		map.put("pagedListHolder", pagedListHolder);
		map.put("banksList", bankCompanies);
		map.put("installationsList", installationService.listInstallations());
		if (result.hasErrors()) {
			map.put("userMsg", userMsg);
			map.put("canAdd", canAdd);
			return "terminals";
		}

		// TODO revisar esto cuando actualicemos el modelo
		//
		// if (terminalService.loadTerminalBySerialNumber(terminal
		// .getSerialNumber()) != null) {
		// map.put("userMsg", userMsg);
		// map.put("canAdd", canAdd);
		// map.put("duplicatedSerialNumber", true);
		// return "terminals";
		// }
		// if (terminalService.loadTerminalByIp(terminal.getIp()) != null) {
		// map.put("userMsg", userMsg);
		// map.put("canAdd", canAdd);
		// map.put("duplicatedIp", true);
		// return "terminals";
		// }
		//
		// if (terminalService.loadTerminalByMac(terminal.getMac()) != null) {
		// map.put("userMsg", userMsg);
		// map.put("canAdd", canAdd);
		// map.put("duplicatedMac", true);
		// return "terminals";
		// }

		terminalService.addTerminal(terminal);

		try {
			// We wait to avoid not loading the recently added DB data
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/list";
	}

	@RequestMapping(value = "/terminals/update", method = RequestMethod.POST)
	public String updateTerminal(
			@Valid @ModelAttribute("terminal") Terminal terminal,
			BindingResult result, Map<String, Object> map,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request, Principal principal) {
		if ((terminal.getBankCompany() != null)
				&& (terminal.getBankCompany().getId() == null)) {
			terminal.setBankCompany(null);
		}
		/*
		if((terminal.getInstallation() != null)
				&& (terminal.getInstallation().getId() == null)) {
			terminal.setInstallation(null);
		}*/
		if ((terminal.getTerminalModel() != null)
				&& (terminal.getTerminalModel().getId() == null)) {
			terminal.setTerminalModel(null);
		}
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		boolean canEdit = false;
		List<Terminal> terminals = new ArrayList<Terminal>();
		Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			if ((loggedUser.getRole() != null)
					&& (canAlterTerminalsRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canEdit = true;
			}
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
			terminals = terminalService.listTerminalsByBankCompanies(loggedUser
					.getManageableBankCompanies());
			bankCompanies = loggedUser.getManageableBankCompanies();
		}
		map.put("banksList", bankCompanies);
		map.put("installationsList", installationService.listInstallations());
		map.put("terminalsList", terminals);
		map.put("userMsg", userMsg);
		map.put("canEdit", canEdit);
		if (result.hasErrors()) {
			map.put("errors", true);
			return "terminalDetails";
		}

		// TODO revisar esto cuando actualicemos el modelo
		//
		// Terminal auxTerminal = terminalService
		// .loadTerminalBySerialNumber(terminal.getSerialNumber());
		// if ((auxTerminal != null)
		// && (!auxTerminal.getId().equals(terminal.getId()))) {
		// map.put("duplicatedSerialNumber", true);
		// map.put("errors", true);
		// return "terminalDetails";
		// }
		// auxTerminal = terminalService.loadTerminalByIp(terminal.getIp());
		// if ((auxTerminal != null)
		// && (!auxTerminal.getId().equals(terminal.getId()))) {
		// map.put("duplicatedIp", true);
		// map.put("errors", true);
		// return "terminalDetails";
		// }
		// auxTerminal = terminalService.loadTerminalByMac(terminal.getMac());
		// if ((auxTerminal != null)
		// && (!auxTerminal.getId().equals(terminal.getId()))) {
		// map.put("duplicatedMac", true);
		// map.put("errors", true);
		// return "terminalDetails";
		// }

		Terminal auxTerminal = terminalService.getTerminal(terminal.getId());
		auxTerminal.replaceTerminalData(terminal);
		terminalService.updateTerminal(auxTerminal);
		redirectAttributes.addFlashAttribute("success", "success.updatingTerminal");
		try {
			// We wait to avoid not loading the recently added DB data
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/details/" + terminal.getId().intValue();
	}

	@RequestMapping(value="terminals/byQuery")
	public String listTerminalsByQuery(
			Map<String, Object> map,
			Integer queryId,
			Principal principal,
			String p,
			String sort,
			String order,
			Date queryDate,
			HttpServletRequest request) {
		
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		Set<Query> userQueries = null;
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}
		String sortValue = (sort == null) ? DEFAULT_SORT : sort;
		String orderValue = (order == null) ? DEFAULT_ORDER : order;
		boolean canAdd = false, canManageScheduled = false;
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			if ((loggedUser.getRole() != null)
					&& (canAlterTerminalsRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canAdd = true;
			}
			if ((loggedUser.getRole() != null)
					&& (canManageScheduledUpdatesRoles.contains("'ROLE_"
							+ loggedUser.getRole().getName().toUpperCase()
							+ "'"))) {
				canManageScheduled = true;
			}
			userQueries = loggedUser.getQueries();
		}
		map.put("userQueries", userQueries);
		map.put("userMsg", userMsg);
		map.put("canAdd", canAdd);
		map.put("canManageScheduled", canManageScheduled);
		Query query= null;
		List<Terminal> terminals = null;
		if (queryId != null) {
			query = queryService.getQuery(queryId);
			terminals= queryService.executeQuery(query, locale, sortValue, orderValue,queryDate);
		}
		if (terminals == null) {
			terminals = terminalService.listTerminals();

		}
		PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>(
				terminals);
		int page = 0;
		if (p != null) {
			try {
				page = Integer.parseInt(p);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(pageSize);
		map.put("query", query);
		map.put("pagedListHolder", pagedListHolder);
		map.put("sort", sortValue);
		map.put("order", orderValue);

		return "terminals";
	}

	@RequestMapping(value = { "/terminals/models" })
	public String redirectToTerminalModels() {
		return "redirect:/terminals/models/list";
	}

	@RequestMapping(value = "/terminals/models/list", method = RequestMethod.GET)
	public String listTerminalModels(Map<String, Object> map,
			Principal principal, String p, HttpServletRequest request) {
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}
		PagedListHolder<TerminalModel> pagedListHolder = new PagedListHolder<TerminalModel>(
				terminalModelService.listTerminalModels());
		map.put("userMsg", userMsg);
		map.put("terminalModel", new TerminalModel());
		int page = 0;
		if (p != null) {
			try {
				page = Integer.parseInt(p);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(terminalModelsPageSize);
		map.put("pagedListHolder", pagedListHolder);

		return "terminalModels";
	}

	@RequestMapping(value = "/terminals/models/list", method = RequestMethod.POST)
	public String addTerminalModel(
			@Valid @ModelAttribute("terminalModel") TerminalModel terminalModel,
			@RequestParam("file") CommonsMultipartFile photo,
			BindingResult result, Map<String, Object> map,
			HttpServletRequest request, String p, Principal principal) {

		if (photo != null) {
			terminalModel.setPhoto(photo.getBytes());
		}
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}

		if (result.hasErrors()) {
			PagedListHolder<TerminalModel> pagedListHolder = new PagedListHolder<TerminalModel>(
					terminalModelService.listTerminalModels());
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
			pagedListHolder.setPageSize(terminalModelsPageSize);
			map.put("pagedListHolder", pagedListHolder);
			map.put("userMsg", userMsg);
			return "terminalModels";
		}

		terminalModelService.addTerminalModel(terminalModel);

		try {
			// We wait to avoid not loading the recently added DB data
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/models/list";
	}

	@RequestMapping("/terminals/models/details/{terminalModelId}")
	public String terminalModelDetails(
			@PathVariable("terminalModelId") Integer terminalModelId,
			Map<String, Object> map, HttpServletRequest request,
			Principal principal) {
		TerminalModel terminalModel = terminalModelService
				.getTerminalModel(terminalModelId);
		if (terminalModel == null) {
			map.clear();
			return "redirect:/terminals/models/list";
		}
		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}
		map.put("userMsg", userMsg);
		map.put("terminalModel", terminalModel);

		return "terminalModelDetails";
	}

	@RequestMapping(value = "/terminals/models/update", method = RequestMethod.POST)
	public String updateTerminalModel(
			@Valid @ModelAttribute("terminalModel") TerminalModel terminalModel,
			@RequestParam("file") CommonsMultipartFile photo,
			BindingResult result, Map<String, Object> map,
			HttpServletRequest request, Principal principal) {
		if ((photo != null) && (photo.getSize() > 0)) {
			terminalModel.setPhoto(photo.getBytes());
		}

		String userMsg = "";
		Locale locale = RequestContextUtils.getLocale(request);
		if (principal != null) {
			User loggedUser = userService
					.getUserByUsername(principal.getName());
			userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		}
		map.put("userMsg", userMsg);
		if (result.hasErrors()) {
			return "terminalModelDetails";
		}

		terminalModelService.updateTerminalModel(terminalModel);

		try {
			// We wait to avoid not loading the recently added DB data
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.clear();
		return "redirect:/terminals/models/details/"
		+ terminalModel.getId().intValue();
	}

	@RequestMapping("/terminals/models/delete/{terminalModelId}")
	public String deleteTerminalModel(
			@PathVariable("terminalModelId") Integer terminalModelId,
			Principal principal) {
		TerminalModel terminalModel = terminalModelService
				.getTerminalModel(terminalModelId);
		if (terminalModel != null) {
			terminalModelService.removeTerminalModel(terminalModelId);
		}

		return "redirect:/terminals/models/list";
	}

	@RequestMapping(value = { "terminals/models/image/{terminalModelId}" })
	public void getTerminalModelImage(
			@PathVariable("terminalModelId") Integer terminalModelId,
			HttpServletRequest request, HttpServletResponse response,
			String width, String height) {

		TerminalModel model = terminalModelService
				.getTerminalModel(terminalModelId);
		try {
			if ((model != null) && (model.getPhoto() != null)) {
				int realHeight = 0, realWidth = 0;
				if (width != null) {
					try {
						realWidth = Integer.parseInt(width);
					} catch (NumberFormatException e) {
					}
				}
				if (height != null) {
					try {
						realHeight = Integer.parseInt(height);
					} catch (NumberFormatException e) {
					}
				}

				BufferedImage img = model.getPhotoAsImage(realWidth, realHeight);
				if (img == null) {
					response.sendRedirect("../../list");
				} else {
					BufferedOutputStream output = new BufferedOutputStream(
							response.getOutputStream());
					ImageIO.write(img, "jpg", output);
					output.close();
				}
			} else {
				response.sendRedirect("../../list");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value ="/terminals/export/{queryId}", method = RequestMethod.GET)
	public void downloadResultsCsvForQuery(
			@PathVariable("queryId") Integer queryId,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setContentType("text/csv;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"terminals.csv\"");
			OutputStream resOs = response.getOutputStream();
			OutputStream buffOs = new BufferedOutputStream(resOs);
			OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
			outputwriter.write(Terminal.getCsvHeader());
			List<Terminal> terminals = null;
			if (queryId != null) {
				Query query = queryService.getQuery(queryId);
				if (query != null) {
					logger.debug("Retriving terminals from query ${query.id} for csv export");
					terminals= queryService.executeQuery(query,RequestContextUtils.getLocale(request));
				}
			}
			for (Terminal terminal : terminals) {
				outputwriter.write("\n" + terminal.getCsvDescription());
			}
			outputwriter.flush();
			outputwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value ="/terminals/exportAll", method = RequestMethod.GET)
	public void downloadResultsCsv(
			HttpServletResponse response, HttpServletRequest request, Principal principal) {
		try {
			response.setContentType("text/csv;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"terminals.csv\"");
			OutputStream resOs = response.getOutputStream();
			OutputStream buffOs = new BufferedOutputStream(resOs);
			OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
			outputwriter.write(Terminal.getCsvHeader());
			User loggedUser = userService.getUserByUsername(principal.getName());
			List<Terminal> terminals = null;
			logger.debug ("Exporting to CSV all terminals");
			terminals =
					terminalService.listTerminalsByBankCompanies(loggedUser.getManageableBankCompanies());

			for (Terminal terminal : terminals) {
				outputwriter.write("\n" + terminal.getCsvDescription());
			}
			outputwriter.flush();
			outputwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = { "terminals/installations/new" }, method = RequestMethod.GET)
	public String newInstallationForm(Map<String, Object> map, String matricula) {
		Terminal terminal = null;
		if (matricula != null) {
			try {
				terminal = terminalService.loadTerminalByMatricula(Long.parseLong(matricula));
			} catch (NumberFormatException e) {
			}
		}
		if (terminal == null) {
			return "redirect:/terminals/list";
		}
		map.put("installation", new Installation());
		map.put("locations", locationService.listLocations());
		map.put("locationClasses", Installation.getLocationclasses());
		map.put("matricula", matricula);
		return "terminalInstallation";
	}

	@RequestMapping(value = { "terminals/installations/new" }, method = RequestMethod.POST)
	public String newInstallation(
			@Valid @ModelAttribute("installation") Installation installation,
			BindingResult result, Map<String, Object> map, String matricula,
			HttpServletRequest request, Principal principal) {
		Terminal terminal = null;
		if (matricula != null) {
			try {
				terminal = terminalService.loadTerminalByMatricula(Long.parseLong(matricula));
			} catch (NumberFormatException e) { }
		}
		if (terminal == null) {
			return "redirect:/terminals/list";
		}
		if ((installation.getLocation() != null) && (installation.getLocation().getId() != null)) {
			installation.setLocation(locationService.getLocation(installation.getLocation().getId()));
		}
		
		installationService.addInstallation(installation);
		terminalService.addInstallationAndUpdateHistoricalData(terminal, installation);
		
		map.put("installation", new Installation());
		map.put("locations", locationService.listLocations());
		return "closeIframeUpdateParent";
	}

}
