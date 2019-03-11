package com.dashboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="deployment_note")
public class DeploymentNote {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="note")
	private String note;
	@ManyToOne
	@JoinColumn(name="dashboard_id_note")
	private Dashboard dashboard2;
	
	public DeploymentNote() {};
	
	public DeploymentNote(String note, Dashboard dashboard) {
		this.note = note;
		this.dashboard2 = dashboard;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Dashboard getDashboard2() {
		return dashboard2;
	}
	public void setDashboard2(Dashboard dashboard2) {
		this.dashboard2 = dashboard2;
	}
	
}
