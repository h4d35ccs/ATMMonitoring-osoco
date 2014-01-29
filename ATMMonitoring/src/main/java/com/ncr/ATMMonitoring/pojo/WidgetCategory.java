package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "widget_category")
public class WidgetCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "widget_categories_id_seq")
    @SequenceGenerator(name = "widget_categories_id_seq", sequenceName = "widget_categories_id_seq", allocationSize = 1)
    private Integer id;
	
	/** The widgets. */
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
	@OrderBy("title")
    private List<Widget> widgets;
    
    @Column(name = "name")
    private String name;
    
    
    public WidgetCategory() {
		this.widgets =  new ArrayList<Widget>();
    }

    public Integer getId() {
		return id;
	}

    public void setId(Integer id) {
		this.id = id;
	}

	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
