package com.ncr.ATMMonitoring.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

// TODO: Auto-generated Javadoc
/**
 * The Class Widget.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Entity
@Table(name = "widget")
public class Widget {

	/** The id. */
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "widgets_id_seq")
    @SequenceGenerator(name = "widgets_id_seq", sequenceName = "widgets_id_seq", allocationSize = 1)
    private Integer id;

    /** The order. */
    @Column(name = "widget_idx", nullable = false)
	private Integer order;

    /** The title. */
    @Column(name = "title", nullable = false, length = 50)
	private String title;

    /** The default widget. */
    @Column(name = "default_widget", nullable = false)
	private boolean defaultWidget = false;

    /** The visible. */
    @Column(name = "visible", nullable = false)
	private boolean visible = true;

	/** The owner. */
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private User owner;

	/** The query. */
	@ManyToOne
	@JoinColumn(name = "query_id", nullable = false)
	private Query query;

	/** The dashboard. */
	@ManyToOne
	@JoinColumn(name = "dashboard_id", nullable = true)
    private Dashboard dashboard;

	/** The group by. */
	@Column(name = "groupByField", nullable = false)
	private String groupBy;

	/** The group by entity. */
	@Column(name = "groupByEntity", nullable = true)
	private String groupByEntity;

	/** The chart type. */
	@Column(name = "chart_type", nullable = false)
	private ChartType chartType;

	/**
	 * Instantiates a new widget.
	 */
	public Widget() {
	}

	/**
	 * Instantiates a new widget.
	 *
	 * @param source the source
	 */
	public Widget(Widget source) {
		this.title = source.getTitle();
		this.order = source.getOrder();
		this.defaultWidget = source.isDefaultWidget();
		this.visible = source.isVisible();
		this.owner = source.getOwner();
		this.query = source.getQuery();
		this.groupBy = source.getGroupBy();
		this.groupByEntity = source.getGroupByEntity();
		this.chartType = source.getChartType();
	}

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
		return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
		this.id = id;
    }

    /**
     * Gets the order.
     *
     * @return the order
     */
    public Integer getOrder() {
		return order;
    }

    /**
     * Sets the order.
     *
     * @param order the new order
     */
    public void setOrder(Integer order) {
		this.order = order;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
		return this.title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
		this.title = title;
    }

	/**
	 * Checks if is default widget.
	 *
	 * @return true, if is default widget
	 */
	public boolean isDefaultWidget() {
		return defaultWidget;
	}

	/**
	 * Sets the default widget.
	 *
	 * @param defaultWidget the new default widget
	 */
	public void setDefaultWidget(boolean defaultWidget) {
		this.defaultWidget = defaultWidget;
	}

	/**
	 * Checks if is visible.
	 *
	 * @return true, if is visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Sets the visible.
	 *
	 * @param visible the new visible
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

    /**
     * Gets the owner.
     *
     * @return the owner
     */
    public User getOwner() {
		return owner;
    }

    /**
     * Sets the owner.
     *
     * @param owner the new owner
     */
    public void setOwner(User owner) {
		this.owner = owner;
    }

    /**
     * Gets the group by.
     *
     * @return the group by
     */
    public String getGroupBy() {
		return groupBy;
    }

    /**
     * Sets the group by.
     *
     * @param groupBy the new group by
     */
    public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
    }

    /**
     * Gets the group by entity.
     *
     * @return the group by entity
     */
    public String getGroupByEntity() {
		return groupByEntity;
    }

    /**
     * Sets the group by entity.
     *
     * @param groupByEntity the new group by entity
     */
    public void setGroupByEntity(String groupByEntity) {
		this.groupByEntity = groupByEntity;
    }

    /**
     * Gets the query.
     *
     * @return the query
     */
    public Query getQuery() {
		return query;
    }

    /**
     * Sets the query.
     *
     * @param query the new query
     */
    public void setQuery(Query query) {
		this.query = query;
    }

    /**
     * Gets the dashboard.
     *
     * @return the dashboard
     */
    public Dashboard getDashboard() {
		return dashboard;
    }

    /**
     * Sets the dashboard.
     *
     * @param dashboard the new dashboard
     */
    public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
    }

    /**
     * Gets the chart type.
     *
     * @return the chart type
     */
    public ChartType getChartType() {
		return chartType;
    }

    /**
     * Sets the chart type.
     *
     * @param chartType the new chart type
     */
    public void setChartType(ChartType chartType) {
		this.chartType = chartType;
    }

	/**
	 * To json.
	 *
	 * @return the map
	 */
	public Map toJSON() {
		Map result = new HashMap();
		result.put("id", id);
		result.put("title", title);
		result.put("type", chartType);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Widget) {
			Widget otherWidget = (Widget)o;
			return ((this.title.equals(otherWidget.getTitle())) &&
					(this.query.equals(otherWidget.getQuery())) &&
					((this.groupByEntity == null) ? (otherWidget.getGroupByEntity() == null) : (this.groupByEntity.equals(otherWidget.getGroupByEntity()))) &&
					((this.groupBy == null) ? (otherWidget.getGroupBy() == null) : (this.groupBy.equals(otherWidget.getGroupBy()))));
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = 3;
		hashCode += 5 * this.title.hashCode();
		hashCode += 7 * this.query.hashCode();
		hashCode += 11 * ((this.groupBy == null) ? 0 : this.groupBy.hashCode());
		hashCode += 13 * ((this.groupByEntity == null) ? 0 : this.groupByEntity.hashCode());
		return hashCode;
	}

	/**
	 * The Enum ChartType.
	 */
	public enum ChartType {
		
		/** The pie chart. */
		PIE_CHART, 
 /** The bar chart. */
 BAR_CHART, 
 /** The column chart. */
 COLUMN_CHART, 
 /** The geo chart. */
 GEO_CHART;
	}

}
