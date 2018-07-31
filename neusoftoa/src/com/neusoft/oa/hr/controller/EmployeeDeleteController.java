package com.neusoft.oa.hr.controller;

import java.io.IOException;
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
 * Servlet implementation class EmployeeDeleteController
 */
@WebServlet("/employee/delete.do")
public class EmployeeDeleteController extends HttpServlet {
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
		int no;
		String sno = request.getParameter("no");
		
		try {
			if(sno == null || sno.equals("")) {
				response.sendRedirect("tolistbyall.do");
			}
			no = Integer.parseInt(sno);
			//创建Model对象
			EmployeeModel employee = new EmployeeModel();
			employee.setNo(no);
			//调用Service层业务对象方法
			employeeService.delete(employee);
			//跳转到指定view对象
			response.sendRedirect("tolistbyall.do");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("../error/error.jsp");
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
