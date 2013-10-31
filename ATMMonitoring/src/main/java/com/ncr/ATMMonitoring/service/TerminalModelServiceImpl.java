package com.ncr.ATMMonitoring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.TerminalModelDAO;
import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class TerminalModelServiceImpl implements TerminalModelService {

    @Autowired
    private TerminalModelDAO terminalModelDAO;

    @Override
    public void addTerminalModel(TerminalModel role) {
	terminalModelDAO.addTerminalModel(role);
    }

    @Override
    public TerminalModel getTerminalModel(Integer id) {
	return terminalModelDAO.getTerminalModel(id);
    }

    @Override
    public List<TerminalModel> listTerminalModels() {
	return terminalModelDAO.listTerminalModels();
    }

    public Map<String, List<TerminalModel>> listTerminalModelsByManufacturer() {
    	Map<String, List<TerminalModel>> data = new HashMap<String, List<TerminalModel>>();
    	List<TerminalModel> terminalModels = terminalModelDAO.listTerminalModels();
    	String manufacturer;
    	for (TerminalModel terminalModel : terminalModels) {
    		manufacturer = terminalModel.getManufacturer();
    		if (manufacturer != null) {
    			if (!data.containsKey(manufacturer)) {
    				data.put(manufacturer, new ArrayList<TerminalModel>());
    			}
				data.get(manufacturer).add(terminalModel);
    		}
    	}
    	data.put("allManufacturers", terminalModels);
    	return data;
    }

    @Override
    public void updateTerminalModel(TerminalModel terminalModel) {
	terminalModelDAO.updateTerminalModel(terminalModel);
    }

    @Override
    public void removeTerminalModel(Integer id) {
	terminalModelDAO.removeTerminalModel(id);
    }
}