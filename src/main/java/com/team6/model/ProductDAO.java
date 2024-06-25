package com.team6.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.team6.model.ProductBean;
import com.team6.util.HibernateUtil;

public class ProductDAO {
	
//	private Session session;

	private SessionFactory factory;
	
	public ProductDAO() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		this.factory = factory;
//		this.session = factory.getCurrentSession();
	}

	// 新增
	public void InsertProduct(ProductBean productBean) {
		
		Session session = factory.getCurrentSession();
		
		session.save(productBean);
		
	}
	
	public void DeleteProduct(Integer productId) {
		
		Session session = factory.getCurrentSession();
		
		String hql = "Delete from ProductBean where productId = :pId";
		Query query = session.createQuery(hql);
		query.setParameter("pId", productId).executeUpdate();
		System.out.println("Deleted!!👏👏👏");
	}
	
	
	// 偽刪除，修改
	public void ChangeProductState(Integer productId, Integer stateId) {
		
		Session session = factory.getCurrentSession();
		
		String hql = "Update ProductBean set ProductStateId = :pState where productId = :pId";
		Query query = session.createQuery(hql);
		query.setParameter("pId", productId);
		query.setParameter("pState", stateId);
		query.executeUpdate();
		System.out.println("👌👌👌👌77777👌👌👌");
	}
	
	
	// 修改								
	public void UpdateProduct(ProductBean productBean) {
		
		Session session = factory.getCurrentSession();
		
		String hql = "Update ProductBean set CategoryId = :cId,"
				+ " productName = :pName, productDesc = :pDesc,"
				+ " productImg_url = :pUrl, productPrice = :pPrice,"
				+ " ProductStateId = :pState where productId = :pId"; 
		
		Query query = session.createQuery(hql);
		query.setParameter("pId", productBean.getProductId());
		query.setParameter("cId", productBean.getCategoryId());
		query.setParameter("pName", productBean.getProductName());
		query.setParameter("pDesc", productBean.getProductDesc());
		query.setParameter("pUrl", productBean.getProductImg_url());
		query.setParameter("pPrice", productBean.getProductPrice());
		query.setParameter("pState", productBean.getProductStateId());
		
		query.executeUpdate();
		System.out.println("👌👌👌👌👌👌👌");
	}
	
	// 修改沒改照片
	public void UpdateProductNoImg(ProductBean productBean) {

		Session session = factory.getCurrentSession();
		
		String hql = "Update ProductBean set CategoryId = :cId," + " productName = :pName, productDesc = :pDesc,"
				+ " productPrice = :pPrice," + " ProductStateId = :pState where productId = :pId";

		Query query = session.createQuery(hql);
		query.setParameter("pId", productBean.getProductId());
		query.setParameter("cId", productBean.getCategoryId());
		query.setParameter("pName", productBean.getProductName());
		query.setParameter("pDesc", productBean.getProductDesc());
		query.setParameter("pPrice", productBean.getProductPrice());
		query.setParameter("pState", productBean.getProductStateId());

		query.executeUpdate();
		System.out.println("👌👌👌👌👌👌👌");
	}
	
//	// 修改								
//	public ProductBean UpdateProduct(ProductBean productBean) {
//		
//		
//		ProductState productState = session.get(ProductState.class,	productBean.getProductStateId());
//		productBean.setProductState(productState);
//		
//		ProductCategory productCategory = session.get(ProductCategory.class, productBean.getCategoryId());
//		productBean.setProductCategory(productCategory);
//		
//		ProductBean oldProductBean = session.get(ProductBean.class, productBean.getProductId());
//		oldProductBean = productBean;
//		oldProductBean.setCategoryId(productBean.getCategoryId());
//		oldProductBean.setProductName(productBean.getProductName());
//		oldProductBean.setProductDesc(productBean.getProductDesc());
//		oldProductBean.setProductImg_url(productBean.getProductImg_url());
//		oldProductBean.setProductPrice(productBean.getProductPrice());
//		oldProductBean.setProductStateId(productBean.getProductStateId());
//		oldProductBean.setProductCategory(productCategory);
//		oldProductBean.setProductState(productState);
//		
//		return oldProductBean;
//	}
	
	
	// 查詢單筆ById
	public ProductBean SelectById(Integer productId) {
		
		Session session = factory.getCurrentSession();
		
		ProductBean productBean = session.get(ProductBean.class, productId);
		
		
		if(productBean != null) {
			return productBean;
		}
		return null;
	}
	
	
	// 模糊查詢
	public List<ProductBean> SelectName(String name) {
		
		Session session = factory.getCurrentSession();
		
		try {
			String hql = "from ProductBean p where p.productName like :n";
			Query<ProductBean> query = session.createQuery(hql, ProductBean.class)
					.setParameter("n", "%" + name + "%");
			List<ProductBean> resultList = query.getResultList();
			
			return resultList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	// 查詢全部
	public List<ProductBean> SelectAll() {
		
		Session session = factory.getCurrentSession();
		
		Query<ProductBean> query = session.createQuery("from ProductBean", ProductBean.class);
		List<ProductBean> resultList = query.getResultList();
		return resultList;
		
	}

	
	
	
	
}
