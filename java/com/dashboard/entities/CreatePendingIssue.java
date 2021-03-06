package com.dashboard.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePendingIssue {
	
		public CreatePendingIssue(PendingIssue pendingIssue) {

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
			session.save(pendingIssue);
			session.getTransaction().commit();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
			factory.close();
		}
	}


}