package com.dashboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@Column(name="teamname")
	private String teamname;
	@Column(name="founder")
	private String founder;
	
	public Team() {
		
	}
	
	public Team(String teamname, String founder) {
		this.teamname = teamname;
		this.founder = founder;
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
