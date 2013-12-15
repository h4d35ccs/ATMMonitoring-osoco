.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

XfsComponentDAO
===============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface XfsComponentDAO

   The Interface XfsComponentDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public void addXfsComponent(XfsComponent xfsComponent)
   :outertype: XfsComponentDAO

   Adds the xfs component.

   :param xfsComponent: the xfs component

getXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public XfsComponent getXfsComponent(Integer id)
   :outertype: XfsComponentDAO

   Gets the xfs component.

   :param id: the id
   :return: the xfs component

listXfsComponents
^^^^^^^^^^^^^^^^^

.. java:method:: public List<XfsComponent> listXfsComponents()
   :outertype: XfsComponentDAO

   List xfs components.

   :return: the list

