package com.dashboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	private int authorityLevel;
	@Column(name="teamname")
	private String teamname;
	@Column(name="enabled")
	private int enabled;
	@Column(table="authorities")
	private String authority;
	
	public Teammate() {
		
	}
	
	public Teammate(String username, String password, String displayName, String email, int authorityLevel, String teamname) {
		this.username = username;
		this.password = "{bcrypt}"+new BCryptPasswordEncoder().encode(password);;
		this.displayName = displayName;
		this.email = email;
		this.authorityLevel = authorityLevel;
		this.teamname = teamname;
		switch(authorityLevel) {
			case 1: this.authority = "ROLE_USER";
					break;
			case 2: this.authority = "ROLE_ADMIN";
					break;
			case 3: this.authority = "ROLE_OWNER";
					break;
			default: this.authority = "ROLE_USER";
			this.enabled=1;
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public int getAuthorityLevel() {
		return authorityLevel;
	}
	public void setAuthorityLevel(int authorityLevel) {
		this.authorityLevel = authorityLevel;
	}
}
