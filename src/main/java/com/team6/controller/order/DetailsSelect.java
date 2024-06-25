package com.team6.controller.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.model.OrderBean;
import com.team6.model.OrderDao;
import com.team6.model.OrderDetailsBean;


@WebServlet("/DetailsSelect")
public class DetailsSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DetailsSelect() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			String orderId = request.getParameter("orderId");
			System.out.println(orderId);
			OrderDao orderDao = new OrderDao();
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
