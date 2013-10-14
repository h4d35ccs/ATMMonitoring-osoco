package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.InternetExplorerDAO;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("internetExplorerService")
@Transactional
public class InternetExplorerServiceImpl implements InternetExplorerService {

    @Autowired
    private InternetExplorerDAO internetExplorerDAO;

    @Override
    public void addInternetExplorer(InternetExplorer internetExplorer) {
	internetExplorerDAO.addInternetExplorer(internetExplorer);
    }

    @Override
    public List<InternetExplorer> listInternetExplorer() {
	return internetExplorerDAO.listInternetExplorer();
    }

    @Override
    public InternetExplorer getInternetExplorer(Integer id) {
	return internetExplorerDAO.getInternetExplorer(id);
    }

    @Override
    public void removeInternetExplorer(Integer id) {
	internetExplorerDAO.removeInternetExplorer(id);
    }

    @Override
    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion) {
	return internetExplorerDAO.getInternetExplorerByVersion(majorVersion,
		minorVersion, buildVersion, revisionVersion, remainingVersion);
    }
}