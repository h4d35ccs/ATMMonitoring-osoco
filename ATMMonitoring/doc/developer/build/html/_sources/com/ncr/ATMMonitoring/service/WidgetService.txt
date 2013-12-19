.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

WidgetService
=============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface WidgetService

   The Interface WidgetService. It contains the widget related methods.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
buildDefaultWidgets
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void buildDefaultWidgets()
   :outertype: WidgetService

   Builds the default widgets.

copyDefaultWidgetsToUserDashboard
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Widget> copyDefaultWidgetsToUserDashboard(User user, Dashboard dashboard)
   :outertype: WidgetService

   Copy default widgets to user dashboard.

   :param user: the user
   :param dashboard: the dashboard
   :return: the list

executeQuery
^^^^^^^^^^^^

.. java:method:: public List executeQuery(Widget widget, Locale locale)
   :outertype: WidgetService

   Execute query.

   :param widget: the widget
   :param locale: the locale
   :return: the list

findDefaultWidgets
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Widget> findDefaultWidgets()
   :outertype: WidgetService

   Find default widgets.

   :return: the list

findWidgetById
^^^^^^^^^^^^^^

.. java:method:: public Widget findWidgetById(int widgetId)
   :outertype: WidgetService

   Find widget by id.

   :param widgetId: the widget id
   :return: the widget

saveWidget
^^^^^^^^^^

.. java:method:: public void saveWidget(Widget widget)
   :outertype: WidgetService

   Save widget.

   :param widget: the widget

