package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class UserDAOImpl implements UserDAO {

    static private Logger logger = Logger
	    .getLogger(UserDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
	sessionFactory.getCurrentSession().save(user);
	logger.info("Created new User with id " + user.getId()
		+ " and username " + user.getUsername());
    }

    @Override
    public void updateUser(User user) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(user));
	logger.info("Updated User with id " + user.getId() + " and username "
		+ user.getUsername());
    }

    @Override
    public List<User> listUsers() {
	return sessionFactory.getCurrentSession().createCriteria(User.class)
		.addOrder(Order.asc("lastname"))
		.addOrder(Order.asc("username")).list();
    }

    @Override
    public List<User> listUsersByBankCompanies(Set<BankCompany> banks) {
	Criterion restriction = (banks.size() > 0) ? Restrictions.or(
		Restrictions.in("bankCompany", banks),
		Restrictions.isNull("bankCompany")) : Restrictions
		.isNull("bankCompany");
	return sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(restriction).addOrder(Order.asc("lastname"))
		.addOrder(Order.asc("username")).list();
    }

    @Override
    public List<User> listUsersByBankCompany(BankCompany bank) {
	return sessionFactory
		.getCurrentSession()
		.createCriteria(User.class)
		.add(Restrictions.or(Restrictions.eq("bankCompany", bank),
			Restrictions.isNull("bankCompany")))
		.addOrder(Order.asc("lastname"))
		.addOrder(Order.asc("username")).list();
    }

    @Override
    public User getUser(Integer id) {
	return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void removeUser(Integer id) {
	User user = (User) sessionFactory.getCurrentSession().load(User.class,
		id);
	if (user != null) {
	    sessionFactory.getCurrentSession().delete(user);
	    logger.info("Deleted User with id " + id + " and username "
		    + user.getUsername());
	}
    }

    @Override
    public User getUserByUsername(String username) {
	User result = (User) sessionFactory.getCurrentSession()
		.createCriteria(User.class)
		.add(Restrictions.eq("username", username)).uniqueResult();
	if (result == null) {
	    logger.error("Requested User with username '" + username
		    + "' was not found");
	    throw new UsernameNotFoundException("User with username '"
		    + username + "' not found");
	}
	return result;
    }
}