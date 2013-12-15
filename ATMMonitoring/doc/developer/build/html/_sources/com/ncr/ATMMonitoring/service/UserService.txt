.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.springframework.security.core.userdetails UserDetailsService

.. java:import:: org.springframework.security.core.userdetails UsernameNotFoundException

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.User

UserService
===========

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface UserService extends UserDetailsService

   The Interface UserService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addUser
^^^^^^^

.. java:method:: public void addUser(User user)
   :outertype: UserService

   Adds the user.

   :param user: the user

getUser
^^^^^^^

.. java:method:: public User getUser(Integer id)
   :outertype: UserService

   Gets the user.

   :param id: the id
   :return: the user

getUserByUsername
^^^^^^^^^^^^^^^^^

.. java:method:: public User getUserByUsername(String username)
   :outertype: UserService

   Gets the user by username.

   :param username: the username
   :return: the user by username

listUsers
^^^^^^^^^

.. java:method:: public List<User> listUsers()
   :outertype: UserService

   List users.

   :return: the list

listUsersByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<User> listUsersByBankCompanies(Set<BankCompany> banks)
   :outertype: UserService

   List users by bank companies.

   :param banks: the banks
   :return: the list

listUsersByBankCompany
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<User> listUsersByBankCompany(BankCompany bank)
   :outertype: UserService

   List users by bank company.

   :param bank: the bank
   :return: the list

loadUserByUsername
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public User loadUserByUsername(String username) throws UsernameNotFoundException
   :outertype: UserService

removeUser
^^^^^^^^^^

.. java:method:: public void removeUser(Integer id)
   :outertype: UserService

   Removes the user.

   :param id: the id

updatePassword
^^^^^^^^^^^^^^

.. java:method:: public void updatePassword(User user)
   :outertype: UserService

   Update password.

   :param user: the user

updateUser
^^^^^^^^^^

.. java:method:: public void updateUser(User user)
   :outertype: UserService

   Update user.

   :param user: the user

