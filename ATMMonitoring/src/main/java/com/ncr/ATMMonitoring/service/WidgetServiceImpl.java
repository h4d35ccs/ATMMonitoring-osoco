package com.ncr.ATMMonitoring.service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.pojo.Widget.ChartType;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;
import com.ncr.ATMMonitoring.dao.WidgetDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class WidgetServiceImpl.
 * 
 * Default implementation of the WidgetService.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Service("widgetService")
@Transactional
public class WidgetServiceImpl implements WidgetService {

    /** The logger. */
    static private Logger logger = Logger.getLogger(WidgetServiceImpl.class.getName());

	/** The query service. */
	@Autowired
	private QueryService queryService;

	/** The user service. */
	@Autowired
	private UserService userService;

    /** The widget dao. */
    @Autowired
    private WidgetDAO widgetDAO;

    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.WidgetService#findDefaultWidgets()
     */
    @Override
	public List<Widget> findDefaultWidgets() {
		return widgetDAO.findDefaultWidgets();
	}

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.WidgetService#saveWidget(com.ncr.ATMMonitoring.pojo.Widget)
	 */
	@Override
	public void saveWidget(Widget widget) {
		if (widget.getId() == null) {
			logger.debug("Saving widget " + widget);
			widgetDAO.save(widget);
		} else {
			logger.debug("Updating widget " + widget.getId());
			widgetDAO.update(widget);
		}
	}

	/* (non-Javadoc)
	 * @see com.ncr.ATMMonitoring.service.WidgetService#copyDefaultWidgetsToUserDashboard(com.ncr.ATMMonitoring.pojo.User, com.ncr.ATMMonitoring.pojo.Dashboard)
	 */
	@Override
	public List<Widget> copyDefaultWidgetsToUserDashboard(User user) {
		List<Widget> defaultWidgets = findDefaultWidgets();
		List<Widget> userDefaultWidgets = new ArrayList<Widget> ();
		for (Widget defaultWidget: defaultWidgets) {
			Widget userWidget = copyWidgetToUserDashboard(defaultWidget, user);
			userDefaultWidgets.add(userWidget);
		}
		return userDefaultWidgets;
	}
	
	@Override
	public void deleteWidgetFromUser(Integer widgetId, User user) {
		Widget widget = findWidgetById(widgetId);
		if (isWidgetOwnedByUser(widget, user)) {
			user.getDashboard().getWidgets().remove(widget);
			userService.updateUser(user);
			widgetDAO.delete(widget);
		}
	}
	
	@Override
	public Boolean isWidgetOwnedByUser(Widget widget, User user) {
		return user != null && widget != null && user.equals(widget.getOwner());
	}

	/**
	 * @see com.ncr.ATMMonitoring.service.WidgetService#findWidgetById(int)
	 */
	@Override
	public Widget findWidgetById(int widgetId) {
		return widgetDAO.findById(widgetId);
	}

	/** 
	 * @see com.ncr.ATMMonitoring.service.WidgetService#executeQuery(com.ncr.ATMMonitoring.pojo.Widget, java.util.Locale)
	 */
	@Override
	public List<?> executeQuery(Widget widget, Locale locale) {
		return queryService.executeQueryGroupingBy(
		    widget.getQuery(),
			widget.getGroupByEntity(),
			widget.getGroupBy(),
			locale);
	}

	@Override
	public void createWidgetForUser(Widget widget, User loggedUser) {
		Set<Query> userQueries = loggedUser.getQueries();
		Dashboard dashboard = loggedUser.getDashboard();
		Integer queryId = widget.getQuery().getId(); 
		if(queryId != null) {
			widget.setQuery(queryService.getQuery(queryId));
		}
		
		if (userQueries.contains(widget.getQuery())) {
			widget.setOwner(loggedUser);
			widget.setDashboard(dashboard);
			widget.setOrder(dashboard.getWidgets().size());
			
			this.saveWidget(widget);
		}
	}
	
	@Override 
	public void addWidgetsFromLibrary(List<Integer> widgetIds, User user) {
		for(Integer widgetId : widgetIds) {
			Widget widget = findWidgetById(widgetId);
			if( widget != null && widget.isLibraryWidget()) {
				logger.info("Adding widget from library[" + widgetId + "] to user[" + user.getId() + "]");
				copyWidgetToUserDashboard(widget, user);
			}
		}
	}
	
	@Override 
	public void addOrRemoveWidgetToLibrary(Integer widgetId ,User user, boolean addToLibrary) {
		Widget widget = findWidgetById(widgetId);
		if( isWidgetOwnedByUser(widget, user)) {
			String action = addToLibrary ? "Adding" : "Removing";
			logger.info(action + " widget[" + widgetId + "] to library by user[" + user.getId() + "]");
			widget.setLibraryWidget(addToLibrary);
			widgetDAO.update(widget);
		}
	}
	
	@Override 
	public void setWidgetDefault(Integer widgetId, User user,	boolean isDefault) {
		Widget widget = findWidgetById(widgetId);
		if( isWidgetOwnedByUser(widget, user)) {
			logger.info("widget[" + widgetId + "] is being setted default property as " +  isDefault +
					" by user[" + user.getId() + "]");
			
			widget.setDefaultWidget(isDefault);
			widgetDAO.update(widget);
		}
	}
	
	public List<Widget> findLibraryWidgets() {
		return widgetDAO.findLibraryWidgets();
	}
	
	private Widget copyWidgetToUserDashboard(Widget widgetToCopy, User user) {
		Dashboard dashboard = user.getDashboard();
		Widget userWidget = new Widget(widgetToCopy);
		userWidget.setDefaultWidget(false);
		userWidget.setLibraryWidget(false);
		userWidget.setOwner(user);
		userWidget.setDashboard(dashboard);
		saveWidget(userWidget);
		
		return userWidget;
	}
}
