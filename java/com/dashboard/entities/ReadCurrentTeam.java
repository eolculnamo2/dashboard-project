package com.dashboard.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadCurrentTeam {
		private Team usersTeam;
	
		public ReadCurrentTeam(String user) {
	
			SessionFactory factory = new Configuration()
			.configure()
			.addAnnotatedClass(Team.class)
			.buildSessionFactory();
			
			Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			//query below search username.. will need to create onetomany relationship for team and teammates
			List<Team>queryFind = session.createQuery("from Team x where x.username='"+user+"'").getResultList();
			usersTeam = queryFind.get(0);
			
			session.getTransaction().commit();
			System.out.println(usersTeam);
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
			factory.close();
		}
	}
		
	public Team getTeam() {
		return usersTeam;
	}

}
