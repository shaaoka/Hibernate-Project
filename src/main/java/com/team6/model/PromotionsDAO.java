//package com.team6.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//
//import com.team6.model.PromotionsBean;
//import com.team6.util.HibernateUtil;
//
//public class PromotionsDAO {
//	
//	private SessionFactory factory;
//	
//	public PromotionsDAO() {
//		this.factory = HibernateUtil.getSessionFactory();
//	}
//
//	// 新增
//	public void InsertPromotions(PromotionsBean promotionsBean) {
//		
//		Session session = factory.getCurrentSession();
//		
//		session.save(promotionsBean);
//		
//	}
//	
//	public PromotionsBean SelectById(Integer PromotionsId) {
//		
//		Session session = factory.getCurrentSession();
//		
//		PromotionsBean PromotionsBean = session.get(PromotionsBean.class, PromotionsId);
//		
//		if(PromotionsBean != null) {
//			return PromotionsBean;
//		}
//		return null;
//	}
//	
//	
//	// 模糊查詢
//	public List<PromotionsBean> SelectName(String name) {
//		
//		try {
//			Session session = factory.getCurrentSession();
//			String hql = "from PromotionsBean p where p.PromotionsName like :n";
//			Query<PromotionsBean> query = session.createQuery(hql, PromotionsBean.class)
//					.setParameter("n", "%" + name + "%");
//			List<PromotionsBean> resultList = query.getResultList();
//			
//			return resultList;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//		
//	// 查詢全部
//	public List<PromotionsBean> SelectAll() {
//		Session session = factory.getCurrentSession();
//		
//		Query<PromotionsBean> query = session.createQuery("from PromotionsBean", PromotionsBean.class);
//		List<PromotionsBean> resultList = query.getResultList();
//		
//		return resultList;
//	}
//
//	
//	
//	
//	
//}


package com.team6.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.team6.util.HibernateUtil;

public class PromotionsDAO {

    private SessionFactory sessionFactory;

    public PromotionsDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // 新增
    public boolean insertPromotions(PromotionsBean promotionsBean) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        boolean isSuccess = false;
        PromotionsBean bean=session.get(PromotionsBean.class, promotionsBean.getPromotions_id());
        try {
//            tx = session.beginTransaction();
        	System.out.println("ddddd");
        	System.out.println(promotionsBean);
        	if(bean==null) {
        		Serializable save = session.save(promotionsBean);
        		System.out.println("123:"+save);
        	}
//            tx.commit();
            isSuccess = true;
        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return isSuccess;
    }

    // 刪除
    public boolean deletePromotions(String promotionsId) {
        Session session = sessionFactory.openSession();
//		String hql="delete from PromotionsBean where promotions_id = ?";
        Transaction tx = null;
        boolean isSuccess = false;
        try {
            tx = session.beginTransaction();
            PromotionsBean promotionsBean = session.get(PromotionsBean.class, promotionsId);
            if (promotionsBean != null) {
//            	session.createQuery(hql,PromotionsBean.class).setParameter(1, promotionsId);
                session.delete(promotionsBean);
                tx.commit();
                isSuccess = true;
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isSuccess;
    }

    // 修改
    public boolean updatePromotions(PromotionsBean promotionsBean) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        boolean isSuccess = false;
        try {
//            tx = session.beginTransaction();
            session.update(promotionsBean);
//            tx.commit();
            isSuccess = true;
        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return isSuccess;
    }

    // 查詢單個
    public PromotionsBean selectOne(String promotionsId) {
        Session session = sessionFactory.getCurrentSession();
        PromotionsBean promotionsBean = null;
        try {
            promotionsBean = session.get(PromotionsBean.class, promotionsId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return promotionsBean;
    }

    // 查詢全部
    public List<PromotionsBean> selectAll() {
        Session session = sessionFactory.getCurrentSession();
        List<PromotionsBean> promotionsBeans = null;
        try {
            promotionsBeans = session.createQuery("FROM PromotionsBean", PromotionsBean.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return promotionsBeans;
    }
}

