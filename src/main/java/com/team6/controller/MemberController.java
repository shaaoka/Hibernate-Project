package com.team6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.team6.model.BossAccount;
import com.team6.model.MemberBean;
import com.team6.model.MemberDao;
import com.team6.util.HibernateUtil;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session=factory.getCurrentSession();
		MemberDao dao = new MemberDao(session);
		
		String type= request.getParameter("type");
		String upDate=request.getParameter("upDate");
		String delete=request.getParameter("delete");
		String output=request.getParameter("output");
		
		if (type !=null) {
			switch (type) {
			case "Login": {
				String account=request.getParameter("account");
				String pwd=request.getParameter("pwd");
				BossAccount Login = dao.login(account, pwd);
				if (Login != null) {
					request.setAttribute("boss", "Welcome! "+Login.getmName());
					request.getRequestDispatcher("/member/jsp/Index.jsp").forward(request, response);
				}else {
					request.setAttribute("err", "帳號或密碼不正確!!");
					request.getRequestDispatcher("/member/jsp/Login.jsp").forward(request, response);
				}
				break;
			}case "insert":{
				MemberBean bean = new MemberBean();
				bean.setAccount(request.getParameter("account"));
				bean.setmName(request.getParameter("mName"));
				bean.setPassword(request.getParameter("password"));
				bean.setmEmail(request.getParameter("mEmail"));
				bean.setmPhone(request.getParameter("mPhone"));
				bean.setBirthday(request.getParameter("birthday"));
				bean.setPermissions(1);
				MemberBean bean2=dao.insert(bean);
				if (bean2==null) {
					request.setAttribute("err", "新增失敗!!");
					request.getRequestDispatcher("/member/jsp/Insert.jsp").forward(request, response);
				}
				break;
			}case "selectByName":{
				String name = request.getParameter("mName");
				List<MemberBean> beans = dao.selectByName(name);
				request.setAttribute("beans", beans);
				request.getRequestDispatcher("/member/jsp/GetAll.jsp").forward(request, response);
				break;
			}case "select":{
				String account = request.getParameter("account");
				MemberBean bean = dao.selectByOne(account);
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("/member/jsp/GetOne.jsp").forward(request, response);
				break;
			}case "upDate":{
				MemberBean bean = new MemberBean();
				bean.setAccount(request.getParameter("account"));
				bean.setmName(request.getParameter("mName"));
				bean.setPassword(request.getParameter("password"));
				bean.setmEmail(request.getParameter("mEmail"));
				bean.setmPhone(request.getParameter("mPhone"));
				bean.setBirthday(request.getParameter("birthday"));
				bean.setPermissions(Integer.parseInt(request.getParameter("permissions")));
				MemberBean bean2=dao.upDate(bean);
				if (bean2==null) {
					request.setAttribute("err", "更新失敗!!");
					request.getRequestDispatcher("/member/jsp/Update.jsp").forward(request, response);
				}
				break;
			}case "upDatePermissions":{
				String account=request.getParameter("account");
				String permissions =request.getParameter("permissions");
				dao.upDataByPermissions(account, permissions);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}
		}else if (upDate != null) {
			MemberBean bean = dao.selectByOne(upDate);
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("/member/jsp/Update.jsp").forward(request, response);
		}else if(delete !=null){
			dao.delete(delete);
		}else if(output != null){
			dao.saveToCsv();
			dao.saveToXml();
			dao.saveToJson();
		}
		List<MemberBean> beans=dao.selectAll();
		request.setAttribute("beans", beans);
		request.getRequestDispatcher("/member/jsp/GetAll.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
