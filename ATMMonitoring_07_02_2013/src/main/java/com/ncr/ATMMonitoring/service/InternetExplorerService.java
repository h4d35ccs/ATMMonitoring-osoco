package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InternetExplorerService {

    public void addInternetExplorer(InternetExplorer internetExplorer);

    public void removeInternetExplorer(Integer id);

    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion);

    public InternetExplorer getInternetExplorer(Integer id);

    public List<InternetExplorer> listInternetExplorer();
}