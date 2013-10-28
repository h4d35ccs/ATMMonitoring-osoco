package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface UserService extends UserDetailsService {

    public void addUser(User user);

    public void updateUser(User user);

    public void updatePassword(User user);

    public User getUser(Integer id);

    public User getUserByUsername(String username);

    public List<User> listUsers();

    public List<User> listUsersByBankCompany(BankCompany bank);

    public List<User> listUsersByBankCompanies(Set<BankCompany> banks);

    public void removeUser(Integer id);

    @Override
    public User loadUserByUsername(String username)
	    throws UsernameNotFoundException;
}