package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Map;

import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalModelService {

    public void addTerminalModel(TerminalModel terminalModel);

    public TerminalModel getTerminalModel(Integer id);

    public TerminalModel getTerminalModelByModel(String model);

    public List<TerminalModel> listTerminalModels();

    public Map<String, List<TerminalModel>> listTerminalModelsByManufacturer();

    public void updateTerminalModel(TerminalModel terminalModel);

    public void removeTerminalModel(Integer id);
}