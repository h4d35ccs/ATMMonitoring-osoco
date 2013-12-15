.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

XfsComponentService
===================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface XfsComponentService

   The Interface XfsComponentService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public void addJxfsComponent(JxfsComponent jxfsComponent)
   :outertype: XfsComponentService

   Adds the jxfs component.

   :param jxfsComponent: the jxfs component

addXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public void addXfsComponent(XfsComponent xfsComponent)
   :outertype: XfsComponentService

   Adds the xfs component.

   :param xfsComponent: the xfs component

getJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public JxfsComponent getJxfsComponent(Integer id)
   :outertype: XfsComponentService

   Gets the jxfs component.

   :param id: the id
   :return: the jxfs component

getXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public XfsComponent getXfsComponent(Integer id)
   :outertype: XfsComponentService

   Gets the xfs component.

   :param id: the id
   :return: the xfs component

listJxfsComponents
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<JxfsComponent> listJxfsComponents()
   :outertype: XfsComponentService

   List jxfs components.

   :return: the list

listXfsComponents
^^^^^^^^^^^^^^^^^

.. java:method:: public List<XfsComponent> listXfsComponents()
   :outertype: XfsComponentService

   List xfs components.

   :return: the list

