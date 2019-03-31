package com.dashboard.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadCurrentTeam {
		private Team team;
		private Teammate currentUser;
		public ReadCurrentTeam(String user) {
	
			SessionFactory factory = new Configuration()
			.configure()
			.addAnnotatedClass(Dashboard.class)
			.addAnnotatedClass(DeploymentNote.class)
			.addAnnotatedClass(IncludedFixes.class)
			.addAnnotatedClass(PendingIssue.class)
			.addAnnotatedClass(Team.class)
			.addAnnotatedClass(Teammate.class)
			.buildSessionFactory();
			
			Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			//query below search username.. will need to create onetomany relationship for team and teammates
			System.out.println(user);
			currentUser = session.get(Teammate.class, user);
			team = currentUser.getTeam();
			
			session.getTransaction().commit();
			System.out.println(team.getTeamname());
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
			factory.close();
		}
	}
		
	public Team getTeam() {
		return team;
	}

}
