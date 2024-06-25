package com.team6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.model.ReserveDAO;
import com.team6.model.ReserveBean;


@WebServlet("/ReserveHomePage")
public class ReserveHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReserveBean reserve = new ReserveBean();
	
    
    public ReserveHomePage() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String selectButton = request.getParameter("checkin");//找的是name為checkin的值(為123)
//	String type = request.getParameter("nameSelect");//找的是我在nameSelect中輸入的值
	
	if (selectButton.equals("selectByName")) {
	    System.out.println("successSelectByName");
		ReserveDAO ReserveDAO = new ReserveDAO();
	    String name = request.getParameter("nameSelect");
	    List<ReserveBean> selectName = ReserveDAO.checkInByName(name);    
		request.setAttribute("selectName", selectName);
		request.getRequestDispatcher("./reservation/jsp/checkInByName.jsp").forward(request, response);
    }
	else if(selectButton.equals("selectByPhone") ) {
	    System.out.println("successPhoneSelect");
	    ReserveDAO ReserveDAO = new ReserveDAO();
	    String phone = request.getParameter("phoneSelect");
	    List<ReserveBean> selectByPhone = ReserveDAO.checkInByPhone(phone);
		request.setAttribute("selectName", selectByPhone);
		request.getRequestDispatcher("./reservation/jsp/checkInByName.jsp").forward(request, response);
		
    }
	else if (selectButton.equals("selectByDate")) {
	    System.out.println("successSelectByDate");
	    ReserveDAO ReserveDAO = new ReserveDAO();
	    String date = request.getParameter("dateSelect");
	    List<ReserveBean> dateReservations = ReserveDAO.selectReservationData(date);
	    request.setAttribute("reservations", dateReservations); // 注意這裡的屬性名稱使用複數形式
	    request.getRequestDispatcher("./reservation/jsp/reservationData.jsp").forward(request, response);    
	}
	else if(selectButton.equals("confirmReservation")) {
		System.out.println("successConfirmReservation");
	    ReserveDAO ReserveDAO = new ReserveDAO();
	    String phone = request.getParameter("phone");
	    ReserveDAO.updateReservationStatus(phone);
	    request.getRequestDispatcher("./reservation/jsp/test.jsp").forward(request, response);    

	}
	else if (selectButton.equals("selectByStatus")) {
	    System.out.println("successselectByStatus");
	    ReserveDAO ReserveDAO = new ReserveDAO();
	    List<ReserveBean> selectReservationStatus= ReserveDAO.selectReservationStatus();
	    request.setAttribute("selectReservationStatus", selectReservationStatus);
	    request.getRequestDispatcher("./reservation/jsp/reservationDataConfirm.jsp").forward(request, response);    
	}
	else if(selectButton.equals("customerReserve")) {
		String numberOfPeople = request.getParameter("people");
		String reservationDate = request.getParameter("date");
		String phone = request.getParameter("phone");
		String reservationTime = request.getParameter("time");
		String specialRequests = request.getParameter("note");
		String reservationName = request.getParameter("name");

//		System.out.println("successReserve");
	    ReserveDAO ReserveDAO = new ReserveDAO();
	    ReserveDAO.InsertReservation("ispanTeam2",numberOfPeople, reservationDate, phone, reservationTime, specialRequests, reservationName);
		reserve.setNumberOfPeople(numberOfPeople);
		reserve.setReservation_date(reservationDate);
		reserve.setPhone(phone);
		reserve.setReservation_date(reservationDate);
		reserve.setReservation_time(reservationTime);
		reserve.setReservation_name(reservationName);
		    
		request.setAttribute("insertReservation", reserve);
		request.getRequestDispatcher("./reservation/jsp/reserveSuccess.jsp").forward(request, response);
	            
	}
	else if(selectButton.equals("selectAllChecked")) {
		ReserveDAO ReserveDAO = new ReserveDAO();
	    List<ReserveBean> selectAllChecked = ReserveDAO.selectAllChecked();    
		request.setAttribute("selectAllChecked", selectAllChecked);
		request.getRequestDispatcher("./reservation/jsp/selectAllChecked.jsp").forward(request, response);		
	}
}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");

	    if ("updateNumberOfPeople".equals(action)) {
	        String reservationId = request.getParameter("reservationId");
	        String newNumberOfPeopleStr = request.getParameter("newNumberOfPeople");
	        int newNumberOfPeople = Integer.parseInt(newNumberOfPeopleStr);

	        ReserveDAO reserveDAO = new ReserveDAO();
	        reserveDAO.updateNumberOfPeople(reservationId, newNumberOfPeople);

	        response.setContentType("text/plain");
	        response.getWriter().write("Update successful");
	    } else if ("updateReservationDate".equals(action)) {
	        String reservationId = request.getParameter("reservationId");
	        String newDate = request.getParameter("newDate");

	        ReserveDAO reserveDAO = new ReserveDAO();
	        reserveDAO.updateReservationDate(reservationId, newDate);

	        response.setContentType("text/plain");
	        response.getWriter().write("Update successful");
	    } else if ("updateReservationTime".equals(action)) {
	        String reservationId = request.getParameter("reservationId");
	        String newTime = request.getParameter("newTime");

	        ReserveDAO reserveDAO = new ReserveDAO();
	        reserveDAO.updateReservationTime(reservationId, newTime);

	        response.setContentType("text/plain");
	        response.getWriter().write("Update successful");
	    } else if ("deleteReservation".equals(action)) {
	        String reservationId = request.getParameter("reservationId");

	        ReserveDAO reserveDAO = new ReserveDAO();
	        reserveDAO.deleteReservation(reservationId);

	        response.setContentType("text/plain");
	        response.getWriter().write("Delete successful");
	    } else if("confirmReservation".equals(action)) {
	        String reservationId = request.getParameter("reservationId");
	        
	        ReserveDAO reserveDAO = new ReserveDAO();
	        reserveDAO.updateReservationStatus(reservationId);
	        
	        response.setContentType("text/plain");
	        response.getWriter().write("comfirm successful"); 	
	    } else if("checkInSuccess".equals(action)) {
	        String reservationId = request.getParameter("reservationId");
	        ReserveDAO reserveDAO = new ReserveDAO();
	        reserveDAO.updateCheckInStatus(reservationId);
	        response.setContentType("text/plain");
	        response.getWriter().write("check in success!"); 
	    } else if(("deleteCheckIn").equals(action)){
	        String reservationId = request.getParameter("reservationId");
	        ReserveDAO reserveDAO = new ReserveDAO();
	        reserveDAO.deleteCheckInStatus(reservationId);
	        response.setContentType("text/plain");
	        response.getWriter().write("delete check in success!");
	    }     
	}

}
	
