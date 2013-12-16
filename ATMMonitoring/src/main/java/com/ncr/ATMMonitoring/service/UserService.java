package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
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
     * Gets the user.
     *
     * @param id the id
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
     * List users.
     *
     * @return the list
     */
    public List<User> listUsers();

    /**
     * List users by bank company.
     *
     * @param bank the bank
     * @return the list
     */
    public List<User> listUsersByBankCompany(BankCompany bank);

    /**
     * List users by bank companies.
     *
     * @param banks the banks
     * @return the list
     */
    public List<User> listUsersByBankCompanies(Set<BankCompany> banks);

    /**
     * Removes the user.
     *
     * @param id the id
     */
    public void removeUser(Integer id);

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public User loadUserByUsername(String username)
	    throws UsernameNotFoundException;
}