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
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
	userDAO.updateUser(user);
    }

    @Override
    public void updatePassword(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userDAO.updateUser(user);
    }

    @Override
    public List<User> listUsers() {
	return userDAO.listUsers();
    }

    @Override
    public List<User> listUsersByBankCompanies(Set<BankCompany> banks) {
	return userDAO.listUsersByBankCompanies(banks);
    }

    @Override
    public List<User> listUsersByBankCompany(BankCompany bank) {
	return userDAO.listUsersByBankCompany(bank);
    }

    @Override
    public User getUser(Integer id) {
	return userDAO.getUser(id);
    }

    @Override
    public User getUserByUsername(String username) {
	return userDAO.getUserByUsername(username);
    }

    @Override
    public void removeUser(Integer id) {
	userDAO.removeUser(id);
    }

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