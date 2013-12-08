package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 *
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface UserDAO {

    /**
     * Adds the user.
     *
     * @param user the user
     */
    public void addUser(User user);

    /**
     * Update user.
     *
     * @param user the user
     */
    public void updateUser(User user);

    /**
     * List users by bank companies.
     *
     * @param bank the bank
     * @return the list
     */
    public List<User> listUsersByBankCompanies(Set<BankCompany> bank);

    /**
     * List users by bank company.
     *
     * @param bank the bank
     * @return the list
     */
    public List<User> listUsersByBankCompany(BankCompany bank);

    /**
     * List users.
     *
     * @return the list
     */
    public List<User> listUsers();

    /**
     * Gets the user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(Integer id);

    /**
     * Removes the user.
     *
     * @param id the id
     */
    public void removeUser(Integer id);

    /**
     * Gets the user by username.
     *
     * @param username the username
     * @return the user by username
     */
    public User getUserByUsername(String username);
}
