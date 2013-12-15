.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Role

RoleService
===========

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface RoleService

   The Interface RoleService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addRole
^^^^^^^

.. java:method:: public void addRole(Role role)
   :outertype: RoleService

   Adds the role.

   :param role: the role

getRole
^^^^^^^

.. java:method:: public Role getRole(Integer id)
   :outertype: RoleService

   Gets the role.

   :param id: the id
   :return: the role

listManageableRoles
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Role> listManageableRoles()
   :outertype: RoleService

   List manageable roles.

   :return: the list

listRoles
^^^^^^^^^

.. java:method:: public List<Role> listRoles()
   :outertype: RoleService

   List roles.

   :return: the list

removeRole
^^^^^^^^^^

.. java:method:: public void removeRole(Integer id)
   :outertype: RoleService

   Removes the role.

   :param id: the id

