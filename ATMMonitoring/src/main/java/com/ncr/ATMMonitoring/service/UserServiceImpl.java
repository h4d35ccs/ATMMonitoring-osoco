package com.ncr.ATMMonitoring.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.UserDAO;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * The Class UserServiceImpl.
 * 
 * Default implementation of the UserService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    /** The user dao. */
    @Autowired
    private UserDAO userDAO;
    
    /** The password encoder. */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#addUser(com.ncr.ATMMonitoring.pojo.User)
     */
    @Override
    public void addUser(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userDAO.addUser(user);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#updateUser(com.ncr.ATMMonitoring.pojo.User)
     */
    @Override
    public void updateUser(User user) {
	userDAO.updateUser(user);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#updatePassword(com.ncr.ATMMonitoring.pojo.User)
     */
    @Override
    public void updatePassword(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userDAO.updateUser(user);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#listUsers()
     */
    @Override
    public List<User> listUsers() {
	return userDAO.listUsers();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#listUsers(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<User> listUsers(String sort, String order) {
	return userDAO.listUsers(sort, order);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#listUsersByBankCompanies(java
     * .util.Set)
     */
    @Override
    public List<User> listUsersByBankCompanies(Set<BankCompany> banks) {
	return userDAO.listUsersByBankCompanies(banks);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#listUsersByBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public List<User> listUsersByBankCompany(BankCompany bank) {
	return userDAO.listUsersByBankCompany(bank);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#getUser(java.lang.Integer)
     */
    @Override
    public User getUser(Integer id) {
	return userDAO.getUser(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#getUserByUsername(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true)
    public User getUserByUsername(String username) {
	return userDAO.getUserByUsername(username);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#removeUser(java.lang.Integer)
     */
    @Override
    public void removeUser(Integer id) {
	userDAO.removeUser(id);
    }

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.UserService#loadUserByUsername(java.lang.String)
     */
    @Override
    public User loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	User user = userDAO.getUserByUsername(username);
	if (user != null) {
	    user.setLastLogin(new Date());
	    userDAO.updateUser(user);
	}
	return user;
    }
}
