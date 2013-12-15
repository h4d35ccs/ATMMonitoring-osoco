.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

XfsComponentDAOImpl
===================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class XfsComponentDAOImpl implements XfsComponentDAO

   The Class XfsComponentDAOImpl.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: @Override public void addXfsComponent(XfsComponent xfsComponent)
   :outertype: XfsComponentDAOImpl

getXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: @Override public XfsComponent getXfsComponent(Integer id)
   :outertype: XfsComponentDAOImpl

listXfsComponents
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<XfsComponent> listXfsComponents()
   :outertype: XfsComponentDAOImpl

