package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity(name = "auditable_internet_explorer")
public class AuditableInternetExplorer extends Auditable {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auditable_internet_explorers_id_seq")
    @SequenceGenerator(name = "auditable_internet_explorers_id_seq", sequenceName = "auditable_internet_explorers_id_seq", allocationSize = 1)
    private Integer id;
    
	@ManyToOne @PrimaryKeyJoinColumn 
    @JoinColumn(name = "internet_explorer_id")
    private InternetExplorer internetExplorer;
	
	public AuditableInternetExplorer() { }
	
	public AuditableInternetExplorer(InternetExplorer internetExplorer) {
		this();
		this.internetExplorer = internetExplorer;
	}

	public InternetExplorer getInternetExplorer() {
		return internetExplorer;
	}

	public void setInternetExplorer(InternetExplorer internetExplorer) {
		this.internetExplorer = internetExplorer;
	}
}
