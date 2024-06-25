package com.team6.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.model.ProductBean;
import com.team6.model.ProductDAO;

@WebServlet("/Product_Delete")
public class Product_DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Product_DeleteController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		ProductDAO productDAO = new ProductDAO();
		productDAO.DeleteProduct(productId);
		
		List<ProductBean> productBeans = productDAO.SelectAll();
		
		request.setAttribute("productBeans", productBeans);
		
		request.getRequestDispatcher("/product/jsp/GetAllProducts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
