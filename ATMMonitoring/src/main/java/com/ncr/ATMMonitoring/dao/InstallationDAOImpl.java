package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Installation;

// TODO: Auto-generated Javadoc
/**
 * The Class InstallationDAOImpl.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class InstallationDAOImpl extends AbstractGenericDAO<Installation>
	implements InstallationDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(InstallationDAOImpl.class
	    .getName());

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.InstallationDAO#addInstallation(com.ncr.ATMMonitoring.pojo.Installation)
     */
    @Override
    public void addInstallation(Installation installation) {
	add(installation);
	logger.debug("Created new Installation with id " + installation.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.InstallationDAO#getInstallation(java.lang.Integer)
     */
    @Override
    public Installation getInstallation(Integer id) {
	return get(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.InstallationDAO#listInstallations()
     */
    @Override
    public List<Installation> listInstallations() {
	return list();
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.InstallationDAO#updateInstallation(com.ncr.ATMMonitoring.pojo.Installation)
     */
    @Override
    public void updateInstallation(Installation installation) {
	update(installation);
	logger.info("Updated Installation with id " + installation.getId());
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.dao.InstallationDAO#removeInstallation(java.lang.Integer)
     */
    @Override
    public void removeInstallation(Integer id) {
	delete(id);
    }
}