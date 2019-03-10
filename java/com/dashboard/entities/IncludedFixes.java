package com.dashboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="included_fix")
public class IncludedFixes {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="fix")
	private String fix;
	
	@ManyToOne()
	@JoinColumn(name="dashboard_id_fix")
	private Dashboard dashboard;
	
	public IncludedFixes() {};
	
	public IncludedFixes(String fix, Dashboard dashboard) {
		this.fix = fix;
		this.dashboard = dashboard;
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFix() {
		return fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
}
