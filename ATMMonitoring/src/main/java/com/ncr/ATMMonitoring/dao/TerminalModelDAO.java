package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalModelDAO {

    public void addTerminalModel(TerminalModel terminalModel);

    public TerminalModel getTerminalModel(Integer id);

    public TerminalModel getTerminalModelByModel(String model);

    public TerminalModel getTerminalModelByProductClass(String productClass);

    public List<TerminalModel> listTerminalModels();

    public void updateTerminalModel(TerminalModel terminalModel);

    public void removeTerminalModel(Integer id);
}
