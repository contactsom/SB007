package com.simplilearn.utill;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class AHibernateUtill {

	static SessionFactory factory;
	
	static {
		AnnotationConfiguration acfg= new AnnotationConfiguration();
		acfg=(AnnotationConfiguration)acfg.configure();
		factory = acfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
