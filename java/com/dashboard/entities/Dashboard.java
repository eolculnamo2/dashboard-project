package com.dashboard.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dashboard")
public class Dashboard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; //OneToMany with PendingIssues
	@Column(name="deployment_name")
	private String deploymentName; // ManyToOne with Team
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
	@ManyToOne
	@JoinColumn(name="team_name")
	Team team;
	@ManyToOne
	@JoinColumn(name="teamname_key")
	Dashboard dashboard;
	//private List<Teammate> userData;

	public Dashboard() {}
	
	public Dashboard(int currentStep, 
					 String deploymentName,
				 	 String stepStatus, 
				 	 String scheduledTime, 
				 	 List<DeploymentNote>deploymentNotes, 
				 	 List<IncludedFixes>includedFixes, 
				 	 List<PendingIssue>pendingIssues
				 	// List<Teammate>userData
				 	 ) {
		this.currentStep = currentStep;
		this.deploymentName = deploymentName;
		this.stepStatus = stepStatus;
		this.scheduledTime = scheduledTime;
		this.pendingIssues = pendingIssues;
		
	}
	
	public void addPendingIssue(PendingIssue issue) {
		if(pendingIssues == null) {
			pendingIssues = new ArrayList<PendingIssue>();
		}
		pendingIssues.add(issue);
		issue.setDashboard(this);
	}
	
	public void addIncludedFix(IncludedFixes fix) {
		if(includedFixes == null) {
			includedFixes = new ArrayList<IncludedFixes>();
		}
		includedFixes.add(fix);
		fix.setDashboard(this);
	}
	
	public void addDeploymentNote(DeploymentNote note) {
		if(deploymentNotes == null) {
			deploymentNotes = new ArrayList<DeploymentNote>();
		}
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

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
}
