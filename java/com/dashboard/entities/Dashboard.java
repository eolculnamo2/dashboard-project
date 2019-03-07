package com.dashboard.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dashboard")
public class Dashboard {
	
	@Id
	@Column(name="id")
	private int id; //OneToMany with PendingIssues
	@Column(name="team_name")
	private String teamName; // ManyToOne iwth Team
	@Column(name="step_status")
	private String stepStatus;
	@Column(name="scheduled_time")
	private String scheduledTime;
	@Column(name="current_step")
	private int currentStep;
	//private List<String> deploymentNotes;
	//private List<String> includedFixes;
	@OneToMany(mappedBy="dashboard")
	private List<PendingIssue> pendingIssues;
	//private List<Teammate> userData;
	
	public Dashboard() {}
	
	public Dashboard(int currentStep, 
				 	 String stepStatus, 
				 	 String scheduledTime, 
//				 	 List<String>deploymentNotes, 
//				 	 List<String>includedFixes, 
				 	 List<PendingIssue>pendingIssues
				 	// List<Teammate>userData
				 	 ) {
		
	}
	
	public void addPendingIssue(PendingIssue issue) {
		pendingIssues.add(issue);
		issue.setDashboard(this);
	}
	
	public int getCurrentStep() {
		return currentStep;
	}
	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}
	public String getStepStatus() {
		return stepStatus;
	}
	public void setStepStatus(String stepStatus) {
		this.stepStatus = stepStatus;
	}
	public String getScheduledTime() {
		return scheduledTime;
	}
	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
//	public List<String> getDeploymentNotes() {
//		return deploymentNotes;
//	}
//	public void setDeploymentNotes(List<String> deploymentNotes) {
//		this.deploymentNotes = deploymentNotes;
//	}
//	public List<String> getIncludedFixes() {
//		return includedFixes;
//	}
//	public void setIncludedFixes(List<String> includedFixes) {
//		this.includedFixes = includedFixes;
//	}
	public List<PendingIssue> getPendingIssues() {
		return pendingIssues;
	}
	public void setPendingIssues(List<PendingIssue> pendingIssues) {
		this.pendingIssues = pendingIssues;
	}
//	public List<Teammate> getUserData() {
//		return userData;
//	}
//	public void setUserData(List<Teammate> userData) {
//		this.userData = userData;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
