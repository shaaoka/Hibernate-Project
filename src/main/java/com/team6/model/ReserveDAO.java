package com.team6.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.team6.model.ReserveBean;
import com.team6.util.HibernateUtil;

public class ReserveDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	Context context;
	ResultSet rs =null;
    ReserveBean reserve = null;
	private SessionFactory factory;

	public ReserveDAO() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	//ok
	public List<ReserveBean> checkInByName(String name) {
	    String hql = "from ReserveBean where reservation_name like :name and reservation_status = 1 and checkIn_status = 0 order by reservation_date asc, reservation_time asc";
	    List<ReserveBean> reserves = new ArrayList<>();
	    Session session = factory.getCurrentSession();

	    try {           
	        Query<ReserveBean> query = session.createQuery(hql, ReserveBean.class);
	        query.setParameter("name", "%" + name + "%"); // 參數化查詢條件
	        reserves = query.getResultList();              
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("查詢失敗：" + e.getMessage());
	    }
	    return reserves;
	}
	//ok
	public List<ReserveBean> checkInByPhone(String phone) {
		String hql = "from ReserveBean where phone = :phone and reservation_status = 1 and checkIn_status = 0 order by reservation_date asc, reservation_time asc";
	    List<ReserveBean> reserves = new ArrayList<>();
	    Session session = factory.getCurrentSession();

	    try {
	        Query<ReserveBean> query = session.createQuery(hql, ReserveBean.class);
	        query.setParameter("phone", phone); // 參數化查詢條件
	        reserves = query.getResultList();	  
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return reserves;
	}
	//ok
	public List<ReserveBean> selectReservationData(String date) {
		String hql = "from ReserveBean where reservation_date = :date and reservation_status=1 ORDER BY reservation_date ASC, reservation_time ASC";
		List<ReserveBean> reserves = new ArrayList<>();
		Session session = factory.getCurrentSession();
		try {
			Query<ReserveBean> query = session.createQuery(hql, ReserveBean.class);
			query.setParameter("date", date);
			reserves = query.getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return reserves;
	}
	//ok
	public List<ReserveBean> selectReservationStatus(){
		String hql ="from ReserveBean where reservation_status=0 ORDER BY reservation_date ASC, reservation_time ASC";
		List<ReserveBean> reserves = new ArrayList<>();
		Session session = factory.getCurrentSession();
		try {
			Query<ReserveBean> query = session.createQuery(hql, ReserveBean.class);
			reserves = query.getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		 return reserves;	
	}
	//ok
	public List<ReserveBean> selectAllChecked() {
		String hql = "from ReserveBean where checkIn_status=1 AND reservation_date = :date ORDER BY reservation_time ASC";
		List<ReserveBean> reserves = new ArrayList<>();
		Session session = factory.getCurrentSession();
		try {
			Query<ReserveBean> query = session.createQuery(hql, ReserveBean.class);
			LocalDate currentDate = LocalDate.now(); // 獲取當前日期
			String dateString = currentDate.toString(); // 將 LocalDate 轉換為字串
			query.setParameter("date", dateString); // 將字串類型的日期參數設置給 HQL 查詢
			reserves = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reserves;
	}
	//ok
	public void updateNumberOfPeople(String reservationId, int newNumberOfPeople) {
	    String hql = "update ReserveBean set numberOfPeople = :people WHERE reservation_id = :id";
	    Session session = factory.getCurrentSession();
	    try {
	        session.createQuery(hql)
	               .setParameter("people", Integer.toString(newNumberOfPeople)) // 將整數轉換為字串
	               .setParameter("id", reservationId) // 使用參數而不是字串 "reservationId"
	               .executeUpdate(); 		
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	//ok
	public void updateReservationDate(String reservationId, String reservation_date) {
		String hql = "update ReserveBean SET reservation_date = :date WHERE reservation_id = :id";
		Session session = factory.getCurrentSession();
		try {
			session.createQuery(hql).setParameter("date", reservation_date).setParameter("id", reservationId)
					.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ok
	public void updateReservationTime(String reservationId, String reservation_time) {
		String hql = "update ReserveBean SET reservation_time = :time WHERE reservation_id = :id";
		Session session = factory.getCurrentSession();
		try {
			session.createQuery(hql).setParameter("time", reservation_time).setParameter("id", reservationId)
					.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ok
	public void deleteReservation(String reservationId) {
		String hql = "delete FROM ReserveBean WHERE reservation_id = :id";
		Session session = factory.getCurrentSession();
		try {
			session.createQuery(hql).setParameter("id", reservationId).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ok
	public void updateReservationStatus(String reservation_id) {
		String hql = "update ReserveBean SET reservation_status=1 WHERE reservation_id= :id";
		Session session = factory.getCurrentSession();
		try {
			session.createQuery(hql).setParameter("id", reservation_id).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ok
	public void InsertReservation(String ispanTeam2, String numberOfPeople, String reservationDate, String phone, String reservationTime, String specialRequests, String reservationName) {

	    Session session = factory.getCurrentSession();
	    try {
	        ReserveBean reserve = new ReserveBean();

	        reserve.setAccount("ispanTeam2");
	        reserve.setNumberOfPeople(numberOfPeople);
	        reserve.setReservation_name(reservationName);
	        reserve.setPhone(phone);
	        reserve.setReservation_time(reservationTime);
	        reserve.setReservation_date(reservationDate);
	        reserve.setSpecial_requests(specialRequests);
	        reserve.setRservation_status("0");
	        reserve.setCheckIn_status("0");
	        session.save(reserve);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	//ok
	public void updateCheckInStatus(String reservation_id) {
		String hql = "UPDATE ReserveBean SET checkIn_status=1 WHERE reservation_id= :id";
		Session session = factory.getCurrentSession();
		try {
			session.createQuery(hql).setParameter("id", reservation_id).executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ok
	public void deleteCheckInStatus(String reservation_id) {
		String hql = "DELETE FROM ReserveBean WHERE reservation_id :id";
		Session session = factory.getCurrentSession();
		try {
			session.createQuery(hql).setParameter("id", reservation_id).executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}	
	

