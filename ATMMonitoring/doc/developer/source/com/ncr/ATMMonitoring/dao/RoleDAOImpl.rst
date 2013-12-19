.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Role

RoleDAOImpl
===========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class RoleDAOImpl extends AbstractGenericDAO<Role> implements RoleDAO

   The Class RoleDAOImpl. Default implementation of RoleDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addRole
^^^^^^^

.. java:method:: @Override public void addRole(Role role)
   :outertype: RoleDAOImpl

getRole
^^^^^^^

.. java:method:: @Override public Role getRole(Integer id)
   :outertype: RoleDAOImpl

listManageableRoles
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Role> listManageableRoles()
   :outertype: RoleDAOImpl

listRoles
^^^^^^^^^

.. java:method:: @Override public List<Role> listRoles()
   :outertype: RoleDAOImpl

removeRole
^^^^^^^^^^

.. java:method:: @Override public void removeRole(Integer id)
   :outertype: RoleDAOImpl

