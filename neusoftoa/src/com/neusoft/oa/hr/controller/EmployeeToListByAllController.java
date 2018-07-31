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
 * 显示所有员工列表页面的前分发控制器
 * Servlet implementation class EmployeeToListByAllController
 */
@WebServlet(description = "员工显示所有列表页面的前分发控制器", urlPatterns = { "/employee/tolistbyall.do" })
public class EmployeeToListByAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
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
		int pageCount = 0;//显示的页数
		int rows = 5;//每页显示的员工个数
		
		String spage = request.getParameter("page");
		
		
		IEmployeeService employeeService = ServiceFactory.createEmployeeService();
		try {
			count = employeeService.getCountByAll();
			pageCount = employeeService.getPageCountByAll(rows);
			
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
			
			//调用Service层的方法
			List<EmployeeModel> employeeList = employeeService.getListByAllWithPage(rows, page);
			//保存给View显示的数据
			request.setAttribute("employeeList", employeeList);
			request.setAttribute("page", page);
			request.setAttribute("count", count);
			request.setAttribute("pageCount", pageCount);
			//以转发方式跳转到员工列表显示页面
			RequestDispatcher dispatcher = request.getRequestDispatcher("listbyall.jsp");
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
