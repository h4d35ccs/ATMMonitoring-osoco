package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface UserDAO {

    public void addUser(User user);

    public void updateUser(User user);

    public List<User> listUsersByBankCompanies(Set<BankCompany> bank);

    public List<User> listUsersByBankCompany(BankCompany bank);

    public List<User> listUsers();

    public User getUser(Integer id);

    public void removeUser(Integer id);

    public User getUserByUsername(String username);
}
