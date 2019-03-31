package com.dashboard.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateDashboard {
	
		public CreateDashboard(Dashboard dashboard, JSONArray pendingIssues, JSONArray includedFixes, JSONArray deploymentNotes) {

			SessionFactory factory = new Configuration()
			.configure()
			.addAnnotatedClass(Team.class)
			.addAnnotatedClass(Teammate.class)
			.addAnnotatedClass(Dashboard.class)
			.addAnnotatedClass(DeploymentNote.class)
			.addAnnotatedClass(IncludedFixes.class)
			.addAnnotatedClass(PendingIssue.class)
			.buildSessionFactory();
			
			Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			session.save(dashboard);
			session.getTransaction().commit();
			
			for(int i = 0; i < pendingIssues.length(); i++) {
				JSONObject issue = pendingIssues.getJSONObject(i);
				PendingIssue p = new PendingIssue(issue.getString("name"),
												  issue.getString("assignedTo"), 
												  "0", 
												  dashboard);
			
				dashboard.addPendingIssue(p);
				new CreatePendingIssue(p);
			}	
			for(int i = 0; i < includedFixes.length(); i++) {
				JSONObject issue = includedFixes.getJSONObject(i);
				IncludedFixes p = new IncludedFixes(issue.getString("fix"),
												    dashboard);

				dashboard.addIncludedFix(p);
				new CreateIncludedFix(p);
			}	
			for(int i = 0; i < deploymentNotes.length(); i++) {
				JSONObject issue = deploymentNotes.getJSONObject(i);
				
				DeploymentNote p = new DeploymentNote(issue.getString("note"),
												  	  dashboard);
			
				dashboard.addDeploymentNote(p);
				new CreateDeploymentNote(p);
			}	
			
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
			factory.close();
		}
	}


}
