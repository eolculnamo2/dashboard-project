package com.dashboard.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTeam {
	
		public CreateTeam(Team team) {

			SessionFactory factory = new Configuration()
			.configure()
			.addAnnotatedClass(Team.class)
			.buildSessionFactory();
			
			Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			session.save(team);
			session.getTransaction().commit();
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
