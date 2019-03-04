package com.dashboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="users")
@SecondaryTable(name="authorities")
public class Teammate {
	
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(name="display_name")
	private String displayName;
	@Column(name="email")
	private String email;
	@Column(name="authority")
	private int authority;
	@Column(name="teamname")
	private String teamname;
	@Column(table="authorities")
	private String authorityLevel;
	
	public Teammate() {
		
	}
	
	public Teammate(String username, String password, String displayName, String email, int authority, String teamname) {
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.email = email;
		this.authority = authority;
		this.teamname = teamname;
		switch(authority) {
			case 1: this.authorityLevel = "ROLE_USER";
					break;
			case 2: this.authorityLevel = "ROLE_ADMIN";
					break;
			case 3: this.authorityLevel = "ROLE_OWNER";
					break;
			default: this.authorityLevel = "ROLE_USER";
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getAuthorityLevel() {
		return authorityLevel;
	}
	public void setAuthorityLevel(String authorityLevel) {
		this.authorityLevel = authorityLevel;
	}
}
