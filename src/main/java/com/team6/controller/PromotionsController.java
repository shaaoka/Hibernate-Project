//package com.team6.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.team6.model.PromotionsBean;
//import com.team6.model.PromotionsDAO;
//
//
///**
// * Servlet implementation class Sdsghfi1
// */
//@WebServlet("/PromotionsController")
//public class PromotionsController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public PromotionsController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		
//		
//		PromotionsBean promotionsBean = new PromotionsBean();
//		promotionsBean.setPromotions_id(request.getParameter("Promotions_id"));
////		promotionsBean.setPromotions_id(Integer.parseInt(request.getParameter("promotions_id")));
//		promotionsBean.setPromotions_name(request.getParameter("Promotions_name"));
//		promotionsBean.setPromotions_content(request.getParameter("Promotions_content"));
//		promotionsBean.setPromotions_picture(request.getParameter("Promotions_picture"));
//		promotionsBean.setPromotions_discount(request.getParameter("Promotions_discount"));
////		promotionsBean.setPromotions_discount(Double.parseDouble(request.getParameter("Promotions_discount")));
//		promotionsBean.setPromotions_discountCode(request.getParameter("Promotions_discountCode"));
//		promotionsBean.setPromotions_startDate(request.getParameter("Promotions_startDate"));
//		promotionsBean.setPromotions_endDate(request.getParameter("Promotions_endDate"));
//		
//		
//		
////		int Promotions_id = Integer.parseInt(request.getParameter("Promotions_id"));
//		String Promotions_id = request.getParameter("Promotions_id");
//		String Promotions_name = request.getParameter("Promotions_name");
//		String Promotions_content = request.getParameter("Promotions_content");
////		byte[] Promotions_picture = request.getParameter("Promotions_picture").getBytes();
//		String Promotions_picture = request.getParameter("Promotions_picture");
////		double Promotions_discount = Double.parseDouble(request.getParameter("Promotions_discount"));
//		String Promotions_discount = request.getParameter("Promotions_discount");
//		String Promotions_discountCode = request.getParameter("Promotions_discountCode");
//		String Promotions_startDate = request.getParameter("Promotions_startDate");
//		String Promotions_endDate = request.getParameter("Promotions_endDate");
//		
//		
//		
//        
//		System.out.printf("Promotions_id:%s,Promotions_name:%s,Promotions_content:%s,Promotions_picture:%s,Promotions_discount:%s,Promotions_discountCode:%s,Promotions_startDate:%s,Promotions_endDate:%s%n",Promotions_id,Promotions_name,Promotions_content,Promotions_picture,Promotions_discount,Promotions_discountCode,Promotions_startDate,Promotions_endDate);
////		System.out.println(Empno + "," + Ename + "," + Hiredate + "," + Salary + "," + Deptno + "," + Title);
//		
//		
//		
//		
//		
//		String fun = request.getParameter("fun");
//		PromotionsDAO promotionsDAO = new PromotionsDAO();
//		
//		
//		switch (fun) {
//		case "Insert": {
//			boolean isSccuess = promotionsDAO.InsertPromotions(promotionsBean);
//			if (isSccuess) {
//				promotionsBean  = promotionsDAO.SelectOne(request.getParameter("Promotions_id"));
//				request.setAttribute("PromotionsBean", promotionsBean);
//				request.getRequestDispatcher("Promotions/jsp/InsertPromotion.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("Promotions/jsp/FailPromotions.jsp").forward(request, response);
//			}
//			break;
//		}
//		case "Delete": {
//			boolean isSccuess = promotionsDAO.DeletePromotions(request.getParameter("Promotions_id"));
//			if (isSccuess) {
//				List<PromotionsBean> promotionsBeans = promotionsDAO.SelectAll();
//				request.setAttribute("PromotionsBeans", promotionsBeans);
//				request.getRequestDispatcher("Promotions/jsp/GetAllPromotions.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("Promotions/jsp/Fail.jsp").forward(request, response);
//			}
//			break;
//		}
//		case "GetOne": {
//			promotionsBean = promotionsDAO.SelectOne(request.getParameter("Promotions_id"));
//			request.setAttribute("PromotionsBean", promotionsBean);
//			request.getRequestDispatcher("Promotions/jsp/GetPromotions.jsp").forward(request, response);
//			break;
//		}
//
//		case "GetAll": {
//			List<PromotionsBean> promotionsBeans = promotionsDAO.SelectAll();
//			request.setAttribute("PromotionsBeans", promotionsBeans);
//			request.getRequestDispatcher("Promotions/jsp/GetAllPromotions.jsp").forward(request, response);
//			break;
//		}
//		case "GetUpdate": {
//			promotionsBean = promotionsDAO.SelectOne(request.getParameter("Promotions_id"));
//			request.setAttribute("PromotionsBean", promotionsBean);
//			request.getRequestDispatcher("Promotions/jsp/DoUpdatePromotions.jsp").forward(request, response);
//			break;
//		}
//		case "DoUpdate": {
//			boolean isSccuess = promotionsDAO.Update(promotionsBean);
//			if (isSccuess) {
//				List<PromotionsBean> promotionsBeans = promotionsDAO.SelectAll();
//				request.setAttribute("PromotionsBeans", promotionsBeans);
//				request.getRequestDispatcher("Promotions/jsp/GetAllPromotions.jsp").forward(request, response);
//
//			} else {
//				request.getRequestDispatcher("Promotions/jsp/FailPromotions.jsp").forward(request, response);
//			}
//			break;
//		}
//		default:
//			request.getRequestDispatcher("Promotions/jsp/FailPromotions.jsp").forward(request, response);
//			break;
//		}
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}

