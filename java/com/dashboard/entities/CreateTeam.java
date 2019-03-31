package com.dashboard.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTeam {
		
	//TODO add list of new teammates to add
		public CreateTeam(Team team, Teammate founder) {

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
			session.save(team);
			session.getTransaction().commit();
			
			team.addTeammate(founder);
			//String username, String password, String displayName, String email, int authorityLevel
			new CreateTeammate(founder);
			
			
			System.out.println(team.getTeamname());
			System.out.println("SAVED");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
			factory.close();
		}
	}


}
