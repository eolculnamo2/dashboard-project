package com.dashboard.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@Column(name="teamname")
	private String teamname;
	@Column(name="founder")
	private String founder;
	@JsonIgnore
	@OneToMany(mappedBy="team")
	private List<Teammate> teammates;
	@JsonIgnore
	@OneToMany(mappedBy="dashboard", fetch=FetchType.EAGER)
	private List<Dashboard> dashboards;
	
	public Team() {
		
	}
	
	public Team(String teamname, String founder, List<Teammate> teammates) {
		this.teamname = teamname;
		this.founder = founder;
		this.teammates = teammates;
		this.dashboards = new ArrayList<Dashboard>();
	}
	
	public void addDashboard(Dashboard dashboard) {
		if(dashboards == null) {
			dashboards = new ArrayList<Dashboard>();
		}
		dashboards.add(dashboard);
		dashboard.setTeam(this);
	}
	
	public void addTeammate(Teammate teammate) {
		if(teammates == null) {
			teammates = new ArrayList<Teammate>();
		}
		teammates.add(teammate);
		teammate.setTeam(this);
	}
	public String getTeamname() {
		return teamname;
	}
	
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	
	public String getFounder() {
		return founder;
	}
	
	public void setFounder(String founder) {
		this.founder = founder;
	}

	public List<Teammate> getTeammates() {
		return teammates;
	}

	public void setTeammates(List<Teammate> teammates) {
		this.teammates = teammates;
	}

	public List<Dashboard> getDashboards() {
		return dashboards;
	}

	public void setDashboards(List<Dashboard> dashboards) {
		this.dashboards = dashboards;
	}
}
