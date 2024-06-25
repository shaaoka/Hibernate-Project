package com.team6.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.team6.model.ProductBean;
import com.team6.model.ProductCategory;
import com.team6.model.ProductDAO;
import com.team6.model.ProductState;


@WebServlet("/Product_Insert")
@MultipartConfig(location = "D:/Hibernate/workspace/team6/src/main/webapp/product/images/")
public class Product_InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Product_InsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProductBean productBean = new ProductBean();
		
		if(request.getParameter("categoryId") != null) {
			productBean.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
		}
		productBean.setProductName(request.getParameter("productName"));
		productBean.setProductDesc(request.getParameter("productDesc"));
		productBean.setProductPrice(request.getParameter("productPrice"));
		productBean.setProductStateId(1);
		
		ProductDAO productDAO = new ProductDAO();
		
		Part part = request.getPart("productImg_url");
		if (part != null && part.getSize() > 0) {
			String fileName = getFileName(part);
			part.write(fileName);
			// 取得路徑
			String path = "product/images/" + fileName;
			
			productBean.setProductImg_url(path);
			productDAO.InsertProduct(productBean);
			
		} else {
			productDAO.InsertProduct(productBean);
		}
		
		request.setAttribute("productBean", productBean);
		request.getRequestDispatcher("/product/jsp/InsertProduct_view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		int slashIdx = header.lastIndexOf("\\");
		String filename;
		if (slashIdx != -1)
			filename = header.substring(slashIdx + 1, header.length()-1);			
		else {
			int idx = header.indexOf("filename");
			filename = header.substring(idx + 10, header.length()-1);
		}
//		System.out.println(filename);
		return filename;
	}
	
	
}
