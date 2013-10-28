package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "bank_companies")
public class BankCompany implements Serializable {

    private static final long serialVersionUID = 6497721184766729099L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bank_companies_id_seq")
    @SequenceGenerator(name = "bank_companies_id_seq", sequenceName = "bank_companies_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "vat_in", length = 15, unique = true, nullable = true)
    @Index(name = "vatInIndex")
    private String vatIN;

    @ManyToOne
    @JoinColumn(name = "parent_company")
    private BankCompany parentCompany;

    @OneToMany(mappedBy = "parentCompany")
    private Set<BankCompany> subBankCompanies;

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

    public BankCompany getParentCompany() {
	return parentCompany;
    }

    public void setParentCompany(BankCompany parentCompany) {
	this.parentCompany = parentCompany;
    }

    public Set<BankCompany> getSubBankCompanies() {
	return subBankCompanies;
    }

    public void setSubBankCompanies(Set<BankCompany> subBankCompanies) {
	this.subBankCompanies = subBankCompanies;
    }

    public Set<BankCompany> getManageableBankCompanies() {
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	bankCompanies.add(this);
	for (BankCompany subBankCompany : subBankCompanies) {
	    bankCompanies.addAll(subBankCompany.getManageableBankCompanies());
	}
	return bankCompanies;
    }

    public String getVatIN() {
	return vatIN;
    }

    public void setVatIN(String vatIN) {
	this.vatIN = vatIN;
    }
}