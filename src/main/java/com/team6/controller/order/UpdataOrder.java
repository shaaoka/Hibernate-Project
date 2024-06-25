package com.team6.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.model.OrderBean;
import com.team6.model.OrderDao;


@WebServlet("/UpdateOrder")
public class UpdataOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdataOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			String orderId = request.getParameter("orderId");
			String payment = request.getParameter("payment");
			String pickup = request.getParameter("pickup");
			String orderStatus = request.getParameter("orderStatus");
			
			
			OrderDao orderDao = new OrderDao();
			if(payment != null && orderId != null) {
				orderDao.updatePayment(orderId, payment);
			}
			if(pickup != null && orderId != null) {
				orderDao.updatePickup(orderId, pickup);				
			}
			if(orderStatus != null && orderId != null) {
				orderDao.updateOrderStatus(orderId, orderStatus);
			}
			
			
			List<OrderBean> orders = orderDao.selectAll();
			request.setAttribute("orders", orders);
			
			request.getRequestDispatcher("/order/jsp/OrderUpdateSelect.jsp").forward(request, response);	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
