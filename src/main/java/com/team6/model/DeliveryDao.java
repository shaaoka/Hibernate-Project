package com.team6.model;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.team6.util.HibernateUtil;

public class DeliveryDao {

	private SessionFactory factory;
	
	public DeliveryDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	public boolean insert(Delivery delivery) {
	    Session session = factory.getCurrentSession();
//	    Session session = factory.openSession();
	    boolean isSuccess = false;
	    try {
//	        session.beginTransaction();
	        session.save(delivery); 
	        isSuccess = true;
//	        session.getTransaction().commit();
	    } catch (Exception e) {
	    	System.out.println("新增失敗");
//	    	session.getTransaction().rollback();
	        e.printStackTrace();
	        } finally {
//	        session.close();
	    }
	    return isSuccess;
	}
	public boolean update(Delivery delivery) {
	    Session session = factory.getCurrentSession();
//	    Session session = factory.openSession();
	    boolean isSuccess = false;
	    try {
//	        session.beginTransaction();
	        String hql = "update Delivery set cname = :cname, phone = :phone, product = :product, num = :num, price = :price, ename = :ename, address = :address, time = :time where id = :id";
	        Query query = session.createQuery(hql);
	        query.setParameter("cname", delivery.getCname());
	        query.setParameter("phone", delivery.getPhone());
	        query.setParameter("product", delivery.getProduct());
	        query.setParameter("num", delivery.getNum());
	        query.setParameter("price", delivery.getPrice());
	        query.setParameter("ename", delivery.getEname());
	        query.setParameter("address", delivery.getAddress());
	        query.setParameter("time", delivery.getTime());
	        query.setParameter("id", delivery.getId());
	        
	        int rowsUpdated = query.executeUpdate(); 
	        
	        if (rowsUpdated > 0) {
	            isSuccess = true;
	        }
	        
//	        session.getTransaction().commit();
	    } catch (Exception e) {
	    	System.out.println("修改失敗");
//	    	session.getTransaction().rollback();
	        e.printStackTrace();
	    } finally {
//	        session.close();
	    }
	    
	    return isSuccess;
	}

	
	public List<Delivery> selectAll() {
	    Session session = factory.getCurrentSession();
//	    Session session = factory.openSession();
	    List<Delivery> delivery = null;
	    
	    try {
//	        session.beginTransaction();
	        String hql = "FROM Delivery"; 
	        Query<Delivery> query = session.createQuery(hql, Delivery.class);
	        delivery = query.list();
//	        session.getTransaction().commit();
	    } catch (Exception e) {
	    	System.out.println("查詢全部失敗");
//	    	session.getTransaction().rollback();
	        e.printStackTrace();
	    } finally {
//	        session.close();
	    }
	    
	    return delivery;
	}
	
	public Delivery selectOne(Integer id) {
	    Session session = factory.getCurrentSession();
//	    Session session = factory.openSession();
	    Delivery delivery = null;
	    
	    try {
//	        session.beginTransaction();
	        String hql = "FROM Delivery WHERE id = ?1"; 
	        Query<Delivery> query = session.createQuery(hql, Delivery.class);
	        query.setParameter(1, id);
	        List<Delivery> list = query.getResultList();
	        
	        if (!list.isEmpty()) {
	            delivery = list.get(0);
	        }
	        
//	        session.getTransaction().commit();
	    } catch (Exception e) {
	    	System.out.println("查詢單筆失敗");
//	    	session.getTransaction().rollback();
	        e.printStackTrace();
	    } finally {
//	        session.close();
	    }
	    
	    return delivery;
	}
	
	
	public boolean delete(Integer id) {
		 	Session session = factory.getCurrentSession(); 
//		 	Session session = factory.openSession(); 
		    boolean isSuccess = false;
		    
		    try {
//		    	session.beginTransaction();
		    	String hql = "delete from Delivery where id = :nn";
		        int deletedCount = session.createQuery(hql)
		                                 .setParameter("nn", id)
		                                 .executeUpdate();
		        
		        if (deletedCount > 0) {
		            isSuccess = true;
		        } else {
		            System.out.println("找不到指定的交付項目，無法刪除！");
		        }
//		        session.getTransaction().commit();
		    } catch (Exception e) {
		    	System.out.println("刪除失敗");
//		    	session.getTransaction().rollback();
		        e.printStackTrace();
		    } finally {
//		        session.close();
		    }
		    
		    return isSuccess;
		}
	}
	
	