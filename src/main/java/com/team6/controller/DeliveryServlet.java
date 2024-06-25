package com.team6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.model.Delivery;
import com.team6.model.DeliveryDao;


@WebServlet("/DeliveryServlet")
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeliveryServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String cname = request.getParameter("cname");
		String phone = request.getParameter("phone");
		String product = request.getParameter("product");
		String num = request.getParameter("num");
		String price = request.getParameter("price");
		String ename = request.getParameter("ename");
		String address = request.getParameter("address");
		String time = request.getParameter("time");
		String message = request.getParameter("message");
		
		
		Delivery delivery = new Delivery();
		if(id != null) {
			delivery.setId(Integer.parseInt(id));
		}
		delivery.setCname(cname);
		delivery.setPhone(phone);
		delivery.setProduct(product);	
		if (num != null) {
			delivery.setNum(Integer.parseInt(num));
		}
		if (price != null) {
			delivery.setPrice(Integer.parseInt(price));
		}
		delivery.setAddress(address);
		delivery.setEname(ename);
		if (time != null) {
			delivery.setTime(Integer.parseInt(time));
		}
		
		DeliveryDao deliveryDao = new DeliveryDao();

		System.out.println(id);
		switch (message) {
		case "ins": { 
			boolean isSccuess = deliveryDao.insert(delivery);
			if (isSccuess) {
				request.getRequestDispatcher("/delivery/jsp/insert.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			} 
			break;
		}
		case "upd": { 
			delivery = deliveryDao.selectOne(Integer.parseInt(id));
			request.setAttribute("deliveryBean", delivery);
			request.getRequestDispatcher("/delivery/jsp/DoUpdate.jsp").forward(request, response);
			break;
		}
		case "Update": { 
			boolean isSccuess = deliveryDao.update(delivery);
			if(isSccuess) {
				request.getRequestDispatcher("/delivery/jsp/update.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			}	
			break;
			
		}

		
		case "Get":{
			List<Delivery> deliveryBeans = deliveryDao.selectAll();
			request.setAttribute("deliveryBeans", deliveryBeans);
			request.getRequestDispatcher("/delivery/jsp/GetAll.jsp").forward(request, response);
			break;
		}
		
		
		case "del": {	
			boolean isSccuess = deliveryDao.delete(Integer.parseInt(id));
			if (isSccuess) {
				List<Delivery> deliveryBeans = deliveryDao.selectAll();
				request.setAttribute("deliveryBeans", deliveryBeans);
				request.getRequestDispatcher("/delivery/jsp/GetAll.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			}
			break;
		}
		
		case "Getone": {
				delivery = deliveryDao.selectOne(Integer.parseInt(id));
				request.setAttribute("deliveryBean", delivery);
				request.getRequestDispatcher("/delivery/jsp/Getone.jsp").forward(request, response);			
				break;
		}
		default :{
			request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			break;
		}

	}
	}
			

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
