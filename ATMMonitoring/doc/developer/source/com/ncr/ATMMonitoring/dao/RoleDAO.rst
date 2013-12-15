.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Role

RoleDAO
=======

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface RoleDAO

   The Interface RoleDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addRole
^^^^^^^

.. java:method:: public void addRole(Role role)
   :outertype: RoleDAO

   Adds the role.

   :param role: the role

getRole
^^^^^^^

.. java:method:: public Role getRole(Integer id)
   :outertype: RoleDAO

   Gets the role.

   :param id: the id
   :return: the role

listManageableRoles
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Role> listManageableRoles()
   :outertype: RoleDAO

   List manageable roles.

   :return: the list

listRoles
^^^^^^^^^

.. java:method:: public List<Role> listRoles()
   :outertype: RoleDAO

   List roles.

   :return: the list

removeRole
^^^^^^^^^^

.. java:method:: public void removeRole(Integer id)
   :outertype: RoleDAO

   Removes the role.

   :param id: the id

