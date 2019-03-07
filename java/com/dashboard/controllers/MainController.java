package com.dashboard.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.entities.CreateDashboard;
import com.dashboard.entities.CreateTeam;
import com.dashboard.entities.CreateTeammate;
import com.dashboard.entities.Dashboard;
import com.dashboard.entities.PendingIssue;
import com.dashboard.entities.Team;
import com.dashboard.entities.Teammate;
import com.dashboard.helpers.Helpers;


@Controller
public class MainController {
	
	@GetMapping("*")
	public String goHome() {
		return "index";
	}
	
	@PostMapping("/create-team")
	@ResponseBody
	public String createTeam(HttpServletRequest request) throws IOException, JSONException {
		String payloadString = Helpers.convertJsonToString( request.getInputStream() );
		JSONObject obj = new JSONObject(payloadString);
		
		Team newTeam = new Team(obj.getString("teamname"), obj.getString("adminUsername"));
		
		Teammate newTeammate = new Teammate(obj.getString("adminUsername"), 
											obj.getString("adminPassword"),
											obj.getString("adminDisplayName"),
											obj.getString("adminEmail"),
											3, 
											obj.getString("teamname"));
		
		new CreateTeam(newTeam);
		new CreateTeammate(newTeammate);
		
		return "Success";
	}
}
