package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Role Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8389177127546888232L;

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_id_seq")
    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    private Integer id;

    /** The name. */
    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String name;

    /** The description. */
    @Column(name = "description", length = 300)
    private String description;

    /** The manageable flag (i.e. can be assigned and modified). */
    @Column(name = "manageable")
    private Boolean manageable;

    /** The flag that tells us whether the users can edit terminal data. */
    @Column(name = "can_edit_terminals")
    private Boolean canEditTerminals;

    // We don't need this for now
    // @OneToMany(mappedBy = "role")
    // @Cascade(CascadeType.ALL)
    // private Set<User> users;
    //
    // public Set<User> getUsers() {
    // return users;
    // }
    //
    // public void setUsers(Set<User> users) {
    // this.users = users;
    // }

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
     * @param id the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Whether the role is manageable (i.e. can be assigned and modified).
     * 
     * @return the manageable flag
     */
    public Boolean getManageable() {
	return manageable;
    }

    /**
     * Sets the manageable flag.
     * 
     * @param manageable
     *            the manageable flag to set
     */
    public void setManageable(Boolean manageable) {
	this.manageable = manageable;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Whether the users is can edit terminal data.
     * 
     * @return the terminal data edition flag
     */
    public Boolean getCanEditTerminals() {
	return canEditTerminals;
    }

    /**
     * Sets the terminal data edition flag.
     * 
     * @param manageable
     *            the terminal data edition flag to set
     */
    public void setCanEditTerminals(Boolean canEditTerminals) {
	this.canEditTerminals = canEditTerminals;
    }
}