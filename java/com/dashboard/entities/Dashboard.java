package com.dashboard.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dashboard")
public class Dashboard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@OneToMany(mappedBy="dashboard")
	private List<DeploymentNote> deploymentNotes;
	@OneToMany(mappedBy="dashboard")
	private List<IncludedFixes> includedFixes;
	@OneToMany(mappedBy="dashboard")
	private List<PendingIssue> pendingIssues;
	//private List<Teammate> userData;
	
	public Dashboard() {}
	
	public Dashboard(int currentStep, 
					 String teamName,
				 	 String stepStatus, 
				 	 String scheduledTime, 
				 	 List<DeploymentNote>deploymentNotes, 
				 	 List<IncludedFixes>includedFixes, 
				 	 List<PendingIssue>pendingIssues
				 	// List<Teammate>userData
				 	 ) {
		this.currentStep = currentStep;
		this.teamName = teamName;
		this.stepStatus = stepStatus;
		this.scheduledTime = scheduledTime;
		this.pendingIssues = pendingIssues;
		
	}
	
	public void addPendingIssue(PendingIssue issue) {
		pendingIssues.add(issue);
		issue.setDashboard(this);
	}
	
	public void addIncludedFix(IncludedFixes fix) {
		includedFixes.add(fix);
		fix.setDashboard(this);
	}
	
	public void addDeploymentNote(DeploymentNote note) {
		deploymentNotes.add(note);
		note.setDashboard(this);
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
	public List<DeploymentNote> getDeploymentNotes() {
		return deploymentNotes;
	}
	public void setDeploymentNotes(List<DeploymentNote> deploymentNotes) {
		this.deploymentNotes = deploymentNotes;
	}
	public List<IncludedFixes> getIncludedFixes() {
		return includedFixes;
	}
	public void setIncludedFixes(List<IncludedFixes> includedFixes) {
		this.includedFixes = includedFixes;
	}
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
