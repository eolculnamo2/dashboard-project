package com.dashboard.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.dashboard.api.DashboardDTO;
import com.dashboard.entities.CreateDashboard;
import com.dashboard.entities.CreateTeam;
import com.dashboard.entities.Dashboard;
import com.dashboard.entities.DeploymentNote;
import com.dashboard.entities.IncludedFixes;
import com.dashboard.entities.PendingIssue;
import com.dashboard.entities.ReadCurrentTeam;
import com.dashboard.entities.Team;
import com.dashboard.entities.Teammate;
import com.dashboard.helpers.Helpers;


@Controller
public class MainController {
	
	@RequestMapping(value={"/","/login","/create-team", 
							"/dashboard","/new-deployment",
							"/deployment-status","/select-deployment"}, method=RequestMethod.GET)
	public String goHome() {
		return "index";
	}
	
	@GetMapping("/deployment")
	public RedirectView successUrl(Authentication authentication, HttpServletRequest request) {
		Helpers.loginSuccessHandler(authentication, request);
		
		return new RedirectView("/deployment-status");
	}
	
	@PostMapping("/create-team")
	@ResponseBody
	public String createTeam(HttpServletRequest request) throws IOException, JSONException {
		String payloadString = Helpers.convertJsonToString( request.getInputStream() );
		JSONObject obj = new JSONObject(payloadString);
		
		Team newTeam = new Team(obj.getString("teamname"), 
								obj.getString("adminUsername"), 
								new ArrayList<Teammate>());
		
		
		
		Teammate newTeammate = new Teammate(obj.getString("adminUsername"), 
				obj.getString("adminPassword"),
				obj.getString("adminDisplayName"),
				obj.getString("adminEmail"),
				3, 
				newTeam);
		
		new CreateTeam(newTeam, newTeammate);
		
		return "Success";
	}
	@PostMapping("/create-deployment")
	@Transactional
	@ResponseBody
	public String createDeployment(HttpServletRequest request, Authentication authentication, HttpSession session) throws IOException, JSONException {
		String payloadStr = Helpers.convertJsonToString( request.getInputStream() );
		JSONObject obj = new JSONObject(payloadStr);

	 	List<PendingIssue> pendingIssues = new ArrayList<>();
	 	List<IncludedFixes> includedFixes = new ArrayList<>();
	 	List<DeploymentNote> deploymentNotes = new ArrayList<>();

	 	//Create dashboard to use as a parameter for PendingIssue and 
		Dashboard dashboard = new Dashboard(0, 
				 							obj.getString("depName"), 
				 							"stopped", 
				 							obj.getString("depTime"), 
				 							deploymentNotes,
				 							includedFixes,
				 							pendingIssues);
		
		JSONArray pendingIssueArray = obj.getJSONArray("pendingIssues");
		JSONArray includedFixesArray = obj.getJSONArray("includedFixes");
		JSONArray deploymentNotesArray = obj.getJSONArray("deploymentNotes");
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("HUR");
		Team currentTeam  = (Team) request.getSession().getAttribute("team");
		System.out.println("AND HUR");
		System.out.println(currentTeam.getFounder());
		currentTeam.addDashboard(dashboard);
		
//		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//	    System.out.println(attr.getRequest().getSession(true)); // true == allow create
		
		
		new CreateDashboard(dashboard, pendingIssueArray, includedFixesArray, deploymentNotesArray);		

		return "Success";
		
	}
	
	@GetMapping("/dashboard-dto")
	@ResponseBody
	public DashboardDTO sendDashboardDTO(Authentication authentication) {
		DashboardDTO dto = new DashboardDTO(authentication.getName());
		
		Team t = new ReadCurrentTeam(authentication.getName()).getTeam();
		dto.setTeam(t);
		
		return dto;
	}
}
