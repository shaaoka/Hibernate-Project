package com.team6.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionFactoryListener implements ServletContextListener {

    public SessionFactoryListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	HibernateUtil.closeSessionFactory();
    	System.out.println("Closed SessionFactory👍");
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	HibernateUtil.getSessionFactory();
    	System.out.println("SessionFactory Created!!!6666");
    	
    }
    
	
}
