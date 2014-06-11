package com.ncr.ATMMonitoring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncr.ATMMonitoring.serverchain.ServerChainService;

/**
 * Controller in charge of showing the network map in serverchain And to provide
 * the actions allowed in the interface
 * 
 * @author Otto Abreu
 * 
 */
@Controller
public class NetworkMapController extends GenericController {

    @Autowired
    private ServerChainService serverChainService;

    static private Logger logger = Logger.getLogger(NetworkMapController.class);

    @RequestMapping(value = "/serverchain")
    public String showNetworkMapping() {

	return "networkMap";

    }

    @RequestMapping(value = "/serverchain/networkmap", method = RequestMethod.GET)
    @ResponseBody
    public Object getNetworkMapping() {
	String jsonNetworkMap = this.serverChainService.getNetworkJSON();
	return jsonNetworkMap;
    }

    @RequestMapping(value = "/serverchain/forceMapping", method = RequestMethod.GET)
    public ResponseEntity<String> forceMapping() {

	this.serverChainService.requestNetworkMapping();

	return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/serverchain/editroutertable", method = RequestMethod.POST)
    public ResponseEntity<String> editRouterTable(
	    @RequestParam MultiValueMap<String, String> params,
	    @RequestParam("addresseeNode") String addresseeNode) {

	Map<String, String> matriculaAndIp = this
		.extractValuesFromRequestParam(params, addresseeNode);

	this.serverChainService.editRouterTable(addresseeNode, matriculaAndIp);
	return new ResponseEntity<String>(HttpStatus.OK);
    }

    private Map<String, String> extractValuesFromRequestParam(
	    MultiValueMap<String, String> params, String addresseeNode) {

	Map<String, String> matriculaAndIp = new HashMap<String, String>();
	Set<Entry<String, List<String>>> entrySet = params.entrySet();

	for (Entry<String, List<String>> keyValue : entrySet) {
	   
	    if (!keyValue.getKey().equals("addresseeNode")
		    && StringUtils.isNotEmpty(keyValue.getKey())) {

		String matricula = keyValue.getValue().get(0);
		matriculaAndIp.put(matricula, addresseeNode);
	    }
	}
	
	return matriculaAndIp;
    }
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex,
	    HttpServletResponse response) {
	logger.error("error in serverchain:", ex);
	return new ResponseEntity<String>(ex.getMessage(),
		HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
