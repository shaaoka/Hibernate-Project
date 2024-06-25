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

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Insert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			String orderId = request.getParameter("orderId");
			String customerName = request.getParameter("customerName");
			String amount = request.getParameter("amount");
			String payment = request.getParameter("payment");
			String pickup = request.getParameter("pickup");
			String orderStatus = request.getParameter("orderStatus");
			
			OrderDao orderDao = new OrderDao();
			OrderBean orderBean = new OrderBean();
			orderBean.setOrderId(orderId);
			orderBean.setCustomerName(customerName);
			orderBean.setAmount(amount);
			orderBean.setPayment(payment);
			orderBean.setPickup(pickup);
			orderBean.setOrderStatus(orderStatus);
			OrderBean newOrder = orderDao.insertOrder(orderBean);
			
			List<OrderDetailsBean> details = new ArrayList<>();
			String[] orderIds = request.getParameterValues("orderId");
			String[] productIds = request.getParameterValues("productId");
			String[] products = request.getParameterValues("product");
			String[] quantitys = request.getParameterValues("quantity");
			String[] unitPrices = request.getParameterValues("unitPrice");
			String[] notes = request.getParameterValues("note");
			
			for (int i = 0; i < products.length; i++) {
		        OrderDetailsBean detail = new OrderDetailsBean();
		        detail.setOrderId(orderIds[i]);
		        detail.setProductId(productIds[i]);
		        detail.setProduct(products[i]);
		        detail.setQuantity(quantitys[i]);
		        detail.setUnitPrice(unitPrices[i]);
		        detail.setNote(notes[i]);
		        
		        
		        details.add(detail);
		        
				}
			
//			for (OrderDetailsBean detail : details) {
//				OrderDetailsBean newDetails = orderDao.insertDetails(detail);
//				request.setAttribute("details", details);
//			}
			
			for (OrderDetailsBean detail : details) {
			    // 尝试插入每个订单详情
			    try {
			        OrderDetailsBean newDetails = orderDao.insertDetails(detail);
			        // 检查插入是否成功，如果成功则添加到请求属性中
			        if (newDetails != null) {
			            // 如果成功，则将新的订单详情添加到请求属性中
			            request.setAttribute("details", details);
			        } else {
			            // 如果插入失败，可能需要记录日志或者进行其他处理
			            // 这里先打印一个错误消息
			            System.err.println("Failed to insert order details.");
			        }
			    } catch (Exception e) {
			        // 处理可能出现的异常情况
			        e.printStackTrace();
			        // 这里可以根据具体情况进行处理，例如返回错误页面或者执行其他逻辑
			    }
			}
			
			OrderBean resultOrder = orderDao.selectOrderByOrderId(orderId);
			
			request.setAttribute("resultOrder", resultOrder);
			
			request.getRequestDispatcher("order/jsp/OrderSelect.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
