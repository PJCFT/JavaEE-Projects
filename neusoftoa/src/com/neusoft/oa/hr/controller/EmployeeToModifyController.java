package com.neusoft.oa.hr.controller;

import java.io.IOException;

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
 * Servlet implementation class EmployeeToModifyController
 */
@WebServlet(description = "显示员工修改页面", urlPatterns = { "/employee/tomodify.do" })
public class EmployeeToModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IEmployeeService employeeService = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		employeeService = ServiceFactory.createEmployeeService();
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
		request.setCharacterEncoding("utf-8");
		int no;
		
		String sno = request.getParameter("no");
		
		try {
			if(sno == null || sno.equals("")) {
				response.sendRedirect("tolistbyall.do");
				return;
			}
			no = Integer.parseInt(sno);
			
			EmployeeModel employeebyno = employeeService.selectByNo(no);
			
			request.setAttribute("employeebyno", employeebyno);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("modify.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("modify.jsp");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
