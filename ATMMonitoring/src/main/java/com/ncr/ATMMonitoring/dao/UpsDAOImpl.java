/**
 * 
 */
package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Ups;

/**
 * The Class UpsDAOImpl.
 * 
 * Default implementation of UpsDAO.
 * 
 * @author Otto Abreu
 * 
 */
@Repository
public class UpsDAOImpl extends AbstractGenericDAO<Ups> implements UpsDAO {

    /** The logger. */
    private static final Logger logger = Logger.getLogger(UpsDAOImpl.class);

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#getUps(int)
     */
    public Ups getUps(int id) {
	return this.get(id);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#getUpsBySerialNumber(java.lang.String)
     */
    @Override
    public Ups getUpsBySerialNumber(String seriesNumber) {

	// Ups ups = null;
	logger.debug("series number: " + seriesNumber);
	Ups ups = this.getOnlyOneResultFromList(Restrictions.eq("seriesNumber",
		seriesNumber));
	// List<Ups> fetch = this.listUps(Restrictions.eq("seriesNumber",
	// seriesNumber));
	// if (fetch != null && !fetch.isEmpty()) {
	//
	// ups = fetch.get(0);
	//
	// }

	return ups;
    }

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#removeUps(int)
     */
    public void removeUps(int id) {
	this.delete(id);
    }

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#updateUps(com.ncr.ATMMonitoring.pojo
     * .Ups)
     */
    public void updateUps(Ups ups) {
	this.update(ups);

    }

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#listAllUps()
     */
    public List<Ups> listAllUps() {
	return this.list();
    }

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#addUps(com.ncr.ATMMonitoring.pojo.Ups)
     */
    public void addUps(Ups ups) {
	this.add(ups);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#listUps(org.hibernate.criterion.Criterion
     * [])
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Ups> listUps(Criterion... criterions) {
	Criteria crit = sessionFactory.getCurrentSession().createCriteria(
		Ups.class);
	for (Criterion rest : criterions) {
	    crit.add(rest);
	}
	return (List<Ups>) crit.list();
    }

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#getUpsBySerialNumberAndModel(java.lang
     * .String, java.lang.String)
     */
    public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model) {

	logger.debug("Get UPS by series number: " + seriesNumber + " model: "
		+ model);
	Ups ups = this.getOnlyOneResultFromList(Restrictions.and(
		Restrictions.eq("seriesNumber", seriesNumber),
		Restrictions.eq("model", model)));
	// List<Ups> fetch =
	// this.listUps(Restrictions.and(Restrictions.eq("seriesNumber",
	// seriesNumber),Restrictions.eq("model",
	// model)));
	// if (fetch != null && !fetch.isEmpty()) {
	//
	// ups = fetch.get(0);
	//
	// }
	//
	return ups;
    }

    /**
     * Executes the method {@link UpsDAO#listUps(Criterion...)} applying the
     * given Criterion for fetching only one result
     * 
     * @param criteria
     *            Criterion
     * @return Ups
     */
    private Ups getOnlyOneResultFromList(Criterion criteria) {
	Ups ups = null;

	List<Ups> fetch = this.listUps(criteria);
	if (fetch != null && !fetch.isEmpty()) {

	    ups = fetch.get(0);

	}

	return ups;
    }
}
