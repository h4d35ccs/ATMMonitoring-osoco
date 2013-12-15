.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

JxfsComponentDAO
================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface JxfsComponentDAO

   The Interface JxfsComponentDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public void addJxfsComponent(JxfsComponent jxfsComponent)
   :outertype: JxfsComponentDAO

   Adds the jxfs component.

   :param jxfsComponent: the jxfs component

getJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public JxfsComponent getJxfsComponent(Integer id)
   :outertype: JxfsComponentDAO

   Gets the jxfs component.

   :param id: the id
   :return: the jxfs component

listJxfsComponents
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<JxfsComponent> listJxfsComponents()
   :outertype: JxfsComponentDAO

   List jxfs components.

   :return: the list

