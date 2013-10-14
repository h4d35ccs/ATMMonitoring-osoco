package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InternetExplorerDAO {

    public void addInternetExplorer(InternetExplorer internetExplorer);

    public List<InternetExplorer> listInternetExplorer();

    public InternetExplorer getInternetExplorer(Integer id);

    public void removeInternetExplorer(Integer id);

    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion);
}
