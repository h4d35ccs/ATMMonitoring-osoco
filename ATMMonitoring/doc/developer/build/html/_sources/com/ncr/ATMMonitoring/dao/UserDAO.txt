.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.User

UserDAO
=======

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface UserDAO

   The Interface UserDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addUser
^^^^^^^

.. java:method:: public void addUser(User user)
   :outertype: UserDAO

   Adds the user.

   :param user: the user

getUser
^^^^^^^

.. java:method:: public User getUser(Integer id)
   :outertype: UserDAO

   Gets the user.

   :param id: the id
   :return: the user

getUserByUsername
^^^^^^^^^^^^^^^^^

.. java:method:: public User getUserByUsername(String username)
   :outertype: UserDAO

   Gets the user by username.

   :param username: the username
   :return: the user by username

listUsers
^^^^^^^^^

.. java:method:: public List<User> listUsers()
   :outertype: UserDAO

   List users.

   :return: the list

listUsersByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<User> listUsersByBankCompanies(Set<BankCompany> bank)
   :outertype: UserDAO

   List users by bank companies.

   :param bank: the bank
   :return: the list

listUsersByBankCompany
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<User> listUsersByBankCompany(BankCompany bank)
   :outertype: UserDAO

   List users by bank company.

   :param bank: the bank
   :return: the list

removeUser
^^^^^^^^^^

.. java:method:: public void removeUser(Integer id)
   :outertype: UserDAO

   Removes the user.

   :param id: the id

updateUser
^^^^^^^^^^

.. java:method:: public void updateUser(User user)
   :outertype: UserDAO

   Update user.

   :param user: the user

