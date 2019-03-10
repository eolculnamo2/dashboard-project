package com.dashboard.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateIncludedFix {
	public CreateIncludedFix(IncludedFixes includedFixes) {

		SessionFactory factory = new Configuration()
		.configure()
		.addAnnotatedClass(Dashboard.class)
		.addAnnotatedClass(IncludedFixes.class)
		.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

	try {
		
		session.beginTransaction();
		session.save(includedFixes);
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
