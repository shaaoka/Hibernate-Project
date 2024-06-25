package com.team6.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.model.OrderDao;
import com.team6.model.OrderDetailsBean;


@WebServlet("/DeleteDetails")
public class DeleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteDetails() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("abc");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		try {
			String orderId = request.getParameter("orderId");
			String product = request.getParameter("product");
			
			OrderDao orderDao = new OrderDao();
			orderDao.deleteButton(orderId, product);
			
			List<OrderDetailsBean> details = orderDao.selectDetailsByOrderId(orderId);
			
			request.setAttribute("details", details);
			
			request.getRequestDispatcher("/order/jsp/DetailsSelect.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
