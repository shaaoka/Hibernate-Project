package com.team6.util; // p.48頁做的4情

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
//	 優先做creatxxx存在FACTORY變數裡
	
	private static final SessionFactory FACTORY = creatSessionFactory();
	

	private static SessionFactory creatSessionFactory() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		return factory;
	}
	
//	p.47
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
	
//	有開就有關
	public static void  closeSessionFactory() {
		if(FACTORY != null) { FACTORY.close();}
	}
	
	
}
