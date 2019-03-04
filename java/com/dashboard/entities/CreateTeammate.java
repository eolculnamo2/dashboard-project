package com.dashboard.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTeammate {
	public CreateTeammate(Teammate teammate) {

		SessionFactory factory = new Configuration()
		.configure()
		.addAnnotatedClass(Teammate.class)
		.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

	try {
		
		session.beginTransaction();
		session.save(teammate);
		new CreateTeammate(teammate);
		session.getTransaction().commit();
		System.out.println(teammate.getUsername());
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
