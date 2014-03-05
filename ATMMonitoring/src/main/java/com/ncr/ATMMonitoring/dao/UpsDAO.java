/**
 * 
 */
package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ncr.ATMMonitoring.pojo.Ups;

/**
 * The Interface UpsDAO.
 * 
 * Dao with the operations for managing Ups Pojos.
 * 
 * @author Otto Abreu
 * 
 */
public interface UpsDAO {

    /**
     * Returns the UPS that matches the given id
     * 
     * @param id
     *            the id of the UPS we want to retrieve
     */
    public Ups getUps(int id);

    /**
     * Removes from the DB the UPS that matches with the given id
     * 
     * @param id
     *            the id of the UPS we want to delete
     */
    public void removeUps(int id);

    /**
     * Updates the data of an UPS
     * 
     * @param ups
     *            the UPS to update
     */
    public void updateUps(Ups ups);

    /**
     * Returns all the ups from the DB
     * 
     * @return a list with all the UPS stored
     */
    public List<Ups> listAllUps();

    /**
     * Adds a new Ups to the database
     * 
     * @param ups
     *            the UPS to add
     */
    public void addUps(Ups ups);

    /**
     * Returns the ups that matches the given criterions. To add a criterion
     * please use {@link Restrictions} or another class that implement
     * {@link Criterion}
     * 
     * @param criterions
     *            {@link Criterion}
     * @return List<Ups>
     */
    public List<Ups> listUps(Criterion... criterions);

    /**
     * Returns a Ups by the given series number
     * 
     * @param seriesNumber
     *            the series number to search for
     * @return the UPS that matches the given parameters, or null if it can't be
     *         found
     */
    public Ups getUpsBySerialNumber(String seriesNumber);

    /**
     * 
     * Returns a Ups by the given series number and model
     * 
     * @param seriesNumber
     *            the series number to search for
     * @param model
     *            the model to search for
     * 
     * @return the UPS that matches the given parameters, or null if it can't be
     *         found
     */
    public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model);

}
