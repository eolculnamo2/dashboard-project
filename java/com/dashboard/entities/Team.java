package com.dashboard.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@Column(name="teamname")
	private String teamname;
	@Column(name="founder")
	private String founder;
	@OneToMany(mappedBy="team")
	private ArrayList<Dashboard> dashboards;
	
	public Team() {
		
	}
	
	public Team(String teamname, String founder) {
		this.teamname = teamname;
		this.founder = founder;
	}
	
	public void addDashboard(Dashboard dashboard) {
		if(dashboards == null) {
			dashboards = new ArrayList<Dashboard>();
		}
		dashboards.add(dashboard);
		dashboard.setTeam(this);
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
}
