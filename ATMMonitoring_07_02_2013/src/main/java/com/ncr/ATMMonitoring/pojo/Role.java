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
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = -8389177127546888232L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_id_seq")
    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String name;

    @Column(name = "manageable")
    private Boolean manageable;

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
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the manageable
     */
    public Boolean getManageable() {
	return manageable;
    }

    /**
     * @param manageable
     *            the manageable to set
     */
    public void setManageable(Boolean manageable) {
	this.manageable = manageable;
    }
}