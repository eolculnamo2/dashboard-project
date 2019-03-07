package com.dashboard.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDashboard {
	
		public CreateDashboard(Dashboard dashboard) {

			SessionFactory factory = new Configuration()
			.configure()
			.addAnnotatedClass(Dashboard.class)
			.addAnnotatedClass(PendingIssue.class)
			.buildSessionFactory();
			
			Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			session.save(dashboard);
			session.getTransaction().commit();
			System.out.println(dashboard.getTeamName());
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
