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

@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			String orderId = request.getParameter("orderId");
			String detailsId = request.getParameter("detailsId");
			String productId = request.getParameter("productId");
			String product = request.getParameter("product");
			String unitPrice = request.getParameter("unitPrice");
			String quantity = request.getParameter("quantity");
			String note = request.getParameter("note");
			System.out.println(product);
			
			OrderDao orderDao = new OrderDao();
			if(product != null && detailsId != null) {
				if(product.equals("香菇意大利比薩")) {
					productId = "1";
					unitPrice = "150";
				}else if (product.equals("夏威夷德國比薩")) {
					productId = "2";
					unitPrice = "130";
				}else if (product.equals("起司義大利比薩")) {
					productId = "3";
					unitPrice = "180";
				}else if (product.equals("義大利雞肉焗烤麵")) {
					productId = "4";
					unitPrice = "220";
				}else if (product.equals("蘋果肉桂德國烤餅")) {
					productId = "5";
					unitPrice = "130";
				}else if (product.equals("炸雞塊(6塊)")) {
					productId = "6";
					unitPrice = "60";
				}else {
					product = "炸起司條(5條)";
					productId = "7";
					unitPrice = "60";
				}
				orderDao.updateProduct(detailsId, productId, product, unitPrice);
			}
			
			if(quantity != null && detailsId != null) {
				orderDao.updateQuantity(detailsId, quantity);
			}
			if(note != null && detailsId != null) {
				orderDao.updateNote(detailsId, note);
			}
			
			
			List<OrderDetailsBean> details = orderDao.selectDetailsByOrderId(orderId);
			
			request.setAttribute("details", details);
			
			request.getRequestDispatcher("/order/jsp/DetailsUpdateSelect.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