package com.team6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.model.PromotionsBean;
import com.team6.model.PromotionsDAO;
import com.team6.util.HibernateUtil;

@WebServlet("/PromotionsController")
public class PromotionsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PromotionsController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String fun = request.getParameter("fun");
        PromotionsDAO promotionsDAO = new PromotionsDAO();

        switch (fun) {
            case "Insert": {
                PromotionsBean promotionsBean = new PromotionsBean();
                populatePromotionsBean(request, promotionsBean);
                boolean isSuccess = promotionsDAO.insertPromotions(promotionsBean);
                System.out.println(isSuccess);
                handleInsertResult(request, response, isSuccess, promotionsBean);
                break;
            }
            case "Delete": {
                boolean isSuccess = promotionsDAO.deletePromotions(request.getParameter("Promotions_id"));
                handleDeleteResult(request, response, isSuccess);
                break;
            }
            case "GetOne": {
                PromotionsBean promotionsBean = promotionsDAO.selectOne(request.getParameter("Promotions_id"));
                handleGetOneResult(request, response, promotionsBean);
                break;
            }
            case "GetAll": {
                List<PromotionsBean> promotionsBeans = promotionsDAO.selectAll();
                handleGetAllResult(request, response, promotionsBeans);
                break;
            }
            case "GetUpdate": {
                PromotionsBean promotionsBean = promotionsDAO.selectOne(request.getParameter("Promotions_id"));
                handleGetUpdateResult(request, response, promotionsBean);
                break;
            }
            case "DoUpdate": {
                PromotionsBean promotionsBean = new PromotionsBean();
                populatePromotionsBean(request, promotionsBean);
                boolean isSuccess = promotionsDAO.updatePromotions(promotionsBean);
                handleUpdateResult(request, response, isSuccess);
                break;
            }
            default:
                request.getRequestDispatcher("Promotions/jsp/FailPromotions.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void populatePromotionsBean(HttpServletRequest request, PromotionsBean promotionsBean) {
        promotionsBean.setPromotions_id(request.getParameter("Promotions_id"));
        promotionsBean.setPromotions_name(request.getParameter("Promotions_name"));
        promotionsBean.setPromotions_content(request.getParameter("Promotions_content"));
        promotionsBean.setPromotions_picture(request.getParameter("Promotions_picture"));
        promotionsBean.setPromotions_discount(request.getParameter("Promotions_discount"));
        promotionsBean.setPromotions_discountCode(request.getParameter("Promotions_discountCode"));
        promotionsBean.setPromotions_startDate(request.getParameter("Promotions_startDate"));
        promotionsBean.setPromotions_endDate(request.getParameter("Promotions_endDate"));
    }

    private void handleInsertResult(HttpServletRequest request, HttpServletResponse response,
                                    boolean isSuccess, PromotionsBean promotionsBean)
            throws ServletException, IOException {
        if (isSuccess) {
            request.setAttribute("PromotionsBean", promotionsBean);
            request.getRequestDispatcher("Promotions/jsp/InsertPromotion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Promotions/jsp/FailPromotions.jsp").forward(request, response);
        }
    }

    private void handleDeleteResult(HttpServletRequest request, HttpServletResponse response,
                                    boolean isSuccess)
            throws ServletException, IOException {
        if (isSuccess) {
            List<PromotionsBean> promotionsBeans = new PromotionsDAO().selectAll();
            request.setAttribute("PromotionsBeans", promotionsBeans);
            request.getRequestDispatcher("Promotions/jsp/GetAllPromotions.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Promotions/jsp/Fail.jsp").forward(request, response);
        }
    }

    private void handleGetOneResult(HttpServletRequest request, HttpServletResponse response,
                                    PromotionsBean promotionsBean)
            throws ServletException, IOException {
        request.setAttribute("PromotionsBean", promotionsBean);
        request.getRequestDispatcher("Promotions/jsp/GetPromotions.jsp").forward(request, response);
    }

    private void handleGetAllResult(HttpServletRequest request, HttpServletResponse response,
                                    List<PromotionsBean> promotionsBeans)
            throws ServletException, IOException {
        request.setAttribute("PromotionsBeans", promotionsBeans);
        request.getRequestDispatcher("Promotions/jsp/GetAllPromotions.jsp").forward(request, response);
    }

    private void handleGetUpdateResult(HttpServletRequest request, HttpServletResponse response,
                                       PromotionsBean promotionsBean)
            throws ServletException, IOException {
        request.setAttribute("PromotionsBean", promotionsBean);
        request.getRequestDispatcher("Promotions/jsp/DoUpdatePromotions.jsp").forward(request, response);
    }

    private void handleUpdateResult(HttpServletRequest request, HttpServletResponse response,
                                    boolean isSuccess)
            throws ServletException, IOException {
        if (isSuccess) {
            List<PromotionsBean> promotionsBeans = new PromotionsDAO().selectAll();
            request.setAttribute("PromotionsBeans", promotionsBeans);
            request.getRequestDispatcher("Promotions/jsp/GetAllPromotions.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Promotions/jsp/FailPromotions.jsp").forward(request, response);
        }
    }
}

