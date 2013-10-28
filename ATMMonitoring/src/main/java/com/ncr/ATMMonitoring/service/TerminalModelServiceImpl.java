package com.ncr.ATMMonitoring.service;

import java.util.List;

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

    @Override
    public void updateTerminalModel(TerminalModel terminalModel) {
	terminalModelDAO.updateTerminalModel(terminalModel);
    }

    @Override
    public void removeTerminalModel(Integer id) {
	terminalModelDAO.removeTerminalModel(id);
    }
}