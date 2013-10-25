package com.ncr.ATMMonitoring.pojo;

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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "users")
public class User implements UserDetails {

    private static final long serialVersionUID = -4609857457555155113L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "firstname", length = 50)
    private String firstname;

    @Column(name = "lastname", length = 60)
    private String lastname;

    @NotEmpty
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @NotEmpty
    @Size(min = 5)
    @Column(name = "passw", length = 80)
    private String password;

    @Column(name = "last_login")
    private Date lastLogin;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("query_name")
    private Set<Query> queries = new HashSet<Query>();

	@OneToOne
	private Dashboard dashboard;

    // Code with support for Terminal Config AUTHORS
    //
    // @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    // @Cascade(CascadeType.ALL)
    // @OrderBy("start_date desc")
    // private Set<TerminalConfig> configs;
    //
    // /**
    // * @return the configs
    // */
    // public Set<TerminalConfig> getConfigs() {
    // return configs;
    // }
    //
    // /**
    // * @param configs the configs to set
    // */
    // public void setConfigs(Set<TerminalConfig> configs) {
    // this.configs = configs;
    // }

    public User() {
	this.role = new Role();
    };

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Override
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @Override
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
	if (role != null) {
	    authList.add(new GrantedAuthorityImpl("ROLE_" + role.getName()));
	}
	return authList;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    /**
     * @return the queries
     */
    public Set<Query> getQueries() {
	return queries;
    }

    /**
     * @param queries
     *            the queries to set
     */
    public void setQueries(Set<Query> queries) {
	this.queries = queries;
    }

    /**
     * @return the lastLogin
     */
    public Date getLastLogin() {
	return lastLogin;
    }

    /**
     * @param lastLogin
     *            the lastLogin to set
     */
    public void setLastLogin(Date lastLogin) {
	this.lastLogin = lastLogin;
    }

    public Dashboard getDashboard() {
		return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
    }

    public String getHtmlWelcomeMessage(Locale locale) {
      	DateFormat timeFormatter = new SimpleDateFormat("H:mm");
        String lastLoginFormatted = "";
        lastLoginFormatted  = DateFormat.getDateInstance(DateFormat.SHORT, locale).format(lastLogin) +
	    " - " + timeFormatter.format(lastLogin);

       return "<div class=\"wellcome\"><spring:message code=\"label.welcomeMessage\"/> "+
               firstname + " " + lastname + ", " + role.getName().replace("_", " ") +
               "</div>" +
	       "<div class=\"date\">" + lastLoginFormatted + "</div>";
    }

}
