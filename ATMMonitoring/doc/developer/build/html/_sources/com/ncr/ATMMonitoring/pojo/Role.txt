.. java:import:: java.io Serializable

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

Role
====

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Role implements Serializable

   The Class Role.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Role

   Gets the id.

   :return: the id

getManageable
^^^^^^^^^^^^^

.. java:method:: public Boolean getManageable()
   :outertype: Role

   Gets the manageable.

   :return: the manageable

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: Role

   Gets the name.

   :return: the name

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Role

   Sets the id.

   :param id: the id to set

setManageable
^^^^^^^^^^^^^

.. java:method:: public void setManageable(Boolean manageable)
   :outertype: Role

   Sets the manageable.

   :param manageable: the manageable to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: Role

   Sets the name.

   :param name: the name to set

