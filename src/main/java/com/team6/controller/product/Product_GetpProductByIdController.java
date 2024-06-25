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

@WebServlet("/Product_GetpProductById")
public class Product_GetpProductByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Product_GetpProductByIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProductDAO productDAO = new ProductDAO();
		
		String productId = request.getParameter("productId");
		
		if(productId != null) {
			ProductBean productBean = productDAO.SelectById(Integer.parseInt(productId));
			request.setAttribute("productBean", productBean);
			request.getRequestDispatcher("/product/jsp/GetUpdateProduct.jsp").forward(request, response);
		}else {
			request.setAttribute("err", "錯誤!!!!!😱");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




















