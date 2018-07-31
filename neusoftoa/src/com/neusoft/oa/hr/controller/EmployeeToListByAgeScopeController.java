package com.neusoft.oa.hr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.oa.hr.factory.ServiceFactory;
import com.neusoft.oa.hr.model.EmployeeModel;
import com.neusoft.oa.hr.service.IEmployeeService;

/**
 * Servlet implementation class EmployeeToListByAgeScopeController
 */
@WebServlet("/employee/tolistbyagescope.do")
public class EmployeeToListByAgeScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int page = 0;//当前页数
		int count = 0;//员工个数
		int pageCount = 0;//显示的总页数
		int rows = 5;//每页显示的个数
		int low = 0;
		int hight = 0;
		
		//int low = Integer.parseInt(request.getParameter("low"));
		//int hight = Integer.parseInt(request.getParameter("hight"));
		String slow = request.getParameter("low");
		String shight = request.getParameter("hight");
		
		
		IEmployeeService employeeService = ServiceFactory.createEmployeeService();
		
		String spage = request.getParameter("page");
		
		try {
			if(slow == null || slow.equals("")) {
				low = 0;
			}else {
				low = Integer.parseInt(slow);
			}
			if(shight == null || shight.equals("")) {
				hight = 150;
			}else {
				hight = Integer.parseInt(shight);
			}
			
			count = employeeService.getCountByAgeScope(low, hight);
			pageCount = employeeService.getPageCountByAgeScope(low, hight, rows);
			
			//对spage进行处理
			if(spage == null || spage.equals("")) {
				page = 1;
			}else {
				page = Integer.parseInt(spage);
				if(page>pageCount) {
					page=pageCount;
				}
				if(page<1) {
					page = 1;
				}
			}
			
			List<EmployeeModel> employeebyagescopeList = employeeService.getListByAgeScopeWithPage(low, hight, rows, page);
			
			request.setAttribute("employeebyagescopeList", employeebyagescopeList);
			request.setAttribute("page", page);
			request.setAttribute("count", count);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("low", low);
			request.setAttribute("hight", hight);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("listbyagescope.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
