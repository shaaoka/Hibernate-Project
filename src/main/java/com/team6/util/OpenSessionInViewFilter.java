package com.team6.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebFilter(urlPatterns = "/*")
public class OpenSessionInViewFilter extends HttpFilter implements Filter {

//	public OpenSessionInViewFilter() {super();}
//	public void destroy() {}
	
	private static final long serialVersionUID = 1L;
	private Session session;
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			// 並非重複啟動,是抓已經啟動的那個Factory
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			this.session = sessionFactory.getCurrentSession();
			
			// 這邊開交易，其他地方不用開
			if(!session.getTransaction().isActive()) {
				session.beginTransaction();
				System.out.println("begin Transaction!!👍👍👍");
			}
			
			chain.doFilter(request, response);// http response 做完，才做下面的事情
			
			session.getTransaction().commit();
//			if(session.getTransaction().isActive()) {
//				session.getTransaction().commit();
//			}
			System.out.println("commit!!👍👍👍👍");
		} catch (Exception e) {
			if(session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			System.out.println("Transaction RollBack!!👌👌👌👌");
			e.printStackTrace();
		}
		// 不用關Factory，這邊關了後面的程式就沒有連線工場了
		
		
		
		
	}

//	public void init(FilterConfig fConfig) throws ServletException {}

}
