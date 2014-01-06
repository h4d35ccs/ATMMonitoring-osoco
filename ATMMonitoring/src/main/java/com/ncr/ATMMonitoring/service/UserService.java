package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * The Interface UserService.
 * 
 * It contains the user related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface UserService extends UserDetailsService {

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
     * Update password.
     *
     * @param user the user
     */
    public void updatePassword(User user);

    /**
     * Gets the user by its id.
     * 
     * @param id
     *            the user id
     * @return the user
     */
    public User getUser(Integer id);

    /**
     * Gets the user by username.
     *
     * @param username the username
     * @return the user by username
     */
    public User getUserByUsername(String username);

    /**
     * List users with the default sorting.
     * 
     * @return the user list
     */
    public List<User> listUsers();

    /**
     * List sorted users.
     * 
     * @param sort
     *            the sort
     * @param order
     *            the order
     * 
     * @return the user list
     */
    public List<User> listUsers(String sort, String order);

    /**
     * List users by bank company.
     * 
     * @param bank
     *            the bank company
     * @return the user list
     */
    public List<User> listUsersByBankCompany(BankCompany bank);

    /**
     * List users by bank companies.
     * 
     * @param banks
     *            the bank companies
     * @return the user list
     */
    public List<User> listUsersByBankCompanies(Set<BankCompany> banks);

    /**
     * Removes the user by its id.
     * 
     * @param id
     *            the user id
     */
    public void removeUser(Integer id);

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public User loadUserByUsername(String username)
	    throws UsernameNotFoundException;
}