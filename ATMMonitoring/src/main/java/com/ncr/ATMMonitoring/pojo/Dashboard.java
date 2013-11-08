package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Rafael Luque (OSOCO)
 */

@Entity
@Table(name = "dashboard")
public class Dashboard implements Serializable {

    private static final long serialVersionUID = -958900960975875923L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dashboards_id_seq")
    @SequenceGenerator(name = "dashboards_id_seq", sequenceName = "dashboards_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "columns", nullable = false)
    private Integer columns;

    @OneToMany(mappedBy = "dashboard", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
	@OrderBy("order")
    private List<Widget> widgets;

    public Dashboard() {
		this.widgets =  new ArrayList<Widget>();
    }

    public Integer getId() {
		return id;
    }

    public void setId(Integer id) {
		this.id = id;
    }

    public Integer getColumns() {
		return columns;
    }

    public void setColumns(Integer columns) {
		this.columns = columns;
    }

    public List<Widget> getWidgets() {
		return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
    }

    public List<Widget> getVisibleWidgets() {
		List<Widget> visibleWidgets = new ArrayList<Widget>();
		for (Widget widget: widgets) {
			if (widget.isVisible()) {
				visibleWidgets.add(widget);
			}
		}
		return visibleWidgets;
    }

	public enum ColumnOptions {
		ONE_COLUMN(1), TWO_COLUMNS(2), THREE_COLUMNS(3), FOUR_COLUMNS(4);

		private int columns;

		ColumnOptions(int columns) {
			this.columns = columns;
		}

		public int getColumns() {
			return this.columns;
		}
	}

}
