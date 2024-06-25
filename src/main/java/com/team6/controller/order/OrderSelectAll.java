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
import com.team6.model.OrderDetailsBean;


@WebServlet("/OrderSelectAll")
public class OrderSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrderSelectAll() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
	        OrderDao orderDao = new OrderDao();

	        List<OrderBean> orders = orderDao.selectAll();
	        
	        request.setAttribute("orders", orders);
	        
	        request.getRequestDispatcher("/order/jsp/OrderSelectAll.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
