.. java:import:: java.util Collections

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

.. java:import:: com.ncr ATMMonitoring.service.DashboardService

.. java:import:: com.ncr ATMMonitoring.service.UserService

.. java:import:: com.ncr ATMMonitoring.service.WidgetCategoryService

.. java:import:: com.ncr ATMMonitoring.service.WidgetService

.. java:import:: com.ncr ATMMonitoring.serviceFacade.DashboardWidgetFacade

DashboardWidgetFacadeImp
========================

.. java:package:: com.ncr.ATMMonitoring.serviceFacade.imp
   :noindex:

.. java:type:: @Service public class DashboardWidgetFacadeImp implements DashboardWidgetFacade

   :author: Otto Abreu

Methods
-------
addOrRemoveWidgetToLibrary
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addOrRemoveWidgetToLibrary(int widgetId, String username, int categoryId)
   :outertype: DashboardWidgetFacadeImp

addWidgetToUser
^^^^^^^^^^^^^^^

.. java:method:: @Override public void addWidgetToUser(String username, Widget widget, List<Integer> widgetsId)
   :outertype: DashboardWidgetFacadeImp

changeDashboardColumms
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void changeDashboardColumms(String username, int columns)
   :outertype: DashboardWidgetFacadeImp

executeQueryForWidget
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<?> executeQueryForWidget(String username, int widgetId, Locale locale)
   :outertype: DashboardWidgetFacadeImp

findAllCategoryWidgets
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<WidgetCategory> findAllCategoryWidgets(boolean fetchType)
   :outertype: DashboardWidgetFacadeImp

getDashboard
^^^^^^^^^^^^

.. java:method:: @Override public Dashboard getDashboard(String username)
   :outertype: DashboardWidgetFacadeImp

getVisiblesAndInvisiblesWidgets
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<String, List<Widget>> getVisiblesAndInvisiblesWidgets(String username)
   :outertype: DashboardWidgetFacadeImp

getWidget
^^^^^^^^^

.. java:method:: @Override public Widget getWidget(int widgetId)
   :outertype: DashboardWidgetFacadeImp

hideShowWidget
^^^^^^^^^^^^^^

.. java:method:: @Override public void hideShowWidget(int widgetId, String username, boolean hideShow)
   :outertype: DashboardWidgetFacadeImp

removeWidgetFromUser
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeWidgetFromUser(int widgetId, String username)
   :outertype: DashboardWidgetFacadeImp

updateWidgetDefaultStatus
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateWidgetDefaultStatus(int widgetId, String username, boolean setAsDefault)
   :outertype: DashboardWidgetFacadeImp

updateWidgetPosition
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateWidgetPosition(String username, int widgetId, int oldPosition, int newPosition)
   :outertype: DashboardWidgetFacadeImp

userHasWidget
^^^^^^^^^^^^^

.. java:method:: @Override public boolean userHasWidget(int widgetId, String username)
   :outertype: DashboardWidgetFacadeImp

userHasWidget
^^^^^^^^^^^^^

.. java:method:: @Override public boolean userHasWidget(Widget widget, String username)
   :outertype: DashboardWidgetFacadeImp

