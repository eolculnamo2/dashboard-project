package com.dashboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pending_issue")
public class PendingIssue {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="assigned_to")
	private String assignedTo;
	@Column(name="solved")
	private String solved;
	
	@ManyToOne
	@JoinColumn(name="dashboard_id")
	private Dashboard dashboard;
	
	public PendingIssue() {}
	
	public PendingIssue(String name, String assignedTo, String solved, Dashboard dashboard) {
		this.name = name;
		this.assignedTo = assignedTo;
		this.solved = solved;
		this.dashboard = dashboard;
	}
	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getSolved() {
		return solved;
	}
	public void setSolved(String solved) {
		this.solved = solved;
	}
}
