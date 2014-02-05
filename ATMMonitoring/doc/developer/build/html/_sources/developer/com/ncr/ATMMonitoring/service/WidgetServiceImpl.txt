.. java:import:: org.apache.log4j Logger

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.pojo.Widget.ChartType

.. java:import:: com.ncr ATMMonitoring.dao.WidgetDAO

WidgetServiceImpl
=================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class WidgetServiceImpl implements WidgetService

   The Class WidgetServiceImpl. Default implementation of the WidgetService.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
buildDefaultWidgets
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void buildDefaultWidgets()
   :outertype: WidgetServiceImpl

copyDefaultWidgetsToUserDashboard
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Widget> copyDefaultWidgetsToUserDashboard(User user, Dashboard dashboard)
   :outertype: WidgetServiceImpl

executeQuery
^^^^^^^^^^^^

.. java:method:: @Override public List executeQuery(Widget widget, Locale locale)
   :outertype: WidgetServiceImpl

findDefaultWidgets
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Widget> findDefaultWidgets()
   :outertype: WidgetServiceImpl

findWidgetById
^^^^^^^^^^^^^^

.. java:method:: @Override public Widget findWidgetById(int widgetId)
   :outertype: WidgetServiceImpl

saveWidget
^^^^^^^^^^

.. java:method:: @Override public void saveWidget(Widget widget)
   :outertype: WidgetServiceImpl

