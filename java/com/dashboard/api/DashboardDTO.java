package com.dashboard.api;

import java.util.ArrayList;

import com.dashboard.entities.Dashboard;
import com.dashboard.entities.ReadCurrentTeam;
import com.dashboard.entities.Team;

public class DashboardDTO {
	
	private String username;
	private String userImg;
	private Team team;
	private ArrayList<Dashboard> dashboards;
	
	public DashboardDTO(String username) {
		ReadCurrentTeam team = new ReadCurrentTeam(username);
		this.team = team.getTeam();
		this.username = username;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public ArrayList<Dashboard> getDashboards() {
		return dashboards;
	}
	public void setDashboards(ArrayList<Dashboard> dashboards) {
		this.dashboards = dashboards;
	}
	
}
