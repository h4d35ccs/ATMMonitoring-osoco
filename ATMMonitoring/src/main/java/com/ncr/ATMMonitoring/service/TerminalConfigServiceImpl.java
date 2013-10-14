package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.TerminalConfigDAO;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("terminalConfigService")
@Transactional
public class TerminalConfigServiceImpl implements TerminalConfigService {

    @Autowired
    private TerminalConfigDAO terminalConfigDAO;

    @Override
    public void addTerminalConfig(TerminalConfig terminalConfig) {
	terminalConfigDAO.addTerminalConfig(terminalConfig);
    }

    @Override
    public List<TerminalConfig> listTerminalConfig() {
	return terminalConfigDAO.listTerminalConfig();
    }

    @Override
    public TerminalConfig getTerminalConfig(Integer id) {
	return terminalConfigDAO.getTerminalConfig(id);
    }
}