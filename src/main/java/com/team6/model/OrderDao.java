package com.team6.model;

import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.team6.util.HibernateUtil;

public class OrderDao {

	private SessionFactory factory;

	public OrderDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	// 查詢全部(所有訂單)
	public List<OrderBean> selectAll() {
		Session session = factory.getCurrentSession();
		List<OrderBean> resultList = null;
		try {
//			session.beginTransaction();

			Query<OrderBean> query = session.createQuery("from OrderBean", OrderBean.class);
			resultList = query.getResultList();

//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;

	}

	// 查詢全部(所有餐點明細)
	public List<OrderDetailsBean> selectAllDetails() {
		Session session = factory.getCurrentSession();
		List<OrderDetailsBean> resultList = null;
		try {
//			session.beginTransaction();

			Query<OrderDetailsBean> query = session.createQuery("from OrderDetailsBean", OrderDetailsBean.class);
			resultList = query.getResultList();

//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	// 用orderId查詢單筆訂單
	public OrderBean selectOrderByOrderId(String orderId) {
		Session session = factory.getCurrentSession();
		OrderBean result = null;

		try {
//			session.beginTransaction();

			Query<OrderBean> query = session.createQuery("from OrderBean where orderId=:orderId", OrderBean.class);
			query.setParameter("orderId", orderId);
			result = query.getSingleResult();

//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 用orderID查詢單筆訂單明細
	public List<OrderDetailsBean> selectDetailsByOrderId(String orderId) {
		Session session = factory.getCurrentSession();
		List<OrderDetailsBean> resultList = null;

		try {
//			session.beginTransaction();

			Query<OrderDetailsBean> query = session.createQuery("from OrderDetailsBean where orderId = :orderId",
					OrderDetailsBean.class);
			query.setParameter("orderId", orderId);
			resultList = query.getResultList();
			System.out.println(toString());
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultList;

	}

	// 模糊查詢 - 訂單(訂購人姓名)
	public List<OrderBean> selectOrderLIKE(String customerName) {

		try {
			Session session = factory.getCurrentSession();
			String hql = "from OrderBean o where o.productName like :n";
			Query<OrderBean> query = session.createQuery(hql, OrderBean.class).setParameter("n",
					"%" + customerName + "%");
			List<OrderBean> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//新增訂單
	public OrderBean insertOrder(OrderBean orderBean) {
	    Session session = null;
	    try {
	        session = factory.getCurrentSession();
//	        session.beginTransaction();
	        
	        OrderBean newOrder = session.get(OrderBean.class, orderBean.getOrderId());
	        
	        if(newOrder == null) {
	            session.save(orderBean);
//	            session.getTransaction().commit(); // 提交事務
	            return orderBean;
	        }
	    } catch (Exception e) {
//	        if (session != null && session.getTransaction().isActive()) {
//	            session.getTransaction().rollback(); // 回滾事務
//	        }
	        e.printStackTrace();
	    }
	    return null;
	}

	//新增餐點明細
	public OrderDetailsBean insertDetails(OrderDetailsBean detail) {
	    Session session = null;
	    try {
	        session = factory.getCurrentSession();
//	        session.beginTransaction();
	        
	        Query query = session.createQuery("from OrderDetailsBean where orderId = :orderId and product = :product");
	        query.setParameter("orderId", detail.getOrderId());
	        query.setParameter("product", detail.getProduct());
	        List<OrderDetailsBean> existingDetails = query.list();
	        
	        if (existingDetails.isEmpty()) {
	            session.save(detail);
//	            session.getTransaction().commit(); // 提交事务
	            return detail;
	        } else {
	            return null;
	        }
	    } catch (Exception e) {
//	        if (session != null && session.getTransaction().isActive()) {
//	            session.getTransaction().rollback(); // 回滚事务
//	        }
	        e.printStackTrace();
	    }
	    return null;
	}

	
	
	// 修改Order payment
	public boolean updatePayment(String orderId, String payment) {
		Session session = factory.getCurrentSession();
		boolean result = false;
		
		try {
//			session.beginTransaction();
			String hql = "update OrderBean set payment=:payment where orderId=:orderId";
			Query<OrderBean> query = session.createQuery(hql);
			query.setParameter("payment", payment);
			query.setParameter("orderId", orderId);
			
			int update = query.executeUpdate();
			
			if(update > 0) {
				result = true;
			}
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 修改Order pickup
	public boolean updatePickup(String orderId, String pickup) {
		Session session = factory.getCurrentSession();
		boolean result = false;
		
		try {
//			session.beginTransaction();
			String hql = "update OrderBean set pickup=:pickup where orderId=:orderId";
			Query<OrderBean> query = session.createQuery(hql);
			query.setParameter("pickup", pickup);
			query.setParameter("orderId", orderId);
			
			int update = query.executeUpdate();
			
			if(update > 0) {
				result = true;
			}
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 修改Order orderStatus
	public boolean updateOrderStatus(String orderId, String orderStatus) {
		Session session = factory.getCurrentSession();
		boolean result = false;
		
		try {
//			session.beginTransaction();
			String hql = "update OrderBean set orderStatus=:orderStatus where orderId=:orderId";
			Query<OrderBean> query = session.createQuery(hql);
			query.setParameter("orderStatus", orderStatus);
			query.setParameter("orderId", orderId);
			
			int update = query.executeUpdate();
			
			if(update > 0) {
				result = true;
			}
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 修改Detail product&id&unitprice
	public boolean updateProduct(String detailsId, String productId, String product, String unitPrice) {
		Session session = factory.getCurrentSession();
		boolean result = false;
		
		try {
//			session.beginTransaction();
			String hql = "update OrderDetailsBean set productId=:productId, product=:product, unitPrice=:unitPrice where detailsId=:detailsId";
			Query<OrderBean> query = session.createQuery(hql);
			query.setParameter("productId", productId);
			query.setParameter("product", product);
			query.setParameter("unitPrice", unitPrice);
			query.setParameter("detailsId", Integer.parseInt(detailsId));
			
			
			int update = query.executeUpdate();
			
			if(update > 0) {
				result = true;
			}
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//修改Details quantity
	public boolean updateQuantity(String detailsId, String quantity) {
		Session session = factory.getCurrentSession();
		boolean result = false;
		
		try {
//			session.beginTransaction();
			String hql = "update OrderDetailsBean set quantity=:quantity where detailsId=:detailsId";
			Query<OrderBean> query = session.createQuery(hql);
			query.setParameter("quantity", quantity);
			query.setParameter("detailsId", Integer.parseInt(detailsId));
			
			int update = query.executeUpdate();
			
			if(update > 0) {
				result = true;
			}
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//修改Details note
	public boolean updateNote(String detailsId, String note) {
		Session session = factory.getCurrentSession();
		boolean result = false;
		
		try {
//			session.beginTransaction();
			String hql = "update OrderDetailsBean set note=:note where detailsId=:detailsId";
			Query<OrderBean> query = session.createQuery(hql);
			query.setParameter("note", note);
			query.setParameter("detailsId", Integer.parseInt(detailsId));
			
			int update = query.executeUpdate();
			
			if(update > 0) {
				result = true;
			}
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	
	// 用訂單編號刪除訂單及訂單明細
	public boolean deleteBothByOrderId(String orderId) {
		Session session = factory.getCurrentSession();
		boolean result = false;
		try {
//			session.beginTransaction();

			String hqlDetails = "delete from OrderDetailsBean where orderId = :orderId";
			int deletedDetailsCount = session.createQuery(hqlDetails).setParameter("orderId", orderId).executeUpdate();

			String hqlOrder = "delete from OrderBean where orderId = :orderId";
			int deletedOrderCount = session.createQuery(hqlOrder).setParameter("orderId", orderId).executeUpdate();

			if (deletedDetailsCount != 0 || deletedOrderCount != 0) {
				result = true;
			} else {
				System.out.println("沒有這筆訂單明細編號，無法刪除！");
			}

//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// deleteButton 刪除單個餐點明細
	public boolean deleteButton(String orderId, String product) {
		Session session = factory.getCurrentSession();
		System.out.println("aaa");
		boolean result = false;
		try {
//			session.beginTransaction();
			System.out.println("bbb");
			String hql = "delete from OrderDetailsBean where orderId = :orderId and product = :product";

			int deleteCount = session.createQuery(hql).setParameter("orderId", orderId).setParameter("product", product)
					.executeUpdate();
			System.out.println("ccc");
			if (deleteCount != 0) {
				result = true;
			} else {
				System.out.println("餐點明細刪除失敗！");
			}
			System.out.println("ddd");
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}