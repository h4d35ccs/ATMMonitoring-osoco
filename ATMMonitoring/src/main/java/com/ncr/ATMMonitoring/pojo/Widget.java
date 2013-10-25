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

/**
 * @author Rafael Luque (OSOCO)
 */

@Entity
@Table(name = "widget")
public class Widget {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "widgets_id_seq")
    @SequenceGenerator(name = "widgets_id_seq", sequenceName = "widgets_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "widget_idx", nullable = false)
	private Integer order;

    @Column(name = "title", nullable = false, length = 50)
	private String title;

    @Column(name = "default_widget", nullable = false)
	private boolean defaultWidget = false;

    @Column(name = "visible", nullable = false)
	private boolean visible = true;

	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private User owner;

	@ManyToOne
	@JoinColumn(name = "query_id", nullable = false)
	private Query query;

	@ManyToOne
	@JoinColumn(name = "dashboard_id", nullable = true)
    private Dashboard dashboard;

	@Column(name = "groupByField", nullable = false)
	private String groupBy;

	@Column(name = "groupByEntity", nullable = true)
	private String groupByEntity;

	@Column(name = "chart_type", nullable = false)
	private ChartType chartType;

	public Widget() {
	}

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

    public Integer getId() {
		return id;
    }

    public void setId(Integer id) {
		this.id = id;
    }

    public Integer getOrder() {
		return order;
    }

    public void setOrder(Integer order) {
		this.order = order;
    }

    public String getTitle() {
		return this.title;
    }

    public void setTitle(String title) {
		this.title = title;
    }

	public boolean isDefaultWidget() {
		return defaultWidget;
	}

	public void setDefaultWidget(boolean defaultWidget) {
		this.defaultWidget = defaultWidget;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

    public User getOwner() {
		return owner;
    }

    public void setOwner(User owner) {
		this.owner = owner;
    }

    public String getGroupBy() {
		return groupBy;
    }

    public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
    }

    public String getGroupByEntity() {
		return groupByEntity;
    }

    public void setGroupByEntity(String groupByEntity) {
		this.groupByEntity = groupByEntity;
    }

    public Query getQuery() {
		return query;
    }

    public void setQuery(Query query) {
		this.query = query;
    }

    public Dashboard getDashboard() {
		return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
    }

    public ChartType getChartType() {
		return chartType;
    }

    public void setChartType(ChartType chartType) {
		this.chartType = chartType;
    }

	public Map toJSON() {
		Map result = new HashMap();
		result.put("id", id);
		result.put("title", title);
		result.put("type", chartType);
		return result;
	}

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

	@Override
	public int hashCode() {
		int hashCode = 3;
		hashCode += 5 * this.title.hashCode();
		hashCode += 7 * this.query.hashCode();
		hashCode += 11 * ((this.groupBy == null) ? 0 : this.groupBy.hashCode());
		hashCode += 13 * ((this.groupByEntity == null) ? 0 : this.groupByEntity.hashCode());
		return hashCode;
	}

	public enum ChartType {
		PIE_CHART, BAR_CHART, COLUMN_CHART, GEO_CHART;
	}

}
